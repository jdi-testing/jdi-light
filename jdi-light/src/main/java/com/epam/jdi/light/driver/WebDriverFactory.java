package com.epam.jdi.light.driver;

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.DriverTypes.CHROME;
import static com.epam.jdi.light.driver.get.DriverTypes.getByName;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    private static WebDriverFactory driverFactory;
    private final MapArray<String, JFunc<WebDriver>> DRIVERS;
    private final boolean SINGLE_THREAD;
    private MapArray<String, WebDriver> RUN_DRIVERS;
    private final Safe<MapArray<String, WebDriver>> THREAD_RUN_DRIVERS;

    private long INIT_THREAD_ID;
    private boolean SWITCH_THREAD;
    private WebDriver INIT_DRIVER;

    private WebSettings webSettings = WebSettings.getWebSettings();


    private WebDriverFactory() {
        RUN_DRIVERS = new MapArray<>();
        THREAD_RUN_DRIVERS = new Safe<>(MapArray::new);
        DRIVERS = new MapArray<>(DEFAULT_DRIVER, () -> initDriver(getByName(getJDISettings().DRIVER.name)));
        SINGLE_THREAD = false;
        INIT_THREAD_ID = -1;
        SWITCH_THREAD = false;
    }

    public static WebDriverFactory getWebDriverFactory() {
        if (driverFactory == null) {
            driverFactory = new WebDriverFactory();
        }
        return driverFactory;
    }

    public MapArray<String, JFunc<WebDriver>> getDrivers() {
        return DRIVERS;
    }

    public long getInitThreadId() {
        return INIT_THREAD_ID;
    }

    public void setInitThreadId(long Id) {
        INIT_THREAD_ID = Id;
    }

    public boolean noRunDrivers() {
        return !getRunDrivers().any();
    }

    private MapArray<String, WebDriver> getRunDrivers() {
        webSettings.logger.debug("SINGLE_THREAD=" + SINGLE_THREAD);
        return SINGLE_THREAD
                ? RUN_DRIVERS
                : THREAD_RUN_DRIVERS.get();
    }

    private void setRunDrivers(MapArray<String, WebDriver> map) {
        if (SINGLE_THREAD) {
            RUN_DRIVERS = map;
        } else {
            THREAD_RUN_DRIVERS.set(map);
        }
    }

    public WebDriver getDriverByName(String driverName) {
        webSettings.logger.debug("getDriverByName(%s)", driverName);
        Lock lock = new ReentrantLock();
        if (!SWITCH_THREAD && INIT_DRIVER != null && INIT_THREAD_ID != currentThread().getId()) {
            webSettings.logger.debug("SWITCH_THREAD = true");
            setRunDrivers(map($(driverName, INIT_DRIVER)));
            SWITCH_THREAD = true;
            return INIT_DRIVER;
        }
        if (!DRIVERS.has(driverName)) {
            webSettings.logger.debug("Has no driver");
            useDriver(driverName);
        }
        try {
            lock.lock();
            webSettings.logger.debug("Lock");
            MapArray<String, WebDriver> rDrivers = getRunDrivers();
            if (rDrivers == null) {
                webSettings.logger.debug("rDrivers == null");
                rDrivers = new MapArray<>();
            }
            if (!rDrivers.has(driverName)) {
                webSettings.logger.debug("rDrivers has no " + driverName);
                WebDriver resultDriver = DRIVERS.get(driverName).invoke();
                rDrivers.add(driverName, resultDriver);
                setRunDrivers(rDrivers);
                webSettings.logger.debug("setRunDrivers");
            }
            webSettings.logger.debug("Get '%s' driver");
            WebDriver driver = rDrivers.get(driverName);
            webSettings.logger.debug("Successs: " + driver);
            if (driver.toString().contains("(null)")) {
                webSettings.logger.debug("driver contains (null)");
                driver = DRIVERS.get(driverName).invoke();
                rDrivers.update(driverName, driver);
                webSettings.logger.debug("update rDrivers");
            }
            if (!SWITCH_THREAD && INIT_THREAD_ID == currentThread().getId()) {
                webSettings.logger.debug("INIT_DRIVER = driver");
                INIT_DRIVER = driver;
            }
            webSettings.logger.debug("driver.manage().timeouts()");
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            return driver;
        } catch (Throwable ex) {
            throw exception(ex, "Can't get driver; Thread: " + currentThread().getId() + LINE_BREAK +
                    format("Drivers: %s; Run: %s", DRIVERS, getRunDrivers()));
        } finally {
            lock.unlock();
        }
    }

    // REGISTER DRIVER
    public String useDriver(JFunc<WebDriver> driver) {
        return useDriver("Driver" + (DRIVERS.size() + 1), driver);
    }

    public String useDriver(String driverName) {
        return useDriver(driverName, () -> getJDISettings().DRIVER.types.get(driverName).getDriver());
    }

    public String useDriver(DriverTypes driverType) {
        return useDriver(driverType.name);
    }

    private WebDriver initDriver(DriverTypes type) {
        if (!getJDISettings().DRIVER.types.has(type.name)) {
            throw exception("Unknown driver: " + type);
        }
        WebDriver driver = getJDISettings().DRIVER.types.get(type.name).getDriver();
        return getJDISettings().DRIVER.setup.execute(driver);
    }

    // GET DRIVER
    public String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        return useDriver(driverType.name, driver);
    }

    public String useDriver(String driverName, JFunc<WebDriver> driver) {
        if (!DRIVERS.has(driverName))
            DRIVERS.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        getJDISettings().DRIVER.name = driverName;
        return driverName;
    }

    public <T> T jsExecute(String script, Object... args) {
        return (T) ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public WebDriver getDriver() {
        try {
            if (isNotBlank(getJDISettings().DRIVER.name)) {
                return getDriver(getJDISettings().DRIVER.name);
            }
            useDriver(CHROME);
            return getDriver(CHROME.name);
        } catch (Exception ex) {
            throw exception(ex, "Can't get WebDriver");
        }
    }

    public WebDriver getDriver(String driverName) {
        //return DRIVER.getFunc.execute(driverName);
        return getDriverByName(driverName);
    }

    public JavascriptExecutor getJSExecutor() {
        if (getDriver() instanceof JavascriptExecutor)
            return (JavascriptExecutor) getDriver();
        else
            throw new ClassCastException("JavaScript Executor doesn't support");
    }

    public void reopenDriver() {
        reopenDriver(getJDISettings().DRIVER.name);
    }

    public void reopenDriver(String driverName) {
        MapArray<String, WebDriver> rDriver = getRunDrivers();
        if (rDriver.has(driverName)) {
            closeDriver(rDriver.get(driverName));
            rDriver.removeByKey(driverName);
            setRunDrivers(rDriver);
        }
        if (DRIVERS.has(driverName))
            getDriver();
    }

    public void switchToDriver(String driverName) {
        if (DRIVERS.has(driverName))
            getJDISettings().DRIVER.name = driverName;
        else
            throw exception("Can't switch to WebDriver '%s'. This Driver name not registered", driverName);
    }

    public void close() {
        for (Pair<String, WebDriver> pair : getRunDrivers()) {
            closeDriver(pair.value);
        }
        getRunDrivers().clear();
    }

    private void closeDriver(WebDriver driver) {
        try {
            driver.close();
            driver.quit();
        } catch (Exception ignore) { }
    }

    public void quit() {
        close();
    }
}