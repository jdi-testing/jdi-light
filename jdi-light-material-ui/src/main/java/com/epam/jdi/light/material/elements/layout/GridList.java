package com.epam.jdi.light.material.elements.layout;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIGridList;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;

import java.lang.reflect.Field;

public class GridList extends UIBaseElement<GridListAssert> implements ISetup {

    private String gridList;
    private String gridTitle;
    private String gridSubtitle;
    private String gridActionButton;

    @JDIAction("Get grid by index")
    public UIElement getGrid(int index) {
        return this.finds(gridList).get(index);
    }

    @JDIAction("Get grid title by index")
    public String getGridTitle(int index) {
        return this.finds(gridTitle).get(index).getText();
    }

    @JDIAction("Get grid subtitle by index")
    public String getGridSubtitle(int index) {
        return this.finds(gridSubtitle).get(index).getText();
    }

    @JDIAction("Get grid action icon by index")
    public UIElement getActionIcon(int index) {
        return this.finds(gridActionButton).get(index);
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIGridList.class, GridList.class))
            return;
        JDIGridList j = field.getAnnotation(JDIGridList.class);

        gridList = j.gridList();
        gridTitle = j.gridTitle();
        gridSubtitle = j.gridSubtitle();
        gridActionButton = j.gridActionButton();
    }
}
