package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.menuSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicMenuTest() {
        menuSection.basicMenu.is().displayed();
        menuSection.basicMenu.expandMenu();
        assertTrue(menuSection.basicMenu.isExpanded());
        menuSection.basicMenu.values();
        menuSection.basicMenu.select("Item 1");
        menuSection.basicMenu.closeMenu();
        assertTrue(menuSection.basicMenu.isClosed());
        menuSection.basicMenuSelectedOption.is().text("Item 1");
    }

    @Test
    public void menuWithIconsTest() {
        menuSection.menuWithIcons.is().displayed();
        menuSection.menuWithIcons.expandMenu();
        assertTrue(menuSection.menuWithIcons.isExpanded());
        menuSection.basicMenu.values();
        menuSection.menuWithIcons.select("Redial");
        menuSection.menuWithIcons.closeMenu();
        assertTrue(menuSection.menuWithIcons.isClosed());
        menuSection.iconsMenuSelectedOption.is().text("Redial");

        menuSection.menuWithIcons.expandMenu();
        assertTrue(menuSection.menuWithIcons.isExpanded());
        menuSection.menuWithIcons.select("Check voice mail");
        menuSection.menuWithIcons.closeMenu();
        assertTrue(menuSection.menuWithIcons.isClosed());
        menuSection.iconsMenuSelectedOption.is().text("Redial");

        menuSection.menuWithIcons.expandMenu();
        assertTrue(menuSection.menuWithIcons.isExpanded());
        menuSection.menuWithIcons.select("Disable alerts");
        menuSection.menuWithIcons.closeMenu();
        assertTrue(menuSection.menuWithIcons.isClosed());
        menuSection.iconsMenuSelectedOption.is().text("notifications_off");
    }

    @Test
    public void nestedMenuTest() {
        menuSection.nestedMenu.is().displayed();
        menuSection.nestedMenu.expandMenu();
        assertTrue(menuSection.nestedMenu.isExpanded());
        System.out.println("NESTED LVL1 - " + menuSection.nestedMenu.values());
        menuSection.nestedMenu.select("Vertebrates");
        menuSection.nestedMenu.closeMenu();
        assertTrue(menuSection.nestedMenu.isClosed());
        menuSection.nestedMenuSelectedOption.is().text("Vertebrates");

        menuSection.nestedMenu.expandMenu();
        assertTrue(menuSection.nestedMenu.isExpanded());
        menuSection.nestedMenu.select("Vertebrates", "Fishes");
        menuSection.nestedMenu.closeMenu();
        assertTrue(menuSection.nestedMenu.isClosed());
        menuSection.nestedMenuSelectedOption.is().text("Fishes");

        menuSection.nestedMenu.expandMenu();
        assertTrue(menuSection.nestedMenu.isExpanded());
        menuSection.nestedMenu.select("Vertebrates", "Fishes", "Bala shark");
        menuSection.nestedMenu.closeMenu();
        assertTrue(menuSection.nestedMenu.isClosed());
        menuSection.nestedMenuSelectedOption.is().text("Bala shark");

        menuSection.nestedMenu.expandMenu();
        assertTrue(menuSection.nestedMenu.isExpanded());
        menuSection.nestedMenu.select("Vertebrates", "Reptiles", "Velociraptor");
        menuSection.nestedMenu.closeMenu();
        assertTrue(menuSection.nestedMenu.isClosed());
        menuSection.nestedMenuSelectedOption.is().text("Bala shark");
    }

}
