package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.com.entities.FormContacts;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;

import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class BootstrapValidationTest extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void formValidationTest() {

        boolean browserValidation = formCustomStyles.isBrowserValidation();
        Assert.assertFalse(browserValidation);

        formCustomStyles.submit(contact());
        Alerts.validateAlert(is("Form filled and submitted successfully"));

        WebList nameInvalidFeedback = formCustomStyles.getInvalidFeedback(formCustomStyles.name);
        nameInvalidFeedback.is().size(0);

        WebList nameValidFeedback = formCustomStyles.getValidFeedback(formCustomStyles.name);
        nameValidFeedback.is().size(1);
        nameValidFeedback.get(1).is()
                .displayed()
                .text("Looks good!")
                .css("color", "rgba(40, 167, 69, 1)");

        WebList userNameInvalidFeedback = formCustomStyles.getInvalidFeedback(formCustomStyles.userName);
        userNameInvalidFeedback.is().size(1);
        userNameInvalidFeedback.get(1).is()
                .displayed()
                .text("Please choose a username.")
                .css("color","rgba(220, 53, 69, 1)");

        WebList userNameValidFeedback = formCustomStyles.getValidFeedback(formCustomStyles.userName);
        userNameValidFeedback.is().size(0);
    }

    private FormContacts contact() {
        return new FormContacts().set(c -> {
            c.name = "NAME";
            c.lastName = "";
            c.userName = "";
            c.city = "";
            c.state = "";
            c.zip = "";
            c.accept = "";
            c.radio = "";
            c.email = "";
            c.password = "";
        });
    }
}
