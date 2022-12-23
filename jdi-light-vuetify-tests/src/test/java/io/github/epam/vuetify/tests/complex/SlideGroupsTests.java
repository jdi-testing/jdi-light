package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SlideGroupTestsData;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slideGroupsPage;
import static io.github.com.pages.SlideGroupsPage.mandatorySlideGroup;
import static io.github.com.pages.SlideGroupsPage.multipleSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselSlideGroup;
import static io.github.com.pages.SlideGroupsPage.centerActiveSlideGroup;
import static io.github.com.pages.SlideGroupsPage.customIconsSlideGroup;
import static io.github.com.pages.SlideGroupsPage.activeClassSlideGroup;
import static io.github.com.pages.SlideGroupsPage.pseudoCarouselCount;
import static org.testng.Assert.assertEquals;

public class SlideGroupsTests extends TestsInit {

    private final int[] multipleSelectedIndexes = {1, 3};

    private final String minusIcon = ".v-icon.mdi-minus";

    private final String plusIcon = ".v-icon.mdi-plus";

    @BeforeClass
    public void before() {
        slideGroupsPage.open();
        waitCondition(() -> slideGroupsPage.isOpened());
    }

    @Test(description="Test checks 'single' selection of slide ")
    public void activeClassSlideGroupTests() {
        // to refactor after changes on test-site. It should not be mandatory
        //to check active-class
        activeClassSlideGroup.show();
        activeClassSlideGroup.startTest();
        activeClassSlideGroup.is().displayed();

        activeClassSlideGroup.slideByIndex(1).click();
        activeClassSlideGroup.has().slideSelected(1);
        activeClassSlideGroup.has().slidesNotSelectedExcept("#ActiveClassSlideGroup", 1);
        activeClassSlideGroup.slideByIndex(2).click();
        activeClassSlideGroup.has().slideSelected(2);
        activeClassSlideGroup.has().slidesNotSelectedExcept("#ActiveClassSlideGroup", 2);
    }

    @Test(description="Test checks slide group feature 'center-active'")
    public void centerActiveSlideGroupTests() {
        //center-active is reflected in attribute 'style' via 'transform:translateX(*px)'

        List<Integer> slidesPositions = new SlideGroupTestsData().centerActiveSlideGroupTestData();
        centerActiveSlideGroup.show();
        centerActiveSlideGroup.hasAttribute("style");
        centerActiveSlideGroup.startTest();
        centerActiveSlideGroup.is().displayed();

        for (int i = 1; i <= 3; i++) {
            centerActiveSlideGroup.slideByIndex(i).click();
            centerActiveSlideGroup.has().slideSelected(i);
        }
        for (Integer slidesPosition : slidesPositions) {
            centerActiveSlideGroup.slideByIndex(4).click();
            centerActiveSlideGroup.has().visibleSlidesPosition(slidesPosition);
            centerActiveSlideGroup.has().slideSelected(3);
        }
        for (int i = 4; i <= 6; i++) {
            centerActiveSlideGroup.slideByIndex(i).click();
            centerActiveSlideGroup.has().slideSelected(i);
            centerActiveSlideGroup.has().visibleSlidesPosition(-1316);
        }
    }

    @Test(description="Test checks slide group feature: 'icon' and theme = 'light'")
    public void customIconsSlideGroupTests() {
        //On our test-site we have the following custom icons:
        // prev-icon="mdi-minus"
        // next-icon="mdi-plus"
        customIconsSlideGroup.show();
        customIconsSlideGroup.startTest();
        customIconsSlideGroup.is().displayed();
        customIconsSlideGroup.has().iconSlidesVisible(minusIcon);
        customIconsSlideGroup.has().iconSlidesVisible(plusIcon);

        customIconsSlideGroup.slideByIndex(1).click();
        customIconsSlideGroup.has().slideSelected(1);
        customIconsSlideGroup.has().slidesNotSelectedExcept("#CustomIconsSlideGroup", 1);

        customIconsSlideGroup.is().lightTheme();
    }

    @Test(description="Test checks slide group feature: 'multiple' and max selections")
    public void multipleSlideGroupTests() {
        //Interface IsMultiple cannot be used as there is no "--is-multi"
        //On our test-site we have the following max=3 selections
        multipleSlideGroup.show();
        multipleSlideGroup.startTest();
        multipleSlideGroup.is().displayed();

        //Check that on selecting 2 slides we have 2 active slides
        multipleSlideGroup.slideByIndex(1).click();
        multipleSlideGroup.slideByIndex(3).click();
        multipleSlideGroup.has().slidesNotSelectedExcept("#MultipleSlideGroup", multipleSelectedIndexes);
        multipleSlideGroup.slideByIndex(1).click();
        multipleSlideGroup.slideByIndex(3).click();

        //Check that on selecting 4 slides we have only 3 selected slides as it is our max
        for (int i = 1; i <= 4; i++) {
            multipleSlideGroup.slideByIndex(i).click();
        }
        int selectedSlides = multipleSlideGroup.allSelectedIndexes("#MultipleSlideGroup").size();
        assertEquals(selectedSlides, 3);
    }

    @Test(description="Test checks slide group version: 'pseudocarousel' and max selections")
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.show();
        pseudoCarouselSlideGroup.startTest();
        pseudoCarouselSlideGroup.is().displayed();
        pseudoCarouselSlideGroup.slideByIndex(1).click();
        pseudoCarouselCount.is().displayed();
        assertEquals(pseudoCarouselCount.getText(),
            "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.slideByIndex(3).click();
        assertEquals(pseudoCarouselCount.getText(),
            "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.slideByIndex(5).click();
        assertEquals(pseudoCarouselCount.getText(),
            "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
    }

    @Test(description="Test checks slide group feature: 'mandatory' and theme dark")
    public void mandatorySlideGroupTests() {
        mandatorySlideGroup.show();
        mandatorySlideGroup.startTest();
        mandatorySlideGroup.is().displayed();

        mandatorySlideGroup.is().darkTheme();
    }
}
