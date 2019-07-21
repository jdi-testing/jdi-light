package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasInput;
import com.epam.jdi.light.elements.interfaces.HasLabel;
import com.epam.jdi.light.elements.interfaces.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.asserts.TextAreaAssert;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class TextArea extends UIBaseElement<TextAreaAssert>
        implements HasLabel, SetValue, HasPlaceholder, HasInput {
    // region Actions
    @JDIAction("Set lines '{0}' in '{name}'")
    public void setLines(String... lines) {
        setText(print(asList(lines), "\\n"));
    }
    @JDIAction("Get '{name}' lines")
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    @JDIAction(level = DEBUG)
    public int rows() { return getInt("rows", uiElement); }
    @JDIAction(level = DEBUG)
    public int cols() { return getInt("cols", uiElement); }
    @JDIAction(level = DEBUG)
    public int minlength() { return getInt("minlength", uiElement); }
    @JDIAction(level = DEBUG)
    public int maxlength() { return getInt("maxlength", uiElement); }
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
