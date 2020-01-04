package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxesAndRadiosWithoutLabels;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxesAndRadiosWithoutLabelsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.open();
    }

    @Test
    public void isValidationTests() {
        checkboxesAndRadiosWithoutLabels.checkbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check")
                .tag(is("div"));
        checkboxesAndRadiosWithoutLabels.radioButtons
                .is()
                .displayed()
                .enabled()
                .core()
                .value("option1")
                .attr("type", "radio")
                .attr("aria-label", "...")
                .hasClass("form-check-input position-static")
                .tag(is("input"));
    }

    @Test
    public void checkboxClickableTests() {
        checkboxesAndRadiosWithoutLabels.checkbox.check();
        checkboxesAndRadiosWithoutLabels.checkbox
                .is()
                .selected();
        checkboxesAndRadiosWithoutLabels.checkbox.uncheck();
        checkboxesAndRadiosWithoutLabels.checkbox
                .is()
                .deselected();
    }

    @Test
    public void radioButtonTests() {
        checkboxesAndRadiosWithoutLabels.radioButtons.select(1);
        checkboxesAndRadiosWithoutLabels.radioButtons.list().get(1)
                .is()
                .selected();
        //checkboxesAndRadiosWithoutLabels.radioButtons.list()
        //        .is()
        //        .selected(1);
        //checkboxesAndRadiosWithoutLabels.radioButtons
        //        .is()
        //        .selected(1);
    }
}
