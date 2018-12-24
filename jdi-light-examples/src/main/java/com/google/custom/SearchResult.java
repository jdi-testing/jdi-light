package com.google.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;

public class SearchResult extends Section {
    @Title
    @Css("h3") public WebElement name;
    @Css(".st")  public WebElement description;
    @Css("cite") public WebElement link;

    public String print() {
        logger.logOff(() -> logger.logOff(() -> System.out.println("test")));

        return logger.logOff(
            () -> format("SearchResult{NAME=%s; DESCRIPTION=%s; LINK=%s}",
                name.getText(), description.getText(), link.getText()));
    }
}
