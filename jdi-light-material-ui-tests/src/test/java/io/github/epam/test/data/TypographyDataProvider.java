package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.BODY_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.BODY_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.BUTTON;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.CAPTION;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_2;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_3;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_4;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_5;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.HEAD_6;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.OVERLINE;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.SUBTITLE_1;
import static com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle.SUBTITLE_2;

public class TypographyDataProvider {

    @DataProvider
    public Object[][] typographyTestData() {
        return new Object[][]{
                {1, "Head 1", HEAD_1},
                {2, "Head 2", HEAD_2},
                {3, "Head 3", HEAD_3},
                {4, "Head 4", HEAD_4},
                {5, "Head 5", HEAD_5},
                {6, "Head 6", HEAD_6},
                {7, "Subtitle 1", SUBTITLE_1},
                {8, "Subtitle 2", SUBTITLE_2},
                {9, "Body 1", BODY_1},
                {10, "Body 2", BODY_2},
                {11, "BUTTON TEXT", BUTTON},
                {12, "Caption text", CAPTION},
                {13, "OVERLINE TEXT", OVERLINE}
        };
    }
}
