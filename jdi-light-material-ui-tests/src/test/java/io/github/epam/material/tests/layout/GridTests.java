package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.gridPage;
import static io.github.com.pages.layout.GridPage.*;

public class GridTests extends TestsInit {

    @BeforeTest
    public void before() {
        gridPage.open();
    }

    @Test
    public void gridTest() {
        rootGrid.is().displayed();
        rootGrid.attr("class").contains("MuiContainer-maxWidthXl");
        basicGrid.is().displayed();
        complexGrid.is().displayed();
    }

    @Test
    public void buttonsTest() {
        listButton.forEach(button -> button.is().displayed());
        listButton.forEach(button -> button.click());
    }

    @Test
    public void inputsTest() {
        listInput.forEach(input-> {
            input.is().displayed();
            input.setValue("xs=5");
            input.is().text("xs=5");
        });
    }

}
