package io.github.com.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardKitchenSink extends Section {
    @UI(".card-img-top") public Image image;
    @UI(".card-title") public Text title;
    @UI(".card-text") public Text text;
    @UI(".card-body") public WebList body;
    @UI(".list-group") public WebList list;
}
