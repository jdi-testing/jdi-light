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

    private final String RECENTS = "Recents";
    private final String FAVORITES = "Favorites";
    private final String NEARBY = "Nearby";
    private final String VIDEO = "Video";
    private final String MUSIC = "Music";
    private final String BOOK = "Book";
    private final String IMAGE = "Image";


    @BeforeClass
    public void beforeTest() {
        bottomNavigationPage.open();
        waitCondition(() -> bottomNavigationPage.isOpened());
        bottomNavigationPage.checkOpened();
    }

    @Test
    public void baseFunctionalTest() {
        bottomNavigationColor.is().displayed();
        bottomNavigationColor.is().buttonColor(RECENTS, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.selectByText(RECENTS);
        bottomNavigationColor.is().buttonColor(RECENTS, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(FAVORITES, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(NEARBY, Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(FAVORITES);
        bottomNavigationColor.is().buttonColor(FAVORITES, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(RECENTS, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(NEARBY, Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(NEARBY);
        bottomNavigationColor.is().buttonColor(NEARBY, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(RECENTS, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(FAVORITES, Colors.BLACK_TRANSPARENT_06.value());
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
        bottomNavigationShift.get(1).has().text(VIDEO);
        bottomNavigationShift.selectByText(VIDEO);
        bottomNavigationShift.is().classValue(Matchers.containsString("blue-grey"));

        bottomNavigationShift.get(2).has().text(MUSIC);
        bottomNavigationShift.selectByText(MUSIC);
        bottomNavigationShift.is().classValue(Matchers.containsString("teal"));

        bottomNavigationShift.get(3).has().text(BOOK);
        bottomNavigationShift.selectByText(BOOK);
        bottomNavigationShift.is().classValue(Matchers.containsString("brown"));

        bottomNavigationShift.get(4).has().text(IMAGE);
        bottomNavigationShift.selectByText(IMAGE);
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
