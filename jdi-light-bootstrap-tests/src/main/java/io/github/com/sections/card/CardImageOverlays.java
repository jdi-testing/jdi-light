package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.VectorImage;

public class CardImageOverlays extends Section {
    @UI("#card-svg")
    public VectorImage vectorImage;
    @UI("#card-overlay-section")
    public OverlaySection overlaySection;
}
