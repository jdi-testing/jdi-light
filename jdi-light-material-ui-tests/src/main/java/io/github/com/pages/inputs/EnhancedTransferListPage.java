package io.github.com.pages.inputs;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;

public class EnhancedTransferListPage extends WebPage {

    @JDITransferList(root = "#root", allItemsLeftCheckbox = "(//span[./input[@aria-label='all items selected']])[1]",
        allItemsRightCheckbox = "(//span[./input[@aria-label='all items selected']])[2]")
    public static EnhancedTransferList enhancedTransferList;

}
