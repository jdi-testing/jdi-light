package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.light.vuetify.elements.common.Switch;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/banners/
 */

public class Banner extends UIBaseElement<BannerAssert> {

    @JDIAction("Get '{name}'s 'switch' element")
    private Switch getChecker() {
        return castToSwitch(find(".v-input__control"));
    }

    @JDIAction("Get '{name}'s buttons")
    private WebList getButtons() {
        return this.finds("button");
    }

    @JDIAction("Get '{name}'s icon")
    private UIElement getIcon() {
        return this.find("i");
    }

    @JDIAction("Get '{name}'s text field's state")
    public boolean hasHiddenTextField() {
        return find(".v-banner__text").isHidden();
    }

    @JDIAction("'{name}' has text")
    public String hasText() {
        return find(".v-banner__text").getText();
    }

    @JDIAction("'{name}' has text in title")
    public String hasTitle() {
        return find(".v-toolbar__title").getText();
    }

    @JDIAction("'{name}' has 'checker' element")
    public boolean hasChecker() {
        return getChecker().isDisplayed();
    }

    @JDIAction("'{name}' has icon")
    public boolean hasIcon() {
        return getIcon().isExist();
    }

    @JDIAction("'{name}' has alert after clicking on icon")
    public String hasAlertOnIconClick() {
        return this.core().driver().switchTo().alert().getText();
    }

    @JDIAction("'{name}' has buttons")
    public int hasButtons() {
        return getButtons().size();
    }

    @JDIAction("'{name}'s buttons are visible")
    public boolean hasVisibleButtons() {
        return getButtons().stream().allMatch(UIElement::isVisible);
    }

    @JDIAction("'{name}'s buttons are hidden")
    public boolean hasHiddenButtons() {
        return getButtons().stream().allMatch(UIElement::isHidden);
    }

    @JDIAction("'{name}' has checked checker")
    public boolean hasCheckerChecked() {
        return getChecker().isChecked();
    }

    @JDIAction("'{name}' has unchecked checker")
    public boolean hasCheckerUnchecked() {
        return getChecker().isNotChecked();
    }

    public void checkerCheck() {
        getChecker().check();
    }

    public void checkerUnCheck() {
        getChecker().uncheck();
    }

    public void handleAlert() {
        core().driver().switchTo().alert().dismiss();
    }

    public void clickOnIcon() {
        getIcon().click();
    }

    private Switch castToSwitch(UIElement element) {
        return new Switch().setCore(Switch.class, element);
    }

    public BannerAssert is() {
        return new BannerAssert().set(this);
    }

    public BannerAssert has() {
        return this.is();
    }
}
