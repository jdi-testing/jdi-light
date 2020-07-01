package io.github.com.pages;

import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.support.FindBy;

public class GithubPage {
    @FindBy(css = ".BorderGrid-cell p.f4")
    public static Text repoDescription;
    // @Css(".repository-meta-content")
    // public static UIElement repoDescription;
}
