package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.BottomNavigationText;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.enums.Colors.BLUE_GREY;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationColor;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationFixed;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationGrow;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationHideOnScroll;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationHorizontal;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationScrollThreshold;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationShift;
import static io.github.com.pages.BottomNavigationPage.bottomNavigationToggle;
import static io.github.com.pages.BottomNavigationPage.cardWithBottomNavigationHideOnScroll;
import static io.github.com.pages.BottomNavigationPage.cardWithBottomNavigationScrollThreshold;
import static io.github.com.pages.BottomNavigationPage.hideAndScrollPanel;
import static io.github.com.pages.BottomNavigationPage.toggleNavigationButton;

public class BottomNavigationTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        bottomNavigationPage.open();
        waitCondition(() -> bottomNavigationPage.isOpened());
        bottomNavigationPage.checkOpened();
    }

    @Test(description = "Test checks bottom navigation button color")
    public void buttonColorBottomNavigationTest() {
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

    @Test(description = "Test checks that bottom navigation hides on scroll")
    public void hideOnScrollBottomNavigationTest() {
        hideAndScrollPanel.hover();
        bottomNavigationHideOnScroll.is().visible();
        hideAndScrollPanel.scroll(350);
        bottomNavigationHideOnScroll.is().notVisible();
    }

    @Test(description = "Test checks bottom navigation button text and selects button by text")
    public void selectButtonByTextBottomNavigationTest() {
        bottomNavigationShift.show();
        bottomNavigationShift.get(1).has().text(BottomNavigationText.VIDEO.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.VIDEO.toString());

        bottomNavigationShift.get(2).has().text(BottomNavigationText.MUSIC.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.MUSIC.toString());

        bottomNavigationShift.get(3).has().text(BottomNavigationText.BOOK.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.BOOK.toString());

        bottomNavigationShift.get(4).has().text(BottomNavigationText.IMAGE.toString());
        bottomNavigationShift.selectByText(BottomNavigationText.IMAGE.toString());
    }

    @Test(description = "Test checks bottom navigation background color")
    public void backgroundColorBottomNavigationTest() {
        bottomNavigationShift.show();
        bottomNavigationShift.selectByText(BottomNavigationText.VIDEO.toString());
        waitCondition(() -> bottomNavigationShift.backgroundColor().equals(BLUE_GREY.value()));
        bottomNavigationShift.has().backgroundColor(BLUE_GREY.value());
    }

    @Test(description = "Test checks if bottom navigation is visible or not")
    public void visibleBottomNavigationTest() {
        bottomNavigationToggle.hover();
        bottomNavigationToggle.is().visible();
        toggleNavigationButton.click();
        waitCondition(() -> bottomNavigationToggle.isNotVisible());
        bottomNavigationToggle.is().notVisible();
    }

    @Test(description = "Test checks bottom navigation position")
    public void positionBottomNavigationTest() {
        bottomNavigationScrollThreshold.show();
        bottomNavigationScrollThreshold.is().absolute();
        bottomNavigationScrollThreshold.is().notFixed();
        bottomNavigationFixed.show();
        bottomNavigationFixed.is().fixed();
        bottomNavigationFixed.is().notAbsolute();
    }

    @Test(description = "Test checks bottom navigation theme")
    public void themeBottomNavigationTest() {
        bottomNavigationShift.show();
        bottomNavigationShift.has().darkTheme();
        bottomNavigationFixed.show();
        bottomNavigationFixed.has().lightTheme();
    }

    @Test(description = "Test checks if bottom navigation is grow or not")
    public void growBottomNavigationTest() {
        bottomNavigationGrow.show();
        bottomNavigationGrow.is().grow();
        bottomNavigationShift.show();
        bottomNavigationShift.is().notGrow();
    }

    @Test(description = "Test checks if bottom navigation is horizontal or not")
    public void horizontalBottomNavigationTest() {
        bottomNavigationHorizontal.show();
        bottomNavigationHorizontal.is().horizontal();
        bottomNavigationShift.show();
        bottomNavigationShift.is().notGrow();
    }

    @Test(description = "Test checks if bottom navigation max and min measurements")
    public void measurementsBottomNavigationTest() {
        bottomNavigationFixed.show();
        bottomNavigationFixed.has().maxHeight(100);
        bottomNavigationFixed.has().minHeight(50);
        bottomNavigationFixed.has().maxWidth(1600);
        bottomNavigationFixed.has().minWidth(1000);
    }

    @Test(description = "Test checks if bottom navigation hides on scroll")
    public void bottomNavigationScrollOverTest() {
        cardWithBottomNavigationHideOnScroll.show();
        cardWithBottomNavigationHideOnScroll.scroll(600);
        cardWithBottomNavigationHideOnScroll.scroll(-600);
        bottomNavigationHideOnScroll.is().notVisible();
        cardWithBottomNavigationHideOnScroll.scroll(400);
        bottomNavigationHideOnScroll.is().visible();
        cardWithBottomNavigationHideOnScroll.scroll(-200);
        bottomNavigationHideOnScroll.is().notVisible();
    }

    @Test(description = "Test checks if bottom navigation hides on scroll (with scroll threshold)")
    public void bottomNavigationScrollOverTest2() {
        cardWithBottomNavigationScrollThreshold.show();
        cardWithBottomNavigationScrollThreshold.scroll(600);
        cardWithBottomNavigationScrollThreshold.scroll(-600);
        bottomNavigationScrollThreshold.is().notVisible();
        cardWithBottomNavigationScrollThreshold.scroll(600);
        bottomNavigationScrollThreshold.is().visible();
        cardWithBottomNavigationScrollThreshold.scroll(-200);
        bottomNavigationScrollThreshold.is().visible();
        cardWithBottomNavigationScrollThreshold.scroll(-200);
        bottomNavigationScrollThreshold.is().visible();
        cardWithBottomNavigationScrollThreshold.scroll(-200);
        bottomNavigationScrollThreshold.is().notVisible();
    }
}
