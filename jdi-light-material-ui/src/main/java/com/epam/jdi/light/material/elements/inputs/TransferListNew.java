package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIList;
import com.epam.jdi.light.material.annotations.JDITransferListNew;
import com.epam.jdi.light.material.asserts.inputs.TransferListNewAssert;
import com.epam.jdi.light.material.elements.displaydata.List;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


public class TransferListNew extends UIBaseElement<TransferListNewAssert> implements ISetup {

    protected String rootLocator = ".MuiGrid-root";
    private String moveAllItemsRightButtonLocator = "button[aria-label='move all right']";
    private String moveAllItemsLeftButtonLocator = "button[aria-label='move all left']";
    protected String moveCheckedItemsRightButtonLocator = "button[aria-label='move selected right']";
    protected String moveCheckedItemsLeftButtonLocator = "button[aria-label='move selected left']";
    protected String leftListLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiList-root ')])[1]";
    protected String rightListLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiList-root ')])[2]";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransferListNew.class, List.class)) return;
        JDITransferListNew j = field.getAnnotation(JDITransferListNew.class);
        moveAllItemsRightButtonLocator = j.moveAllItemsRightButton();
        moveAllItemsLeftButtonLocator = j.moveAllItemsLeftButton();
        moveCheckedItemsRightButtonLocator = j.moveCheckedItemsRightButton();
        moveCheckedItemsLeftButtonLocator = j.moveCheckedItemsLeftButton();
        leftListLocator = j.leftList();
        rightListLocator = j.rightList();
    }

    @Override
    public TransferListNewAssert is() {
        return new TransferListNewAssert().set(this);
    }
}
