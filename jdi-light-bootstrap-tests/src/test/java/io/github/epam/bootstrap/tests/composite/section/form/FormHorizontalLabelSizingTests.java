package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formHorizontalLabelSizing;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Bordiugov on 18.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormHorizontalLabelSizingTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTests() {
        formHorizontalLabelSizing.smallText.is() //parametrize
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control-sm") //parametrize
                .attr("type", "email")
                .attr("placeholder", "col-form-label-sm") //parametrize //form-control //form-control-lg
                .tag(is("input"));

        formHorizontalLabelSizing.smallText.label().is()
                .displayed()
                .enabled()
                .core()
                .hasClass("col-form-label-sm") //parametrize
                .value("Email");
    }
}
