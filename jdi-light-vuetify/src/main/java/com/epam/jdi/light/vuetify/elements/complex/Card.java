package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.asserts.CardAssert;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * To see an example of Card web element please visit https://vuetifyjs.com/en/components/cards
 * <p>
 * There are 4 basic components, v-card-title, v-card-subtitle, v-card-text and v-card-actions
 * accordingly to documentation.
 * <p>
 * If your component has a different locator, override the method in a descendant class.
 */
public class Card extends UIBaseElement<CardAssert> implements HasRounded, IsOutlined, IsShaped, IsTile, IsLoading,
        HasElevation, HasMeasurement, HasColor, HasTheme, IsFlat, HasClick {

    @UI(".v-progress-linear")
    protected ProgressLinear progressBar;

    public Card() {
        super();
    }
    public Card(UIElement element) {
        setCore(Card.class, element.base());
    }

    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(".v-card__title"));
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement subtitle() {
        return core().find(".v-card__subtitle");
    }

    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return core().find(".v-card__text");
    }

    @JDIAction("Get '{name}' actions")
    public ButtonGroup actions() {
        return core().find(".v-card__actions").with(ButtonGroup.class);
    }

    @JDIAction("Get '{name}' reverse")
    public Card revealCard() {
        return core().find(".v-card--reveal").with(Card.class);
    }

    public ProgressLinear progressBar() {
        return progressBar;
    }

    @JDIAction("Scroll {name} to position '{0}'")
    public void scroll(int y) {
        if (scrollable(core())) {
            core().jsExecute("scroll(0," + y + ")");
        } else {
            if (scrollable(content())) {
                content().jsExecute("scroll(0," + y + ")");
            } else {
                throw new RuntimeException("Card is not scrollable");
            }
        }
    }

    protected boolean scrollable(UIElement uiElement) {
        return uiElement.jsExecute("scrollHeight > arguments[0].offsetHeight").equals("true");
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return hasClass("v-card--disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get '{name}' loader height")
    public int getLoaderHeight() {
        return Integer.parseInt(progressBar().css("height").replace("px", ""));
    }

    @JDIAction("Get if '{name}' is link")
    public boolean isLink() {
        return hasClass("v-card--link");
    }

    @JDIAction("Get '{name}' max-width")
    public int getMaxWidth() {
        return Integer.parseInt(css("max-width").replace("px", ""));
    }

    @JDIAction("Get '{name}' max-height")
    public int getMaxHeight() {
        return Integer.parseInt(css("max-height").replace("px", ""));
    }

    @JDIAction("Get if '{name}' is hover")
    public boolean isHover() {
        return hasClass("v-card--hover");
    }

    @JDIAction("Get if '{name}' is raised")
    public boolean isRaised() {
        return hasClass("v-card--raised");
    }

    @Override
    @JDIAction("Click on {name}")
    public void click() {
        core().click();
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
