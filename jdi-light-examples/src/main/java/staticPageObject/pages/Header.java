package staticPageObject.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.WebElement;
import staticPageObject.sections.LoginForm;

public class Header extends Section {
	@Css("form") public static LoginForm loginForm;
	@Css(".fa-sign-out") public static WebElement logout;
	@Css("img#epam_logo") public static WebElement epamLogo;
	@Css("img#user-icon") public static WebElement userIcon;
	@XPath(".//*[@ui='label']") public static WebElement piterChailovskii;
	@Css("input[type=text]") public static WebElement textField437465;

}