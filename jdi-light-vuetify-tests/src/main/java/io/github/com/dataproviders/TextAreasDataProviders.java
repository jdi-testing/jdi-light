package io.github.com.dataproviders;

import io.github.com.entities.textareas.SignUpData;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.TextareasPage.blueTextArea;
import static io.github.com.pages.TextareasPage.greenTextArea;
import static io.github.com.pages.TextareasPage.yellowTextArea;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class TextAreasDataProviders {

    protected final static SignUpData allCorrect = new SignUpData(
            "Ab2/cc",
            "1234",
            "correctmail@mail.com",
            asList("Start", "Middle", "End"),
            true
    );

    final static SignUpData allIncorrect = new SignUpData(
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
                {allCorrect, true},
                {allIncorrect, false}
        };
    }

}