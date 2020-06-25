package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.menuSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MenuTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicMenuTest() throws InterruptedException {
        menuSection.basicMenu.is().displayed();
        menuSection.basicMenu.select(1);
        menuSection.matMenuPanel0.select("Item 1");
        menuSection.matMenuPanel0.is().hidden();
        Thread.sleep(5000);
    }

    @Test
    public void menuWithIconsTest() {
        menuSection.menuWithIcons.is().displayed();
        menuSection.menuWithIcons.select(1);
        menuSection.matMenuPanel1.is().displayed();
        menuSection.matMenuPanel1.select(1);
        menuSection.matMenuPanel1.is().hidden();
    }

    @Test
    public void nestedMenuTest() {
        menuSection.nestedMenu.is().displayed();
        menuSection.nestedMenu.show();
    }

}
