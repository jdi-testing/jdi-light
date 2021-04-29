package io.github.epam.material.tests.layout;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.layout.GridPage.basicGrid;
import static io.github.com.pages.layout.GridPage.complexGrid;
import static io.github.com.pages.layout.GridPage.firstButton;
import static io.github.com.pages.layout.GridPage.fourthButton;
import static io.github.com.pages.layout.GridPage.rootGrid;
import static io.github.com.pages.layout.GridPage.secondButton;
import static io.github.com.pages.layout.GridPage.thirdButton;

public class GridTests extends TestsInit {

    @BeforeTest
    public void before() {
        openSection("Grid");
        Timer timer = new Timer(1000L);
        timer.wait(() -> complexGrid.isDisplayed());
    }

    @Test
    public void gridTest() {
        rootGrid.is().displayed();
        rootGrid.attr("class").contains("MuiContainer-maxWidthXl");
        basicGrid.is().displayed();
        complexGrid.is().displayed();
    }

    @Test
    public void buttonsOnGridTest() {
        firstButton.is().displayed();
        secondButton.is().displayed();
        thirdButton.is().displayed();
        fourthButton.is().displayed();
        firstButton.click();
        secondButton.click();
        thirdButton.click();
        fourthButton.click();
    }

}
