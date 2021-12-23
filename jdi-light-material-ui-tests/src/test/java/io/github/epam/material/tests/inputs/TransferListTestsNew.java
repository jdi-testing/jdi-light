package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;
import static io.github.com.pages.inputs.SimpleTransferListPage.simpleTransferListNew;

public class TransferListTestsNew extends TestsInit {

    @Test
    public void simpleTransferListTests() {
        simpleTransferListPage.open();
        simpleTransferListPage.checkOpened();

        simpleTransferListNew.leftList().is().notEmpty();
        simpleTransferListNew.moveAllItemsRight(); // transfer with high-level method
        simpleTransferListNew.leftList().is().empty();
        simpleTransferListNew.moveAllItemsLeftButton().click(); // transfer by clicking button directly
        simpleTransferListNew.rightList().is().empty();

        String textOfItemToTransfer = "List item 5";

        // Transfer items with high-level methods
        simpleTransferListNew.leftList().checkItemByText(textOfItemToTransfer);
        simpleTransferListNew.leftList().getItemByText(textOfItemToTransfer).is().checked();
        simpleTransferListNew.moveCheckedItemsRight();
        simpleTransferListNew.rightList().has().itemsWithTexts(Collections.singleton(textOfItemToTransfer));

        // Transfer items by interacting with element components
        simpleTransferListNew.rightList().getItemByText(textOfItemToTransfer).is().unchecked();
        simpleTransferListNew.rightList().getItemByText(textOfItemToTransfer).checkbox().check();
        simpleTransferListNew.moveCheckedItemsLeftButton().click();
        simpleTransferListNew.leftList().has().itemsWithTexts(Collections.singleton(textOfItemToTransfer));
    }

    @Test
    public void enhancedTransferListTests() {
        enhancedTransferListPage.open();
        enhancedTransferListPage.checkOpened();

    }
}
