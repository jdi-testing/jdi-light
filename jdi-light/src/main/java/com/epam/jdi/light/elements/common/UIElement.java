package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.jdiai.tools.Timer;
import com.jdiai.tools.func.JAction1;
import com.jdiai.tools.func.JFunc;
import com.jdiai.tools.func.JFunc1;
import com.jdiai.tools.func.JFunc2;
import com.jdiai.tools.map.MapArray;
import org.hamcrest.Matchers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.ElementArea.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.elements.composite.WebPage.windowScreenshot;
import static com.epam.jdi.light.elements.composite.WebPage.zoomLevel;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.AllureLogger.attachScreenshot;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.JDISettings.SCREEN;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.EnumUtils.getEnumValue;
import static com.jdiai.tools.JsonUtils.getInt;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.LinqUtils.valueOrDefault;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.ReflectionUtils.create;
import static com.jdiai.tools.ReflectionUtils.isInterface;
import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.switcher.SwitchActions.Case;
import static com.jdiai.tools.switcher.SwitchActions.Switch;
import static java.lang.Math.abs;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.Keys.BACK_SPACE;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UIElement extends JDIBase
        implements WebElement, SetValue, HasAssert<IsAssert>,
        HasClick, IsText, HasLabel, HasPlaceholder, IsInput, HasCheck, CanBeSelected {
    //region Constructors
    public UIElement() { }
    public UIElement(WebElement el) { setWebElement(el); }
    public UIElement(List<WebElement> els) { setWebElements(els); }
    public UIElement(@MarkupLocator By locator) { setLocator(locator); }
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
        this(base, el);
        setGetFunc(func);
    }
    public UIElement(JDIBase base, WebElement el) {
        super(base);
        setWebElement(el);
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
    @Override
    public UIElement waitSec(int timeout) {
        super.waitSec(timeout);
        return this;
    }
    @Override
    public UIElement noWait() {
        super.noWait();
        return this;
    }

    //endregion

    //region WebElement
    /** Click on element */
    @JDIAction("Click on '{name}'") @Override
    public void click() {
        click(clickAreaType);
    }

    /** Submit form*/
    @JDIAction(level = DEBUG)
    public void submit() { get().submit(); }

    /**
     * Send specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'") @Override
    public void sendKeys(CharSequence... value) {
        if (value == null || value.length == 0 || value[0] == null) {
            return;
        }
        WebElement el = get();
        if (value.length == 1 && value[0] != null && value[0].equals("\n")) {
            el.sendKeys("\n " + BACK_SPACE);
        } else {
            el.sendKeys(value);
        }
        waitAfterAction();
    }

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

    public String tag() { return getTagName(); }
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
    @JDIAction(value = "Check that '{name}' is selected", timeout = 0)
    public boolean isSelected() {
        return selected();
    }

    /**
     * Check the element is enabled
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    public boolean isEnabled() {
        return enabled();
    }

    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return text(textType);
    }

    @JDIAction("Get '{name}' text")
    public String getTextForce() {
        noValidation();
        return text(textType);
    }

    /**
     * Check the element is displayed
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is displayed", timeout = 0, level = DEBUG)
    public boolean isDisplayed() {
        if (params.keys().contains("visualCheck"))
            visualCheck("Check that '"+getName()+"' is displayed");
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

    @JDIAction(level = DEBUG)
    public Rectangle getPosition() {
        Map<String, Object> map = (Map<String, Object>)js().executeScript("const rect = arguments[0].getBoundingClientRect();return {x:rect.x,y:rect.y,width:rect.width,height:rect.height};", getWebElement());
        return new Rectangle(getInt(map.get("x")), getInt(map.get("y")), getInt(map.get("height")), getInt(map.get("width")));
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
    public WebElement findElement(@MarkupLocator By locator) { return getWebElement().findElement(locator); }

    @JDIAction(level = DEBUG)
    public List<WebElement> findElements(@MarkupLocator By locator) { return getWebElement().findElements(locator); }

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
    @JDIAction(value = "Execute javascript '{0}' for '{name}'", level = DEBUG, timeout = 0)
    public String jsExecute(String jsCode) {
        return valueOf(js().executeScript("return arguments[0]."+ jsCode +";", getWebElement()));
    }

    /**
     * Check the element is displayed
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is visible by user", timeout = 0)
    public boolean isVisible() {
        if (isHidden()) {
            return false;
        }
        Object isInView = js().executeScript(
            "const rect = arguments[0].getBoundingClientRect();\n" +
            "if (!rect) return false;\n" +
            "const windowHeight = Math.min(window.innerHeight || document.documentElement.clientHeight);\n" +
            "const windowWidth = Math.min(window.innerWidth || document.documentElement.clientWidth);\n" +
            "if (rect.top < 0) return false;\n" +
            "if (rect.left < 0) return false;\n" +
            "if (rect.bottom > windowHeight) return false;\n" +
            "if (rect.right > windowWidth) return false;\n" +
            "return true;", getWebElement());
        return (boolean)isInView;
    }

    /**
     * Input specified value as keys
     * @param value
     */
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        if (value == null) return;
        setTextType.action.execute(this, value);
        waitAfterAction();
    }

    /**
     * Focus
     */
    @JDIAction(level = DEBUG) @Override
    public void focus() { sendKeys(""); }
    /**
     * Set the text in the attribute "value"
     * @param value
     */

    @JDIAction("Set '{0}' in '{name}'") @Override
    public void setText(String value) {
        if (value == null) return;
        jsExecute("value='"+value.replace("\\", "\\\\").replace("'", "\\'")+"'");
    }

    @JDIAction("Click on '{name}' (x:{0}, y:{1})")
    public void click(int x, int y) {
        actionsWithElement(a -> a.moveByOffset(x - getRect().width / 2, y - getRect().height / 2).click());
    }
    @JDIAction("Click on '{name}'")
    public void click(ElementArea area) {
        if (isDisabled()) {
            throw runtimeException("Can't perform click. Element is disabled");
        }
        switch (area) {
            case TOP_LEFT:
                click(1,1);
                logger.debug("Click Top Left");
                break;
            case TOP_RIGHT:
                click(getRect().getWidth() - 1,1);
                logger.debug("Click Top Right");
                break;
            case BOTTOM_LEFT:
                click(1,getRect().getHeight() - 1);
                logger.debug("Click Bottom Left");
                break;
            case BOTTOM_RIGHT:
                click(getRect().getWidth() - 1,getRect().getHeight() - 1);
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
                logger.debug("Click Smart");
                ElementArea clArea = timer().getResultByCondition(
                    this::getElementClickableArea, Objects::nonNull);
                if (clArea == null || clArea == CENTER) {
                    try {
                        get().click();
                    } catch (Exception ex) {
                        throw getNotClickableException();
                    }
                } else click(clArea);
        }
        waitAfterAction();
    }

    protected void waitAfterAction() {
        int timeout = waitAfter().value;
        if (isBlank(waitAfterMethod) && timeout > 0) {
            Timer.sleep(timeout * 1000L);
        }
    }

    protected RuntimeException getNotClickableException() {
        return runtimeException("%s is not clickable in any parts. Maybe this element overlapped by some other element or locator is wrong", getName());
    }
    protected ElementArea getElementClickableArea() {
        return Switch().get(
            Case(t -> isClickable(), t-> CENTER),
            Case(t -> isClickable(1, 1), t-> TOP_LEFT),
            Case(t -> isClickable(getRect().getWidth() - 1,1),
                t-> TOP_RIGHT),
            Case(t -> isClickable(1,getRect().getHeight() - 1),
                t-> BOTTOM_LEFT),
            Case(t -> isClickable(getRect().getWidth() - 1,getRect().getHeight() - 1),
                t-> BOTTOM_RIGHT));
    }

    /**
     * Select item by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        if (value == null) return;
        get(value).click();
        waitAfterAction();
    }

    @JDIAction("Select '{name}' element")
    public void select() { click(); }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        getWebElements().get(index).click();
        waitAfterAction();
    }

    /**
     * Select items by the values
     * @param names
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String... names) {
        for (String name : names) {
            select(name);
        }
    }

    public <TEnum extends Enum<?>> void select(TEnum name) {
        select(getEnumValue(name));
    }

    public Select asSelect() {
        WebElement select = getWebElement();
        if (!getTagName().equals("select")) {
            List<WebElement> els = select.findElements(By.tagName("select"));
            if (els.size() > 0) {
                select = els.get(0);
            }
            else {
                throw runtimeException("Element should point to <select> tag in order to use Selenium Select");
            }
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
        if (value == null) return;
        jsExecute("setAttribute('" + name + "','" + value + "')");
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
    @JDIAction(value = "Check that '{name}' is deselected", timeout = 0)
    public boolean isDeselected() {
        return !selected();
    }

    /**
     * Check the element is hidden
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is hidden", timeout = 0)
    public boolean isHidden() {
        return !displayed();
    }

    /**
     * Check the element is visible by user
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is not visible by user", timeout = 0)
    public boolean isNotVisible() {
        return !isVisible();
    }

    /**
     * Check the element is displayed
     * @return boolean
     */
    @JDIAction(value = "Check that '{name}' is displayed", timeout = 0, level = DEBUG)
    public boolean isNotDisplayed() {
        return !displayed();
    }
    @JDIAction(value = "Check that '{name}' is exist on the page", timeout = 0)
    public boolean isExist() {
        try {
            return getWebElements().size() > 0;
        } catch (Exception ignore) { return false; }
    }
    @JDIAction(value = "Check that '{name}' is missed on the page", timeout = 0)
    public boolean isNotExist() {
        return !isExist();
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
    @JDIAction(value = "Get '{name}' list of classes ", level = DEBUG)
    public List<String> classes() {
        String cl = attr("class");
        return cl.length() > 0
            ? asList(cl.split(" "))
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

    public String pseudo(String elementName, String propertyName) {
        return js().executeScript("return window.getComputedStyle(arguments[0], arguments[1])" +
                ".getPropertyValue(arguments[2]);", getWebElement(), elementName, propertyName).toString();
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
     * Scroll screen view to item
     */
    @JDIAction(timeout = 0)
    public void show() {
        if (isDisplayed() && !isVisible()) {
            jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
        }
    }

    private Actions getActions() {
        return new Actions(driver());
    }
    private WebElement showElement() {
        show();
        return getWebElement();
    }
    public void actions(JFunc2<Actions, WebElement, Actions> action) {
        WebElement webElement = showElement();
        action.execute(getActions(), webElement).build().perform();
    }
    public void actions(JFunc1<Actions, Actions> action) {
        show();
        action.execute(getActions()).build().perform();
    }
    public void actionsWithElement(JFunc2<Actions, WebElement, Actions> action) {
        WebElement webElement = showElement();
        action.execute(getActions().moveToElement(webElement), webElement).build().perform();
    }
    public void actionsWithElement(JFunc1<Actions, Actions> action) {
        WebElement webElement = showElement();
        action.execute(getActions().moveToElement(webElement)).build().perform();
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
     * Double click on the element
     */
    @JDIAction("DoubleClick on '{name}'") @Override
    public void doubleClick() {
        actionsWithElement((a,e) -> a.doubleClick(e));
        waitAfterAction();
    }
    /**
     * Right click on the element
     */
    @JDIAction("RightClick on '{name}'") @Override
    public void rightClick() {
        actionsWithElement((a,e) -> a.contextClick(e));
        waitAfterAction();
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

    public void makePhotoToAllure() {
        try {
            attachScreenshot(getName(), makePhoto(getName()).getAbsolutePath());
        } catch (Exception ignore) { }
    }
    public File makePhoto() {
        return makePhoto(getName());
    }
    /**
     * Get element's screen shot with red border
     * @return String
     */
    protected String imageFilePath;

    public boolean hasImage() {
        return imageFilePath != null;
    }
    public File getImageFile() {
        return hasImage() ? new File(imageFilePath) : null;
    }
    protected String getScreenshotName(String tag) {
        return tag + "." + SCREEN.fileSuffix;
    }

    @JDIAction(level = DEBUG)
    public File makePhoto(String tag) {
        show();
        Rectangle rect = getPosition();
        imageFilePath = windowScreenshot(
            multiply(rect.getX()), multiply(rect.getY()),
            multiply(rect.getWidth()), multiply(rect.getHeight()),
            getScreenshotName(tag));
        return getImageFile();
    }
    protected int multiply(int value) {
        return (int)Math.round(value*zoomLevel());
    }
    @JDIAction("Visual compare '{0}'")
    public void visualValidation(String tag) {
        try {
            if (hasImage()) {
                File image = getImageFile();
                makePhoto(tag + "-new");
                compareImageFiles(getImageFile(), image);
            } else {
                makePhoto(tag);
                String message = "Set baseline: " + imageFilePath;
                jdiAssert(message, Matchers.is(message));
            }
        } catch (Exception ex) {throw exception(ex, "Can't compare files"); }
    }
    protected void compareImageFiles(File image1, File image2) {
        long actual = image1.length();
        long expected = image2.length();
        String result = abs(actual - expected) < 100
            ? "Images are the same"
            : format("Images are different %s %s", image1.getAbsolutePath(), image2.getAbsolutePath());
        jdiAssert(result, Matchers.is("Images are the same"));
    }

    @JDIAction("Visual compare '{0}'")
    public void visualValidation(UIElement element) {
        compareImageFiles(getImageFile(), element.getImageFile());
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
        if (isSelected()) {
            click();
        }
    }
    @Override
    public Label label() {
        return new Label().setup(Label.class, j->j
            .setLocator(By.cssSelector("[for="+ core().attr("id")+"]"))
            .setName(getName() + " label").setTypeName("Label"));
    }

    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }
    @JDIAction("Get '{name}' text") @Override
    public String text(TextTypes type) {
        return timer().getResult(() -> noWait(() -> type.func.execute(this)));
    }
    public static JFunc1<UIElement, String> SMART_GET_TEXT = ui -> {
        String text = ui.text(TEXT);
        if (isNotBlank(text)) {
            return text;
        }
        text = ui.text(INNER);
        if (isNotBlank(text)) {
            return text;
        }
        text = ui.text(VALUE);
        return isNotBlank(text) ? text : "";
    };
    public static JFunc1<UIElement, String> SMART_LIST_TEXT = ui -> {
        String text = ui.text(TEXT);
        if (isNotBlank(text)) {
            return text;
        }
        text = ui.text(INNER);
        if (isNotBlank(text)) {
            return text;
        }
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
    public UIElement find(@MarkupLocator String by) {
        return $(by, this);
    }
    public UIElement findFirst(@MarkupLocator String by) {
        UIElement element = $(by, this);
        element.strictSearch(false);
        return element;
    }
    public UIElement find(@MarkupLocator By by) {
        return $(by, this);
    }
    public WebList finds(@MarkupLocator String by) {
        return $$(by, this);
    }
    public WebList finds(@MarkupLocator By by) {
        return $$(by, this);
    }
    public UIElement firstChild() { return find("*"); }
    public WebList children() { return finds("*"); }
    public UIElement findUp() {
        return find("./..");
    }
    //endregion

    //region Aliases
    /** getAllAttributes alias */
    public MapArray<String, String> attrs() { return getAllAttributes(); }
    /** getAttribute alias */
    public String attr(String value) { return getAttribute(value); }
    /** getText alias */ @Override
    public String text() { return text(textType); }
    /** getCssValue alias */
    public String css(String prop) {
        return getCssValue(prop);
    }
    //endregion

    //region SetValue
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    //endregion

    //region Protected and private
    protected boolean selected() {
        if (getWebElement().isSelected())
            return true;
        return hasClass("checked") || hasClass("active") ||
            hasClass("selected") || attr("checked").equals("true");
    }
    protected boolean enabled() {
        if (hasClass("active"))
            return true;
        if (hasClass("disabled") || hasAttribute("disabled"))
            return false;
        return getWebElement().isEnabled();
    }
    protected boolean displayed() {
        try {
            return getWebElement().isDisplayed();
        } catch (Throwable ex) {
            return false;
        }
    }
    @Override
    public UIElement noValidation() {
        super.noValidation();
        return this;
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

    public <T> T with(Class<T> cl) {
        try {
            return create(cl, this);
        } catch (Throwable ex) {
            throw exception(ex, "Can't create instantiate class. %s class should have constructor with UIElement parameter in order to use with method", cl.getSimpleName());
        }
    }

    public void press(Keys key) {
        Keyboard.press(key);
    }
    public void command(String sequence) {
        Keyboard.command(sequence);
    }
    public void commands(String... commands) {
        Keyboard.commands(commands);
    }
    public void pasteText(String text) {
        Keyboard.pasteText(text);
    }
    public void pasteText(String text, long timeToWaitMSec) {
        Keyboard.pasteText(text, timeToWaitMSec);
    }

    public UIElement inFrame(By... bys) {
        return setup(base -> base.setFrames(asList(bys)));
    }
    public UIElement inFrame(String... bys) {
        return setup(base -> base.setFrames(map(bys, WebDriverByUtils::defineLocator)));
    }

    public MapArray<String, Direction> relations;

    public UIElement clearRelations() {
        relations = null;
        return this;
    }

    protected Point getCenter(Rectangle rect) {
        int x = rect.x + rect.width / 2;
        int y = rect.y + rect.height / 2;
        return new Point(x, y);
    }

    public Direction getDirectionTo(ICoreElement element) {
        return getDirectionTo(element.core().getWebElement());
    }
    public Direction getDirectionTo(WebElement element) {
        Rectangle elementCoordinates = getRect();
        Rectangle destinationCoordinates = element.getRect();
        Direction direction = new Direction(getCenter(elementCoordinates), getCenter(destinationCoordinates));
        if (isInterface(element.getClass(), ICoreElement.class)) {
            ICoreElement core = ((ICoreElement)element).core();
            if (relations == null) {
                relations = new MapArray<>(core.getFullName(), direction);
            } else {
                relations.update(core.getFullName(), direction);
            }
        }
        return direction;
    }

    public IsAssert is() {
        return new IsAssert().set(this);
    }

}
