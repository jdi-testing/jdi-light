package com.epam.jdi.light.elements.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.common.ElementArea.BOTTOM_LEFT;
import static com.epam.jdi.light.common.ElementArea.BOTTOM_RIGHT;
import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;
import static com.epam.jdi.light.common.ElementArea.TOP_RIGHT;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.INNER;
import static com.epam.jdi.light.common.TextTypes.TEXT;
import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.switcher.SwitchActions.Case;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class UIElement extends JDIBase
        implements WebElement, SetValue, HasAssert<IsAssert>, IListBase,
        HasClick, IsText, HasLabel, HasPlaceholder, IsInput, HasCheck {
    public static JFunc1<UIElement, String> SMART_GET_TEXT = ui -> {
        String text = ui.text(TEXT);
        if (isNotBlank(text))
            return text;
        text = ui.text(INNER);
        if (isNotBlank(text))
            return text;
        text = ui.text(VALUE);
        return isNotBlank(text)
                ? text
                : isNotBlank(text) ? text : "";
    };
    public static JFunc1<UIElement, String> SMART_LIST_TEXT = ui -> {
        String text = ui.text(TEXT);
        if (isNotBlank(text))
            return text;
        text = ui.text(INNER);
        if (isNotBlank(text))
            return text;
        String id = ui.attr("id");
        if (isNotBlank(id)) {
            UIElement label = $(By.cssSelector("[for=" + id + "]"));
            label.waitSec(0);
            try {
                text = label.getText();
            } catch (Throwable ignore) { }
        }
        return isNotBlank(text) ? text : ui.text(VALUE);
    };
    //region Constructors
    public UIElement() { }
    public UIElement(WebElement el) { setWebElement(el); }
    public UIElement(List<WebElement> els) { setWebElements(els); }
    public UIElement(By locator) { setLocator(locator); }
    public UIElement(JDIBase base) {
        super(base);
    }
    public UIElement(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }
    public UIElement(JDIBase base, By locator, String name) {
        super(base);
        setLocator(locator);
        setName(name);
    }
    public UIElement(JDIBase base, WebElement el, JFunc<WebElement> func) {
        super(base);
        setWebElement(el);
        setGetFunc(func);
    }
    //endregion

    //region Core
    public UIElement core() { return this; }
    public UIElement setup(JAction1<JDIBase> setup) {
        return setup(UIElement.class, setup);
    }
    @Override
    public UIElement setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    @Override
    public UIElement setName(String name) {
        super.setName(name);
        return this;
    }

    //endregion

    //region WebElement
    /** Click on element */
    @JDIAction("Click on '{name}'") @Override
    public void click() {
        click(getClickType());
    }

    /** Submit form*/
    @JDIAction(level = DEBUG)
    public void submit() { get().submit(); }

    /**
     * Send specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'") @Override
    public void sendKeys(CharSequence... value) { get().sendKeys(value);}
    @Override
    public void clear() { get().clear();}

    /**
     * Get the element tag name
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String getTagName() {
        return getWebElement().getTagName();
    }

    /**
     * Get the attribute value
     * @param value
     * @return String
     */
    @JDIAction(value = "Get '{name}' attribute '{0}'", level = DEBUG)
    public String getAttribute(String value) {
        return valueOrDefault(getWebElement().getAttribute(value), "");
    }

    /**
     * Check that element is selected
     * @return boolean
     */
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return selected();
    }

    /**
     * Check the element is enabled
     * @return boolean
     */
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return enabled();
    }

    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return text(getTextType());
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
     * Get element location as Point
     * @return Point
     */
    @JDIAction(level = DEBUG)
    public Point getLocation() {
        return getWebElement().getLocation();
    }

    /**
     * Get element size
     * @return Dimension
     */
    @JDIAction(level = DEBUG)
    public Dimension getSize() {
        return getWebElement().getSize();
    }

    /**
     * Get element rectangle
     * @return Rectangle
     */
    @JDIAction(level = DEBUG)
    public Rectangle getRect() {
        return getWebElement().getRect();
    }

    /**
     * Get element css value
     * @param value
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String getCssValue(String value) {
        return getWebElement().getCssValue(value);
    }

    @JDIAction(level = DEBUG)
    public WebElement findElement(By locator) { return $(locator, this).getWebElement(); }
    @JDIAction(level = DEBUG)
    public List<WebElement> findElements(By locator) { return $(locator, this).getWebElements(); }

    /** Get screen screen shot */
    @JDIAction(level = DEBUG)
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWebElement().getScreenshotAs(outputType);
    }
    //endregion

    //region Extended functions
    /**
     * Execute Java Script call
     * @param jsCode
     */
    @JDIAction(value = "Execute javascript '{0}' for '{name}'", level = DEBUG)
    public String jsExecute(String jsCode) {
        return valueOf(js().executeScript("return arguments[0]."+ jsCode +";", getWebElement()));
    }

    /**
     * Input specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        clear();
        setText(value);
    }
    /**
     * Focus
     */
    @JDIAction(level = DEBUG) @Override
    public void focus(){ sendKeys(""); }
    /**
     * Set the text in the attribute "value"
     * @param value
     */
    @JDIAction("Set '{0}' in '{name}'") @Override
    public void setText(String value) {
        jsExecute("value='"+value.replace("'", "\\'")+"'");
    }

    public void click(int x, int y) {
        actionsWitElement((a, e) -> a.moveByOffset(x-getRect().width/2, y-getRect().height/2).click());
    }
    public void click(ElementArea area) {
        if (isDisabled())
            throw exception("Can't perform click. Element is disabled");
        switch (area) {
            case TOP_LEFT:
                click(1,1);
                logger.debug("Click Top Left");
                break;
            case TOP_RIGHT:
                click(getRect().getWidth()-1,1);
                logger.debug("Click Top Right");
                break;
            case BOTTOM_LEFT:
                click(1,getRect().getHeight()-1);
                logger.debug("Click Bottom Left");
                break;
            case BOTTOM_RIGHT:
                click(getRect().getWidth()-1,getRect().getHeight()-1);
                logger.debug("Click Bottom Right");
                break;
            case CENTER:
                get().click();
                break;
            case JS:
                jsExecute("click()");
                break;
            case SMART_CLICK:
                show();
                ElementArea clArea = timer().getResultByCondition(
                    this::getElementClickableArea, Objects::nonNull);
                if (clArea == null || clArea == CENTER) {
                    try {
                        get().click();
                    } catch (Exception ex) {
                        throw getNotClickableException();
                    }
                } else click(clArea);
                break;
            default:
                throw exception("Can't perform click because of unknown Element area: " + area);
        }
    }
    private RuntimeException getNotClickableException() {
        return exception("%s is not clickable in any parts. Maybe this element overlapped by some other element or locator is wrong", getName());
    }
    private ElementArea getElementClickableArea() {
        return Switch().get(
            Case(t -> isClickable(), t-> CENTER),
            Case(t -> isClickable(1, 1), t-> TOP_LEFT),
            Case(t -> isClickable(getRect().getWidth()-1,1),
                t-> TOP_RIGHT),
            Case(t -> isClickable(1,getRect().getHeight()-1),
                t-> BOTTOM_LEFT),
            Case(t -> isClickable(getRect().getWidth()-1,getRect().getHeight()-1),
                t-> BOTTOM_RIGHT));
    }

    /**
     * Select item by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        get(value).click();
    }

    /**
     * Select items by the values
     * @param names
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String... names) {
        for (String name : names)
            select(name);
    }
    public <TEnum extends Enum> void select(TEnum name) {
        select(getEnumValue(name));
    }

    public Select asSelect() {
        WebElement select = getWebElement();
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
     * Set the value in the specified attribute
     * @param name
     * @param value
     */
    @JDIAction(level = DEBUG)
    public void setAttribute(String name, String value) {
        jsExecute("setAttribute('"+name+"','"+value+"')");
    }

    /**
     * Get all element's attributes
     */
    @JDIAction(level = DEBUG)
    public MapArray<String, String> getAllAttributes() {
        List<String> jsList;
        try {
            jsList = (List<String>) js().executeScript("var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + '=\"' + a.value + '\"'); } ; return s;", getWebElement());
            return new MapArray<>(jsList, r -> r.split("=")[0], r -> r.split("=")[1].replace("\"", ""));
        } catch (Exception ignore) { return new MapArray<>(); }
    }

    /**
     * Check that element is deselected
     * @return boolean
     */
    @JDIAction("Check that '{name}' is deselected")
    public boolean isDeselected() {
        return !selected();
    }

    /**
     * Check the element is hidden
     * @return boolean
     */
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !displayed();
    }

    /**
     * Check the element is disabled
     * @return boolean
     */
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !enabled();
    }

    /**
     * Get all elements classes as list.
     * Example: <div class="btn submit color"> </a> will return list of elements [btn, submit, color]
     */
    @JDIAction(value = "Execute javascript '{0}' for '{name}'", level = DEBUG)
    public List<String> classes() {
        String cl = attr("class");
        return cl.length() > 0
            ? asList(attr("class").split(" "))
            : new ArrayList<>();
    }

    /** return true if element has expected class */
    @JDIAction(value = "Is '{name}' has class '{0}'", level = DEBUG)
    public boolean hasClass(String className) {
        return classes().contains(className);
    }
    public boolean hasAttribute(String attrName) {
        return isNotBlank(attr(attrName));
    }

    /**
     * Gets attribute 'placeholder'
     * @return String
     */
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG) @Override
    public String placeholder() { return getAttribute("placeholder"); }

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
     * Scroll screen view to item
     */
    @JDIAction
    public void show() {
        jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
    }

    /**
     * Scroll view to element and make a border around with specified color
     * @param color
     */
    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        show();
        jsExecute("style.border='3px dashed "+color+"'");
    }
    /**
     * Highlight element with red color
     */
    public void highlight() {
        highlight("red");
    }

    /**
     * Unhighlight element
     */
    @JDIAction(level = DEBUG)
    public void unhighlight() {
        show();
        jsExecute("style.border='none'");
    }

    /**
     * Double click on the element
     */
    @JDIAction("DoubleClick on '{name}'") @Override
    public void doubleClick() {
        actionsWitElement(Actions::doubleClick);
    }
    /**
     * Right click on the element
     */
    @JDIAction("RightClick on '{name}'") @Override
    public void rightClick() {
        actionsWitElement(Actions::contextClick);
    }

    /**
     * Hover mouse to element
     */
    @JDIAction("Hover to '{name}'")
    public void hover() {
        actions(Actions::moveToElement);
    }

    /**
     * Drag element and drop it to another element
     * @param to
     */
    @JDIAction("Drag '{name}' and drop it to '{0}'")
    public void dragAndDropTo(WebElement to) {
        actions((a,from) -> a.clickAndHold(from).moveToElement(to).release(to));
    }

    /**
     * Drag element and drop it to certain coordinates
     * @param x
     * @param y
     */
    @JDIAction("Drag '{name}' and drop it to ({0},{1})")
    public void dragAndDropTo(int x, int y) {
        actions((a,e) -> a.dragAndDropBy(e, x, y));
    }

    /**
     * Get element's screen shot with red border
     * @return String
     */
    @JDIAction(level = DEBUG)
    public String makePhoto() {
        highlight();
        return takeScreen();
    }

    /** Click on element if not selected */
    @JDIAction("Check '{name}'")
    public void check() {
        if (isDeselected())
            click();
    }


    /** Click on element selected */
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isSelected())
            click();
    }
    @Override
    public Label label() {
        return new Label().setup(Label.class, j->j
            .setLocator(By.cssSelector("[for="+ core().attr("id")+"]"))
            .setName(getName() + " label"));
    }

    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }
    @Override
    public String text(TextTypes type) {
        return timer().getResult(() -> noWait(() -> type.func.execute(this)));
    }

    public UIElement find(String by) {
        return $(by, this);
    }
    public UIElement find(By by) {
        return $(by, this);
    }
    public WebList finds(String by) {
        return $$(by, this);
    }
    public WebList finds(By by) {
        return $$(by, this);
    }
    public UIElement firstChild() { return find("*"); }
    public WebList childs() { return finds("*"); }
    //endregion

    //region Aliases
    /** getAllAttributes alias */
    public MapArray<String, String> attrs() { return getAllAttributes(); }
    /** getAttribute alias */
    public String attr(String value) { return getAttribute(value); }
    /** getText alias */ @Override
    public String text() { return text(getTextType()); }
    /** getCssValue alias */
    public String css(String prop) {
        return getCssValue(prop);
    }
    //endregion

    //region SetValue
    public void setValue(String value) {
        setText(value);
    }
    public String getValue() {
        return getText();
    }
    //endregion

    //region Protected and private
    protected boolean selected() {
        if (getWebElement().isSelected())
            return true;
        List<String> cl = classes();
        return cl.contains("checked") || cl.contains("active")||
            cl.contains("selected") || getAttribute("checked").equals("true");
    }
    protected boolean enabled() {
        if (hasClass("active")) {
            return true;
        }
        if (hasClass("disabled") || hasAttribute("disabled")) {
            return false;
        }
        return getWebElement().isEnabled();
    }
    protected boolean displayed() {
        try {
            if (getWebElement().isDisplayed())
                return true;
        } catch (Exception ex) {
            List<WebElement> result = getAllElements();
            return result.size() == 1 && result.get(0).isDisplayed();
        }
        return false;
    }

    public boolean isClickable() {
        return isClickable(getRect().getWidth()/2, getRect().getHeight()/2-1);
    }
    public boolean isClickable(int x, int y) {
        return (Boolean) js().executeScript("var elem = arguments[0],    " +
                "  rect = elem.getBoundingClientRect(),    " +
                "  cx = rect.left + arguments[1],        " +
                "  cy = rect.top + arguments[2],        " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {         " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            ", getWebElement(), x, y);
    }
    //endregion
    public boolean wait(JFunc1<UIElement, Boolean> condition) {
        return timer().wait(() -> condition.execute(this));
    }

    public IsAssert is() {
        return new IsAssert().set(this);
    }

}
