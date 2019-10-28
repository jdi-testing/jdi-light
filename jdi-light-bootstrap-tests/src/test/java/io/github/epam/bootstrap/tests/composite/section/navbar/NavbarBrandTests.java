package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;

public class NavbarBrandTests extends TestsInit {

    private String imgPath = "images/wolverin.jpg";
    private String navbarUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] navbarBrands() {
        return new Object[][]{
                {navbarSection.navbarBrandLink, "Brand link"},
                {navbarSection.navbarBrandHeading, "Brand heading"},
                {navbarSection.navbarBrandAsImage, ""},
                {navbarSection.navbarBrandAsImageAndLink, "Brand link"},
        };
    }

    @DataProvider
    public static Object[][] navbarBrandsWithImage() {
        return new Object[][]{
                {navbarSection.navbarBrandAsImage},
                {navbarSection.navbarBrandAsImageAndLink},
        };
    }

    @DataProvider
    public static Object[][] navbarBrandsWithLink() {
        return new Object[][]{
                {navbarSection.navbarBrandLink},
                {navbarSection.navbarBrandAsImage},
                {navbarSection.navbarBrandAsImageAndLink},
        };
    }

    @Test (dataProvider = "navbarBrandsWithLink")
    public void  checkNavbarLink(UIElement brandAsLink) {
        brandAsLink.is().core().hasAttr("href");
        brandAsLink.highlight("blue");
        brandAsLink.unhighlight();
        brandAsLink.click();
        int winNumber = WindowsManager.windowsCount();
        WindowsManager.switchToWindow(winNumber);
        assertThat(getUrl(), is(navbarUrl));
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(winNumber - 1);
        }

    @Test(dataProvider = "navbarBrands")
    public void checkNavbarText(UIElement uiBaseElement, String navbarText) {
                uiBaseElement.highlight();
                uiBaseElement.is().core().text(navbarText);
                uiBaseElement.unhighlight();
            }

    @Test(dataProvider = "navbarBrandsWithImage")
    public void checkNavbarImage(UIElement brandWithImage) {

        brandWithImage.is().core().hasAttr("href");
        UIElement imgFromNavbar = brandWithImage.childs().get(1);
        imgFromNavbar.highlight("blue");
        imgFromNavbar.is().core().tag("img").attr("src", containsString(imgPath));
        imgFromNavbar.unhighlight();
        imgFromNavbar.click();
        int winNumber = WindowsManager.windowsCount();
        WindowsManager.switchToWindow(winNumber);
        assertThat(getUrl(), is(navbarUrl));
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(winNumber - 1);
    }

    @Test(dataProvider = "navbarBrands")
    public void baseValidationNavbarBrand(Object...nbBrand) {
        baseValidation((UIElement) nbBrand[0]);
       ((UIElement) nbBrand[0]).unhighlight();
    }
}
