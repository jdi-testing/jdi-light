package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxesCustom;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxesCustomTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxesCustom.hover();
    }

    @Test
    public void isValidationTests() {
        checkboxesCustom.checkbox
                .is()
                .disappear()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("custom-control-input")
                .tag(is("input"));
        checkboxesCustom.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Check this custom checkbox"))
                .tag(is("label"));
        checkboxesCustom.checkboxContainer
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-checkbox")
                .tag(is("div"));
    }

    @Test
    public void clickableTests() {
        checkboxesCustom.checkboxContainer.check();
        checkboxesCustom.checkbox.is().selected();
        checkboxesCustom.checkboxContainer.check();
        checkboxesCustom.checkbox.is().deselected();
        checkboxesCustom.checkbox.label().click();
        checkboxesCustom.checkbox.is().selected();
        checkboxesCustom.checkbox.label().click();
        checkboxesCustom.checkbox.is().deselected();
    }
}
