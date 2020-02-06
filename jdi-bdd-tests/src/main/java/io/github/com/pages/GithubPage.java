package io.github.com.pages;

import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = "[itemprop=about]")
    public static Text repoDescription;
    // @UI(".repository-meta-content")
    // public static UIElement repoDescription;
}
