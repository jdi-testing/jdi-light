package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Paper;

public class PaperFrame extends Section {

    @UI(".MuiPaper-root")
    public Paper paper;
}
