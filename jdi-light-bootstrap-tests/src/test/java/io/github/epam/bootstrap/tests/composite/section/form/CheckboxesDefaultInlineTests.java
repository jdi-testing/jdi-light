package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxesDefaultInline;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxesDefaultInlineTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        checkboxesDefaultInline.checkboxOne
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check form-check-inline");
        /*checkboxesDefaultInline.checkboxOne.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("1"))
                .tag(is("label"));*/
        checkboxesDefaultInline.checkboxTwo
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check form-check-inline");
        /*checkboxesDefaultInline.checkboxTwo.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("2"))
                .tag(is("label"));*/
        checkboxesDefaultInline.checkboxThree
                .is()
                .displayed()
                .disabled()
                .core()
                .hasClass("form-check form-check-inline");
        /*checkboxesDefaultInline.checkboxThree.label()
                .is()
                .displayed()
                .core()
                .hasClass("form-check-label")
                .text(is("3 (disabled)"))
                .tag(is("label"));*/
    }

    @Test
    public void clickableTests() {
        checkboxesDefaultInline.checkboxOne.check();
        checkboxesDefaultInline.checkboxOne
                .is()
                .selected();
        checkboxesDefaultInline.checkboxOne.uncheck();
        checkboxesDefaultInline.checkboxOne
                .is()
                .deselected();
        checkboxesDefaultInline.checkboxTwo.check();
        checkboxesDefaultInline.checkboxTwo
                .is()
                .selected();
        checkboxesDefaultInline.checkboxTwo.uncheck();
        checkboxesDefaultInline.checkboxTwo
                .is()
                .deselected();
        /*checkboxesDefaultInline.checkboxOne.label().click();
        checkboxesDefaultInline.checkboxOne
                .is()
                .selected();
        checkboxesDefaultInline.checkboxOne.label().click();
        checkboxesDefaultInline.checkboxOne
                .is()
                .deselected();
        checkboxesDefaultInline.checkboxTwo.label().click();
        checkboxesDefaultInline.checkboxTwo
                .is()
                .selected();
        checkboxesDefaultInline.checkboxTwo.label().click();
        checkboxesDefaultInline.checkboxTwo
                .is()
                .deselected();*/
    }
}
