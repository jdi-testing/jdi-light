package com.jditest.site;

import com.jditest.JS;
import com.jditest.annotations.UI;
import com.jditest.annotations.Url;
import org.openqa.selenium.WebDriver;

@Url("/")
public class SeleniumHomePage {
    public SeleniumHomePage(WebDriver driver) { }
    @UI("#user-icon")
    public JS userIcon;
}
