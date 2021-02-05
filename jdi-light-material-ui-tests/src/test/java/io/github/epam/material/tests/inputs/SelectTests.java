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
        selectFrame.select.is().disabled();
    }

    @Test
    public void simpleSelectTest() {
        String item = "Henry";

        inputSelectSimplePage.open();
        selectFrame.select.is().enabled();
        selectFrame.select.selectItem(item);
        selectFrame.select.is().itemTextDisplayed(item);
        selectFrame.select.is().collapsed();

        inputSelectSimplePage.open();
        selectFrame.select.is().enabled();
        selectFrame.select.selectItem(1);
        selectFrame.select.is().itemTextDisplayed(item);
        selectFrame.select.is().collapsed();
    }

    @Test
    public void multipleSelectTest() {
        List<String> items = Arrays.asList("Omar", "Carlos", "Miriam");

        inputSelectMultiplePage.open();
        selectFrame.select.is().enabled();
        selectFrame.select.multipleSelect(items);
        selectFrame.select.close();
        selectFrame.select.is().itemsTextDisplayed(items);
    }
}
