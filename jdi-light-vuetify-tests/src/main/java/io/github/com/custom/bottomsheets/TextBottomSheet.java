package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;

public class TextBottomSheet extends Dialog {
    @UI(".text-center > div")
    protected Text text;

    @UI("button")
    protected Button button;

    public void close() {
        button.click();
    }

    public Text sheetText() {
        return text;
    }

}
