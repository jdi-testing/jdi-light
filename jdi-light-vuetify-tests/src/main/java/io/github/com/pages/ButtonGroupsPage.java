package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDIButtonGroup;
import com.epam.jdi.light.vuetify.elements.complex.ButtonGroup;

public class ButtonGroupsPage extends VuetifyPage {

    // mandatory button group section
    @UI("#MandatoryButtonGroup .v-item-group")  // buttons search strategy is default
    public static ButtonGroup mandatoryButtonGroup;


    // multiple button group section
    @JDIButtonGroup(root = "#MultipleButtonGroup .v-item-group") // container selector is defined similarly to @UI()
    public static ButtonGroup multipleButtonGroup;
    @UI("#MultipleButtonGroup div.text-center")
    public static Text modelText;


    // rounded button group section
    @JDIButtonGroup(
            root = "#RoundedButtonGroup .v-item-group",
            buttons = "//*[@type = 'button']"
    ) // buttons search strategy is custom
    public static ButtonGroup roundedButtonGroup;


    // toolkit section
    @JDropdown(
            root = "//*[@id = 'ToolbarButtonGroup']//div[contains(@class, 'v-autocomplete')][1]" +
                    "//div[@role = 'combobox']",
            expand = ".v-input__append-inner",
            value = ".v-select__selection--comma",
            list = "//ancestor-or-self::*//div[@role='listbox' and .//div[@class = 'v-list-item__title' " +
                    "and contains(text(), 'Arial')]]//div[contains(@class, 'v-list-item__title')]"
    )
    public static Dropdown fontDropdown;

    @JDropdown(
            root = "//*[@id = 'ToolbarButtonGroup']//div[contains(@class, 'v-autocomplete')][2]" +
                    "//div[@role = 'combobox']",
            expand = ".v-input__append-inner",
            value = ".v-select__selection--comma",
            list = "//ancestor-or-self::*//div[@role='listbox' and .//div[@class = 'v-list-item__title' " +
                    "and contains(text(), '0%')]]//div[contains(@class, 'v-list-item__title')]"
    )
    public static Dropdown sizeDropdown;

    @UI("//*[@id = 'ToolbarButtonGroup']//div[contains(@class, 'v-item-group')][1]")
    @JDIButtonGroup(buttons = "button")
    public static ButtonGroup fontDecorationGroup; // combined annotation

    @UI("//*[@id = 'ToolbarButtonGroup']//div[contains(@class, 'v-item-group')][2]")
    public static ButtonGroup fontAlignmentGroup;


    // WYSIWYG section
    @UI("//*[@id = 'WYSIWYGButtonGroup']//div[contains(@class, 'v-item-group') " +
            "and .//i[contains(@class, 'mdi-format-bold')]]")
    public static ButtonGroup fontDecorationGroupWYSIWYG;

    @UI("//*[@id = 'WYSIWYGButtonGroup']//div[contains(@class, 'v-item-group') " +
            "and .//i[contains(@class, 'mdi-format-align-center')]]")
    public static ButtonGroup fontAlignmentGroupWYSIWYG;

}
