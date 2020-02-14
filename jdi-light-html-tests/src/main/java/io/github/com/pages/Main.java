package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.ContactFormCustom;
import io.github.com.custom.ContactFormCustomFill;
import io.github.com.custom.ContactFormCustomGet;
import io.github.com.sections.ContactForm;
import io.github.com.sections.ContactFormUI;

public class Main {
	@UI("form#contact-form") public ContactForm contactForm;
	@Css("form#contact-form") public ContactFormCustom contactFormCustom;
	@UI("form#contact-form") public ContactFormCustomFill contactFormCustomFill;
	@Css("form#contact-form") public ContactFormCustomGet contactFormCustomGet;
	@UI("form#contact-form") public ContactFormUI contactFormUI;
	@XPath(".//button[@type='submit']") public Button calculate;
}