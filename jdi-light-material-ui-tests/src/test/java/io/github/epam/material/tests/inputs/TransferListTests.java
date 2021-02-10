package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.inputSimpleTransferListPage;
import static io.github.com.StaticSite.simpleTransferListFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class TransferListTests extends TestsInit {

    @Test
    public void simpleTransferListTest() {
        inputSimpleTransferListPage.open();
        simpleTransferListFrame.simpleTransferList.check("List item 1");
        simpleTransferListFrame.simpleTransferList.is().checked("List item 1");
        simpleTransferListFrame.simpleTransferList.moveItemsRight();
        simpleTransferListFrame.simpleTransferList.is().itemsMovedRight("List item 1");
        simpleTransferListFrame.simpleTransferList.check("List item 5");
        simpleTransferListFrame.simpleTransferList.check("List item 6");
        simpleTransferListFrame.simpleTransferList.is().checked("List item 5");
        simpleTransferListFrame.simpleTransferList.is().checked("List item 6");
        simpleTransferListFrame.simpleTransferList.moveItemsLeft();
        simpleTransferListFrame.simpleTransferList.is().itemsMovedLeft("List item 5", "List item 6");
        simpleTransferListFrame.simpleTransferList.moveAllItemsLeft();
        simpleTransferListFrame.simpleTransferList.is().itemsMovedLeft("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
        simpleTransferListFrame.simpleTransferList.moveAllItemsRight();
        simpleTransferListFrame.simpleTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

//    @Test
//    public void enhancedTransferListTest() {
//        inputEnhancedTransferListPage.open();
//        transferListFrame.transferList.check("Choices");
//        transferListFrame.transferList.moveItemsRight();
//    }

}
