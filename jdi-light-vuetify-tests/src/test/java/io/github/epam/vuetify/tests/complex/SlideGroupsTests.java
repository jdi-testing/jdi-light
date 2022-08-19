package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slideGroupsPage;
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

    @Test
    public void activeClassSlideGroupTests() {
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

    @Test
    public void centerActiveSlideGroupTests() {
        centerActiveSlideGroup.show();
        centerActiveSlideGroup.startTest();
        centerActiveSlideGroup.is().displayed();
        centerActiveSlideGroup.slideByIndex(2).click();
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.slideByIndex(5).click();
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.getNextButton().click();
        centerActiveSlideGroup.slideByIndex(5).click();
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.getNextButton().click();
        centerActiveSlideGroup.slideByIndex(5).click();
        centerActiveSlideGroup.has().centerActiveSlide();
    }

    @Test
    public void customIconsSlideGroupTests() {
        customIconsSlideGroup.show();
        customIconsSlideGroup.startTest();
        customIconsSlideGroup.is().displayed();
        customIconsSlideGroup.has().iconSlidesVisible(minusIcon);
        customIconsSlideGroup.has().iconSlidesVisible(plusIcon);

        customIconsSlideGroup.slideByIndex(1).click();
        customIconsSlideGroup.has().slideSelected(1);
        customIconsSlideGroup.has().slidesNotSelectedExcept("#CustomIconsSlideGroup", 1);
    }

    @Test
    public void multipleSlideGroupTests() {
        multipleSlideGroup.show();
        multipleSlideGroup.startTest();
        multipleSlideGroup.is().displayed();
        multipleSlideGroup.slideByIndex(1).click();
        multipleSlideGroup.slideByIndex(3).click();
        multipleSlideGroup.has().slidesNotSelectedExcept("#MultipleSlideGroup", multipleSelectedIndexes);
    }

    @Test
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.show();
        pseudoCarouselSlideGroup.startTest();
        pseudoCarouselSlideGroup.is().displayed();
        pseudoCarouselSlideGroup.slideByIndex(1).click();
        pseudoCarouselCount.is().displayed();
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.slideByIndex(3).click();
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.slideByIndex(5).click();
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
    }
}
