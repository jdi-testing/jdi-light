package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AspectRatiosTestsData;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.aspectRatiosPage;
import static io.github.com.pages.AspectRatiosPage.aspectRatiosContainer;

public class AspectRatiosTests extends TestsInit {

    private final AspectRatiosTestsData aspectRatiosTestsData = new AspectRatiosTestsData();

    @BeforeClass
    public void before() {
        aspectRatiosPage.open();
        waitCondition(() -> aspectRatiosPage.isOpened());
        aspectRatiosPage.checkOpened();
    }

    @Test
    public void aspectRatioImageTests() {
        aspectRatiosTestsData.aspectRatiosTestData().forEach(
                dataObject -> {
                    getDriver().manage().window().setSize(new Dimension(dataObject.getWidth(), dataObject.getHeight()));
                    aspectRatiosContainer.has().ratio(16, 9);
                }
        );
    }

    @AfterClass
    public void after() {
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
    }

}
