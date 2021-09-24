package io.github.epam.vuetify.tests.complex;

import io.github.com.pages.PaginationPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.disabledPagination;


public class PaginationTests extends TestsInit {

    @BeforeClass
    public void before() {
        paginationPage.open();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStart()  {
//        circlePagination.leftNavigation.click();
//        circlePagination.rightNavigation.click();
        System.out.println(circlePagination.leftNavigation.isDisabled());
        System.out.println(circlePagination.rightNavigation.isDisabled());
    }

}
