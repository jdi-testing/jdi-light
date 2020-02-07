package io.github.com.custom;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;

import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static java.lang.String.format;

public class SearchResult extends Section {
@Title  @Css("h3") public UIElement name;
        @Css("p") public UIElement description;
        @Css("a") public UIElement link;

    public String print() {
        return logger.logOff(
            () -> format("SearchResult{NAME=%s; DESCRIPTION=%s; LINK=%s}",
                name.getText(), description.getText(), link.getAttribute("href")));
    }
}
