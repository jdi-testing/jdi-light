package io.github.com.custom.elements;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CustomStepContent extends UIElement {
    private static final String LABEL_LOCATOR = ".//p" ;
    private static final String BACK_LOCATOR = ".//button[1]" ;
    private static final String NEXT_LOCATOR = ".//button[2]" ;

    public CustomStepContent(UIElement root) {
        setCore(CustomStepContent.class, root.base());
    }

    public String stepLabel() {
        return find(LABEL_LOCATOR).text();
    }

    public MUIButton nextStep() {
        return new MUIButton().setCore(MUIButton.class, find(NEXT_LOCATOR));
    }
    public void goToNextStep() {
        this.nextStep().click();
    }

    public MUIButton backStep() {
        return new MUIButton().setCore(MUIButton.class, find(BACK_LOCATOR));
    }
    public void goToBackStep() {
        this.backStep().click();
    }
}
