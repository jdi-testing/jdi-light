package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.annotations.JMUITableHeader;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableHeaderAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableHeader extends UIBaseElement<MUITableHeaderAssert> implements HasAssert<MUITableHeaderAssert> {

    private final JMUITableHeader tableHeader;
    private Text headerText;
    private Button filterButton;

    public MUITableHeader(JMUITableHeader tableHeader) {
        this.tableHeader = tableHeader;
        base().setLocator(tableHeader.root());
    }

    public Text text() {
//        if (headerText == null) {
//            headerText = new Text().setCore(Text.class, core().find(tableHeader.text()));
//        }
        return new Text().setCore(Text.class, core().find(tableHeader.text()));
    }

    public int selectedRows() {
        if (text().isExist()) {
            String value = text().getValue();
            try {
                return Integer.parseInt(value.substring(0, value.indexOf(" ")));
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public Button button() {
//        if (filterButton == null) {
//            filterButton = new Button().setCore(Button.class, core().find(tableHeader.button()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(tableHeader.button()));
    }

    @Override
    public MUITableHeaderAssert is() {
        return new MUITableHeaderAssert().set(this);
    }

}
