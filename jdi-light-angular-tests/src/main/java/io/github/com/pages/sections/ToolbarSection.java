package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class ToolbarSection extends Section {

    @UI("#toolbar-basic")
    public static TextArea toolbarTextArea;

}
