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
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.BLANK_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.clearBlankContact;
import static io.github.com.pages.BootstrapPage.formTooptip;
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
                {formTooptip.name, "First name", "Mark"},
                {formTooptip.lastName, "Last name", "Otto"},
                {formTooptip.userName, "Username", ""},
                {formTooptip.city, "City", ""},
                {formTooptip.state, "State", ""},
                {formTooptip.zip, "Zip", ""}
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
        formTooptip.tooltipName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is(positiveTooltip));
        formTooptip.tooltipLastName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is(positiveTooltip));
        formTooptip.tooltipUserName
                .is()
                .displayed()
                .core()
                .hasClass("valid-tooltip")
                .text(is("Please choose a unique and valid username."));
        formTooptip.tooltipCity
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " city."));
        formTooptip.tooltipState
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " state."));
        formTooptip.tooltipZip
                .is()
                .displayed()
                .core()
                .hasClass("invalid-tooltip")
                .text(is(negativeTooltip + " zip."));
    }

    @Test
    public void fillTest() {
        formTooptip.fill(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void customFillingTest() {
        formTooptip.fill(BLANK_CONTACT.set(c -> c.name = name));
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT);
        formTooptip.fill(BLANK_CONTACT.set(c -> c.lastName = lastName));
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT);
        formTooptip.fill(BLANK_CONTACT.set(c -> c.userName = userName));
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT);
        formTooptip.fill(BLANK_CONTACT.set(c -> c.city = city));
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT);
        formTooptip.fill(BLANK_CONTACT.set(c -> c.state = state));
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT);
        formTooptip.fill(BLANK_CONTACT.set(c -> c.zip = zip));
        checkContactFormSubmitted();
        formTooptip.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void directFillingTest() {
        formTooptip.name.clear();
        formTooptip.lastName.clear();
        formTooptip.name.setValue(name);
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT.set(c -> c.name = name));
        formTooptip.lastName.setValue(lastName);
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT.set(c -> c.lastName = lastName));
        formTooptip.userName.sendKeys(userName);
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT.set(c -> c.userName = userName));
        formTooptip.city.sendKeys(city);
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT.set(c -> c.city = city));
        formTooptip.state.sendKeys(state);
        checkContactFormSubmitted();
        formTooptip.check(BLANK_CONTACT.set(c -> c.state = state));
        formTooptip.zip.sendKeys(zip);
        checkContactFormSubmitted();
        formTooptip.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void submitTextToContactFormTest() {
        formTooptip.submit("Roman");
        formTooptip.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formTooptip.submit(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formTooptip.submit("Roman", "submit");
        formTooptip.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formTooptip.fill(DEFAULT_CONTACT);
        List<String> verified = formTooptip.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formTooptip.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formTooptip.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formTooptip.fill(DEFAULT_CONTACT);
        formTooptip.send();
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formTooptip.send(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formTooptip.add(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formTooptip.publish(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formTooptip.save(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formTooptip.update(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formTooptip.cancel(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formTooptip.close(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formTooptip.back(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formTooptip.select(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formTooptip.next(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formTooptip.search(DEFAULT_CONTACT);
        formTooptip.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formTooptip.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
