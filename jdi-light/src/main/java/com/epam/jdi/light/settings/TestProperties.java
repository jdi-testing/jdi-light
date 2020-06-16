package com.epam.jdi.light.settings;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.logger.Strategy;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.PageLoadStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.common.SetTextTypes.SET_TEXT;
import static com.epam.jdi.light.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.light.common.UseSmartSearch.*;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.RemoteDriver.*;
import static com.epam.jdi.light.driver.sauce.SauceSettings.sauceCapabilities;
import static com.epam.jdi.light.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.light.logger.Strategy.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.Strategies.JDI;
import static com.epam.jdi.light.settings.Strategies.SELENIUM;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getAllEnumValues;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.openqa.selenium.PageLoadStrategy.*;

public class TestProperties {

    private static Map<String, Pair<JAction1<String>, JAction>> testsProperties = null;
    private static final JAction _doNothing = () -> {
    };
    public static boolean STRICT_SEARCH = true;

    private TestProperties() {
    }

    public static Map<String, Pair<JAction1<String>, JAction>> getTestsProperties() {
        if (testsProperties == null) {
            testsProperties = createTestProperties();
        }
        return testsProperties;
    }

    private static Map<String, Pair<JAction1<String>, JAction>> createTestProperties() {
        Map<String, Pair<JAction1<String>, JAction>> properties = new HashMap<>();
        properties.put("strategy", combo(p -> COMMON.strategy = getStrategy(p),
            COMMON.strategy.action));
        properties
            .put("timeout.wait.element", single(p -> TIMEOUTS.element = new Timeout(parseInt(p))));
        properties.put("timeout.wait.page", single(p -> TIMEOUTS.page = new Timeout(parseInt(p))));
        properties.put("domain", single(WebSettings::setDomain));
        if (DRIVER.name.equals(DEFAULT_DRIVER)) {
            properties.put("driver", single(p -> DRIVER.name = p));
        }
        properties.put("driver.version", single(p -> DRIVER.version = p));
        properties.put("drivers.folder", single(p -> DRIVER.path = p));
        properties.put("screens.folder", combo(p -> SCREEN.path = p, () -> addStrategy(FAIL, LOGS.screenStrategy)));
        properties.put("list.start.index", single(p -> ELEMENT.startIndex = parseInt(p)));
        properties
            .put("log.info.details", single(p -> LOGS.logInfoDetails = getInfoDetailsLevel(p)));
        properties
            .put("screenshot.strategy", single(p -> LOGS.screenStrategy = getLoggerStrategy(p)));
        properties
            .put("html.code.strategy", single(p -> LOGS.htmlCodeStrategy = getLoggerStrategy(p)));
        properties
            .put("requests.strategy", single(p -> LOGS.requestsStrategy = getLoggerStrategy(p)));
        properties.put("browser.kill", single(p -> COMMON.killBrowser = p));
        properties.put("element.search.strategy", single(TestProperties::setSearchStrategy));
        properties.put("browser.size", single(DRIVER.screenSize::read));
        properties
            .put("page.load.strategy", single(p -> DRIVER.pageLoadStrategy = getPageLoadStrategy(p)));
        properties.put("page.check.after.open", single(p -> PAGE.checkPageOpen = parse(p)));
        properties.put("assert.type", single(SoftAssert::setAssertType));
        properties.put("click.type", single(p -> ELEMENT.clickType = getClickType(p)));
        properties.put("text.type", single(p -> ELEMENT.getTextType = getTextType(p)));
        properties.put("set.text.type", single(p -> ELEMENT.setTextType = getSetTextType(p)));
///     RemoteWebDriver properties
        properties.put("remote.type", single(p -> DRIVER.remoteUrl = getRemoteUrl(p)));
        properties.put("driver.remote.url", single(p -> DRIVER.remoteUrl = p));
        properties.put("log.level",
            combo(p -> LOGS.logLevel = parseLogLevel(p), () -> logger.setLogLevel(LOGS.logLevel)));
        properties.put("allure.steps", single(p -> LOGS.writeToAllure = parseBoolean(p)));
        properties.put("smart.locators", single(p -> ELEMENT.smartTemplate = p.split(";")[0]));
        properties
            .put("smart.locators.toName", single(p -> ELEMENT.smartName = getSmartSearchFunc(p)));
        properties.put("smart.search", single(p -> ELEMENT.useSmartSearch = getSmartSearchUse(p)));
        properties.put("headless", single(p -> DRIVER.capabilities.common.put("headless", p)));
        return properties;
    }

    public static Pair<JAction1<String>, JAction> combo(JAction1<String> setPropertyAction,
                                                        JAction additionalPropertyAction) {
        return new Pair<>(setPropertyAction, additionalPropertyAction);
    }

    public static Pair<JAction1<String>, JAction> single(JAction1<String> setPropertyAction) {
        return combo(setPropertyAction, _doNothing);
    }

    private static Strategies getStrategy(String prop) {
        String strategy = prop.trim().toLowerCase();
        switch (strategy) {
            case "jdi":
                return JDI;
            case "selenium":
                return SELENIUM;
            default:
                return JDI;
        }
    }

    private static List<Strategy> getLoggerStrategy(String strategy) {
        if (isBlank(strategy)) {
            return new ArrayList<>();
        }
        List<Strategy> strategies = new ArrayList<>();
        try {
            String[] split = strategy.split(";");
            strategies = LinqUtils.map(split, s -> parseStrategy(s.trim()));
        } catch (Exception ignore) {
        }
        return strategies;
    }

    private static void setSearchStrategy(String p) {
        List<String> params = getSearchStrategyParams(p);
        if (params.size() == 2) {
            if (params.contains("visible") || params.contains("displayed")) {
                onlyVisible();
            }
            if (params.contains("any") || params.contains("all")) {
                noValidation();
            }
            if (params.contains("enabled")) {
                visibleEnabled();
            }
            if (params.contains("inview")) {
                inView();
            }
            if (params.contains("single")) {
                STRICT_SEARCH = true;
            }
            if (params.contains("multiple")) {
                STRICT_SEARCH = false;
            }
        }
    }

    private static List<String> getSearchStrategyParams(String p) {
        switch (p.toLowerCase()) {
            case "soft":
                return asList("any", "multiple");
            case "strict":
                return asList("visible", "single");
            default:
                return asList(p.split(","));
        }
    }

    private static PageLoadStrategy getPageLoadStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "none":
                return NONE;
            case "eager":
                return EAGER;
            default:
                return NORMAL;
        }
    }

    private static ElementArea getClickType(String type) {
        ElementArea clickType = first(getAllEnumValues(ElementArea.class),
            t -> t.toString().equals(type));
        return clickType != null
            ? clickType : CENTER;
    }

    private static TextTypes getTextType(String type) {
        TextTypes textType = first(getAllEnumValues(TextTypes.class),
            t -> t.toString().equals(type));
        return textType != null
            ? textType : SMART_TEXT;
    }

    private static SetTextTypes getSetTextType(String type) {
        SetTextTypes textType = first(getAllEnumValues(SetTextTypes.class),
            t -> t.toString().equals(type));
        return textType != null
            ? textType : SET_TEXT;
    }

    private static String getRemoteUrl(String prop) {
        switch (prop.toLowerCase().replaceAll(" ", "")) {
            case "sauce":
            case "saucelabs":
                DRIVER.capabilities.common = sauceCapabilities();
                return sauceLabs();
            case "browserstack":
                return browserstack();
            default:
                return seleniumLocalhost();
        }
    }

    private static Pair<String, JFunc1<String, String>> getSmartSearchFunc(
        String name) {
        if (!SMART_MAP_NAME_TO_LOCATOR.keys().contains(name)) {
            throw exception(
                "Unknown JDISettings.ELEMENT.smartName: '%s'. Please correct value 'smart.locators.toName' in test.properties."
                    +
                    "Available names: [%s]", name, print(SMART_MAP_NAME_TO_LOCATOR.keys()));
        }
        return Pair.$(name, SMART_MAP_NAME_TO_LOCATOR.get(name));
    }

    private static UseSmartSearch getSmartSearchUse(String prop) {
        String propLower = prop.toLowerCase().trim().replaceAll(" ", "");
        switch (propLower) {
            case "false":
                return FALSE;
            case "onlyui":
                return ONLY_UI;
            case "uiandelements":
                return UI_AND_ELEMENTS;
            case "always":
                return ALWAYS;
            default:
                return UI_AND_ELEMENTS;
        }
    }

    private static LogInfoDetails getInfoDetailsLevel(String option) {
        switch (option.toLowerCase()) {
            case "none":
                return LogInfoDetails.NONE;
            case "name":
                return LogInfoDetails.NAME;
            case "locator":
                return LogInfoDetails.LOCATOR;
            case "context":
                return LogInfoDetails.CONTEXT;
            case "element":
                return LogInfoDetails.ELEMENT;
            default:
                return LogInfoDetails.ELEMENT;
        }
    }

}
