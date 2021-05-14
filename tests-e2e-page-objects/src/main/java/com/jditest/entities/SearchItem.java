package com.jditest.entities;

import com.jditest.annotations.UI;
import com.jditest.jswraper.interfaces.GetValue;

public class SearchItem {
    @UI("h3") public String title;
    @UI("p") public String description;
    @UI("a") @GetValue("href") public String link;

    @Override
    public String toString() {
        return "[Title: " + title + "; Description: " + description + "; Link: " + link + "]";
    }
}
