package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }
    private static final String HOME = "Home";
    private static final String HTML5 = "HTML 5";
    private static final String BOOTSTRAP = "Bootstrap";
    private static final List<String> ANCESTOR_VALUES = Arrays.asList(HOME, HTML5);

    @Test
    public void getTextTest() {
        List<String> ancestorTexts = breadcrumb.ancestorList.stream().map(UIElement::getText).collect(Collectors.toList());

        assertThat(breadcrumb.currentItem.getText(), is(BOOTSTRAP));
        assertThat(ancestorTexts, is(ANCESTOR_VALUES));
    }

    @Test
    public void getValueTest() {
        List<String> ancestorValues = breadcrumb.ancestorList.stream().map(UIElement::getValue).collect(Collectors.toList());

        assertThat(breadcrumb.currentItem.getValue(), is(BOOTSTRAP));
        assertThat(ancestorValues, is(ANCESTOR_VALUES));
    }

    @Test
    public void clickByNameTest() {
        breadcrumb.ancestorList.get(HOME).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertTrue(homePage.getTitle().contains(HOME));

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void clickByIDTest() {
        breadcrumb.ancestorList.get(1).click();

        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));

        assertEquals(HTML5, html5Page.getTitle());

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValdidationTest() {
        breadcrumb.assertThat().displayed();
        breadcrumb.assertThat().enabled();
        assertThat( breadcrumb.core().css("font-size"), is("14px"));
        breadcrumb.assertThat().displayed()
                .core()
                .cssClass("breadcrumb")
                .tag(is("ol"))
                .css("display", is("flex"))
                .css("flex-wrap", is("wrap"))
                .css("background-color", is("rgba(233, 236, 239, 1)")) //#e9ecef Color Hex
                .css("color", is("rgba(102, 102, 102, 1)")); //#666 Color Hex

        breadcrumb.currentItem.is().text(bsPage.getTitle());
        breadcrumb.currentItem.assertThat().displayed()
                .core()
                .attr("aria-current", "page")
                .cssClass("breadcrumb-item active")
                .tag(is("li"))
                .css("color", is("rgba(108, 117, 125, 1)")); //#6c757d Color Hex

        for (UIElement item: breadcrumb.ancestorList) {
            item.is().displayed();
            item.is().enabled();
            item.assertThat().displayed()
                    .core()
                    .css("color", is("rgba(57, 194, 215, 1)")); //#39c2d7 Color Hex
        }
    }

    @Test
    public void baseValidationTest() {
        baseValidation(breadcrumb);
    }

}