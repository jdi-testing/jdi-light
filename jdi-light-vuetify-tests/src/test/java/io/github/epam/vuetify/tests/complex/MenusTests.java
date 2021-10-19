package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.common.ElementArea.TOP_RIGHT;
import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static io.github.com.StaticSite.menusPage;
import static io.github.com.pages.MenusPage.absoluteMenu;
import static io.github.com.pages.MenusPage.absoluteWithoutActivatorMenu;
import static io.github.com.pages.MenusPage.activeMenu;
import static io.github.com.pages.MenusPage.closeOnClickMenuButton;
import static io.github.com.pages.MenusPage.closeOnClickMenuSwitch;
import static io.github.com.pages.MenusPage.complexComponent;
import static io.github.com.pages.MenusPage.customRadiusButton;
import static io.github.com.pages.MenusPage.dropdownWithTooltipButton;
import static io.github.com.pages.MenusPage.largeRadiusButton;
import static io.github.com.pages.MenusPage.menuAsPopoverButton;
import static io.github.com.pages.MenusPage.offsetXMenuButton;
import static io.github.com.pages.MenusPage.offsetXMenuSwitch;
import static io.github.com.pages.MenusPage.offsetYMenuButton;
import static io.github.com.pages.MenusPage.offsetYMenuSwitch;
import static io.github.com.pages.MenusPage.openOnHoverMenuButton;
import static io.github.com.pages.MenusPage.removedRadiusButton;
import static io.github.com.pages.MenusPage.scaleTransitionButton;
import static io.github.com.pages.MenusPage.slideXTransitionButton;
import static io.github.com.pages.MenusPage.slideYTransitionButton;

public class MenusTests extends TestsInit {

    @BeforeClass
    public void before() {
        menusPage.open();
        resizeWindow(1920, 1080);
    }

    @Test
    public void absoluteMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(absoluteMenu::isDisplayed);
        absoluteMenu.is().displayed();
        absoluteMenu.show();
        absoluteMenu.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(330, 1071);
        absoluteMenu.click();
        activeMenu.is().hidden();
        absoluteMenu.click(TOP_RIGHT);
        activeMenu.has().position(181, 1370);
        absoluteMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void absoluteWithoutActivatorMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(absoluteWithoutActivatorMenu::isDisplayed);
        absoluteWithoutActivatorMenu.is().displayed();
        absoluteWithoutActivatorMenu.show();
        absoluteWithoutActivatorMenu.click();
        absoluteWithoutActivatorMenu.rightClick();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(678, 1071);
        absoluteWithoutActivatorMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void closeOnClickMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(closeOnClickMenuSwitch::isDisplayed);
        closeOnClickMenuSwitch.uncheck();
        closeOnClickMenuButton.show();
        closeOnClickMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(766, 1011);
        absoluteWithoutActivatorMenu.click();
        activeMenu.is().displayed();
        activeMenu.click();
        activeMenu.is().hidden();
        closeOnClickMenuSwitch.check();
        closeOnClickMenuButton.click();
        activeMenu.is().displayed();
        absoluteWithoutActivatorMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void offsetXMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(offsetXMenuButton::isDisplayed);
        offsetXMenuButton.show();
        offsetXMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1190, 1132);
        offsetXMenuButton.click();
        activeMenu.is().hidden();
        offsetXMenuSwitch.uncheck();
        offsetXMenuButton.click();
        activeMenu.has().position(1190, 1011);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void offsetYMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(offsetYMenuButton::isDisplayed);
        offsetYMenuButton.show();
        offsetYMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1312, 1011);
        offsetYMenuButton.click();
        activeMenu.is().hidden();
        offsetYMenuSwitch.uncheck();
        offsetYMenuButton.click();
        activeMenu.has().position(1348, 1011);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void openOnHoverMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(openOnHoverMenuButton::isDisplayed);
        openOnHoverMenuButton.show();
        openOnHoverMenuButton.hover();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1420, 1011);
        openOnHoverMenuButton.click();
        activeMenu.is().displayed();
        offsetXMenuButton.hover();
        activeMenu.is().hidden();
    }

    @Test
    public void roundedMenuTests() {
        List<String> roundedMenusOptionsTitles = Arrays.asList("Item 0", "Item 1", "Item 2", "Item 3");
        Timer.waitCondition(removedRadiusButton::isDisplayed);
        removedRadiusButton.show();
        removedRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().removedRadius();
        activeMenu.has().position(1633, 458);
        largeRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().largeRadius();
        activeMenu.has().position(1633, 1004);
        customRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().customRadius();
        activeMenu.has().position(1633, 1527);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void dropdownWithTooltipMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me1", "Click Me2", "Click Me3", "Click Me4");
        Timer.waitCondition(dropdownWithTooltipButton::isDisplayed);
        dropdownWithTooltipButton.is().displayed();
        dropdownWithTooltipButton.show();
        dropdownWithTooltipButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1860, 964);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void customTransitionsMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(scaleTransitionButton::isDisplayed);
        scaleTransitionButton.show();
        scaleTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1956, 443);
        slideXTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1956, 972);
        slideYTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(1956, 1511);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void menuAsPopoverMenuTests() {
        List<String> optionsTitles = Arrays.asList("John Leider", "Enable messages", "Enable hints");
        Timer.waitCondition(menuAsPopoverButton::isDisplayed);
        menuAsPopoverButton.is().displayed();
        menuAsPopoverButton.show();
        menuAsPopoverButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(3);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(2052, 1161);
        menuAsPopoverButton.click();
        activeMenu.is().hidden();
    }

    @Test
    public void useInComponentsMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
        Timer.waitCondition(complexComponent::isDisplayed);
        complexComponent.is().displayed();
        complexComponent.show();
        complexComponent.clickOnVerticalDotsButton();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.has().position(2176, 1339);
        activeMenu.click();
        activeMenu.is().hidden();
    }
}
