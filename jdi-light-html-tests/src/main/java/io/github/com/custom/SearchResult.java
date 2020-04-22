package io.github.com.custom;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static com.epam.jdi.light.settings.WebSettings.*;
import static java.lang.String.*;

public class SearchResult extends Section {
        @UI("h3") public Label name;
        @UI("p") public Text description;
        @UI("a") public Link link;

    public String print() {
        return logger.logOff(
            () -> format("SearchResult{NAME=%s; DESCRIPTION=%s; LINK=%s}",
                name.getText(), description.getText(), link.ref()));
    }
}
