package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.annotations.JDIChip;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;


/**
 * To see an example of Chip web element please visit
 * https://mui.com/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements ISetup, HasClick {

    protected By chipLabel;
    protected By chipIcon;
    protected By chipDelete;

    @JDIAction("Get chip {name} label")
    public UIElement getChipLabel() {
        return find(chipLabel);
    }

    @JDIAction("Get chip {name} icon")
    public UIElement getChipIcon() {
        return find(chipIcon);
    }

    @JDIAction("Click delete chip {name}")
    public void delete() {
        find(chipDelete).click();
    }

    public boolean isDeletable() {
        return hasClass("MuiChip-deletable");
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIChip.class, Chip.class))
            return;
        JDIChip j = field.getAnnotation(JDIChip.class);
        core().setLocator(NAME_TO_LOCATOR.execute(j.root()));
        chipLabel = NAME_TO_LOCATOR.execute(j.label());
        chipIcon = NAME_TO_LOCATOR.execute(j.icon());
        chipDelete = NAME_TO_LOCATOR.execute(j.delete());
    }
}
