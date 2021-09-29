package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> {

    @JDIAction("Get {name} 'menu' button")
    public UIElement getMenuButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get {name} 'text")
    public String getText() {
        return this.getText();
    }

    @JDIAction("Get {name} title")
    public UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get {name} 'search' button")
    public UIElement getSearchButton() {
        return this.find(".mdi-magnify");
    }

    @JDIAction("Get {name} 'heart' button")
    public UIElement getHeartButton() {
        return this.find(".mdi-heart");
    }

    @JDIAction("GGet {name} 'vertical dots' button")
    public UIElement getVerticalDotsButton() {
        return this.find(".mdi-dots-vertical");
    }

    @JDIAction("Get {name} header")
    public UIElement getHeader() {
        return this.find("header");
    }

    @JDIAction("{name} has 'menu' button")
    public boolean hasMenuButton() {
        Timer.waitCondition(this.getMenuButton()::isDisplayed);
        return getMenuButton().isClickable();
    }

    @JDIAction("{name} has title")
    public boolean hasTitle() {
        Timer.waitCondition(this.getTitle()::isDisplayed);
        return getTitle().isVisible();
    }

    @JDIAction("{name} has hidden title")
    public boolean hasHiddenTitle() {
        Timer.waitCondition(this.getTitle()::isHidden);
        return getTitle().isHidden();
    }

    @JDIAction("{name} has 'search' button")
    public boolean hasSearchButton() {
        Timer.waitCondition(this.getSearchButton()::isDisplayed);
        return getSearchButton().isClickable();
    }

    @JDIAction("{name} has 'heart' button")
    public boolean hasHeartButton() {
        Timer.waitCondition(this.getHeartButton()::isDisplayed);
        return getHeartButton().isClickable();
    }

    @JDIAction("{name} has 'vertical dots' button")
    public boolean hasVerticalDotsButton() {
        Timer.waitCondition(this.getVerticalDotsButton()::isDisplayed);
        return getVerticalDotsButton().isClickable();
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }
}
