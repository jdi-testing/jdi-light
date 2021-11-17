package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.BottomNavigationPage.*;

public class BottomNavigationTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        bottomNavigationPage.open();
    }

    @Test
    public void baseFunctionalTest() {
        bottomNavigationColor.is().displayed();
        bottomNavigationColor.is().buttonColor(1, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.button(1).click();
        bottomNavigationColor.is().buttonColor(1, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.button(2).click();
        bottomNavigationColor.is().buttonColor(2, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.button(3).click();
        bottomNavigationColor.is().buttonColor(3, Colors.BLUE_DARKEN_2.value());
    }

    @Test
    public void hideOnScrollTest() {
        bottomNavigationHideOnScroll.is().visible();
        hideAndScrollPanel.hover();
        hideAndScrollPanel.jsExecute("scroll(0,350)");
        bottomNavigationHideOnScroll.is().notVisible();
    }

    @Test
    public void shiftTest() {
        bottomNavigationShift.is().displayed();
        bottomNavigationShift.button(1).has().text("Video");
        bottomNavigationShift.button(1).click();
        bottomNavigationShift.is().classValue(Matchers.containsString("blue-grey"));

        bottomNavigationShift.button(2).has().text("Music");
        bottomNavigationShift.button(2).click();
        bottomNavigationShift.is().classValue(Matchers.containsString("teal"));

        bottomNavigationShift.button(3).has().text("Book");
        bottomNavigationShift.button(3).click();
        bottomNavigationShift.is().classValue(Matchers.containsString("brown"));

        bottomNavigationShift.button(4).has().text("Image");
        bottomNavigationShift.button(4).click();
        bottomNavigationShift.is().classValue(Matchers.containsString("indigo"));
    }

    @Test
    public void toggleTest() {
        bottomNavigationToggle.hover();
        bottomNavigationToggle.is().visible();
        toggleNavigationButton.click();
        bottomNavigationToggle.is().notVisible();
    }

}
