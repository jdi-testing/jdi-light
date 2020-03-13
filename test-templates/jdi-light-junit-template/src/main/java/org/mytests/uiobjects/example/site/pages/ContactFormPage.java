package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.sections.ContactForm;

@Url("/contacts.html") @Title("Contact Form")
public class ContactFormPage extends WebPage {
	@Css("form#contact-form") public static ContactForm contactForm;
}