package io.github.epam.angular.tests.elements.complex;

//import io.github.com.pages.sections.GridListSection;
//import io.github.com.pages.sections.GridListSection.*;
//import io.github.com.pages.sections.GridListSection;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.gridListSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
//import static

public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void getTextTest(){

        System.out.println( gridListSection.basicGridList.getValue() );
        //assertEquals(gridListSection.basicGridList.size(), 4);
        //gridListSection.basicGridList.isExist();

    }
}
