package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.gridListSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicGridListBasicTest() {
        gridListSection.basicGridList.is().displayed();
        gridListSection.basicGridList.get(1).show();
    }

    @Test
    public void basicGridListTextTest() {
        gridListSection.basicGridList.get(1).is().text("1");
    }

    @Test
    public void basicGridListColorTest() {
        gridListSection.dynamicGridList.get(1)
                 .has().css("background-color", "rgba(" + 173 + ", " + 216 + ", " + 230 + ", 1)");
    }

    @Test
    public void dynamicGridListBasicTest() {
        gridListSection.dynamicGridList.is().displayed();
        gridListSection.dynamicGridList.get(1).show();
    }

    @Test
    public void dynamicGridListTextTest() {
        gridListSection.dynamicGridList.get(1).is().text("One");
    }

    @Test
    public void dynamicGridListColorTest() {
        gridListSection.dynamicGridList.get(1)
                 .has().css("background-color", "rgba(" + 173 + ", " + 216 + ", " + 230 + ", 1)");
        gridListSection.dynamicGridList.get(4)
                 .has().css("background-color", "rgba(" + 221 + ", " + 189 + ", " + 241 + ", 1)");
    }
}
