package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.ColorPickerAssert;
import org.openqa.selenium.support.Color;

public class ColorPicker extends UIBaseElement<ColorPickerAssert> {

    protected final String CANVAS_LOCATOR = "div.v-color-picker__canvas";
    protected final String CANVAS_DOT_LOCATOR = "div.v-color-picker__canvas-dot";
    protected final String HUE_SLIDER_LOCATOR = "div.v-color-picker__hue";
    protected final String ALPHA_SLIDER_LOCATOR = "div.v-color-picker__alpha";
    protected final String DOT_LOCATOR = "div.v-color-picker__dot div";
    protected final String INPUT_FIRST_LOCATOR = "div.v-color-picker__edit div:nth-of-type(1)";
    protected final String INPUT_SECOND_LOCATOR = "div.v-color-picker__edit div:nth-of-type(2)";
    protected final String INPUT_THIRD_LOCATOR = "div.v-color-picker__edit div:nth-of-type(3)";
    protected final String INPUT_FOURTH_LOCATOR = "div.v-color-picker__edit div:nth-of-type(4)";
    protected final String INPUT_HEX_LOCATOR = "div.v-color-picker__input";
    protected final String BUTTON_LOCATOR = "button";
    protected final String SWATCHES_LOCATOR = "div.v-color-picker__swatches";

    //TODO: implement setup() method

    @Override
    public ColorPickerAssert is() {
        return new ColorPickerAssert().set(this);
    }

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

    public UIElement swatches() {
        return find(SWATCHES_LOCATOR);
    }

    public TextField inputRH() {
        return new TextField().setCore(TextField.class, core().find(INPUT_FIRST_LOCATOR));
    }

    public TextField inputGS() {
        return new TextField().setCore(TextField.class, core().find(INPUT_SECOND_LOCATOR));
    }

    public TextField inputBL() {
        return new TextField().setCore(TextField.class, core().find(INPUT_THIRD_LOCATOR));
    }

    public TextField inputA() {
        return new TextField().setCore(TextField.class, core().find(INPUT_FOURTH_LOCATOR));
    }

    public TextField inputHEX() {
        return new TextField().setCore(TextField.class, core().find(INPUT_HEX_LOCATOR));
    }

    public Button button() {
        return new Button().setCore(Button.class, core().find(BUTTON_LOCATOR));
    }

    public Color getColor() {
        String styleColor = colorDot().getAttribute("style");
        String stringColor = styleColor.substring(12, styleColor.length() - 1);
        return Color.fromString(stringColor);
    }

    public void setColor(String value) {
        Color color = Color.fromString(value);
        String red = String.valueOf(color.getColor().getRed());
        String green = String.valueOf(color.getColor().getGreen());
        String blue = String.valueOf(color.getColor().getBlue());

        String stringAlpha = String.valueOf(color.getColor().getAlpha());
        double doubleAlpha = Double.parseDouble(stringAlpha) / 255.0D;
        String alpha = String.format("%.2f", doubleAlpha).replace(",", ".");
        inputRH().setText(red);
        inputGS().setText(green);
        inputBL().setText(blue);
        inputA().setText(alpha);
    }

}
