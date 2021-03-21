package org.jdiai.entities;

import com.epam.jdi.tools.DataClass;
import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends DataClass<SearchItem> {
    @UI(tag = "h3") public String title;
    @FindBy(tagName = "p") public String description;
    @UI("a") @GetValue("href") public String link;

    @Override
    public String toString () {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
