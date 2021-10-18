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
import static io.github.com.pages.MenusPage.activeMenu;

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
//        absoluteWithoutActivatorMenu.rightClick();
//        activeMenu.is().displayed();
//        absoluteWithoutActivatorMenu.click();
//        Timer.waitCondition(closeOnClickMenuSwitch::isDisplayed);
//        closeOnClickMenuSwitch.uncheck();
//        closeOnClickMenuButton.click();
//        activeMenu.is().displayed();
//        absoluteWithoutActivatorMenu.click();
//        activeMenu.is().displayed();
//        activeMenu.click();
//        activeMenu.is().hidden();
//        closeOnClickMenuSwitch.check();
//        closeOnClickMenuButton.click();
//        activeMenu.is().displayed();
//        System.out.println(activeMenu.hasPosition());
//        activeMenu.click();
//        offsetXMenuButton.click();
//        System.out.println(activeMenu.hasPosition());
//        activeMenu.click();
//        offsetXMenuSwitch.uncheck();
//        offsetXMenuButton.click();
//        System.out.println(activeMenu.hasPosition());
//        absoluteWithoutActivatorMenu.click();
//        activeMenu.is().hidden();

    }

}
