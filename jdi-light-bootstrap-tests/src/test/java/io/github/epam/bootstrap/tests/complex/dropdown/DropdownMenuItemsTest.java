package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuItems;
import static io.github.com.pages.BootstrapPage.dropdownMenuTextItem;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class DropdownMenuItemsTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dropdownMenuItems);
        dropdownMenuItems.unhighlight();

        dropdownMenuItems.expand();
        baseValidation(dropdownMenuItems.expander());
        dropdownMenuItems.expander().unhighlight();
        for (UIElement item : dropdownMenuItems.list()) {
            baseValidation(item);
            item.unhighlight();
        }
        dropdownMenuItems.collapse();

        baseValidation(dropdownMenuTextItem);
        dropdownMenuTextItem.unhighlight();

        dropdownMenuTextItem.expand();
        baseValidation(dropdownMenuTextItem.expander());
        dropdownMenuTextItem.expander().unhighlight();
        for (UIElement item : dropdownMenuTextItem.list()) {
            baseValidation(item);
            item.unhighlight();
        }
        dropdownMenuTextItem.collapse();
    }

    @DataProvider(name = "actionsDataProvider")
    public Object[][] actionsDataProvider() {
        return new Object[][]{
                {"Action", "Action"},
                {"Another action", "Another action"},
                {"Something else here", "One more action"}
        };
    }

    @Test(dataProvider = "actionsDataProvider")
    public void menuItemsActionsTest(String itemText, String alertText) {
        dropdownMenuItems.expand();
        dropdownMenuItems.select(itemText);
        Alerts.validateAlert(Matchers.is(alertText));
        dropdownMenuItems.collapse();
    }

    @Test(expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ".*Expected: an array containing \"href\".*")
    public void textItemTest() {
        dropdownMenuTextItem.expand();
        UIElement textItem = dropdownMenuTextItem.list().get("Dropdown item text");
        textItem.waitFor().enabled();
        textItem.assertThat()
                .tag("span");

        textItem.waitSec(1);
        textItem.assertThat()
                .hasAttr("href");
    }

    @DataProvider(name = "linksDataProvider")
    public Object[][] linksDataProvider() {
        return new Object[][]{
                {"Action", "https://getbootstrap.com/docs/4.3/components/dropdowns/"},
                {"Another action", "https://getbootstrap.com/docs/4.3/getting-started/introduction/"},

        };
    }

    @Test(dataProvider = "linksDataProvider")
    public void linkItemsTest(String itemText, String itemHref) {
        dropdownMenuTextItem.expand();

        int currWindowNum = WindowsManager.windowsCount();

        dropdownMenuTextItem.select(itemText);

        WindowsManager.switchToWindow(currWindowNum + 1);
        String url = WebPage.getUrl();
        Assert.assertEquals(url, itemHref);

        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(currWindowNum);

        dropdownMenuTextItem.collapse();
    }

}
