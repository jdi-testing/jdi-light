package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;


public class CheckboxPage extends WebPage {

    @UI("//h2[text()='Basic checkboxes']/following-sibling::div[1]/span")
    public List<Checkbox> basicCheckbox;

    @UI("//h2[text()='Checkbox with FormControlLabel']/following-sibling::div[1]/label/span[1]")
    public List<Checkbox> formControlLabelCheckbox;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/div/label/span[1]")
    public List<Checkbox> formGroupCheckbox;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset/div/label/span[1]")
    public List<Checkbox> labelPlacementCheckbox;

    @UI("//h2[text()='Checkbox with FormControlLabel']/following-sibling::div[1]/label/span[2]")
    public List<Text> formControlLabelText;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/div/label/span[2]")
    public List<Text> formGroupText;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset/div/label/span[2]")
    public List<Text> labelPlacementText;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/legend")
    public List<Text> errorMessage;
}
