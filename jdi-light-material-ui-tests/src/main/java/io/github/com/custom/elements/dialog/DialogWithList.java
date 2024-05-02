package io.github.com.custom.elements.dialog;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.list.ListItem;
import com.epam.jdi.light.material.elements.displaydata.list.MUIList;
import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
import com.epam.jdi.light.material.elements.feedback.Dialog;

import static com.jdiai.tools.Timer.waitCondition;

public class DialogWithList extends Dialog {
    /**
     * Gets the list with items within the dialog.
     *
     * @return list with items within dialog as {@link SimpleList}
     */
    @JDIAction("Get '{name}' list items")
    public MUIList<ListItem> list() {
        return new MUIList<ListItem>().setCore(MUIList.class, core().find(".MuiList-root"));
    }

    public void select(int index) {
        this.list().items(ListItem.class).get(index).click();
        waitCondition(this::isHidden);
    }
}
