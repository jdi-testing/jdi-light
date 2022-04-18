package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.material.annotations.JMUITableFooter;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableFooterAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableFooter extends UIBaseElement<MUITableFooterAssert> implements HasAssert<MUITableFooterAssert> {

    private final JMUITableFooter tableFooter;
    private Dropdown rowsPerPageDropdown;
    private Button firstPageButton;
    private Button previousPageButton;
    private Button nextPageButton;
    private Button lastPageButton;

    public MUITableFooter(JMUITableFooter tableFooter) {
        this.tableFooter = tableFooter;
        base().setLocator(tableFooter.root());
    }

    public int selectedRows() {
        Text text = new Text().setCore(Text.class, core().find(tableFooter.selectedRowsInfo()));
        if (text.isExist()) {
            String value = text.getValue();
            return Integer.parseInt(value.substring(0, value.indexOf(" ")));
        } else {
            return 0;
        }
    }

    public Dropdown rowsPerPageDropdown() {
//        if (rowsPerPageDropdown == null) {
//            rowsPerPageDropdown = new Dropdown().setCore(Dropdown.class, core().find(tableFooter.rowsPerPageDropdown()));
//        }
        //html Dropdown seems not working properly by using class field
        return new Dropdown().setCore(Dropdown.class, core().find(tableFooter.rowsPerPageDropdown()));
    }

    public int currentMinRowIndex() {
        return Integer.parseInt(paginationInfo().substring(0, paginationInfo().indexOf("-")));
    }

    public int currentMaxRowIndex() {
        return Integer.parseInt(paginationInfo().substring(paginationInfo().indexOf("-") + 1, paginationInfo().indexOf(" ")));
    }

    public int maxRowAmount() {
        return Integer.parseInt(paginationInfo().substring(paginationInfo().lastIndexOf(" ") + 1));
    }

    public Button firstPageButton() {
//        if (firstPageButton == null) {
//            firstPageButton = new Button().setCore(Button.class, core().find(tableFooter.firstPageButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(tableFooter.firstPageButton()));
    }

    public Button previousPageButton() {
//        if (previousPageButton == null) {
//            previousPageButton = new Button().setCore(Button.class, core().find(tableFooter.previousPageButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(tableFooter.previousPageButton()));
    }

    public Button nextPageButton() {
//        if (nextPageButton == null) {
//            nextPageButton = new Button().setCore(Button.class, core().find(tableFooter.nextPageButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(tableFooter.nextPageButton()));
    }

    public Button lastPageButton() {
//        if (lastPageButton == null) {
//            lastPageButton = new Button().setCore(Button.class, core().find(tableFooter.lastPageButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(tableFooter.lastPageButton()));
    }

    private String paginationInfo() {
        return core().find(tableFooter.paginationInfo()).text();
    }

    @Override
    public MUITableFooterAssert is() {
        return new MUITableFooterAssert().set(this);
    }

}
