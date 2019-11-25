package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.ui.bootstrap.asserts.TextAreaAssert;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.getInt;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

/**
 * To see an example of Text area web element please visit https://getbootstrap.com/docs/4.3/components/forms/#form-controls
 */

public class TextArea extends UIBaseElement<TextAreaAssert>
        implements HasLabel, SetValue, HasPlaceholder, IsInput {
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
        String newLine = line;
        if (isNotEmpty()) {
            newLine = "\n" + newLine;
        }
        sendKeys(newLine);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    @Override
    public String getText() {
        return core().attr("value");
    }
    // endregion
    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }

}
