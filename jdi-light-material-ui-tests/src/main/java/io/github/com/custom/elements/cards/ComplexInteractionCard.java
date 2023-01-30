package io.github.com.custom.elements.cards;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.surfaces.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents Complex Interaction Card MUI component on GUI.
 * <p>On desktop, card content can expand. (Click the downward chevron to view the recipe.)</p>
 *
 * @see Card
 * @see <a href="https://v4.mui.com/components/cards/#complex-interaction">Complex Interaction Card MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/card_surface">MUI test page</a>
 */
public class ComplexInteractionCard extends Card {

    @UI("#complexInteraction p.MuiTypography-root")
    protected Text textUnderImage;

    /**
     * Gets text under image of this Complex Interaction Card.
     *
     * @return text under image of this Complex Interaction Card as {@link Text}
     */
    @JDIAction("Get text under image of '{name}'")
    public Text textUnderImage() {
        return textUnderImage;
    }

    /**
     * Gets 'add to favorites' button of this Complex Interaction Card.
     *
     * @return 'add to favorites' button of this Complex Interaction Card as {@link Button}
     */
    @JDIAction("Get 'add to favorites' button of '{name}'")
    public Button addToFavoritesButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='add to favorites']"));
    }

    /**
     * Gets 'add to favorites' icon of this Complex Interaction Card.
     *
     * @return 'add to favorites' icon of this Complex Interaction Card as {@link Icon}
     */
    @JDIAction("Get 'add to favorites' icon of '{name}'")
    public Icon addToFavoritesSvgIcon() {
        return new Icon().setCore(Icon.class, actions().find(".MuiSvgIcon-root"));
    }

    /**
     * Gets 'share' button of this Complex Interaction Card.
     *
     * @return 'share' button of this Complex Interaction Card as {@link Button}
     */
    @JDIAction("Get 'share' button of '{name}'")
    public Button shareButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='share']"));
    }

    /**
     * Gets 'expand' button of this Complex Interaction Card.
     *
     * @return 'expand' button of this Complex Interaction Card as {@link Button}
     */
    @JDIAction("Get 'expand' button of '{name}'")
    public Button expandButton() {
        return new Button().setCore(Button.class, actions().find("[aria-label='show more']"));
    }
}
