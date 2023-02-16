package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.RangeSlider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;

public class RangeSlidersPage extends VuetifyPage {

    @UI("#MinAndMaxRangeSlider .v-slider")
    public static RangeSlider minAndMaxRangeSlider;

    @UI("#StepRangeSlider .v-slider")
    public static RangeSlider stepRangeSlider;

    @UI("#VerticalSlidersRangeSlider .v-slider")
    public static RangeSlider verticalSlidersRangeSlider;

    @UI("#ThumbLabelRangeSlider .v-slider")
    public static RangeSlider thumbLabelRangeSlider;

    @UI("#AppendAndPrependIconsWithRangeSlider .v-slider")
    public static List<RangeSlider> appendAndPrependIconsWithRangeSlider;

    @UI("#LabelRangerSlider .v-slider")
    public static List<RangeSlider> labelRangerSlider;

    @UI("#ColorRangerSlider .v-slider")
    public static RangeSlider colorRangeSlider;

    @UI("#LoadingRangerSlider .v-input--range-slider .v-slider")
    public static RangeSlider loadingRangerSlider;

    @UI("#HintRangerSlider .v-slider")
    public static RangeSlider hintRangerSlider;

    @UI("#HintRangerSlider .v-input--switch")
    public static Switch persistentHintSwitch;

    @UI("#RuleRangerSlider .v-slider")
    public static RangeSlider ruleRangerSlider;

    @UI("#SuccessRangerSlider .v-slider")
    public static RangeSlider successRangerSlider;

    @UI("#SuccessRangerSlider .v-text-field")
    public static List<TextField> successTextFields;

    @UI("#ErrorsRangerSlider .v-slider")
    public static RangeSlider errorsRangerSlider;

    @UI("#ErrorsRangerSlider .v-input--switch")
    public static Switch errorsHideDetailsSwitch;

    @UI("#ErrorsRangerSlider .v-text-field")
    public static List<TextField> errorsTextFields;

    @UI("#RuleRangerSlider .v-input--switch")
    public static Switch validateOnBlureSwitch;

    @UI("#TicksRangerSlider .v-slider")
    public static RangeSlider ticksRangerSlider;

    @UI("#AdjustableRangerSlider .v-slider")
    public static RangeSlider adjustableRangeSlider;

    @UI("#AdjustableRangerSlider .v-input--switch[1]")
    public static Switch disableSwitch;

    @UI("#AdjustableRangerSlider .v-input--switch[2]")
    public static Switch denseSwitch;

    @UI("#AdjustableRangerSlider .v-input--switch[3]")
    public static Switch readonlySwitch;

    @UI("#AdjustableRangerSlider .v-input--switch[4]")
    public static Switch darkThemeSwitch;

    @UI("#AdjustableRangerSlider .v-text-field[1]")
    public static TextField heightTextField;
    @UI("#AdjustableRangerSlider .v-text-field[2]")
    public static TextField thumbSizeTextField;

    @UI("#AdjustableRangerSlider .v-input--switch[6]")
    public static Switch thumbSizeSwitch;
}
