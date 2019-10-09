package io.github.epam.bootstrap.tests.composite.section.navbarbrand;

import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import io.github.epam.TestsInit;
import io.github.epam.bootstrap.tests.BaseValidations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.com.pages.BootstrapPage.progressSections;
import static io.github.epam.states.States.shouldBeLoggedIn;


/**
 * Created by Aleksandr Shiganov on 3.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class NavbarBrandTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] progressData() {
        return new Object[][]{
                {"striped_ordinary", "10", "rgba(0, 123, 255, 1)", "0", "100", "progress-bar-striped"},
                {"striped_success", "25", "rgba(40, 167, 69, 1)", "0", "100", "progress-bar-striped"},
                {"striped_info", "50", "rgba(23, 162, 184, 1)", "0", "100", "progress-bar-striped"},
                {"striped_warning", "75", "rgba(255, 193, 7, 1)", "0", "100", "progress-bar-striped"},
                {"striped_danger", "100", "rgba(220, 53, 69, 1)", "0", "100", "progress-bar-striped"}
        };
    }

    @Test(dataProvider = "progressData")
    public void checkProgressData(String progressId, String value, String color,
                                  String min, String max, String classStriped) {

        List<NavbarBrand> ln = navbarSection.navbarBrandLinkJList.stream().filter(navbarBrand ->
                        navbarBrand.hasAttribute("href")).collect(Collectors.toList());

    }

    @Test
    public void baseValidationTest() {
        navbarSection.navbarBrandLinkJList.forEach(BaseValidations::baseValidation);
    }
}