package io.github.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MaterialNavigator {
    private static String url = "https://jdi-testing.github.io/jdi-light/material/";
    private static WebDriver driver = getDriver();

    public static void openMainMaterialPage() {
        driver.navigate().to(url);
    }


    public static void openSection(String firstSection) {
        openMainMaterialPage();
        driver.findElement(By.xpath("//div[@class='MuiList-root']//span[text()='"+firstSection+"']")).click();
    }

    public static void openSection(String firstSection, String secondSection) {
        openMainMaterialPage();
        driver.findElement(By.xpath("//div[@class='MuiListItemText-root']//span[text()='"+firstSection+"']")).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MuiListItemText-root']//span[text()='"+secondSection+"']"))).click();
    }
}
