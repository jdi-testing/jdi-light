package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
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
        bottomNavigationColor.is().displayed();
        bottomNavigationColor.is().buttonColor(1, "rgba(0, 0, 0, 0.6)");
        bottomNavigationColor.bottomNavigationButtonList().get(1).click();
        bottomNavigationColor.is().buttonColor(1, Colors.BLUE_DARKEN_2.value());
    }

    @Test
    public void wightTest() {
        bottomNavigationGrow.is().displayed();
        bottomNavigationGrow.is().buttonWight(1, "168px");
        bottomNavigationGrow.is().buttonWight(2, "168px");
        bottomNavigationGrow.is().buttonWight(3, "168px");
    }

    @Test
    public void hideOnScrollTest() {
        bottomNavigationHideOnScroll.is().displayed();
        hideAndScrollPanel.hover();
        hideAndScrollPanel.jsExecute("scroll(0,350)");
        bottomNavigationHideOnScroll.is().notDisplayed();
    }

    @Test
    public void horizontalTest() {
        bottomNavigationHorizontal.is().displayed();
        bottomNavigationHorizontal.is().buttonDirection(1, "row-reverse");
        bottomNavigationHorizontal.is().buttonDirection(2, "row-reverse");
        bottomNavigationHorizontal.is().buttonDirection(3, "row-reverse");
    }

    @Test
    public void scrollThresholdTest() {
        bottomNavigationScrollThreshold.is().displayed();

        bottomNavigationScrollThreshold.is().buttonColor(1, "rgba(0, 0, 0, 0.6)");
        bottomNavigationScrollThreshold.bottomNavigationButtonList().get(1).click();
        bottomNavigationScrollThreshold.is().buttonColor(1, Colors.WHITE.value());

        scrollThresholdPanel.hover();
        scrollThresholdPanel.jsExecute("scroll(0,450)");
        bottomNavigationScrollThreshold.is().notDisplayed();
    }

    @Test
    public void shiftTest() {
        bottomNavigationShift.is().displayed();
        bottomNavigationShift.bottomNavigationButtonList().get(1).click();
        bottomNavigationShift.is().buttonText(1, "Video");
        bottomNavigationShift.is().backgroundColorAttribute("blue-grey");

        bottomNavigationShift.bottomNavigationButtonList().get(2).click();
        bottomNavigationShift.is().buttonText(2, "Music");
        bottomNavigationShift.is().backgroundColorAttribute("teal");

        bottomNavigationShift.bottomNavigationButtonList().get(3).click();
        bottomNavigationShift.is().buttonText(3, "Book");
        bottomNavigationShift.is().backgroundColorAttribute("brown");

        bottomNavigationShift.bottomNavigationButtonList().get(4).click();
        bottomNavigationShift.is().buttonText(4, "Image");
        bottomNavigationShift.is().backgroundColorAttribute("indigo");
    }

    @Test
    public void toggleTest() {
        bottomNavigationToggle.is().displayed();
        bottomNavigationToggle.is().seen();
        toggleNavigationButton.click();
        bottomNavigationToggle.is().hide();
    }

}
