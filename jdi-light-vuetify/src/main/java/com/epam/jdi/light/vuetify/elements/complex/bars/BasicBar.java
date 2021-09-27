package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> {

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getMenuButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getSearchButton() {
        return this.find(".mdi-magnify");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getHeartButton() {
        return this.find(".mdi-heart");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getVerticalDotsButton() {
        return this.find(".mdi-dots-vertical");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getHeader() {
        return this.find("header");
    }


    @JDIAction("{name} has icon")
    public boolean hasMenuButton() {
        return getMenuButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasTitle() {
        return getTitle().isVisible();
    }

    @JDIAction("{name} has icon")
    public boolean hasHiddenTitle() {
        return getTitle().isHidden();
    }

    @JDIAction("{name} has icon")
    public boolean hasSearchButton() {
        return getSearchButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasHeartButton() {
        return getHeartButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasVerticalDotsButton() {
        return getVerticalDotsButton().isClickable();
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }
}
