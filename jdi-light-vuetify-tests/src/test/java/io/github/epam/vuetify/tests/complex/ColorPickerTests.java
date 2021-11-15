package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.*;

public class ColorPickerTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        colorPickersPage.open();
    }

    @Test
    public void setColorTest() {

    }

}
