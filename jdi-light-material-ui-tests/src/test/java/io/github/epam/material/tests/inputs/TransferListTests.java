package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;
import static io.github.com.pages.inputs.EnhancedTransferListPage.enhancedTransferList;
import static io.github.com.pages.inputs.SimpleTransferListPage.simpleTransferList;

public class TransferListTests extends TestsInit {

    @Test
    public void simpleTransferListTests() {
        simpleTransferListPage.open();
        simpleTransferListPage.checkOpened();

        simpleTransferList.leftList().is().notEmpty();
        simpleTransferList.moveAllItemsRight();
        simpleTransferList.leftList().is().empty();
        simpleTransferList.moveAllItemsLeftButton().click();
        simpleTransferList.rightList().is().empty();

        String textOfItemToTransfer = "List item 5";

        simpleTransferList.leftList().checkItemByText(textOfItemToTransfer);
        simpleTransferList.leftList().getItemByText(textOfItemToTransfer).is().checked();
        simpleTransferList.moveCheckedItemsRight();
        simpleTransferList.rightList().has().itemWithText(textOfItemToTransfer);

        simpleTransferList.rightList().getItemByText(textOfItemToTransfer).is().unchecked();
        simpleTransferList.rightList().getItemByText(textOfItemToTransfer).checkbox().check();
        simpleTransferList.has().allRightListItemsChecked();
        simpleTransferList.moveCheckedItemsLeftButton().click();
        simpleTransferList.leftList().has().itemWithText(textOfItemToTransfer);
    }

    @Test
    public void enhancedTransferListTests() {
        enhancedTransferListPage.open();
        enhancedTransferListPage.checkOpened();

        enhancedTransferList.leftListHeader().has().text("Choices");
        enhancedTransferList.has().allLeftListItemsUnchecked();
        enhancedTransferList.leftListSubheader().has().text("0/4 selected");
        enhancedTransferList.checkAllLeftItems();
        enhancedTransferList.has().allLeftListItemsChecked();
        enhancedTransferList.leftListSubheader().has().text("4/4 selected");

        enhancedTransferList.rightListHeader().has().text("Chosen");
        enhancedTransferList.rightListSubheader().has().text("0/4 selected");
        enhancedTransferList.moveCheckedItemsRight();

        Set<String> allItemTextsSet = new HashSet<>(Arrays.asList("List item 1", "List item 2", "List item 3",
                "List item 4", "List item 5", "List item 6", "List item 7", "List item 8"));

        enhancedTransferList.rightList().has().itemsWithTexts(allItemTextsSet);
        enhancedTransferList.rightListSubheader().has().text("0/8 selected");
        enhancedTransferList.checkAllRightItems();
        enhancedTransferList.uncheckAllRightItems();
        enhancedTransferList.has().allRightListItemsUnchecked();
        enhancedTransferList.rightList().checkItemByText("List item 7");
        enhancedTransferList.moveCheckedItemsLeft();
    }
}
