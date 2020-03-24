package selenium.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import selenium.site.sections.ContactForm;

@Url("/contacts") @Title("Contact Form")
public class ContactPage extends WebPage {
    public static ContactForm seleniumContactForm;
}
