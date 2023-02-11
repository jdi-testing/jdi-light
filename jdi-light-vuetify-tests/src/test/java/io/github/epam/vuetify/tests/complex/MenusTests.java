package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
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

    private static final List<String> OPTIONS_TITLES_NAMES = Arrays.asList("John Leider Founder of Vuetify", "Enable messages", "Enable hints");
    private static final List<String> ROUNDED_MENUS_OPTIONS_TITLES = Arrays.asList("Item 0", "Item 1", "Item 2", "Item 3");
    private static final List<String> OPTIONS_TITLES = Arrays.asList("Click Me", "Click Me", "Click Me", "Click Me 2");
    private static final List<String> OPTIONS_TITLES_DROPDOWN_WITH_TOOLTIP = Arrays.asList("Click Me1", "Click Me2", "Click Me3", "Click Me4");
    private static final String TOOLTIP_EXPECTED_TEXT = "Im A ToolTip";

    @BeforeClass
    public void before() {
        menusPage.open();
        waitCondition(() -> menusPage.isOpened());
        menusPage.checkOpened();
    }

    @Test(description = "Test checks that menu appears after clicking on element and menu contains all expected options")
    public void absoluteMenuTests() {
        waitCondition(absoluteMenu::isDisplayed);
        absoluteMenu.is().displayed();
        absoluteMenu.show();
        absoluteMenu.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        absoluteMenu.press(Keys.ESCAPE);
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks that menu appears after clicking on element and menu contains all expected options")
    public void absoluteWithoutActivatorMenuTests() {
        waitCondition(absoluteWithoutActivatorMenu::isDisplayed);
        absoluteWithoutActivatorMenu.is().displayed();
        absoluteWithoutActivatorMenu.show();
        absoluteWithoutActivatorMenu.click();
        absoluteWithoutActivatorMenu.rightClick();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks that menu can be closed by click if 'closeOnClick' switch is activated")
    public void closeOnClickMenuTests() {
        waitCondition(closeOnClickMenuSwitch::isDisplayed);
        closeOnClickMenuSwitch.uncheck();
        closeOnClickMenuButton.show();
        closeOnClickMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        absoluteWithoutActivatorMenu.click();
        activeMenu.is().displayed();
        activeMenu.click();
        activeMenu.is().hidden();
        closeOnClickMenuSwitch.check();
        closeOnClickMenuButton.click();
        waitCondition(activeMenu::isVisible);
        activeMenu.is().displayed();
        absoluteWithoutActivatorMenu.press(Keys.ESCAPE);
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks that active menu appears with offset by X if 'offsetX' switch is activated")
    public void offsetXMenuTests() {
        waitCondition(offsetXMenuButton::isDisplayed);
        offsetXMenuButton.show();
        offsetXMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        offsetXMenuButton.press(Keys.ESCAPE);
        activeMenu.is().hidden();
        offsetXMenuSwitch.uncheck();
        offsetXMenuButton.click();
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks that active menu appears with offset by Y if 'offsetY' switch is activated")
    public void offsetYMenuTests() {
        waitCondition(offsetYMenuButton::isDisplayed);
        waitCondition(() -> offsetYMenuButton.core().isClickable());
        offsetYMenuButton.show();
        offsetYMenuButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        activeMenu.press(Keys.ESCAPE);
        activeMenu.is().hidden();
        offsetYMenuSwitch.uncheck();
        offsetYMenuButton.click();
        waitCondition(activeMenu::isDisplayed);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks that active menu appears after hover upon the button")
    public void openOnHoverMenuTests() {
        waitCondition(openOnHoverMenuButton::isDisplayed);
        openOnHoverMenuButton.show();
        openOnHoverMenuButton.hover();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        openOnHoverMenuButton.click();
        activeMenu.is().displayed();
        offsetXMenuButton.hover();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks different radius of menus and removed radius menu")
    public void roundedMenuTests() {
        waitCondition(removedRadiusButton::isDisplayed);
        removedRadiusButton.show();
        removedRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(ROUNDED_MENUS_OPTIONS_TITLES);
        activeMenu.has().removedRadius();
        largeRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(ROUNDED_MENUS_OPTIONS_TITLES);
        activeMenu.has().largeRadius();
        customRadiusButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(ROUNDED_MENUS_OPTIONS_TITLES);
        activeMenu.has().customRadius();
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks tooltip for button, that activates menu")
    public void dropdownWithTooltipMenuTests() {
        waitCondition(dropdownWithTooltipButton::isDisplayed);
        dropdownWithTooltipButton.is().displayed();
        dropdownWithTooltipButton.show();
        dropdownWithTooltipButton.hover();
        tooltip.is().visible();
        tooltip.has().text(TOOLTIP_EXPECTED_TEXT);
        dropdownWithTooltipButton.click();
        waitCondition(activeMenu::isDisplayed);
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES_DROPDOWN_WITH_TOOLTIP);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks menus with different transitions on appearance")
    public void customTransitionsMenuTests() {
        waitCondition(scaleTransitionButton::isDisplayed);
        scaleTransitionButton.show();
        scaleTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        slideXTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        slideYTransitionButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        activeMenu.click();
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks active menu that appears in popover")
    public void menuAsPopoverMenuTests() {
        waitCondition(menuAsPopoverButton::isDisplayed);
        menuAsPopoverButton.is().displayed();
        menuAsPopoverButton.show();
        menuAsPopoverButton.click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(3);
        activeMenu.has().optionsList(OPTIONS_TITLES_NAMES);
        menuAsPopoverButton.press(Keys.ESCAPE);
        activeMenu.is().hidden();
    }

    @Test(description = "Test checks menu as a part of more complex component")
    public void useInComponentsMenuTests() {
        waitCondition(complexComponent::isDisplayed);
        complexComponent.is().displayed();
        complexComponent.show();
        complexComponent.findIconButton("mdi-dots-vertical").click();
        activeMenu.is().displayed();
        activeMenu.has().numberOfOptions(4);
        activeMenu.has().optionsTitles(OPTIONS_TITLES);
        activeMenu.click();
        activeMenu.is().hidden();
    }
}
