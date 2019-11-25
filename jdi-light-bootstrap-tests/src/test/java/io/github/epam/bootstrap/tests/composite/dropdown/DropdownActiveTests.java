package io.github.epam.bootstrap.tests.composite.dropdown;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuItemsActive;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertEquals;

public class DropdownActiveTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] dropdownMenu() {
        return new Object[][]{
                {"Action", "https://getbootstrap.com/docs/4.3/components/dropdowns/#active"},
                {"Another action", "https://getbootstrap.com/docs/4.3/components/dropdowns/"},
                {"Something else here", "https://getbootstrap.com/docs/4.3/getting-started/introduction/"}
        };
    }

    @Test(dataProvider = "dropdownMenu")
    public void dropdownMenuTest(String itemText, String itemHref) {
        dropdownMenuItemsActive.expand();
        int currWindowNum = WindowsManager.windowsCount();
        dropdownMenuItemsActive.select(itemText);
        WindowsManager.switchToWindow(currWindowNum + 1);
        String Url = WebPage.getUrl();
        assertEquals(Url, itemHref);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(currWindowNum);
        dropdownMenuItemsActive.collapse();
    }

    @Test
    public void isActiveTest() {
        dropdownMenuItemsActive.expand();
        dropdownMenuItemsActive.is().active(2);
        dropdownMenuItemsActive.collapse();
    }

    @Test(expectedExceptions = Throwable.class,
            expectedExceptionsMessageRegExp = ".*Expected: is \"dropdown-item active\".*")
    public void isActiveNegativeTest() {
        dropdownMenuItemsActive.expand();
        dropdownMenuItemsActive.is().active(1);
        dropdownMenuItemsActive.collapse();
    }

    @Test
    public void baseValidationTest() {
        dropdownMenuItemsActive.expand();
        baseValidation(dropdownMenuItemsActive.expander());
        for (UIElement item : dropdownMenuItemsActive.list()) {
            baseValidation(item);
            item.unhighlight();
        }
    }
}
