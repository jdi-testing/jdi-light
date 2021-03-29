package io.github.com;

import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MaterialNavigator {
    private static String url = "https://jdi-testing.github.io/jdi-light/material/";
    public static void openMainMaterialPage() {
        getDriver().navigate().to(url);
    }


    public static void openSection(String firstSection) {
        openMainMaterialPage();
        getDriver().findElement(By.xpath("//div[@class='MuiList-root']//span[text()='"+firstSection+"']")).click();
    }

    public static void openSection(String firstSection, String secondSection) {
        openMainMaterialPage();
        getDriver().findElement(By.xpath("//div[@class='MuiListItemText-root']//span[text()='"+firstSection+"']")).click();
        getDriver().findElement(By.xpath("//div[@class='MuiListItemText-root']//span[text()='"+secondSection+"']")).click();
    }
}
