package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;

public class Badge extends UIBaseElement<BadgeAssert> {

    private static final String BADGE_CONTENT_CLASS = ".MuiBadge-badge";
    private static final String BADGE_DOT_CLASS = "MuiBadge-dot";
    private static final String BADGE_INVISIBLE_CLASS = "MuiBadge-invisible";
    private static final String BADGE_ALIGNMENT_PATTERN = "MuiBadge-anchorOrigin%sRectangle";

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @Override
    public BadgeAssert has() {
        return this.is();
    }

    @JDIAction("Get content of '{name}'")
    public String getBadgeContent() {
        return core().find(BADGE_CONTENT_CLASS).getText();
    }

    @JDIAction("Is '{name}' invisible")
    public boolean isInvisible() {
        return core().find(BADGE_CONTENT_CLASS).hasClass(BADGE_INVISIBLE_CLASS);
    }

    @JDIAction("Is '{name}' dot")
    public boolean isDot() {
        return core().find(BADGE_CONTENT_CLASS).hasClass(BADGE_DOT_CLASS);
    }

    @JDIAction("Is '{name}' has '{0}' alignment")
    public boolean hasAlignment(String alignment) {
        return core().find(BADGE_CONTENT_CLASS).hasClass(String.format(BADGE_ALIGNMENT_PATTERN, alignment.replaceAll("\\s+", "")));
    }

}
