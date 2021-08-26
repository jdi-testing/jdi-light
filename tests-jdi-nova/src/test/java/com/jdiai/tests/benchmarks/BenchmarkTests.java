package com.jdiai.tests.benchmarks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.gson.JsonObject;
import com.jdiai.TestInit;
import com.jdiai.jsproducer.Json;
import com.jdiai.testng.TestNGListener;
import com.jdiai.tests.benchmarks.test.data.Statistic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jdiai.JDI.$;
import static com.jdiai.JDI.driver;
import static com.jdiai.Pages.PERFORMANCE_PAGE;
import static com.jdiai.states.States.loggedInAt;
import static com.jdiai.states.States.logout;
import static com.jdiai.tests.benchmarks.PerfStatistic.testScenario;
import static com.jdiai.tools.FilterConditions.textEquals;
import static com.jdiai.tools.LinqUtils.ifSelect;
import static com.jdiai.tools.PrintUtils.print;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.repeat;

@Listeners(TestNGListener.class)
public class BenchmarkTests implements TestInit {
    final String atTop = "Zachary Hendrix";
    final String atBottom = "Yen Stevenson";
    final int index = 385;
    final int repeat = 1;
    List<Statistic> stats = new ArrayList<>();
    final int lightTestsCount = 200;
    final int heavyTestsCount = 10;

    @BeforeMethod
    public void before() {
        loggedInAt(PERFORMANCE_PAGE);;
    }

    @Test(invocationCount = repeat)
    public void getText() {
        stats.add(testScenario("getText",
            () -> driver().findElement(By.cssSelector("#users-table tr>th")).getText(),
            () -> $("#users-table tr>th").getText(),
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void multiLocator() {
        stats.add(testScenario("multiLocator",
            () -> driver().findElement(By.cssSelector("#users-table"))
                .findElement(By.xpath(".//tr[2]"))
                .findElement(By.tagName("td")).getText(),
            () -> $("#users-table", ".//tr[2]", "td").getText(),
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void getAllAttributes() {
        stats.add(testScenario("getAllAttributes", () -> {
            WebElement element = driver().findElement(By.cssSelector(".sidebar-tooltip"));
            String dt = element.getAttribute("data-toggle");
            String dp = element.getAttribute("data-placement");
            String title = element.getAttribute("title");
            String cl = element.getAttribute("class");
            return "data-toggle:"+dt+",data-placement:"+dp+",title:"+title+",class:"+cl;
        },
        () -> $(".sidebar-tooltip").allAttributes().toString(),
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void getMultiData() {
        stats.add(testScenario("getMultiData", () -> {
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
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void multiElements() {
        stats.add(testScenario("multiElements", () -> {
            WebElement element = driver().findElement(By.xpath("//*[@id='users-table']//tr[2]"));
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                result.add(element.findElement(By.xpath(".//td[" + i + "]")).getText());
            }
            return result;
        }, () -> {
            JsonObject jo = $("//*[@id='users-table']//tr[2]").getJSObject(
            "{ '1': xpath(element, 'td[1]').innerText, '2': xpath(element, 'td[2]').innerText, " +
                "'3': xpath(element, 'td[3]').innerText, '4': xpath(element, 'td[4]').innerText }");
                return asList(jo.get("1").getAsString(), jo.get("2").getAsString(), jo.get("3").getAsString(), jo.get("4").getAsString());
        },
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void listGetValuesTest() {
        stats.add(testScenario("listGetValuesTest", () -> {
            List<WebElement> elements = driver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> $("#users-table tr>td:first-child").values(),
        heavyTestsCount));
    }

    @Test(invocationCount = repeat)
    public void getValueByIndexTest() {
        stats.add(testScenario("getValueByIndexTest",
            () -> driver().findElements(By.cssSelector("#users-table tr"))
                .get(index).findElement(By.xpath(".//td[3]")).getText(),
            () -> $("#users-table tr").get(index).find("td").get(2).getText(),
        lightTestsCount));
    }

    @Test(invocationCount = repeat)
    public void getValueByNameTopTest() {
        stats.add(testScenario("getValueByNameTopTest", () -> {
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
        heavyTestsCount));
    }

    @Test(invocationCount = repeat)
    public void getValueByNameBottomTest() {
        stats.add(testScenario("getValueByNameBottomTest", () -> {
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
        heavyTestsCount));
    }

    @Test(invocationCount = repeat)
    public void scenarioJdiSeleniumTest() {
        stats.add(testScenario("scenarioJdiSeleniumTest",
            () -> logout(),
            "Selenium",
            () -> { try { new SeleniumTests().simpleSearchTest(); return true; } catch (Exception ex) { return false; } },
            "JDI Nova",
            () -> { try { new JDINovaTests().simpleSearchTest(); return true; } catch (Exception ex) { return false; } },
            heavyTestsCount*2));
    }

    @Test(invocationCount = repeat)
    public void scenarioJdiSelenideTest() {
        Configuration.headless = true;
        stats.add(testScenario("scenarioJdiSelenideTest",
            () -> { logout(); Selenide.clearBrowserCookies(); },
            "Selenide",
            () -> { try { new SelenideTests().simpleSearchTest(); return true; } catch (Exception ex) { return false; } },
            "JDI Nova",
            () -> { try { new JDINovaTests().simpleSearchTest(); return true; } catch (Exception ex) { return false; } },
            heavyTestsCount));
    }

    @Test(invocationCount = repeat)
    public void scenarioAllJdiSeleniumTest() {
        Configuration.headless = true;
        stats.add(testScenario("scenarioAllJdiSeleniumTest",
            () -> logout(),
            "Selenium",
            () -> { try { new SeleniumTests().simpleAllSearchTest(); return true; } catch (Exception ex) { return false; } },
            "JDI Nova",
            () -> { try { new JDINovaTests().simpleAllOrderedSearchTest(); return true; } catch (Exception ex) { return false; } },
            heavyTestsCount));
    }

    @Test(invocationCount = repeat)
    public void scenarioAllJdiSelenideTest() {
        Configuration.headless = true;
        stats.add(testScenario("scenarioAllJdiSelenideTest",
            () -> { logout(); Selenide.clearBrowserCookies(); },
            "Selenide",
            () -> { try { new SelenideTests().simpleAllSearchTest(); return true; } catch (Exception ex) { return false; } },
            "JDI Nova",
            () -> { try { new JDINovaTests().simpleAllOrderedSearchTest(); return true; } catch (Exception ex) { return false; } },
            heavyTestsCount));
    }

    @AfterClass
    public void afterClass() {
        String statistic = printStatistic("Selenium") +
            repeat(' ', 83) + "\n" +
            printStatistic("Selenide");
        System.out.println(statistic);
    }
    protected String printStatistic(String framework) {
        String statistic = repeat('-', 83) + "\n" +
            format("| %-26s |", "Scenario") +
            format("| %-8s |", framework) +
            format(" %-8s |", "JDI Nova") +
            format(" %-9s |", "Faster in") +
            format(" %-15s |\n", "[min, max]");
        return statistic + print(ifSelect(stats, s -> s.framework1.equals(framework), s ->
            format("| %-26s |", s.scenario) +
            format("| %-8s |", s.stat1) +
            format(" %-8s |", s.stat2) +
            format(" %-9s |", s.ratio) +
            format(" %-15s |\n", s.additionalInfo)
        ), "") + repeat('-', 83) + "\n";
    }
}
