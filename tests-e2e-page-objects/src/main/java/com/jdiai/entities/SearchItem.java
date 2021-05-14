package com.jdiai.entities;

import com.jdiai.annotations.UI;
import com.jdiai.jswraper.interfaces.GetValue;

public class SearchItem {
    @UI("h3") public String title;
    @UI("p") public String description;
    @UI("a") @GetValue("href") public String link;

    @Override
    public String toString() {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
