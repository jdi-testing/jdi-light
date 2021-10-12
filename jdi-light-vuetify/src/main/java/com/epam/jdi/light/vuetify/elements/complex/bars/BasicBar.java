package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> implements IsText {

    @JDIAction("Get '{name}' 'menu' button")
    private UIElement getMenuButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get '{name}' title")
    private UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get {name} 'vertical dots' button")
    private UIElement getVerticalDotsButton() {
        return this.find(".mdi-dots-vertical");
    }

    @JDIAction("Get {name} header")
    protected UIElement getHeader() {
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
        UIElement searchButton = this.find(".mdi-magnify");
        Timer.waitCondition(searchButton::isDisplayed);
        return searchButton.isClickable();
    }

    @JDIAction("{name} has 'heart' button")
    public boolean hasHeartButton() {
        UIElement heartButton = this.find(".mdi-heart");
        Timer.waitCondition(heartButton::isDisplayed);
        return heartButton.isClickable();
    }

    @JDIAction("{name} has 'vertical dots' button")
    public boolean hasVerticalDotsButton() {
        Timer.waitCondition(this.getVerticalDotsButton()::isDisplayed);
        return getVerticalDotsButton().isClickable();
    }

    @JDIAction("Get {name} title")
    public String titleText() {
        return this.getTitle().getText();
    }

    @JDIAction("Click on 'menu' button")
    public void clickOnMenuButton() {
        this.getMenuButton().click();
    }

    @JDIAction("Click on 'vertical dots' button")
    public void clickOnVerticalDotsButton() {
        this.getVerticalDotsButton().click();
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }
}
