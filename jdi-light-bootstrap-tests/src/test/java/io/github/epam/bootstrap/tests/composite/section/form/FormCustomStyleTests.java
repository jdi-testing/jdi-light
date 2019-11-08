package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 10.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class FormCustomStyleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formCustomStyles.name, "First name", "Mark"},
                {formCustomStyles.lastName, "Last name", "Otto"},
                {formCustomStyles.userName, "Username", ""},
                {formCustomStyles.city, "City", ""},
                {formCustomStyles.state, "State", ""},
                {formCustomStyles.zip, "Zip", ""}
        };
    }

    @Test(dataProvider = "listData")
    public void isValidationTests(TextField element, String label, String value) {
        element
                .is()
                .displayed()
                .enabled()
                .core()
                .value(value)
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", label)
                .tag(is("input"));
        element.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is(label));
    }

    @Test
    public void isValidationTests() {
        formCustomStyles.accept
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check")
                .tag(is("div"));
        formCustomStyles.accept.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Agree to terms and conditions"))
                .tag(is("label"));
    }

    @Test
    public void checkboxTests() {
        formCustomStyles.accept.check();
        formCustomStyles.accept.is().selected();
        formCustomStyles.accept.uncheck();
        formCustomStyles.accept.is().deselected();
    }

    @Test
    public void fillTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormTest() {
        formCustomStyles.submit("Roman");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formCustomStyles.submit(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formCustomStyles.submit("Roman", "submit");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formCustomStyles.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.send();
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formCustomStyles.send(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formCustomStyles.add(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formCustomStyles.publish(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formCustomStyles.save(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formCustomStyles.update(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formCustomStyles.cancel(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formCustomStyles.close(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formCustomStyles.back(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formCustomStyles.select(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formCustomStyles.next(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formCustomStyles.search(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formCustomStyles.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
