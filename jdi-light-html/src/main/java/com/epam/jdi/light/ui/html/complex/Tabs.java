package com.epam.jdi.light.ui.html.complex;

import java.util.List;

public interface Tabs extends Menu {
    // TODO
    default List<String> allTabs() { return allOptions(); }

}
