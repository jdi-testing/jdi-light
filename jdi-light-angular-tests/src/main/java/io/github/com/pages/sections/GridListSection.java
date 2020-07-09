package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridListSection {

    //@FindBy(id="basic-grid-list")
    @UI("#basic-grid-list")
    //@UI("[ui=label] basic-grid-list")
    public JList<Label> basicGridList;

    //public JList<Label> dynamicGridList;

}
