package org.jdiai.tests.jsdriver.flow;

import com.epam.jdi.tools.DataClass;
import org.jdiai.tools.GetValue;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends DataClass<SearchItem> {
    @FindBy(tagName = "h3")
    String title;
    @FindBy(tagName = "p")
    String description;
    @FindBy(tagName = "a") @GetValue("href")
    String link;

    @Override
    public String toString () {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
