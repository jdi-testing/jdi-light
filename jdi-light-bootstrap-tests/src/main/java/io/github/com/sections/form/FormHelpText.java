package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormHelpText extends Section {

    @UI("#inputPassword5")
    public TextField passwordOne;
    @UI("#inputPassword6")
    public TextField passwordTwo;
    @UI("//input[@id='inputPassword5']/../small")
    public Text passwordOneHelpText;
    @UI("//input[@id='inputPassword6']/../small")
    public Text passwordTwoHelpText;

}
