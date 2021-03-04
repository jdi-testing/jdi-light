package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDISelect;
import com.epam.jdi.light.material.elements.inputs.Select;

public class SelectFrame extends Section {

    @JDISelect(root = ".MuiSelect-root", items = "li.MuiListItem-button")
    public Select simpleSelect;

    @JDISelect(root = ".MuiSelect-root")
    public Select disabledSelect;

    @JDISelect(root = ".MuiSelect-root",
        items = "li.MuiListItem-button", itemByText = "//li[text() = '%s']")
    public Select multipleSelect;

}
