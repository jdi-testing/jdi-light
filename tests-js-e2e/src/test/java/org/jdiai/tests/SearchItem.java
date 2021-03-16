package org.jdiai.tests;

import com.epam.jdi.tools.DataClass;
import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends DataClass<SearchItem> {
    @UI(tag = "h3") String title;
    @FindBy(tagName = "p") String description;
    @UI("a") @GetValue("href") String link;

    @Override
    public String toString () {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
