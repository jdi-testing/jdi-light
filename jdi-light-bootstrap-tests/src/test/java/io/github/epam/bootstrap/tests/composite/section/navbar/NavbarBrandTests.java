package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;

public class NavbarBrandTests extends TestsInit {

    private String imgPath = "images/wolverin.jpg";
    private String navbarUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
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
        for (int i = 1; i < navbarSection.allNavbarBrands.size() + 1; i++) {
            UIElement nbb = navbarSection.allNavbarBrands.get(i);
            if (nbb.hasAttribute("href")) {
                nbb.highlight();
                nbb.click();
                WebDriver driver = WebDriverFactory.getDriver();
                ArrayList<String> tabs = new ArrayList<>(
                        WebDriverFactory.getDriver().getWindowHandles());
                driver.switchTo().window(tabs.get(tabs.size() - 1));
                assertEquals(getUrl(), navbarUrl);
                driver.close();
                driver.switchTo().window(tabs.get(tabs.size() - 2));
            }
        }
    }

    @Test(dataProvider = "navbarBrandData")
    public void checkNavbarText(String navbarId, String navbarText) {
        for (int i = 1; i < navbarSection.allNavbarBrands.size() + 1; i++) {
            UIElement nbb = navbarSection.allNavbarBrands.get(i);
            if (nbb.attr("id").equals(navbarId)) {
                nbb.highlight();
                nbb.is().core().text(navbarText);
                nbb.unhighlight();
            }
        }
    }

    @Test
    public void checkNavbarClickImage() {
        navbarSection.navbarBrandWithImage.stream()
                .filter(nbb -> nbb.hasAttribute("href") && nbb.childs().size() > 0)
                .map(nbbWithIm -> nbbWithIm.childs().get(1))
                .forEach(imgFromNavbar -> {
                    imgFromNavbar.highlight("blue");
                    imgFromNavbar.is().attr("src", containsString(imgPath))
                            .tag("img");
                    imgFromNavbar.unhighlight();

                    imgFromNavbar.click();
                    WebDriver driver = WebDriverFactory.getDriver();
                    ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver()
                            .getWindowHandles());
                    driver.switchTo().window(tabs.get(tabs.size() - 1));
                    assertEquals(getUrl(), navbarUrl);
                    driver.close();
                    driver.switchTo().window(tabs.get(tabs.size() - 2));
                });
    }

    @Test
    public void baseValidationStreamJListTest() {
        for (int i = 1; i < navbarSection.allNavbarBrands.size() + 1; i++) {
            UIElement nb = navbarSection.allNavbarBrands.get(i);
            baseValidation(nb);
            nb.unhighlight();
        }
    }
}
