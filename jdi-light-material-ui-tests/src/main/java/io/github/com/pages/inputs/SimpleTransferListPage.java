package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JTransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;

public class SimpleTransferListPage extends WebPage {

    @JTransferList(
            root = "#root",
            moveAllLeftButton = "button[aria-label='move all left']",
            moveAllRightButton = "button[aria-label='move all right']"
    )
    public static TransferList simpleTransferList;
}
