package io.github.epam.material.tests.layout;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.exception;
import static io.github.com.StaticSite.hiddenPage;
import static io.github.com.pages.layout.HiddenPage.*;

/**
 * To see an example of Hidden web element please visit
 * https://material-ui.com/components/hidden/
 */

public class HiddenTests extends TestsInit {

    private static final int WIDTH_LABEL_LENGHT = 15;

    @BeforeMethod
    public void before() {
        hiddenPage.open();
        hiddenPage.isOpened();
        WebDriverFactory.getDriver().manage().window().maximize();

    }

    @Test(dataProvider = "Screen Width Dividers")
    public void hiddenTestWithScreenWidthDifferentScreenWidth(int divider) {
        currentWidth.is().displayed();
        xsDown.is().displayed();
        smDown.is().displayed();
        mdDown.is().displayed();
        divideScreenWidthSize(divider);
        String width = getWidth(currentWidth);
        checkWidth(width);
    }

    @DataProvider(name = "Screen Width Dividers")
    public Object[][] screenWidthDividers() {
        return new Object[][]{{1}, {2}, {3}};
    }

    private void checkWidth(String width) {
        String[] widthArr = {"xs", "sm", "md", "lg", "xl"};
        Button[] hiddenArr = {xsDown, smDown, mdDown, lgDown, xlDown};
        int j = 0;
        for (int i = j; !width.equals(widthArr[i]); i++) {
            hiddenArr[i].is().displayed();
            j++;
        }
        for (int i = j; i < widthArr.length; i++) {
            hiddenArr[i].is().notVisible();
        }
    }

    private void divideScreenWidthSize(int divider) {
        Dimension lastScreenSize = WebDriverFactory.getDriver().manage().window().getSize();
        try {
            Dimension currentScreenSize = new Dimension(lastScreenSize.width / divider,
                    lastScreenSize.height);
            WebDriverFactory.getDriver().manage().window().setSize(currentScreenSize);
        } catch (ArithmeticException e) {
            throw exception("Wrong divider: " + divider);
        }
    }

    private String getWidth(Text element) {
        String text = element.getText();
        return text.substring(WIDTH_LABEL_LENGHT);
    }
}
