package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIDivider;
import com.epam.jdi.light.material.elements.displaydata.Divider;

public class VerticalDividerFrame extends Section {

    @JDIDivider(root = "#root", divider = ".MuiDivider-vertical")
    public Divider divider;

}
