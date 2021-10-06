package io.github.com.custom.windows;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class AccountCreatedWindow extends AccountWindow {

    @UI("h3")
    private Text welcome;

    @UI(".v-image")
    private Image image;

    public Text welcome() {
        return welcome;
    }

    public Image image() {
        return image;
    }
}
