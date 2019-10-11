package io.github.epam.bootstrap.tests.composite.section.navbarbrand;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import io.github.epam.TestsInit;
import io.github.epam.bootstrap.tests.BaseValidations;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavbarBrandTests extends TestsInit {

    private List<NavbarBrand> navbarBrandList;
    private String imgPath = "images/wolverin.jpg";
    private String navbarUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();

        navbarBrandList = new ArrayList<NavbarBrand>();
        for (int i = 0; i < navbarSection.navbarBrandJList.size(); i++)
            navbarBrandList.add(navbarSection.navbarBrandJList.get(i));
    }

    @DataProvider
    public static Object[][] navbarBrandData() {
        return new Object[][]{
                {"brand-link", "Brand link"},
                {"brand-heading", "Brand heading"},
                {"brand-as-image", ""},
                {"brand-as-image-and-link", "Brand link"},
        };
    }

    @Test
    public void checkNavbarClickLink() {
        navbarBrandList.stream().filter(NavbarBrand::isLink).forEach(nbb -> {
            nbb.click();
            WebDriver driver = WebDriverFactory.getDriver();
            ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            assertEquals(getUrl(), navbarUrl);
            driver.close();
            driver.switchTo().window(tabs.get(tabs.size() - 2));
        });
    }

    @Test(dataProvider = "navbarBrandData")
    public void checkNavbarText(String navbarId, String navbarText) {
        navbarBrandList.stream().filter(navbarBrand ->
                navbarBrand.attr("id").equals(navbarId)).forEach(nbb -> {
            nbb.highlight();
            nbb.is().core()
                    .text(navbarText);
            nbb.unhighlight();
        });
    }

    @Test
    public void checkNavbarClickImage() {
        navbarBrandList.stream()
                .filter(nbb -> nbb.isLink() && nbb.childs().size() > 0)
                .map(nbbWithIm -> nbbWithIm.childs().get(0))
                .forEach(imgFromNavbar -> {

                    imgFromNavbar.highlight("blue");
                    imgFromNavbar.is().attr("src", containsString(imgPath))
                            .tag("img");
                    imgFromNavbar.unhighlight();

                    imgFromNavbar.click();
                    WebDriver driver = WebDriverFactory.getDriver();
                    ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
                    driver.switchTo().window(tabs.get(tabs.size() - 1));
                    assertEquals(getUrl(), navbarUrl);
                    driver.close();
                    driver.switchTo().window(tabs.get(tabs.size() - 2));
                });
    }

    @Test
    public void baseValidationStreamTest() {
        navbarBrandList.forEach(BaseValidations::baseValidation);
        navbarBrandList.forEach(NavbarBrand::unhighlight);
    }
}