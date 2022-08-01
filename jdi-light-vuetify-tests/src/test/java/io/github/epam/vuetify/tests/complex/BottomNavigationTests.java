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

    private final String recents = "Recents";
    private final String favorites = "Favorites";
    private final String nearby = "Nearby";
    private final String video = "Video";
    private final String music = "Music";
    private final String book = "Book";
    private final String image = "Image";


    @BeforeClass
    public void beforeTest() {
        bottomNavigationPage.open();
        waitCondition(() -> bottomNavigationPage.isOpened());
        bottomNavigationPage.checkOpened();
    }

    @Test
    public void baseFunctionalTest() {
        bottomNavigationColor.is().displayed();
        bottomNavigationColor.is().buttonColor(recents, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.selectByText(recents);
        bottomNavigationColor.is().buttonColor(recents, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(favorites, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(nearby, Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(favorites);
        bottomNavigationColor.is().buttonColor(favorites, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(recents, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(nearby, Colors.BLACK_TRANSPARENT_06.value());

        bottomNavigationColor.selectByText(nearby);
        bottomNavigationColor.is().buttonColor(nearby, Colors.BLUE_DARKEN_2.value());
        bottomNavigationColor.is().buttonColor(recents, Colors.BLACK_TRANSPARENT_06.value());
        bottomNavigationColor.is().buttonColor(favorites, Colors.BLACK_TRANSPARENT_06.value());
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
        bottomNavigationShift.get(1).has().text(video);
        bottomNavigationShift.selectByText(video);
        bottomNavigationShift.is().classValue(Matchers.containsString("blue-grey"));

        bottomNavigationShift.get(2).has().text(music);
        bottomNavigationShift.selectByText(music);
        bottomNavigationShift.is().classValue(Matchers.containsString("teal"));

        bottomNavigationShift.get(3).has().text(book);
        bottomNavigationShift.selectByText(book);
        bottomNavigationShift.is().classValue(Matchers.containsString("brown"));

        bottomNavigationShift.get(4).has().text(image);
        bottomNavigationShift.selectByText(image);
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
