package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;


import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;

public class ColorPickersPage extends VuetifyPage {

    @UI("#CanvasColorPicker > div:first-child")
    public static ColorPicker noCanvasColorPicker;

    @UI("#CanvasColorPicker > div:nth-child(2)")
    public static ColorPicker fullCanvasColorPicker;

    @UI("#CanvasColorPicker > div:nth-child(3)")
    public static ColorPicker halfCanvasColorPicker;

    @UI("#ElevationColorPicker > div:first-child")
    public static ColorPicker flatColorPicker;

    @UI("#ElevationColorPicker > div:nth-child(2)")
    public static ColorPicker elevationColorPicker;

    @UI("#InputsColorPicker > div:nth-child(1)")
    public static ColorPicker noInputsColorPicker;

    @UI("#InputsColorPicker > div:nth-child(2)")
    public static ColorPicker rgbaInputColorPicker;

    @UI("#InputsColorPicker > div:nth-child(3)")
    public static ColorPicker dropdownInputColorPicker;

    @JDropdown(root = "#InputsColorPicker > div:nth-child(3) > .v-input",
            value = ".v-select__selection.v-select__selection--comma",
            list = "//ancestor::div[@id='app']//div[@role='listbox']//div[@class='v-list-item__content']",
            expand = ".v-input__icon.v-input__icon--append")
    public static Dropdown dropdownInput;

    @UI("#ModelColorPicker  div.col-md-4  button:nth-of-type(1)")
    public static VuetifyButton hexModelButton;

    @UI("#ModelColorPicker  div.col-md-4  button:nth-of-type(2)")
    public static VuetifyButton hexaModelButton;

    @UI("#ModelColorPicker  div.col-md-4  button:nth-of-type(3)")
    public static VuetifyButton rgbaModelButton;

    @UI("#ModelColorPicker  div.col-md-4  button:nth-of-type(4)")
    public static VuetifyButton hslaModelButton;

    @UI("#ModelColorPicker  div.col-md-4  button:nth-of-type(5)")
    public static VuetifyButton hsvaModelButton;

    @UI("#ModelColorPicker div.d-flex")
    public static ColorPicker modelColorPicker;

    @UI("#SwatchesColorPicker > div:first-child")
    public static ColorPicker mediumSwatchesColorPicker;

    @UI("#SwatchesColorPicker > div:nth-child(2)")
    public static ColorPicker smallSwatchesColorPicker;

    @UI("#SwatchesColorPicker > div:nth-child(3)")
    public static ColorPicker bigSwatchesColorPicker;

}
