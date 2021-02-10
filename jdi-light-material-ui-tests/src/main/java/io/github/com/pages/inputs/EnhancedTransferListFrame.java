package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.elements.inputs.TransferList.EnhancedTransferList;

public class EnhancedTransferListFrame extends Section {

    @JDITransferList(root = "#root")
    public EnhancedTransferList enhancedTransferList;

}
