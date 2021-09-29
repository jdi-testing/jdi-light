package io.github.com.custom.footers;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.elements.composite.Footer;

import java.util.List;

public class IndigoFooter extends Footer {

    @UI("button")
    protected List<Button> socialButtons;

    @UI(".pt-0")
    protected Text descriptionText;

    @UI("hr")
    protected Divider divider;

    @UI("//div[contains(@class, 'v-card__text') and ./strong]")
    protected Text footerText;

    public List<Button> socialButtons() {
        return socialButtons;
    }

    public Text descriptionText() {
        return descriptionText;
    }

    public Divider divider() {
        return divider;
    }

    public Text footerText() {
        return footerText;
    }

}
