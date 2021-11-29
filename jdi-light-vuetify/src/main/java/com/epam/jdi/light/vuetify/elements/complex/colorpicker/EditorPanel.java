package com.epam.jdi.light.vuetify.elements.complex.colorpicker;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.ColorPickerAssert;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class EditorPanel extends UIBaseElement<ColorPickerAssert> {

    public static final String INPUT_FIRST_LOCATOR = "div:nth-of-type(1)";
    public static final String INPUT_SECOND_LOCATOR = "div:nth-of-type(2)";
    public static final String INPUT_THIRD_LOCATOR = "div:nth-of-type(3)";
    public static final String INPUT_FOURTH_LOCATOR = "div:nth-of-type(4)";
    public static final String INPUT_HEX_LOCATOR = "div.v-color-picker__input";
    public static final String BUTTON_LOCATOR = "button";

    public ColorInput inputR() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_FIRST_LOCATOR));
    }

    public ColorInput inputG() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_SECOND_LOCATOR));
    }

    public ColorInput inputB() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_THIRD_LOCATOR));
    }

    public ColorInput inputA() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_FOURTH_LOCATOR));
    }

    public ColorInput inputH() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_FIRST_LOCATOR));
    }

    public ColorInput inputS() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_SECOND_LOCATOR));
    }

    public ColorInput inputL() {
        return new ColorInput().setCore(ColorInput.class, core().find(INPUT_THIRD_LOCATOR));
    }

    public TextField inputHEX() {
        return new TextField().setCore(TextField.class, core().find(INPUT_HEX_LOCATOR));
    }

    public Button button() {
        return new Button().setCore(Button.class, core().find(BUTTON_LOCATOR));
    }

}
