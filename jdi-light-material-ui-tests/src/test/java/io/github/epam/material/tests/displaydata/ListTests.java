package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;

import static io.github.com.StaticSite.listPage;

public class ListTests extends TestsInit {

    @BeforeClass
    public void setup() {
        listPage.open();
        listPage.checkOpened();
    }
}
