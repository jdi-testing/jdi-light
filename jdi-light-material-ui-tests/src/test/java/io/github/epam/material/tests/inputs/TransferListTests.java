package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;
import static io.github.com.pages.inputs.EnhancedTransferListPage.enhancedTransferList;
import static io.github.com.pages.inputs.SimpleTransferListPage.simpleTransferList;

import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;
import io.github.epam.TestsInit;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TransferListTests extends TestsInit {
    List<String> items = Arrays.asList("List item 1", "List item 2",
            "List item 3", "List item 4", "List item 5", "List item 6", "List item 7", "List item 8");

    @Test
    public void simpleTransferListTest() {
        simpleTransferListPage.open();
        simpleTransferList.assertThat().isMoveRightButtonDisable().and().isMoveLeftButtonDisable();

        simpleTransferList.check(items.get(0));
        simpleTransferList.is().checked(items.get(0));

        simpleTransferList.is().isMoveRightButtonEnable();
        simpleTransferList.moveItemsRight();
        simpleTransferList.is().itemsMovedRight(items.get(0));

        simpleTransferList.check(items.get(4));
        simpleTransferList.check(items.get(5));
        simpleTransferList.is().checked(items.get(4));
        simpleTransferList.is().checked(items.get(5));
        simpleTransferList.is().isMoveLeftButtonEnable();
        simpleTransferList.moveItemsLeft();
        simpleTransferList.is().itemsMovedLeft(items.get(4), items.get(5));

        checkMoveElementsFunction(simpleTransferList, items.toArray(new String[0]));
    }

    @Test
    public void enhancedTransferListTest() {
        enhancedTransferListPage.open();
        enhancedTransferList.assertThat().isMoveRightButtonDisable().and().isMoveLeftButtonDisable();

        enhancedTransferList.check(items.get(0));
        enhancedTransferList.is().checked(items.get(0));
        enhancedTransferList.is().isMoveRightButtonEnable();

        enhancedTransferList.uncheck(items.get(0));
        enhancedTransferList.is().unchecked(items.get(0));

        checkMoveElementsFunction(enhancedTransferList, items.toArray(new String[0]));
    }

    private static void checkMoveElementsFunction(TransferList transferList, String... checkingItems) {
        transferList.moveAllElementsRight();
        transferList.has().itemsMovedRight(checkingItems);
        transferList.moveAllElementsLeft();
        transferList.has().itemsMovedLeft(checkingItems);
    }
}
