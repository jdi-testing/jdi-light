package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ComplexInteractionCard extends Card {

    @UI("#complexInteraction p.MuiTypography-root")
    protected Text textUnderImage;

    public Text textUnderImage() {
        return textUnderImage;
    }

    public Button addToFavoritesButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='add to favorites']"));
    }

    public Button shareButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='share']"));
    }

    public Button expandButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='show more']"));
    }
}
