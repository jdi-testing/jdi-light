package com.epam.jdi.light.vuetify.elements.complex.colorpicker;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.ColorPickerAssert;
import com.epam.jdi.light.vuetify.elements.complex.Slider;

public class ColorPicker extends UIBaseElement<ColorPickerAssert> {

    private String CANVAS_LOCATOR = "div.v-color-picker__canvas";
    private String CANVAS_DOT_LOCATOR = "div.v-color-picker__canvas-dot";
    private String HUE_SLIDER_LOCATOR = "div.v-color-picker__hue";
    private String ALPHA_SLIDER_LOCATOR = "div.v-color-picker__alpha";
    private String DOT_LOCATOR = "div.v-color-picker__dot";
    private String EDITOR_PANEL_LOCATOR = "div.v-color-picker__edit";
    private String SWATCHES_LOCATOR = "div.v-color-picker__swatches";

    public UIElement canvas() {
        return find(CANVAS_LOCATOR);
    }

    public UIElement canvasDot() {
        return find(CANVAS_DOT_LOCATOR);
    }

    public UIElement colorDot() {
        return find(DOT_LOCATOR);
    }

    public Slider hueSlider() {
        return new Slider().setCore(Slider.class, core().find(HUE_SLIDER_LOCATOR));
    }

    public Slider alphaSlider() {
        return new Slider().setCore(Slider.class, core().find(ALPHA_SLIDER_LOCATOR));
    }

    public EditorPanel editorPanel() {
        return new EditorPanel().setCore(EditorPanel.class, core().find(EDITOR_PANEL_LOCATOR));
    }

    public UIElement swatches() {
        return find(SWATCHES_LOCATOR);
    }

}
