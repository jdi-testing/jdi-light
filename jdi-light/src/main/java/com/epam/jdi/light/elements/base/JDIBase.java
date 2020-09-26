package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasCache;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.JdiSettings.*;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class JDIBase extends DriverBase implements IBaseElement, HasCache {

    public JDIBase base() {
        return this;
    }
    public JDIBase() {
        searchRules.update(ELEMENT.searchRule);
    }
    public JDIBase(JDIBase base) {
        this(); setCore(base);
    }
    public JDIBase setCore(JDIBase base) {
        locator = base.locator.copy();
        name = base.name;
        parent = base.parent;
        varName = base.varName;
        typeName = base.typeName;
        failElement = base.failElement;
        driverName = base.driverName;
        context = base.printFullLocator();
        webElement = base.webElement.copy();
        webElements = base.webElements.copy();
        searchRules = base.searchRules.copy();
        beforeSearch = base.beforeSearch;
        timeout = base.timeout;
        return this;
    }
    public MapArray<String, Object> params = new MapArray<>();

    public JDILocator locator = new JDILocator(this);
    @Override
    public DriverBase setParent(Object parent) {
        return super.setParent(parent);
    }
    public CacheValue<WebElement> webElement = new CacheValue<>();
    public CacheValue<List<WebElement>> webElements = new CacheValue<>();
    public MapArray<String, JFunc1<WebElement, Boolean>> searchRules = new MapArray<>();
    protected MapArray<String, JFunc1<WebElement, Boolean>> searchRules() {
        return searchRules;
    }
    public JAction1<UIElement> beforeSearch = null;
    WebElement beforeSearch(WebElement el) {
        (beforeSearch == null ? ELEMENT.beforeSearch : beforeSearch).execute(new UIElement(el));
        return el;
    }

    public JDIBase doBefore(JAction1<UIElement> action) { beforeSearch = action; return this; }
    public JDIBase showBefore() { beforeSearch = UIElement::show; return this; }
    public JDIBase noValidation() {
        return setSearchRule("Any", ANY_ELEMENT);
    }
    public <T> T noValidation(JFunc<T> func) {
        MapArray<String, JFunc1<WebElement, Boolean>> rules = searchRules.copy();
        searchRules.clear();
        T result = func.execute();
        searchRules = rules;
        return result;
    }
    public JDIBase searchVisible() {
        return setSearchRule("Visible", VISIBLE_ELEMENT);
    }
    public JDIBase visibleEnabled() { return setSearchRule("Enabled", ENABLED_ELEMENT); }
    public JDIBase inView() {
        showBefore();
        return setSearchRule("Element in view", ELEMENT_IN_VIEW);
    }
    public JDIBase addSearchRule(String name, JFunc1<WebElement, Boolean> rule) {
        searchRules.add(name, rule);
        return this;
    }
    public JDIBase setSearchRule(String name, JFunc1<WebElement, Boolean> rule) {
        searchRules.clear();
        searchRules.add(name, rule);
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

    public JDIBase setLocator(@MarkupLocator String locator) {
        return setLocator(defineLocator(locator));
    }
    public JDIBase setLocator(@MarkupLocator By locator) {
        if (locator != null) {
            if (name.isEmpty())
                name = shortBy(locator, this);
            this.locator.add(locator, this);
        }
        return this;
    }
    public JDIBase setFrames(List<By> frames) {
        if (name.isEmpty() && frames.size() > 0)
            name = shortBy(frames.get(0));
        this.locator.add(frames, this);
        return this;
    }
    public By getLocator(Object... args) {
        initContext();
        return locator.getLocator(args);
    }
    public List<By> getFrames() { return locator.getFrames(); }

    protected int timeout = -1;
    protected int waitAfterTimeout = -1;
    protected String waitAfterMethod = "";
    public IBaseElement waitAfter(int timeout, String methodName) {
        if (timeout > 0)
            waitAfterTimeout = timeout;
        if (isNotBlank(methodName))
            waitAfterMethod = methodName;
        return this;
    }
    public Pair<String, Integer> waitAfter() {
        return new Pair<>(waitAfterMethod, waitAfterTimeout);
    }
    @Override
    public IBaseElement waitSec(int sec) {
        timeout = sec;
        return this;
    }
    public int getTimeout() {
        return timeout > -1 ? timeout : TIMEOUTS.element.get();
    }
    public Timer timer() { return new Timer(getTimeout()*1000); }

    @Override
    public JDIBase setName(String name) {
        this.name = name;
        this.varName = name;
        this.failElement = name;
        return this;
    }

    @JDIAction(value = "{0}", timeout = 0)
    public void visualCheck(String message) { }

    // Get Web Element without validations and wait
    public WebElement getWebElement() {
        return noValidation(() -> noWait(() -> get(new Object[]{})));
    }

    // Get Web Element using Search Rules and wait
    public WebElement get() {
        return get(new Object[]{});
    }
    protected JFunc<WebElement> getElementFunc = null;
    public JDIBase setGetFunc(JFunc<WebElement> func) {
        getElementFunc = func;
        return this;
    }
    public WebElement get(Object... args) {
        return ELEMENT.getElementWithArgs.execute(this, args);
    }

    protected Boolean strictSearch;
    public void strictSearch(boolean strictSearch) {
        this.strictSearch = strictSearch;
    }
    public WebElement getSmart() {
        try {
            WebElement element = SMART_SEARCH.execute(this);
            if (element != null)
                return element;
            throw exception("");
        } catch (Exception ex) {
            throw exception(ex, FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), getTimeout());
        }
    }
    // Get all webElements
    public List<WebElement> getWebElements(Object... args) {
        logger.debug("getAllElements()");
        getDefaultContext(driver());
        if (webElements.hasValue()) {
            List<WebElement> elements = map(webElements.get(), JdiSettings::purify);
            try {
                beforeSearch(elements.get(0)).getTagName();
                return elements;
            } catch (Exception ignore) { webElements.clear(); }
        }
        if (locator.isNull())
            return singletonList(beforeSearch(getSmart()));
        List<WebElement> result = getAllElementsInContext(this, args);
        if (result.size() > 0)
            beforeSearch(result.get(0));
        return result;
    }
    public List<WebElement> getAll(Object... args) {
        return filterElements(this, getWebElements(args));
    }

    public WebElement getFast() {
        return getEl(getContext(this));
    }
    public List<WebElement> getListFast() {
        return getEls(getContext(this));
    }
    public WebElement seleniumElement() {
        return getEl(driver());
    }
    public List<WebElement> seleniumList() {
        return getEls(driver());
    }

    private WebElement getEl(SearchContext ctx) {
        return ctx.findElement(correctXPaths(getLocator()));
    }
    private List<WebElement> getEls(SearchContext ctx) {
        return ctx.findElements(correctXPaths(getLocator()));
    }

    public List<WebElement> getList(int minAmount) {
        List<WebElement> result = timer().getResultByCondition(this::tryGetList,
                els -> els.size() >= minAmount);
        if (result == null)
            throw exception("Expected at least %s elements but failed (%s)", minAmount, toString());
        return filterElements(this, result);
    }
    protected List<WebElement> tryGetList() {
        List<WebElement> elements = getAll();
        if (elements == null)
            throw exception("No elements found (%s)", toString());
        if (elements.size() == 1)
            elements = processListTag(elements);
        return elements;
    }
    protected List<WebElement> processListTag(List<WebElement> elements) {
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
    public WebList list(Object... args) {
        return $$(getAll(args), getName());
    }
    public <TE extends IBaseElement> void waitAction(int sec, JAction1<TE> action, Class<TE> type) {
        waitFunc(sec, j -> { action.execute(j); return this; }, type);
    }
    public <TE extends IBaseElement, TR> TR waitFunc(int sec, JFunc1<TE, TR> action, Class<TE> type) {
        int temp = getTimeout();
        TR result;
        try {
            waitSec(sec);
            result = action.execute((TE) this);
        }
        finally {
            waitSec(temp);
            dropToGlobalTimeout();
        }
        return result;
    }
    public <T> T waitFunc(int sec, JFunc<T> func) {
        return waitFunc(sec, j -> func.execute(), IBaseElement.class);
    }
    public <T> T noWait(JFunc<T> func) {
        return waitFunc(0, func);
    }
    public <T> T noWait() {
        return (T) waitSec(0);
    }
    public <TE extends IBaseElement, TR> TR noWait(JFunc1<TE, TR> action, Class<TE> type) {
        return waitFunc(0, action, type);
    }
    public void dropToGlobalTimeout() {
        waitSec(TIMEOUTS.element.get());
    }
    public boolean hasLocator() {
        return !locator.isNull();
    }

    public String printContext() {
        JDIBase jdiBase = getBase(parent);
        if (jdiBase == null) return "";
        String locator = jdiBase.locator.printLocator();
        if (jdiBase.parent == null)
            return locator;
        if (isBlank(locator))
            return jdiBase.printContext();
        return jdiBase.printContext() + ">" + locator;
    }
    public String printFullLocator() {
        return parent == null || isBlank(printContext())
                ? locator.printLocator()
                : printContext() + ">" + locator.printLocator();
    }
    private void initContext() {
        context = printFullLocator();
    }

    @Override
    public String toString() {
        initContext();
        try {
            return PRINT_ELEMENT.execute(this);
        } catch (Exception ex) { throw exception(ex, "Can't print element"); }
    }
    public static String printWebElement(WebElement element) {
        String asString = element.toString().replaceAll("css selector", "css");
        String result = asString.startsWith("WebElement->")
                ? "" : "WebElement->";
        if (asString.contains(")]")) {
            String s = asString.substring(asString.indexOf("-> ")+3).replaceAll("]* -> ", "->");
            return result + s.substring(0,s.length()-1);
        }
        return asString;
    }
    public String printWebElement() {
        if (webElement.hasValue())
            return printWebElement(webElement.get());
        if (webElements.hasValue() && webElements.get().size() > 0)
            return printWebElement(webElements.get().get(0));
        return "";
    }
    public static JFunc1<JDIBase, String> PRINT_ELEMENT = element -> {
        if (element.webElement.hasValue())
            return element.printWebElement();
        if (isBlank(element.varName))
            return element.context;
        return Switch(LOGS.logLevel).get(
                Case(l -> l == STEP,
                    l -> msgFormat(PRINT_ELEMENT_STEP, element)),
                Case(l -> l == INFO,
                    l -> msgFormat(PRINT_ELEMENT_INFO, element)),
                Case(l -> l == ERROR,
                    l -> msgFormat(PRINT_ERROR_STEP, element)),
                Default(l -> msgFormat(PRINT_ELEMENT_DEBUG, element))
        );
    };

    public void actions(JFunc2<Actions, WebElement, Actions> action) {
        action.execute(actions.get(), get()).build().perform();
    }
    public void actions(JFunc1<Actions, Actions> action) {
        action.execute(actions.get()).build().perform();
    }
    public void actionsWithElement(JFunc2<Actions, WebElement, Actions> action) {
        action.execute(actions.get().moveToElement(get()), get()).build().perform();
    }
    public void actionsWithElement(JFunc1<Actions, Actions> action) {
        action.execute(actions.get().moveToElement(get())).build().perform();
    }
    private Safe<Actions> actions = new Safe<>(() -> new Actions(driver()));

    public ElementArea clickAreaType = ELEMENT.clickType;
    public TextTypes textType = ELEMENT.getTextType;
    public SetTextTypes setTextType = ELEMENT.setTextType;

    public void offCache() {
        webElement.useCache(false);
        webElements.useCache(false);
    }
    public boolean isUseCache() { return webElement.isUseCache() || webElements.isUseCache(); }
}
