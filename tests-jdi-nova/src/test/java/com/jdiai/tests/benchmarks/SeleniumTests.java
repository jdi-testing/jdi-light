package com.jdiai.tests.benchmarks;

import com.jdiai.testng.TestNGListener;
import com.jdiai.tests.benchmarks.test.data.MarvelHero;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static com.jdiai.JDI.driver;
import static com.jdiai.tests.benchmarks.test.data.HeroesData.*;
import static com.jdiai.tests.benchmarks.test.data.HeroesData.HULK;
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

    @Test(enabled = false)
    public void simpleAllSearchTest() {
        driver().navigate().to("https://jdi-testing.github.io/jdi-light");
        driver().findElement(By.cssSelector("#user-icon")).click();
        driver().findElement(By.cssSelector("#name")).sendKeys("Roman");
        driver().findElement(By.cssSelector("#password")).sendKeys("Jdi1234");
        driver().findElement(By.cssSelector(".fa-sign-in")).click();

        driver().findElement(By.xpath("//*[contains(@class, 'sidebar-menu')]//*[text()='Service']")).click();
        driver().findElement(By.xpath("//*[contains(@class, 'sidebar-menu')]//*[text()='User Table']")).click();

        List<MarvelHero> allHeroes = asList(WOLVERINE, SPIDER_MAN, PUNISHER, CAPITAN_AMERICA, CYCLOPE, HULK);
        int i = 0;
        List<WebElement> userTableRow = driver().findElements(By.cssSelector("#user-table tbody tr"));
        for (WebElement element : userTableRow) {
            validate(element.findElements(By.cssSelector("td")), allHeroes.get(i++));
        }
    }

    private void validate(List<WebElement> row, MarvelHero expected) {
        String numberText = row.get(0).getText();
        int number = Integer.parseInt(numberText);
        String type = row.get(1).findElement(By.cssSelector("option[selected]")).getText();
        String name = row.get(2).findElement(By.tagName("a")).getText();
        String heroName = row.get(3).findElement(By.tagName("span")).getText();
        String img = row.get(3).findElement(By.tagName("img")).getAttribute("src");

        assertEquals(number, expected.number);
        assertEquals(type, expected.type);
        assertEquals(name, expected.name);
        assertEquals(heroName, expected.heroName);
        assertThat(img).contains(expected.img);
    }
}
