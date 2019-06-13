package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDILocator;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.HasCache;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.MessageFormat;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.OutputTemplates.*;
import static com.epam.jdi.light.elements.init.InitActions.isPageObject;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class JDIBase extends DriverBase implements IWebBaseElement, HasValue, HasUIBase, HasCache {
    public JDIBase element() { return this; }
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
    public <T extends JDIBase> T noValidation() {
        return setSearchRule(ANY_ELEMENT);
    }
    public <T extends JDIBase> T onlyVisible() {
        return setSearchRule(VISIBLE_ELEMENT);
    }
    public <T extends JDIBase> T onlyEnabled() { return setSearchRule(ENABLED_ELEMENT); }
    public <T extends JDIBase> T setSearchRule(JFunc1<WebElement, Boolean> rule) {
        searchRule.setForce(rule);
        return (T) this;
    }
    public UIElement setWebElement(WebElement el) {
        webElement.setForce(el);
        return isClass(getClass(), UIElement.class) ? (UIElement) this : new UIElement();
    }
    public void setWebElements(List<WebElement> els) {
        webElements.setForce(els);
    }

    public <T extends JDIBase> T setLocator(By locator) {
        if (name.isEmpty()) name = shortBy(locator);
        this.locator = new JDILocator(locator, this);
        return (T) this;
    }
    public <T extends JDIBase> T setFrame(By locator) {
        if (name.isEmpty()) name = shortBy(locator);
        this.locator = new JDILocator(locator, FRAME, this);
        return (T) this;
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

    private SearchContext getSearchContext(Object element) {
        JDIBase bElement = (JDIBase) element;
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
                || !isClass(parent.getClass(), JDIBase.class);
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
        if (!isClass(parent.getClass(), JDIBase.class))
            return "";
        JDIBase jdiBase = (JDIBase)parent;
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
    public String jsExecute(String text) {
        return valueOf(js().executeScript("return arguments[0]."+text+";", get()));
    }

    public Select select() {
        WebElement select = get();
        if (!select.getTagName().equals("select")) {
            List<WebElement> els = select.findElements(By.tagName("select"));
            if (els.size() > 0)
                select = els.get(0);
            else
                throw exception("Element should point to <select> tag in order to use Selenium Select");
        }
        return new Select(select);
    }

    /**
     * Get element location point
     * @return Point
     */
    @JDIAction("Click on '{name}'")
    public void click() {
        get().click();
    }

    /**
     * Get attribute innerText'
     * @return String
     */
    @JDIAction("Get '{name}' text")
    public String innerText() {
        return jsExecute("innerText");
    }
    public String text() { return getText(); }
    @JDIAction("Get '{name}' text")
    public String getText() {
        WebElement el = get();
        String text = el.getText();
        if (isNotBlank(text))
            return text;
        String value = el.getAttribute("value");
        return isNotBlank(value) ? value : text;
    }
    @JDIAction(level = DEBUG)
    public Point getLocation() {
        return get().getLocation();
    }

    /**
     * Get element size
     * @return Dimension
     */
    @JDIAction(level = DEBUG)
    public Dimension getSize() {
        return get().getSize();
    }

    /**
     * Get element rectangle
     * @return Rectangle
     */
    @JDIAction(level = DEBUG)
    public Rectangle getRect() {
        return get().getRect();
    }

    /**
     * Get element css value
     * @param value
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String getCssValue(String value) {
        return get().getCssValue(value);
    }
    public String css(String prop) {
        return getCssValue(prop);
    }
    @JDIAction(level = DEBUG)
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return get().getScreenshotAs(outputType);
    }

    /**
     * Get the attribute value
     * @param value
     * @return String
     */
    @JDIAction(value = "Get '{name}' attribute '{0}'", level = DEBUG)
    public String getAttribute(String value) {
        return valueOrDefault(get().getAttribute(value), "");
    }

    public String attr(String value) { return getAttribute(value); }

    /**
     * Check the element is enable
     * @return boolean
     */
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return enabled();
    }

    /**
     * Check the element is disable
     * @return boolean
     */
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !enabled();
    }
    private boolean enabled() {
        List<String> cls = classes();
        return cls.contains("active") ||
                get().isEnabled() && !cls.contains("disabled");
    }

    /**
     * Check the element is displayed
     * @return boolean
     */
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return displayed();
    }

    /**
     * Check the element is hidden
     * @return boolean
     */
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !displayed();
    }
    public boolean displayed() {
        try {
            if (webElement.hasValue())
                return webElement.get().isDisplayed();
            if (locator.isEmpty()) {
                WebElement element = SMART_SEARCH.execute(this);
                return element != null && element.isDisplayed();
            }
            List<WebElement> result = getAll();
            return result.size() == 1 && result.get(0).isDisplayed();
        } catch (Exception ex) { return false; }
    }

    /**
     * Set the text in the attribute "value"
     * @param value
     */
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        //setAttribute("value", value);
        jsExecute("value='"+value+"'");
    }

    /**
     * Set the value in the specified attribute
     * @param name
     * @param value
     */
    @JDIAction(level = DEBUG)
    public void setAttribute(String name, String value) {
        jsExecute("setAttribute('"+name+"','"+value+"')");
    }
    public MapArray<String, String> getAllAttributes() {
        List<String> jsList;
        try {
            jsList = (List<String>) js().executeScript("var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + '=\"' + a.value + '\"'); } ; return s;", get());
            return new MapArray<>(jsList, r -> r.split("=")[0], r -> r.split("=")[1].replace("\"", ""));
        } catch (Exception ignore) { return new MapArray<>(); }
    }
    public MapArray<String, String> attrs() { return getAllAttributes(); }

    public List<String> classes() {
        return asList(getAttribute("class").split(" "));
    }
    public boolean hasClass(String className) {
        return classes().contains(className);
    }

    /**
     * Get the element tag name
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String getTagName() {
        return get().getTagName();
    }

    /**
     * Get the element attribute "innerHTML" value
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String printHtml() {
        return MessageFormat.format("<{0} {1}>{2}</{0}>", getTagName(),
                print(getAllAttributes(), el -> format("%s=\"%s\"", el.key, el.value), " "),
                getAttribute("innerHTML"));
    }

    /**
     * Make a border the specified color
     * @param color
     */
    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        jsExecute("style.border='3px dashed "+color+"'");
    }
    public void highlight() {
        show();
        highlight("red");
    }

    /**
     * Get screenshot with red border
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String makePhoto() {
        highlight();
        return takeScreen();
    }

    /**
     * Show all items
     */
    @JDIAction
    public void show() {
        jsExecute("scrollIntoView(true)");
    }

    /**
     * Hover over the element
     */
    @JDIAction("Hover to '{name}'")
    public void hover() {
        doActions(a -> a.moveToElement(get()));
    }

    //region Actions
    /**
     * Drag element and drop it to the UI element
     * @param to
     */
    @JDIAction("Drag '{name}' and drop it to '{0}'")
    public void dragAndDropTo(UIElement to) {
        doActions(a -> a.clickAndHold(get()).moveToElement(to).release(to));
    }

    /**
     * Double click on the element
     */
    @JDIAction("DoubleClick on '{name}'")
    public void doubleClick() {
        doActions(Actions::doubleClick);
    }

    /**
     * Right click on the element
     */
    @JDIAction("RightClick on '{name}'")
    public void rightClick() {
        doActions(Actions::contextClick);
    }

    /**
     * Drag element and drop it to certain coordinates
     * @param x
     * @param y
     */
    @JDIAction("Drag '{name}' and drop it to ({0},{1})")
    public void dragAndDropTo(int x, int y) {
        doActions(a -> a.dragAndDropBy(get(), x, y));
    }
    private Actions actions = null;
    private Actions actionsClass() {
        if (actions == null)
            actions = new Actions(driver());
        return actions;
    }
    public void doActions(JFunc1<Actions, Actions> actions) {
        actions.execute(actionsClass()).build().perform();
    }
    public void actions(JFunc1<Actions, Actions> actions) {
        actions.execute(actionsClass().moveToElement(get())).build().perform();
    }

    public String getValue() {
        return getText();
    }
    //endregion

    //region Asserts
    public IsAssert is() {
        return new IsAssert(this);
    }
    public IsAssert assertThat() {
        return is();
    }
    public IsAssert has() {
        return is();
    }
    public IsAssert waitFor() {
        return is();
    }
    public IsAssert shouldBe() {
        return is();
    }
    public IsAssert verify() {
        assertSoft();
        return is();
    }
    //endregion

    public void offCache() {
        webElement.useCache(false);
        webElements.useCache(false);
        searchRule.useCache(false);
    }
}
