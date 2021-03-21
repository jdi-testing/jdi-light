package org.jdiai.entities;

import org.jdiai.annotations.UI;
import org.jdiai.jswraper.interfaces.GetValue;

public class SearchItem {
    @UI("h3") public String title;
    @UI("p") public String description;
    @UI("a") @GetValue("href") public String link;

    @Override
    public String toString() {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
