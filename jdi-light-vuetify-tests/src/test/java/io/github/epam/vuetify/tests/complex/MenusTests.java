package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
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
import static io.github.com.pages.MenusPage.tooltip;

public class MenusTests extends TestsInit {

    List<String> optionsTitles = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");

    @BeforeClass
    public void before() {
        menusPage.open();
        waitCondition(() -> menusPage.isOpened());
        menusPage.checkOpened();
    }

    @Test
    public void absoluteMenuTests() {
        waitCondition(absoluteMenu::isDisplayed);
        absoluteMenu.is().displayed();
        absoluteMenu.show();
        absoluteMenu.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        absoluteMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void absoluteWithoutActivatorMenuTests() {
        waitCondition(absoluteWithoutActivatorMenu::isDisplayed);
        absoluteWithoutActivatorMenu.is().displayed();
        absoluteWithoutActivatorMenu.show();
        absoluteWithoutActivatorMenu.click();
        absoluteWithoutActivatorMenu.rightClick();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        absoluteWithoutActivatorMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void closeOnClickMenuTests() {
        waitCondition(closeOnClickMenuSwitch::isDisplayed);
        closeOnClickMenuSwitch.uncheck();
        closeOnClickMenuButton.show();
        closeOnClickMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
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
        waitCondition(offsetXMenuButton::isDisplayed);
        offsetXMenuButton.show();
        offsetXMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        offsetXMenuButton.click();
        activeMenu.is().hidden();
        offsetXMenuSwitch.uncheck();
        offsetXMenuButton.click();
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void offsetYMenuTests() {
        waitCondition(offsetYMenuButton::isDisplayed);
        offsetYMenuButton.show();
        offsetYMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        offsetYMenuButton.click();
        activeMenu.is().hidden();
        offsetYMenuSwitch.uncheck();
        offsetYMenuButton.click();
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void openOnHoverMenuTests() {
        waitCondition(openOnHoverMenuButton::isDisplayed);
        openOnHoverMenuButton.show();
        openOnHoverMenuButton.hover();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        openOnHoverMenuButton.click();
        activeMenu.is().displayed();
        offsetXMenuButton.hover();
        activeMenu.is().hidden();
    }

    @Test
    public void roundedMenuTests() {
        List<String> roundedMenusOptionsTitles = Arrays.asList("Item 0", "Item 1", "Item 2", "Item 3");
        waitCondition(removedRadiusButton::isDisplayed);
        removedRadiusButton.show();
        removedRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().removedRadius();
        largeRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().largeRadius();
        customRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(roundedMenusOptionsTitles);
        activeMenu.has().customRadius();
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void dropdownWithTooltipMenuTests() {
        List<String> optionsTitles = Arrays.asList("Click Me1", "Click Me2", "Click Me3", "Click Me4");
        waitCondition(dropdownWithTooltipButton::isDisplayed);
        dropdownWithTooltipButton.is().displayed();
        dropdownWithTooltipButton.show();
        dropdownWithTooltipButton.hover();
        tooltip.is().visible();
        tooltip.has().text("Im A ToolTip");
        dropdownWithTooltipButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void customTransitionsMenuTests() {
        waitCondition(scaleTransitionButton::isDisplayed);
        scaleTransitionButton.show();
        scaleTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        slideXTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        slideYTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test
    public void menuAsPopoverMenuTests() {
        List<String> optionsTitles = Arrays.asList("John Leider", "Enable messages", "Enable hints");
        waitCondition(menuAsPopoverButton::isDisplayed);
        menuAsPopoverButton.is().displayed();
        menuAsPopoverButton.show();
        menuAsPopoverButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(3);
        activeMenu.has().optionsTitles(optionsTitles);
        menuAsPopoverButton.click();
        activeMenu.is().hidden();
    }

    @Test
    public void useInComponentsMenuTests() {
        waitCondition(complexComponent::isDisplayed);
        complexComponent.is().displayed();
        complexComponent.show();
        complexComponent.verticalDotsButton().click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(optionsTitles);
        activeMenu.click();
        activeMenu.is().hidden();
    }
}
