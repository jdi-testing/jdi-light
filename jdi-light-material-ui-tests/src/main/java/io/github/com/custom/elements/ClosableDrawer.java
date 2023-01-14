package io.github.com.custom.elements;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.navigation.Drawer;

public class ClosableDrawer extends Drawer {

    @Override
    public void close() {
        UIElement closeBtn = core().find(".//button");
        if (closeBtn.isExist()) {
            closeBtn.click();
        } else {
            super.close();
        }
    }
}
