package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormContacts;
import org.openqa.selenium.Keys;

public class FormGrid extends Form<FormContacts> {

    @UI("#first_name")
    public TextField name;
    @UI("#last_name")
    public TextField lastName;

    @Override
    public void submit() {
        lastName.sendKeys(Keys.ENTER);
    }
}
