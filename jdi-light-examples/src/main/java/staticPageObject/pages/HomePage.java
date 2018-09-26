package staticPageObject.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import com.epam.jdi.light.ui.html.common.Text;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public static WebElement mainTitle;
	@Css(".main-txt") public static Text jdiText;
	@ByText("JDI Github") public static WebElement githubLink;
}