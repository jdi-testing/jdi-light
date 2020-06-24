package io.github.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = "div[class='BorderGrid-cell']>p[class*='f4']")
    public WebElement repoDescription;
    // @Css(".repository-meta-content")
    // public UIElement repoDescription;
}
