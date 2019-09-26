package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.common.TextTypes.TEXT;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

/**
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private static final String HOME = "Home";
    private static final String HTML5 = "HTML 5";
    private static final String BOOTSTRAP = "Bootstrap";
    private static final String[] ITEMS_VALUES = new String[]{HOME, HTML5, BOOTSTRAP};

    @Test
    public void getTextTest() {
        breadcrumb.items.has().size(ITEMS_VALUES.length);
        breadcrumb.items.assertThat().values(TEXT, hasItems(ITEMS_VALUES));
    }

    @Test
    public void getValueTest() {
        breadcrumb.items.has().size(ITEMS_VALUES.length);
        assertThat(breadcrumb.items.values().toArray(), is(ITEMS_VALUES));
    }

    @Test
    public void getFirstItemTest() {
        breadcrumb.items.first().has().value(HOME);
        breadcrumb.items.first().is().text(HOME);
    }

    @Test
    public void getCurrectItemTest() {
        breadcrumb.items.last().has().value(BOOTSTRAP);
        breadcrumb.items.last().has().text(BOOTSTRAP);
    }

    @Test
    public void clickCurrectItemTest(){
        breadcrumb.items.last().click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        assertThat(tabs.size(), is(1));
    }

    @Test
    public void clickByNameTest() {
        breadcrumb.items.get(HTML5).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertThat(WebPage.getTitle(), is(HTML5));

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void clickByIDTest() {
        breadcrumb.items.get(0).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertThat(WebPage.getTitle().contains(HOME), is(true));

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValdidationTest() {
        breadcrumb.shouldBe().enabled();
        breadcrumb.shouldBe().displayed()
                .core()
                .cssClass("breadcrumb")
                .tag(is("ol"))
                .css("display", is("flex"))
                .css("flex-wrap", is("wrap"))
                .css("background-color", is("rgba(233, 236, 239, 1)")) //#e9ecef Color Hex
                .css("color", is("rgba(102, 102, 102, 1)"))//#666 Color Hex
                .css("font-size", is("14px"));

        for (UIElement item : breadcrumb.items) {
            item.shouldBe().enabled();
            item.shouldBe().displayed()
                    .core()
                    .tag(is("li"));
        }

        breadcrumb.items.last().shouldBe().displayed()
                .core()
                .attr("aria-current", "page")
                .cssClass("breadcrumb-item active")
                .css("color", is("rgba(108, 117, 125, 1)")); //#6c757d Color Hex

        for (UIElement item : breadcrumb.items.finds(By.tagName("a"))) {
            item.shouldBe().enabled();
            item.shouldBe().displayed()
                    .core()
                    .tag(is("a"))
                    .css("color", is("rgba(57, 194, 215, 1)")); //#39c2d7 Color Hex
        }
    }

    @Test
    public void baseValidationTest() {
        baseValidation(breadcrumb);
    }
}
