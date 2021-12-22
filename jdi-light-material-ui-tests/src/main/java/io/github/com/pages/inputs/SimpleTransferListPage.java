package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.elements.inputs.TransferListNew;
import com.epam.jdi.light.material.elements.inputs.transferlist.SimpleTransferList;

public class SimpleTransferListPage extends WebPage {

    @JDITransferList(
            root = "#root",
            moveAllLeftButton = "button[aria-label='move all left']",
            moveAllRightButton = "button[aria-label='move all right']"
    )
    public static SimpleTransferList simpleTransferList;

    @UI(".MuiGrid-root.MuiGrid-justify-xs-center")
    public static TransferListNew simpleTransferListNew;
}
