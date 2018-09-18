package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.LocatorType;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.INamed;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.LocatorType.DEFAULT;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class JDIBase extends DriverBase implements INamed {
    public static JFunc1<String, String> STRING_SIMPLIFY = s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    protected By byLocator;
    private CacheValue<WebElement> webElement = new CacheValue<>();
    protected LocatorType locatorType = DEFAULT;
    public JFunc1<WebElement, Boolean> searchRule = SEARCH_CONDITION;
    public <T extends JDIBase> T setWebElement(WebElement el) { webElement.setForce(el); return (T)this; }

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
    public By getFrame() { return locatorType == FRAME ? byLocator : null; }

    public void setFrame(By locator) {
        locatorType = FRAME;
        byLocator = locator;
    }

    public static final String FAILED_TO_FIND_ELEMENT_MESSAGE
            = "Can't find Element '%s' during %s seconds";
    public static final String FIND_TO_MUCH_ELEMENTS_MESSAGE
            = "Find %s elements instead of one for Element '%s' during %s seconds";

    public WebElement get(Object... args) {
        // TODO SAVE GET ELEMENT AND STALE ELEMENT PROCESS
        if (webElement.hasValue())
            return webElement.get();
        List<WebElement> result = getAll(args);
        switch (result.size()) {
            case 0:
                throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT);
            case 1:
                return result.get(0);
            default:
                throw exception(FIND_TO_MUCH_ELEMENTS_MESSAGE, result.size(), toString(), TIMEOUT);
        }
    }
    public UIElement getUI(Object... args) {
        return new UIElement().setWebElement(get(args));
    }

    public List<WebElement> getAll(Object... args) {
        SearchContext searchContext = containsRoot(getLocator(args))
                ? getDefaultContext()
                : getSearchContext(parent);
        List<WebElement> els = searchContext.findElements(correctLocator(getLocator(args)));
        return filter(els, el -> searchRule.invoke(el));
    }
    public List<UIElement> allUI(Object... args) {
        return map(getAll(args), el -> new UIElement().setWebElement(el));
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
            : getContext(parent, locator);
        return locator != null
            ? searchContext.findElement(correctLocator(locator))
            : searchContext;
    }
    private boolean isRoot(Object parent) {
        return parent == null || isClass(parent.getClass(), WebPage.class)
                || !isClass(parent.getClass(), JDIBase.class);
    }
    private SearchContext getContext(Object parent, By locator) {
        return isRoot(parent) || containsRoot(locator)
                ? getDefaultContext()
                : getSearchContext(parent);
    }
    private SearchContext getFrameContext(By frame) {
        return driver().switchTo().frame(driver().findElement(frame));
    }
    private SearchContext getDefaultContext() {
        return driver().switchTo().defaultContent();
    }
    private By correctLocator(By locator) {
        if (locator == null) return null;
        return correctXPaths(containsRoot(locator)
                ? trimRoot(locator)
                : locator);
    }

    public String printContext() {
        if (!isClass(parent.getClass(), JDIBase.class))
            return "";
        JDIBase jdiBase = (JDIBase)parent;
        return jdiBase.getLocator() == null ? "" : jdiBase.printLocator();
    }
    private String context;
    private String printFullLocator() {
        return parent == null || isBlank(printContext())
            ? printLocator()
            : printContext() + ">" + printLocator();
    }
    private String locator;
    private String printLocator() {
        if (!hasDomain() && locatorType == DEFAULT)
            return "No Locators";
        String isFrame = "";
        By locator = getLocator();
        if (locatorType == FRAME) {
            isFrame = "Frame: ";
            locator = getFrame();
        }
        return isFrame + shortBy(locator);
    }

    @Override
    public String toString() {
        if (locator == null) locator = printLocator();
        if (context == null) context = printFullLocator();
        return Switch(logger.getLogLevel()).get(
            Case(l -> l == STEP,
                l -> msgFormat(PRINT_ELEMENT_STEP, this)),
            Case(l -> l == INFO,
                l -> msgFormat(PRINT_ELEMENT_INFO, this)),
            Default(l -> msgFormat(PRINT_ELEMENT_DEBUG, this))
        );
    }
    public void jsExecute(String text) {
        js().executeScript("arguments[0]."+text+";", get());
    }
}
