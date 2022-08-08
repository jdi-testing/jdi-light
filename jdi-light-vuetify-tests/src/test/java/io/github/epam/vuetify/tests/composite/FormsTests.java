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

    @Test
    public void rulesFormTest() {
        Rules rules = new Rules("Foo bar", "6", false, "Foobar");
        rulesForm.show();
        rulesForm.fill(rules);
        rulesForm.check(rules);

        rulesForm.firstName.has().hasErrorText("A maximum of 6 characters is allowed");
        rulesForm.maxCharacters.slideHorizontalTo("7");
        rulesForm.firstName.has().hasErrorText("No spaces are allowed");
        rulesForm.allowSpaces.check();
        rulesForm.firstName.has().hasErrorText("Values do not match");
        rulesForm.valueMustMatch.setText("Foo bar");
        rulesForm.firstName.has().hasNoError();
    }

    @Test
    public void validationWithSubmitClearFormTest() {
        ValidationWithSubmitClear entity = new ValidationWithSubmitClear("Batman", "dark_knight@gotaham.com", "Item 1", true);
        validationWithSubmitClearForm.show();
        validationWithSubmitClearForm.fill(entity);
        validationWithSubmitClearForm.check(entity);

        validationWithSubmitClearForm.validate();
        validationWithSubmitClearForm.resetFormButton.click();
        validationWithSubmitClearForm.isClear();
        validationWithSubmitClearForm.email.setText("dark_knight");
        validationWithSubmitClearForm.email.has().hasErrorText("E-mail must be valid");
        validationWithSubmitClearForm.resetValidationButton.click();
        validationWithSubmitClearForm.isValid();
    }

    @Test
    public void veeValidateForm() {
        VeeValidate entity = new VeeValidate("Batman", "7677777", "dark_knight@gotaham.com", "Item 1", true);
        veeValidateForm.show();
        veeValidateForm.fill(entity);
        veeValidateForm.check(entity);

        veeValidateForm.submitButton.click();
        veeValidateForm.isValid();

        veeValidateForm.clearButton.click();
        veeValidateForm.isClear();
    }

    @Test
    public void vuelidateFormTest() {
        Vuelidate entity = new Vuelidate("Batman", "dark_knight@gotaham.com", "Item 1", true);
        vuelidateForm.show();
        vuelidateForm.fill(entity);
        vuelidateForm.check(entity);

        vuelidateForm.submitButton.click();
        vuelidateForm.isValid();

        vuelidateForm.clearButton.click();
        vuelidateForm.isClear();
    }
}
