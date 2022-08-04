package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.BottomNavigationText;
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
        bottomNavigationColor.is().buttonColor(BottomNavigationText.RECENTS.toString(),
            Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.selectByText(BottomNavigationText.RECENTS.toString());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.RECENTS.toString(),
            Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.FAVORITES.toString(),
            Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.NEARBY.toString(),
            Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(BottomNavigationText.FAVORITES.toString());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.FAVORITES.toString(),
            Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.RECENTS.toString(),
            Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.NEARBY.toString(),
            Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(BottomNavigationText.NEARBY.toString());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.NEARBY.toString(),
            Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.RECENTS.toString(),
            Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(BottomNavigationText.FAVORITES.toString(),
            Colors.BLACK_TRANSPARENT_06.value());
    }

    @Test
    public void hideOnScrollTest() {
        hideAndScrollPanel.hover();
        bottomNavigationHideOnScroll.is().visible();
        hideAndScrollPanel.scroll(350);
        bottomNavigationHideOnScroll.is().notVisible();
    }

    @Test
    public void shiftTest() {
        bottomNavigationShift.get(1).has().text(BottomNavigationText.VIDEO.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.VIDEO.toString());
        bottomNavigationShift.is().classValue(Matchers.containsString("blue-grey"));

        bottomNavigationShift.get(2).has().text(BottomNavigationText.MUSIC.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.MUSIC.toString());
        bottomNavigationShift.is().classValue(Matchers.containsString("teal"));

        bottomNavigationShift.get(3).has().text(BottomNavigationText.BOOK.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.BOOK.toString());
        bottomNavigationShift.is().classValue(Matchers.containsString("brown"));

        bottomNavigationShift.get(4).has().text(BottomNavigationText.IMAGE.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.IMAGE.toString());
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
