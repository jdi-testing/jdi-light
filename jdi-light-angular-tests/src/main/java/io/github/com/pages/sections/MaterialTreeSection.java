package io.github.com.pages.sections;


import com.epam.jdi.light.angular.elements.complex.MaterialTree;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class MaterialTreeSection {
    @UI("tree-dynamic-example")
    public static UIElement dynamicExample;
    @UI("#tree-dynamic")
    public static MaterialTree dynamicTree;
    @UI("tree-flat-overview-example")
    public static UIElement flatExample;
    @UI("#tree-flat")
    public static MaterialTree flatTree;
    @UI("tree-checklist-example")
    public static UIElement checkBoxesExample;
    @UI("#tree-checklist")
    public static MaterialTree checkBoxesTree;
}
