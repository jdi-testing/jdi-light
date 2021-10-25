package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> implements IsText {

    @JDIAction("Get '{name}' 'menu' button")
    private Button getMenuButton() {
        return new Button(find("//i[contains(@class, 'mdi-menu')]/ancestor::button"));
    }

    @JDIAction("Get '{name}' title")
    private UIElement getTitle() {
        return find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' 'vertical dots' button")
    private Button getVerticalDotsButton() {
        return new Button(find("//i[contains(@class, 'mdi-dots-vertical')]/ancestor::button"));
    }

    @JDIAction("Get '{name}' header")
    protected UIElement getHeader() {
        return find("header");
    }

    @JDIAction("'{name}' has 'menu' button")
    public boolean hasMenuButton() {
        return getMenuButton().isDisplayed();
    }

    @JDIAction("'{name}' has title")
    public boolean hasTitle() {
        return getTitle().isDisplayed();
    }

    @JDIAction("'{name}' has hidden title")
    public boolean hasHiddenTitle() {
        return getTitle().isHidden();
    }

    @JDIAction("'{name}' has 'search' button")
    public boolean hasSearchButton() {
        Button searchButton = new Button(find("//i[contains(@class, 'mdi-magnify')]/ancestor::button"));
        return searchButton.isDisplayed();
    }

    @JDIAction("'{name}' has 'heart' button")
    public boolean hasHeartButton() {
        Button heartButton = new Button(find("//i[contains(@class, 'mdi-heart')]/ancestor::button"));
        return heartButton.isDisplayed();
    }

    @JDIAction("'{name}' has 'vertical dots' button")
    public boolean hasVerticalDotsButton() {
        return getVerticalDotsButton().isDisplayed();
    }

    @JDIAction("Get '{name}' title text")
    public String titleText() {
        return getTitle().getText();
    }

    @JDIAction("Click on 'menu' button")
    public void clickOnMenuButton() {
        getMenuButton().click();
    }

    @JDIAction("Click on 'vertical dots' button")
    public void clickOnVerticalDotsButton() {
        getVerticalDotsButton().click();
    }
}
