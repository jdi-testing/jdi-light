package io.github.epam.material.tests.gridView;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.gridFrame;
import static io.github.com.StaticSite.gridViewPage;

public class GridViewTests extends TestsInit {

    @Test
    public void isButtonsGridEnabled() {
        gridViewPage.shouldBeOpened();

        gridFrame.gridView.is().isEnabled();
        gridFrame.gridView.clickOn();

    }
}
