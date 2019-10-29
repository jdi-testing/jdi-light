package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.INLINE_FORM_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_INLINE_FORM_CONTACT;
import static io.github.com.pages.BootstrapPage.formInlinePreference;
import static io.github.com.pages.BootstrapPage.formInlineUsername;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class FormInlineTests extends TestsInit {

    private String name = "Arnold";
    private String userName = "Reiner";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] fields() {
        return new Object[][]{
                {formInlineUsername.name, "Jane Doe"},
                {formInlineUsername.userName, "Username"}
        };
    }

    @Test(dataProvider = "fields")
    public void isValidationTest(TextField field, String value) {
        field.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .tag(is("input"))
                .attr("placeholder", value);
    }

    @Test
    public void checkboxTests() {
        formInlineUsername.rememberMe.check();
        formInlineUsername.rememberMe.is().selected();
        formInlineUsername.rememberMe.uncheck();
        formInlineUsername.rememberMe.is().deselected();
        formInlinePreference.rememberPreference.label().click();
        formInlinePreference.rememberPreference.is().selected();
        formInlinePreference.rememberPreference.label().click();
        formInlinePreference.rememberPreference.is().deselected();
    }

    @Test
    public void fillTest() {
        formInlineUsername.fill(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void directFillingTest() {
        formInlineUsername.name.setValue(name);
        formInlineUsername.userName.setValue(userName);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void submitTextToContactFromTest() {
        formInlineUsername.submit(name);
        formInlineUsername.check(ONLY_NAME_FILLED_INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void submitTextToContactFromUsingCustomButtonTest() {
        formInlineUsername.submit(name, "submit");
        formInlineUsername.check(ONLY_NAME_FILLED_INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void verifyMethodPositiveTest() {
        formInlineUsername.fill(INLINE_FORM_CONTACT);
        List<String> verified = formInlineUsername.verify(INLINE_FORM_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void sendMethodTest() {
        formInlineUsername.fill(INLINE_FORM_CONTACT);
        formInlineUsername.send();
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void sendEntityMethodText() {
        formInlineUsername.send(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void addEntityMethodTest() {
        formInlineUsername.add(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void publishMethodText() {
        formInlineUsername.add(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void saveMethodTest() {
        formInlineUsername.save(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void updateMethodTest() {
        formInlineUsername.update(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void cancelMethodTest() {
        formInlineUsername.cancel(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void closeMethodTest() {
        formInlineUsername.close(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void backMethodTest() {
        formInlineUsername.back(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void selectMethodTest() {
        formInlineUsername.select(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void nextMethodTest() {
        formInlineUsername.next(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    @Test
    public void searchMethodTest() {
        formInlineUsername.search(INLINE_FORM_CONTACT);
        formInlineUsername.check(INLINE_FORM_CONTACT);
        checkInlineFormSubmitted();
    }

    private void checkInlineFormSubmitted() {
        formInlineUsername.submit();
        validateAlert(is("Submit button clicked"));
    }
}
