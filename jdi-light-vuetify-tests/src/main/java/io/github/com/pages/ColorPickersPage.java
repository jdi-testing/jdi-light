package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
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

//    @UI("#InputsColorPicker > div.v-input__control") //#InputsColorPicker > div:nth-child(1) > div.v-color-picker__controls > div > div.v-color-picker__sliders > div.v-input.v-color-picker__alpha.v-input--hide-details.v-input--is-label-active.v-input--is-dirty.theme--light.v-input__slider.v-color-picker__track
//    public static Dropdown dropdownInput;

    @UI("#ModelColorPicker div.d-flex")
    public static ColorPicker modelColorPicker;

    @UI("#SwatchesColorPicker > div:first-child")
    public static ColorPicker mediumSwatchesColorPicker;

    @UI("#SwatchesColorPicker > div:nth-child(2)")
    public static ColorPicker smallSwatchesColorPicker;

    @UI("#SwatchesColorPicker > div:nth-child(3)")
    public static ColorPicker bigSwatchesColorPicker;

}
