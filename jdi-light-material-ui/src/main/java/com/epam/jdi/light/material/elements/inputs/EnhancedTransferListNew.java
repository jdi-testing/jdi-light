package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITransferListNew;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferListNew;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Exchanges the "move all" buttons for a "select all / select none" checkbox, and adds a counter.
 *
 * To see an example of Enhanced Transfer List web element please visit
 * https://mui.com/components/transfer-list/#enhanced-transfer-list
 */

public class EnhancedTransferListNew extends TransferListNew implements ISetup {


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransferListNew.class, List.class)) return;
        JDITransferListNew j = field.getAnnotation(JDITransferListNew.class);
        rootLocator = j.root();
        moveCheckedItemsRightButtonLocator = j.moveCheckedItemsRightButton();
        moveCheckedItemsLeftButtonLocator = j.moveCheckedItemsLeftButton();
        leftListLocator = j.leftList();
        rightListLocator = j.rightList();
    }
}
