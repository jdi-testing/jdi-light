package com.epam.jdi.light.settings;

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
import javafx.util.Pair;
import org.openqa.selenium.PageLoadStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestProperties {

  private static Map<String, Pair<JAction1<String>, JAction>> testsProperties = new HashMap<>();
  private static final JAction doNothing = ()->{};
  public static boolean STRICT_SEARCH = true;

  private TestProperties() {
  }

  public static Map<String, Pair<JAction1<String>, JAction>> getTestsProperties() {
    return testsProperties;
  }

  static {
    testsProperties.put("strategy",
        new Pair<>(p -> COMMON.strategy = getStrategy(p),
            COMMON.strategy.action));
    testsProperties.put("timeout.wait.element",
        new Pair<>(p -> TIMEOUTS.element = new Timeout(parseInt(p)), doNothing));
    testsProperties.put("timeout.wait.page",
        new Pair<>(p -> TIMEOUTS.page = new Timeout(parseInt(p)), doNothing));
    testsProperties.put("domain",
        new Pair<>(WebSettings::setDomain, doNothing));
    if (DRIVER.name.equals(DEFAULT_DRIVER))
    {
      testsProperties.put("driver",
          new Pair<>(p -> DRIVER.name = p, doNothing));}
    testsProperties.put("driver.version",
        new Pair<>(p -> DRIVER.version = p, doNothing));
    testsProperties.put("drivers.folder",
        new Pair<>(p -> DRIVER.path = p, doNothing));
    testsProperties.put("screens.folder",
        new Pair<>(p -> SCREEN.path = p, () -> addStrategy(FAIL, LOGS.screenStrategy)));
    testsProperties.put("list.start.index",
        new Pair<>(p -> ELEMENT.startIndex = parseInt(p),doNothing));
    testsProperties.put("log.info.details",
        new Pair<>(p -> LOGS.logInfoDetails = getInfoDetailsLevel(p),doNothing));
    testsProperties.put("screenshot.strategy",
        new Pair<>(p -> LOGS.screenStrategy = getLoggerStrategy(p), doNothing));
    testsProperties.put("html.code.strategy",
        new Pair<>(p -> LOGS.htmlCodeStrategy = getLoggerStrategy(p),doNothing));
    testsProperties.put("requests.strategy",
        new Pair<>(p -> LOGS.requestsStrategy = getLoggerStrategy(p),doNothing));
    testsProperties.put("browser.kill",
        new Pair<>(p -> COMMON.killBrowser = p,doNothing));
    testsProperties.put("element.search.strategy",
        new Pair<>(TestProperties::setSearchStrategy,doNothing));
    testsProperties.put("browser.size",
        new Pair<>(DRIVER.screenSize::read,doNothing));
    testsProperties.put("page.load.strategy",
        new Pair<>(p -> DRIVER.pageLoadStrategy = getPageLoadStrategy(p),doNothing));
    testsProperties.put("page.check.after.open",
        new Pair<>(p -> PAGE.checkPageOpen = parse(p),doNothing));
    testsProperties.put("assert.type",
        new Pair<>(SoftAssert::setAssertType,doNothing));
    testsProperties.put("click.type",
        new Pair<>(p -> ELEMENT.clickType = getClickType(p),doNothing));
    testsProperties.put("text.type",
        new Pair<>(p -> ELEMENT.getTextType = getTextType(p),doNothing));
    testsProperties.put("set.text.type",
        new Pair<>(p -> ELEMENT.setTextType = getSetTextType(p),doNothing));
//     RemoteWebDriver properties
    testsProperties.put("remote.type",
        new Pair<>(p -> DRIVER.remoteUrl = getRemoteUrl(p),doNothing));
    testsProperties.put("driver.remote.url",
        new Pair<>(p -> DRIVER.remoteUrl = p,doNothing));
    testsProperties.put("log.level",
        new Pair<>(p -> LOGS.logLevel = parseLogLevel(p), () -> logger.setLogLevel(LOGS.logLevel)));
    testsProperties.put("allure.steps",
        new Pair<>(p -> LOGS.writeToAllure = parseBoolean(p),doNothing));
    testsProperties.put("smart.locators",
        new Pair<>(p -> ELEMENT.smartTemplate = p.split(";")[0],doNothing));
    testsProperties.put("smart.locators.toName",
        new Pair<>(p -> ELEMENT.smartName = getSmartSearchFunc(p),doNothing));
    testsProperties.put("smart.search",
        new Pair<>(p -> ELEMENT.useSmartSearch = getSmartSearchUse(p),doNothing));
    testsProperties.put("headless",
        new Pair<>(p -> DRIVER.capabilities.common.put("headless", p),doNothing));
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
    if (isBlank(strategy))
      return new ArrayList<>();
    List<com.epam.jdi.light.logger.Strategy> strategies = new ArrayList<>();
    try {
      String[] split = strategy.split(";");
      strategies = LinqUtils.map(split, s -> parseStrategy(s.trim()));
    } catch (Exception ignore) { }
    return strategies;
  }

  private static void setSearchStrategy(String p) {
    p = p.toLowerCase();
    if (p.equals("soft"))
      p = "any, multiple";
    if (p.equals("strict"))
      p = "visible, single";
    if (p.split(",").length == 2) {
      List<String> params = asList(p.split(","));
      if (params.contains("visible") || params.contains("displayed"))
        onlyVisible();
      if (params.contains("any") || params.contains("all"))
        noValidation();
      if (params.contains("enabled"))
        visibleEnabled();
      if (params.contains("inview"))
        inView();
      if (params.contains("single"))
        STRICT_SEARCH = true;
      if (params.contains("multiple"))
        STRICT_SEARCH = false;
    }
  }

  private static PageLoadStrategy getPageLoadStrategy(String strategy) {
    switch (strategy.toLowerCase()) {
      case "normal": return NORMAL;
      case "none": return NONE;
      case "eager": return EAGER;
    }
    return NORMAL;
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
      case "browserstack": return browserstack();
      default: return seleniumLocalhost();
    }
  }

  private static com.epam.jdi.tools.pairs.Pair<String, JFunc1<String, String>> getSmartSearchFunc(String name) {
    if (!SMART_MAP_NAME_TO_LOCATOR.keys().contains(name)) {
      throw exception("Unknown JDISettings.ELEMENT.smartName: '%s'. Please correct value 'smart.locators.toName' in test.properties." +
          "Available names: [%s]", name, print(SMART_MAP_NAME_TO_LOCATOR.keys()));
    }
    return com.epam.jdi.tools.pairs.Pair.$(name, SMART_MAP_NAME_TO_LOCATOR.get(name));
  }

  private static UseSmartSearch getSmartSearchUse(String prop) {
    String propLower = prop.toLowerCase().trim().replaceAll(" ", "");
    switch (propLower) {
      case "false": return FALSE;
      case "onlyui": return ONLY_UI;
      case "uiandelements": return UI_AND_ELEMENTS;
      case "always": return ALWAYS;
      default: return UI_AND_ELEMENTS;
    }
  }

  private static LogInfoDetails getInfoDetailsLevel(String option) {
    switch (option.toLowerCase()) {
      case "none": return LogInfoDetails.NONE;
      case "name": return LogInfoDetails.NAME;
      case "locator": return LogInfoDetails.LOCATOR;
      case "context": return LogInfoDetails.CONTEXT;
      case "element": return LogInfoDetails.ELEMENT;
      default: return LogInfoDetails.ELEMENT;
    }
  }

}
