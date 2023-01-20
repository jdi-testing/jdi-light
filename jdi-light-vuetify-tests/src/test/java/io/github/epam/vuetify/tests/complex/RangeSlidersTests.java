package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.rangeSlidersPage;
import static io.github.com.pages.RangeSlidersPage.disabledRangeSlider;
import static io.github.com.pages.RangeSlidersPage.minAndMaxRangeSlider;
import static io.github.com.pages.RangeSlidersPage.stepRangeSlider;
import static io.github.com.pages.RangeSlidersPage.verticalSlidersRangeSlider;
import static io.github.com.pages.RangeSlidersPage.thumbLabelRangeSlider;
import static io.github.com.pages.RangeSlidersPage.colorRangerSlider;

public class RangeSlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        rangeSlidersPage.open();
        waitCondition(() -> rangeSlidersPage.isOpened());
        rangeSlidersPage.checkOpened();
    }

    @Test (enabled = false, description = "Check disabled ranger slider")
    public void disabledSliderTest() {
        boolean isVertical = disabledRangeSlider.isVertical();
        disabledRangeSlider.is().disabled();
        disabledRangeSlider.is().value(30, 60);
        disabledRangeSlider.setValue(20, 40, isVertical);
        disabledRangeSlider.is().value(30, 60);
    }

    @Test(description = "Check min and max ranger slider")
    public void minAndMaxRangeSliderTest() {
        boolean isVertical = minAndMaxRangeSlider.isVertical();
        minAndMaxRangeSlider.setValue(11, 66, isVertical);
        minAndMaxRangeSlider.is().value(11, 66);
        minAndMaxRangeSlider.setValue(-50, 90, isVertical);
        minAndMaxRangeSlider.is().value(-50, 90);
    }

    @Test(description = "Check step ranger slider")
    public void stepRangeSliderTest() {
        boolean isVertical = stepRangeSlider.isVertical();
        stepRangeSlider.setValue(30, 40, isVertical);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.setValue(26, 44, isVertical);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.setValue(24, 46, isVertical);
        stepRangeSlider.is().value(20, 50);
    }

    @Test(description = "Check vertical ranger slider")
    public void verticalSlidersRangeSliderTest() {
        boolean isVertical = verticalSlidersRangeSlider.isVertical();
        verticalSlidersRangeSlider.setValue(25, 45, isVertical);
        verticalSlidersRangeSlider.is().value(25, 45);
        verticalSlidersRangeSlider.has().leftValue(25);
        verticalSlidersRangeSlider.has().rightValue(45);
        verticalSlidersRangeSlider.setValue(0, 100, isVertical);
        verticalSlidersRangeSlider.is().value(0, 100);
    }

    @Test(description = "Check ranger slider's thumb : thumb-label (y/n/”always”), thumb-size (0-n)")
    public void thumbLabelRangeSliderTest() {
        thumbLabelRangeSlider.show();
        boolean isVertical = thumbLabelRangeSlider.isVertical();
        thumbLabelRangeSlider.is().thumbLabelNotDisplayed();
        thumbLabelRangeSlider.getLeftThumb().click();
        thumbLabelRangeSlider.is().thumbLabelDisplayed();
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-leaf");
        thumbLabelRangeSlider.setValue(0, 2, isVertical);
        thumbLabelRangeSlider.is().value(0, 2);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-fire");
        thumbLabelRangeSlider.setValue(0, 3, isVertical);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-water");

        thumbLabelRangeSlider.setLeftValue(1, isVertical);
        thumbLabelRangeSlider.has().leftValue(1);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-leaf", "mdi-water");
        thumbLabelRangeSlider.setRightValue(2, isVertical);
        thumbLabelRangeSlider.has().rightValue(2);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-leaf", "mdi-fire");

        thumbLabelRangeSlider.is().trickAlwaysShow();
        thumbLabelRangeSlider.is().trickLabel(1, "Winter");
        thumbLabelRangeSlider.is().trickLabel(2, "Spring");
        thumbLabelRangeSlider.is().trickLabel(3, "Summer");
        thumbLabelRangeSlider.is().trickLabel(4, "Fall");

        thumbLabelRangeSlider.is().rightThumbSize(16);
        thumbLabelRangeSlider.is().leftThumbSize(16);
    }

    @Test(description = "Check ranger slider's color")
    public void thumbRangeSliderColor(){
        colorRangerSlider.show();
        colorRangerSlider.setRangerSliderColor("244", "67", "54");
        waitCondition(() -> colorRangerSlider.trackColor().equals(Colors.RED.value()));
        colorRangerSlider.has().trackColor(Colors.RED.value());
    }
}
