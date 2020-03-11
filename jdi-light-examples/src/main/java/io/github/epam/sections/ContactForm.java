package io.github.epam.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindByUI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class ContactForm extends Form<User> {
	@FindByUI(id = "name") public WebElement name;
	@FindByUI(id = "passport") public WebElement passport;
	@FindByUI(id = "last-name") public WebElement lastName;
	@FindByUI(id = "position") public WebElement position;
	@FindByUI(id = "passport-number") public WebElement passportNumber;
	@FindByUI(id = "passport-seria") public WebElement passportSeria;

	@FindByUI(id = "gender") public Selector gender;
	@Css("div[ui=combobox] input") public WebElement religion;

	@FindByUI(id = "accept-conditions") public WebElement acceptConditions;
	@FindByUI(css = "textarea") public WebElement description;

	@FindByUI(xpath = ".//button[@type='submit']") public WebElement submit;
}