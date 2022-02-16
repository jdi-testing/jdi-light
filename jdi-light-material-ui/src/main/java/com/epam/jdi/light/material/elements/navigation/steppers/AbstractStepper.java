package com.epam.jdi.light.material.elements.navigation.steppers;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.lang.reflect.Field;

public abstract class AbstractStepper<A extends UIAssert<?, ?>>
    extends UIBaseElement<A>
    implements ISetup {

    protected String root;
    protected String backButton = "//*[contains(text(), 'Back')]";
    protected String nextButton = "//*[contains(text(), 'Next')]";
    protected String finishButton = "//*[contains(text(), 'Finish')]";

    @JDIAction("Click {name}'s 'Back' button")
    public void back() {
        backButton().click();
    }

    @JDIAction("Get {name}'s 'Back' button")
    public Button backButton() {
        return new Button().setCore(Button.class, find(backButton));
    }

    @JDIAction("Click {name}'s 'Next' button")
    public void next() {
        nextButton().click();
    }

    @JDIAction("Get {name}'s 'Next' button")
    public Button nextButton() {
        return new Button().setCore(Button.class, find(nextButton));
    }

    @JDIAction("Click {name}'s 'Finish' button")
    public void finish() {
        finishButton().click();
    }

    @JDIAction("Get {name}'s 'Finish' button")
    public Button finishButton() {
        return new Button().setCore(Button.class, find(finishButton));
    }

    @Override
    public A is() {
        return (A) new UIAssert<>().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JStepper.class, AbstractStepper.class)) {
            return;
        }
        JStepper j = field.getAnnotation(JStepper.class);
        root = j.root();
        backButton = j.backButton();
        nextButton = j.nextButton();
        finishButton = j.finishButton();
        base().setLocator(NAME_TO_LOCATOR.execute(root));
    }
}
