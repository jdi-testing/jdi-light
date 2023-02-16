package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.TextAreaPage.blueTextArea;
import static io.github.com.pages.TextAreaPage.fourRowsTextArea;
import static io.github.com.pages.TextAreaPage.greyTextArea;
import static io.github.com.pages.TextAreaPage.oneRowTextArea;
import static io.github.com.pages.TextAreaPage.threeRowsTextArea;
import static io.github.com.pages.TextAreaPage.twoRowsTextArea;
import static io.github.com.pages.TextAreaPage.yellowTextArea;

public class TextAreasDataProviders {
    @DataProvider
    public static Object[][] textAreasWithColor() {
        return new Object[][]{
                {blueTextArea, "rgba(3, 169, 244, 1)"},
                {greyTextArea, "rgba(224, 224, 224, 1)"},
                {yellowTextArea, "rgba(255, 236, 179, 1)"}
        };
    }

    @DataProvider
    public static Object[][] rowTextAreaTestDataProvider() {
        return new Object[][] {
                {oneRowTextArea, 1},
                {twoRowsTextArea, 2},
                {threeRowsTextArea, 3},
                {fourRowsTextArea, 4}
        };
    }
}
