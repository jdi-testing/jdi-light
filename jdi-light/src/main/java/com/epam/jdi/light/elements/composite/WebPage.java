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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.MessageFormat;
import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;
import static com.epam.jdi.light.common.CheckTypes.EQUALS;
import static com.epam.jdi.light.common.CheckTypes.MATCH;
import static com.epam.jdi.light.common.CheckTypes.NONE;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_PAGE;
import static com.epam.jdi.light.driver.ScreenshotMaker.getPath;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static com.epam.jdi.light.driver.WebDriverFactory.noRunDrivers;
import static com.epam.jdi.light.elements.base.OutputTemplates.PRINT_PAGE_DEBUG;
import static com.epam.jdi.light.elements.base.OutputTemplates.PRINT_PAGE_INFO;
import static com.epam.jdi.light.elements.base.OutputTemplates.PRINT_PAGE_STEP;
import static com.epam.jdi.light.elements.common.WindowsManager.checkNewWindowIsOpened;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getUrlFromUri;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.JDISettings.LOGS;
import static com.epam.jdi.light.settings.JDISettings.PAGE;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.light.settings.WebSettings.VISUAL_PAGE_STRATEGY;
import static com.epam.jdi.light.settings.WebSettings.getDomain;
import static com.epam.jdi.light.settings.WebSettings.init;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.Case;
import static com.epam.jdi.tools.switcher.SwitchActions.Default;
import static com.epam.jdi.tools.switcher.SwitchActions.Else;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static com.epam.jdi.tools.switcher.SwitchActions.Value;
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
  //  public CheckTypes checkUrlType = CONTAINS;
  //  public CheckTypes checkTitleType = NONE;

    public <T> Form<T> asForm() {
        return new Form<>().setPageObject(this).setup(Form.class, e -> e.setName(getName() + " Form").setParent(this));
    }

    private static Safe<String> currentPageSingleton = null;


    public static String getCurrentPage() {
        return currentPageSingleton.get();
    }

    public static void setCurrentPage(WebPage page) {
        if (currentPageSingleton == null) {
            currentPageSingleton = new Safe<>("Undefined Page");
        }
        currentPageSingleton.set(page.getName());
    }

    public WebPage() {
        initElements(this);
    }

    public WebPage(String url) {
        setUrl(url, url, CONTAINS);
    }

    public WebPage(String url, String title) {
        this(url);
        this.title = title;
    }

    public static void openUrl(String url, String pageName) {
        WebPage page = new WebPage(url);
        page.setName(isNotBlank(pageName) ? pageName : "");
        page.open();
    }

    public static void openUrl(String url) {
        init();
        new WebPage(url).open();
    }

    public static void openSite() {
        init();
        new WebPage(getDomain()).open();
    }

    public static void openSite(Class<?> site) {
        initSite(site);
        openSite();
    }

    /**
     * Get Web page URL
     *
     * @return String
     */
    @JDIAction(level = DEBUG)
    public static String getUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Get Web page title
     *
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
      //  checkUrlType = validate;
        if (isBlank(template)) {
            if (validate != MATCH)
                checkUrl = uri;
            else throw exception("In order to validate MATCH for page '%s', please specify 'template' in @Url",
                    getName());
        } else if (validate == null) ;//checkUrlType = MATCH;
        if (!uri.contains("://"))
            url = getUrlFromUri(uri);
        else {
            if (isBlank(uri)) url = getDomain();
        }
    }

    public void updatePageData(Url urlAnnotation, Title titleAnnotation) {
        if (urlAnnotation != null)
            setUrl(urlAnnotation.value(), urlAnnotation.template(), urlAnnotation.validate());
        else setUrl(getDomain());
        if (titleAnnotation != null) {
            title = titleAnnotation.value();
           // checkTitleType = titleAnnotation.validate();
        }
    }

    public StringCheckType url() {
        return new StringCheckType(driver()::getCurrentUrl, checkUrl, "url");
    }

    public StringCheckType title() {
        return new StringCheckType(driver()::getTitle, title, "title");
    }

    /**
     * Opens url specified for page
     *
     * @param url
     */
    @JDIAction("Open '{name}'(url={0})")
    private void open(String url) {
        init();
        CacheValue.reset();
        driver().navigate().to(url);
        getWindows();
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
            throw exception("Page '%s' is not opened: Driver is not run", toString());
        String result =""; //Switch(checkUrlType).get(
//                Value(NONE, ""),
//                Value(EQUALS, t -> !url().check() ? "Url '%s' doesn't equal to '%s'" : ""),
//                Value(MATCH, t -> !url().match() ? "Url '%s' doesn't match to '%s'" : ""),
//                Value(CONTAINS, t -> !url().contains() ? "Url '%s' doesn't contains '%s'" : "")
//        );
        if (isNotBlank(result))
            throw exception("Page '%s' is not opened: %s", getName(), format(result, driver().getCurrentUrl(), checkUrl));
//        result = Switch(checkTitleType).get(
//                Value(NONE, ""),
//                Value(EQUALS, t -> !title().check() ? "Title '%s' doesn't equal to '%s'" : ""),
//                Value(MATCH, t -> !title().match() ? "Title '%s' doesn't match to '%s'" : ""),
//                Value(CONTAINS, t -> !title().contains() ? "Title '%s' doesn't contains '%s'" : "")
//        );
        if (isNotBlank(result))
            throw exception("Page '%s' is not opened: %s", getName(), format(result, driver().getTitle(), title));
        setCurrentPage(this);
        if (VISUAL_PAGE_STRATEGY == CHECK_PAGE)
            visualWindowCheck();
    }

    /**
     * Check that page opened
     */
    @JDIAction("Check that '{name}' is opened (url {checkUrlType} '{checkUrl}'; title {checkTitleType} '{title}')")
    public static void visualWindowCheck() {
    }

    /**
     * Check the page is opened
     *
     * @return boolean
     */
    @JDIAction(level = DEBUG)
    public boolean isOpened() {
        if (noRunDrivers())
            return false;
        boolean result = true;//Switch(checkUrlType).get(
//                Value(NONE, t -> true),
//                Value(EQUALS, t -> url().check()),
//                Value(MATCH, t -> url().match()),
//                Value(CONTAINS, t -> url().contains()),
//                Else(false)
//        );
        if (!result) return false;
        result =true;// Switch(checkTitleType).get(
//                Value(NONE, t -> true),
//                Value(EQUALS, t -> title().check()),
//                Value(MATCH, t -> title().match()),
//                Value(CONTAINS, t -> title().contains()),
//                Else(false)
//        );
        if (result)
            setCurrentPage(this);
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
     *
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
    @JDIAction("Reload current page")
    public static void refresh() {
        getDriver().navigate().refresh();
    }

    public static void reload() {
        refresh();
    }

    /**
     * Go back to previous page
     */
    @JDIAction("Go back to previous page")
    public static void back() {
        getDriver().navigate().back();
    }

    /**
     * Go forward to next page
     */
    @JDIAction("Go forward to next page")
    public static void forward() {
        getDriver().navigate().forward();
    }

    /**
     * Scale the page by the specific factor
     *
     * @param factor
     */
    @JDIAction(level = DEBUG)
    public static void zoom(double factor) {
        jsExecute("document.body.style.transform = 'scale(' + arguments[0] + ')';" +
                "document.body.style.transformOrigin = '0 0';", factor);
    }

    /**
     * Get page html
     *
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
     *
     * @param x
     * @param y
     */
    @JDIAction(level = DEBUG)
    private static void scroll(int x, int y) {
        jsExecute("window.scrollBy(" + x + "," + y + ")");
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
     *
     * @param value
     */
    @JDIAction("Scroll screen down on '{0}'")
    public static void scrollDown(int value) {
        scroll(0, value);
    }

    /**
     * Scroll screen up on specific values
     *
     * @param value
     */
    @JDIAction("Scroll screen up on '{0}'")
    public static void scrollUp(int value) {
        scroll(0, -value);
    }

    /**
     * Scroll screen to the right on specific values
     *
     * @param value
     */
    @JDIAction("Scroll screen to the right on '{0}'")
    public static void scrollRight(int value) {
        scroll(value, 0);
    }

    /**
     * Scroll screen to the left on specific values
     *
     * @param value
     */
    @JDIAction("Scroll screen to the left on '{0}'")
    public static void scrollLeft(int value) {
        scroll(-value, 0);
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

    @JDIAction(level = DEBUG)
    public static String windowScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            //show();
            String path = mergePath(getPath(), getCurrentPage() + ".png");
            File imageFile = new File(path);
            copyFile(screenshot, imageFile);
            return path;
        } catch (Exception ex) {
            throw exception(ex, "Can't take screenshot");
        }
    }

    @JDIAction(level = DEBUG)
    public static String windowScreenshot(int x, int y, int w, int h, String name) {
        File screenshot;
        File imageFile;
        String path;
        try {
            screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            //show();
            path = mergePath(getPath(), name);
            imageFile = new File(path);
        } catch (Exception ex) {
            throw exception(ex, "Can't take windowScreenshot");
        }
        try {
            BufferedImage fullImg = ImageIO.read(screenshot);
            BufferedImage crop = fullImg.getSubimage(x, y, w, h);
            ImageIO.write(crop, "png", screenshot);
            copyFile(screenshot, imageFile);
        } catch (Exception ex) {
            throw exception(ex, "Can't crop windowScreenshot");
        }
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
//        if (VISUAL_PAGE_STRATEGY == CHECK_NEW_PAGE)
//            visualWindowCheck();
//        logger.toLog("Page '" + page.getName() + "' opened");
//        TIMEOUTS.element.set(TIMEOUTS.page.get());
    }
}
