package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class DividerSection {
    @UI("#divider-list mat-list-item")
    public JList<UIElement> itemsList;

    @UI("#divider-list .mat-list-item-content")
    public JList<Text> itemsContent;

    @UI("#divider-list mat-divider")
    public JList<UIElement> itemsDivider;
}
