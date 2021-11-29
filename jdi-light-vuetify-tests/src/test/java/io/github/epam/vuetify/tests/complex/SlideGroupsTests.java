package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SlideGroupTestsData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static io.github.com.StaticSite.slideGroupsPage;
import static io.github.com.pages.SlideGroupsPage.activeClassSlideGroup;
import static io.github.com.pages.SlideGroupsPage.centerActiveSlideGroup;
import static io.github.com.pages.SlideGroupsPage.customIconsSlideGroup;
import static io.github.com.pages.SlideGroupsPage.multipleSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselSlideGroup;

public class SlideGroupsTests extends TestsInit {

    SlideGroupTestsData testsData = new SlideGroupTestsData();

    @BeforeClass
    public void before() {
        slideGroupsPage.open();
        resizeWindow(1920, 1080);
    }

    @Test
    public void activeClassSlideGroupTests() {
        activeClassSlideGroup.is().displayed();
        testCommonSlideGroup(activeClassSlideGroup);
    }

    @Test
    public void centerActiveSlideGroupTests() {
        List<Integer> slidesPositions = new SlideGroupTestsData().centerActiveSlideGroupTestData();
        centerActiveSlideGroup.is().displayed();
        for (int i = 1; i <= 3; i++) {
            centerActiveSlideGroup.clickOnSlideByIndex(i);
            centerActiveSlideGroup.has().slideSelected(i);
        }
        for (Integer slidesPosition : slidesPositions) {
            centerActiveSlideGroup.clickOnSlideByIndex(4);
            centerActiveSlideGroup.has().visibleSlidesPosition(slidesPosition);
            centerActiveSlideGroup.has().slideSelected(3);
        }
        for (int i = 4; i <= 6; i++) {
            centerActiveSlideGroup.clickOnSlideByIndex(i);
            centerActiveSlideGroup.has().slideSelected(i);
            centerActiveSlideGroup.has().visibleSlidesPosition(-1316);
        }
    }

    @Test
    public void customIconsSlideGroupTests() {
        customIconsSlideGroup.is().displayed();
        testCommonSlideGroup(customIconsSlideGroup);
    }

    @Test
    public void multipleSlideGroupTests() {
        multipleSlideGroup.is().displayed();
        testMultipleSlideGroup(multipleSlideGroup);
    }

    @Test
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.is().displayed();
        testCommonSlideGroup(pseudoCarouselSlideGroup);
    }

    private void checkVisibleSlidesInDirectOrder(SlideGroup slideGroup, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            slideGroup.clickOnSlideByIndex(i);
            slideGroup.has().slideSelected(i);
        }
        slideGroup.has().slideNotSelected(endIndex - 1);
    }

    private void checkVisibleSlidesInReverseOrder(SlideGroup slideGroup, int startIndex, int endIndex) {
        for (int i = startIndex; i >= endIndex; i--) {
            slideGroup.clickOnSlideByIndex(i);
            slideGroup.has().slideSelected(i);
        }
        slideGroup.has().slideNotSelected(endIndex + 1);
    }

    private void testCommonSlideGroup(SlideGroup slideGroup) {
        slideGroup.startTest();
        Timer.waitCondition(slideGroup::previousButtonIsDisabled);
        for (SlideGroupTestsData.SlideGroupTestDataObject dataObject : testsData.commonSlideGroupTestData()) {
            slideGroup.has().visibleSlidesPosition(dataObject.getSlidesPosition());
            if (dataObject.getOrder().equals("direct")) {
                checkVisibleSlidesInDirectOrder(slideGroup, dataObject.getStartIndex(), dataObject.getEndIndex());
                if (slideGroup.nextButtonIsDisabled()) {
                    slideGroup.clickOnSlideByIndex(dataObject.getEndIndex());
                } else if (slideGroup.nextButtonIsActive()) {
                    slideGroup.clickOnNextButton();
                }
            } else if (dataObject.getOrder().equals("reverse")) {
                checkVisibleSlidesInReverseOrder(slideGroup, dataObject.getStartIndex(), dataObject.getEndIndex());
                if (slideGroup.previousButtonIsDisabled()) {
                    slideGroup.clickOnSlideByIndex(dataObject.getEndIndex());
                } else if (slideGroup.previousButtonIsActive()) {
                    slideGroup.clickOnPreviousButton();
                }
            }
        }
    }

    private void testMultipleSlideGroup(SlideGroup slideGroup) {
        slideGroup.startTest();
        Timer.waitCondition(slideGroup::previousButtonIsDisabled);
        for (SlideGroupTestsData.SlideGroupTestDataObject dataObject : testsData.multipleSlideGroupTestData()) {
            if (dataObject.getOrder().equals("direct")) {
                for (int i = dataObject.getStartIndex(); i <= dataObject.getEndIndex(); i++) {
                    slideGroup.clickOnSlideByIndex(i);
                }
                for (int i = dataObject.getStartIndex(); i <= dataObject.getEndIndex(); i++) {
                    slideGroup.has().slideSelected(i);
                }
                if(slideGroup.nextButtonIsActive()) {
                    slideGroup.clickOnNextButton();
                }
            } else if (dataObject.getOrder().equals("reverse")) {
                for (int i = dataObject.getStartIndex(); i >= dataObject.getEndIndex(); i--) {
                    slideGroup.clickOnSlideByIndex(i);
                }
                for (int i = dataObject.getStartIndex(); i >= dataObject.getEndIndex(); i--) {
                    slideGroup.has().slideNotSelected(i);
                }
            }
        }
    }
}
