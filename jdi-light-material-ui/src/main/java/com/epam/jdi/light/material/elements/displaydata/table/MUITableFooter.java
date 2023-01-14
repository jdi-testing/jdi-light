package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.annotations.JMUITableFooter;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableFooterAssert;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableFooter extends UIBaseElement<MUITableFooterAssert> implements HasAssert<MUITableFooterAssert> {

    private String firstPageButtonLocator;
    private String previousPageButtonLocator;
    private String nextPageButtonLocator;
    private String lastPageButtonLocator;
    private String selectedRowsLocator;
    private String rowsPerPageDropdownLocator;
    private String paginationInfoLocator;

    public MUITableFooter(JMUITableFooter tableFooter) {
        this.selectedRowsLocator = tableFooter.selectedRowsInfo();
        this.rowsPerPageDropdownLocator = tableFooter.rowsPerPageDropdown();
        this.firstPageButtonLocator = tableFooter.firstPageButton();
        this.previousPageButtonLocator = tableFooter.previousPageButton();
        this.nextPageButtonLocator = tableFooter.nextPageButton();
        this.lastPageButtonLocator = tableFooter.previousPageButton();
        this.paginationInfoLocator = tableFooter.paginationInfo();
        base().setLocator(tableFooter.root());
    }

    @JDIAction("Get '{name}' selected rows")
    public int selectedRows() {
        Text text = new Text().setCore(Text.class, core().find(selectedRowsLocator));
        if (text.isExist()) {
            String value = text.getValue();
            return Integer.parseInt(value.substring(0, value.indexOf(" ")));
        } else {
            return 0;
        }
    }

    @JDIAction("Get '{name}' 'Rows per page' select")
    public Select rowsPerPageSelect() {
        return new Select(){
            @Override
            public void toggle() {
                base().getWebElement().click();
            }
        }.setCore(Select.class, core().find(rowsPerPageDropdownLocator));
    }

    @JDIAction("Get '{name}' current min row index")
    public int currentMinRowIndex() {
        return Integer.parseInt(paginationInfo().substring(0, paginationInfo().indexOf("-")));
    }

    @JDIAction("Get '{name}' current max row index")
    public int currentMaxRowIndex() {
        return Integer.parseInt(paginationInfo().substring(paginationInfo().indexOf("-") + 1, paginationInfo().indexOf(" ")));
    }

    @JDIAction("Get '{name}' max row amount")
    public int maxRowAmount() {
        return Integer.parseInt(paginationInfo().substring(paginationInfo().lastIndexOf(" ") + 1));
    }

    @JDIAction("Get '{name}' 'First page' button")
    public Button firstPageButton() {
        return new Button().setCore(Button.class, core().find(firstPageButtonLocator));
    }

    @JDIAction("Get '{name}' 'Previous page' button")
    public Button previousPageButton() {
        return new Button().setCore(Button.class, core().find(previousPageButtonLocator));
    }

    @JDIAction("Get '{name}' 'Next page' button")
    public Button nextPageButton() {
        return new Button().setCore(Button.class, core().find(nextPageButtonLocator));
    }

    @JDIAction("Get '{name}' 'Last page' button")
    public Button lastPageButton() {
        return new Button().setCore(Button.class, core().find(lastPageButtonLocator));
    }

    @Override
    public MUITableFooterAssert is() {
        return new MUITableFooterAssert().set(this);
    }

    private String paginationInfo() {
        return core().find(paginationInfoLocator).text();
    }
}
