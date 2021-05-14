package com.jditest.site;

import com.jditest.JS;
import com.jditest.WebPage;
import com.jditest.annotations.UI;

public class ContactPage extends WebPage {
    @UI(".lname-res")
    public JS lastNameInLog;
    @UI(".descr-res")
    public JS descriptionInLog;
    public JS contactForm;

    @UI("#contact-form")
    public ContactForm contacts;

}
