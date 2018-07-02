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
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class JDIBase extends DriverBase implements INamed {
    public String name;
    public String varName;
    public String typeName;
    public Object parent;
    protected By byLocator;
    private CacheValue<WebElement> webElement = new CacheValue<>();
    protected LocatorType locatorType = DEFAULT;
    public JFunc1<WebElement, Boolean> searchRule = SEARCH_CONDITION;
    public void setName(String varName, String className) {
        this.name = splitCamelCase(varName);
        this.varName = className + "." + varName;
    }
    public void setWebElement(WebElement el) { webElement.setForce(el); }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getName() {
        return isBlank(name) ? getClass().getSimpleName() : name;
    }

    public WebPage getPage() {
        if (parent == null) return null;
        if (isClass(parent.getClass(), WebPage.class))
            return (WebPage) parent;
        if (!isClass(parent.getClass(), JDIBase.class)) return null;
        return ((JDIBase)parent).getPage();
    }

    public void setLocator(By locator) {
        locatorType = DEFAULT;
        byLocator = locator;
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

    public WebElement get(String... args) {
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
    protected WebElement getWebElement(Object... args) {
        List<WebElement> result = getWebElements(args);
        return result.size() > 0 ? result.get(0) : null;
    }

    public List<WebElement> getAll(Object... args) {
        return filter(getWebElements(args), el -> searchRule.invoke(el));
    }
    protected List<WebElement> getWebElements(Object... args) {
        SearchContext searchContext = containsRoot(getLocator(args))
            ? getDefaultContext()
            : getSearchContext(parent);
        return searchContext.findElements(correctLocator(getLocator(args)));
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
        return getDriver().switchTo().frame(getDriver().findElement(frame));
    }
    private SearchContext getDefaultContext() {
        return getDriver().switchTo().defaultContent();
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
