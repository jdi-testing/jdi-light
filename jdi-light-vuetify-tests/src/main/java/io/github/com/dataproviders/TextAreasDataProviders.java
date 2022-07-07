package io.github.com.dataproviders;

import io.github.com.entities.textareas.SignUpData;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.TextAreaPage.blueTextArea;
import static io.github.com.pages.TextAreaPage.greenTextArea;
import static io.github.com.pages.TextAreaPage.yellowTextArea;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class TextAreasDataProviders {

    static final SignUpData ALL_CORRECT = new SignUpData(
            "Ab2/cc",
            "1234",
            "correctmail@mail.com",
            asList("Start", "Middle", "End"),
            true
    );

    static final SignUpData ALL_INCORRECT = new SignUpData(
            "incorrect password",
            "not a phone",
            "not email",
            emptyList(),
            false
    );

    @DataProvider
    public static Object[][] textAreasWithColor() {
        return new Object[][]{
                {blueTextArea, "rgba(3, 169, 244, 1)"},
                {greenTextArea, "rgba(224, 224, 224, 1)"},
                {yellowTextArea, "rgba(255, 236, 179, 1)"}
        };
    }

    @DataProvider
    public static Object[][] signUpDataProvider() {
        return new Object[][]{
                {ALL_CORRECT, true},
                {ALL_INCORRECT, false}
        };
    }

}
