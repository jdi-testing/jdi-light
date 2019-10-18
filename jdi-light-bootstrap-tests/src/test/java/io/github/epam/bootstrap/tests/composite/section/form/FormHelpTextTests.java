package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formHelpText;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class FormHelpTextTests extends TestsInit {

    private String passwordOneHelpText = "Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.";
    private String passwordTwoHelpText = "Must be 8-20 characters long.";
    private String testText = "Text to in";
    private String moreTestText = "put for test.";
    private String label = "Password";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        formHelpText.passwordOne
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "password")
                .attr("aria-describedby", "passwordHelpBlock")
                .tag(is("input"));
        formHelpText.passwordOne.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is(label));
        formHelpText.passwordTwo
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "password")
                .attr("aria-describedby", "passwordHelpInline")
                .tag(is("input"));
        formHelpText.passwordTwo.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is(label));
    }

    @Test
    public void helpTextTests() {
        formHelpText.passwordOneHelpText
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-text")
                .hasClass("text-muted")
                .text(is(passwordOneHelpText))
                .tag(is("small"));
        formHelpText.passwordTwoHelpText
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("text-muted")
                .text(is(passwordTwoHelpText))
                .tag(is("small"));
    }

    @Test
    public void textInputTests() {
        formHelpText.passwordOne.setValue(testText);
        formHelpText.passwordOne
                .is()
                .text(testText);
        formHelpText.passwordOne.sendKeys(moreTestText);
        formHelpText.passwordOne
                .is()
                .text(testText + moreTestText);
        formHelpText.passwordOne.clear();
        formHelpText.passwordOne.sendKeys(moreTestText);
        formHelpText.passwordOne
                .is()
                .text(moreTestText);
        formHelpText.passwordTwo.setValue(testText);
        formHelpText.passwordTwo
                .is()
                .text(testText);
        formHelpText.passwordTwo.sendKeys(moreTestText);
        formHelpText.passwordTwo
                .is()
                .text(testText + moreTestText);
        formHelpText.passwordTwo.clear();
        formHelpText.passwordTwo.sendKeys(moreTestText);
        formHelpText.passwordTwo
                .is()
                .text(moreTestText);
    }
}
