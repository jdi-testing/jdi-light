package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

/**
 * To see an example of Modal web element please visit https://getbootstrap.com/docs/4.3/components/modal/#examples
 */

public class Modal extends Section {

    @UI(".modal-header .modal-title")
    public Text title;

    public void close() {
        linked(".modal-header button", "Close").click();
    }

}
