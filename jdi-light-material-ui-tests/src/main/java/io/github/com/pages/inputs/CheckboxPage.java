package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.annotations.JDICheckbox;
import com.epam.jdi.light.material.elements.inputs.Checkbox;

public class CheckboxPage extends WebPage {

    @JDICheckbox(
            basicCheckbox = "//h2[text()='Basic checkboxes']/following-sibling::div[1]/span",
            formControlLabelCheckbox = "//h2[text()='Checkbox with FormControlLabel']/following-sibling::div[1]/label/span[1]",
            formGroupCheckbox = "//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/div/label/span[1]",
            labelPlacement = "//h2[text()='Label placement']/following-sibling::fieldset/div/label/span[1]",
            formControlLabelText = "//h2[text()='Checkbox with FormControlLabel']/following-sibling::div[1]/label/span[2]",
            formGroupText = "//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/div/label/span[2]",
            labelPlacementText = "//h2[text()='Label placement']/following-sibling::fieldset/div/label/span[2]",
            errorMessageText = "//h2[text()='Checkboxes with FormGroup']/following-sibling::div[1]/fieldset/legend"
    )
    public Checkbox checkbox;
}
