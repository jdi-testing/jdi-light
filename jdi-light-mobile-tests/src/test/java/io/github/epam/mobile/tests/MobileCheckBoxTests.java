package io.github.epam.mobile.tests;

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.github.epam.StaticSite.*;
import static io.github.epam.sections.HtmlMobileElements.htmlMenu;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MobileCheckBoxTests extends StaticTestsInit {

    @Test
    public void checkBoxClick() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        htmlMobilePage.singleCheckBox.click();
        htmlMobilePage.singleCheckBox.is().selected();
    }

    @Test
    public void isCheckBoxDisplayed() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        htmlMobilePage.singleCheckBox.click();
        htmlMobilePage.singleCheckBox.is().displayed();
    }

    @Test
    public void getCheckBoxByText() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        UIElement checkBoxHot = htmlMobilePage.checkList.find(By.id("hot"));
        checkBoxHot.core().click();
        checkBoxHot.is().selected();

        UIElement checkBoxCold = htmlMobilePage.checkList.find(By.id("cold"));
        checkBoxCold.core().click();
        checkBoxCold.is().selected();

        UIElement checkBoxRainy = htmlMobilePage.checkList.find(By.id("rainy"));
        checkBoxRainy.core().click();
        checkBoxRainy.is().selected();

        UIElement checkBoxSunny = htmlMobilePage.checkList.find(By.id("sunny-day"));
        checkBoxSunny.core().click();
        checkBoxSunny.is().selected();

        UIElement checkBoxDisabled = htmlMobilePage.checkList.find(By.id("disabled-ch"));
        checkBoxDisabled.core().is().disabled();
    }

    @Test
    public void verifyOtherCheckBoxesNotSelected() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        UIElement checkBoxHot = htmlMobilePage.checkList.find(By.id("hot"));
        checkBoxHot.core().click();
        checkBoxHot.is().selected();

        UIElement checkBoxCold = htmlMobilePage.checkList.find(By.id("cold"));
        checkBoxCold.is().deselected();

        UIElement checkBoxRainy = htmlMobilePage.checkList.find(By.id("rainy"));
        checkBoxRainy.is().deselected();

        UIElement checkBoxSunny = htmlMobilePage.checkList.find(By.id("sunny-day"));
        checkBoxSunny.is().deselected();
    }
}
