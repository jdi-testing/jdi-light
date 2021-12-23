package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;
import static io.github.com.pages.inputs.EnhancedTransferListPage.enhancedTransferListNew;
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
        simpleTransferListNew.rightList().has().itemWithText(textOfItemToTransfer);

        // Transfer items by interacting with element components
        simpleTransferListNew.rightList().getItemByText(textOfItemToTransfer).is().unchecked();
        simpleTransferListNew.rightList().getItemByText(textOfItemToTransfer).checkbox().check();
        simpleTransferListNew.has().allRightListItemsChecked();
        simpleTransferListNew.moveCheckedItemsLeftButton().click();
        simpleTransferListNew.leftList().has().itemWithText(textOfItemToTransfer);
    }

    @Test
    public void enhancedTransferListTests() {
        enhancedTransferListPage.open();
        enhancedTransferListPage.checkOpened();

        enhancedTransferListNew.leftListHeader().has().text("Choices");
        enhancedTransferListNew.has().allLeftListItemsUnchecked();
        enhancedTransferListNew.leftListSubheader().has().text("0/4 selected");
        enhancedTransferListNew.checkAllLeftItems();
        enhancedTransferListNew.has().allLeftListItemsChecked();
        enhancedTransferListNew.leftListSubheader().has().text("4/4 selected");

        enhancedTransferListNew.rightListHeader().has().text("Chosen");
        enhancedTransferListNew.rightListSubheader().has().text("0/4 selected");
        enhancedTransferListNew.moveCheckedItemsRight();

        Set<String> allItemTextsSet = new HashSet<>(Arrays.asList("List item 1", "List item 2", "List item 3",
                "List item 4", "List item 5", "List item 6", "List item 7", "List item 8"));

        enhancedTransferListNew.rightList().has().itemsWithTexts(allItemTextsSet);
        enhancedTransferListNew.rightListSubheader().has().text("0/8 selected");
        enhancedTransferListNew.checkAllRightItems();
        enhancedTransferListNew.uncheckAllRightItems();
        enhancedTransferListNew.has().allRightListItemsUnchecked();
        enhancedTransferListNew.rightList().checkItemByText("List item 7");
        enhancedTransferListNew.moveCheckedItemsLeft();
    }
}
