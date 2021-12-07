package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Switch;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/banners/
 */

public class Banner extends UIBaseElement<BannerAssert> {

    @JDIAction("Get '{name}'s 'switch' element")
    public Switch getSwitch() {
        return new Switch().setCore(Switch.class, find(".v-input--switch"));
    }

    @JDIAction("Get '{name}'s 'checkbox' element")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(".v-input--checkbox"));
    }

    @JDIAction("Get '{name}'s button")
    public Button button() {
        return new Button(find("button"));
    }

    @JDIAction("Get '{name}'s button group")
    public ButtonGroup buttons() {
        return new ButtonGroup(find(".v-banner__actions"));
   }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find("i"));
    }

    @JDIAction("Get '{name}'s text content")
    public Text textContent() {
        return new Text().setCore(Text.class, find(".v-banner__text"));
    }

    @JDIAction("Get '{name}'s title")
    public String getTitle() {
        return find(".v-toolbar__title").getText();
    }

    @JDIAction("Get '{name}'s alert's text")
    public String getAlertText() {
        return core().driver().switchTo().alert().getText();
    }

    @JDIAction("Dismiss alert")
    public void dismissAlert() {
        core().driver().switchTo().alert().dismiss();
    }

    public BannerAssert is() {
        return new BannerAssert().set(this);
    }
}
