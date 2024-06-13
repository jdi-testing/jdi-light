package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
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

public class SlideGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        slideGroupsPage.open();
        waitCondition(() -> slideGroupsPage.isOpened());
    }

    @Test(description="Test checks 'single' selection of slide ")
    public void activeClassSlideGroupTests() {
        activeClassSlideGroup.show();
        activeClassSlideGroup.is().displayed();

        activeClassSlideGroup.slideByIndex(1).click();
        activeClassSlideGroup.has().slideSelected(1);
        activeClassSlideGroup.slideByIndex(2).click();
        activeClassSlideGroup.has().slideSelected(2);

        activeClassSlideGroup.has().slideNotSelected(1);
    }

    @Test(enabled = false, description="Test checks slide group feature 'center-active'")
    public void centerActiveSlideGroupTests() {
        centerActiveSlideGroup.show();
        centerActiveSlideGroup.hasAttribute("style");
        centerActiveSlideGroup.is().displayed();

        for (int i = 1; i <= 3; i++) {
            centerActiveSlideGroup.slideByIndex(i).click();
            centerActiveSlideGroup.has().slideSelected(i);
        }

        centerActiveSlideGroup.slideByIndex(4).click();
        centerActiveSlideGroup.has().slideSelected(3);

        for (int i = 4; i <= 6; i++) {
            centerActiveSlideGroup.slideByIndex(i).click();
            centerActiveSlideGroup.has().slideSelected(i);
        }
    }

    @Test(description="Test checks slide group feature: theme = 'light'")
    public void themeSlideGroupTests() {
        customIconsSlideGroup.show();
        customIconsSlideGroup.is().displayed();

        // @todo #5318 content can have links, so wee need additional method to select
        customIconsSlideGroup.slideByIndex(1).click();
        customIconsSlideGroup.has().slideSelected(1);

        customIconsSlideGroup.is().lightTheme();
    }

    @Test(description="Test checks slide group feature: 'multiple' and max selections")
    public void multipleSlideGroupTests() {
        //Interface IsMultiple cannot be used as there is no "--is-multi"
        //On our test-site we have the following max=3 selections
        multipleSlideGroup.show();
        multipleSlideGroup.is().displayed();

        //Check that on selecting 2 slides we have 2 active slides
        multipleSlideGroup.slideByIndex(1).click();
        multipleSlideGroup.slideByIndex(3).click();
        multipleSlideGroup.slideByIndex(1).click();
        multipleSlideGroup.slideByIndex(3).click();

        //Check that on selecting 4 slides we have only 3 selected slides as it is our max
        for (int i = 1; i <= 4; i++) {
            multipleSlideGroup.slideByIndex(i).click();
        }
    }

    @Test(description="Test checks slide group version: 'pseudocarousel' and max selections")
    public void pseudoCarouselSlideGroupTests() {
        pseudoCarouselSlideGroup.show();
        pseudoCarouselSlideGroup.is().displayed();
        pseudoCarouselSlideGroup.slideByIndex(1).click();
        pseudoCarouselCount.is().displayed();

        pseudoCarouselSlideGroup.slideByIndex(3).click();

        pseudoCarouselSlideGroup.slideByIndex(5).click();

    }

    @Test(description="Test checks slide group feature: 'mandatory' and theme dark")
    public void mandatorySlideGroupTests() {
        mandatorySlideGroup.show();
        mandatorySlideGroup.is().displayed();

        //Check that before selecting any slide we already have the first slide as item--active
        mandatorySlideGroup.slideByIndex(1).has().cssClass("v-slide-item--active");

        //Check that if we select the same v-slide-item--active it stays selected
        mandatorySlideGroup.slideByIndex(1).click();
        mandatorySlideGroup.has().slideSelected(1);

        //Check that if we select next slide it becomes 'selected' and all other slides become 'not selected'
        mandatorySlideGroup.slideByIndex(2).click();

        //Check theme of the group
        mandatorySlideGroup.is().darkTheme();
    }
}
