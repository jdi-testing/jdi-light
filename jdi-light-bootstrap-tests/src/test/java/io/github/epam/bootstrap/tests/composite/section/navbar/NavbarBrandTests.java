package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.settings.WebSettings;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
                {navbarSection.navbarBrandLink, "Brand link"},
                {navbarSection.navbarBrandHeading, "Brand heading"},
                {navbarSection.navbarBrandAsImage, ""},
                {navbarSection.navbarBrandAsImageAndLink, "Brand link"},
        };
    }

    @DataProvider
    public static Object[][] navbarBrandImage() {
        return new Object[][]{
                {navbarSection.navbarBrandAsImage},
                {navbarSection.navbarBrandAsImageAndLink},
        };
    }

    /*@Test
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
*/
    @Test(dataProvider = "navbarBrandData")
    public void checkNavbarText(UIBaseElement uiBaseElement, String navbarText) {
                uiBaseElement.highlight();
                uiBaseElement.is().core().text(navbarText);
                uiBaseElement.unhighlight();
            }


    @Test(dataProvider = "navbarBrandImage")
    public void checkNavbarClickImage() {

        navbarSection.navbarBrandAsImage.is().core().hasAttr("href");
        UIElement imgFromNavbar = navbarSection.navbarBrandAsImage.childs().get(1);
        imgFromNavbar.highlight("blue");
        imgFromNavbar.is().core().tag("img").attr("src", containsString(imgPath));
        imgFromNavbar.unhighlight();
        imgFromNavbar.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(navbarUrl));
        WindowsManager.closeWindow();



                   /* WebDriver driver = WebDriverFactory.getDriver();
                    ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver()
                            .getWindowHandles());
                    driver.switchTo().window(tabs.get(tabs.size() - 1));
                    assertEquals(getUrl(), navbarUrl);
                    driver.close();
                    driver.switchTo().window(tabs.get(tabs.size() - 2));*/

    }

    @Test
    public void baseValidationStreamJListTest() {
        baseValidation(navbarSection.navbarBrandLink);
        navbarSection.navbarBrandLink.unhighlight();

        baseValidation(navbarSection.navbarBrandHeading);
        navbarSection.navbarBrandHeading.unhighlight();

        baseValidation(navbarSection.navbarBrandAsImage);
        navbarSection.navbarBrandAsImage.unhighlight();

        baseValidation(navbarSection.navbarBrandAsImageAndLink);
        navbarSection.navbarBrandAsImageAndLink.unhighlight();
    }
}
