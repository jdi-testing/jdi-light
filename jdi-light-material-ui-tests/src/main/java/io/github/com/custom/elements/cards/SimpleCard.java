package io.github.com.custom.elements.cards;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents Simple Card MUI component on GUI.
 * <p>Although cards can support multiple actions, UI controls, and an overflow menu,
 * use restraint and remember that cards are entry points to more complex and detailed information.</p>
 *
 * @see Card
 * @see <a href="https://v4.mui.com/components/cards/#simple-card">Simple Card MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/card_surface">MUI test page</a>
 */
@SuppressWarnings("checkstyle:LineLength")
public class SimpleCard extends Card {

    @UI("p.MuiTypography-body2")
    protected Text primaryText;

    /**
     * Gets primary body text of this Simple Card.
     *
     * @return primary body text of this Simple Card as {@link Text}
     */
    @JDIAction("Get primary text of '{name}'")
    public Text primaryText() {
        return primaryText;
    }

    /**
     * Gets title element of this Simple Card.
     *
     * @return title element of this Simple Card as {@link UIElement}
     */
    @JDIAction("Get title of '{name}'")
    @Override
    public UIElement title() {
        return core().find(".MuiTypography-h5");
    }

    /**
     * Gets 'Learn More' button of this Simple Card.
     *
     * @return 'Learn More' button of this Simple Card as {@link Button}
     */
    @JDIAction("Get 'Learn More' button of '{name}'")
    public Button learnMoreButton() {
        return new Button().setCore(Button.class, actions().find("button"));
    }
}
