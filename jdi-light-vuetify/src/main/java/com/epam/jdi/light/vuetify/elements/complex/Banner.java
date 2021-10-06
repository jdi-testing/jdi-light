package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see an example of Banner web element please visit https://jdi-testing.github.io/jdi-light/vuetify/banners
 *
 * From vuetify docs: "The v-banner component is used as middle-interruptive message to user with 1-2 actions.
 * It comes in 2 variations single-line and multi-line (implicit).
 * These can have icons which you can use with your message and actions."
 *
 */

public class Banner extends UIBaseElement<BannerAssert> {

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getChecker() {
        return this.find(".v-input__control");
    }

    @JDIAction("Get '{name}' text")
    public String getText() {
        return this.find(".v-banner__text").getText();
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getButton() {
        return this.find("button");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getButtons() {
        return this.finds("button");
    }

    @JDIAction("Get '{name}' icon")
    public UIElement getIcon() {
        return this.find("i");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getTextField() {
        return this.find(".v-banner__text");
    }

    @JDIAction("{name} has 'checker' element")
    public boolean hasChecker() {
        Timer.waitCondition(getChecker()::isDisplayed);
        return getChecker().isExist();
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String checkerState() {
        return getChecker().find("input").getAttribute("aria-checked");
    }

    @JDIAction("{name} has title")
    public String hasTitle() {
        Timer.waitCondition(getTitle()::isDisplayed);
        return getTitle().text();
    }

    @JDIAction("{name} has button")
    public boolean hasButton() {
        Timer.waitCondition(getButton()::isDisplayed);
        return getButton().isDisplayed();
    }

    @JDIAction("{name} has icon")
    public boolean hasIcon() {
        Timer.waitCondition(getIcon()::isDisplayed);
        return getIcon().isExist();
    }

    @JDIAction("{name} has alert after clicking on icon")
    public String hasAlertOnIconClick() {
        return this.core().driver().switchTo().alert().getText();
    }

    @JDIAction("{name} has buttons")
    public boolean hasButtons() {
        Timer.waitCondition(getButtons()::isDisplayed);
        return getButtons().size()>1;
    }

    public void handleAlert() {
        this.core().driver().switchTo().alert().dismiss();
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public BannerAssert is() {
        return new BannerAssert().set(this);
    }

    public BannerAssert has() {
        return this.is();
    }
}
