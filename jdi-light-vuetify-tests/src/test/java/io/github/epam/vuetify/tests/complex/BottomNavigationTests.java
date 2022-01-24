package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationColor;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationHideOnScroll;
import static io.github.com.pages.BottomNavigationPage.hideAndScrollPanel;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationShift;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationToggle;
import static io.github.com.pages.BottomNavigationPage.toggleNavigationButton;

public class BottomNavigationTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        bottomNavigationPage.open();
        waitCondition(() -> bottomNavigationPage.isOpened());
        bottomNavigationPage.checkOpened();
    }

    @Test
    public void baseFunctionalTest() {
        bottomNavigationColor.is().displayed();
        bottomNavigationColor.is().buttonColor(1, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.select(1);
        bottomNavigationColor.is().buttonColor(1, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.select(2);
        bottomNavigationColor.is().buttonColor(2, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.select(3);
        bottomNavigationColor.is().buttonColor(3, Colors.BLUE_DARKEN_2.value());
    }

    @Test
    public void hideOnScrollTest() {
        hideAndScrollPanel.hover();
        bottomNavigationHideOnScroll.is().visible();
        hideAndScrollPanel.jsExecute("scroll(0,350)");
        bottomNavigationHideOnScroll.is().notVisible();
    }

    @Test
    public void shiftTest() {
        bottomNavigationShift.get(1).has().text("Video");
        bottomNavigationShift.select(1);
        bottomNavigationShift.is().classValue(Matchers.containsString("blue-grey"));

        bottomNavigationShift.get(2).has().text("Music");
        bottomNavigationShift.select(2);
        bottomNavigationShift.is().classValue(Matchers.containsString("teal"));

        bottomNavigationShift.get(3).has().text("Book");
        bottomNavigationShift.select(3);
        bottomNavigationShift.is().classValue(Matchers.containsString("brown"));

        bottomNavigationShift.get(4).has().text("Image");
        bottomNavigationShift.select(4);
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
