package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.LocatorType;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.INamed;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.LocatorType.DEFAULT;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.common.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.OutputTemplates.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class JDIBase extends DriverBase implements BaseElement, INamed {
    public static JFunc1<String, String> STRING_SIMPLIFY = s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    protected By byLocator;
    public CacheValue<WebElement> webElement = new CacheValue<>();
    protected CacheValue<List<WebElement>> webElements = new CacheValue<>();
    protected LocatorType locatorType = DEFAULT;
    public JFunc1<WebElement, Boolean> searchRule = SEARCH_CONDITION;
    public boolean isRootLocator = false;
    public static Timer timer () { return new Timer(TIMEOUT.get()*1000); }
    public UIElement setWebElement(WebElement el) {
        webElement.setForce(el);
        return isClass(getClass(), UIElement.class) ? (UIElement) this : new UIElement();
    }
    public void setWebElements(List<WebElement> els) {
        webElements.setForce(els);
    }
    public <T extends JDIBase> T setLocator(By locator) {
        locatorType = DEFAULT;
        byLocator = locator;
        return (T) this;
    }
    public By getLocator(Object... args) {
        if (locatorType == FRAME) return null;
        if (isEmpty(args)) return byLocator;
        return args.length == 1
                ? fillByTemplate(byLocator, args)
                : fillByMsgTemplate(byLocator, args);
    }
    public boolean hasLocator() {
        return byLocator != null && locatorType == DEFAULT;
    }
    public By getFrame() { return locatorType == FRAME ? byLocator : null; }

    public void setFrame(By locator) {
        locatorType = FRAME;
        byLocator = locator;
    }

    public static final String FAILED_TO_FIND_ELEMENT_MESSAGE
            = "Can't find Element '%s' during %s seconds";
    public static final String FIND_TO_MUCH_ELEMENTS_MESSAGE
            = "Find %s elements instead of one for Element '%s' during %s seconds";
    public static final String ELEMENTS_FILTERED_MESSAGE
            = "Found %s elements but no one pass results filtering. Please change locator or filtering rules (WebSettings.SEARCH_CONDITION = el -> ...)" +
            LINE_BREAK + "Element '%s' search during %s seconds";

    public WebElement get() {
        return get(new Object[]{});
    }
    public WebElement get(Object... args) {
        // TODO SAFE GET ELEMENT AND STALE ELEMENT PROCESS
        if (webElement.hasValue())
            return webElement.get();
        if (!hasLocator()) {
            try {
                WebElement element = SMART_SEARCH.execute(this);
                if (element != null)
                    return element;
                throw exception("");
            } catch (Exception ex) {
                throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
            }
        }
        if (byLocator.toString().contains("%s") && args.length == 0)
            throw exception("Can't get element with template locator '%s' without arguments", byLocator);
        List<WebElement> result = getAll(args);
        if (result.size() == 0)
            throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
        if (result.size() > 1) {
            int found = result.size();
            List<WebElement> filtered = filter(result, el -> searchRule.execute(el));
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
        if (webElements.hasValue())
            return webElements.get();
        if (!hasLocator())
            return asList(SMART_SEARCH.execute(this));
        SearchContext searchContext = isRootLocator
                ? getDefaultContext()
                : getSearchContext(parent);
        List<WebElement> els = uiSearch(searchContext, correctLocator(getLocator(args)));
        return filter(els, el -> searchRule.invoke(el));
    }

    public WebList allUI(Object... args) {
        return new WebList(getAll(args)).setName(getName());
    }

    private SearchContext getSearchContext(Object element) {
        if (isRoot(element))
            return getDefaultContext();
        JDIBase bElement = (JDIBase) element;
        if (bElement.webElement.hasValue())
            return bElement.webElement.get();
        Object parent = bElement.parent;
        By locator = bElement.getLocator();
        By frame = bElement.getFrame();
        SearchContext searchContext = frame != null
            ? getFrameContext(frame)
            : getContext(parent, bElement.isRootLocator);
        //TODO rethink SMART SEARCH
        return locator != null
            ? uiSearch(searchContext, correctLocator(locator)).get(0)
            : searchContext;
    }
    private boolean isRoot(Object parent) {
        return parent == null || isClass(parent.getClass(), WebPage.class)
                || !isClass(parent.getClass(), JDIBase.class);
    }
    private SearchContext getContext(Object parent, boolean isRoot) {
        return isRoot || isRoot(parent)
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
        return jdiBase.getLocator() == null ? "" : jdiBase.printLocator();
    }
    private String context;
    public String printFullLocator() {
        return parent == null || isBlank(printContext())
            ? printLocator()
            : printContext() + ">" + printLocator();
    }
    private String locator;
    private String printLocator() {
        try {
            if (!hasDomain() && locatorType == DEFAULT)
                return "No Locators";
            String isFrame = "";
            By locator = getLocator();
            if (locatorType == FRAME) {
                isFrame = "Frame: ";
                locator = getFrame();
            }
            String shortLocator = locator != null
                    ? shortBy(locator)
                    : print(LinqUtils.select(SMART_SEARCH_LOCATORS, l -> format(l, splitHythen(name))), " or ");
            return isFrame + shortLocator;
        } catch (Exception ex) { throw exception("Can't print locator: " + ex.getMessage()); }
    }

    @Override
    public String toString() {
        try {
            return PRINT_ELEMENT.execute(this);
        } catch (Exception ex) { throw exception("Can't print element: " + ex.getMessage()); }
    }
    public String toError() {
        try {
            return msgFormat(PRINT_ELEMENT_ERROR, this);
        } catch (Exception ex) { throw exception("Can't print element for error: " + ex.getMessage()); }
    }
    public static JFunc1<JDIBase, String> PRINT_ELEMENT = element -> {
        if (element.locator == null) element.locator = element.printLocator();
        if (element.context == null) element.context = element.printFullLocator();
        return Switch(logger.getLogLevel()).get(
                Case(l -> l == STEP,
                    l -> msgFormat(PRINT_ELEMENT_STEP, element)),
                Case(l -> l == INFO,
                    l -> msgFormat(PRINT_ELEMENT_INFO, element)),
                Case(l -> l == ERROR,
                    l -> msgFormat(PRINT_ELEMENT_ERROR, element)),
                Default(l -> msgFormat(PRINT_ELEMENT_DEBUG, element))
        );
    };
    public String jsExecute(String text) {
        return valueOf(js().executeScript("arguments[0]."+text+";", get()));
    }

    public Select select() {
        return new Select(get());
    }
    @JDIAction(level = DEBUG)
    public Point getLocation() {
        return get().getLocation();
    }
    @JDIAction(level = DEBUG)
    public Dimension getSize() {
        return get().getSize();
    }
    @JDIAction(level = DEBUG)
    public Rectangle getRect() {
        return get().getRect();
    }
    @JDIAction(level = DEBUG)
    public String getCssValue(String s) {
        return get().getCssValue(s);
    }
    @JDIAction(level = DEBUG)
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return get().getScreenshotAs(outputType);
    }
    @JDIAction(value = "Get '{name}' attribute '{0}'", level = DEBUG)
    public String getAttribute(String value) {
        return valueOrDefault(get().getAttribute(value), "");
    }

    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return enabled();
    }
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !enabled();
    }
    public boolean enabled() {
        List<String> cls = classes();
        return cls.contains("active") ||
                get().isEnabled() && !cls.contains("disabled");
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return displayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !displayed();
    }
    public boolean displayed() {
        try {
            if (webElement.hasValue())
                return webElement.get().isDisplayed();
            if (byLocator == null) {
                WebElement element = SMART_SEARCH.execute(this);
                return element != null && element.isDisplayed();
            }
            List<WebElement> result = getAll();
            return result.size() == 1 && result.get(0).isDisplayed();
        } catch (Exception ex) { return false; }
    }

    @JDIAction("Set '{value}' in '{name}'")
    public void setText(String value) {
        //setAttribute("value", value);
        jsExecute("value='"+value+"'");
    }

    @JDIAction(level = DEBUG)
    public void setAttribute(String name, String value) {
        jsExecute("setAttribute('"+name+"','"+value+"')");
    }
    public List<String> getAllAttributes() {
        List<String> result;
        try {
            result = (List<String>) js().executeScript("var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + '=\"' + a.value + '\"'); } ; return s;", get());
        } catch (Exception ignore) { return new ArrayList<>(); }
        if (getAttribute("selected").equals("true"))
            result.add("selected");
        if (getAttribute("checked").equals("true"))
            result.add("checked");
        return result;
    }
    public List<String> classes() {
        return asList(getAttribute("class").split(" "));
    }
    public boolean hasClass(String className) {
        return classes().contains(className);
    }

    @JDIAction(level = DEBUG)
    public String getTagName() {
        return get().getTagName();
    }
    @JDIAction(level = DEBUG)
    public String printHtml() {
        return MessageFormat.format("<{0}{1}>{2}</{0}>", getTagName(),
                print(getAllAttributes(), el -> " "+ el), getAttribute("innerHTML"));
    }

    @JDIAction(level = DEBUG)
    public void higlight(String color) {
        jsExecute("style.border='3px dashed "+color+"'");
    }
    public void higlight() {
        show();
        higlight("red");
    }
    @JDIAction(level = DEBUG)
    public String makePhoto() {
        higlight();
        return takeScreen();
    }
    @JDIAction
    public void show() {
        jsExecute("scrollIntoView(true)");
    }
    @JDIAction("Hover to '{name}'")
    public void hover() {
        doActions(a -> a.moveToElement(get()));
    }
    //region Actions
    @JDIAction("Drag '{name}' and drop it to '{value}'")
    public void dragAndDropTo(UIElement to) {
        doActions(a -> a.clickAndHold(get()).moveToElement(to).release(to));
    }
    @JDIAction("DoubleClick on '{name}'")
    public void doubleClick() {
        doActions(Actions::doubleClick);
    }
    @JDIAction("RightClick on '{name}'")
    public void rightClick() {
        doActions(Actions::contextClick);
    }
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

    public boolean wait(JFunc1<BaseElement, Boolean> condition) {
        return new Timer(TIMEOUT.get()).wait(() -> condition.execute(this));
    }

    public String getValue() {
        return get().getText();
    }
    //endregion
}
