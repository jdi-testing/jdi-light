package io.github.com.custom.elements.cards;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.surfaces.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ComplexInteractionCard extends Card {

    @UI("#complexInteraction p.MuiTypography-root")
    protected Text textUnderImage;

    @JDIAction("Get '{name}'s text under image")
    public Text textUnderImage() {
        return textUnderImage;
    }

    @JDIAction("Get '{name}'s 'add to favorites' button")
    public Button addToFavoritesButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='add to favorites']"));
    }

    @JDIAction("Get '{name}'s 'add to favorites' icon")
    public Icon addToFavoritesSvgIcon() {
        return new Icon().setCore(Icon.class, actions().find(".MuiSvgIcon-root"));
    }

    @JDIAction("Get '{name}'s 'share' button")
    public Button shareButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='share']"));
    }

    @JDIAction("Get '{name}'s 'expand' button")
    public Button expandButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='show more']"));
    }
}
