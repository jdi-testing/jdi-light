package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

public class SelectPage extends WebPage {

    @UI("//div[@id='simple-select']")
    public static Button simpleSelectExpand;

    @UI("//input")
    public static List<TextField> simpleSelectField;

    @UI("//ul")
    public static Select selectList;

    @UI("li.MuiListItem-button")
    public static List<UIElement> selectListItems;

    @UI("//button/span[@class='MuiButton-label']")
    public static Button openTheSelectButton;

    @UI("//div[@id='multiple-select']")
    public static Button multipleSelectButton;

    @UI("//select[@id='age-native-simple']")
    public static Dropdown ageNativeSimpleSelect;

    @UI("//select[@id='age-native-helper']")
    public static Dropdown ageNativeHelperSelect;

    @UI("//p[text()='With visually hidden label']/preceding::select[@aria-label='age']")
    public static Dropdown visuallyHiddenLabelSelect;

    @UI("//select[@id='age-native-label-placeholder']")
    public static Dropdown ageNativeLabelSelect;

    @UI("//select[@id='name-native-disabled']")
    public static Dropdown disabledSelect;

    @UI("//select[@id='name-native-error']")
    public static Dropdown errorSelect;

    @UI("//select[@id='uncontrolled-native']")
    public static Dropdown uncontrolledSelect;

    @UI("//p[text()='Uncontrolled']/following::select[@aria-label='age']")
    public static Dropdown placeholderSelect;

    @UI("//select[@id='age-native-required']")
    public static Dropdown requiredSelect;

    @UI("//select[@id='outlined-age-native-simple']")
    public static Dropdown outlinedSelect;

    @UI("//select[@id='filled-age-native-simple']")
    public static Dropdown filledSelect;

    @UI("//select[@id='grouped-native-select']")
    public static Dropdown groupedNativeSelect;

    @UI("//div[@id='grouped-select']")
    public static Button groupedSelectButton;

    @UI("//div[@id='demo-controlled-open-select']")
    public static Button controlledSelect;

    @UI("//h2[text()='Native select']/following::label")
    public static List<Text> nativeSelectLabels;

    @UI("//p")
    public static List<Text> helperLabels;

    @UI("//div[@id='disabled-select']")
    public static Button disabledSelectExpand;
}
