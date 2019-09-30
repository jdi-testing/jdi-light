package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardBorder extends Section {
    @UI(".card-header") public Text border;

    @Title @UI(".card-title") public Text title;

    @UI(".card-text") public Text text;
}
