package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.MaterialSelector;
import com.epam.jdi.light.angular.elements.complex.NativeSelector;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SelectSection {
    @JDropdown(value = "#basic-mat-select")
    public static MaterialSelector basicMatSelect;

    @UI("#basic-native-select")
    public static NativeSelector basicNativeSelect;

    @JDropdown(value = "#two-binding-select")
    public static MaterialSelector twoBindingSelect;

    @UI("#select-binding-confirm")
    public static Text selectBindingConfirmation;

    @JDropdown(value = "#form-mat-select")
    public static MaterialSelector formMatSelect;

    @UI("#form-mat-select-confirm")
    public static Text formMatSelectConfirmation;

    @UI("#form-native-select")
    public static NativeSelector formNativeSelect;

    @UI("#form-native-select-confirm")
    public static Text formNativeSelectConfirmation;

    @JDropdown(value = "#form-mat-feature-select")
    public static MaterialSelector formMatFeatureSelect;

    @UI("#form-native-feature")
    public static NativeSelector formNativeFeatureSelect;

    @JDropdown(value = "#disable-mat-select")
    public static MaterialSelector disableMatSelect;

    @UI("#disable-native-select")
    public static NativeSelector disableNativeSelect;

    @UI("#disable-checkbox-select")
    public static Checkbox checkboxDisableSelect;

    @JDropdown(value = "#reset-mat-select")
    public static MaterialSelector resetMatSelect;

    @UI("#reset-native-select")
    public static NativeSelector resetNativeSelect;

    @JDropdown(value = "#option-groups-mat-select")
    public static MaterialSelector optionGroupsMatSelect;

    @UI("#option-groups-native-select")
    public static NativeSelector optionGroupsNativeSelect;

    @JDropdown(value = "#multiple-select")
    public static MaterialSelector multipleSelect;

    @JDropdown(value = "#custom-trigger-text-select")
    public static MaterialSelector customTriggerTextSelect;

    @JDropdown(value = "#no-option-ripple-select")
    public static MaterialSelector noOptionRippleSelect;

    @JDropdown(value = "#custom-panel-styling-select")
    public static MaterialSelector customPanelStylingSelect;

    @JDropdown(value = "#mat-error-state-matcher-select")
    public static MaterialSelector matErrorStateMatcherSelect;

    @UI(value = "#native-error-state-matcher")
    public static NativeSelector nativeErrorStateMatcherSelect;
}
