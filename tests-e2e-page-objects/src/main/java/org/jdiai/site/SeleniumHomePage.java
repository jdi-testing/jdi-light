package org.jdiai.site;

import org.jdiai.JS;
import org.jdiai.annotations.UI;
import org.jdiai.annotations.Url;
import org.openqa.selenium.WebDriver;

@Url("/")
public class SeleniumHomePage {
    public SeleniumHomePage(WebDriver driver) { }
    @UI("#user-icon")
    public JS userIcon;
}
