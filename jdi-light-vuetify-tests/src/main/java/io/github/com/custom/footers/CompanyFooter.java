package io.github.com.custom.footers;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.composite.Footer;

import java.util.List;

public class CompanyFooter extends Footer {

    @UI(".primary")
    protected Text footerText;

    @UI("button")
    protected List<Button> navigationButtons;

    public Text footerText() {
        return footerText;
    }

    public List<Button> navigationButtons() {
        return navigationButtons;
    }

}
