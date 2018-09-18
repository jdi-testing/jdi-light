package staticPageObject.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

public class HomePageFrame {
	@Css("img#user-icon") public WebElement userIcon;
}