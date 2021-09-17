package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.BottomNavigationButton;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.BottomNavigationPage.*;

public class BottomNavigationTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        bottomNavigationPage.open();
    }

    @Test
    public void colorTest() {
        for (BottomNavigationButton button : color) {
            button.is().disabled();
        }
    }
}
