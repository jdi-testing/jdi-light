package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.MaterialSelector;
import com.epam.jdi.light.angular.elements.complex.NativeSelector;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SelectSection {
    @JDropdown("#basic-mat-select")
    public static MaterialSelector basicMatSelect;

    @UI("#basic-native-select")
    public static NativeSelector basicNativeSelect;

    @JDropdown("#two-binding-select")
    public static MaterialSelector twoBindingSelect;

    @UI("#select-binding-confirm")
    public static Text selectBindingConfirmation;

    @JDropdown("#form-mat-select")
    public static MaterialSelector formMatSelect;

    @UI("#form-mat-select-confirm")
    public static Text formMatSelectConfirmation;

    @UI("#form-native-select")
    public static NativeSelector formNativeSelect;

    @UI("#form-native-select-confirm")
    public static Text formNativeSelectConfirmation;

    @JDropdown("#form-mat-feature-select")
    public static MaterialSelector formMatFeatureSelect;

    @UI("#form-native-feature")
    public static NativeSelector formNativeFeatureSelect;

    @JDropdown("#disable-mat-select")
    public static MaterialSelector disableMatSelect;

    @UI("#disable-native-select")
    public static NativeSelector disableNativeSelect;

    @UI("#disable-checkbox-select")
    public static Checkbox checkboxDisableSelect;

    @JDropdown("#reset-mat-select")
    public static MaterialSelector resetMatSelect;

    @UI("#reset-native-select")
    public static NativeSelector resetNativeSelect;

    @JDropdown("#option-groups-mat-select")
    public static MaterialSelector optionGroupsMatSelect;

    @UI("#option-groups-native-select")
    public static NativeSelector optionGroupsNativeSelect;

    @JDropdown("#multiple-select")
    public static MaterialSelector multipleSelect;

    @JDropdown("#custom-trigger-text-select")
    public static MaterialSelector customTriggerTextSelect;

    @JDropdown("#no-option-ripple-select")
    public static MaterialSelector noOptionRippleSelect;

    @JDropdown("#custom-panel-styling-select")
    public static MaterialSelector customPanelStylingSelect;

    @JDropdown("#mat-error-state-matcher-select")
    public static MaterialSelector matErrorStateMatcherSelect;

    @UI("#native-error-state-matcher")
    public static NativeSelector nativeErrorStateMatcherSelect;
}
