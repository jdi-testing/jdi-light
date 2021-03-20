package org.jdiai.site;

import org.jdiai.JS;
import org.jdiai.WebPage;
import org.jdiai.annotations.UI;

public class ContactPage extends WebPage {
    @UI(".lname-res")
    public JS lastNameInLog;
    @UI(".descr-res")
    public JS descriptionInLog;
    public JS contactForm;

}
