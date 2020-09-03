package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.HasCache;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.JDIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.*;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.common.TextTypes.LABEL;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH;
import static com.epam.jdi.light.settings.WebSettings.STRICT_SEARCH;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class JDIBase extends DriverBase implements IBaseElement, HasCache {
    public static JFunc1<String, String> STRING_SIMPLIFY =
        s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

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
    private MapArray<String, JFunc1<WebElement, Boolean>> searchRules() {
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

    public static final String FAILED_TO_FIND_ELEMENT_MESSAGE
            = "Can't find Element '%s' during %s seconds";
    public static final String FIND_TO_MUCH_ELEMENTS_MESSAGE
            = "Found %s elements instead of one for Element '%s' during %s seconds";
    public static final String ELEMENTS_FILTERED_MESSAGE
            = "Found %s elements but none pass results filtering. Please change locator or filtering rules (JDISettings.ELEMENT.searchRule = )" +
            LINE_BREAK + "Element '%s' search during %s seconds";

    public WebElement getWebElement() {
        return get(new Object[]{});
    }
    public WebElement get() {
        WebElement element = get(new Object[]{});
        VALIDATE_FOUND_ELEMENT.execute(this, element);
        return element;
    }
    public static JAction2<JDIBase, WebElement> VALIDATE_FOUND_ELEMENT = JDIBase::validateFoundElement;
    private static void validateFoundElement(JDIBase base, WebElement element) {
        for (JFunc1<WebElement, Boolean> rule : base.searchRules().values())
            if (!rule.execute(element))
                throw exception("Search rules failed for element. Please check base().searchRules() for element or in global settings(JDISettings.ELEMENT.searchRule)");
    }
    protected JFunc<WebElement> getElementFunc = null;
    public JDIBase setGetFunc(JFunc<WebElement> func) {
        getElementFunc = func;
        return this;
    }
    private WebElement purify(WebElement element) {
        return isInterface(element.getClass(), IBaseElement.class)
            ? ((IBaseElement)element).base().get()
            : element;
    }
    private UIElement getUIElementByLocator(WebElement element) {
        return new UIElement(element).find(getLocator()).setup(b -> {
            b.searchRules = searchRules;
            b.timeout = timeout;
        });
    }
    public WebElement get(Object... args) {
        return ELEMENT.getElementWithArgs.execute(this, args);
    }
    UIElement getWebListFromArgs(Object... args) {
        if (locator.argsCount() == 0 && args.length == 1) {
            if (args[0].getClass() == String.class)
                return new WebList(this).get(args[0].toString());
            if (isClass(args[0].getClass(), Enum.class))
                return new WebList(this).get(getEnumValue((Enum<?>)args[0]));
        }
        throw exception("Can't get element with template locator '%s'. Expected %s arguments but found %s", getLocator(), locator.argsCount(), args.length);
    }
    WebElement getCachedElement() {
        WebElement element = purify(webElement.get());
        try {
            element.getTagName();
            if (locator.isNull())
                return element;
            return purify(getUIElementByLocator(element));
        } catch (Exception ignore) {
            if (getElementFunc == null) {
                webElement.clear();
                return null;
            } else {
                return webElement.set(purify(getElementFunc.execute()));
            }
        }
    }
    public Boolean strictSearch;
    public void strictSearch(boolean strictSearch) {
        this.strictSearch = strictSearch;
    }
    WebElement getElement(List<WebElement> els) {
        if (els.size() == 1)
            return els.get(0);
        if (els.isEmpty())
            throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), getTimeout());
        List<WebElement> filtered = filterElements(els);
        if (filtered.size() == 1)
            return filtered.get(0);
        if ((strictSearch == null && STRICT_SEARCH) || (strictSearch != null && strictSearch))
            throw exception(FIND_TO_MUCH_ELEMENTS_MESSAGE, els.size(), toString(), getTimeout());
        return (filtered.size() > 1 ? filtered : els).get(0);
    }
    private List<WebElement> filterElements(List<WebElement> elements) {
        List<WebElement> result = elements;
        for (JFunc1<WebElement, Boolean> rule : searchRules().values())
            result = filter(result, rule::execute);
        if (result.size() == 0 && textType == LABEL)
            return elements;
        return result;
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
    public List<WebElement> getWebElements(Object... args) {
        return noValidation(() -> getAll(args));
    }
    public List<WebElement> getAll(Object... args) {
        return getAllElements(args);
    }
    public List<WebElement> getAllElements(Object... args) {
        getDefaultContext();
        if (webElements.hasValue()) {
            List<WebElement> elements = map(webElements.get(), this::purify);
            try {
                beforeSearch(elements.get(0)).getTagName();
                return elements;
            } catch (Exception ignore) { webElements.clear(); }
        }
        if (locator.isNull())
            return singletonList(beforeSearch(getSmart()));
        SearchContext searchContext = getContext(parent, locator);
        List<WebElement> result = uiSearch(searchContext, correctLocator(getLocator(args)));
        if (result.size() > 0)
            beforeSearch(result.get(0));
        return result;
    }
    public WebElement getFast() {
        return getEl(getContext(parent, locator));
    }
    public List<WebElement> getListFast() {
        return getEls(getContext(parent, locator));
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
        return filterElements(result);
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
    private JDIBase getBase(Object element) {
        if (isClass(element.getClass(), JDIBase.class))
            return  (JDIBase) element;
        else {
            if (isInterface(element.getClass(), IBaseElement.class))
                return  ((IBaseElement) element).base(); }
        return null;
    }
    private SearchContext getSearchContext(Object parent) {
        JDIBase base = getBase(parent);
        if (base == null)
            return getDefaultContext();
        if (base.webElement.hasValue())
            return base.webElement.get();
        if (base.locator.isRoot() && base.locator.isNull())
            return getDefaultContext();
        List<By> frames = base.getFrames();
        if (frames != null)
            return getFrameContext(frames);
        By byLocator = base.getLocator();
        IBaseElement asBaseElement = (IBaseElement) parent;
        return byLocator == null || isBlank(getByLocator(byLocator))
                ? getSmartSearchContext(asBaseElement)
                : getContextByLocator(base, byLocator);
    }
    private SearchContext getContextByLocator(JDIBase base, By locator) {
        List<WebElement> els = uiSearch(getContext(base.parent, base.locator), correctLocator(locator));
        return getElement(els);
    }

    private SearchContext getSmartSearchContext(IBaseElement bElement) {
        try {
            WebElement result = SMART_SEARCH.execute(bElement);
            if (result != null)
                return result;
        } catch (Exception ignore) { }
        return getContext(bElement.base().parent, bElement.base().locator);
    }
    private boolean isRoot(Object parent) {
        return parent == null || isClass(parent.getClass(), WebPage.class)
            || !isInterface(parent.getClass(), JDIElement.class);
    }
    public boolean hasLocator() {
        return !locator.isNull();
    }
    private SearchContext getContext(Object parent, JDILocator locator) {
        List<By> frames = getFrames();
        if (frames != null)
            return getFrameContext(frames);
        return locator.isRoot || isRoot(parent)
                ? getDefaultContext()
                : getSearchContext(parent);
    }
    private SearchContext getFrameContext(List<By> frames) {
        WebDriver driver = driver();
        for (By frame : frames)
            try {
                driver = driver.switchTo().frame(uiSearch(driver, getFrameLocator(frame, driver)).get(0));
            } catch (Exception ex) {
                throw exception(ex, "Can't find frame by locator: '%s'", frame);
            }
        return driver;
    }
    private By getFrameLocator(By frame, WebDriver driver) {
        try {
            driver.findElement(frame).getTagName();
            return frame;
        } catch (Exception ignore) {
            return By.id(getByLocator(frame));
        }
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
        String locator = jdiBase.getLocator() == null
                ? ""
                : jdiBase.locator.printLocator();
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
    public boolean isUseCache() { return webElement.isUseCache() && webElements.isUseCache(); }
}