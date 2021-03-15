package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.PageChecks;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.MessageFormat;
import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.common.CheckTypes.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_PAGE;
import static com.epam.jdi.light.driver.ScreenshotMaker.getPath;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.elements.common.WindowsManager.checkNewWindowIsOpened;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getUrlFromUri;
import static com.epam.jdi.light.logger.AllureLogger.attachScreenshot;
import static com.epam.jdi.light.logger.AllureLogger.logDataToAllure;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.logger.Strategy.NEW_PAGE;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 25.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebPage extends DriverBase implements PageObject {

    public String url = "";
    public String title = "";

    public String checkUrl;
    public CheckTypes checkUrlType = CONTAINS;
    public CheckTypes checkTitleType = NONE;

    public <T> Form<T> asForm() {
        return new Form<>().setPageObject(this)
            .setup(Form.class, e -> e.setName(getName() + " Form").setParent(this));
    }

    private static Safe<String> currentPage = new Safe<>("Undefined Page");

    public static String getCurrentPage() {
        return currentPage.get();
    }

    public static void setCurrentPage(WebPage page) {
        String oldPage = currentPage.get();
        String newPage = page.getName();
        if (!oldPage.equals(newPage)) {
            PAGE.beforeNewPage.execute(page);
            currentPage.set(newPage);
        }
    }

    public WebPage() {
        initElements(this);
    }
    public WebPage(String url) {
        setUrl(url, url, CONTAINS);
    }
    public WebPage(String url, String title) { this(url); this.title = title; }
    public static void openUrl(String url, String pageName) {
        WebPage page = new WebPage(url);
        page.setName(isNotBlank(pageName) ? pageName : "");
        page.open();
    }
    public static void openUrl(String url) {
        init();
        if (!hasDomain() && url.contains("://"))
            DRIVER.domain = url;
        new WebPage(url).open();
    }
    public static void checkUrl(String url) {
        init();
        new WebPage(url).checkOpened();
    }
    @JDIAction
    public static boolean verifyUrl(String url) {
        init();
        return getUrl().contains(url);
    }
    @JDIAction
    public static boolean verifyTitle(String title) {
        init();
        return getTitle().contains(title);
    }
    public static void checkTitle(String title) {
        init();
        new WebPage("", title).checkOpened();
    }
    public static void checkPage(String url, String title) {
        init();
        new WebPage(url, title).checkOpened();
    }
    public static void openSite() {
        init();
        String domain = getDomain();
        if (isBlank(domain)) {
            throw exception("No Domain Found. Add browser=MY_SITE_DOMAIN in test.properties or JDISettings.DRIVER.domain");
        }
        WebPage site = new WebPage();
        if(isNotBlank(DRIVER.siteName)) {
            site.setName(DRIVER.siteName);
        }
        site.open(domain);
    }
    public static void openSite(Class<?> site) {
        initSite(site);
        String domain = getDomain();
        if (isBlank(domain)) {
            throw exception("No Domain Found. Use test.properties or JDISettings.DRIVER.domain");
        }
        WebPage page = new WebPage(domain);
        page.setName(site.getSimpleName());
        page.open();
    }
    /**
     * Get Web page URL
     * @return String
     */
    @JDIAction(level = DEBUG)
    public static String getUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Get Web page title
     * @return String
     */
    @JDIAction(level = DEBUG)
    public static String getTitle() {
        return getDriver().getTitle();
    }

    void setUrl(String uri) {
        setUrl(uri, "", CONTAINS);
    }
    void setUrl(String uri, String template, CheckTypes validate) {
        url = uri;
        checkUrl = template;
        checkUrlType = validate;
        if (isBlank(template)) {
            if (validate != MATCH)
                checkUrl = uri;
            else throw exception("In order to validate MATCH for page '%s', please specify 'template' in @Url",
                    getName());
        } else if (validate == null) checkUrlType = MATCH;
        if (!uri.contains("://"))
            url = getUrlFromUri(uri);
        else  { if (isBlank(uri)) url = getDomain(); }
    }
    public void updatePageData(Url urlAnnotation, Title titleAnnotation) {
        if (urlAnnotation != null)
            setUrl(urlAnnotation.value(), urlAnnotation.template(), urlAnnotation.validate());
        else setUrl(getDomain());
        if (titleAnnotation != null) {
            title = titleAnnotation.value();
            checkTitleType = titleAnnotation.validate();
        }
    }

    public StringCheckType url() {
        return new StringCheckType(WebPage::getUrl, checkUrl, "url");
    }

    public StringCheckType title() {
        return new StringCheckType(WebPage::getTitle, title, "title");
    }

    /**
     * Opens url specified for page
     * @param url
     */
    @JDIAction(value = "Open '{name}'(url={0})", timeout = 0)
    private void open(String url) {
        if (isBlank(url)) {
            throw exception("Failed to open page with empty url");
        }
        init();
        CacheValue.reset();
        driver().navigate().to(url);
        getWindows();
        isTop.set(true);
        setCurrentPage(this);
    }
    public void open(Object... params) {
        open(getUrlWithParams(params));
    }
    private String getUrlWithParams(Object... params) {
        if (params == null || params.length == 0)
            return url;
        if (url.contains("%s")) {
            return String.format(url, params);
        }
        return url.contains("{0}")
            ? MessageFormat.format(url, params)
            : url + "?" + print(map(params, Object::toString), "&");
    }
    @JDIAction("Check that '{name}' is opened (url {checkUrlType} '{checkUrl}'; title {checkTitleType} '{title}') in new window")
    public void checkOpenedInNewWindow() {
        checkNewWindowIsOpened();
        checkOpened();
    }
    /**
     * Check that page opened
     */
    @JDIAction("Check that '{name}' is opened (url {checkUrlType} '{checkUrl}'; title {checkTitleType} '{title}')")
    public void checkOpened() {
        if (noRunDrivers())
            throw exception("Page '%s' is not opened: Driver is not run: ", toString());
        String result = Switch(checkUrlType).get(
            Value(NONE, ""),
            Value(EQUALS, t -> !url().check() ? "Url '%s' doesn't equal to '%s'" : ""),
            Value(MATCH, t -> !url().match() ? "Url '%s' doesn't match to '%s'" : ""),
            Value(CONTAINS, t -> !url().contains() ? "Url '%s' doesn't contains '%s'" : "")
        );
        if (isNotBlank(result))
            throw exception("Page '%s' is not opened: %s", getName(), format(result, getUrl(), checkUrl));
        result = Switch(checkTitleType).get(
            Value(NONE, ""),
            Value(EQUALS, t -> !title().check() ? "Title '%s' doesn't equal to '%s'" : ""),
            Value(MATCH, t -> !title().match() ? "Title '%s' doesn't match to '%s'" : ""),
            Value(CONTAINS, t -> !title().contains() ? "Title '%s' doesn't contains '%s'" : "")
        );
        if (isNotBlank(result))
            throw exception("Page '%s' is not opened: %s", getName(), format(result, driver().getTitle(), title));
        if (VISUAL_PAGE_STRATEGY == CHECK_PAGE)
            visualWindowCheck();
        isTop.set(true);
        setCurrentPage(this);
    }
    public void checkIsNotChanged() {
        if (noRunDrivers())
            throw exception("Driver is not run: ", toString());
        boolean result = new Timer(TIMEOUTS.page.get() * 1000L).getResult(() -> !isOpened());
        if (!result) {
            throw exception("New page opened: %s", getUrl());
        }
    }
    public boolean isOnPage(String url) {
        switch (checkUrlType) {
            case NONE:
            case EQUALS:
                return url.equals(this.checkUrl);
            case MATCH:
                return url.matches(this.checkUrl);
            case CONTAINS:
                return url.contains(this.checkUrl);
            default: return false;
        }
    }
    /**
     * Check that page opened
     */
    @JDIAction("Check that '{name}' is opened (url {checkUrlType} '{checkUrl}'; title {checkTitleType} '{title}')")
    public static void visualWindowCheck() { }

    /**
     * Check the page is opened
     * @return boolean
     */
    @JDIAction(level = DEBUG)
    public boolean isOpened() {
        if (noRunDrivers())
            return false;
        boolean result = Switch(checkUrlType).get(
            Value(NONE, t -> true),
            Value(EQUALS, t -> url().check()),
            Value(MATCH, t -> url().match()),
            Value(CONTAINS, t -> url().contains()),
            Else(false)
        );
        if (!result) return false;
        result = Switch(checkTitleType).get(
            Value(NONE, t -> true),
            Value(EQUALS, t -> title().check()),
            Value(MATCH, t -> title().match()),
            Value(CONTAINS, t -> title().contains()),
            Else(false)
        );
        if (result) {
            isTop.set(true);
            setCurrentPage(this);
        }
        return result;
    }

    public void shouldBeOpened() {
        openedPage(url);
    }
    public void shouldBeOpened(Object... params) {
        openedPage(getUrlWithParams(params));
    }

    /**
     * Check the page is opened
     * @param url
     */
    @JDIAction("'{name}'(url={0}) should be opened")
    private void openedPage(String url) {
        if (isOpened()) return;
        open(url);
        checkOpened();
    }
    /**
     * Reload current page
     */
    @JDIAction(value = "Reload current page", isAssert = true)
    public static void refresh() {
        getDriver().navigate().refresh();
        logger.info("Page url: " + getUrl());
    }
    public static void reload() { refresh(); }

    /**
     * Go back to previous page
     */
    @JDIAction("Go back to previous page")
    public static void back() {
        getDriver().navigate().back();
        logger.info("Page url: " + getUrl());
    }

    /**
     * Go forward to next page
     */
    @JDIAction("Go forward to next page")
    public static void forward() {
        getDriver().navigate().forward();
        logger.info("Page url: " + getUrl());
    }

    /**
     * Scale the page by the specific factor
     * @param factor
     */
    @JDIAction(level = DEBUG)
    public static void zoom(double factor) {
        jsExecute("document.body.style.transform = 'scale(' + arguments[0] + ')';" +
                        "document.body.style.transformOrigin = '0 0';", factor);
    }

    /**
     * Get page html
     * @return String
     */
    @JDIAction
    public static String getHtml() {
        return getDriver().getPageSource();
    }
    public static List<LogEntry> getHttpRequests() {
        return getDriver().manage().logs().get("performance").getAll();
    }

    /**
     * Scroll screen on specific values
     * @param x
     * @param y
     */
    @JDIAction(level = DEBUG)
    private static void scroll(int x, int y) {
        jsExecute("window.scrollBy("+x+","+y+")");
    }
    public static boolean isBottomOfThePage() {
        return jsExecute("return ((window.innerHeight + window.scrollY) >= document.body.scrollHeight);");
    }
    public static boolean isTopOfThePage() {
        return jsExecute("return window.scrollX == window.scrollY;");
    }

    /**
     * Scroll screen to top
     */
    @JDIAction
    public static void scrollToTop() {
        jsExecute("window.scrollTo(0,0)");
    }

    /**
     * Scroll screen to bottom
     */
    @JDIAction
    public static void scrollToBottom() {
        jsExecute("window.scrollTo(0,document.body.scrollHeight)");
    }
    /**
     * Scroll screen down on specific values
     * @param value
     */
    @JDIAction("Scroll screen down on '{0}'")
    public static void scrollDown(int value) {
        scroll(0,value);
    }

    /**
     * Scroll screen up on specific values
     * @param value
     */
    @JDIAction("Scroll screen up on '{0}'")
    public static void  scrollUp(int value) {
        scroll(0,-value);
    }

    /**
     * Scroll screen to the right on specific values
     * @param value
     */
    @JDIAction("Scroll screen to the right on '{0}'")
    public static void  scrollRight(int value) {
        scroll(value,0);
    }

    /**
     * Scroll screen to the left on specific values
     * @param value
     */
    @JDIAction("Scroll screen to the left on '{0}'")
    public static void scrollLeft(int value) {
        scroll(-value,0);
    }

    @JDIAction(level = DEBUG)
    public static double zoomLevel() {
        return getDouble(jsExecute("return window.devicePixelRatio;"));
    }
    @JDIAction(level = DEBUG)
    public static long xOffset() {
        return jsExecute("return window.pageXOffset;");
    }
    @JDIAction(level = DEBUG)
    public static long yOffset() {
        return jsExecute("return window.pageYOffset;");
    }
    public void windowScreenshotToAllure() {
        try {
            attachScreenshot(getName(), windowScreenshot());
        } catch (Exception ignore) { }
    }
    @JDIAction(level = DEBUG)
    public static String windowScreenshot(String path) {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File imageFile = new File(path);
            copyFile(screenshot, imageFile);
            return path;
        } catch (Exception ex) { throw exception(ex, "Can't take screenshot"); }
    }
    @JDIAction(level = DEBUG)
    public static String windowScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String path = mergePath(getPath(), getCurrentPage()+".png");
            File imageFile = new File(path);
            copyFile(screenshot, imageFile);
            return path;
        } catch (Exception ex) { throw exception(ex, "Can't take screenshot"); }
    }
    @JDIAction(level = DEBUG)
    public static String windowScreenshot(int x, int y, int w, int h, String name) {
        File screenshot;
        File imageFile;
        String path;
        try {
            screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            path = mergePath(getPath(), name);
            imageFile = new File(path);
        } catch (Exception ex) { throw exception(ex, "Can't take windowScreenshot"); }
        try {
            BufferedImage fullImg = ImageIO.read(screenshot);
            BufferedImage crop = fullImg.getSubimage(x, y, w, h);
            ImageIO.write(crop, "png", screenshot);
            copyFile(screenshot, imageFile);
        } catch (Exception ex) { throw exception(ex, "Can't crop windowScreenshot"); }
        return path;
    }

    @Override
    public String toString() {
        return Switch(LOGS.logLevel).get(
            Case(l -> l == STEP,
                l -> msgFormat(PRINT_PAGE_STEP, this)),
            Case(l -> l == INFO,
                l -> msgFormat(PRINT_PAGE_INFO, this)),
            Default(msgFormat(PRINT_PAGE_DEBUG, this))
        );
    }
    public String details() {
        return format("url=%s, title='%s', checkUrl='%s'%s, checkTitle='%s'",
            url, title, checkUrlType,
            isNotBlank(checkUrl) ? ("[checkUrl=" + checkUrl+ "]") : "", checkTitleType);
    }

    public static class StringCheckType {
        private Supplier<String> actual;
        private String equals;
        private String what;

        StringCheckType(Supplier<String> actual, String equals, String what) {
            this.actual = actual;
            this.equals = equals;
            this.what = what;
        }

        /**
         * Check that current page url/title equals to expected url/title
         */
        public boolean check() {
            String value = actual.get();
            return equals == null
                    || equals.equals("")
                    || value.equals(equals);
        }

        /**
         * Check that current page url/title matches to expected url/title-matcher
         */
        public boolean match() {
            String value = actual.get();
            return equals == null
                    || equals.equals("")
                    || value.matches(equals);
        }

        /**
         * Check that current page url/title contains expected url/title-matcher
         */
        public boolean contains() {
            String value = actual.get();
            return equals == null || equals.equals("") || value.contains(equals);
        }
    }

    public static void beforeNewPage(WebPage page) {
        if (VISUAL_PAGE_STRATEGY == CHECK_NEW_PAGE) {
            visualWindowCheck();
        }
        logDataToAllure(NEW_PAGE, page.getName(), false);
        logger.toLog("Page '" + page.getName() + "' opened");
        TIMEOUTS.element.set(TIMEOUTS.page.get());
    }

    public static void beforeEachPage(WebPage page) {
        if (PAGE.checkPageOpen != PageChecks.NONE) {
            page.checkOpened();
        }
    }
}
