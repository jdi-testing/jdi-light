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

    private final int[] INDEXES = {1, 3};

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

        activeClassSlideGroup.clickOnSlideByIndex(1);
        activeClassSlideGroup.has().slideSelected(1);
        activeClassSlideGroup.has().slidesNotSelectedExcept("#ActiveClassSlideGroup", 1);
        activeClassSlideGroup.clickOnSlideByIndex(2);
        activeClassSlideGroup.has().slideSelected(2);
        activeClassSlideGroup.has().slidesNotSelectedExcept("#ActiveClassSlideGroup", 2);
    }

    @Test
    public void centerActiveSlideGroupTests() {
        centerActiveSlideGroup.show();
        centerActiveSlideGroup.startTest();
        centerActiveSlideGroup.is().displayed();
        centerActiveSlideGroup.clickOnSlideByIndex(2);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnSlideByIndex(5);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnNextButton();
        centerActiveSlideGroup.clickOnSlideByIndex(5);
        centerActiveSlideGroup.has().centerActiveSlide();

        centerActiveSlideGroup.clickOnNextButton();
        centerActiveSlideGroup.clickOnSlideByIndex(5);
        centerActiveSlideGroup.has().centerActiveSlide();
    }

    @Test
    public void customIconsSlideGroupTests() {
        customIconsSlideGroup.show();
        customIconsSlideGroup.startTest();
        customIconsSlideGroup.is().displayed();
        customIconsSlideGroup.clickOnSlideByIndex(1);
        customIconsSlideGroup.has().slideSelected(1);
        customIconsSlideGroup.has().slidesNotSelectedExcept("#CustomIconsSlideGroup", 1);

        customIconsSlideGroup.clickOnSlideByIndex(3);
        customIconsSlideGroup.has().slideSelected(3);
        customIconsSlideGroup.has().slidesNotSelectedExcept("#CustomIconsSlideGroup", 3);
    }

    @Test
    public void multipleSlideGroupTests() {
        multipleSlideGroup.show();
        multipleSlideGroup.startTest();
        multipleSlideGroup.is().displayed();
        multipleSlideGroup.clickOnSlideByIndex(1);
        multipleSlideGroup.clickOnSlideByIndex(3);
        multipleSlideGroup.has().slidesNotSelectedExcept("#MultipleSlideGroup", INDEXES);
    }

    @Test
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.show();
        pseudoCarouselSlideGroup.startTest();
        pseudoCarouselSlideGroup.is().displayed();
        pseudoCarouselSlideGroup.clickOnSlideByIndex(1);
        pseudoCarouselCount.is().displayed();
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.clickOnSlideByIndex(3);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
        pseudoCarouselSlideGroup.clickOnSlideByIndex(5);
        assertEquals(pseudoCarouselCount.getText(), "Selected " + pseudoCarouselSlideGroup.selectedIndex("#PseudoCarouselSlideGroup"));
    }
}
