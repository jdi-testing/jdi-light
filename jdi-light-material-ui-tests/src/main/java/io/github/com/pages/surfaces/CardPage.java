package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Card;

public class CardPage extends WebPage {

    @UI("#simpleCard")
    public static Card simpleCard;

    @UI("#outlinedCard")
    public static Card outlinedCard;

    @UI("#complexInteraction")
    public static Card complexCard;

    public static UIElement complexCardImage() {
        return complexCard.find(".MuiCardMedia-root");
    }

    public static UIElement complexCardHeartButtonIcon() {
        return complexCard.getActionButtonByNumber(1).find(".MuiSvgIcon-root");
    }

    public static UIElement complexCardCollapsibleContent() {
        return complexCard.find(".MuiCollapse-container");
    }
}
