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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private static final String HOME = "Home";
    private static final String HTML5 = "HTML 5";
    private static final String BOOTSTRAP = "Bootstrap";
    private static final List<String> ITEMS_VALUES = Arrays.asList(HOME, HTML5, BOOTSTRAP);

    @Test
    public void getTextTest() {
        List<String> itemsTexts = breadcrumb.itemns.stream().map(UIElement::getText).collect(Collectors.toList());

        breadcrumb.itemns.has().size(ITEMS_VALUES.size());
        assertThat(itemsTexts, is(ITEMS_VALUES));
    }

    @Test
    public void getValueTest() {
        List<String> itemsValues = breadcrumb.itemns.stream().map(UIElement::getValue).collect(Collectors.toList());

        breadcrumb.itemns.has().size(ITEMS_VALUES.size());
        assertThat(itemsValues, is(ITEMS_VALUES));
    }

    @Test
    public void getFirstItem() {
        breadcrumb.getFirstItem().has().value(HOME);
        breadcrumb.getFirstItem().has().text(HOME);
    }

    @Test
    public void getCurrectItem() {
        breadcrumb.getCurrectItem().has().value(BOOTSTRAP);
        breadcrumb.getCurrectItem().has().text(BOOTSTRAP);
        breadcrumb.getCurrectItem().has().text(WebPage.getTitle());
        breadcrumb.getCurrectItem().has().value(WebPage.getTitle());
    }

    @Test
    public void clickByNameTest() {
        breadcrumb.itemns.get(HTML5).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertThat(WebPage.getTitle(), is(HTML5));

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void clickByIDTest() {
        breadcrumb.itemns.get(0).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertThat(WebPage.getTitle().contains(HOME), is(true));

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValdidationTest() {
        breadcrumb.shouldBe().displayed();
        breadcrumb.shouldBe().enabled();
        breadcrumb.shouldBe().displayed()
                .core()
                .cssClass("breadcrumb")
                .tag(is("ol"))
                .css("display", is("flex"))
                .css("flex-wrap", is("wrap"))
                .css("background-color", is("rgba(233, 236, 239, 1)")) //#e9ecef Color Hex
                .css("color", is("rgba(102, 102, 102, 1)")) //#666 Color Hex
                .css("font-size", is("14px"));

        for (UIElement item : breadcrumb.itemns) {
            item.shouldBe().displayed();
            item.shouldBe().enabled();
            item.shouldBe().displayed()
                    .core()
                    .tag(is("li"));
        }

        breadcrumb.getCurrectItem().shouldBe().displayed()
                .core()
                .attr("aria-current", "page")
                .cssClass("breadcrumb-item active")
                .css("color", is("rgba(108, 117, 125, 1)")); //#6c757d Color Hex

        for (UIElement item : breadcrumb.itemns.finds(By.tagName("a"))) {
            item.shouldBe().displayed();
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