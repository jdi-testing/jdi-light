package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.sections.ContactForm;

@Url("/contacts.html") @Title("Contact Form")
public class ContactFormPage extends WebPage {
	@Css("form#contact-form") public static ContactForm contactForm;
}