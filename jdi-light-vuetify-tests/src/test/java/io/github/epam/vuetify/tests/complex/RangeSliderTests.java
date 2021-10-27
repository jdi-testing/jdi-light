package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.rangeSlidersPage;
import static io.github.com.pages.RangeSlidersPage.disabledRangeSlider;
import static io.github.com.pages.RangeSlidersPage.minAndMaxRangeSlider;
import static io.github.com.pages.RangeSlidersPage.stepRangeSlider;
import static io.github.com.pages.RangeSlidersPage.thumbLabelRangeSlider;
import static io.github.com.pages.RangeSlidersPage.verticalSlidersRangeSlider;

public class RangeSliderTests extends TestsInit {

    @BeforeClass
    public void before() {
        rangeSlidersPage.open();
        rangeSlidersPage.checkOpened();
    }

    @Test
    public void disabledSliderTest() {
        disabledRangeSlider.is().disabled();
        disabledRangeSlider.is().value(30, 60);
        disabledRangeSlider.slideHorizontalTo(20, 40);
        disabledRangeSlider.is().value(30, 60);
    }

    @Test
    public void minAndMaxRangeSliderTest() {
        minAndMaxRangeSlider.slideHorizontalTo(11, 66);
        minAndMaxRangeSlider.is().value(11, 66);
        minAndMaxRangeSlider.slideHorizontalTo(-50, 90);
        minAndMaxRangeSlider.is().value(-50, 90);
    }

    @Test
    public void stepRangeSliderTest() {
        stepRangeSlider.slideHorizontalTo(30, 40);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.slideHorizontalTo(26, 44);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.slideHorizontalTo(24, 46);
        stepRangeSlider.is().value(20, 50);
    }

    @Test
    public void verticalSlidersRangeSliderTest() {
        verticalSlidersRangeSlider.isVertical();
        verticalSlidersRangeSlider.slideVerticalTo(25, 45);
        verticalSlidersRangeSlider.is().value(25, 45);
        verticalSlidersRangeSlider.slideVerticalTo(0, 100);
        verticalSlidersRangeSlider.is().value(0, 100);
    }

    @Test
    public void thumbLabelRangeSliderTest() {
        thumbLabelRangeSlider.is().thumbLabelNotDisplayed();
        thumbLabelRangeSlider.getLeftThumb().click();
        thumbLabelRangeSlider.is().thumbLabelDisplayed();
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-leaf");
        thumbLabelRangeSlider.slideHorizontalTo(0, 2);
        thumbLabelRangeSlider.is().value(0, 2);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-fire");
        thumbLabelRangeSlider.slideHorizontalTo(0, 3);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-water");

        thumbLabelRangeSlider.is().trickAlwaysShow();
        thumbLabelRangeSlider.is().trickLabel(1, "Winter");
        thumbLabelRangeSlider.is().trickLabel(2, "Spring");
        thumbLabelRangeSlider.is().trickLabel(3, "Summer");
        thumbLabelRangeSlider.is().trickLabel(4, "Fall");
    }
}
