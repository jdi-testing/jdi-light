package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formColumnSizing;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Bordiugov on 21.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormColumnSizingTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "listData")
    public void isValidationTests(TextField textField, String placeholder) {
        textField.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", placeholder)
                .tag(is("input"));
    }

    @Test(dataProvider = "list")
    public void textFieldsTest(String txt) {
        /*formColumnSizing.cityName.sendKeys();
        formColumnSizing.cityName.is().value();

        formColumnSizing.stateName.sendKeys();
        formColumnSizing.stateName.is().value();

        formColumnSizing.zipCode.sendKeys();
        formColumnSizing.zipCode.is().value();

        formColumnSizing.cityName.clear();
        formColumnSizing.stateName.clear();
        formColumnSizing.zipCode.clear();*/
    }

    @Test
    public void baseValidations() {
        baseValidation(formColumnSizing);
        baseValidation(formColumnSizing.cityName);
        baseValidation(formColumnSizing.stateName);
        baseValidation(formColumnSizing.zipCode);
    }
}
