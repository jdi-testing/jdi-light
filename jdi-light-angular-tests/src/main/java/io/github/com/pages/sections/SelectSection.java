package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.MaterialSelector;
import com.epam.jdi.light.angular.elements.complex.NativeSelector;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SelectSection {

    @UI("#basic-mat-select")
    public static MaterialSelector basicMatSelect;

    @UI("#basic-native-select")
    public static NativeSelector basicNativeSelect;

    @UI("#two-binding-select")
    public static MaterialSelector twoBindingSelect;

    @UI("#select-binding-confirm")
    public static Text selectBindingConfirm;

    @UI("#form-mat-select")
    public static MaterialSelector formMatSelect;

    @UI("#form-mat-select-confirm")
    public static Text formMatSelectConfirm;

    @UI("#form-native-select")
    public static NativeSelector formNativeSelect;

    @UI("#form-native-select-confirm")
    public static Text formNativeSelectConfirm;

    @UI("#form-mat-feature-select")
    public static MaterialSelector formMatFeatureSelect;

    @UI("#form-native-feature-select")
    public static NativeSelector formNativeFeatureSelect;

    @UI("#disable-mat-select")
    public static MaterialSelector disableMatSelect;

    @UI("#disable-native-select")
    public static NativeSelector disableNativeSelect;

    @UI("#disable-checkbox-select")
    public static Checkbox disableCheckboxSelect;

    @UI("#reset-mat-select")
    public static MaterialSelector resetMatSelect;

    @UI("#reset-native-select")
    public static NativeSelector resetNativeSelect;

    @UI("#option-groups-mat-select")
    public static MaterialSelector optionGroupsMatSelect;

    @UI("#form-native-feature-select")
    public static NativeSelector optionGroupsNativeSelect;

    @UI("#multiple-select")
    public static MaterialSelector multipleSelect;

    @UI("##custom-trigger-text-select")
    public static MaterialSelector customTriggerTextSelect;

    @UI("#no-option-ripple-select")
    public static MaterialSelector noOptionRippleSelect;

    @UI("#custom-panel-styling-select")
    public static MaterialSelector customPanelStylingSelect;

    @UI("#mat-error-state-matcher-select")
    public static MaterialSelector matErrorStateMatcherSelect;

    @UI("#native-error-state-matcher-select")
    public static NativeSelector nativeErrorStateMatcherSelect;
}
