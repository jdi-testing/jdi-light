package org.jdiai.tests.jsdriver.benchmarks;

import org.jdiai.tests.jsdriver.TestInit;
import org.jdiai.tools.JS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.jdiai.tests.jsdriver.benchmarks.PerfStatistic.testScenario;
import static org.jdiai.tests.jsdriver.states.States.atPerformancePage;
import static org.jdiai.tools.JSTalk.$;
import static org.jdiai.tools.JSTalk.driver;

public class JSTests extends TestInit {
    final String value = "Yen Stevenson";
    final int index = 385;
    final int repeat = 1;

    @BeforeMethod
    public void before() {
        atPerformancePage();
    }

    @Test(invocationCount = repeat)
    public void getValuesTest() {
        JS userTable = $("#users-table");
        testScenario(() -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> userTable.find("tr>td:first-child").js.getAttributeList("innerText"), 30);
    }
    @Test(invocationCount = repeat)
    public void getText() {
        testScenario(
            () -> driver().findElement(By.cssSelector("#users-table tr>th")).getText(),
            () -> $("#users-table tr>th").getText(),
            500);
    }
    // @Test(invocationCount = repeat)
    // public void getValuesValueTest() {
    //     JS userTable = $("#users-table");
    //     List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
    //     elements.stream().map(WebElement::getText).collect(Collectors.toList());
    //     testScenario(() -> elements.stream().filter(
    //         el -> el.getText().equals(value)).findFirst().get().getText(),
    //         () -> userTable.getJSResult("element."), 30);
    // }
    // @Test(invocationCount = repeat)
    // public void getValueTest() {
    //     testScenario(() -> {
    //         List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
    //         return elements.stream().filter(el -> el.getText().equals(value)).findFirst().get().getText();
    //     }, () -> firstTemplate.get(value).getText(), 10);
    // }
    // @Test(invocationCount = repeat)
    // public void getIndexTest() {
    //     testScenario(() -> {
    //         List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
    //         return elements.get(index).getText();
    //     }, () -> firstXpath.get(index+1).getText(), 100);
    // }
}
