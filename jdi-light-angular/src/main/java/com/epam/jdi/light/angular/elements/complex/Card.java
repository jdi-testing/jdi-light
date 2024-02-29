package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.CardAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Image;

/**
 * To see an example of Card web element please visit https://material.angular.io/components/card/overview.
 */

public class Card extends UIBaseElement<CardAssert> {

    //Properties

    @JDIAction("Get '{name}' header")
    UIElement header() {
        return core().find(".//mat-card-header");
    }

    @JDIAction("Get '{name}' title")
    UIElement title() {
        return core().find(".mat-mdc-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    UIElement subtitle() {
        return core().find(".mat-mdc-card-subtitle");
    }

    @JDIAction("Get '{name}' avatar")
    Image avatar() {
        return new Image().setCore(Image.class, core().find(".mat-mdc-card-avatar"));
    }

    @JDIAction("Get '{name}' content")
    UIElement content() {
        return core().find(".//mat-card-content");
    }

    @JDIAction("Get '{name}' image")
    Image image() {
        return new Image().setCore(Image.class, core().find(".//img[@mat-card-image]"));
    }

    @JDIAction("Get '{name}' actions")
    UIElement actions() {
        return core().find(".//mat-card-actions");
    }

    @JDIAction("Get '{name}'s footer")
    UIElement footer() {
        return core().find(".//mat-card-footer");
    }

    //Methods

    @JDIAction("Click '{name}' LIKE button")
    void clickLike() {
        core().find(".//mat-card-actions//span[text()='LIKE']").click();
    }

    @JDIAction("Click '{name}' SHARE button")
    void clickShare() {
        core().find(".//mat-card-actions//span[text()='SHARE']").click();
    }

    @JDIAction("Get '{name}' header title text")
    String getHeaderTitleText() {
        return title().getText();
    }

    @JDIAction("Get '{name}' header subtitle text")
    String getHeaderSubtitleText() {
        return subtitle().getText();
    }

    //Events
}
