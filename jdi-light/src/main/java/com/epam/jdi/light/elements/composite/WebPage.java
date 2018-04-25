package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.interfaces.IComposite;
import com.epam.jdi.tools.CacheValue;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

import static com.epam.jdi.light.common.CheckTypes.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.Switch;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static com.epam.jdi.tools.Switch.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 25.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class WebPage implements IComposite {
    public static boolean CHECK_AFTER_OPEN = false;
    public String url;
    public String title;

    private String checkUrl;
    private String checkTitle;
    private CheckTypes checkUrlType = EQUALS;
    private CheckTypes checkTitleType = EQUALS;

    private static ThreadLocal<String> currentPage = new ThreadLocal<>();
    public static String getCurrentPage() { return currentPage.get(); }
    public static void setCurrentPage(WebPage page) {
        currentPage.set(page.getName());
        CacheValue.reset();
    }
    public String driverName;
    public WebDriver getDriver() { return WebDriverFactory.getDriver(driverName); }
    private String name;
    private String varName;

    public String getName() {
        return name;
    }
    public void setName(String varName, String className) {
        this.name = splitCamelCase(varName);
        this.varName = className + "." + varName;
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

    public void updatePageData(String url, String title) {
        this.url = url;
        this.checkUrl = url;

        this.title = title;
        this.checkTitle = title;
    }
    public void setCheckUrl(String url, CheckTypes type) {
        this.checkUrl = url;
        this.checkUrlType = type;
    }
    public void setCheckTitle(String title, CheckTypes type) {
        this.checkTitle = title;
        this.checkTitleType = type;
    }

    public StringCheckType url() {
        return new StringCheckType(getDriver()::getCurrentUrl, checkUrl, "url");
    }

    public StringCheckType title() {
        return new StringCheckType(getDriver()::getTitle, checkTitle, "title");
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
                Value(EQUALS, url().check()),
                Value(MATCH, url().match()),
                Value(CONTAINS, url().contains()),
                Else(false)
        );
        if (!result) return false;
        result = Switch(checkTitleType).get(
                Value(EQUALS, title().check()),
                Value(MATCH, title().match()),
                Value(CONTAINS, title().contains()),
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
            getDriver().navigate().to(url);
        } catch (Exception ex) {
            logger.debug("Second try open page: " + toString());
            getDriver().navigate().to(url);
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
    public void refresh() {
        getDriver().navigate().refresh();
    }
    public void reload() { refresh(); }

    /**
     * Go back to previous page
     */
    @JDIAction("Go back to previous page")
    public void back() {
        getDriver().navigate().back();
    }


    /**
     * Go forward to next page
     */
    @JDIAction("Go forward to next page")
    public void forward() {
        getDriver().navigate().forward();
    }

    /**
     * @param cookie Specify cookie
     *               Add cookie in browser
     */
    @JDIAction
    public void addCookie(Cookie cookie) {
        getDriver().manage().addCookie(cookie);
    }

    /**
     * Clear browsers cache
     */
    @JDIAction("Delete all cookies")
    public void clearCache() {
        getDriver().manage().deleteAllCookies();
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
            logger.toLog(format("Check that page %s equals to '%s'", what, equals));
            return equals == null
                    || equals.equals("")
                    || actual.get().equals(equals);
        }

        /**
         * Check that current page url/title matches to expected url/title-matcher
         */
        public boolean match() {
            logger.toLog(format("Check that page %s matches to '%s'", what, equals));
            return equals == null
                    || equals.equals("")
                    || actual.get().matches(equals);
        }

        /**
         * Check that current page url/title contains expected url/title-matcher
         */
        public boolean contains() {
            logger.toLog(format("Check that page %s contains to '%s'", what, equals));
            return equals == null
                    || equals.equals("")
                    || actual.get().contains(equals);
        }
    }
}
