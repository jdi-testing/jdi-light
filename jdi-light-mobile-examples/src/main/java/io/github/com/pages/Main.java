package io.github.com.pages;

import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.XPath;
import io.github.com.sections.ContactForm;
import org.openqa.selenium.WebElement;

public class Main {
	@Css("form#contact-form") public ContactForm contactForm;
	@XPath(".//button[@type='submit']") public WebElement calculate;

}