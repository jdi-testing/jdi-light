package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.elements.textfields.SelectTextField;

public class SelectPage extends WebPage {

    @JDropdown(root = "//*[@id='demo-simple-select']/following-sibling::div")
    public static Select simpleSelect;

    @JDropdown(root = "//*[@id='demo-disabled-select']/following-sibling::div")
    public static Select disabledSelect;

    @UI("//*[@id='age-native-simple']/../..")
    public static SelectTextField ageNativeSimpleSelect;

    @UI("//*[@id='age-native-helper']/../..")
    public static SelectTextField ageNativeHelperSelect;

    @UI("//*[@id='age-native-label-placeholder']/../..")
    public static SelectTextField ageNativeLabelPlaceholderSelect;

    @UI("//*[@id='name-native-disabled']/../..")
    public static SelectTextField ageNameNativeDisabledSelect;

    @UI("//*[@id='name-native-error']/../..")
    public static SelectTextField ageNameNativeErrorSelect;

    @UI("//*[@id='uncontrolled-native']/../..")
    public static SelectTextField uncontrolledNativeSelect;

    @UI("//p[text()='Placeholder']/..")
    public static SelectTextField placeholderNativeSelect;

    @UI("//*[@id='age-native-required']/../..")
    public static SelectTextField ageNativeRequiredSelect;

    @UI("//*[@id='outlined-age-native-simple']/../..")
    public static SelectTextField outlinedAgeNativeSimpleSelect;

    @UI("//*[@id='filled-age-native-simple']/../..")
    public static SelectTextField filledAgeNativeSimpleSelect;

    @JDropdown(root = "//*[@id='demo-multiple-select']/following-sibling::div", autoClose = true)
    public static Select multipleSelect;

    @UI("#grouped-native-select")
    public static Dropdown groupedNativeSelect;

    @JDropdown(root = "//*[@id='grouped-select']/..")
    public static Select groupedSelect;

    @UI("//button[./span[text()='Open the select']]")
    public static Button openSelectButton;

    @JDropdown(root = "//*[@id='demo-controlled-open-select-label']/following-sibling::div")
    public static Select controlledOpenSelect;
}
