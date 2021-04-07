package io.github.com;


import com.epam.jdi.tools.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MaterialNavigator {
    private static String url = "https://jdi-testing.github.io/jdi-light/material/";
    private static WebDriver driver = getDriver();
    private static String oneSectionLocator = "//div[@class='MuiList-root']//span[text()='%s']";
    private static String twoSectionLocator = "//div[@class='MuiListItemText-root']//span[text()='%s']";
    private static String sectionTitle = "//h1";
    private static Timer timer = new Timer(2000L);

    public static void openMainMaterialPage() {
        driver.navigate().to(url);
    }

    public static void openSection(String firstSection) {
        openMainMaterialPage();
        driver.findElement(By.xpath(String.format(oneSectionLocator, firstSection))).click();
        timer.wait(() -> driver.findElement(By.xpath(sectionTitle)).isDisplayed());
    }

    public static void openSection(String firstSection, String secondSection) {
        openMainMaterialPage();
        driver.findElement(By.xpath(String.format(twoSectionLocator, firstSection))).click();
        timer.wait(() -> driver.findElement(By.xpath(String.format(twoSectionLocator, secondSection))).click());
        timer.wait(() -> driver.findElement(By.xpath(sectionTitle)));
    }
}
