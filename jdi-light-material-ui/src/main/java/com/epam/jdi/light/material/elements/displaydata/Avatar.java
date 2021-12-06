package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;
import com.epam.jdi.light.material.interfaces.base.HasImage;
import com.epam.jdi.light.material.interfaces.displaydata.HasBadge;

/**
 * To see an example of Avatar web element please visit
 * https://mui.com/components/avatars/
 */

public class Avatar extends UIBaseElement<AvatarAssert> implements HasImage, HasBadge, HasClick, IsText {

    @JDIAction("Get avatar '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(".MuiSvgIcon-root"));
    }

    @Override
    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }

    @Override
    public AvatarAssert has() {
        return this.is();
    }
}
