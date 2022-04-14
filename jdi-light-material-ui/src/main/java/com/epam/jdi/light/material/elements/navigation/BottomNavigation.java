package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;

/**
 * Represent bottom navigation MUI component on GUI. Bottom navigation bars allow movement between
 * primary destinations in an app. Bottom navigation bars display three to five destinations
 * at the bottom of a screen. Each destination is represented by an icon and an optional text label.
 * When a bottom navigation icon is tapped, the user is taken to the top-level navigation destination
 * associated with that icon.
 *
 * @see <a href="https://mui.com/components/bottom-navigation/">Bottom navigation MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class BottomNavigation extends UIListBase<UISelectAssert<?, ?>> {

    @Override
    public boolean selected(int index) {
        return list().get(index).hasClass("Mui-selected");
    }

    @Override
    public UISelectAssert<?, ?> is() {
        return (UISelectAssert<?, ?>) new UISelectAssert().set(this);
    }
}
