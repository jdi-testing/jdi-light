package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slideGroupsPage;
import static io.github.com.pages.SlideGroupsPage.activeClassSlideGroup;
import static io.github.com.pages.SlideGroupsPage.centerActiveSlideGroup;
import static io.github.com.pages.SlideGroupsPage.multipleSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselCount;
import static org.testng.Assert.assertEquals;

public class SlideGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        slideGroupsPage.open();
        waitCondition(() -> slideGroupsPage.isOpened());
        slideGroupsPage.checkOpened();
        resizeWindow(1920, 1080);
    }

    @Test
    public void activeClassSlideGroupTests() {
        activeClassSlideGroup.startTest();
        activeClassSlideGroup.is().displayed();

        activeClassSlideGroup.clickOnSlideByIndex(1);
        activeClassSlideGroup.has().slideSelected(1);
        activeClassSlideGroup.clickOnSlideByIndex(2);
        activeClassSlideGroup.has().slideSelected(2);
        activeClassSlideGroup.has().slideNotSelected(1);

        if (activeClassSlideGroup.nextButtonIsActive()) {
            activeClassSlideGroup.clickOnNextButton();
            activeClassSlideGroup.has().visibleSlidesPosition(-664);
            activeClassSlideGroup.clickOnSlideByIndex(2);
            activeClassSlideGroup.has().slideSelected(2);

            activeClassSlideGroup.clickOnSlideByIndex(3);
            activeClassSlideGroup.has().slideSelected(3);
            activeClassSlideGroup.has().slideNotSelected(2);
        }
    }

    @Test
    public void centerActiveSlideGroupTests() {
        centerActiveSlideGroup.startTest();
        centerActiveSlideGroup.is().displayed();
        centerActiveSlideGroup.clickOnSlideByIndex(2);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnSlideByIndex(3);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnSlideByIndex(4);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnSlideByIndex(5);
        centerActiveSlideGroup.has().centerActiveSlide();
    }

    @Test
    public void multipleSlideGroupTests() {
        multipleSlideGroup.startTest();
        multipleSlideGroup.is().displayed();
        multipleSlideGroup.clickOnSlideByIndex(1);
        multipleSlideGroup.clickOnSlideByIndex(2);
        multipleSlideGroup.clickOnNextButton();
        multipleSlideGroup.clickOnSlideByIndex(3);

        multipleSlideGroup.has().slideSelected(3);
        multipleSlideGroup.clickOnPreviousButton();
        waitCondition(multipleSlideGroup.find(".v-slide-group__prev")::isDisabled);
        multipleSlideGroup.has().slideSelected(2);
        multipleSlideGroup.has().slideSelected(1);

    }

    @Test
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.startTest();
        pseudoCarouselSlideGroup.is().displayed();
        pseudoCarouselSlideGroup.clickOnSlideByIndex(1);
        pseudoCarouselCount.is().displayed();
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex(By.cssSelector("#PseudoCarouselSlideGroup .v-card")));
        pseudoCarouselSlideGroup.clickOnSlideByIndex(3);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex(By.cssSelector("#PseudoCarouselSlideGroup .v-card")));
        pseudoCarouselSlideGroup.clickOnSlideByIndex(5);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex(By.cssSelector("#PseudoCarouselSlideGroup .v-card")));
        pseudoCarouselSlideGroup.clickOnNextButton();
        pseudoCarouselSlideGroup.clickOnSlideByIndex(5);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex(By.cssSelector("#PseudoCarouselSlideGroup .v-card")));
        pseudoCarouselSlideGroup.clickOnSlideByIndex(2);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex(By.cssSelector("#PseudoCarouselSlideGroup .v-card")));
    }
}
