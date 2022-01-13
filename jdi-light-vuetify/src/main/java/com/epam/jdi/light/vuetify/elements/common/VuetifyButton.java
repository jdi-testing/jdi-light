package com.epam.jdi.light.vuetify.elements.common;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.VuetifyButtonAssert;

/**
 * To see the example of Buttons web element please visit
 * https://vuetifyjs.com/en/components/buttons/
 */

public class VuetifyButton extends Button implements HasClick {

    @UI("i")
    protected Icon icon;

    @UI(".v-btn__loader")
    protected UIElement loader;

    VuetifyButton() {
    }

    public VuetifyButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return icon;
    }

    @JDIAction("Get '{name}'s loader")
    public UIElement loader() {
        return loader;
    }

    @JDIAction("Get '{name}'s color")
    public String getColor() {
        return css("background-color");
    }

    @JDIAction("Check if '{name}' is loading")
    public boolean isLoading() {
        return loader.isVisible();
    }

    @Override
    public VuetifyButtonAssert assertThat() {
        return is();
    }

    @Override
    public VuetifyButtonAssert is() {
        VuetifyButtonAssert vuetifyButtonAssert = new VuetifyButtonAssert();
        vuetifyButtonAssert.set(this);
        return vuetifyButtonAssert;
    }

    @Override
    public VuetifyButtonAssert has() {
        return is();
    }

    @Override
    public VuetifyButtonAssert waitFor() {
        return is();
    }

    @Override
    public VuetifyButtonAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public VuetifyButtonAssert shouldBe() {
        return is();
    }

    @Override
    public VuetifyButtonAssert verify() {
        assertSoft();
        return is();
    }
}
