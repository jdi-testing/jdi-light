package com.epam.jdi.light.material.elements.displaydata.list;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.annotations.JMUIList;
import com.epam.jdi.light.material.asserts.displaydata.ContainerListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;


/**
 * Represents List MUI component on GUI.
 *
 * @see IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */

public class MUIList<T extends ICoreElement> extends UIBaseElement<ContainerListAssert> implements IMUIList<ICoreElement> {

    protected String itemLocator = ".MuiListItem-root";
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

    @Override
    public List<ICoreElement> items() {
        return core().finds(itemLocator).stream().collect(Collectors.toList());
    }

    public WebList weblist() {
        return core().finds(itemLocator);
    }
    /**
     * Get list of items
     *
     * @return list of items as {@code List<MUIButton>}
     */
    public <T extends ICoreElement> List<T> items(Class<T> cl) {
        try {
            Constructor<T> constr = cl.getConstructor();
            return core().finds(itemLocator).stream().map(o -> {
                try {
                    return constr.newInstance().setCore(cl, o);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw runtimeException("Can not create a new object " + cl , e);
                }
            })
            .collect(Collectors.toList());
        } catch (Exception ex) {
            throw runtimeException("Can not create a list " + cl, ex);
        }
    }

    @Override
    public ContainerListAssert is() {
        return new ContainerListAssert().set(this);
    }
}
