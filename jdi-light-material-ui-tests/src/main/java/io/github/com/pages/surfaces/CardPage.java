package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JDICard;
import com.epam.jdi.light.material.elements.surfaces.Card;

public class CardPage extends WebPage {

    @JDICard(cardBackground = ".MuiCardActionArea-root", cardContent = ".MuiCardContent-root")
    public Card card;

}
