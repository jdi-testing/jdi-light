package com.epam.jdi.light.vuetify.elements.complex.banners;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

public class SingleBanner extends Banner {
    @JDIAction("Get '{name}' toolbar title")
    public UIElement toolbarTitle() {
        return toolbarContent().find(By.className("v-toolbar__title"));
    }
    @JDIAction("Get '{name}' control panel")
    public UIElement control() {
        return toolbarContent().find(".v-input__control");
    }

    @JDIAction("Get '{name}' checkbox")
    public UIElement checkbox() {
        return control().find(".v-input--selection-controls__input");
    }

    @JDIAction("Get '{name}' toolbar content")
    public UIElement toolbarContent() {
        return core().find(".v-toolbar__content");
    }

    @JDIAction("Get '{name}' single line property")
    public UIElement singleLineProperty () {
        return core().find("v-banner--single-line");
    }
}
