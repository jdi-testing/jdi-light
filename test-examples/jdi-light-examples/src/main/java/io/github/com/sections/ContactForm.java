package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class ContactForm extends Form<User> {
	WebElement firstName;
	WebElement lastName
	WebElement position;
	WebElement passportNumber;
	WebElement passportSeria;
	WebElement passport;
	WebElement acceptConditions;
	WebElement description;

	Selector gender;
	Selector religion;
	Selector weather;

	@UI("['Submit']") public WebElement submit;

}
