package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.mobile.ui.html.elements.common.Button;
import io.github.com.sections.ContactForm;

public class Main {
	@UI("form#contact-form")
	public ContactForm contactForm;
	@XPath(".//button[@type='submit']")
	public Button calculate;
}