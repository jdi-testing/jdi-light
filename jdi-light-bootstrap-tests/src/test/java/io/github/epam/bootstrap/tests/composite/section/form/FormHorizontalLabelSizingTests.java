package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formHorizontalLabelSizing;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
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

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formHorizontalLabelSizing.smallText, "form-control-sm", "col-form-label-sm"},
                {formHorizontalLabelSizing.commonText, "form-control", "col-form-label"},
                {formHorizontalLabelSizing.largeText, "form-control-lg", "col-form-label-lg"}
        };
    }

    @DataProvider
    public Object[] listEmails() {
        return new Object[]{
                "Aron_Paul@mail.com",
                "as_s-testing",
                "!@3"
        };
    }

    @Test(dataProvider = "listData")
    public void isValidationTests(TextField textField, String formClass, String labelClass) {
        textField.is()
                .displayed()
                .enabled()
                .core()
                .hasClass(formClass)
                .attr("type", "email")
                .attr("placeholder", labelClass)
                .tag(is("input"));

        textField.label().is()
                .displayed()
                .enabled()
                .core()
                .hasClass(labelClass)
                .value("Email");
    }

    @Test(dataProvider = "listEmails")
    public void textFieldsTest(String email) {
        formHorizontalLabelSizing.smallText.sendKeys(email);
        formHorizontalLabelSizing.smallText.is().value(email);

        formHorizontalLabelSizing.commonText.sendKeys(email);
        formHorizontalLabelSizing.commonText.is().value(email);

        formHorizontalLabelSizing.largeText.sendKeys(email);
        formHorizontalLabelSizing.largeText.is().value(email);

        formHorizontalLabelSizing.smallText.clear();
        formHorizontalLabelSizing.commonText.clear();
        formHorizontalLabelSizing.largeText.clear();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formHorizontalLabelSizing);
        baseValidation(formHorizontalLabelSizing.smallText);
        baseValidation(formHorizontalLabelSizing.commonText);
        baseValidation(formHorizontalLabelSizing.largeText);
    }
}
