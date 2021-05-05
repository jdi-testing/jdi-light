package io.github.epam.material.tests.layout;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.layout.GridPage.*;

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
    public void buttonsTest() {
        firstButton.is().displayed();
        secondButton.is().displayed();
        thirdButton.is().displayed();
        fourthButton.is().displayed();
        firstButton.click();
        secondButton.click();
        thirdButton.click();
        fourthButton.click();
    }

    @Test
    public void inputsTest() {
        firstInput.is().displayed();
        firstInput.setValue("xs=1");
        firstInput.is().text("xs=1");
        secondInput.is().displayed();
        secondInput.setValue("xs=2");
        secondInput.is().text("xs=2");
        thirdInput.is().displayed();
        thirdInput.setValue("xs=3");
        thirdInput.is().text("xs=3");
        fourthInput.is().displayed();
        fourthInput.setValue("xs=4");
        fourthInput.is().text("xs=4");
    }

}
