package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.formsPage;
import static io.github.com.pages.FormsPage.*;

public class FormsTests extends TestsInit {

    @BeforeClass
    public void before() {
        formsPage.open();
    }

    @Test
    public void rulesFormTest() {
        String textValue = "JDI Light";
        int characters = 9;

        ruleForm.slider.slideHorizontalTo(characters);
        ruleForm.checkbox.check();
        ruleForm.validationTextField.setText(textValue);
        ruleForm.mainTextField.setText(textValue);
        ruleForm.validate();

        ruleForm.mainTextField.clear();
        ruleForm.checkbox.uncheck();
        ruleForm.validationTextField.clear();
        ruleForm.isClear();

    }

    @Test
    public void validationWithSubmitClearFormTest() {
        validationWithSubmitClearForm.nameField.setText("Batman");
        validationWithSubmitClearForm.emailField.setText("dark_knight@gotaham.com");
        validationWithSubmitClearForm.itemField.select("Item 1");
        validationWithSubmitClearForm.confirmingCheckBox.check();
        validationWithSubmitClearForm.validate();

        validationWithSubmitClearForm.resetFormButton.click();
        validationWithSubmitClearForm.isClear();
    }

    @Test
    public void veeValidateForm() {
        veeValidateForm.nameField.setText("Batman");
        veeValidateForm.phoneNumberField.setText("7474747");
        veeValidateForm.emailField.setText("dark_knight@gotaham.com");
        veeValidateForm.itemField.select("Item 1");
        veeValidateForm.optionCheckBox.check();
        veeValidateForm.validate();

        veeValidateForm.clearButton.click();
        veeValidateForm.isClear();
    }

    @Test
    public void vuelidateFormTest() {
        vuelidateForm.nameField.setText("Batman");
        vuelidateForm.emailField.setText("dark_knight@gotaham.com");
        vuelidateForm.itemField.select("Item 1");
        vuelidateForm.optionCheckBox.check();
        vuelidateForm.validate();

        vuelidateForm.clearButton.click();
        vuelidateForm.isClear();
    }
}
