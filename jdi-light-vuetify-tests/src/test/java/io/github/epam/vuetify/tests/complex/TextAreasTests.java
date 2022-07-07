package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import io.github.com.dataproviders.TextAreasDataProviders;
import io.github.com.entities.textareas.SignUpData;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.StaticSite.textareasPage;
import static io.github.com.custom.forms.textareas.SignUpForm.submit;
import static io.github.com.pages.TextAreaPage.autoGrowTextArea;
import static io.github.com.pages.TextAreaPage.clearableTextArea;
import static io.github.com.pages.TextAreaPage.counterTextArea;
import static io.github.com.pages.TextAreaPage.fourRowsTextArea;
import static io.github.com.pages.TextAreaPage.noResizeTextArea;
import static io.github.com.pages.TextAreaPage.oneRowTextArea;
import static io.github.com.pages.TextAreaPage.signUpForm;
import static io.github.com.pages.TextAreaPage.threeRowsTextArea;
import static io.github.com.pages.TextAreaPage.twoRowsTextArea;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class TextAreasTests extends TestsInit {

    private static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
            "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
            "exercitation ullamco laboris nisi ut aliquipex ea commodo consequat.";

    @BeforeClass
    public void before() {
        textareasPage.open();
        waitCondition(() -> textareasPage.isOpened());
        textareasPage.checkOpened();
    }

    @Test
    public void autoGrowTextAreaTest() {
        autoGrowTextArea.is().autoGrow();
        autoGrowTextArea.is().notResizable();
        autoGrowTextArea.is().filled();
        autoGrowTextArea.has().lines("The Woodman set to work at once, and so " +
                "sharp was his axe that the tree was soon chopped nearly through.");
        autoGrowTextArea.label().is().displayed();
        autoGrowTextArea.label().has().text("Label");
        autoGrowTextArea.has().height(is(120));
        autoGrowTextArea.setLines(" 1 row", "2 row", "3 row", "4 row");
        autoGrowTextArea.has().height(is(120))
                .and().has().rowsCount(5);
        autoGrowTextArea.addNewLine("5 row");
        autoGrowTextArea.has().height(is(140));
    }

    @Test
    public void clearableTextAreaTest() {
        clearableTextArea.label().has().text("Text");
        clearableTextArea.has().text("This is clearable text.");
        clearableTextArea.appendInner().click();
        clearableTextArea.has().text(emptyString());
        clearableTextArea.setText("Set text for clearing");
        clearableTextArea.appendInner().click();
        clearableTextArea.has().text(emptyString());
    }

    @Test
    public void counterTextAreaTest() {
        counterTextArea.label().has().text("Text");
        counterTextArea.has().text("Hello!");
        counterTextArea.counter().has().text("6");
        counterTextArea.counter().has().css("color", "rgba(0, 0, 0, 0.6)");
        counterTextArea.sendKeys("This is text for 25");
        counterTextArea.counter().has().text("25");
        counterTextArea.counter().has().css("color", "rgba(0, 0, 0, 0.6)");
        counterTextArea.sendKeys("-");
        counterTextArea.message().has().text("Max 25 characters");
        counterTextArea.message().has().css("color", RED_ACCENT_2.toString());
        counterTextArea.counter().has().text("26");
        counterTextArea.counter().has().css("color", RED_ACCENT_2.toString());
        counterTextArea.label().has().css("color", RED_ACCENT_2.toString());
        counterTextArea.clear();
        counterTextArea.counter().has().text("0");
    }

    @Test
    public void noResizeTextAreaTest() {
        noResizeTextArea.label().has().text("Text");
        noResizeTextArea.has().text(LOREM_IPSUM_TEXT);
        noResizeTextArea.is().notResizable();
        noResizeTextArea.has().height(is(32));
        noResizeTextArea.addNewLine(LOREM_IPSUM_TEXT + LOREM_IPSUM_TEXT);
        noResizeTextArea.has().height(is(32));
        noResizeTextArea.has().lines(LOREM_IPSUM_TEXT, LOREM_IPSUM_TEXT + LOREM_IPSUM_TEXT);
    }



    @Test (dataProvider = "rowTextAreaTestDataProvider", dataProviderClass = TextAreasDataProviders.class)
    public void rowTextAreaTest(TextArea rowTextArea, String labelText, int rowsCount, boolean isFilled) {
        rowTextArea.label().has().text(labelText);
        rowTextArea.has().rowsCount(rowsCount);
        if (isFilled) {
            rowTextArea.is().filled();
        }
        else {
            rowTextArea.is().outlined();
        }
    }

    @Test(dataProvider = "signUpDataProvider", dataProviderClass = TextAreasDataProviders.class)
    public void signUpFormTest(SignUpData signUpData, boolean correct) {
        signUpForm.fill(signUpData);
        if (correct) {
            submit.is().enabled();
        } else {
            submit.is().disabled();
        }
    }
}
