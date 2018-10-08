package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import io.github.com.sections.ContactForm;

public class Main {
	@Css("form#contact-form") public ContactForm contactForm;
	@XPath(".//button[@type='submit']") public Button calculate;

}