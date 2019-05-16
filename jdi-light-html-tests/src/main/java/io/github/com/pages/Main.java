package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import io.github.com.custom.CustomContactForm;
import io.github.com.sections.ContactForm;

public class Main {
	@Css("form#contact-form") public ContactForm contactForm;
	@Css("form#contact-form") public CustomContactForm customContactForm;
	@XPath(".//button[@type='submit']") public Button calculate;
}