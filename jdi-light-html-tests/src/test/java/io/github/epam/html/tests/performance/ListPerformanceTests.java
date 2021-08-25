package io.github.epam.html.tests.performance;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static io.github.com.StaticSite.performancePage;
import static io.github.com.pages.PerformancePage.*;
import static io.github.epam.html.tests.performance.PerfStatistic.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static com.epam.jdi.tools.StringUtils.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ListPerformanceTests implements TestsInit {
    final String value = "Yen Stevenson";
    final int index = 385;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        performancePage.open();
    }

    @Test
    public void getValuesFastTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        }, () -> firstRow.getValuesFast(), 1, 1, 10);
    }
    @Test
    public void getValuesValueFastTest() {
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
        elements.stream().map(WebElement::getText).collect(Collectors.toList());
        firstRow.values();

        testScenario(() -> elements.stream().filter(
            el -> el.getText().equals(value)).findFirst().get().getText(),
            () -> firstRow.getFast(value).getText(), 100, 80, 10);
    }
    @Test
    public void getValueFastTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().filter(el -> el.getText().equals(value)).findFirst().get().getText();
        }, () -> firstTemplate.getFast(value).getText(), 100, 45, 10);
    }
    @Test
    public void getIndexFastTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.get(index).getText();
        }, () -> firstXpath.getFast(index + ELEMENT.startIndex).getText(), 1.5, 0.8, 100);
    }

    @Test
    public void getValuesTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList()).toString();
        }, () -> "[" + firstRowNoValidation.getValue().replace(",", ", ") + "]", 0.7, 235, 10);
    }
    @Test
    public void getValuesVisibleTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().map(WebElement::getText).collect(Collectors.toList()).toString();
        }, () -> "[" + firstRow.getValue().replace(",", ", ") + "]", 0.5, 235, 10);
    }
    @Test
    public void getValuesValueTest() {
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
        elements.stream().map(WebElement::getText).collect(Collectors.toList());
        firstRow.values();

        testScenario(() -> elements.stream().filter(
            el -> el.getText().equals(value)).findFirst().get().getText(),
            () -> firstRow.get(value).getText(), 65, 50, 10);
    }
    @Test
    public void getValueTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.stream().filter(el -> el.getText().equals(value)).findFirst().get().getText();
        }, () -> firstTemplate.get(value).getText(), 80, 40, 10);
    }
    @Test
    public void getIndexTest() {
        testScenario(() -> {
            List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector("#users-table tr>td:first-child"));
            return elements.get(index).getText();
        }, () -> firstXpath.get(index + ELEMENT.startIndex).getText(), 1, 0.6, 100);
    }


    private <T> void testScenario(JFunc<T> seleniumAction, JFunc<T> jdiAction, double expectedFirst, double expectedRatio, int count) {
        StartStatistic();
        double max = 0;
        double firstResult = 0;
        for (int i = 0; i < count; i++) {
            Timer t = new Timer();
            T seleniumResult = seleniumAction.execute();
            long seleniumTime = t.timePassedInMSec();
            if (i > 0)
                addStatistic("Selenium", seleniumTime);

            t = new Timer();
            T jdiResult = jdiAction.execute();
            long jdiTime = t.timePassedInMSec();
            if (i > 0)
                addStatistic("Jdi", jdiTime);
            double ratio = (double) seleniumTime / jdiTime;
            if (i == 0)
                firstResult = ratio;
            logger.info("Ratio: " + ratio);
            if (ratio > max)
                max = ratio;
            assertThat(seleniumResult, equalTo(jdiResult));
        }
        double avSelenium = getAverage("Selenium");
        double avJdi = getAverage("Jdi");
        logger.info("Average Selenium: %f ms", avSelenium);
        logger.info("Average Jdi: %f ms", avJdi);
        double ratio = avSelenium/avJdi;
        logger.info("Average ratio: %f", ratio);
        String goodBad = avSelenium/avJdi > 1 ? "better" : "worse";
        String goodBadMax = max > 1 ? "better" : "worse";
        if (ratio < 1) {
            ratio = 1 / ratio;
        }
        if (max < 1) {
            max = 1 / max;
        }
        String toLog = Math.abs(ratio - 1) < 0.1
            ? "First time result: " + firstResult + ". JDI has the same result in average as Selenium with max better in " + max + "times"
            : format("First time result: " + firstResult + ". JDI in average is %s than Selenium in %s times with maximum %s in %s times", goodBad, ratio, goodBadMax, max);
        logger.info(toLog);
        boolean validatePerformance = Boolean.parseBoolean(getProperty("validate.performance"));
        if (validatePerformance) {
            assertThat(format("Expected ratio: %s; but Actual: %s", expectedRatio, avJdi * expectedRatio),
                avSelenium, lessThan(avJdi * expectedRatio * 2));
            assertThat(format("Expected result: %s; but Actual: %s", expectedFirst, firstResult),
                firstResult, lessThan(expectedFirst * 2));
        }
    }
}
