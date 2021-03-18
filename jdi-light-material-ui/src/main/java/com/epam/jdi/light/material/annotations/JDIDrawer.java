package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIDrawer {

    @MarkupLocator String root() default "";
    @MarkupLocator String drawerLeftButton() default "//*[text()='left']/..";
    @MarkupLocator String drawerRightButton() default "//*[text()='right']/..";
    @MarkupLocator String drawerTopButton() default "//*[text()='top']/..";
    @MarkupLocator String drawerBottomButton() default "//*[text()='bottom']/..";

    @MarkupLocator String drawerLeftListItems() default "//*[contains(@class,'MuiDrawer-paperAnchorLeft')]";
    @MarkupLocator String drawerRightListItems() default "//*[contains(@class,'MuiDrawer-paperAnchorRight')]";
    @MarkupLocator String drawerTopListItems() default "//*[contains(@class,'MuiDrawer-paperAnchorTop')]";
    @MarkupLocator String drawerBottomListItems() default "//*[contains(@class,'MuiDrawer-paperAnchorBottom')]";

    @MarkupLocator String drawerBaseButton() default "(//*[contains(@class,'MuiSvgIcon-root')])[1]";
    @MarkupLocator String drawerLeftDockedListItems() default "//*[contains(@class,'MuiDrawer-paperAnchorDockedLeft')]";
}
