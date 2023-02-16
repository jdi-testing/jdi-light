package io.github.com.custom.footers;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.composite.Footer;

import java.util.List;

public class TealFooter extends Footer {

    @UI("button")
    protected List<Button> socialButtons;

    @UI(".subheading")
    protected Text subheading;

    @UI(".text-center")
    protected Text footerText;

    public List<Button> socialButtons() {
        return socialButtons;
    }

    public Text subheading() {
        return subheading;
    }

    public Text footerText() {
        return footerText;
    }

}
