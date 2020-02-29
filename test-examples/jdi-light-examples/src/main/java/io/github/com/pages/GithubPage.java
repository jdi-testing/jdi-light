package io.github.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = "[itemprop=about]")
    public static WebElement repoDescription;
    // @Css(".repository-meta-content")
    // public static UIElement repoDescription;
}
