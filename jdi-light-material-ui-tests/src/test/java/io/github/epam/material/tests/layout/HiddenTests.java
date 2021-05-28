package io.github.epam.material.tests.layout;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.hiddenPage;
import static io.github.com.pages.layout.HiddenPage.*;

public class HiddenTests extends TestsInit {

    private static final int WIDTH_LABEL_LENGHT = 15;

    @BeforeMethod
    public void before() {
        hiddenPage.open();
    }

    @Test
    public void defaultHiddenTest() {
        currentWidth.is().displayed();
        xsDown.is().displayed();
        smDown.is().displayed();
        mdDown.is().displayed();

        String width = getWidth(currentWidth);
        checkWidth(width);

        setHalfScreenWidthSize();
        width = getWidth(currentWidth);
        checkWidth(width);
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

    private void setHalfScreenWidthSize(){
        Dimension xy = WebDriverFactory.getDriver().manage().window().getSize();
        Dimension xy2 = new Dimension(xy.width / 2, xy.height );
        WebDriverFactory.getDriver().manage().window().setSize(xy2);
    }

    private String getWidth(Text element) {
        String text = element.getText();
        return text.substring(WIDTH_LABEL_LENGHT);
    }
}
