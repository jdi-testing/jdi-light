package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formColumnSizing.cityName, "City"},
                {formColumnSizing.stateName, "State"},
                {formColumnSizing.zipCode, "Zip"}
        };
    }

    @DataProvider
    public Object[][] fieldsData() {
        return new Object[][]{
                {"Saint Petersburg", "Leningrad", "190500"},
                {"City", "State", "Zip"},
                {"VLG", "Stateless", "zip1220"}
        };
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

    @Test(dataProvider = "fieldsData")
    public void textFieldsTest(String city, String state, String zip) {
        formColumnSizing.cityName.sendKeys(city);
        formColumnSizing.cityName.is().value(city);

        formColumnSizing.stateName.sendKeys(state);
        formColumnSizing.stateName.is().value(state);

        formColumnSizing.zipCode.sendKeys(zip);
        formColumnSizing.zipCode.is().value(zip);

        formColumnSizing.cityName.clear();
        formColumnSizing.stateName.clear();
        formColumnSizing.zipCode.clear();
    }

    @Test
    public void baseValidations() {
        baseValidation(formColumnSizing);
        baseValidation(formColumnSizing.cityName);
        baseValidation(formColumnSizing.stateName);
        baseValidation(formColumnSizing.zipCode);
    }
}
