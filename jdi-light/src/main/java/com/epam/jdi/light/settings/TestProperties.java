package com.epam.jdi.light.settings;

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

import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.PageChecks.parse;
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
import static com.epam.jdi.light.settings.CommonSettings.getCommonSettings;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.light.settings.Strategies.JDI;
import static com.epam.jdi.light.settings.Strategies.SELENIUM;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;
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

public class TestProperties {

  private static final CommonSettings commonSettings = getCommonSettings();
  private static final JDISettings jdiSettings = getJDISettings();

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
    properties.put("strategy", combo(p -> commonSettings.strategy = getStrategy(p),
            commonSettings.strategy.action));
    properties
            .put("timeout.wait.element", single(p -> jdiSettings.TIMEOUTS.element = new Timeout(parseInt(p))));
    properties.put("timeout.wait.page", single(p -> jdiSettings.TIMEOUTS.page = new Timeout(parseInt(p))));
    properties.put("domain", single(getWebSettings()::setDomain));
    if (jdiSettings.DRIVER.name.equals(DEFAULT_DRIVER)) {
      properties.put("driver",
              single(p -> jdiSettings.DRIVER.name = p));
    }
    properties.put("driver.version", single(p -> jdiSettings.DRIVER.version = p));
    properties.put("drivers.folder", single(p -> jdiSettings.DRIVER.path = p));
    properties.put("screens.folder",
            combo(p -> jdiSettings.SCREEN.path = p, () -> addStrategy(FAIL, jdiSettings.LOGS.screenStrategy)));
    properties.put("list.start.index", single(p -> jdiSettings.ELEMENT.startIndex = parseInt(p)));
    properties
            .put("log.info.details", single(p -> jdiSettings.LOGS.logInfoDetails = getInfoDetailsLevel(p)));
    properties
            .put("screenshot.strategy", single(p -> jdiSettings.LOGS.screenStrategy = getLoggerStrategy(p)));
    properties
            .put("html.code.strategy", single(p -> jdiSettings.LOGS.htmlCodeStrategy = getLoggerStrategy(p)));
    properties
            .put("requests.strategy", single(p -> jdiSettings.LOGS.requestsStrategy = getLoggerStrategy(p)));
    properties.put("browser.kill", single(p -> commonSettings.killBrowser = p));
    properties.put("element.search.strategy", single(TestProperties::setSearchStrategy));
    properties.put("browser.size", single(jdiSettings.DRIVER.screenSize::read));
    properties
            .put("page.load.strategy", single(p -> jdiSettings.DRIVER.pageLoadStrategy = getPageLoadStrategy(p)));
    properties.put("page.check.after.open", single(p -> jdiSettings.PAGE.checkPageOpen = parse(p)));
    properties.put("assert.type", single(SoftAssert::setAssertType));
    properties.put("click.type", single(p -> jdiSettings.ELEMENT.clickType = getClickType(p)));
    properties.put("text.type", single(p -> jdiSettings.ELEMENT.getTextType = getTextType(p)));
    properties.put("set.text.type", single(p -> jdiSettings.ELEMENT.setTextType = getSetTextType(p)));
///     RemoteWebDriver properties
    properties.put("remote.type", single(p -> jdiSettings.DRIVER.remoteUrl = getRemoteUrl(p)));
    properties.put("driver.remote.url", single(p -> jdiSettings.DRIVER.remoteUrl = p));
    properties.put("log.level",
            combo(p -> jdiSettings.LOGS.logLevel = parseLogLevel(p), () -> getWebSettings().logger.setLogLevel(jdiSettings.LOGS.logLevel)));
    properties.put("allure.steps", single(p -> jdiSettings.LOGS.writeToAllure = parseBoolean(p)));
    properties.put("smart.locators", single(p -> jdiSettings.ELEMENT.smartTemplate = p.split(";")[0]));
    properties
            .put("smart.locators.toName", single(p -> jdiSettings.ELEMENT.smartName = getSmartSearchFunc(p)));
    properties.put("smart.search", single(p -> jdiSettings.ELEMENT.useSmartSearch = getSmartSearchUse(p)));
    properties.put("headless", single(p -> jdiSettings.DRIVER.capabilities.common.put("headless", p)));
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
        jdiSettings.DRIVER.capabilities.common = sauceCapabilities();
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
