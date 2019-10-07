package io.github.epam.bootstrap.tests.composite.section;

import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressMultipleBars;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Roman Bordiugov on 7.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class ProgressMultipleBarsTests {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] progressMultipleBarsData() {
        return new Object[][]{
                {progressMultipleBars.multipleOrdinary},
                {progressMultipleBars.multipleSuccess},
                {progressMultipleBars.multipleInfo}
        };
    }

    @Test(dataProvider = "progressMultipleBarsData")
    public void isValidationTest(Progress progress) {
        progress.is().enabled().and().displayed();
    }

    @Test(dataProvider = "progressMultipleBarsData")
    public void baseValidationTest(Progress progress) {
        baseValidation(progress);
    }
}
