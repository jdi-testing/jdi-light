package com.jditest.site;

import com.jditest.JS;
import com.jditest.Section;
import com.jditest.annotations.UI;

public class ContactForm extends Section {
    @UI("[type=submit]") public JS submitButton;
}
