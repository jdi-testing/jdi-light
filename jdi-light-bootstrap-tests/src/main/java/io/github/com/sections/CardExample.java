package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardExample extends Section {
    @Css(".card-title") public Text title;
    @Css(".card-text") public Text text;
    @Css(".btn") public Button button;
    @Css(".card-img-top") public Image image;
}
