package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormContacts;
import org.openqa.selenium.Keys;

public class FormGrid extends Form<FormContacts> {
    //FindBy(css = "#first_name")
    @UI("#first_name")
    public TextField name;
    //FindBy(css = "#last_name")
    @UI("#last_name")
    public TextField lastName;

    @Override
    public void submit() {
        lastName.sendKeys(Keys.ENTER);
    }
}
