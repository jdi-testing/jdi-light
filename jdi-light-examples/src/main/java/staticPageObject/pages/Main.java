package staticPageObject.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.WebElement;
import staticPageObject.sections.ContactForm;

public class Main {
	@Css("form#contact-form") public ContactForm contactForm;
	@XPath(".//button[@type='submit']") public WebElement calculate;

}