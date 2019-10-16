package io.github.epam.bootstrap.tests.composite.section.spinner;

import io.github.com.sections.spinner.Spinner;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.spinnerAlignment;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class SpinnerAlignmentTests extends TestsInit {

    private static final String spinnerBorderStyle = "spinner-border";

    private static final String spinnerMarginStyle = "mb-3";
    private static final String spinnerJustifyContentStyle = "justify-content-center";
    private static final String spinnerAlignCenterStyle = "align-items-center";
    private static final String spinnerClearfixStyle = "clearfix";
    private static final String spinnerTextCenterStyle = "text-center";


    @DataProvider
    public Object[][] spinnerData() {
        return new Object[][]{
                {spinnerAlignment.spinnerLeft},
                {spinnerAlignment.flexJustifySpinner},
                {spinnerAlignment.flexAlignCenterSpinner},
                {spinnerAlignment.clearfixSpinner},
                {spinnerAlignment.textCenterSpinner},
        };
    }

    @DataProvider
    public Object[][] spinnerStyleData() {
        return new Object[][]{
                {spinnerAlignment.spinnerLeft, spinnerMarginStyle},
                {spinnerAlignment.flexJustifySpinner, spinnerJustifyContentStyle},
                {spinnerAlignment.flexAlignCenterSpinner, spinnerAlignCenterStyle},
                {spinnerAlignment.clearfixSpinner, spinnerClearfixStyle},
                {spinnerAlignment.textCenterSpinner, spinnerTextCenterStyle},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "spinnerData")
    public void isValidationTest(Spinner spinner) {
        spinner.childs().get(1).highlight();
        spinner
                .is()
                .enabled()
                .and()
                .displayed();
    }

    @Test(dataProvider = "spinnerData")
    public void spinnerBorderStyleTest(Spinner spinner) {
        spinner.childs().get(1).is().core().hasClass(spinnerBorderStyle);
    }

    @Test(dataProvider = "spinnerStyleData")
    public void spinnerAlignmentStyleTest(Spinner spinner, String style) {
        spinner.is().core().hasClass(style);
    }

}
