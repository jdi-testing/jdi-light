package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;


public class CheckboxPage extends WebPage {

    @UI("//h2[text()='Basic checkboxes']/following-sibling::div/span[contains(@class,'MuiCheckbox-root')]")
    public List<Checkbox> basicCheckbox;

    @UI("//h2[text()='Checkboxes with FormGroup']/preceding::div/label/span[contains(@class,'MuiCheckbox-root')]")
    public List<Checkbox> formControlLabelCheckbox;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div//span[contains(@class,'MuiCheckbox-root')]")
    public List<Checkbox> formGroupCheckbox;

    @UI("//h2[text()='Label placement']/following::span[contains(@class,'MuiCheckbox-root')]")
    public List<Checkbox> labelPlacementCheckbox;

    @UI("//h2[text()='Checkboxes with FormGroup']/preceding::div/label/span[contains(@class,'MuiFormControlLabel-label')]")
    public List<Text> formControlLabelText;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div//span[contains(@class,'MuiFormControlLabel-label')]")
    public List<Text> formGroupText;

    @UI("//h2[text()='Label placement']/following::div//span[contains(@class,'MuiFormControlLabel-label')]")
    public List<Text> labelPlacementText;

    @UI("//h2[text()='Checkboxes with FormGroup']/following-sibling::div//legend")
    public List<Text> errorMessage;
}
