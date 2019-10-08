package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class NavbarForm extends Form  implements PageObject {

    @UI("//button[text()='Left']") public Button leftButton;
    @UI("//button[text()='Middle']") public Button middleButton;
    @UI("//button[text()='Right']") public Button rightButton;

}
