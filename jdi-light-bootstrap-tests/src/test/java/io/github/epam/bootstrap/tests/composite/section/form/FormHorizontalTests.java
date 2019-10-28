package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.BLANK_CONTACT;
import static io.github.com.entities.FormUsers.HORIZONTAL_FORM_CONTACT;
import static io.github.com.entities.FormUsers.HORIZONTAL_FORM_DEFAULT;
import static io.github.com.entities.FormUsers.clearBlankContact;
import static io.github.com.pages.BootstrapPage.formHorizontal;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormHorizontalTests extends TestsInit {

    private String email = "delnot@gmail.com";
    private String password = "qwerty";
    private String radio = "option2";
    private String accept = "true";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        formHorizontal.email
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "email")
                .attr("placeholder", "Email")
                .tag(is("input"));
        formHorizontal.email.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Email");
        formHorizontal.password
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "password")
                .attr("placeholder", "Password")
                .tag(is("input"));
        formHorizontal.password.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Password");
        formHorizontal.accept
                .is()
                .displayed()
                .enabled()
                .core()
                .tag(is("div"));
        formHorizontal.accept.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .value("Example checkbox");
    }

    @Test
    public void radioOneIsValidationTests() {
        formHorizontal.radio.get(1).is()
                .displayed()
                .enabled()
                .core()
                .value("option1")
                .attr("type", "radio")
                .attr("name", "gridRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        formHorizontal.radio.get(2).is()
                .displayed()
                .enabled()
                .core()
                .value("option2")
                .attr("type", "radio")
                .attr("name", "gridRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioThreeIsValidationTests() {
        formHorizontal.radio.get(3).is()
                .displayed()
                .disabled()
                .core()
                .value("option3")
                .attr("type", "radio")
                .attr("name", "gridRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void baseInitRadioTests() {
        formHorizontal.radio.is()
                .size(3);
        formHorizontal.radio.get(1).is()
                .selected();
        formHorizontal.radio.get(2).is()
                .deselected();
        formHorizontal.radio.get(3).is()
                .deselected();
        formHorizontal.radio.get(3).is()
                .disabled();
        formHorizontal.radio.get(1).label()
                .is()
                .text(is("First radio"));
        formHorizontal.radio.get(2).label()
                .is()
                .text(is("Second radio"));
        formHorizontal.radio.get(3).label()
                .is()
                .text(is("Third disabled radio"));
    }


    @Test
    public void radioButtonByIndexTests() {
        formHorizontal.radio.select(2);
        formHorizontal.radio.get(2).is()
                .selected();
        formHorizontal.radio.get(1).is()
                .deselected();
        formHorizontal.radio.select(1);
        formHorizontal.radio.get(1).is()
                .selected();
        formHorizontal.radio.get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        formHorizontal.radio.get(2).label().click();
        formHorizontal.radio.get(2).is()
                .selected();
        formHorizontal.radio.get(1).is()
                .deselected();
        formHorizontal.radio.get(1).label().click();
        formHorizontal.radio.get(1).is()
                .selected();
        formHorizontal.radio.get(2).is()
                .deselected();
    }

    @Test
    public void emailInputTest() {
        formHorizontal.email.sendKeys("delnote");
        formHorizontal.submit();
        formHorizontal.check(BLANK_CONTACT.set(c -> c.email = "delnote"));
        formHorizontal.email.sendKeys("@");
        formHorizontal.submit();
        formHorizontal.check(BLANK_CONTACT.set(c -> c.email = "delnote@"));
        formHorizontal.email.sendKeys(".");
        formHorizontal.submit();
        formHorizontal.check(BLANK_CONTACT.set(c -> c.email = "delnote@."));
        formHorizontal.email.clear();
        formHorizontal.email.sendKeys("delnote@gmail.");
        formHorizontal.submit();
        formHorizontal.check(BLANK_CONTACT.set(c -> c.email = "delnote@gmail."));
        formHorizontal.email.sendKeys("com");
        formHorizontal.submit();
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
        clearBlankContact();
    }

    @Test
    public void formTest() {
        formHorizontal.fill(HORIZONTAL_FORM_CONTACT);
        formHorizontal.check(HORIZONTAL_FORM_CONTACT);
        formHorizontal.submit();
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void customFillingTest() {
        formHorizontal.fill(BLANK_CONTACT.set(c -> c.email = email));
        formHorizontal.check(BLANK_CONTACT);
        formHorizontal.fill(BLANK_CONTACT.set(c -> c.password = password));
        formHorizontal.check(BLANK_CONTACT);
        formHorizontal.fill(BLANK_CONTACT.set(c -> c.radio = radio));
        formHorizontal.check(BLANK_CONTACT);
        formHorizontal.fill(BLANK_CONTACT.set(c -> c.accept = accept));
        formHorizontal.check(BLANK_CONTACT);
        formHorizontal.submit();
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
        clearBlankContact();
    }

    @Test
    public void directFillingTest() {
        formHorizontal.email.sendKeys(email);
        formHorizontal.check(BLANK_CONTACT.set(c -> c.email = email));
        formHorizontal.password.sendKeys(password);
        formHorizontal.check(BLANK_CONTACT.set(c -> c.password = password));
        formHorizontal.radio.select(2);
        formHorizontal.check(BLANK_CONTACT.set(c -> c.radio = radio));
        formHorizontal.accept.setValue(accept);
        formHorizontal.check(BLANK_CONTACT.set(c -> c.accept = accept));
        formHorizontal.submit();
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
        clearBlankContact();
    }

    @Test
    public void submitEntityToContactFormTest() {
        formHorizontal.submit(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void sendMethodTest() {
        formHorizontal.fill(HORIZONTAL_FORM_CONTACT);
        formHorizontal.send();
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void sendEntityMethodTest() {
        formHorizontal.send(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void addEntityMethodTest() {
        formHorizontal.add(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void publishMethodTest() {
        formHorizontal.publish(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void saveMethodTest() {
        formHorizontal.save(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void updateMethodTest() {
        formHorizontal.update(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void cancelMethodTest() {
        formHorizontal.cancel(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void closeMethodTest() {
        formHorizontal.close(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void backMethodTest() {
        formHorizontal.back(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void selectMethodTest() {
        formHorizontal.select(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void nextMethodTest() {
        formHorizontal.next(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    @Test
    public void searchMethodTest() {
        formHorizontal.search(HORIZONTAL_FORM_CONTACT);
        validateAlerts();
        formHorizontal.check(HORIZONTAL_FORM_DEFAULT);
    }

    private void validateAlerts() {
        validateAlert(is("Submit button clicked."));
        validateAlert(is("Form submitted successfully"));
    }
}
