package io.github.com.custom.elements;

import com.epam.jdi.light.angular.elements.interfaces.HasBadge;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.custom.asserts.UIElementWithBadgeAssert;

public class UIElementWithBadge extends UIElement implements HasBadge {
    @Override
    public UIElementWithBadgeAssert is() {
        return (UIElementWithBadgeAssert) new UIElementWithBadgeAssert().set(this);
    }

    @Override
    public UIElementWithBadgeAssert has() {
        return (UIElementWithBadgeAssert) new UIElementWithBadgeAssert().set(this);
    }
}
