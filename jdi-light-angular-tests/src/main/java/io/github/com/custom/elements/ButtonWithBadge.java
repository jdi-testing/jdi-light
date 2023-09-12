package io.github.com.custom.elements;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.interfaces.HasBadge;
import io.github.com.custom.asserts.ButtonWithBadgeAssert;

public class ButtonWithBadge extends Button implements HasBadge {
    @Override
    public ButtonWithBadgeAssert is() {
        return (ButtonWithBadgeAssert) new ButtonWithBadgeAssert().set(this);
    }

    @Override
    public ButtonWithBadgeAssert has() {
        return (ButtonWithBadgeAssert) new ButtonWithBadgeAssert().set(this);
    }
}
