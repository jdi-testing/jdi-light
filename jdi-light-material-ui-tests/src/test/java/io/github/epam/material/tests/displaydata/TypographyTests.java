package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle;
import io.github.epam.TestsInit;
import io.github.epam.test.data.TypographyDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.typographyPage;
import static io.github.com.pages.displaydata.TypographyPage.typographyTexts;

public class TypographyTests extends TestsInit {

    @BeforeMethod
    public void before() {
        typographyPage.open();
        typographyPage.checkOpened();
    }

    @Test(dataProviderClass = TypographyDataProvider.class, dataProvider = "typographyTestData")
    public static void typographyTest(int number, String text, TypographyComponentStyle style) {
        typographyTexts.get(number).has().text(text).and().style(style);
    }
}
