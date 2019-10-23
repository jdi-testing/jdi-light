package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formRow;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormRowTests extends TestsInit {

    private String textFirstName = "First name";
    private String textLastName = "Last name";
    private String textForSendKeys = "test send keys";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkStructureRow() {
        formRow.row.assertThat().hasClass("form-row");
        formRow.row.is().enabled().displayed();
        formRow.row.childs().foreach(e -> e.is()
                .displayed()
                .enabled());
        formRow.cols.childs().foreach(e -> e.is()
                .tag("input")
        );
    }

    @Test
    public void setTextTest() {
        formRow.firstName.setValue(textFirstName);
        formRow.firstName.assertThat().text(is(textFirstName));
        formRow.lastName.setValue(textLastName);
        formRow.lastName.assertThat().text(is(textLastName));
    }

    @Test
    public void sendKeysTest() {
        formRow.firstName.sendKeys(textForSendKeys);
        formRow.lastName.sendKeys(textForSendKeys);
        formRow.firstName.assertThat().text(is(textForSendKeys));
        formRow.lastName.assertThat().text(is(textForSendKeys));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formRow.firstName);
        baseValidation(formRow.lastName);
    }
}
