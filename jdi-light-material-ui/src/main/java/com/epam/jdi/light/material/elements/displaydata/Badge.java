package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.material.interfaces.HasPosition;

/**
 * Represents badge MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/badges/">Badge MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Badge extends UIBaseElement<BadgeAssert> implements IsText, HasPosition, HasIcon {

    public static final String MUI_BADGE_DOT_LOCATOR = ".MuiBadge-dot";
    // @todo #5336 Create a basi class for badge (content or dot) to check style and content
    @JDIAction("Get '{name}'s  dot element")
    public UIElement dot() {
        return core().findFirst(MUI_BADGE_DOT_LOCATOR);
    }
    @JDIAction("Get '{name}'s  content element")
    public UIElement content() {
        return core().findFirst(".MuiBadge-badge");
    }

    @JDIAction("Get '{name}'s  content element")
    public <T extends UIElement> T content(Class<T> clazz) {
        return this.content().with(clazz);
    }
    /**
     * Checks if the badge is a dot type or not.
     *
     * @return {@code true} if this badge is a dot, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has a dot")
    public boolean hasDot() {
        return !core().finds(MUI_BADGE_DOT_LOCATOR).isEmpty();
    }

    @Override
    @JDIAction("Check that '{name}' is visible")
    public boolean isVisible() {
        return !isNotVisible();
    }

    @Override
    @JDIAction("Check that '{name}' is invisible")
    public boolean isNotVisible() {
        return content().hasClass("MuiBadge-invisible");
    }

    /**
     * Returns the position of the badge on the main element.
     *
     * @return position of this badge as {@link Position}
     */
    @Override
    @JDIAction("Get '{name}' position")
    public Position position() {
        return Position.fromClasses(content().classes(), "MuiBadge-anchorOrigin", "Rectangle");
    }
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(".MuiAvatar-root"));
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }
}
