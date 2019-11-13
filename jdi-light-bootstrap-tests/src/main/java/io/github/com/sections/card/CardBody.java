package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardBody extends Section {
    @UI(".card-body") public Text text;
}
