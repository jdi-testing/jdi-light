package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.paginationPage;

public class TreeviewTests extends TestsInit {

    @BeforeClass
    public void before() {
        paginationPage.open();
        paginationPage.checkOpened();
    }

    @Test
    public void baseTest() {

    }
}
