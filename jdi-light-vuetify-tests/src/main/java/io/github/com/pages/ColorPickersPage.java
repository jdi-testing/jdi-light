package io.github.com.pages;

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
    public static ColorPicker flatElevationColorPicker;

    @UI("#ElevationColorPicker > div:nth-child(2)")
    public static ColorPicker elevationColorPicker;

    @UI("#SwatchesColorPicker > div:first-child")
    public static ColorPicker swatchesColorPicker;

}
