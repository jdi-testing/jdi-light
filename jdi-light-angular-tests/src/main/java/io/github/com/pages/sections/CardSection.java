package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardSection {
    @UI("#simple-card")
    public static Text simpleCard;

    @UI("//*[contains(@class, 'example-card')]")
    public static Section card;
}
