package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.SelectMenu;

public class FormAutoSizingWithCustomControls extends Section {
    @UI("#inlineFormCustomSelect")
    public SelectMenu selectMenu;
    @UI("formAutoSizing-customCheckbox")
    public Checkbox checkboxContainer;
    @UI("#customControlAutosizing")
    public Checkbox checkbox;
    @UI("button")
    public Button submit;

}
