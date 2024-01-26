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
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.UNKNOWN;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * To see an example of Card web element please visit https://material.angular.io/components/card/overview.
 */

public class Card extends UIBaseElement<CardAssert> {

    @JDIAction("Get '{name}' header")
    public UIElement header() {
        return this.find(".mat-mdc-card-header");
    }

    @JDIAction("Get '{name}' footer")
    public UIElement footer() {
        return this.find(".mat-mdc-card-footer");
    }

    @JDIAction("Get '{name}' avatar")
    public Image avatar() {
        return new Image().setCore(Image.class, core().find(".mat-mdc-card-avatar"));
    }

    @JDIAction("Get '{name}' title")
    public UIElement title() {
        return this.find(".mat-mdc-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement subtitle() {
        return this.find(".mat-mdc-card-subtitle");
    }

    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return this.find(".mat-mdc-card-content");
    }

    @JDIAction("Get '{name}' action buttons")
    public WebList actionButtons() {
        return this.finds(".//mat-card-actions//button");
    }

    @JDIAction("Get '{name}' text")
    public String getCardText() {
        return core().getText();
    }

    @JDIAction("Get button with text '{text}'")
    public Button getButtonByText(String text) {
        return new Button().setCore(Button.class, this.actionButtons().get(text));
    }

    @JDIAction("Get button with number '{number}'")
    public Button buttonByNumber(int number) {
        return new Button().setCore(Button.class, this.actionButtons().get(number));
    }

    @JDIAction("Get if {name} has align end actions")
    public boolean actionsEndAlign() {
        UIElement e = core().find("mat-card-actions");
        if (e.isExist()) {
            return e.hasClass("mat-mdc-card-actions-align-end");
        } else {
            throw runtimeException("Element does not have actions");
        }
    }

    @JDIAction("Get '{name}' image")
    public Image cardBodyImage() {
        UIElement potentialImage = core().find("//img[@mat-card-image]");
        if (potentialImage.isExist()) {
            return new Image().setCore(Image.class, potentialImage);
        } else {
            throw runtimeException("Element doesn't have image", this);
        }
    }

    @JDIAction("Get '{name}' header image")
    public Image cartHeaderImage() {
        UIElement potentialImage = core().find("//mat-card-header//img");
        if (potentialImage.isExist()) {
            return new Image().setCore(Image.class, potentialImage);
        } else {
            throw runtimeException("Element doesn't have image", this);
        }
    }

    @JDIAction("Get '{name}' size")
    public CardImageSize cardHeaderImageSize() {
        Image image = cartHeaderImage();
        return defineSize(image);
    }

    private CardImageSize defineSize(Image image) {
        CardImageSize size = UNKNOWN;

        if (isNotBlank(image.classLike("-xl-"))) {
            size = EXTRALARGE;
        }
        if (isNotBlank(image.classLike("-lg-"))) {
            size = LARGE;
        }
        if (isNotBlank(image.classLike("-md-"))) {
            size = MEDIUM;
        }
        if (isNotBlank(image.classLike("-sm-"))) {
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
