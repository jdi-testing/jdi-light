package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.displaydata.MUIListCommonAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.util.List;
import java.util.stream.Collectors;

public class MUICustomList extends UIBaseElement<MUICustomList.MUICustomListAssert> implements IMUIList<MUIContainerListItem> {

    private static final String ITEM = ".MuiListItem-container";

    /**
     * Get List items
     *
     * @return list of items as {@link MUIContainerListItem}
     */
    @JDIAction(value = "Get '{name}' text element")
    @Override
    public List<MUIContainerListItem> items() {
        return core().finds(ITEM).stream().map(el -> el.with(MUIContainerListItem.class)).collect(Collectors.toList());
    }

    @Override
    public <T extends ICoreElement> List<T> items(Class<T> clazz) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MUICustomListAssert is() {
        return new MUICustomListAssert().set(this);
    }

    public class MUICustomListAssert extends MUIListCommonAssert<MUICustomListAssert, MUICustomList> {

    }
}
