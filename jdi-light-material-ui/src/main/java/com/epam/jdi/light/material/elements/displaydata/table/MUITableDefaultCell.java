package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableDefaultCellAssert;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableDefaultCell extends MUITableCell<MUITableDefaultCellAssert> implements IsText, HasClick {

    private Button button;
    private Checkbox checkbox;
    private Select select;

    public MUITableDefaultCell(int rowIndex, int columnIndex) {
        super(rowIndex, columnIndex);
    }

    @Override
    public String getText() {
        Text text = new Text().setCore(Text.class, core().find(".//div[@class='MuiDataGrid-colCellTitle'] | ."));
        if (text.isExist()) {
            return text.getValue();
        } else {
            return "";
        }
    }

    public Button button(String label) {
//        if (button == null) {
//            button = new Button().setCore(Button.class, core().find(".//button"));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(String.format(".//button[@aria-label='%s']", label)));
    }

    public Checkbox checkbox() {
        if (checkbox == null) {
            checkbox = new Checkbox().setCore(Checkbox.class, core().find(".//*[contains(@class,'MuiCheckbox-root')]"));
        }
        return checkbox;
    }

    public Select select() {
        if (select == null) {
            select = new Select().setCore(Select.class, core().find(".//select"));
        }
        return select;
    }

    @Override
    public MUITableDefaultCellAssert is() {
        return new MUITableDefaultCellAssert().set(this);
    }

}
