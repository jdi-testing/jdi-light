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
        ruleForm.validationTextField.clearAndSetText(textValue);
        ruleForm.mainTextField.clearAndSetText(textValue);
        ruleForm.is().validate();

        ruleForm.mainTextField.clear();
        ruleForm.checkbox.uncheck();
        ruleForm.validationTextField.clear();
        ruleForm.is().clear();
    }

    @Test
    public void validationWithSubmitClearFormTest() {
        validationWithSubmitClearForm.nameField.clearAndSetText("Batman");
        validationWithSubmitClearForm.emailField.clearAndSetText("dark_knight@gotaham.com");
        validationWithSubmitClearForm.itemField.select("Item 1");
        validationWithSubmitClearForm.confirmingCheckBox.check();
        validationWithSubmitClearForm.is().validate();

        validationWithSubmitClearForm.resetFormButton.click();
        validationWithSubmitClearForm.is().clear();
    }

    @Test
    public void veeValidateForm() {
        veeValidateForm.nameField.clearAndSetText("Batman");
        veeValidateForm.phoneNumberField.clearAndSetText("7474747");
        veeValidateForm.emailField.clearAndSetText("dark_knight@gotaham.com");
        veeValidateForm.itemField.select("Item 1");
        veeValidateForm.optionCheckBox.check();
        veeValidateForm.is().validate();

        veeValidateForm.clearButton.click();
        veeValidateForm.is().clear();
    }

    @Test
    public void vuelidateFormTest() {
        vuelidateForm.nameField.clearAndSetText("Batman");
        vuelidateForm.emailField.clearAndSetText("dark_knight@gotaham.com");
        vuelidateForm.itemField.select("Item 1");
        vuelidateForm.optionCheckBox.check();
        vuelidateForm.is().validate();

        vuelidateForm.clearButton.click();
        vuelidateForm.is().clear();
    }
}
