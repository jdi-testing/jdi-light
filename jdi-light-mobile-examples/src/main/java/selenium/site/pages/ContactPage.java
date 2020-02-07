package selenium.site.pages;

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;
import selenium.site.sections.ContactForm;

@Url("/contacts") @Title("Contact Form")
public class ContactPage extends WebPage {
    public static ContactForm seleniumContactForm;
}
