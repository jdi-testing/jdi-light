package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonGroupFrame;
import static io.github.com.StaticSite.inputButtonGroupDefaultPage;

public class ButtonGroupTests extends TestsInit {

    @Test
    public void defaultButtonGroupTest() {
        inputButtonGroupDefaultPage.open();

        // click by index
        buttonGroupFrame.buttonGroup.finds(By.className("MuiButton-root")).get(1).click();
        buttonGroupFrame.buttonGroup.finds(By.className("MuiButton-root")).get(2).click();
        buttonGroupFrame.buttonGroup.finds(By.className("MuiButton-root")).get(3).click();

        // click by button text
        buttonGroupFrame.buttonGroup.find(By.xpath("//span[contains(text(), 'One')]")).click();
        buttonGroupFrame.buttonGroup.find(By.xpath("//span[contains(text(), 'Two')]")).click();
        buttonGroupFrame.buttonGroup.find(By.xpath("//span[contains(text(), 'Three')]")).click();


    }

    // disabled button group contains disabled buttons

}
