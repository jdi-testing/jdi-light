package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.aserts.TextAreaAssert;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class TextArea extends UIBaseElement<TextAreaAssert> implements WithLabel, SetValue {
    // region Actions
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) { element.sendKeys(value); }
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        element.setText(value);
    }
    @JDIAction("Clear '{name}'")
    public void clear() { element.clear(); }
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        element.input(value);
    }
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return element.placeholder(); }
    @JDIAction("Get '{name}' text")
    public String getText() { return element.attr("value"); }
    @JDIAction("Set lines '{0}' in '{name}'")
    public void setLines(String... lines) {
        setText(print(asList(lines), "\\n"));
    }
    @JDIAction("Get '{name}' lines")
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    @JDIAction(level = DEBUG)
    public int rows() { return getInt("rows", element); }
    @JDIAction(level = DEBUG)
    public int cols() { return getInt("cols", element); }
    @JDIAction(level = DEBUG)
    public int minlength() { return getInt("minlength", element); }
    @JDIAction(level = DEBUG)
    public int maxlength() { return getInt("maxlength", element); }
    @JDIAction("Add ne line '{0}' in '{name}'")
    public void addNewLine(String line) {
        sendKeys("\n" + line);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
    // endregion

}
