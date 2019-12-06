package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;


/**
 * To see an example of Toast in bootstrap please visit https://getbootstrap.com/docs/4.3/components/toasts/#examples
 */

public abstract class Toast extends Section {

    @UI(".toast-header .mr-auto")
    public Text title;

    @UI(".toast-body")
    public Text message;

    public String getTitle() {
        return title.getText();
    }

    public String getMessage() {
        return message.getText();
    }

    public void close() {
        linked(".toast-header button", "Close").click();
    }

}