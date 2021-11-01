package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;

import static io.github.com.StaticSite.selectsPage;

public class SelectTests extends TestsInit {

    @BeforeClass
    public void before() {
        selectsPage.open();
    }


}
