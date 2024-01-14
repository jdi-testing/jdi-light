package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.cards.ComplexInteractionCard;
import io.github.com.custom.elements.cards.SimpleCard;

public class CardPage extends WebPage {

    @UI("#simpleCard")
    public static SimpleCard simpleCard;

    @UI("#outlinedCard")
    public static SimpleCard outlinedCard;

    @UI("#complexInteraction")
    public static ComplexInteractionCard complexCard;

    // @todo #5297 Class should be created to describe the card with image or image is a legal part of the card
    @UI("#complexInteraction .MuiCardMedia-root")
    public static Image complexCardImage;

    @UI("#complexInteraction .MuiCollapse-root")
    public static Text complexCardDropdownText;

}
