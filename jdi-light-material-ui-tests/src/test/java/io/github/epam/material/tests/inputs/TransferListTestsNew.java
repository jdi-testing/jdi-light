package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.enhancedTransferListPage;
import static io.github.com.StaticSite.simpleTransferListPage;

public class TransferListTestsNew extends TestsInit {

    @Test
    public void simpleTransferListTests() {
        simpleTransferListPage.open();
        simpleTransferListPage.checkOpened();

    }

    @Test
    public void enhancedTransferListTests() {
        enhancedTransferListPage.open();
        enhancedTransferListPage.checkOpened();

    }
}
