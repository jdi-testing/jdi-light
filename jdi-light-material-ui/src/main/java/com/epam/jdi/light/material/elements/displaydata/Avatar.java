package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;

public class Avatar extends UIBaseElement<AvatarAssert>  {

    @JDIAction("Get avatar {name} photo")
    public boolean hasPhoto() {
        return core().firstChild().firstChild().hasAttribute("src");
    }

    @JDIAction("Get avatar {name} badge")
    public boolean hasBadge() {
        return core().children().get(3).hasClass("MuiBadge-badge");
    }

    @JDIAction("Get avatar {name} icon")
    public boolean hasIcon() {
        return core().firstChild().hasClass("MuiSvgIcon-root");
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
