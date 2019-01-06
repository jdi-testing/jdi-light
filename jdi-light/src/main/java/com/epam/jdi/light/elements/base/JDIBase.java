package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.LocatorType;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.INamed;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.LocatorType.DEFAULT;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.OutputTemplates.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitHythen;
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

public class JDIBase extends DriverBase implements INamed {
    public static JFunc1<String, String> STRING_SIMPLIFY = s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    protected By byLocator;
    protected CacheValue<WebElement> webElement = new CacheValue<>();
    protected LocatorType locatorType = DEFAULT;
    public JFunc1<WebElement, Boolean> searchRule = SEARCH_CONDITION;
    public boolean isRootLocator = false;
    public static Timer timer () { return new Timer(TIMEOUT.get()*1000); }
    public UIElement setWebElement(WebElement el) {
        webElement.setForce(el);
        return isClass(getClass(), UIElement.class) ? (UIElement) this : new UIElement();
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
    public By getFrame() { return locatorType == FRAME ? byLocator : null; }

    public void setFrame(By locator) {
        locatorType = FRAME;
        byLocator = locator;
    }

    public static final String FAILED_TO_FIND_ELEMENT_MESSAGE
            = "Can't find Element '%s' during %s seconds";
    public static final String FIND_TO_MUCH_ELEMENTS_MESSAGE
            = "Find %s elements instead of one for Element '%s' during %s seconds";

    public WebElement get() {
        return get(new Object[]{});
    }
    public WebElement get(Object... args) {
        // TODO SAFE GET ELEMENT AND STALE ELEMENT PROCESS
        if (webElement.hasValue())
            return webElement.get();
        if (byLocator == null) {
            try {
                WebElement element = SMART_SEARCH.execute(this);
                if (element != null)
                    return element;
                throw exception("");
            } catch (Exception ex) {
                throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
            }
        }
        List<WebElement> result = getAll(args);
        if (result.size() == 0)
            throw exception(FAILED_TO_FIND_ELEMENT_MESSAGE, toString(), TIMEOUT.get());
        if (result.size() > 1)
            result = LinqUtils.filter(result, el -> searchRule.execute(el));
        if (result.size() == 1)
            return result.get(0);
        throw exception(FIND_TO_MUCH_ELEMENTS_MESSAGE, result.size(), toString(), TIMEOUT.get());
    }
    public UIElement<UIElement> getUI(Object... args) {
        return new UIElement<>(get(args));
    }

    public List<WebElement> getAll(Object... args) {
        //TODO rethink SMART SEARCH
        if (byLocator == null)
            return asList(SMART_SEARCH.execute(this));
        SearchContext searchContext = isRootLocator
                ? getDefaultContext()
                : getSearchContext(parent);
        List<WebElement> els = uiSearch(searchContext, correctLocator(getLocator(args)));
        return filter(els, el -> searchRule.invoke(el));
    }

    public List<UIElement> allUI(Object... args) {
        return map(getAll(args), UIElement::new);
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
        String shortLocator = locator != null
            ? shortBy(locator)
            : print(select(SMART_SEARCH_LOCATORS, l -> format(l, splitHythen(name))), " or ");
        return isFrame + shortLocator;
    }

    @Override
    public String toString() {
        return PRINT_ELEMENT.execute(this);
    }
    public String toError() {
        return msgFormat(PRINT_ELEMENT_ERROR, this);
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
}
