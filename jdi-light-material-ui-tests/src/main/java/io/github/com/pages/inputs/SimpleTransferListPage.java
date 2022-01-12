package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.transferlist.SimpleTransferList;

public class SimpleTransferListPage extends WebPage {

    @UI(".MuiGrid-root.MuiGrid-justify-xs-center")
    public static SimpleTransferList simpleTransferList;
}
