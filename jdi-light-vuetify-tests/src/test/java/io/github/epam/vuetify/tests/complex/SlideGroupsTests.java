package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.slideGroupsPage;
import static io.github.com.pages.SlideGroupsPage.activeClassSlideGroup;
import static io.github.com.pages.SlideGroupsPage.centerActiveSlideGroup;
import static io.github.com.pages.SlideGroupsPage.customIconsSlideGroup;
import static io.github.com.pages.SlideGroupsPage.multipleSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselSlideGroup;

public class SlideGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        slideGroupsPage.open();
    }

    @Test
    public void activeClassSlideGroupTests() {
        activeClassSlideGroup.is().displayed();
        checkVisibleSlidesInDirectOrder(activeClassSlideGroup, 1, 5);
        activeClassSlideGroup.clickOnNextButton();
        activeClassSlideGroup.has().visibleSlidesPosition(-664);
        checkVisibleSlidesInDirectOrder(activeClassSlideGroup, 1, 5);
        activeClassSlideGroup.clickOnNextButton();
        activeClassSlideGroup.has().visibleSlidesPosition(-1316);
        checkVisibleSlidesInDirectOrder(activeClassSlideGroup, 2, 6);
        activeClassSlideGroup.clickOnSlideByIndex(6);
        checkVisibleSlidesInReverseOrder(activeClassSlideGroup, 6, 2);
        activeClassSlideGroup.clickOnPreviousButton();
        activeClassSlideGroup.has().visibleSlidesPosition(-652);
        checkVisibleSlidesInReverseOrder(activeClassSlideGroup, 6, 2);
        activeClassSlideGroup.clickOnPreviousButton();
        activeClassSlideGroup.has().visibleSlidesPosition(0);
        checkVisibleSlidesInReverseOrder(activeClassSlideGroup, 5, 1);
    }

    @Test
    public void centerActiveSlideGroupTests() {
        centerActiveSlideGroup.is().displayed();
        List<Integer> slidesPositions = Arrays.asList(-130, -262, -394, -526, -658, -790, -922, -1054, -1186);
        for(int i = 1; i <= 3; i++) {
            centerActiveSlideGroup.clickOnSlideByIndex(i);
            centerActiveSlideGroup.has().slideSelected(i);
        }
        for (Integer slidesPosition : slidesPositions) {
            centerActiveSlideGroup.clickOnSlideByIndex(4);
            centerActiveSlideGroup.has().visibleSlidesPosition(slidesPosition);
            centerActiveSlideGroup.has().slideSelected(3);
        }
        centerActiveSlideGroup.clickOnSlideByIndex(4);
        centerActiveSlideGroup.has().visibleSlidesPosition(-1316);
        centerActiveSlideGroup.has().slideSelected(4);
        centerActiveSlideGroup.clickOnSlideByIndex(5);
        centerActiveSlideGroup.has().slideSelected(5);
        centerActiveSlideGroup.clickOnSlideByIndex(6);
        centerActiveSlideGroup.has().slideSelected(6);
        centerActiveSlideGroup.clickOnSlideByIndex(6);
    }

    @Test
    public void customIconsSlideGroupTests() {
        customIconsSlideGroup.is().displayed();
        checkVisibleSlidesInDirectOrder(customIconsSlideGroup, 1, 5);
        customIconsSlideGroup.clickOnNextButton();
        customIconsSlideGroup.has().visibleSlidesPosition(-664);
        checkVisibleSlidesInDirectOrder(customIconsSlideGroup, 1, 5);
        customIconsSlideGroup.clickOnNextButton();
        customIconsSlideGroup.has().visibleSlidesPosition(-1316);
        checkVisibleSlidesInDirectOrder(customIconsSlideGroup, 2, 6);
        customIconsSlideGroup.clickOnSlideByIndex(6);
        checkVisibleSlidesInReverseOrder(customIconsSlideGroup, 6, 2);
        customIconsSlideGroup.clickOnPreviousButton();
        customIconsSlideGroup.has().visibleSlidesPosition(-652);
        checkVisibleSlidesInReverseOrder(customIconsSlideGroup, 6, 2);
        customIconsSlideGroup.clickOnPreviousButton();
        customIconsSlideGroup.has().visibleSlidesPosition(0);
        checkVisibleSlidesInReverseOrder(customIconsSlideGroup, 5, 1);
    }

    @Test
    public void multipleSlideGroupTests() {
        multipleSlideGroup.is().displayed();
        List<Integer> slidesPositions = Arrays.asList(-664, -1316);
        for (Integer slidesPosition : slidesPositions) {
            for (int j = 1; j <= 5; j++) {
                multipleSlideGroup.clickOnSlideByIndex(j);
            }
            for (int j = 1; j <= 5; j++) {
                multipleSlideGroup.has().slideSelected(j);
            }
            multipleSlideGroup.clickOnNextButton();
            multipleSlideGroup.has().visibleSlidesPosition(slidesPosition);
        }
        for(int i = 2; i <= 6; i++) {
            multipleSlideGroup.clickOnSlideByIndex(i);
        }
        for(int i = 2; i <= 6; i++) {
            multipleSlideGroup.has().slideSelected(i);
        }
    }

    @Test
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.is().displayed();
        checkVisibleSlidesInDirectOrder(pseudoCarouselSlideGroup, 1, 5);
        pseudoCarouselSlideGroup.clickOnNextButton();
        pseudoCarouselSlideGroup.has().visibleSlidesPosition(-664);
        checkVisibleSlidesInDirectOrder(pseudoCarouselSlideGroup, 1, 5);
        pseudoCarouselSlideGroup.clickOnNextButton();
        pseudoCarouselSlideGroup.has().visibleSlidesPosition(-1316);
        checkVisibleSlidesInDirectOrder(pseudoCarouselSlideGroup, 2, 6);
        pseudoCarouselSlideGroup.clickOnSlideByIndex(6);
        checkVisibleSlidesInReverseOrder(pseudoCarouselSlideGroup, 6, 2);
        pseudoCarouselSlideGroup.clickOnPreviousButton();
        pseudoCarouselSlideGroup.has().visibleSlidesPosition(-652);
        checkVisibleSlidesInReverseOrder(pseudoCarouselSlideGroup, 6, 2);
        pseudoCarouselSlideGroup.clickOnPreviousButton();
        pseudoCarouselSlideGroup.has().visibleSlidesPosition(0);
        checkVisibleSlidesInReverseOrder(pseudoCarouselSlideGroup, 5, 1);
    }

    private void checkVisibleSlidesInDirectOrder(SlideGroup slideGroup, int startIndex, int endIndex) {
        slideGroup.clickOnSlideByIndex(startIndex);
        slideGroup.has().slideSelected(startIndex);
        for(int i = startIndex + 1; i <= endIndex; i++) {
            slideGroup.clickOnSlideByIndex(i);
            slideGroup.has().slideSelected(i);
        }
        slideGroup.has().slideNotSelected(endIndex - 1);
    }

    private void checkVisibleSlidesInReverseOrder(SlideGroup slideGroup, int startIndex, int endIndex) {
        slideGroup.clickOnSlideByIndex(startIndex);
        slideGroup.has().slideSelected(startIndex);
        for(int i = startIndex - 1; i >= endIndex; i--) {
            slideGroup.clickOnSlideByIndex(i);
            slideGroup.has().slideSelected(i);
        }
        slideGroup.has().slideNotSelected(endIndex + 1);
    }
}
