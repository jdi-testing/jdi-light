package com.jdiai.entities;

import com.epam.jdi.tools.DataClass;
import com.jdiai.annotations.UI;
import com.jdiai.jswraper.interfaces.GetValue;
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
