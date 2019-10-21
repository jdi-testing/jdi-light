package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;

public class FormAutoSizingWithCustomControls extends Section {
    @UI("#inlineFormCustomSelect")
    public Selector selector;
    @UI("#customCheck1-div")
    public Checkbox checkboxContainer; //ADD ID HERE IN HTML
    @UI("#customControlAutosizing")
    public Checkbox checkbox;
    @UI("button")
    public Button submit;
}
