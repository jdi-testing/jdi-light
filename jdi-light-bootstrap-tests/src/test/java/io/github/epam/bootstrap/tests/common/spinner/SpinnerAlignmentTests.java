package io.github.epam.bootstrap.tests.common.spinner;

import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
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
                {spinnerAlignment.spinnerSectionLeft},
                {spinnerAlignment.flexJustifySpinnerSection},
                {spinnerAlignment.flexAlignCenterSpinnerSection},
                {spinnerAlignment.clearfixSpinnerSection},
                {spinnerAlignment.textCenterSpinnerSection},
        };
    }

    @DataProvider
    public Object[][] spinnerStyleData() {
        return new Object[][]{
                {spinnerAlignment.spinnerSectionLeft, spinnerMarginStyle},
                {spinnerAlignment.flexJustifySpinnerSection, spinnerJustifyContentStyle},
                {spinnerAlignment.flexAlignCenterSpinnerSection, spinnerAlignCenterStyle},
                {spinnerAlignment.clearfixSpinnerSection, spinnerClearfixStyle},
                {spinnerAlignment.textCenterSpinnerSection, spinnerTextCenterStyle},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "spinnerData")
    public void isValidationTest(Spinner spinner) {
        spinner.children().get(1).highlight();
        spinner
                .is()
                .enabled()
                .and()
                .displayed();
    }

    @Test(dataProvider = "spinnerData")
    public void spinnerBorderStyleTest(Spinner spinner) {
        spinner.children().get(1).is().core().hasClass(spinnerBorderStyle);
    }

    @Test(dataProvider = "spinnerStyleData")
    public void spinnerAlignmentStyleTest(Spinner spinner, String style) {
        spinner.is().core().hasClass(style);
    }

}
