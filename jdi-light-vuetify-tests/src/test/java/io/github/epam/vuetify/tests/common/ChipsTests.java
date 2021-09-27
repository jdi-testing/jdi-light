package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.chipsPage;

public class ChipsTests extends TestsInit {

    @BeforeSuite
    public void before() {
        chipsPage.open();
    }

    @Test
    public void closableChipsTest() {}
}
