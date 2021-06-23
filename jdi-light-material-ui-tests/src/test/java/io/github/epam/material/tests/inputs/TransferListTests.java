package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.inputEnhancedTransferListPage;
import static io.github.com.StaticSite.inputSimpleTransferListPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class TransferListTests extends TestsInit {

    @Test
    public void simpleTransferListTest() {
        inputSimpleTransferListPage.open();
        inputSimpleTransferListPage.simpleTransferList.is().isMoveRightButtonDisable();
        inputSimpleTransferListPage.simpleTransferList.is().isMoveLeftButtonDisable();

        inputSimpleTransferListPage.simpleTransferList.check("List item 1");
        inputSimpleTransferListPage.simpleTransferList.is().checked("List item 1");
        inputSimpleTransferListPage.simpleTransferList.is().isMoveRightButtonEnable();
        inputSimpleTransferListPage.simpleTransferList.moveItemsRight();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedRight("List item 1");

        inputSimpleTransferListPage.simpleTransferList.check("List item 5");
        inputSimpleTransferListPage.simpleTransferList.check("List item 6");
        inputSimpleTransferListPage.simpleTransferList.is().checked("List item 5");
        inputSimpleTransferListPage.simpleTransferList.is().checked("List item 6");
        inputSimpleTransferListPage.simpleTransferList.is().isMoveLeftButtonEnable();
        inputSimpleTransferListPage.simpleTransferList.moveItemsLeft();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedLeft("List item 5", "List item 6");

        inputSimpleTransferListPage.simpleTransferList.moveAllElementsRight();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        inputSimpleTransferListPage.simpleTransferList.moveAllElementsLeft();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedLeft("List item 1", "List item 2",
          "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

    @Test
    public void enhancedTransferListTest() {
        inputEnhancedTransferListPage.open();
        inputSimpleTransferListPage.simpleTransferList.is().isMoveRightButtonDisable();
        inputSimpleTransferListPage.simpleTransferList.is().isMoveLeftButtonDisable();

        inputEnhancedTransferListPage.enhancedTransferList.check("List item 1");
        inputEnhancedTransferListPage.enhancedTransferList.is().checked("List item 1");
        inputSimpleTransferListPage.simpleTransferList.is().isMoveRightButtonEnable();

        inputEnhancedTransferListPage.enhancedTransferList.uncheck("List item 1");
        inputEnhancedTransferListPage.enhancedTransferList.is().unchecked("List item 1");

        inputEnhancedTransferListPage.enhancedTransferList.moveAllElementsRight();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        inputEnhancedTransferListPage.enhancedTransferList.moveAllElementsLeft();
        inputSimpleTransferListPage.simpleTransferList.is().itemsMovedLeft("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

}
