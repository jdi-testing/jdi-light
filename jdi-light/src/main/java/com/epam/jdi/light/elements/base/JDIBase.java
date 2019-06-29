package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDILocator;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.HasCache;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.OutputTemplates.*;
import static com.epam.jdi.light.elements.init.InitActions.isPageObject;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public abstract class JDIBase extends DriverBase implements HasCache {
    public static JFunc1<String, String> STRING_SIMPLIFY =
        s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    public static <T> boolean waitCondition(JFunc1<T, Boolean> condition, T element) {
        return new Timer(TIMEOUT.get()).wait(() -> condition.execute(element));
    }
    public JDILocator locator = new JDILocator();

    public CacheValue<WebElement> webElement = new CacheValue<>();
    protected CacheValue<List<WebElement>> webElements = new CacheValue<>();
    protected CacheValue<JFunc1<WebElement, Boolean>> searchRule =
            new CacheValue<>(() -> SEARCH_CONDITION);

    public JDIBase noValidation() {
        return setSearchRule(ANY_ELEMENT);
    }
    public JDIBase onlyVisible() {
        return setSearchRule(VISIBLE_ELEMENT);
    }
    public JDIBase onlyEnabled() { return setSearchRule(ENABLED_ELEMENT); }
    public JDIBase setSearchRule(JFunc1<WebElement, Boolean> rule) {
        searchRule.setForce(rule);
        return this;
    }
    public JDIBase setWebElement(WebElement el) {
        webElement.setForce(el);
        return this;
    }
    public JDIBase setWebElements(List<WebElement> els) {
        webElements.setForce(els);
        return this;
    }

    public JDIBase setLocator(By locator) {
        if (name.isEmpty()) name = shortBy(locator);
        this.locator = new JDILocator(locator, this);
        return this;
    }
    public JDIBase setFrame(By locator) {
        if (name.isEmpty()) name = shortBy(locator);
        this.locator = new JDILocator(locator, FRAME, this);
        return this;
    }
    public By getLocator(Object... args) {
        initContext();
        if (locator.isFrame()) return null;
        return locator.getLocator(args);
    }
    public By getFrame() { return locator.getFrame(); }

    public static final String FAILED_TO_FIND_ELEMENT_MESSAGE
            = "Can't find Element '%s' during %s seconds";
    public static final String FIND_TO_MUCH_ELEMENTS_MESSAGE
            = "Found %s elements instead of one for Element '%s' during %s seconds";
    public static final String ELEMENTS_FILTERED_MESSAGE
            = "Found %s elements but none pass results filtering. Please change locator or filtering rules (WebSettings.SEARCH_CONDITION = el -> ...)" +
            LINE_BREAK + "Element '%s' search during %s seconds";

    public WebElement get() {
        return get(new Object[]{});
    }
    protected JFunc<WebElement> getElementFunc = null;
    public void setGetFunc(JFunc<WebElement> func) { getElementFunc = func; }
    public WebElement get(Object... args) {
        if (webElement.hasValue()) {
            WebElement element = webElement.get();
            try {
                element.getTagName();
                return element;
            } catch (Exception ignore) {
                if (getElementFunc == null)
                    webElement.clear();
                else {
                    return webElement.set(getElementFunc.execute());
                }
            }
        }
        if (locator.isEmpty()) {
            try {
                WebElement element = SMART_SEARCH.execute(this);
                if (element != null)
                    return element;
                throw exception("");
            } catch (Exception ex) {
                throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
            }
        }
        if (locator.isTemplate() && args.length == 0)
            throw exception("Can't get element with template locator '%s' without arguments", getLocator());
        List<WebElement> result = getAll(args);
        if (result.size() == 0)
            throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
        if (result.size() > 1) {
            int found = result.size();
            List<WebElement> filtered = filter(result, el -> searchRule.get().execute(el));
            if (filtered.size() == 0)
                throw exception(ELEMENTS_FILTERED_MESSAGE, found, toString(), TIMEOUT.get());
        }
        if (result.size() == 1)
            return result.get(0);
        throw exception(FIND_TO_MUCH_ELEMENTS_MESSAGE, result.size(), toString(), TIMEOUT.get());
    }
    public UIElement getUI(Object... args) {
        return new UIElement(get(args));
    }

    public List<WebElement> getAll(Object... args) {
        //TODO rethink SMART SEARCH
        if (webElements.hasValue()) {
            List<WebElement> elements = webElements.get();
            try {
                elements.get(0).getTagName();
                return elements;
            } catch (Exception ignore) { webElements.clear(); }
        }
        if (locator.isEmpty())
            return asList(SMART_SEARCH.execute(this));
        SearchContext searchContext = getContext(parent, locator);
        List<WebElement> els = uiSearch(searchContext, correctLocator(getLocator(args)));
        return filter(els, el -> searchRule.get().execute(el));
    }
    public List<WebElement> getList(int minAmount) {
        List<WebElement> result = timer().getResultByCondition(this::tryGetList,
                els -> els.size() >= minAmount);
        if (result == null)
            throw exception("Expected at least %s elements but failed (%s)", minAmount, toString());
        return result;
    }
    private List<WebElement> tryGetList() {
        List<WebElement> elements = getAll();
        if (elements == null)
            throw exception("No elements found (%s)", toString());
        if (elements.size() == 1)
            elements = processListTag(elements);
        return elements;
    }
    private List<WebElement> processListTag(List<WebElement> elements) {
        WebElement element = elements.get(0);
        String tagName = element.getTagName();
        switch (tagName) {
            case "ul":
                return element.findElements(By.tagName("li"));
            case "select":
                return element.findElements(By.tagName("option"));
            default:
                return elements;
        }
    }
    public WebList allUI(Object... args) {
        return new WebList(getAll(args)).setName(getName());
    }
    private JDIBase getBase(Object element) {
        if (isClass(element.getClass(), JDIBase.class))
            return  (JDIBase) element;
        else { if (isInterface(element.getClass(), IBaseElement.class))
            return  ((IBaseElement) element).core(); }
        return null;
    }
    private SearchContext getSearchContext(Object element) {
        JDIBase bElement = getBase(element);
        if (bElement == null)
            return getDefaultContext();
        if (bElement.webElement.hasValue())
            return bElement.webElement.get();
        Object parent = bElement.parent;
        By locator = bElement.getLocator();
        By frame = bElement.getFrame();
        SearchContext searchContext = frame != null
                ? getFrameContext(frame)
                : getContext(parent, bElement.locator);
        //TODO rethink SMART SEARCH
        return locator != null
                ? uiSearch(searchContext, correctLocator(locator)).get(0)
                : isPageObject(bElement.getClass())
                ? searchContext
                : SMART_SEARCH.execute(bElement);
    }
    private boolean isRoot(Object parent) {
        return parent == null || isClass(parent.getClass(), WebPage.class)
                || !isInterface(parent.getClass(), JDIElement.class);
    }
    private SearchContext getContext(Object parent, JDILocator locator) {
        return locator.isRoot || isRoot(parent)
                ? getDefaultContext()
                : getSearchContext(parent);
    }
    private SearchContext getFrameContext(By frame) {
        return driver().switchTo().frame(uiSearch(driver(),frame).get(0));
    }
    private SearchContext getDefaultContext() {
        return driver().switchTo().defaultContent();
    }
    private By correctLocator(By locator) {
        if (locator == null) return null;
        return correctXPaths(locator);
    }

    public String printContext() {
        JDIBase jdiBase = getBase(parent);
        if (jdiBase == null) return "";
        String locator = jdiBase.getLocator() == null ? "" : jdiBase.locator.toString();
        if (jdiBase.parent == null)
            return locator;
        if (isBlank(locator))
            return jdiBase.printContext();
        return jdiBase.printContext() + ">" + locator;
    }
    public String printFullLocator() {
        return parent == null || isBlank(printContext())
                ? locator.toString()
                : printContext() + ">" + locator.toString();
    }
    private void initContext() {
        if (context == null)
            context = printFullLocator();
    }

    @Override
    public String toString() {
        initContext();
        try {
            return PRINT_ELEMENT.execute(this);
        } catch (Exception ex) { throw exception("Can't print element: " + ex.getMessage()); }
    }
    public String toError() {
        initContext();
        try {
            return Switch(logger.getLogLevel()).get(
                    Case(l -> l == INFO,
                            l -> msgFormat(PRINT_ERROR_INFO, this)),
                    Case(l -> l == DEBUG,
                            l -> msgFormat(PRINT_ERROR_DEBUG, this)),
                    Default(l -> msgFormat(PRINT_ERROR_STEP, this))
            );
        } catch (Exception ex) { throw exception("Can't print element for error: " + ex.getMessage()); }
    }
    private static String printWebElement(WebElement element) {
        String asString = element.toString().replaceAll("css selector", "css");
        String result = asString.startsWith("WebElement->")
                ? "" : "WebElement->";
        if (asString.contains(")]")) {
            String s = asString.split("-> ")[1];
            return result + s.substring(0,s.length()-1);
        }
        return asString;
    }
    public static JFunc1<JDIBase, String> PRINT_ELEMENT = element -> {
        if (element.webElement.hasValue())
            return printWebElement(element.webElement.get());
        return Switch(logger.getLogLevel()).get(
                Case(l -> l == STEP,
                        l -> msgFormat(PRINT_ELEMENT_STEP, element)),
                Case(l -> l == INFO,
                        l -> msgFormat(PRINT_ELEMENT_INFO, element)),
                Case(l -> l == ERROR,
                        l -> msgFormat(PRINT_ERROR_STEP, element)),
                Default(l -> msgFormat(PRINT_ELEMENT_DEBUG, element))
        );
    };

    public void actions(JFunc2<Actions, WebElement, Actions> actions) {
        actions.execute(actionsClass(), get()).build().perform();
    }
    public void actionsWitElement(JFunc2<Actions, WebElement, Actions> actions) {
        actions.execute(actionsClass().moveToElement(get()), get()).build().perform();
    }
    private Actions actions = null;
    private Actions actionsClass() {
        if (actions == null)
            actions = new Actions(driver());
        return actions;
    }

    public void offCache() {
        webElement.useCache(false);
        webElements.useCache(false);
        searchRule.useCache(false);
    }
}