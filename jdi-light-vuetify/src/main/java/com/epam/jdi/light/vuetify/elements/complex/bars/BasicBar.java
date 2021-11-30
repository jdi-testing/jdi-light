package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Icon;

public abstract class BasicBar<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIBaseElement<A> implements IsText {

    @JDIAction("Get '{name}' 'menu' button")
    public Button menuButton() {
        return findIconButton("mdi-menu");
    }

    @JDIAction("Get '{name}' title")
    private UIElement getTitle() {
        return find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' 'vertical dots' button")
    public Button verticalDotsButton() {
        return findIconButton("mdi-dots-vertical");
    }

    @JDIAction("Get '{name}' 'vertical dots' button")
    public Button searchButton() {
        return findIconButton("mdi-magnify");
    }

    @JDIAction("Get '{name}' 'vertical dots' button")
    public Button heartButton() {
        return findIconButton("mdi-heart");
    }

    @JDIAction("Get '{name}' header")
    protected UIElement getHeader() {
        return find("header");
    }

    @JDIAction("'{name}' has title")
    public boolean hasTitle() {
        return getTitle().isDisplayed();
    }

    @JDIAction("'{name}' has hidden title")
    public boolean hasHiddenTitle() {
        return getTitle().isHidden();
    }

    @JDIAction("Get '{name}' title text")
    public String titleText() {
        return getTitle().getText();
    }

    protected Button findIconButton(String buttonLocator) {
        return new Button(find(String.format("//i[contains(@class, '%s')]/ancestor::button", buttonLocator)));
    }

    protected Icon castToIcon(UIElement element) {
        return new Icon().setCore(Icon.class, element);
    }
}
