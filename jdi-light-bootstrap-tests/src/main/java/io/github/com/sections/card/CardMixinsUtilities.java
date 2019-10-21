package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardMixinsUtilities extends Section {
    @UI(".card-header") public Text header;
    @UI(".card-footer") public Text footer;
    @Title
    @UI(".card-title") public Text title;
    @UI(".card-text") public Text text;
}
