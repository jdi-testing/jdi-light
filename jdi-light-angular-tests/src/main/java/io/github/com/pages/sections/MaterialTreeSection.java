package io.github.com.pages.sections;


import com.epam.jdi.light.angular.elements.complex.MaterialTree;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class MaterialTreeSection {
    @UI("tree-dynamic-example")
    public static UIElement dynamicExample;
    @UI("#tree-dynamic")
    public static MaterialTree dynamicTree;
    @UI("#tree-dynamic mat-tree-node")
    public JList<Button> basicTree;
}
