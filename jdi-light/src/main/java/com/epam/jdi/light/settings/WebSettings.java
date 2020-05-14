package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.VisualCheckAction;
import com.epam.jdi.light.common.VisualCheckPage;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.logger.ILogger;
import com.epam.jdi.tools.PropReader;
import com.epam.jdi.tools.PropertyReader;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.JDILogger.instance;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebSettings {
    public static ILogger logger = instance("JDI");
    public static String getDomain() {
        if (DRIVER.domain != null)
            return DRIVER.domain;
        init();
        return "No Domain Found. Use test.properties or JDISettings.DRIVER.domain";
    }
    public static void setDomain(String domain) {
        DRIVER.domain = domain;
    }
    public static VisualCheckAction VISUAL_ACTION_STRATEGY = VisualCheckAction.NONE;
    public static VisualCheckPage VISUAL_PAGE_STRATEGY = VisualCheckPage.NONE;
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        init();
        return DRIVER.domain != null && DRIVER.domain.contains("://");
    }
    public static String TEST_GROUP = "";
    // TODO multi properties example
    public static Safe<String> TEST_NAME = new Safe<>((String) null);
    public static String useDriver(JFunc<WebDriver> driver) {
        return WebDriverFactory.useDriver(driver);
    }
    public static String useDriver(String driverName) {
        return WebDriverFactory.useDriver(driverName);
    }
    public static String useDriver(DriverTypes driverType) {
        return WebDriverFactory.useDriver(driverType);
    }
    public static String printSmartLocators(IBaseElement el) {
        try {
            return "smart: " + format(ELEMENT.smartTemplate, ELEMENT.smartName.value.execute(el.getName()));
        } catch (Exception ex) {
            return format("Can't define smart locator(%s, %s)", ELEMENT.smartTemplate, ELEMENT.smartName.key);
        }
    }
    public static JFunc1<IBaseElement, WebElement> SMART_SEARCH = el -> {
        switch (ELEMENT.useSmartSearch) {
            case FALSE:
                return null;
            case ONLY_UI:
                if (el.base().locator.isNull())
                    return null;
                break;
            case UI_AND_ELEMENTS:
                if (el.base().locator.isNull() && isInterface(el.getClass(), PageObject.class))
                    return null;
                break;
        }
        String locatorName = ELEMENT.smartName.value.execute(el.getName());
        return el.base().timer().getResult(() -> {
            String locator = format(ELEMENT.smartTemplate, locatorName);
            UIElement ui = (ELEMENT.smartTemplate.equals("#%s")
                ? $(locator)
                : $(locator, el.base().parent))
                    .setup(e -> e.setName(el.getName()).noWait());
            try {
                return ui.getWebElement();
            } catch (Exception ignore) {
                throw exception("Element '%s' has no locator and Smart Search failed (%s). Please add locator to element or be sure that element can be found using Smart Search", el.getName(), printSmartLocators(el));
            }
        });
    };
    public static boolean initialized = false;
    public static synchronized void init() {
        if (initialized) return;
        try {
            getProperties(COMMON.testPropertiesPath);
            TestProperties.getTestsProperties().forEach((k,v)->
                                {String name = k;
                                JAction1<String> action1 = v.getKey();
                                JAction action = v.getValue();
                                fillAction(action1,name);
                                action.execute();});

            loadCapabilities("chrome.capabilities.path", "chrome.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.chrome.put(key.toString(), value.toString())));
            loadCapabilities("ff.capabilities.path","ff.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.firefox.put(key.toString(), value.toString())));
            loadCapabilities("ie.capabilities.path","ie.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.ie.put(key.toString(), value.toString())));
            loadCapabilities("edge.capabilities.path","edge.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.ieEdge.put(key.toString(), value.toString())));
            loadCapabilities("opera.capabilities.path","opera.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.opera.put(key.toString(), value.toString())));
            loadCapabilities("safari.capabilities.path","safari.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.safari.put(key.toString(), value.toString())));
            loadCapabilities("common.capabilities.path","common.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.common.put(key.toString(), value.toString())));

            INIT_THREAD_ID = Thread.currentThread().getId();
            initialized = true;
        } catch (Throwable ex) {
            throw exception(ex, "Failed to init test.properties");
        }
    }

    private static boolean getBoolean(String param) {
        String lowerParams = param.toLowerCase();
        return !lowerParams.equals("off") && !lowerParams.equals("false");
    }

    public static void loadCapabilities(String property, String defaultPath, JAction1<Properties> setCapabilities) {
        String path = "";
        try {
            path = System.getProperty(property, getProperty(property));
        } catch (Exception ignore) { }
        if (isEmpty(path))
            path = defaultPath;
        Properties properties = new PropReader(path).getProperties();
        if (properties.isEmpty())
            return;
        try {
            setCapabilities.execute(properties);
        } catch (Exception ignore) { }
    }

    private static Properties getProperties(String path) {
        File propertyFile = new File(path);
        Properties properties;
        if (propertyFile.exists()) {
            properties = getCiProperties(path, propertyFile);
        } else {
            Properties pTest = PropertyReader.getProperties(mergePath(path));
            Properties pTarget = PropertyReader.getProperties(mergePath("/../../target/classes/" + path));
            if (pTarget.size() > 0)
                return pTarget;
            String propertiesPath = pTest.size() > 0
                    ? path
                    : mergePath("/../../target/classes/" + path);
            properties = PropertyReader.getProperties(propertiesPath);
        }
        return properties;
    }

    private static Properties getCiProperties(String path, File propertyFile){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFile));
            System.out.println("Property file found: " + propertyFile.getAbsolutePath());
        } catch (IOException ex) {
            throw exception("Couldn't load properties for CI Server" + path);
        }
        return properties;
    }
}
