package io.github.com.custom;

import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JTooltip;
import com.epam.jdi.light.material.interfaces.displaydata.HasTooltip;
import com.epam.jdi.light.material.interfaces.HasPopper;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class TooltipButton extends Button implements HasTooltip, HasPopper, ISetup {

    private String tooltipLocator = ".MuiTooltip-popper";

    @Override
    public String tooltipLocator() {
        return this.tooltipLocator;
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JTooltip.class, TooltipButton.class)) {
            JTooltip annotation = field.getAnnotation(JTooltip.class);
            this.tooltipLocator = annotation.tooltip();
        }
    }
}
