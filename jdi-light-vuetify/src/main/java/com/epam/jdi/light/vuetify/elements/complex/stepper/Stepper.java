package com.epam.jdi.light.vuetify.elements.complex.stepper;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class Stepper extends UIBaseElement<TextAssert> {

    @UI(".v-stepper__step")
    private List<Step> step;

    public Step getStep(int index) {
        return step.get(index);
    }

    public List<Step> getStepsList() {
        return step;
    }

    public WebList getContentList() {
        return $$(".v-stepper__content", core());
    }

}