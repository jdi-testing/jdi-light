package io.github.epam.material.tests.layout;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.hiddenPage;
import static io.github.com.pages.layout.HiddenPage.currentWidth;
import static io.github.com.pages.layout.HiddenPage.papers;

/**
 * To see an example of Hidden web element please visit
 * https://material-ui.com/components/hidden/
 */
public class HiddenTests extends TestsInit {

    @BeforeMethod
    public void before() {
        hiddenPage.open();
        hiddenPage.isOpened();
    }

    @DataProvider(name = "Screen Width Dividers")
    public Object[][] screenWidthDividers() {
        return new Object[][]{
                { 600 + 13, 0, "xs"},
                { 600 + 14, 1, "sm"},
                { 960 + 13, 1, "sm"},
                { 960 + 14, 2, "md"},
                {1280 + 13, 2, "md"},
                {1280 + 14, 3, "lg"},
                {1920 + 13, 3, "lg"},
                {1920 + 14, 4, "xl"}};
    }//600 960 1280 1920

    @Test(dataProvider = "Screen Width Dividers")
    public void hiddenTestWithScreenWidthDifferentScreenWidth(int width, int size, String expectedWidth) {
        setWidth(width);
        jdiAssert(papers.size(), Matchers.equalTo(size));
        papers.forEach(element -> element.is().displayed());
        currentWidth.has().text("Current width: " + expectedWidth);
    }

    private void setWidth(int width) {
        Dimension currentScreenSize = WebDriverFactory.getDriver().manage().window().getSize();
        Dimension newScreenSize = new Dimension(width, currentScreenSize.getHeight());
        WebDriverFactory.getDriver().manage().window().setSize(newScreenSize);
    }

    @AfterMethod
    public void after() {
        WebDriverFactory.getDriver().manage().window().maximize();
        WebDriverFactory.getDriver().manage().window().fullscreen();
    }
}
