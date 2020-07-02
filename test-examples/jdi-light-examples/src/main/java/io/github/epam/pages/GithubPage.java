package io.github.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = ".BorderGrid-cell p.f4")
    public WebElement repoDescription;
    // @Css(".repository-meta-content")
    // public UIElement repoDescription;
}
