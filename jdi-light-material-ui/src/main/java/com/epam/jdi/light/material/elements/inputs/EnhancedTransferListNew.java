package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITransferListNew;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Exchanges "move all" buttons for "select all / select none" checkboxes, and adds list item counters.
 *
 * To see an example of Enhanced Transfer List web element please visit
 * https://mui.com/components/transfer-list/#enhanced-transfer-list
 */

public class EnhancedTransferListNew extends TransferListNew implements ISetup {
    protected String leftSelectAllCheckboxLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiCardHeader-avatar ')]/*)[1]";
    protected String rightSelectAllCheckboxLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiCardHeader-avatar ')]/*)[2]";
    protected String leftListHeaderLocator = "(//*[contains(concat(' ', @class, ' '), ' MuiCardHeader-title ')])[1]";
    protected String rightListHeaderLocator = "(//*[contains(concat(' ', @class, ' '), ' MuiCardHeader-title ')])[2]";
    protected String leftListSubheaderLocator = "(//*[contains(concat(' ', @class, ' '), ' MuiCardHeader-subheader ')])[1]";
    protected String rightListSubheaderLocator = "(//*[contains(concat(' ', @class, ' '), ' MuiCardHeader-subheader ')])[2]";

    @JDIAction("Returns 'select all/none' checkbox for '{name}' left list")
    public Checkbox leftSelectAllCheckbox() {
        return new Checkbox().setCore(Checkbox.class, find(leftSelectAllCheckboxLocator));
    }

    @JDIAction("Returns 'select all/none' checkbox for '{name}' right list")
    public Checkbox rightSelectAllCheckbox() {
        return new Checkbox().setCore(Checkbox.class, find(rightSelectAllCheckboxLocator));
    }

    @JDIAction("Checks all '{name}' left list items via 'select all/none' checkbox")
    public void checkAllLeftItems() {
        leftSelectAllCheckbox().check();
    }

    @JDIAction("Unchecks all '{name}' left list items via 'select all/none' checkbox")
    public void uncheckAllLeftItems() {
        leftSelectAllCheckbox().uncheck();
    }

    @JDIAction("Checks all '{name}' right list items via 'select all/none' checkbox")
    public void checkAllRightItems() {
        rightSelectAllCheckbox().check();
    }

    @JDIAction("Unchecks all '{name}' right list items via 'select all/none' checkbox")
    public void uncheckAllRightItems() {
        rightSelectAllCheckbox().uncheck();
    }

    @JDIAction("Get '{name}' left list header text")
    public Text leftListHeader() {
        return new Text().setCore(Text.class, find(leftListHeaderLocator));
    }

    @JDIAction("Get '{name}' right list header text")
    public Text rightListHeader() {
        return new Text().setCore(Text.class, find(rightListHeaderLocator));
    }

    @JDIAction("Get '{name}' left list subheader text")
    public Text leftListSubheader() {
        return new Text().setCore(Text.class, find(leftListSubheaderLocator));
    }

    @JDIAction("Get '{name}' right list subheader text")
    public Text rightListSubheader() {
        return new Text().setCore(Text.class, find(rightListSubheaderLocator));
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransferListNew.class, List.class)) return;
        JDITransferListNew j = field.getAnnotation(JDITransferListNew.class);
        rootLocator = j.root();
        moveCheckedItemsRightButtonLocator = j.moveCheckedItemsRightButton();
        moveCheckedItemsLeftButtonLocator = j.moveCheckedItemsLeftButton();
        leftListLocator = j.leftList();
        rightListLocator = j.rightList();
        leftSelectAllCheckboxLocator = j.leftSelectAllCheckbox();
        rightSelectAllCheckboxLocator = j.rightSelectAllCheckbox();
        leftListHeaderLocator = j.leftListHeader();
        rightListHeaderLocator = j.rightListHeader();
        leftListSubheaderLocator = j.leftListSubheader();
        rightListSubheaderLocator = j.rightListSubheader();
    }
}
