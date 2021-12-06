package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.utils.enums.TypographyStyles;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.BODY_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.BODY_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.BUTTON;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.CAPTION;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_3;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_4;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_5;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.HEAD_6;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.OVERLINE;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.SUBTITLE_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyStyles.SUBTITLE_2;
import static io.github.com.StaticSite.typographyPage;
import static io.github.com.pages.displaydata.TypographyPage.typographyTexts;
import static org.hamcrest.Matchers.equalTo;

public class TypographyTests extends TestsInit {

    @BeforeMethod
    public void before() {
        typographyPage.open();
        typographyPage.checkOpened();
    }

    @Test
    public void typographyTextsTest() {
        typographyTexts.get(1).has().text("Head 1");

        List<String> expectedText = Arrays.asList(
                "Head 1", "Head 2", "Head 3", "Head 4", "Head 5", "Head 6",
                "Subtitle 1", "Subtitle 2", "Body 1", "Body 2",
                "BUTTON TEXT", "Caption text", "OVERLINE TEXT");

        List<String> actualTexts = typographyTexts.stream()
                .map(IsText::getText)
                .collect(Collectors.toList());

        jdiAssert(actualTexts, equalTo(expectedText));
    }

    @Test
    public void typographyStylesTest() {
        typographyTexts.get(1).has().style(HEAD_1);

        List<TypographyStyles> expectedStyles = Arrays.asList(
                HEAD_1, HEAD_2, HEAD_3, HEAD_4, HEAD_5, HEAD_6,
                SUBTITLE_1, SUBTITLE_2, BODY_1, BODY_2,
                BUTTON, CAPTION, OVERLINE);

        List<TypographyStyles> actualStyles = typographyTexts.stream()
                .map(Typography::getStyle)
                .collect(Collectors.toList());

        jdiAssert(actualStyles, equalTo(expectedStyles));
    }
}
