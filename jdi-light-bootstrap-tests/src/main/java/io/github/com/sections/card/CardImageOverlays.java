package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardImageOverlays extends Card {
    @UI("#card-svg")
    public Image image;
    @UI("#card-overlay-section")
    public OverlaySection overlaySection;
}
