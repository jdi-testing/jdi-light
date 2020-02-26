package io.github.epam.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class ContactForm extends Form<User> {
	@FindBy(id = "name") public WebElement name;
	@FindBy(id = "passport") public WebElement passport;
	@FindBy(id = "last-name") public WebElement lastName;
	@FindBy(id = "position") public WebElement position;
	@FindBy(id = "passport-number") public WebElement passportNumber;
	@FindBy(id = "passport-seria") public WebElement passportSeria;

	@FindBy(id = "gender") public Selector gender;
	@Css("div[ui=combobox] input") public WebElement religion;

	@FindBy(id = "accept-conditions") public WebElement acceptConditions;
	@FindBy(css = "textarea") public WebElement description;

	@FindBy(xpath = ".//button[@type='submit']") public WebElement submit;
}