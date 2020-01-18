package io.github.com.sections.toast;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.AbstractToast;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Toast extends AbstractToast {
    @UI(".toast-header") public Label header;
    @UI(".mr-auto") public Text headerText;
    @UI(".toast-body") public Text body;
    @UI(".close") public Button closeButton;
}
