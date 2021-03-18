package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDrawer;
import com.epam.jdi.light.material.asserts.navigation.DrawerAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Drawer extends UIBaseElement<DrawerAssert> implements ISetup {

    private String root;
    private String drawerLeftButton;
    private String drawerRightButton;
    private String drawerTopButton;
    private String drawerBottomButton;
    private String drawerLeftListItems;
    private String drawerRightListItems;
    private String drawerTopListItems;
    private String drawerBottomListItems;
    private String drawerBaseButton;
    private String drawerLeftDockedListItems;

    public void clickLeftButton(){
        this.find(drawerLeftButton).click();
    }

    public void clickRightButton(){
        this.find(drawerRightButton).click();
    }

    public void clickTopButton(){
        this.find(drawerTopButton).click();
    }

    public void clickBottomButton(){
        this.find(drawerBottomButton).click();
    }

    public void clickBaseButton(){
        this.find(drawerBaseButton).click();
    }

    public boolean isDrawerDisplayed(){
        return this.find(root).isDisplayed();
    }

    public boolean isLeftListItemsDisplayed(){
        return this.find(drawerLeftListItems).isDisplayed();
    }

    public boolean isRightListItemsDisplayed(){
        return this.find(drawerRightListItems).isDisplayed();
    }

    public boolean isTopListItemsDisplayed(){
        return this.find(drawerTopListItems).isDisplayed();
    }

    public boolean isBottomListItemsDisplayed(){
        return this.find(drawerBottomListItems).isDisplayed();
    }

    public boolean isBaseButtonDisplayed(){
        return this.find(drawerBaseButton).isDisplayed();
    }

    public boolean isLeftDockedListItemsDisplayed(){
        return this.find(drawerLeftDockedListItems).isDisplayed();
    }

    @Override
    public DrawerAssert is() {
        return new DrawerAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIDrawer.class, Drawer.class))
            return;
        JDIDrawer j = field.getAnnotation(JDIDrawer.class);

        root = j.root();
        drawerLeftButton = j.drawerLeftButton();
        drawerRightButton = j.drawerRightButton();
        drawerTopButton = j.drawerTopButton();
        drawerBottomButton = j.drawerBottomButton();
        drawerLeftListItems = j.drawerLeftListItems();
        drawerRightListItems = j.drawerRightListItems();
        drawerTopListItems = j.drawerTopListItems();
        drawerBottomListItems = j.drawerBottomListItems();
        drawerBaseButton = j.drawerBaseButton();
        drawerLeftDockedListItems = j.drawerLeftDockedListItems();
    }
}
