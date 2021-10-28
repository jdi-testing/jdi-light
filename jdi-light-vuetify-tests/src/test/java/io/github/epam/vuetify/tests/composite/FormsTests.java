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

        customRuleForm.slider.slideHorizontalTo(characters);
        customRuleForm.slider.is().value(characters);

        customRuleForm.checkbox.check();
        customRuleForm.checkbox.is().checked();

        customRuleForm.validationTextFieldDemo.clearAndSetText(textValue);
        customRuleForm.mainTextFieldDemo.clearAndSetText(textValue);
        customRuleForm.is().validate();
    }

    @Test
    public void ValidationWithSubmitClearFormTest() throws InterruptedException {

        validationWithSubmitClearForm.nameField.clearAndSetText("Batman");
        validationWithSubmitClearForm.nameField.isText("Batman");
        validationWithSubmitClearForm.emailField.clearAndSetText("dark_knight@gotaham.com");
        validationWithSubmitClearForm.emailField.isText("dark_knight@gotaham.com");
        validationWithSubmitClearForm.itemField.select("Item 1");
        validationWithSubmitClearForm.itemField.is().selected("Item 1");
        validationWithSubmitClearForm.confirmingCheckBox.check();
        validationWithSubmitClearForm.is().validate();

        validationWithSubmitClearForm.resetFormButton.click();
        validationWithSubmitClearForm.nameField.isText("");
        validationWithSubmitClearForm.emailField.isText("");
        validationWithSubmitClearForm.itemField.is().selected("Nothing selected");
        Thread.sleep(2000);
    }

    @Test
    public void ValidationWithSubmitClearFormResetTest() {
        validationWithSubmitClearForm.nameField.click();
        validationWithSubmitClearForm.emailField.click();
        validationWithSubmitClearForm.itemField.expand();
        validationWithSubmitClearForm.confirmingCheckBox.check();
        validationWithSubmitClearForm.confirmingCheckBox.uncheck();

        validationWithSubmitClearForm.nameField.message().is().visible();
        validationWithSubmitClearForm.emailField.message().is().visible();
        validationWithSubmitClearForm.itemField.is().hint("Hint doesn't exist");
    }
}
