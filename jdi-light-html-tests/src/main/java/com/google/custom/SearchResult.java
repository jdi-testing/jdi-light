package com.google.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Link;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.Title;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;

public class SearchResult extends Section {
    @UI("h3") public Title name;
    @UI(".st") public Text description;
    @UI("cite") public Link link;

    public String print() {
        logger.logOff(() -> logger.logOff(() -> System.out.println("test")));

        return logger.logOff(
            () -> format("SearchResult{NAME=%s; DESCRIPTION=%s; LINK=%s}",
                name.getText(), description.getText(), link.getText()));
    }
}
