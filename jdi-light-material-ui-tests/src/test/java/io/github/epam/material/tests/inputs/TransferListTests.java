package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.inputs.SimpleTransferListPage.*;
import static io.github.com.pages.inputs.EnhancedTransferListPage.*;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class TransferListTests extends TestsInit {

    @Test
    public void simpleTransferListTest() {
        simpleTransferListPage.open();
        simpleTransferList.is().isMoveRightButtonDisable();
        simpleTransferList.is().isMoveLeftButtonDisable();

        simpleTransferList.check("List item 1");
        simpleTransferList.is().checked("List item 1");

        simpleTransferList.is().isMoveRightButtonEnable();
        simpleTransferList.moveItemsRight();
        simpleTransferList.is().itemsMovedRight("List item 1");

        simpleTransferList.check("List item 5");
        simpleTransferList.check("List item 6");
        simpleTransferList.is().checked("List item 5");
        simpleTransferList.is().checked("List item 6");
        simpleTransferList.is().isMoveLeftButtonEnable();
        simpleTransferList.moveItemsLeft();
        simpleTransferList.is().itemsMovedLeft("List item 5", "List item 6");

        simpleTransferList.moveAllElementsRight();
        simpleTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        simpleTransferList.moveAllElementsLeft();
        simpleTransferList.is().itemsMovedLeft("List item 1", "List item 2",
          "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

    @Test
    public void enhancedTransferListTest() {
        enhancedTransferListPage.open();
        enhancedTransferList.is().isMoveRightButtonDisable();
        enhancedTransferList.is().isMoveLeftButtonDisable();

        enhancedTransferList.check("List item 1");
        enhancedTransferList.is().checked("List item 1");
        enhancedTransferList.is().isMoveRightButtonEnable();

        enhancedTransferList.uncheck("List item 1");
        enhancedTransferList.is().unchecked("List item 1");

        enhancedTransferList.moveAllElementsRight();
        enhancedTransferList.is().itemsMovedRight("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

        enhancedTransferList.moveAllElementsLeft();
        enhancedTransferList.is().itemsMovedLeft("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");
    }

}
