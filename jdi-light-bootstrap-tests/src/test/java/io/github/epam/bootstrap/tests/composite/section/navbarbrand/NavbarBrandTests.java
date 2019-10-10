package io.github.epam.bootstrap.tests.composite.section.navbarbrand;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import io.github.epam.TestsInit;
import io.github.epam.bootstrap.tests.BaseValidations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;


/**
 * Created by Aleksandr Shiganov on 3.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class NavbarBrandTests extends TestsInit {

    private String navbarUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";
    private List<NavbarBrand> navbarBrandList;




    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();

        navbarBrandList = new ArrayList<NavbarBrand>();
        for (int i = 0; i < navbarSection.navbarBrandJList.size(); i++)
            navbarBrandList.add(navbarSection.navbarBrandJList.get(i));
    }

    @DataProvider
    public static Object[][] navbarData() {
        return new Object[][]{
                {"striped_ordinary", "10", "rgba(0, 123, 255, 1)", "0", "100", "progress-bar-striped"},
                {"striped_success", "25", "rgba(40, 167, 69, 1)", "0", "100", "progress-bar-striped"},
                {"striped_info", "50", "rgba(23, 162, 184, 1)", "0", "100", "progress-bar-striped"},
                {"striped_warning", "75", "rgba(255, 193, 7, 1)", "0", "100", "progress-bar-striped"},
                {"striped_danger", "100", "rgba(220, 53, 69, 1)", "0", "100", "progress-bar-striped"}
        };
    }
/*
    @Test(dataProvider = "navbarData")
    public void checkProgressData(String progressId, String value, String color,
                                  String min, String max, String classStriped) {

        List<NavbarBrand> ln = navbarSection.navbarBrandLinkJList.stream().filter(navbarBrand ->
                        navbarBrand.hasAttribute("href")).collect(Collectors.toList());

    }*/

    @Test(dataProvider = "progressData")
    public void checkProgressData(String progressId, String value, String color,
                                  String min, String max, String classStriped) {
    }

    @Test
    public void checkLink() {
        navbarSection.navbarBrandJList.stream().filter(navbarBrand ->
                navbarBrand.hasAttribute("href")).forEach(nbb -> {
            nbb.click();
            ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
            WebDriver driver = WebDriverFactory.getDriver();
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            assertEquals(getUrl(), navbarUrl);
            driver.close();
            driver.switchTo().window(tabs.get(tabs.size() - 2));
            bsPage.checkOpened();
        });
    }

    @Test
    public void baseValidationTest() {
        for (int i = 0; i < navbarSection.navbarBrandJList.size(); i++)
            baseValidation(navbarSection.navbarBrandJList.get(i));
        //This is a BUG. Start take elements from get(1) instead of
        /*navbarSection.navbarBrandJList.forEach(BaseValidations::baseValidation);*/
    }

    @Test
    public void baseValidationStreamTest1() {
        //This is a BUG. Start take elements from get(1) instead of
        navbarBrandList.forEach(BaseValidations::baseValidation);
    }

    @Test
    public void baseValidationStreamTest2() {
        //This is a BUG. Start take elements from get(1) instead of
        navbarSection.navbarBrandJList.forEach(BaseValidations::baseValidation);
    }
}