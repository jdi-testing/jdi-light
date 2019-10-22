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

    private String text_first_name = "First name";
    private String text_last_name = "Last name";
    private String text_for_send_keys = "test send keys";

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
        formRow.firstName.setValue(text_first_name);
        formRow.firstName.assertThat().text(is(text_first_name));
        formRow.lastName.setValue(text_last_name);
        formRow.lastName.assertThat().text(is(text_last_name));
    }

    @Test
    public void sendKeysTest() {
        formRow.firstName.sendKeys(text_for_send_keys);
        formRow.lastName.sendKeys(text_for_send_keys);
        formRow.firstName.assertThat().text(is(text_for_send_keys));
        formRow.lastName.assertThat().text(is(text_for_send_keys));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formRow.firstName);
        baseValidation(formRow.lastName);
    }
}
