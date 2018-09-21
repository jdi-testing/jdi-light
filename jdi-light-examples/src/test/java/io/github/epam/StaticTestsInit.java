package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.InitActions;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Text;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import staticPageObject.StaticSite;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.searchBy;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static staticPageObject.StaticSite.homePage;

public class StaticTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        List<By> r;
        r = searchBy(By.xpath("//*[text()='test']"));
        r = searchBy(By.cssSelector(".user[2]"));
        r = searchBy(By.cssSelector(".product<div[title=test]>#name"));
        r = searchBy(By.cssSelector("['test']"));
        r = searchBy(By.cssSelector("['test text']"));
        r = searchBy(By.cssSelector("['test text']<.name[3]"));
        // Double
        r = searchBy(By.cssSelector(".user[2].user[1]"));
        r = searchBy(By.cssSelector(".product<<div[title=test]<#name"));
        r = searchBy(By.cssSelector("['test'].name['value']"));

        logger.setLogLevel(STEP);
        InitActions.INIT_RULES.add(f -> isInterface(f, Text.class), info -> new HtmlElement());
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        WebDriverFactory.close();
    }
}
