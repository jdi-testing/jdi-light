package org.jdiai.tests.benchmarks;

import org.jdiai.TestInit;
import org.jdiai.jsproducer.Json;
import org.jdiai.testng.TestNGListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.jdiai.Pages.PERFORMANCE_PAGE;
import static org.jdiai.states.States.loggedInAt;
import static org.jdiai.tests.benchmarks.PerfStatistic.testScenario;
import static org.jdiai.tools.Conditions.textEquals;
import static org.jdiai.tools.JSTalk.$;
import static org.jdiai.tools.JSTalk.driver;

@Listeners(TestNGListener.class)
public class JSTests implements TestInit {
    final String atTop = "Zachary Hendrix";
    final String atBottom = "Yen Stevenson";
    final int index = 385;
    final int repeat = 1;
    static String totalResult = "";
    final int lightTestsCount = 100;
    final int heavyTestsCount = 10;

    @BeforeMethod
    public void before() {
        loggedInAt(PERFORMANCE_PAGE);;
    }

    @Test(invocationCount = repeat)
    public void getText() {
        totalResult += "getText: " + testScenario(
            () -> driver().findElement(By.cssSelector("#users-table tr>th")).getText(),
            () -> $("#users-table tr>th").getText(),
        lightTestsCount) + "\n";
    }

    @Test(invocationCount = repeat)
    public void multiLocator() {
        totalResult += "multiLocator: " + testScenario(
            () -> driver().findElement(By.cssSelector("#users-table"))
                .findElement(By.xpath(".//tr[2]"))
                .findElement(By.tagName("td")).getText(),
            () -> $("#users-table", ".//tr[2]", "td").getText(),
        lightTestsCount) + "\n";
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
        lightTestsCount) + "\n";
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
        lightTestsCount) + "\n";
    }
    @Test(invocationCount = repeat)
    public void listGetValuesTest() {
        totalResult += "listGetValuesTest: " + testScenario(() -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> $("#users-table tr>td:first-child").values(),
        heavyTestsCount) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getValueByIndexTest() {
        totalResult += "getValueByNameTest: " + testScenario(
            () -> driver().findElements(By.cssSelector("#users-table tr"))
                .get(index).findElement(By.xpath(".//td[3]")).getText(),
            () -> $("#users-table tr").get(index).find("td").get(2).getText(),
        lightTestsCount) + "\n";
    }
    @Test(invocationCount = repeat)
    public void getValueByNameTopTest() {
        totalResult += "getValueByNameTest: " + testScenario(() -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr"));
            WebElement row = elements.stream().filter(el -> {
                WebElement td = null;
                boolean isExist = true;
                try {
                    td = el.findElement(By.cssSelector("td:first-child"));
                } catch (Exception ex) { isExist = false; }
                return isExist && td.getText().equals(atTop);
            }).findFirst().get();
            return row.findElement(By.xpath(".//td[3]")).getText();
        }, () -> $("#users-table tr").findFirst("td", textEquals(atTop)).find(".//td[3]").getText(),
        heavyTestsCount) + "\n";
    }


    @Test(invocationCount = repeat)
    public void getValueByNameBottomTest() {
        totalResult += "getValueByNameTest: " + testScenario(() -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr"));
            WebElement row = elements.stream().filter(el -> {
                WebElement td = null;
                boolean isExist = true;
                try {
                    td = el.findElement(By.cssSelector("td:first-child"));
                } catch (Exception ex) { isExist = false; }
                return isExist && td.getText().equals(atBottom);
            }).findFirst().get();
            return row.findElement(By.xpath(".//td[3]")).getText();
        }, () -> $("#users-table tr").findFirst("td", textEquals(atBottom)).find(".//td[3]").getText(),
        heavyTestsCount) + "\n";
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
