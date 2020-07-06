package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ToolbarSection extends Section {

    @UI("#toolbar-basic")
    public static Text toolbarTextArea;

    @UI("#toolbar-table")
    public static Table toolbarTable;

    @UI("#toolbar-table span:not(.example-spacer)")
    public static JList<Text> toolbarRowsElementsWithText;
}


