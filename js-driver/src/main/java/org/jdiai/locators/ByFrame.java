package org.jdiai.locators;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ByFrame extends By implements Serializable {
    public final String locator;
    public final String type;
    public ByFrame(String locator, String type) {
        this.locator = locator;
        this.type = type;
    }
    public List<WebElement> findElements(SearchContext context) {
        return new ArrayList<>();
    }
    public String toString() {
        return "By.frame: " + locator;
    }
    public static ByFrame id(String id) {
        return new ByFrame(id, "id");
    }
    public static ByFrame css(String css) {
        return new ByFrame(css, "css");
    }
}
