package io.github.epam.vuetify.tests.composite;

import io.github.com.entities.form.Rules;
import io.github.com.entities.form.ValidationWithSubmitClear;
import io.github.com.entities.form.VeeValidate;
import io.github.com.entities.form.Vuelidate;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.formsPage;
import static io.github.com.pages.FormsPage.disabledForm;
import static io.github.com.pages.FormsPage.readonlyForm;
import static io.github.com.pages.FormsPage.rulesForm;
import static io.github.com.pages.FormsPage.validationWithSubmitClearForm;
import static io.github.com.pages.FormsPage.veeValidateForm;
import static io.github.com.pages.FormsPage.vuelidateForm;

public class FormsTests extends TestsInit {

    @BeforeClass
    public void before() {
        formsPage.open();
        waitCondition(() -> formsPage.isOpened());
        formsPage.checkOpened();
    }

    @Test(description = "Test checks form error messages")
    public void rulesFormTest() {
        Rules rules = new Rules("Foo bar", "6", false, "Foobar");
        rulesForm.show();
        rulesForm.fill(rules);
        rulesForm.firstName.has().errorMessage("A maximum of 6 characters is allowed");
        rulesForm.maxCharacters.setValue(7.0);
        rulesForm.firstName.has().errorMessage("No spaces are allowed");
        rulesForm.allowSpaces.check();
        rulesForm.firstName.has().errorMessage("Values do not match");
        rulesForm.valueMustMatch.setText("Foo bar");
        rulesForm.firstName.has().noErrorMessages();
    }

    @Test(description = "Test checks form filling, reset and submission")
    public void validationWithSubmitClearFormTest() {
        ValidationWithSubmitClear entity = new ValidationWithSubmitClear("Batman", "dark_knight@gotaham.com", "Item 1", true);
        validationWithSubmitClearForm.show();
        validationWithSubmitClearForm.fill(entity);
        validationWithSubmitClearForm.validate();
        validationWithSubmitClearForm.resetFormButton.click();
        validationWithSubmitClearForm.isClear();
        validationWithSubmitClearForm.email.setText("dark_knight");
        validationWithSubmitClearForm.email.has().errorMessage("E-mail must be valid");
        validationWithSubmitClearForm.resetValidationButton.click();
        validationWithSubmitClearForm.isValid();
    }

    @Test(description = "Test checks that veeValidateForm after submission is valid, and after pressing clear button it is clear")
    public void veeValidateForm() {
        VeeValidate entity = new VeeValidate("Batman", "7677777", "dark_knight@gotaham.com", "Item 1", true);
        veeValidateForm.show();
        veeValidateForm.fill(entity);
        veeValidateForm.submitButton.click();
        veeValidateForm.isValid();
        veeValidateForm.clearButton.click();
        veeValidateForm.isClear();
    }

    @Test(description = "Test checks that vuelidateForm after submission is valid, and after pressing clear button it is clear")
    public void vuelidateFormTest() {
        Vuelidate entity = new Vuelidate("Batman", "dark_knight@gotaham.com", "Item 1", true);
        vuelidateForm.show();
        vuelidateForm.fill(entity);
        vuelidateForm.submitButton.click();
        vuelidateForm.isValid();
        vuelidateForm.clearButton.click();
        vuelidateForm.isClear();
    }

    @Test(description = "Test checks if form field is enabled or disabled")
    public void disabledFormTest() {
        disabledForm.show();
        disabledForm.firstName.is().disabled();
        readonlyForm.show();
        readonlyForm.firstName.is().enabled();
    }

    @Test(description = "Test checks if form field is readonly or not")
    public void readonlyFormTest() {
        readonlyForm.show();
        readonlyForm.firstName.is().readonly();
        disabledForm.show();
        disabledForm.firstName.is().notReadonly();
    }
}
