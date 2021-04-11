package org.jdiai.tests.benchmarks;

import org.jdiai.testng.TestNGListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jdiai.JDI.driver;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class SeleniumTests {

    @Test(enabled = false)
    public void simpleSearchTest() {
        driver().navigate().to("https://jdi-testing.github.io/jdi-light");
        driver().findElement(By.cssSelector("#user-icon")).click();
        driver().findElement(By.cssSelector("#name")).sendKeys("Roman");
        driver().findElement(By.cssSelector("#password")).sendKeys("Jdi1234");
        driver().findElement(By.cssSelector(".fa-sign-in")).click();

        driver().findElement(By.xpath("//*[contains(@class, 'sidebar-menu')]//*[text()='Service']")).click();
        driver().findElement(By.xpath("//*[contains(@class, 'sidebar-menu')]//*[text()='User Table']")).click();

        String numberText = driver().findElement(By.xpath("//*[@id='user-table']//tr[2]//td[1]")).getText();
        int number = Integer.parseInt(numberText);
        String type = driver().findElement(By.xpath("//*[@id='user-table']//tr[2]//td[2]//option[@selected]")).getText();
        String name = driver().findElement(By.xpath("//*[@id='user-table']//tr[2]//td[3]//a")).getText();
        String heroName = driver().findElement(By.xpath("//*[@id='user-table']//tr[2]//td[4]//span")).getText();
        String img = driver().findElement(By.xpath("//*[@id='user-table']//tr[2]//td[4]//img")).getAttribute("src");

        assertEquals(number, 2);
        assertEquals(type, "User");
        assertEquals(name, "Sergey Ivan");
        assertEquals(heroName, "Spider Man");
        assertThat(img).contains("spider-man.jpg");
    }
}
