package io.github.epam.html.tests.performance;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import io.github.epam.TestsInit;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.PerformancePage.*;
import static io.github.epam.html.tests.performance.PerfStatistic.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ListTests implements TestsInit {
    final String value = "Yen Stevenson";
    final int index = 385;
    final int repeat = 1;
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        performancePage.shouldBeOpened();
    }

    @Test(invocationCount = repeat)
    public void getValuesTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> firstRow.getValuesFast(), 0.8, 10);
    }
    @Test(invocationCount = repeat)
    public void getValuesValueTest() {
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
        elements.stream().map(WebElement::getText).collect(Collectors.toList());
        firstRow.values();

        testScenario(() -> elements.stream().filter(
            el -> el.getText().equals(value)).findFirst().get().getText(),
            () -> firstRow.get(value).getText(), 70, 10);
    }
    @Test(invocationCount = repeat)
    public void getValueTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().filter(el -> el.getText().equals(value)).findFirst().get().getText();
        }, () -> firstTemplate.get(value).getText(), 90, 10);
    }
    @Test(invocationCount = repeat)
    public void getIndexTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.get(index).getText();
        }, () -> firstXpath.get(index).getText(), 0.9, 100);
    }

    private <T> void testScenario(JFunc<T> seleniumAction, JFunc<T> jdiAction, double expectedRatio, int count) {
        StartStatistic();
        for (int i = 0; i < count; i++) {
            Timer t = new Timer();
            T seleniumResult = seleniumAction.execute();
            long seleniumTime = t.timePassedInMSec();
            addStatistic("Selenium", seleniumTime);

            t = new Timer();
            T jdiResult = jdiAction.execute();
            long jdiTime = t.timePassedInMSec();
            addStatistic("Jdi", jdiTime);
            System.out.println("Ratio: "+(double)seleniumTime/jdiTime);
            assertThat(seleniumResult, equalTo(jdiResult));
        }
        double avSelenium = getAverage("Selenium");
        double avJdi = getAverage("Jdi");
        System.out.println("Average Selenium: " + avSelenium);
        System.out.println("Average Jdi: " + avJdi);
        System.out.println("Average Ratio: "+avSelenium/avJdi);
        assertThat(avSelenium, greaterThan(avJdi*expectedRatio));
    }
}
