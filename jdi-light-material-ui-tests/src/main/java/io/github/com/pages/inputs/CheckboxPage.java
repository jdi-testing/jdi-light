package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class CheckboxPage extends WebPage {

    @UI("//h2[text()='Basic checkboxes']/following-sibling::div/span[contains(@class,'MuiCheckbox-root')]")
    public static List<Checkbox> basicCheckboxes;

    @UI("//h2[text()='Checkboxes with FormGroup']/preceding::div/label/span[contains(@class,'MuiCheckbox-root')]")
    public static List<Checkbox> formControlLabelCheckboxes;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div//fieldset[1]//span[contains(@class,'MuiCheckbox-root')]")
    public static List<Checkbox> mirrorFormGroupCheckboxes;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div//fieldset[2]//span[contains(@class,'MuiCheckbox-root')]")
    public static List<Checkbox> formGroupCheckboxes;

    @UI("//h2[text()='Label placement']/following::span[contains(@class,'MuiCheckbox-root')]")
    public static List<Checkbox> labelPlacementCheckboxes;

    @UI("//legend[contains(text(), 'Assign')]")
    public static Text assignResponsibilityText;

    @UI("//legend[contains(text(), 'Pick')]")
    public static Text pickTwoText;

    @UI("//p[contains(text(), 'display')]")
    public static Text displayErrorText;
}
