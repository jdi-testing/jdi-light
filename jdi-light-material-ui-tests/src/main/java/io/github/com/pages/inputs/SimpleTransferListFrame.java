package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.elements.inputs.TransferList.SimpleTransferList;

public class SimpleTransferListFrame extends Section {

    @JDITransferList(root = "#root", moveAllLeftButton = "button[aria-label='move all left']",
        moveAllRightButton = "button[aria-label='move all right']")
    public SimpleTransferList simpleTransferList;

}
