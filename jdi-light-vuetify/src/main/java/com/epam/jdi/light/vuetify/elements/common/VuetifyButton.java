package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.VuetifyButtonAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

/**
 * To see the example of Buttons web element please visit
 * https://v2.vuetifyjs.com/en/components/buttons/
 */

public class VuetifyButton extends Button implements HasClick, HasIcon,
        HasColor, HasTheme, HasElevation, IsOutlined,
    HasMeasurement, HasRounded {

    @UI(".v-btn__loader")
    protected UIElement loader;

    public VuetifyButton() {
    }

    public VuetifyButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Get '{name}'s loader")
    public UIElement loader() {
        return loader;
    }

    @JDIAction("Get 'name' border color")
    public String borderColor() {
        return core().css("border-color");
    }

    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        return loader.isVisible();
    }

    @JDIAction("Get 'name' aria-label")
    public String ariaLabel() {
        return core().getAttribute("aria-label");
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

    @Override
    public boolean isRounded() {
        return core().attr("class").contains("v-btn--rounded");
    }

}
