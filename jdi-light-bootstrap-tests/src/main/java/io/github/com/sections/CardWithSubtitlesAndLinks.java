package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardWithSubtitlesAndLinks extends Section {
    @UI(".card-title") public Text title;
    @UI(".card-subtitle") public Text subtitle;
    @UI(".card-text") public Text mainText;
    @UI("#bs-card-2-link1") public Link link1;
    @UI("#bs-card-2-link2") public Link link2;
}
