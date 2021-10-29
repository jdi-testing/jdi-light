package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.vuetify.asserts.TextAreaAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static java.util.Arrays.asList;

/**
 * To see an example of TextArea web element please visit
 * https://vuetifyjs.com/en/components/textareas/
 */
public class TextArea extends UIBaseElement<TextAreaAssert>
        implements HasLabel, HasPlaceholder, IsInput {

    protected String SLOT = ".v-input__slot";
    protected String TEXT_AREA = ".v-input__slot textarea";
    protected String DETAILS = ".v-text-field__details";
    protected String PREPEND_OUTER_ICON = ".v-input__prepend-outer .v-icon";
    protected String PREPEND_INNER_ICON = ".v-input__prepend-inner .v-icon";
    protected String APPEND_OUTER_ICON = ".v-input__append-outer .v-icon";
    protected String APPEND_INNER_ICON = ".v-input__append-inner .v-icon";
    protected String MESSAGE = ".v-messages__message";
    protected String COUNTER = ".v-counter";

    protected String FILLED_CLASS = "v-text-field--filled";
    protected String OUTLINED_CLASS = "v-text-field--outlined";
    protected String AUTO_GROW_CLASS = "v-textarea--auto-grow";
    protected String NO_RESIZE_CLASS = "v-textarea--no-resize";

    @JDIAction("Check if '{name}' is filled")
    public boolean isFilled() {
        return core().hasClass(FILLED_CLASS);
    }

    @JDIAction("Check if '{name}' is outlined")
    public boolean isOutlined() {
        return core().hasClass(OUTLINED_CLASS);
    }

    @JDIAction("Check if '{name}' is auto grow")
    public boolean isAutoGrow() {
        return core().hasClass(AUTO_GROW_CLASS);
    }

    @JDIAction("Check if '{name}' is no resizable")
    public boolean isNotResizable() {
        return core().hasClass(NO_RESIZE_CLASS);
    }

    @JDIAction(value = "Get '{name}' slot", level = DEBUG)
    public UIElement slot() {
        return core().find(SLOT);
    }

    @JDIAction(value = "Get '{name}' textarea", level = DEBUG)
    public UIElement textArea() {
        return core().find(TEXT_AREA);
    }

    @JDIAction(value = "Get '{name}' details", level = DEBUG)
    public UIElement details() {
        return core().find(DETAILS);
    }

    @JDIAction(value = "Get '{name}' prepend outer icon", level = DEBUG)
    public Icon prependOuter() {
        return new Icon().setCore(Icon.class, core().find(PREPEND_OUTER_ICON));
    }

    @JDIAction(value = "Get '{name}' prepend inner icon", level = DEBUG)
    public Icon prependInner() {
        return new Icon().setCore(Icon.class, core().find(PREPEND_INNER_ICON));
    }

    @JDIAction(value = "Get '{name}' append outer icon", level = DEBUG)
    public Icon appendOuter() {
        return new Icon().setCore(Icon.class, core().find(APPEND_OUTER_ICON));
    }

    @JDIAction(value = "Get '{name}' append inner icon", level = DEBUG)
    public Icon appendInner() {
        return new Icon().setCore(Icon.class, core().find(APPEND_INNER_ICON));
    }

    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return details().find(MESSAGE);
    }

    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return details().find(COUNTER);
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textArea().getText();
    }

    @JDIAction("Get '{name}' lines")
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return textArea().label();
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @Override
    @JDIAction("Get '{name}' placeholder text")
    public String placeholder() {
        return labelText();
    }

    @Override
    @JDIAction("Set text '{0}' into '{name}'")
    public void input(String value) {
        clear();
        textArea().input(value);
    }

    @JDIAction("Set lines '{0}' in '{name}'")
    public void setLines(String... lines) {
        sendKeys(String.join("\n", lines));
    }

    public void setLines(List<String> lines) {
        setLines(lines.toArray(new String[0]));
    }

    @Override
    @JDIAction("Set text '{0}' into '{name}'")
    public void setText(String value) {
        input(value);
    }

    @Override
    @JDIAction("Add text '{0}' into '{name}'")
    public void sendKeys(CharSequence... value) {
        textArea().sendKeys(value);
    }

    @Override
    @JDIAction("Focus on '{name}'")
    public void focus() {
        sendKeys("");
    }

    @JDIAction("Add new line '{0}' in '{name}'")
    public void addNewLine(String line) {
        String newLine = line;
        if (isNotEmpty())
            newLine = "\n" + line;
        sendKeys(newLine);
    }

    @Override
    @JDIAction("Clear '{name}' textarea")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            textArea().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            textArea().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    @JDIAction(value = "Get '{name}' css 'color'", level = DEBUG)
    public String color() {
        return slot().css("color");
    }

    @JDIAction(value = "Get '{name}' css 'background-color'", level = DEBUG)
    public String backgroundColor() {
        return slot().css("background-color");
    }

    @JDIAction(value = "Get '{name}' height", level = DEBUG)
    public int height() {
        return textArea().getSize().height;
    }

    @JDIAction(value = "Get '{name}' attr 'rows'", level = DEBUG)
    public int rows() { return getInt("rows", textArea()); }

    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
}
