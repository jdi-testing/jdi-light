package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;
@SuppressWarnings({"PMD.UnusedLocalVariable"})
public class ContactForm extends Form<User> {
	public WebElement name;
	public WebElement lastName;
	public WebElement position;
	public WebElement passportNumber;
	public WebElement passportSerial;
	public WebElement passport;
	public WebElement acceptConditions;
	public WebElement description;

	public Selector gender;
	public Selector religion;
	public Selector weather;

	@UI("['Submit']") public WebElement submit;

}