package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class TransferListTests extends TestsInit {

    @Test
    public void simpleTransferListTest() {
        simpleTransferListPage.open();
        simpleTransferListPage.simpleTransferList.is().isMoveRightButtonDisable();
        simpleTransferListPage.simpleTransferList.is().isMoveLeftButtonDisable();

        simpleTransferListPage.simpleTransferList.check("List item 1");
        simpleTransferListPage.simpleTransferList.is().checked("List item 1");

        simpleTransferListPage.simpleTransferList.is().isMoveRightButtonEnable();
        simpleTransferListPage.simpleTransferList.moveItemsRight();
        simpleTransferListPage.simpleTransferList.is().itemsMovedRight("List item 1");

        simpleTransferListPage.simpleTransferList.check("List item 5");
        simpleTransferListPage.simpleTransferList.check("List item 6");
        simpleTransferListPage.simpleTransferList.is().checked("List item 5");
        simpleTransferListPage.simpleTransferList.is().checked("List item 6");
        simpleTransferListPage.simpleTransferList.is().isMoveLeftButtonEnable();
        simpleTransferListPage.simpleTransferList.moveItemsLeft();
        simpleTransferListPage.simpleTransferList.is().itemsMovedLeft("List item 5", "List item 6");

        simpleTransferListPage.simpleTransferList.moveAllElementsRight();
        simpleTransferListPage.simpleTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        simpleTransferListPage.simpleTransferList.moveAllElementsLeft();
        simpleTransferListPage.simpleTransferList.is().itemsMovedLeft("List item 1", "List item 2",
          "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

    @Test
    public void enhancedTransferListTest() {
        enhancedTransferListPage.open();
        enhancedTransferListPage.enhancedTransferList.is().isMoveRightButtonDisable();
        enhancedTransferListPage.enhancedTransferList.is().isMoveLeftButtonDisable();

        enhancedTransferListPage.enhancedTransferList.check("List item 1");
        enhancedTransferListPage.enhancedTransferList.is().checked("List item 1");
        enhancedTransferListPage.enhancedTransferList.is().isMoveRightButtonEnable();

        enhancedTransferListPage.enhancedTransferList.uncheck("List item 1");
        enhancedTransferListPage.enhancedTransferList.is().unchecked("List item 1");

        enhancedTransferListPage.enhancedTransferList.moveAllElementsRight();
        enhancedTransferListPage.enhancedTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        enhancedTransferListPage.enhancedTransferList.moveAllElementsLeft();
        enhancedTransferListPage.enhancedTransferList.is().itemsMovedLeft("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

}
