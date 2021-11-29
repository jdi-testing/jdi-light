package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.colorPickersPage;
import static io.github.com.pages.ColorPickersPage.fullCanvasColorPicker;
import static io.github.com.pages.ColorPickersPage.swatchesColorPicker;

public class ColorPickerTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        colorPickersPage.open();
    }

    @Test
    public void setColorTest() {

    }

    @Test
    public void alphaSliderTest() {
        System.out.println(swatchesColorPicker.alphaSlider().attr("class"));
    }

    @Test
    public void editorPanelTest() {
        System.out.println(swatchesColorPicker.editorPanel().attr("class"));
    }

    @Test
    public void editorPanelButtonTest() {
        System.out.println(fullCanvasColorPicker.editorPanel().button().attr("class"));
    }

    @Test
    public void editorPanelInputRTest() {
        System.out.println(fullCanvasColorPicker.editorPanel().inputR().attr("class"));
    }

    @Test
    public void editorPanelInputATest() {
        System.out.println(fullCanvasColorPicker.editorPanel().inputA().attr("class"));
    }

    @Test
    public void editorPanelInputHEXTest() {
        fullCanvasColorPicker.editorPanel().button().click();
        fullCanvasColorPicker.editorPanel().button().click();
        System.out.println(fullCanvasColorPicker.editorPanel().inputHEX().attr("class"));
        fullCanvasColorPicker.editorPanel().inputHEX().has().text("#FF0000FF");
        System.out.println(fullCanvasColorPicker.editorPanel().inputHEX().find("span").getText());
    }

    @Test
    public void swatchesTest() {
        System.out.println(swatchesColorPicker.swatches().attr("style"));
    }

}
