package io.github.com.pages;

import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = "div[class='BorderGrid-cell']>p[class*='f4']")
    public static Text repoDescription;
    // @Css(".repository-meta-content")
    // public static UIElement repoDescription;
}
