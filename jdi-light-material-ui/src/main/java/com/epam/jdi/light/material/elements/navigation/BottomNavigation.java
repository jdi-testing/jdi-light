package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;

/**
 * To see an example of Bottom Navigation web element please visit
 * https://mui.com/components/bottom-navigation/
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
