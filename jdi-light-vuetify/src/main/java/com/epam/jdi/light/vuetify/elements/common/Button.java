package com.epam.jdi.light.vuetify.elements.common;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.asserts.ButtonAssert;

/**
 * To see the example of Buttons web element please visit
 * https://vuetifyjs.com/en/components/buttons/
 */

public class Button extends com.epam.jdi.light.ui.html.elements.common.Button implements HasClick {

    @UI("i")
    protected Icon icon;

    @UI(".v-btn__loader")
    protected UIElement loader;

    Button() {
    }

    public Button(UIElement element) {
        core().setCore(element);
    }

    public Icon icon() {
        return icon;
    }

    public UIElement loader() {
        return loader;
    }

    @JDIAction("Check if '{name}' is loading")
    public boolean isLoading() {
        return loader.isVisible();
    }

//    @JDIAction("Check if {name} is disabled")
//    @Override
//    public boolean isDisabled() {
//        return core().hasClass("v-btn--disabled");
//    }

//    @JDIAction("Check if {name} is displayed")
//    @Override
//    public boolean isDisplayed() {
//        return !core().getAttribute("style").contains("display: none");
//    }

//    @JDIAction("Check if {name} is hidden")
//    @Override
//    public boolean isHidden() {
//        return core().getAttribute("style").contains("display: none");
//    }

    @Override
    public ButtonAssert assertThat() {
        return is();
    }

    @Override
    public ButtonAssert is() {
        ButtonAssert buttonAssert = new ButtonAssert();
        buttonAssert.set(this);
        return buttonAssert;
    }

    @Override
    public ButtonAssert has() {
        return is();
    }

    @Override
    public ButtonAssert waitFor() {
        return is();
    }

    @Override
    public ButtonAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public ButtonAssert shouldBe() {
        return is();
    }

    @Override
    public ButtonAssert verify() {
        assertSoft();
        return is();
    }
}
