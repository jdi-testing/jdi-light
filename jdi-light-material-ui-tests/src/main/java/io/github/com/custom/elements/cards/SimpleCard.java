package io.github.com.custom.elements.cards;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SimpleCard extends Card {

    @UI("p.MuiTypography-body2")
    protected Text primaryText;

    public Text primaryText() {
        return primaryText;
    }

    @Override
    public UIElement title() {
        return core().find(".MuiTypography-h5");
    }

    public Button learnMoreButton() {
        return new Button().setCore(Button.class, actions().find("button"));
    }
}
