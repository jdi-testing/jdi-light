package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;
import com.epam.jdi.light.material.interfaces.base.HasImage;
import com.epam.jdi.light.material.interfaces.displaydata.HasBadge;

/**
 * Represents avatar MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/avatars/">Avatar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Avatar extends UIBaseElement<AvatarAssert> implements HasImage, HasBadge, HasClick, IsText {

    /**
     * Gets the avatar's icon.
     *
     * @return avatar's icon as {@link Icon}
     */
    @JDIAction("Get avatar '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(".MuiSvgIcon-root"));
    }

    @Override
    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }
}
