package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.CardAssert;
import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.CardImageSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Image;

import static com.epam.jdi.light.angular.elements.enums.CardImageSize.EXTRALARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.SMALL;
import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Card web element please visit https://material.angular.io/components/card/overview.
 */

public class Card extends UIBaseElement<CardAssert> {
    @JDIAction("Get '{name}' header")
    public UIElement getHeader() {
        return this.find(".mat-mdc-card-header");
    }

    @JDIAction("Get '{name}' footer")
    public UIElement getFooter() {
        return this.find(".mat-mdc-card-footer");
    }

    @JDIAction("Get '{name}' avatar")
    public UIElement getAvatar() {
        return this.find(".mat-mdc-card-avatar");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".mat-mdc-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement getSubtitle() {
        return this.find(".mat-mdc-card-subtitle");
    }

    @JDIAction("Get '{name}' image")
    public Image image() {
        core().show();
        if (core().find("//img").isExist()) {
            return new Image().setCore(Image.class, core().find("//img"));
        } else {
            throw runtimeException("Element doesn't have image", this);
        }
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return this.find(".mat-mdc-card-content");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getButtons() {
        return this.finds(".//mat-card-actions//button");
    }

    @JDIAction("Get '{name}' text")
    public String getCardText() {
        return core().getText();
    }

    @JDIAction("Get button with text '{text}'")
    public Button getButtonByText(String text) {
        return new Button().setCore(Button.class, this.getButtons().get(text));
    }

    @JDIAction("Get button with number '{number}'")
    public Button getButtonByNumber(int number) {
        return new Button().setCore(Button.class, this.getButtons().get(number));
    }

    @JDIAction("Get if {name} has align end actions")
    public boolean actionsEndAlign() {
        UIElement e = core().find("mat-card-actions");
        if (e.isExist()) {
            return e.hasClass("mat-mdc-card-actions-align-end");
        } else {
            throw new RuntimeException("Element does not have actions");
        }
    }

    @JDIAction("Get '{name}' size")
    public CardImageSize cardHeaderImageSize() {
        UIElement image = core().find("//mat-card-header//img");
        return defineSize(image);
    }

    @JDIAction("Get '{name}' size")
    public CardImageSize cardImageSize() {
        UIElement image = core().find("//img");
        return defineSize(image);
    }

    public CardImageSize defineSize(UIElement image) {
        CardImageSize size = CardImageSize.UNKNOWN;
        if (image.hasClass("mat-mdc-card-xl-image")) {
            size = EXTRALARGE;
        }
        if (image.hasClass("mat-mdc-card-lg-image")) {
            size = LARGE;
        }
        if (image.hasClass("mat-mdc-card-md-image")) {
            size = MEDIUM;
        }
        if (image.hasClass("mat-mdc-card-sm-image")) {
            size = SMALL;
        }
        return size;
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }

    @Override
    public CardAssert has() {
        return is();
    }
}
