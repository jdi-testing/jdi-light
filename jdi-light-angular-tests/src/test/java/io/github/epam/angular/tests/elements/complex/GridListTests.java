package io.github.epam.angular.tests.elements.complex;

//import io.github.com.pages.sections.GridListSection;
//import io.github.com.pages.sections.GridListSection.*;
//import io.github.com.pages.sections.GridListSection;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.basicIcon;
import static io.github.com.pages.AngularPage.gridListSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;


public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicGridListTest() {

        gridListSection.basicGridList.is().displayed();
        gridListSection.basicGridList.get(1).show();

        System.out.println(gridListSection.basicGridList.get(1).getValue());

        gridListSection.dynamicGridList.is().displayed();
        gridListSection.dynamicGridList.get(1).show();

        System.out.println(gridListSection.dynamicGridList.get(1).getValue());

    }

    @Test
    public void dynamicGridListBasicTest() {
        gridListSection.dynamicGridList.is().displayed();
        gridListSection.dynamicGridList.get(1).show();
    }

    @Test
    public void dynamicGridListColorTest() {
        System.out.println(gridListSection.dynamicGridList.get(1).getText());
        System.out.println(gridListSection.dynamicGridList.get(4).color());
        gridListSection.dynamicGridList.get(1).has().attr("style","rgba(173, 216, 230, 1)");
    }

    @Test
    public void dynamicGridListTextTest() {

    }
}
