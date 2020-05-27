package com.epam.jdi.light.settings;

import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.common.Property.ALLURE_STEPS_PROPERTY;
import static com.epam.jdi.light.common.Property.ASSERT_TYPE_PROPERTY;
import static com.epam.jdi.light.common.Property.CLICK_TYPE_PROPERTY;
import static com.epam.jdi.light.common.Property.DOMAIN_PROPERTY;
import static com.epam.jdi.light.common.Property.DRIVERS_FOLDER_PROPERTY;
import static com.epam.jdi.light.common.Property.DRIVER_PROPERTY;
import static com.epam.jdi.light.common.Property.DRIVER_REMOTE_URL_PROPERTY;
import static com.epam.jdi.light.common.Property.DRIVER_VERSION_PROPERTY;
import static com.epam.jdi.light.common.Property.ELEMENT_SEARCH_STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.HEADLESS_PROPERTY;
import static com.epam.jdi.light.common.Property.HTML_CODE_STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.KILL_BROWSER_PROPERTY;
import static com.epam.jdi.light.common.Property.LIST_START_INDEX_PROPERTY;
import static com.epam.jdi.light.common.Property.LOG_INFO_DETAILS_PROPERTY;
import static com.epam.jdi.light.common.Property.LOG_LEVEL_PROPERTY;
import static com.epam.jdi.light.common.Property.REMOTE_TYPE_PROPERTY;
import static com.epam.jdi.light.common.Property.REQUESTS_STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.SCREENSHOT_STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.SCREENS_FOLDER_PROPERTY;
import static com.epam.jdi.light.common.Property.SET_TEXT_TYPE_PROPERTY;
import static com.epam.jdi.light.common.Property.SMART_LOCATORS_TO_NAME_PROPERTY;
import static com.epam.jdi.light.common.Property.SMART_SEARCH_PROPERTY;
import static com.epam.jdi.light.common.Property.STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.TEXT_TYPE_PROPERTY;
import static com.epam.jdi.light.common.Property.TIMEOUT_WAIT_ELEMENT_PROPERTY;
import static com.epam.jdi.light.common.Property.BROWSER_SIZE_PROPERTY;
import static com.epam.jdi.light.common.Property.PAGE_LOAD_STRATEGY_PROPERTY;
import static com.epam.jdi.light.common.Property.PAGE_CHECK_AFTER_OPEN;
import static com.epam.jdi.light.common.Property.SMART_LOCATORS_PROPERTY;
import static com.epam.jdi.light.common.Property.TIMEOUT_WAIT_PAGE_PROPERTY;
import static com.epam.jdi.light.common.SearchStrategies.inView;
import static com.epam.jdi.light.common.SearchStrategies.noValidation;
import static com.epam.jdi.light.common.SearchStrategies.onlyVisible;
import static com.epam.jdi.light.common.SearchStrategies.visibleEnabled;
import static com.epam.jdi.light.common.SetTextTypes.SET_TEXT;
import static com.epam.jdi.light.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.light.common.UseSmartSearch.ALWAYS;
import static com.epam.jdi.light.common.UseSmartSearch.FALSE;
import static com.epam.jdi.light.common.UseSmartSearch.ONLY_UI;
import static com.epam.jdi.light.common.UseSmartSearch.UI_AND_ELEMENTS;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.RemoteDriver.browserstack;
import static com.epam.jdi.light.driver.get.RemoteDriver.sauceLabs;
import static com.epam.jdi.light.driver.get.RemoteDriver.seleniumLocalhost;
import static com.epam.jdi.light.driver.sauce.SauceSettings.sauceCapabilities;
import static com.epam.jdi.light.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.light.logger.Strategy.FAIL;
import static com.epam.jdi.light.logger.Strategy.addStrategy;
import static com.epam.jdi.light.logger.Strategy.parseStrategy;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.JDISettings.LOGS;
import static com.epam.jdi.light.settings.JDISettings.PAGE;
import static com.epam.jdi.light.settings.JDISettings.SCREEN;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
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
import static org.openqa.selenium.PageLoadStrategy.EAGER;
import static org.openqa.selenium.PageLoadStrategy.NONE;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.common.Timeout;
import com.epam.jdi.light.common.UseSmartSearch;
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

public class TestProperties {

  private static Map<String, Pair<JAction1<String>, JAction>> testsProperties = null;
  private static final JAction _doNothing = () -> {};
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
    properties.put(STRATEGY_PROPERTY.getName(), combo(p -> COMMON.strategy = getStrategy(p),
            COMMON.strategy.action));
    properties
            .put(TIMEOUT_WAIT_ELEMENT_PROPERTY.getName(), single(p -> TIMEOUTS.element = new Timeout(parseInt(p))));
    properties.put(TIMEOUT_WAIT_PAGE_PROPERTY.getName(), single(p -> TIMEOUTS.page = new Timeout(parseInt(p))));
    properties.put(DOMAIN_PROPERTY.getName(), single(WebSettings::setDomain));
    if (DRIVER.name.equals(DEFAULT_DRIVER)) {
      properties.put(DRIVER_PROPERTY.getName(),
              single(p -> DRIVER.name = p));
    }
    properties.put(DRIVER_VERSION_PROPERTY.getName(), single(p -> DRIVER.version = p));
    properties.put(DRIVERS_FOLDER_PROPERTY.getName(), single(p -> DRIVER.path = p));
    properties.put(SCREENS_FOLDER_PROPERTY.getName(),
            combo(p -> SCREEN.path = p, () -> addStrategy(FAIL, LOGS.screenStrategy)));
    properties.put(LIST_START_INDEX_PROPERTY.getName(), single(p -> ELEMENT.startIndex = parseInt(p)));
    properties
            .put(LOG_INFO_DETAILS_PROPERTY.getName(), single(p -> LOGS.logInfoDetails = getInfoDetailsLevel(p)));
    properties
            .put(SCREENSHOT_STRATEGY_PROPERTY.getName(), single(p -> LOGS.screenStrategy = getLoggerStrategy(p)));
    properties
            .put(HTML_CODE_STRATEGY_PROPERTY.getName(), single(p -> LOGS.htmlCodeStrategy = getLoggerStrategy(p)));
    properties
            .put(REQUESTS_STRATEGY_PROPERTY.getName(), single(p -> LOGS.requestsStrategy = getLoggerStrategy(p)));
    properties.put(KILL_BROWSER_PROPERTY.getName(), single(p -> COMMON.killBrowser = p));
    properties.put(ELEMENT_SEARCH_STRATEGY_PROPERTY.getName(), single(TestProperties::setSearchStrategy));
    properties.put(BROWSER_SIZE_PROPERTY.getName(), single(DRIVER.screenSize::read));
    properties
            .put(PAGE_LOAD_STRATEGY_PROPERTY.getName(), single(p -> DRIVER.pageLoadStrategy = getPageLoadStrategy(p)));
    properties.put(PAGE_CHECK_AFTER_OPEN.getName(), single(p -> PAGE.checkPageOpen = parse(p)));
    properties.put(ASSERT_TYPE_PROPERTY.getName(), single(SoftAssert::setAssertType));
    properties.put(CLICK_TYPE_PROPERTY.getName(), single(p -> ELEMENT.clickType = getClickType(p)));
    properties.put(TEXT_TYPE_PROPERTY.getName(), single(p -> ELEMENT.getTextType = getTextType(p)));
    properties.put(SET_TEXT_TYPE_PROPERTY.getName(), single(p -> ELEMENT.setTextType = getSetTextType(p)));
///     RemoteWebDriver properties
    properties.put(REMOTE_TYPE_PROPERTY.getName(), single(p -> DRIVER.remoteUrl = getRemoteUrl(p)));
    properties.put(DRIVER_REMOTE_URL_PROPERTY.getName(), single(p -> DRIVER.remoteUrl = p));
    properties.put(LOG_LEVEL_PROPERTY.getName(),
            combo(p -> LOGS.logLevel = parseLogLevel(p), () -> logger.setLogLevel(LOGS.logLevel)));
    properties.put(ALLURE_STEPS_PROPERTY.getName(), single(p -> LOGS.writeToAllure = parseBoolean(p)));
    properties.put(SMART_LOCATORS_PROPERTY.getName(), single(p -> ELEMENT.smartTemplate = p.split(";")[0]));
    properties
            .put(SMART_LOCATORS_TO_NAME_PROPERTY.getName(), single(p -> ELEMENT.smartName = getSmartSearchFunc(p)));
    properties.put(SMART_SEARCH_PROPERTY.getName(), single(p -> ELEMENT.useSmartSearch = getSmartSearchUse(p)));
    properties.put(HEADLESS_PROPERTY.getName(), single(p -> DRIVER.capabilities.common.put("headless", p)));
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

  private static List<String> getSearchStrategyParams(String p){
    switch (p.toLowerCase()){
      case "soft":
       return asList("any","multiple");
      case "strict":
       return asList("visible","single");
      default:
       return  asList(p.split(","));
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
