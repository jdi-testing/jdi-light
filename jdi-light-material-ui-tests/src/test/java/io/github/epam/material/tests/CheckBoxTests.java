package io.github.epam.material.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.materialPageFrame;
import static io.github.com.StaticSite.primaryCheckBoxPage;

public class CheckBoxTests extends TestsInit {

    @Test
    public void primaryCheckBoxTest() {
        primaryCheckBoxPage.shouldBeOpened();
        materialPageFrame.checkbox.is().enabledCheckbox();
        materialPageFrame.checkbox.clickOnCheckbox();
        materialPageFrame.checkbox.is().selectedCheckbox();
        materialPageFrame.checkbox.clickOnCheckbox();
        materialPageFrame.checkbox.is().unSelectedCheckbox();
    }

}
