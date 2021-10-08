package io.github.com.custom.treeview;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CheckedNode extends Section {

    @UI(".v-treeview-node__label")
    public Text text;

    @UI(".v-treeview-node__checkbox")
    public Checkbox checkbox;

}
