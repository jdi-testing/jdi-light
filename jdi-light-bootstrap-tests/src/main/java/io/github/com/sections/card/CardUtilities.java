package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardUtilities extends Section {

    @Title
    @UI(".card-title")
    public Text cardTitle;

    @UI(".card-text")
    public Text cardText;

    @UI(".btn")
    public Button cardButton;
}
