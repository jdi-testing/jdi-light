package com.google.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class SearchResult extends Section {
    @Title
    @Css("h3>a") public WebElement name;
    @Css(".st")  public WebElement description;
    @Css("cite") public WebElement link;

    public String print() {
        return logger.logOff(() -> "SearchResult{" +
                "NAME=" + name.getText() +
                ", DESCRIPTION=" + description.getText() +
                ", LINK=" + link.getText() +
                '}');
    }
}
