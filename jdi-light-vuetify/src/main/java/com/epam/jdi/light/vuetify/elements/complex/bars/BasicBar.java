package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.common.Icon;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> implements IsText {

    @JDIAction("Get '{name}' 'menu' button")
    private VuetifyButton getMenuButton() {
        return findIconButton("mdi-menu");
    }

    @JDIAction("Get '{name}' title")
    private UIElement getTitle() {
        return find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' 'vertical dots' button")
    private VuetifyButton getVerticalDotsButton() {
        return findIconButton("mdi-dots-vertical");
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
        VuetifyButton searchButton = findIconButton("mdi-magnify");
        return searchButton.isDisplayed();
    }

    @JDIAction("'{name}' has 'heart' button")
    public boolean hasHeartButton() {
        VuetifyButton heartButton = findIconButton("mdi-heart");
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

    protected VuetifyButton findIconButton(String buttonLocator) {
        return new VuetifyButton(find(String.format("//i[contains(@class, '%s')]/ancestor::button", buttonLocator)));
    }

    protected Icon castToIcon(UIElement element) {
        return new Icon().setCore(Icon.class, element);
    }
}
