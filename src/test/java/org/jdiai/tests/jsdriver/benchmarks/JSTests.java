package org.jdiai.tests.jsdriver.benchmarks;

import org.jdiai.jsproducer.Json;
import org.jdiai.tests.jsdriver.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.jdiai.tests.jsdriver.benchmarks.PerfStatistic.testScenario;
import static org.jdiai.tests.jsdriver.states.Pages.PERFORMANCE_PAGE;
import static org.jdiai.tests.jsdriver.states.States.loggedInAt;
import static org.jdiai.tools.Conditions.textEquals;
import static org.jdiai.tools.JSTalk.$;
import static org.jdiai.tools.JSTalk.driver;

public class JSTests extends TestInit {
    final String value = "Yen Stevenson";
    final int index = 385;
    final int repeat = 1;
    static String totalResult = "";

    @BeforeMethod
    public void before() {
        loggedInAt(PERFORMANCE_PAGE);;
    }

    @Test(invocationCount = repeat)
    public void getText() {
        totalResult += "getText: " + testScenario(
            () -> driver().findElement(By.cssSelector("#users-table tr>th")).getText(),
            () -> $("#users-table tr>th").getText(),
        200) + "\n";
    }

    @Test(invocationCount = repeat)
    public void multiLocator() {
        totalResult += "multiLocator: " + testScenario(
            () -> driver().findElement(By.cssSelector("#users-table"))
                .findElement(By.xpath(".//tr[2]"))
                .findElement(By.tagName("td")).getText(),
            () -> $("#users-table", ".//tr[2]", "td").getText(),
            200) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getAllAttributes() {
        totalResult += "getAllAttributes: " + testScenario(() -> {
            WebElement element = driver().findElement(By.cssSelector(".sidebar-tooltip"));
            String dt = element.getAttribute("data-toggle");
            String dp = element.getAttribute("data-placement");
            String title = element.getAttribute("title");
            String cl = element.getAttribute("class");
            return "data-toggle:"+dt+",data-placement:"+dp+",title:"+title+",class:"+cl;
        },
        () -> $(".sidebar-tooltip").getAllAttributes().toString(),
        200) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getMultiData() {
        totalResult += "getMultiData: " + testScenario(() -> {
            WebElement element = driver().findElement(By.cssSelector("#users-table"));
            String id = element.getAttribute("id");
            String ui = element.getAttribute("ui");
            String tag = element.getTagName().toUpperCase();
            String font = element.getCssValue("fontSize");
            String bgColor = element.getCssValue("backgroundColor");
            return "id:"+id+",ui:"+ui+",tag:"+tag+",font:"+font+",bg-color:"+bgColor;
        }, () -> {
            Json data = $("#users-table").getJson(
                "{ 'id': element.id, 'ui': element.getAttribute('ui'), 'tag': element.tagName, " +
                "'font': styles.fontSize, 'bg-color': styles.backgroundColor }");
            return data.toString();
        },
        200) + "\n";
    }
    @Test(invocationCount = repeat)
    public void listGetValuesTest() {
        totalResult += "listGetValuesTest: " + testScenario(() -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> $("#users-table tr>td:first-child").values(),
        30) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getValueByIndexTest() {
        totalResult += "getValueByNameTest: " + testScenario(
            () -> driver().findElements(By.cssSelector("#users-table tr"))
                .get(index).findElement(By.xpath(".//td[3]")).getText(),
            () -> $("#users-table tr").get(index).find("td").get(2).getText(),
        200) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getValueByNameTest() {
        totalResult += "getValueByNameTest: " + testScenario(() -> {
        List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr"));
        WebElement row = elements.stream().filter(el -> {
            WebElement td = null;
            boolean isExist = true;
            try {
                td = el.findElement(By.cssSelector("td:first-child"));
            } catch (Exception ex) { isExist = false; }
            return isExist && td.getText().equals(value);
        }).findFirst().get();
        return row.findElement(By.xpath(".//td[3]")).getText();
        }, () -> $("#users-table tr").findFirst("td", textEquals(value)).find(".//td[3]").getText(),
    30) + "\n";
    }

    @AfterClass
    public void afterClass() {
        System.out.println(totalResult);
    }
    // @Test(invocationCount = repeat)
    // public void getIndexTest() {
    //     testScenario(() -> {
    //         List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
    //         return elements.get(index).getText();
    //     }, () -> firstXpath.get(index+1).getText(), 100);
    // }
}
