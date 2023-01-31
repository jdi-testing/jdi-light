package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.RangeSlidersDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.rangeSlidersPage;
import static io.github.com.pages.RangeSlidersPage.disabledRangeSlider;
import static io.github.com.pages.RangeSlidersPage.minAndMaxRangeSlider;
import static io.github.com.pages.RangeSlidersPage.stepRangeSlider;
import static io.github.com.pages.RangeSlidersPage.verticalSlidersRangeSlider;
import static io.github.com.pages.RangeSlidersPage.thumbLabelRangeSlider;
import static io.github.com.pages.RangeSlidersPage.adjustableRangeSlider;
import static io.github.com.pages.RangeSlidersPage.colorRangeSlider;
import static io.github.com.pages.RangeSlidersPage.thumbLabelControl;
import static io.github.com.pages.RangeSlidersPage.colorPicker;

public class RangeSlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        rangeSlidersPage.open();
        waitCondition(() -> rangeSlidersPage.isOpened());
        rangeSlidersPage.checkOpened();
    }

    @Test (enabled = false, description = "Test checks range slider if range slider is disabled")
    public void disabledSliderTest() {
        disabledRangeSlider.is().disabled();
        disabledRangeSlider.is().value(30, 60);
        disabledRangeSlider.setValue(20, 40);
        disabledRangeSlider.is().value(30, 60);
    }

    @Test(description = "Test checks min and max range slider's values")
    public void minAndMaxRangeSliderTest() {
        minAndMaxRangeSlider.setValue(11, 66);
        minAndMaxRangeSlider.is().value(11, 66);
        minAndMaxRangeSlider.setValue(-50, 90);
        minAndMaxRangeSlider.is().value(-50, 90);
    }

    @Test(description = "Test checks step range slider's values")
    public void stepRangeSliderTest() {
        stepRangeSlider.setValue(30, 40);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.setValue(26, 44);
        stepRangeSlider.is().value(30, 40);
        stepRangeSlider.setValue(24, 46);
        stepRangeSlider.is().value(20, 50);
    }

    @Test(description = "Test checks vertical range slider's values")
    public void verticalSlidersRangeSliderTest() {
        verticalSlidersRangeSlider.setValue(25, 45);
        verticalSlidersRangeSlider.is().value(25, 45);
        verticalSlidersRangeSlider.has().leftValue(25);
        verticalSlidersRangeSlider.has().rightValue(45);
        verticalSlidersRangeSlider.setValue(0, 100);
        verticalSlidersRangeSlider.is().value(0, 100);
    }

    @Test(description = "Test checks slider's thumb : thumb-label (y/n/”always”), thumb-size (0-n)")
    public void thumbLabelRangeSliderTest() {
        thumbLabelRangeSlider.show();
        thumbLabelRangeSlider.is().thumbLabelNotDisplayed();
        thumbLabelRangeSlider.leftThumb().click();
        thumbLabelRangeSlider.is().thumbLabelDisplayed();
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-leaf");
        thumbLabelRangeSlider.setValue(0, 2);
        thumbLabelRangeSlider.is().value(0, 2);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-fire");
        thumbLabelRangeSlider.setValue(0, 3);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-snowflake", "mdi-water");

        thumbLabelRangeSlider.setLeftValue(1);
        thumbLabelRangeSlider.has().leftValue(1);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-leaf", "mdi-water");
        thumbLabelRangeSlider.setRightValue(2);
        thumbLabelRangeSlider.has().rightValue(2);
        thumbLabelRangeSlider.is().thumbLabelValue("mdi-leaf", "mdi-fire");

        thumbLabelRangeSlider.is().trickAlwaysShow();
        thumbLabelRangeSlider.is().trickLabel(1, "Winter");
        thumbLabelRangeSlider.is().trickLabel(2, "Spring");
        thumbLabelRangeSlider.is().trickLabel(3, "Summer");
        thumbLabelRangeSlider.is().trickLabel(4, "Fall");

        thumbLabelRangeSlider.is().rightThumbSize(16);
        thumbLabelRangeSlider.is().leftThumbSize(16);

        adjustableRangeSlider.show();
        adjustableRangeSlider.is().thumbLabelDisplayed();
        thumbLabelControl.click();
        adjustableRangeSlider.has().noThumbLabels();
    }

    @Test(description = "Test checks range slider's color", dataProvider = "rangeSliderColorTestData", dataProviderClass = RangeSlidersDataProvider.class)
    public void trackRangeSliderColor(String color){
        colorRangeSlider.show();
        colorPicker.setColor(color);
        waitCondition(() -> colorRangeSlider.trackColor().equals(Colors.RED_TRANSPARENT_055.value()));
        colorRangeSlider.has().trackColor(color);
    }
}
