package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.utils.enums.TypographyStyle;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.BODY_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.BODY_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.BUTTON;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.CAPTION;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_3;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_4;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_5;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.HEAD_6;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.OVERLINE;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.SUBTITLE_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyle.SUBTITLE_2;
import static io.github.com.StaticSite.typographyPage;
import static io.github.com.pages.displaydata.TypographyPage.typographyTexts;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TypographyTests extends TestsInit {

    @BeforeMethod
    public void before() {
        typographyPage.open();
        typographyPage.checkOpened();
    }

    @Test(dataProvider = "typographyTestData")
    public static void typographyTest(int number, String text, TypographyStyle style) {
        typographyTexts.get(number).has().text(text).and().style(style);
    }

    @DataProvider
    public Object[][] typographyTestData() {
        return new Object[][]{
                {1, "Head 1", HEAD_1}, {2, "Head 2", HEAD_2}, {3, "Head 3", HEAD_3}, {4, "Head 4", HEAD_4},
                {5, "Head 5", HEAD_5}, {6, "Head 6", HEAD_6}, {7, "Subtitle 1", SUBTITLE_1},
                {8, "Subtitle 2", SUBTITLE_2}, {9, "Body 1", BODY_1}, {10, "Body 2", BODY_2},
                {11, "BUTTON TEXT", BUTTON}, {12, "Caption text", CAPTION}, {13, "OVERLINE TEXT", OVERLINE}
        };
    }
}
