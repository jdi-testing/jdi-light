package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIAppBar;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class AppBarFrame extends Section {

    @JDIAppBar(buttons = ".MuiButtonBase-root", barTitle = ".makeStyles-title-3")
    public AppBar appBar;
}
