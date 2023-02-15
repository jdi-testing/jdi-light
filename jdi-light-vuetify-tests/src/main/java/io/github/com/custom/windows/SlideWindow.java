package io.github.com.custom.windows;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.window.Window;

public class SlideWindow extends Card {

    @UI(".v-window")
    public Window slideWindow;

}
