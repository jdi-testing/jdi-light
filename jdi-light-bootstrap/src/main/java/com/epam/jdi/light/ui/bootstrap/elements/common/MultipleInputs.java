package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.ui.bootstrap.asserts.MultipleInputsAssert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class MultipleInputs extends UIBaseElement<MultipleInputsAssert>
        implements IsInput, HasLabel, HasValue, SetValue {

    @Override
    public String getValue() {
        return getValue(0);
    }

    @JDIAction("Get value from input with locator {0}")
    public String getValue(String locator) {
        return core().find(locator).getValue();
    }

    @JDIAction("Get value from input with index {0}")
    public String getValue(int number) {
        return core().finds(By.cssSelector("input")).get(number).getValue();
    }

    @JDIAction("Get all values from {name}")
    public List<String> getAllValues() {
        WebList inputs = core().finds(By.cssSelector("input"));
        List<String> values = new ArrayList<>(inputs.size());

        inputs.forEach(i -> values.add(i.getValue()));

        return values;
    }

    public String getText() {
        return getText(0);
    }

    @JDIAction("Get text from input with locator {0}")
    public String getText(String locator) {
        return core().find(locator).getText();
    }

    @JDIAction("Get text from input with index {0}")
    public String getText(int number) {
        return core().finds("input").get(number).getText();
    }

    @JDIAction("Get all texts from {name}")
    public List<String> getAllTexts() {
        WebList inputs = core().finds("input");
        List<String> texts = new ArrayList<String>(inputs.size());

        inputs.forEach(i -> texts.add(i.getText()));

        return texts;
    }

    @Override
    public void setValue(String value) {
        setValue(value, 0);
    }

    @JDIAction("Set value '{0}' to input with locator {1}")
    public void setValue(String value, String locator) {
        core().find(locator).setValue(value);
    }

    @JDIAction("Set value '{0}' to input with index {1}")
    public void setValue(String value, int number) {
        core().finds("input").get(number).setValue(value);
    }

    @JDIAction("Set values to all inputs from {name}")
    public void setAllValues(List<String> values) {
        WebList inputs = core().finds("input");

        for(int index = 0; index < values.size(); index++) {
            inputs.get(index).setValue(values.get(index));
        }
    }

    @Override
    public void sendKeys(CharSequence... value) {
        sendKeys(0, value);
    }

    @JDIAction("Send keys to input with index {0}")
    public void sendKeys(int index, CharSequence... value) {
        core().finds("input").get(index).sendKeys(value);
    }

    @JDIAction("Send keys to input with locator {0}")
    public void sendKeys(String locator, CharSequence value) {
        core().find(locator).sendKeys(value);
    }

    @JDIAction("Send keys to all inputs from {name}")
    public void sendKeysAll(List<String> values) {
        WebList inputs = core().finds("input");

        for (int index = 0; index < inputs.size(); index++) {
            inputs.get(index).sendKeys(values.get(index));
        }
    }

    @Override
    public void clear() {
        clear(0);
    }

    @JDIAction("Clear input from {name} with index {0}")
    public void clear(int index) {
        core().finds("input").get(index).clear();
    }

    @JDIAction("Clear input from {name} with locator {0}")
    public void clear(String locator) {
        core().find(locator).clear();
    }
    @JDIAction("Clear all inputs from {name}")
    public void clearAll() {
        core().finds("input").forEach(UIElement::clear);
    }

    @Override
    public void focus() {
        focus(0);
    }

    @JDIAction("Focus input from {name} with index {0}")
    public void focus(int index) {
        core().finds("input").get(index).focus();
    }

    @JDIAction("Focus input from {name} with locator {0}")
    public void focus(String locator) {
        core().find(locator).focus();
    }
    @Override
    public String placeholder() {
        return placeholder(0);
    }

    @JDIAction("Get placeholder from input with index {0} from {name}")
    public String placeholder(int index) {
        return core().finds("input").get(index).placeholder();
    }

    @JDIAction("Get placeholder from input with locator {0} from {name}")
    public String placeholder(String locator) {
        return core().find(locator).placeholder();
    }
    @JDIAction("Get all placeholders from {name}")
    public List<String> placeholderAll() {
        WebList inputs = core().finds("input");
        List<String> placeholders = new ArrayList<String>(inputs.size());

        inputs.forEach(i -> placeholders.add(i.placeholder()));

        return placeholders;
    }

    @Override
    public void input(String value) {
        input(value, 0);
    }

    @JDIAction("Input value {0} in input with index {1}")
    public void input(String value, int index) {
        core().finds("input").get(index).input(value);
    }

    @JDIAction("Input value {0} in input with locator {1}")
    public void input(String value, String locator) {
        core().find(locator).input(value);
    }
    @JDIAction("Input values in all inputs for {name}")
    public void inputAll(List<String> values) {
        WebList inputs = core().finds("input");

        for(int index = 0; index < inputs.size(); index++) {
           inputs.get(index).input(values.get(index));
        }
    }

    @Override
    public MultipleInputsAssert is() {
        return new MultipleInputsAssert().set(this);
    }
}
