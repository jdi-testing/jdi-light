package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.gridListFrame;
import static io.github.com.StaticSite.layoutGridListPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class GridListTests extends TestsInit {

    @Test
    public void gridListTest() {
        layoutGridListPage.open();
        gridListFrame.gridList.is().titleEquals(2, "plant");
        gridListFrame.gridList.is().subtitleContains(2, "author2");
        gridListFrame.gridList.getActionIcon(1).is().attr("aria-label", "info about morning");
    }
}
