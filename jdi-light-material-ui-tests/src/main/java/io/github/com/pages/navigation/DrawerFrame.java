package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIDrawer;
import com.epam.jdi.light.material.elements.navigation.Drawer;

public class DrawerFrame extends Section {

    @JDIDrawer(root = "#root")
    public Drawer drawer;
}
