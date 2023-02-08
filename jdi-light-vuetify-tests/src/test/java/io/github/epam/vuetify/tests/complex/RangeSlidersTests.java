package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.MdiIcons;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.RangeSlidersDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.rangeSlidersPage;
import static io.github.com.pages.RangeSlidersPage.adjustableRangeSlider;
import static io.github.com.pages.RangeSlidersPage.appendAndPrependIconsWithRangeSlider;
import static io.github.com.pages.RangeSlidersPage.colorRangeSlider;
import static io.github.com.pages.RangeSlidersPage.darkThemeSwitch;
import static io.github.com.pages.RangeSlidersPage.denseSwitch;
import static io.github.com.pages.RangeSlidersPage.disableSwitch;
import static io.github.com.pages.RangeSlidersPage.errorsHideDetailsSwitch;
import static io.github.com.pages.RangeSlidersPage.errorsRangerSlider;
import static io.github.com.pages.RangeSlidersPage.errorsTextFields;
import static io.github.com.pages.RangeSlidersPage.heightTextField;
import static io.github.com.pages.RangeSlidersPage.hintRangerSlider;
import static io.github.com.pages.RangeSlidersPage.labelRangerSlider;
import static io.github.com.pages.RangeSlidersPage.loadingRangerSlider;
import static io.github.com.pages.RangeSlidersPage.minAndMaxRangeSlider;
import static io.github.com.pages.RangeSlidersPage.persistentHintSwitch;
import static io.github.com.pages.RangeSlidersPage.readonlySwitch;
import static io.github.com.pages.RangeSlidersPage.ruleRangerSlider;
import static io.github.com.pages.RangeSlidersPage.stepRangeSlider;
import static io.github.com.pages.RangeSlidersPage.successRangerSlider;
import static io.github.com.pages.RangeSlidersPage.successTextFields;
import static io.github.com.pages.RangeSlidersPage.thumbLabelRangeSlider;
import static io.github.com.pages.RangeSlidersPage.thumbSizeSwitch;
import static io.github.com.pages.RangeSlidersPage.thumbSizeTextField;
import static io.github.com.pages.RangeSlidersPage.ticksRangerSlider;
import static io.github.com.pages.RangeSlidersPage.validateOnBlureSwitch;
import static io.github.com.pages.RangeSlidersPage.verticalSlidersRangeSlider;

public class RangeSlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        rangeSlidersPage.open();
        waitCondition(() -> rangeSlidersPage.isOpened());
        rangeSlidersPage.checkOpened();
    }

    @Test(description = "Test checks min and max range slider's values: min(0-n), max(0-n)")
    public void minAndMaxRangeSliderTest() {
        minAndMaxRangeSlider.show();
        minAndMaxRangeSlider.setValue(11, 66);
        minAndMaxRangeSlider.has().value(11, 66)
            .and().minValue(-50).and().maxValue(90);
        minAndMaxRangeSlider.setValue(-50, 90);
        minAndMaxRangeSlider.has().value(-50, 90);
    }

    @Test(description = "Test checks step range slider's values: step", dataProvider = "stepRangeSliderTestData", dataProviderClass = RangeSlidersDataProvider.class)
    public void stepRangeSliderTest(double approximateLeftValue, double approximateRightValue, double expectedLeftValue, double expectedRightValue) {
        stepRangeSlider.show();
        stepRangeSlider.setValue(approximateLeftValue, approximateRightValue);
        stepRangeSlider.has().value(expectedLeftValue, expectedRightValue);
    }

    @Test(description = "Test checks vertical range slider's values: vertical (y/n)")
    public void verticalRangeSliderTest() {
        verticalSlidersRangeSlider.show();
        verticalSlidersRangeSlider.setLeftValue(25);
        verticalSlidersRangeSlider.setRightValue(45);
        verticalSlidersRangeSlider.is().vertical().and().has().value(25, 45).
            and().leftValue(25).and().rightValue(45);
    }

    @Test(description = "Test checks slider's thumb : thumb-label (y/n/”always”/String), thumb-size (0-n)")
    public void thumbRangeSliderTest() {
        thumbLabelRangeSlider.show();
        thumbLabelRangeSlider.is().thumbLabelNotDisplayed();
        thumbLabelRangeSlider.setValue(0, 2);
        thumbLabelRangeSlider.leftThumb().click();
        thumbLabelRangeSlider.is().thumbLabelDisplayed().and().thumbLabelValue("mdi-snowflake", "mdi-fire")
            .is().thumbSize(32);

        adjustableRangeSlider.show();
        adjustableRangeSlider.setValue(10, 20);
        thumbSizeTextField.setText("16");
        thumbSizeSwitch.check();
        adjustableRangeSlider.is().thumbLabelDisplayed().and().has().thumbSize(16)
            .and().thumbLabelValue("10", "20");
        thumbSizeSwitch.uncheck();
        adjustableRangeSlider.has().noThumbLabels();
    }

    @Test(description = "Test checks slider's ticks: ticks (y/n/”always”), tick-labels (array), tick-size (0-n)")
    public void ticksRangeSliderTest() {
        String[] tickText = {"-2", "-1", "0", "1", "2"};
        ticksRangerSlider.show();
        ticksRangerSlider.has().ticks().and().ticksSize(5).and().is().ticksAlwaysShow();
        ticksRangerSlider.ticks().forEach(tick -> tick.is().displayed());
        IntStream.range(0, tickText.length).forEach(index ->
            ticksRangerSlider.is().tickLabel(index + 1, tickText[index]));

        adjustableRangeSlider.show();
        adjustableRangeSlider.has().noTicks();
    }

    @Test(description = "Test checks range slider's color: background-color (color), track-color (color), track-fill-color (color)," +
        " thumb-color (color)", dataProvider = "rangeSliderColorTestData", dataProviderClass = RangeSlidersDataProvider.class)
    public void colorRangeSliderTest(String backgroundColor, String trackColor, String trackFillColor, String thumbColor) {
        adjustableRangeSlider.show();
        adjustableRangeSlider.has().backgroundColor(backgroundColor)
            .and().trackColor(trackColor)
            .and().trackFillColor(trackFillColor)
            .and().thumbColor(thumbColor);
    }

    @Test(description = "Test checks if slider is disabled or not: disabled (y/n)")
    public void disabledRangeSliderTest() {
        adjustableRangeSlider.show();
        double leftValue = adjustableRangeSlider.leftValue();
        double newLeftValue = leftValue + 20;

        disableSwitch.check();
        adjustableRangeSlider.setLeftValue(newLeftValue);
        adjustableRangeSlider.is().disabled().and().has().leftValue(leftValue);

        disableSwitch.uncheck();
        adjustableRangeSlider.setLeftValue(newLeftValue);
        adjustableRangeSlider.is().enabled().and().has().leftValue(newLeftValue);
    }

    @Test(description = "Test checks slider's dense: dense (y/n)")
    public void denseRangeSliderTest() {
        adjustableRangeSlider.show();
        denseSwitch.check();
        adjustableRangeSlider.is().dense();
        denseSwitch.uncheck();
        adjustableRangeSlider.is().notDense();
    }

    @Test(description = "Test checks if slider is readonly or not: readonly (y/n)")
    public void readonlyRangeSliderTest() {
        adjustableRangeSlider.show();
        double leftValue = adjustableRangeSlider.leftValue();
        double newLeftValue = leftValue + 30;

        readonlySwitch.check();
        adjustableRangeSlider.setLeftValue(newLeftValue);
        adjustableRangeSlider.is().readonly().and().has().leftValue(leftValue);

        readonlySwitch.uncheck();
        adjustableRangeSlider.setLeftValue(newLeftValue);
        adjustableRangeSlider.is().notReadonly().and().has().leftValue(newLeftValue);
    }

    @Test(description = "Test checks range slider's theme: theme (dark/light)")
    public void themeRangeSliderTest() {
        adjustableRangeSlider.show();
        darkThemeSwitch.check();
        adjustableRangeSlider.has().darkTheme();
        darkThemeSwitch.uncheck();
        adjustableRangeSlider.has().lightTheme();
    }

    @Test(description = "Test checks if slider has details hidden or not: hide-details(y/n)")
    public void hideDetailsRangeSliderTest() {
        errorsRangerSlider.show();
        errorsHideDetailsSwitch.check();
        errorsRangerSlider.has().detailsHidden().and().noErrorMessages();
        errorsHideDetailsSwitch.uncheck();
        errorsRangerSlider.has().notDetailsHidden().and().errorMessages();
    }

    @Test(description = "Test checks slider's messages: hint(string), persistent-hint (y/n)")
    public void hintRangeSliderTest() {
        String hintMessage = "Some hint";
        hintRangerSlider.show();
        hintRangerSlider.has().messagesCount(0);
        hintRangerSlider.leftThumb().click();
        waitCondition(() -> hintRangerSlider.messages().size() > 0);
        hintRangerSlider.has().messagesCount(1).and().messageText(hintMessage);

        persistentHintSwitch.check();
        hintRangerSlider.has().messagesCount(1);
        hintRangerSlider.clickOutsideOfSlider();
        hintRangerSlider.has().messagesCount(1);
    }

    @Test(description = "Test checks slider's height: height (0-n)")
    public void heightRangeSliderTest() {
        heightTextField.setText("40");
        adjustableRangeSlider.show();
        adjustableRangeSlider.has().height(40);
    }

    @Test(description = "Test checks slider's loader : loading(y/n/color), loader-height (0-n)")
    public void loadingRangeSliderTest() {
        loadingRangerSlider.show();
        loadingRangerSlider.is().loading();
        loadingRangerSlider.loader().has().height(10).and().barColor("rgba(28, 100, 246, 1)");
    }

    @Test(description = "Test checks slider's label: label (string),  inverse-label (y/n)")
    public void labelRangeSliderTest() {
        labelRangerSlider.get(1).show();
        labelRangerSlider.get(1).has().label("lableText");
        labelRangerSlider.get(2).has().inverseLabel().and().label("inverselableText");

        colorRangeSlider.show();
        colorRangeSlider.has().noLabel();
    }

    @Test(description = "Test checks slider's icons: append-icon (y/n), prepend-icon (y/n)")
    public void appendAndPrependIconsRangeSliderTest() {
        appendAndPrependIconsWithRangeSlider.get(1).show();
        appendAndPrependIconsWithRangeSlider.get(1).appendOuterIcon().is().mdiIconName(MdiIcons.MAP_MARKER.value());
        appendAndPrependIconsWithRangeSlider.get(2).prependOuterIcon().is().mdiIconName(MdiIcons.MAGNIFY.value());
    }

    @Test(description = "Test checks slider's rules: rules, validate-on-blur")
    public void validateOnBlurRangeSliderTest() {
        String message = "some error";
        ruleRangerSlider.show();
        validateOnBlureSwitch.check();
        ruleRangerSlider.has().messagesCount(0);
        ruleRangerSlider.setValue(-30, 30);
        ruleRangerSlider.leftThumb().click();
        ruleRangerSlider.clickOutsideOfSlider(); //validate-on-blur works only after click on slider and then click outside
        ruleRangerSlider.has().messagesCount(1).and().messageText(message);

        validateOnBlureSwitch.uncheck();
        ruleRangerSlider.setValue(-30, 30);
        ruleRangerSlider.has().messagesCount(1).and().messageText(message);
        ruleRangerSlider.setValue(-10, 10);
        ruleRangerSlider.has().messagesCount(0);
    }

    @Test(description = "Test checks slider's success messages: success (y/n), success-messages (string)",
        dataProvider = "successRangeSliderTestData", dataProviderClass = RangeSlidersDataProvider.class)
    public void successRangeSliderTest(int messagesCount, List<String> messages) {
        successRangerSlider.show();
        successTextFields.get(1).setText(String.valueOf(messagesCount));
        successRangerSlider.is().success().and().has().successMessagesCount(messagesCount).and().successMessages(messages);
    }

    @Test(description = "Test checks slider's error messages: error (y/n), error-messages (string)",
        dataProvider = "errorRangeSliderTestData", dataProviderClass = RangeSlidersDataProvider.class)
    public void errorsSliderTest(int messagesCount, List<String> messages) {
        errorsRangerSlider.show();
        errorsTextFields.get(1).setText(String.valueOf(messagesCount));
        errorsRangerSlider.is().error().and().has().errorMessagesCount(messagesCount).and().errorMessages(messages);
    }

    @Test(description = "Test checks slider's without success and errors: success (y/n), errors (y/n)")
    public void successRangeSliderTest() {
        colorRangeSlider.show();
        colorRangeSlider.is().notSuccess().and().notError();
    }
}
