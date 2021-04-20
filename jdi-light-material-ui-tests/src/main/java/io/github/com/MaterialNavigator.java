package io.github.com;


import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MaterialNavigator {
    private static String url = "https://jdi-testing.github.io/jdi-light/material/";
    private static WebDriver driver = getDriver();
    private static String oneSectionLocator = "//div[contains(@class,'MuiListSubheader-root')]/following::span[text()='%s']";
    private static String twoSectionLocator = "//div[@class='MuiList-root']//span[contains(text(),'%s')]";

    public static void openMainMaterialPage() {
        driver.navigate().to(url);
    }

    public static void openSection(String firstSection) {
        openMainMaterialPage();
        UIElement firstButton = new UIElement(By.xpath(String.format(oneSectionLocator,firstSection)));
        firstButton.click();
    }

    public static void openSection(String firstSection, String secondSection) {
        openMainMaterialPage();

        UIElement firstButton = new UIElement(By.xpath(String.format(oneSectionLocator,firstSection)));
        firstButton.core().click();

        UIElement secondButton = new UIElement(By.xpath(String.format(twoSectionLocator,secondSection)));
        secondButton.core().jsExecute("scrollIntoView()");
        secondButton.core().click();
    }
}
