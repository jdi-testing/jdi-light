package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.SelectMenu;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class FormAutoSizingWithCustomControls extends Section {
    @UI("#formAutoSizing-customCheckbox")
    public Checkbox checkboxContainer;
    @UI("#customControlAutosizing")
    public Checkbox checkbox;
    @UI("//div[@id='formAutoSizing-customCheckbox']/..")
    public Text colParameterCheckbox;
    @UI("#inlineFormCustomSelect")
    public SelectMenu selectMenu;
    @UI("//select[@id='inlineFormCustomSelect']/..")
    public Text colParameterSelectMenu;
    @UI("button")
    public Button submit;
    @UI("//button/..")
    public Button colParameterButton;

}
