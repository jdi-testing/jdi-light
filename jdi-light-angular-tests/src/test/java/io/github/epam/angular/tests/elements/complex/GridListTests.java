package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.enums.Colors.LIGHT_GREEN;
import static io.github.com.enums.Colors.LIGHT_LILAC;
import static io.github.com.enums.Colors.LIGHT_PINK;
import static io.github.com.pages.AngularPage.gridListSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
@Ignore
public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test(description = "Test checks is grid tile displayed")
    public void basicGridListBasicTest() {
        gridListSection.basicGridList.is().displayed();
    }

    @Test(description = "Test checks grid tile's text")
    public void basicGridListTextTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().tileText(1, "1");
    }

    @Test(description = "Test checks grid tile's background color")
    public void basicGridListColorTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().tileBackgroundColor(1, LIGHT_BLUE.value());
    }

    @Test(description = "Test checks is grid tile displayed")
    public void dynamicGridListBasicTest() {
        gridListSection.dynamicGridList.is().displayed();
    }

    @Test(description = "Test checks grid tile's text")
    public void dynamicGridListTextTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has().tileText(1, "One");
    }

    @Test(description = "Test checks grid tile's background color")
    public void dynamicGridListColorTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has().tileBackgroundColor(1, LIGHT_BLUE.value());
        gridListSection.dynamicGridList.has().tileBackgroundColor(2, LIGHT_GREEN.value());
        gridListSection.dynamicGridList.has().tileBackgroundColor(3, LIGHT_PINK.value());
        gridListSection.dynamicGridList.has().tileBackgroundColor(4, LIGHT_LILAC.value());
    }
}
