package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardListGroups extends Section {

    @UI(".card-header") public Label cardHeader;
    @UI(".list-group-item") public WebList listGroups;
}
