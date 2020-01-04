package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.TextTypes.TEXT;
import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.windowsCount;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

/**
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

public class BreadcrumbTests extends TestsInit {
    private static final String HOME = "Home";
    private static final String HTML5 = "HTML 5";
    private static final String BOOTSTRAP = "Bootstrap";
    private static final String[] ITEMS_VALUES = new String[]{HOME, HTML5, BOOTSTRAP};

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        breadcrumb.has().size(ITEMS_VALUES.length);
        breadcrumb.assertThat().values(TEXT, hasItems(ITEMS_VALUES));
    }

    @Test
    public void getValueTest() {
        breadcrumb.has().size(ITEMS_VALUES.length);
        assertThat(breadcrumb.values().toArray(), is(ITEMS_VALUES));
    }

    @Test
    public void getFirstItemTest() {
        breadcrumb.first().has().value(HOME);
        breadcrumb.first().is().text(HOME);
    }

    @Test
    public void getCurrectItemTest() {
        breadcrumb.last().has().value(BOOTSTRAP);
        breadcrumb.last().has().text(BOOTSTRAP);
    }

    @Test
    public void clickCurrectItemTest(){
        breadcrumb.last().click();

        assertThat(windowsCount(), is(1));
    }

    @Test
    public void clickByNameTest() {
        breadcrumb.get(HTML5).click();

        switchToWindow(2);

        assertThat(WebPage.getTitle(), is(HTML5));

        closeWindow();
        switchToWindow(1);
    }

    @Test
    public void clickByIDTest() {
        breadcrumb.get(1).click();

        switchToWindow(2);

        assertThat(WebPage.getTitle().contains(HOME), is(true));

        closeWindow();
        switchToWindow(1);
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

        for (UIElement item : breadcrumb) {
            item.shouldBe().enabled();
            item.shouldBe().displayed()
                    .core()
                    .tag(is("li"));
        }

        breadcrumb.last().shouldBe().displayed()
                .core()
                .attr("aria-current", "page")
                .cssClass("breadcrumb-item active")
                .css("color", is("rgba(108, 117, 125, 1)")); //#6c757d Color Hex

        for (UIElement item : breadcrumb.finds(By.tagName("a"))) {
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
