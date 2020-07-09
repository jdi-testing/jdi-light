package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.listSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class ListTests extends TestsInit{

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicListBasicTest(){
        listSection.basicList.is().displayed();
        listSection.basicList.get(1).show();
    }

    @Test
    public void basicListTextTest(){
        listSection.basicList.get(1).is().text("Item 1");
        listSection.basicList.get(2).is().text("Item 2");
        listSection.basicList.get(3).is().text("Item 3");
    }

    @Test
    public void listWithSectionsBasicTest(){
        listSection.listWithSection.is().displayed();
        listSection.listWithSection.get(1).show();
    }

    @Test
    public void listWithSectionsIconTest(){
        assertEquals(listSection.listWithSection.get(1).getValue().split("\n")[0], "folder");
        assertEquals(listSection.listWithSection.get(4).getValue().split("\n")[0], "note");
    }

    @Test
    public void listWithSectionsTextTest() {
        assertEquals(listSection.listWithSection.get(1).getValue().split("\n")[1], "Photos");
        assertEquals(listSection.listWithSection.get(5).getValue().split("\n")[2], "Jan 18, 2016");
    }
}
