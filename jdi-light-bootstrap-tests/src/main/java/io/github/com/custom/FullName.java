package io.github.com.custom;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import static java.lang.String.*;
import static org.apache.commons.lang3.StringUtils.*;

public class FullName extends UIBaseElement<TextAssert> implements IsText {
    @UI("[aria-label='First name']") TextField firstName;
    @UI("[aria-label='Last name']") TextField lastName;
    public String getText() {
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        return isNotBlank(firstName) || isNotBlank(lastName)
                ? format("%s;%s", firstName, lastName)
                : "";
    }
    public void setName(String firstName, String lastName) {
        this.firstName.input(firstName);
        this.lastName.input(lastName);
    }
    public void clear() {
        firstName.clear();
        lastName.clear();
    }
    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
