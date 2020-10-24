package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.init.rules.AnnotationRule;
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

import java.lang.annotation.Annotation;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.JdiSettings.*;
import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.InitActions.defaultSetup;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
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
        timeout = new Safe<>(() -> base.timeout.get());
        waitAfterTimeout = new Safe<>(() -> base.waitAfterTimeout.get());
        waitAfterMethod = base.waitAfterMethod;
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
    public void setup(SiteInfo info) {
        defaultSetup(info, this);
        if (parent != null && isClass(parent.getClass(), IBaseElement.class)) {
            JDIBase parentBase = ((IBaseElement)parent).base();
            searchRules = parentBase.searchRules.copy();
        }
        if (info.field != null) {
            for (Pair<String, AnnotationRule> aRule : JDI_ANNOTATIONS) {
                try {
                    Class<? extends Annotation> annotation = aRule.value.annotation;
                    if (hasAnnotation(info.field, annotation))
                        aRule.value.action.execute(this, info.field.getAnnotation(annotation), info.field);
                } catch (Exception ex) {
                    throw exception(ex, "Setup element '%s' with Annotation '%s' failed", info.name(), aRule.key);
                }
            }
        }
    }

    public JDIBase doBefore(JAction1<UIElement> action) { beforeSearch = action; return this; }
    public JDIBase showBefore() { beforeSearch = UIElement::show; return this; }
    public JDIBase noValidation() {
        return setSearchRule("Any", ANY_ELEMENT);
    }
    public <T> T noValidation(JFunc<T> func) {
        MapArray<String, JFunc1<WebElement, Boolean>> tempRules = searchRules.copy();
        searchRules.clear();
        T result;
        try {
            result = func.execute();
        } finally {
            searchRules = tempRules;
        }
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
    @JDebug
    public JDIBase setWebElement(WebElement el) {
        webElement.setForce(el);
        return this;
    }
    @JDebug
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

    protected Safe<Integer> timeout = new Safe<>(() -> -1);
    protected Safe<Integer> waitAfterTimeout = new Safe<>(() -> -1);
    protected String waitAfterMethod = "";
    public IBaseElement waitAfter(int timeout, String methodName) {
        waitAfterTimeout = new Safe<>(() -> timeout > 0 ? timeout : 1);
        if (isNotBlank(methodName))
            waitAfterMethod = methodName;
        return this;
    }
    public Pair<String, Integer> waitAfter() {
        return new Pair<>(waitAfterMethod, waitAfterTimeout.get());
    }
    public void setTimeout(int sec) {
        timeout = new Safe<>(() -> sec);
    }
    @Override
    public IBaseElement waitSec(int sec) {
        timeout.set(sec);
        return this;
    }
    public int getTimeout() {
        int t = timeout.get();
        return t > -1 ?  t: TIMEOUTS.element.get();
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
    @JDebug
    public WebElement getWebElement() {
        return ELEMENT.getElementWithArgs.execute(this, new Object[]{});
    }

    // Get Web Element using Search Rules and wait
    @JDebug
    public WebElement get() {
        return get(new Object[]{});
    }
    protected JFunc<WebElement> getElementFunc = null;
    public JDIBase setGetFunc(JFunc<WebElement> func) {
        getElementFunc = func;
        return this;
    }
    @JDebug
    public WebElement get(Object... args) {
        return ELEMENT.getElementAndValidate.execute(this, args);
    }

    protected Boolean strictSearch;
    public void strictSearch(boolean strictSearch) {
        this.strictSearch = strictSearch;
    }
    @JDebug
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
    @JDebug
    public List<WebElement> getWebElements(Object... args) {
        List<WebElement> elements = getAllWebElements(args);
        if (elements.size() > 0) {
            beforeSearch(elements.get(0));
        }
        return elements;
    }
    @JDebug
    private List<WebElement> getAllWebElements(Object... args) {
        getDefaultContext(driver());
        if (webElements.hasValue()) {
            List<WebElement> elements = map(webElements.get(), JdiSettings::purify);
            if (elements.size() > 0) {
                try {
                    elements.get(0).getTagName();
                    return elements;
                } catch (Exception ignore) {
                    webElements.clear();
                }
            }
        }
        if (locator.isNull())
            return singletonList(getSmart());
        return getAllElementsInContext(this, args);
    }
    @JDebug
    public List<WebElement> getAll(Object... args) {
        return filterElements(this, getWebElements(args));
    }

    @JDebug
    public WebElement getFast() {
        return getEl(getContext(this));
    }
    @JDebug
    public List<WebElement> getListFast() {
        return getEls(getContext(this));
    }
    @JDebug
    public WebElement seleniumElement() {
        return getEl(driver());
    }
    @JDebug
    public List<WebElement> seleniumList() {
        return getEls(driver());
    }

    @JDebug
    private WebElement getEl(SearchContext ctx) {
        return ctx.findElement(correctXPaths(getLocator()));
    }
    @JDebug
    private List<WebElement> getEls(SearchContext ctx) {
        return ctx.findElements(correctXPaths(getLocator()));
    }

    @JDebug
    public List<WebElement> getList(int minAmount) {
        List<WebElement> result = timer().getResultByCondition(this::tryGetList,
            els -> els.size() >= minAmount);
        if (result == null)
            throw exception("Expected at least %s elements but failed (%s)", minAmount, toString());
        List<WebElement> l = filterElements(this, result);
        return l;
    }
    @JDebug
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
        try {
            initContext();
            return PRINT_ELEMENT.execute(this);
        } catch (Exception ex) {
            return "Can't print element";
        }
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
            return printWebElement(webElements.get().get(0)) + "[" + webElements.get().size() + "]";
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
