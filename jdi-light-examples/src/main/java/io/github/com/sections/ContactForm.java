package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class ContactForm extends Form<User> {
	WebElement name, lastName, position, passportNumber, passportSeria, passport,
			acceptConditions, description;

	Selector gender, religion, weather;

	@UI("['Submit']") public WebElement submit;

}