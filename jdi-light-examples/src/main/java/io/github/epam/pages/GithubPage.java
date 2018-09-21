package io.github.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = "[itemprop=about]")
    public WebElement repoDescription;
    // @Css(".repository-meta-content")
    // public UIElement repoDescription;
}
