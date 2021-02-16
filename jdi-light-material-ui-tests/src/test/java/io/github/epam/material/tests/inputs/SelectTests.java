package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.inputSelectDisabledPage;
import static io.github.com.StaticSite.inputSelectMultiplePage;
import static io.github.com.StaticSite.inputSelectSimplePage;
import static io.github.com.StaticSite.selectFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectTests extends TestsInit {

    @Test
    public void disabledSelectTest() {
        inputSelectDisabledPage.open();
        selectFrame.disabledSelect.is().disabled();
    }

    @Test
    public void simpleSelectTest() {
        String item1 = "Henry";
        String item2 = "Hansen";

        inputSelectSimplePage.open();
        selectFrame.simpleSelect.is().enabled();
        selectFrame.simpleSelect.open();
        selectFrame.simpleSelect.is().expanded();
        selectFrame.simpleSelect.selectItemByText(item1);
        selectFrame.simpleSelect.is().itemTextDisplayed(item1);

        selectFrame.simpleSelect.is().enabled();
        selectFrame.simpleSelect.open();
        selectFrame.simpleSelect.is().expanded();
        selectFrame.simpleSelect.selectItemByIndex(1);
        selectFrame.simpleSelect.is().itemTextDisplayed(item2);
    }

    @Test
    public void multipleSelectTest() {
        List<String> items = Arrays.asList("Omar", "Carlos", "Miriam");

        inputSelectMultiplePage.open();
        selectFrame.multipleSelect.is().enabled();
        selectFrame.multipleSelect.open();
        selectFrame.multipleSelect.is().expanded();
        selectFrame.multipleSelect.multipleSelect(items);
        selectFrame.multipleSelect.close();
        selectFrame.multipleSelect.is().itemsTextDisplayed(items);
    }
}
