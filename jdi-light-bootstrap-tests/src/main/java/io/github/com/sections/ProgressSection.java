package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;

public class ProgressSection extends Section {
    //@FindBy(css = ".progress-bar")
    @UI(".progress-bar")
    public Progress progress;
}
