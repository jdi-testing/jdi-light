package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardWithSubtitlesAndLinks extends Section {
    @Css(".card-title") public Text title;
    @Css(".card-subtitle") public Text subtitle;
    @Css(".card-text") public Text mainText;
    @Css("#bs-card-2-link1") public Link link1;
    @Css("#bs-card-2-link2") public Link link2;
}
