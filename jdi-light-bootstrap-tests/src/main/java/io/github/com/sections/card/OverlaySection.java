package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class OverlaySection extends Section {
    @UI(".card-title")
    public Text title;
    @UI(".card-text-main")
    public Text textMain;
    @UI(".card-text-status")
    public Text textStatus;
}
