package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.windowsPage;
import static io.github.com.enums.Colors.GREY;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.WindowsPage.customizedArrowsWindow;
import static io.github.com.pages.WindowsPage.onboardingWindow;
import static io.github.com.pages.WindowsPage.reverseWindow;
import static io.github.com.pages.WindowsPage.verticalWindow;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class WindowsTests extends TestsInit {

    @BeforeClass
    public void before() {
        windowsPage.open();
        waitCondition(() -> windowsPage.isOpened());
        windowsPage.checkOpened();
    }

    @Test(description = "Test checks windows navigation")
    public void navigationWindowsTest() {
        reverseWindow.show();
        assertThat(reverseWindow.slideWindow.getActiveItem().find("h1").getText(),
            Matchers.equalTo("Slide 1"));
        reverseWindow.slideWindow.nextButton().click();
        reverseWindow.slideWindow.getActiveItem().isDisplayed();
        assertThat(reverseWindow.slideWindow.getActiveItem().find("h1").getText(),
            Matchers.equalTo("Slide 2"));
        reverseWindow.slideWindow.previousButton().click();
        reverseWindow.slideWindow.getActiveItem().isDisplayed();
        assertThat(reverseWindow.slideWindow.getActiveItem().find("h1").getText(),
            Matchers.equalTo("Slide 1"));
    }

    // most probably we don't need this test (depends on user implementation of WindowItem class), TBD
    @Ignore
    @Test(description = "Test checks windows color")
    public void colorWindowsTest() {
        reverseWindow.show();
        reverseWindow.slideWindow.getActiveItem().has().css("color", WHITE.value());
        reverseWindow.slideWindow.getActiveItem().has().css("background-color", GREY.value());
    }

    @Test(description = "Test checks if next/previous buttons exist or not")
    public void customizedArrowsWindowsTest() {
        customizedArrowsWindow.show();
        customizedArrowsWindow.has().noPreviousButton();
        customizedArrowsWindow.has().nextButton();
        customizedArrowsWindow.nextButton().click();
        customizedArrowsWindow.has().previousButton();
        customizedArrowsWindow.nextButton().click();
        customizedArrowsWindow.nextButton().click();
        customizedArrowsWindow.nextButton().click();
        customizedArrowsWindow.has().noNextButton();
    }

    @Test(description = "Test checks if next/previous actions buttons and navigation buttons exist or not")
    public void nextPreviousActionsButtonsAndNavigationButtonsWindowsTest() {
        reverseWindow.slideWindow.show();
        reverseWindow.slideWindow.has().nextButton();
        reverseWindow.slideWindow.nextButton().click();
        reverseWindow.slideWindow.has().previousButton();

        verticalWindow.slideWindow.show();
        verticalWindow.slideWindow.has().showArrowsOnHover();
        verticalWindow.slideWindow.hover();
        verticalWindow.slideWindow.nextButton().click();
        verticalWindow.slideWindow.hover();
        verticalWindow.slideWindow.has().previousButton();

        customizedArrowsWindow.show();
        customizedArrowsWindow.has().previousButton();
        customizedArrowsWindow.previousButton().click();
        customizedArrowsWindow.has().nextButton();

        onboardingWindow.slideWindow.show();
        onboardingWindow.slideWindow.has().noNextButton();
        onboardingWindow.slideWindow.has().noPreviousButton();
    }

    @Test(description = "Test checks windows theme")
    public void reverseWindowsTest() {
        reverseWindow.slideWindow.show();
        reverseWindow.slideWindow.has().lightTheme();
        onboardingWindow.show();
        onboardingWindow.has().darkTheme();
        verticalWindow.slideWindow.show();
        verticalWindow.slideWindow.has().lightTheme();
    }

    @Test(description = "Test checks if windows show arrows on hover or not")
    public void showArrowsOnHoverWindowsTest() {
        reverseWindow.slideWindow.is().notShowArrowsOnHover();
        verticalWindow.show();
        verticalWindow.slideWindow.is().showArrowsOnHover();
        customizedArrowsWindow.show();
        customizedArrowsWindow.is().notShowArrowsOnHover();
    }
}
