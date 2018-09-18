package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.interfaces.INamed;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Cookie;

import java.util.function.Supplier;

import static com.epam.jdi.light.common.CheckTypes.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static com.epam.jdi.light.elements.base.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getUrlFromUri;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 25.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class WebPage extends DriverBase implements INamed {
    public static boolean CHECK_AFTER_OPEN = false;
    public String url;
    public String title;

    private String checkUrl;
    private CheckTypes checkUrlType = CONTAINS;
    private CheckTypes checkTitleType = NONE;

    private static ThreadLocal<String> currentPage = new ThreadLocal<>();
    public static String getCurrentPage() { return currentPage.get(); }
    public static void setCurrentPage(WebPage page) {
        currentPage.set(page.getName());
        CacheValue.reset();
    }

    public WebPage() { }
    public WebPage(String url) { this.url = url; }
    public static void openUrl(String url) {
        new WebPage(url).open();
    }

    public static String getUrl() {
        return WebDriverFactory.getDriver().getCurrentUrl();
    }

    public static String getTitle() {
        return WebDriverFactory.getDriver().getTitle();
    }

    public void updatePageData(Url urlAnnotation, Title titleAnnotation) {
        if (urlAnnotation != null) {
            url = urlAnnotation.value();
            checkUrl = urlAnnotation.template();
            checkUrlType = urlAnnotation.validate();
            if (isBlank(checkUrl)) {
                if (checkUrlType != MATCH)
                    checkUrl = url;
                else throw exception("In order to validate MATCH for page '%s', please specify 'template' in @Url",
                        getName());
            } else if (checkUrlType == null) checkUrlType = MATCH;
            if (!url.contains("://"))
                url = getUrlFromUri(url);
        } else  { if (isBlank(url)) url = DOMAIN; }
        if (titleAnnotation != null) {
            title = titleAnnotation.value();
            checkTitleType = titleAnnotation.validate();
        }
    }

    public StringCheckType url() {
        return new StringCheckType(driver()::getCurrentUrl, checkUrl, "url");
    }

    public StringCheckType title() {
        return new StringCheckType(driver()::getTitle, title, "title");
    }

    /**
     * Check that page opened
     */
    @JDIAction
    public void checkOpened() {
        if (!isOpened())
            throw exception("Page '%s' is not opened", toString());
    }
    public boolean isOpened() {
        if (!hasRunDrivers())
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
        if (result)
            setCurrentPage(this);
        return result;
    }

    /**
     * Opens url specified for page
     */
    @JDIAction("Open {url}")
    public void open() {
        CacheValue.reset();
        try {
            driver().navigate().to(url);
        } catch (Exception ex) {
            logger.debug("Second try open page: " + toString());
            driver().navigate().to(url);
        }
        setCurrentPage(this);
    }
    @JDIAction
    public void shouldBeOpened() {
        try {
            if (isOpened()) return;
            open();
            checkOpened();
            setCurrentPage(this);
        } catch (Exception ex) {
            throw exception(format("Can't open page '%s'. Reason: %s", getName(), ex.getMessage()));
        }
    }

    /**
     * Reload current page
     */
    @JDIAction("Reload current page")
    public static void refresh() {
        WebDriverFactory.getDriver().navigate().refresh();
    }
    public static void reload() { refresh(); }

    /**
     * Go back to previous page
     */
    @JDIAction("Go back to previous page")
    public static void back() {
        WebDriverFactory.getDriver().navigate().back();
    }


    /**
     * Go forward to next page
     */
    @JDIAction("Go forward to next page")
    public static void forward() {
        WebDriverFactory.getDriver().navigate().forward();
    }

    /**
     * @param cookie Specify cookie
     *               Add cookie in browser
     */
    @JDIAction
    public static void addCookie(Cookie cookie) {
        WebDriverFactory.getDriver().manage().addCookie(cookie);
    }

    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public static void clearCache() {
        WebDriverFactory.getDriver().manage().deleteAllCookies();
    }

    @JDIAction
    public static void zoom(double factor) {
        jsExecute("document.body.style.transform = 'scale(' + arguments[0] + ')';" +
                        "document.body.style.transformOrigin = '0 0';", factor);
    }
    @JDIAction
    public static String getHtml() {
        return WebDriverFactory.getDriver().getPageSource();
    }

    private static void scroll(int x, int y) {
        jsExecute("window.scrollBy("+x+","+y+")");
    }
    @JDIAction
    public static void scrollToTop() {
        jsExecute("window.scrollTo(0,0)");
    }
    @JDIAction
    public static void scrollToBottom() {
        jsExecute("window.scrollTo(0,document.body.scrollHeight)");
    }

    @JDIAction
    public static void scrollDown(int value) {
        scroll(0,value);
    }
    @JDIAction
    public static void  scrollUp(int value) {
        scroll(0,-value);
    }
    @JDIAction
    public static void  scrollRight(int value) {
        scroll(value,0);
    }
    @JDIAction
    public static void scrollLeft(int value) {
        scroll(-value,0);
    }

    private static MapArray<String, WebPage> pages = new MapArray<>();
    public static void addPage(WebPage page) {
        pages.update(page.getName(), page);
    }
    public static <T extends WebPage> T getPage(String name) {
        WebPage page = pages.get(name);
        return (T) (page == null ? pages.get(name + " Page") : page);
    }

    @Override
    public String toString() {
        return Switch(logger.getLogLevel()).get(
            Case(l -> l == STEP,
                l -> msgFormat(PRINT_PAGE_STEP, this)),
            Case(l -> l == INFO,
                l -> msgFormat(PRINT_PAGE_INFO, this)),
            Default(msgFormat(PRINT_PAGE_DEBUG, this))
        );
    }

    public class StringCheckType {
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
            logger.toLog(format("Check that page %s(%s) equals to '%s'", what, value, equals));
            return equals == null
                    || equals.equals("")
                    || value.equals(equals);
        }

        /**
         * Check that current page url/title matches to expected url/title-matcher
         */
        public boolean match() {
            String value = actual.get();
            logger.toLog(format("Check that page %s(%s) matches to '%s'", what, value, equals));
            return equals == null
                    || equals.equals("")
                    || value.matches(equals);
        }

        /**
         * Check that current page url/title contains expected url/title-matcher
         */
        public boolean contains() {
            String value = actual.get();
            logger.toLog(format("Check that page %s(%s) contains '%s'", what, value, equals));
            return equals == null
                    || equals.equals("")
                    || value.contains(equals);
        }
    }
}
