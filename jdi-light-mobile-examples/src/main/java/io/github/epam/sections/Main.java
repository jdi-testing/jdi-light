package io.github.epam.sections;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.XPath;
import org.openqa.selenium.WebElement;

public class Main extends Section {
	@Css("form#contact-form") public ContactForm contactForm;
	@XPath(".//button[@type='submit']") public WebElement calculate;

}