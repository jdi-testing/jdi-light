package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardImageCaps extends Section {
    @UI(".card-img-top")
    public Image image;
    @UI(".card-body")
    public Text text;
}
