package io.github.epam.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class ContactForm extends Form<User> {
	@Css("#passport") public WebElement passport;
	@Css("#name") public WebElement name;
	@Css("#last-name") public WebElement lastName;
	@Css("#position") public WebElement position;
	@Css("#passport-number") public WebElement passportNumber;
	@Css("#passport-seria") public WebElement passportSeria;

	@Css("#gender") public Selector gender;
	@Css("div[ui=combobox] input") public WebElement religion;

	@Css("#accept-conditions") public WebElement acceptConditions;
	@Css("textarea") public WebElement description;

	@XPath(".//button[@type='submit']") public WebElement submit;
}