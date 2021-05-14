package com.jdiai.site;

import com.jdiai.JS;
import com.jdiai.annotations.UI;
import com.jdiai.annotations.Url;
import org.openqa.selenium.WebDriver;

@Url("/")
public class SeleniumHomePage {
    public SeleniumHomePage(WebDriver driver) { }
    @UI("#user-icon")
    public JS userIcon;
}
