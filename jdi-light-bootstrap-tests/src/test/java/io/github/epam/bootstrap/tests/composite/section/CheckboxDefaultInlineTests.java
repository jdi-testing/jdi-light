package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxDefaultInline;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxDefaultInlineTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        checkboxDefaultInline.checkboxOne
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .attr("value", "option1")
                .hasClass("form-check-input")
                .tag(is("input"));
        checkboxDefaultInline.checkboxOne.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("1"))
                .tag(is("label"));
        checkboxDefaultInline.checkboxTwo
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .attr("value", "option2")
                .hasClass("form-check-input")
                .tag(is("input"));
        checkboxDefaultInline.checkboxTwo.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("2"))
                .tag(is("label"));
        checkboxDefaultInline.checkboxThree
                .is()
                .displayed()
                .disabled()
                .core()
                .attr("type", "checkbox")
                .attr("value", "option3")
                .hasClass("form-check-input")
                .tag(is("input"));
        checkboxDefaultInline.checkboxThree.label()
                .is()
                .displayed()
                .core()
                .hasClass("form-check-label")
                .text(is("3 (disabled)"))
                .tag(is("label"));
    }

    @Test
    public void clickableTests() {
        checkboxDefaultInline.checkboxOne.check();
        checkboxDefaultInline.checkboxOne
                .is()
                .selected();
        checkboxDefaultInline.checkboxOne.uncheck();
        checkboxDefaultInline.checkboxOne
                .is()
                .deselected();
        checkboxDefaultInline.checkboxTwo.check();
        checkboxDefaultInline.checkboxTwo
                .is()
                .selected();
        checkboxDefaultInline.checkboxTwo.uncheck();
        checkboxDefaultInline.checkboxTwo
                .is()
                .deselected();
        checkboxDefaultInline.checkboxOne.label().click();
        checkboxDefaultInline.checkboxOne
                .is()
                .selected();
        checkboxDefaultInline.checkboxOne.label().click();
        checkboxDefaultInline.checkboxOne
                .is()
                .deselected();
        checkboxDefaultInline.checkboxTwo.label().click();
        checkboxDefaultInline.checkboxTwo
                .is()
                .selected();
        checkboxDefaultInline.checkboxTwo.label().click();
        checkboxDefaultInline.checkboxTwo
                .is()
                .deselected();
    }
}
