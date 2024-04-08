package com.epam.jdi.light.material.elements.displaydata.list;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.annotations.JMUIList;
import com.epam.jdi.light.material.asserts.displaydata.ContainerListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;


/**
 * Represents List MUI component on GUI.
 *
 * @see IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */

public class MUIList<T extends ICoreElement> extends UIBaseElement<ContainerListAssert> implements IMUIList<ICoreElement> {

    protected String itemLocator = ".MuiListItem-container";
    protected String headerLocator = ".MuiListSubheader-root";

    public void setup(Field field) {
        if (fieldHasAnnotation(field, JMUIList.class, MUIList.class)) {
            JMUIList listLocators = field.getAnnotation(JMUIList.class);
            itemLocator = listLocators.items();
            headerLocator = listLocators.header();
        }
    }
    @Override
    public String itemLocator() {
        return this.itemLocator;
    }
    @Override
    public String headerLocator() {
        return this.headerLocator;
    }
    /**
     * Get list of items
     *
     * @return list of items as {@code List<MUIButton>}
     */
    @Override
    public List<ICoreElement> items() {
        return new ArrayList<>(core().finds(itemLocator));
    }

    @Override
    public ContainerListAssert is() {
        return new ContainerListAssert().set(this);
    }
}
