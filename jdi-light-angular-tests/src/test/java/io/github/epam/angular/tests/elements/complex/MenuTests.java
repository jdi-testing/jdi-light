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
    public void basicMenuTest() {
        menuSection.basicMenu.is().displayed();
        menuSection.basicMenu.select("Item 1");
        menuSection.nestedMenu.select("Vertebrates");
        menuSection.nestedMenu.select("Vertebrates", "Fishes");
        menuSection.nestedMenu.select("Vertebrates", "Fishes", "Bala shark");
    }

    @Test
    public void menuWithIconsTest() {
        menuSection.menuWithIcons.is().displayed();
        menuSection.menuWithIcons.select(1);
    }

    @Test
    public void nestedMenuTest() {
        menuSection.nestedMenu.is().displayed();
        menuSection.nestedMenu.show();
    }

}
