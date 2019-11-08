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
import static io.github.com.entities.FormUsers.BLANK_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.clearBlankContact;
import static io.github.com.pages.BootstrapPage.formTooltip;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 14.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class FormTooltipTests extends TestsInit {

    private String name = "Dmitrii";
    private String lastName = "Pavlov";
    private String userName = "Delnote";
    private String city = "Saint-Petersburg";
    private String state = "North capital";
    private String zip = "190000";
    private String positiveTooltip = "Looks good!";
    private String negativeTooltip = "Please provide a valid";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formTooltip.name, "First name", "Mark"},
                {formTooltip.lastName, "Last name", "Otto"},
                {formTooltip.userName, "Username", ""},
                {formTooltip.city, "City", ""},
                {formTooltip.state, "State", ""},
                {formTooltip.zip, "Zip", ""}
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
    public void tooltipTests() {
        checkContactFormSubmitted();
        formTooltip.tooltipName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is(positiveTooltip));
        formTooltip.tooltipLastName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is(positiveTooltip));
        formTooltip.tooltipUserName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is("Please choose a unique and valid username."));
        formTooltip.tooltipCity
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " city."));
        formTooltip.tooltipState
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " state."));
        formTooltip.tooltipZip
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " zip."));
    }

    @Test
    public void fillTest() {
        formTooltip.fill(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void customFillingTest() {
        formTooltip.fill(BLANK_CONTACT.set(c -> c.name = name));
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT);
        formTooltip.fill(BLANK_CONTACT.set(c -> c.lastName = lastName));
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT);
        formTooltip.fill(BLANK_CONTACT.set(c -> c.userName = userName));
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT);
        formTooltip.fill(BLANK_CONTACT.set(c -> c.city = city));
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT);
        formTooltip.fill(BLANK_CONTACT.set(c -> c.state = state));
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT);
        formTooltip.fill(BLANK_CONTACT.set(c -> c.zip = zip));
        checkContactFormSubmitted();
        formTooltip.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void directFillingTest() {
        formTooltip.name.clear();
        formTooltip.lastName.clear();
        formTooltip.name.setValue(name);
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT.set(c -> c.name = name));
        formTooltip.lastName.setValue(lastName);
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT.set(c -> c.lastName = lastName));
        formTooltip.userName.sendKeys(userName);
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT.set(c -> c.userName = userName));
        formTooltip.city.sendKeys(city);
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT.set(c -> c.city = city));
        formTooltip.state.sendKeys(state);
        checkContactFormSubmitted();
        formTooltip.check(BLANK_CONTACT.set(c -> c.state = state));
        formTooltip.zip.sendKeys(zip);
        checkContactFormSubmitted();
        formTooltip.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void submitTextToContactFormTest() {
        formTooltip.submit("Roman");
        formTooltip.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formTooltip.submit(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formTooltip.submit("Roman", "submit");
        formTooltip.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formTooltip.fill(DEFAULT_CONTACT);
        List<String> verified = formTooltip.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formTooltip.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formTooltip.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formTooltip.fill(DEFAULT_CONTACT);
        formTooltip.send();
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formTooltip.send(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formTooltip.add(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formTooltip.publish(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formTooltip.save(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formTooltip.update(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formTooltip.cancel(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formTooltip.close(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formTooltip.back(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formTooltip.select(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formTooltip.next(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formTooltip.search(DEFAULT_CONTACT);
        formTooltip.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formTooltip.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
