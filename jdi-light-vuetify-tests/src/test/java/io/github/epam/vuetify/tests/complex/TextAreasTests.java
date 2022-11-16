package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import io.github.com.dataproviders.TextAreasDataProviders;
import io.github.com.entities.textareas.SignUpData;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.textareasPage;
import static io.github.com.custom.forms.textareas.SignUpForm.submit;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.pages.TextAreaPage.appendInnerTextArea;
import static io.github.com.pages.TextAreaPage.appendOuterTextArea;
import static io.github.com.pages.TextAreaPage.autoGrowTextArea;
import static io.github.com.pages.TextAreaPage.autocompleteTextArea;
import static io.github.com.pages.TextAreaPage.blueTextArea;
import static io.github.com.pages.TextAreaPage.clearableTextArea;
import static io.github.com.pages.TextAreaPage.counterTextArea;
import static io.github.com.pages.TextAreaPage.disabledTextArea;
import static io.github.com.pages.TextAreaPage.greyTextArea;
import static io.github.com.pages.TextAreaPage.loadingTextArea;
import static io.github.com.pages.TextAreaPage.noResizeTextArea;
import static io.github.com.pages.TextAreaPage.prefixTextArea;
import static io.github.com.pages.TextAreaPage.prependInnerTextArea;
import static io.github.com.pages.TextAreaPage.prependOuterTextArea;
import static io.github.com.pages.TextAreaPage.readonlyTextArea;
import static io.github.com.pages.TextAreaPage.signUpForm;
import static io.github.com.pages.TextAreaPage.suffixTextArea;
import static io.github.com.pages.TextAreaPage.threeRowsTextArea;
import static io.github.com.pages.TextAreaPage.twoRowsTextArea;
import static io.github.com.pages.TextAreaPage.yellowTextArea;
import static org.hamcrest.Matchers.is;

public class TextAreasTests extends TestsInit {

    private static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, consectetur "
            + "adipiscing elit, sed do eiusmod tempor incididunt ut labore et "
            + "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud "
            + "exercitation ullamco laboris nisi ut aliquipex ea commodo consequat.";

    @BeforeClass
    public void before() {
        textareasPage.open();
        waitCondition(() -> textareasPage.isOpened());
        textareasPage.checkOpened();
    }

    @Test
    public void autoGrowHeightTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.is().autoGrow();
        autoGrowTextArea.has().lines("The Woodman set to work at once, and so "
                + "sharp was his axe that the tree was soon chopped nearly through.");
        autoGrowTextArea.has().height(120);
        autoGrowTextArea.setLines(" 1 row", "2 row", "3 row", "4 row");
        autoGrowTextArea.has().height(120)
                .and().has().rowsCount(5);
        autoGrowTextArea.addNewLine("5 row");
        autoGrowTextArea.has().height(is(140));
        blueTextArea.is().notAutoGrow();
    }

    @Test
    public void notResizableTextAreaTest() {
        noResizeTextArea.show();
        noResizeTextArea.is().notResizable();
        noResizeTextArea.has().height(is(32));
        noResizeTextArea.addNewLine(LOREM_IPSUM_TEXT + LOREM_IPSUM_TEXT);
        noResizeTextArea.has().height(is(32));
        noResizeTextArea.has().lines(LOREM_IPSUM_TEXT, LOREM_IPSUM_TEXT + LOREM_IPSUM_TEXT);
        blueTextArea.show();
        blueTextArea.is().resizable();
    }

    @Test
    public void colorTextAreaTest() {
        blueTextArea.show();
        blueTextArea.has().backgroundColor(LIGHT_BLUE.value());
        blueTextArea.has().color(BLACK_TRANSPARENT_087.value());
    }
    @Test
    public void filledTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.is().filled();
        autocompleteTextArea.show();
        autocompleteTextArea.is().notFilled();
    }

    @Test
    public void labelTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.has().hasLabel();
        autoGrowTextArea.label().has().text("Label");
    }

    @Test
    public void clearableTextAreaTest() {
        clearableTextArea.show();
        clearableTextArea.is().clearable();
        clearableTextArea.clear();
    }

    @Test
    public void counterTextAreaTest() {
        counterTextArea.show();
        counterTextArea.has().text("Hello!");
        counterTextArea.has().counterValue(6);
        counterTextArea.clear();
        counterTextArea.has().counterValue(0);
    }

    @Test
    public void sendKeysTextAreaTest() {
        String text = "Some text";
        counterTextArea.show();
        counterTextArea.clear();
        counterTextArea.sendKeys(text);
        counterTextArea.has().text(text);
    }

    @Test (dataProvider = "rowTextAreaTestDataProvider", dataProviderClass = TextAreasDataProviders.class)
    public void rowCountTextAreaTest(TextArea rowTextArea, int rowsCount) {
        rowTextArea.show();
        rowTextArea.has().rowsCount(rowsCount);
    }

    @Test
    public void messagesTextAreaTest() {
        blueTextArea.show();
        blueTextArea.has().messagesCount(1);
        blueTextArea.has().messageText("Message");
        blueTextArea.has().noErrorMessages();
        blueTextArea.has().noSuccessMessages();
        greyTextArea.show();
        greyTextArea.has().errorMessages();
        greyTextArea.has().errorMessagesCount(1);
        greyTextArea.has().errorMessages(Collections.singletonList("Error message"));
        greyTextArea.has().errorMessage("Error message");
        yellowTextArea.show();
        yellowTextArea.has().successMessages();
        yellowTextArea.has().successMessagesCount(1);
        yellowTextArea.has().successMessages(Collections.singletonList("Success message"));
        yellowTextArea.has().successMessage("Success message");
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

    @Test
    public void suffixPrefixTextAreaTest() {
        suffixTextArea.show();
        suffixTextArea.has().suffix();
        suffixTextArea.has().suffixText("Suffix");
        prefixTextArea.has().notSuffix();
        prefixTextArea.has().prefix();
        prefixTextArea.has().prefixText("Prefix");
        suffixTextArea.has().notPrefix();
    }

    @Test
    public void iconTextAreaTest() {
        prependOuterTextArea.show();
        prependOuterTextArea.has().icon();
        prependOuterTextArea.has().prependOuterIcon();
        prependInnerTextArea.show();
        prependInnerTextArea.has().prependInnerIcon();
        appendOuterTextArea.show();
        appendOuterTextArea.has().appendOuterIcon();
        appendInnerTextArea.show();
        appendInnerTextArea.has().appendInnerIcon();
        noResizeTextArea.show();
        noResizeTextArea.has().notIcon();
    }

    @Test
    public void placeholderTextAreaTest() {
        suffixTextArea.show();
        suffixTextArea.has().placeholder();
        suffixTextArea.has().placeholderText("Placeholder");
        prefixTextArea.has().notPlaceholder();
    }

    @Test
    public void themeTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.has().darkTheme();
        blueTextArea.has().lightTheme();
    }

    @Test
    public void autofocusTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.is().autofocus();
        blueTextArea.is().notAutofocus();
    }

    @Test
    public void denseTextAreaTest() {
        autoGrowTextArea.show();
        autoGrowTextArea.is().dense();
        blueTextArea.is().notDense();
    }

    @Test
    public void flatTextAreaTest() {
        suffixTextArea.show();
        suffixTextArea.is().flat();
        noResizeTextArea.show();
        noResizeTextArea.is().notFlat();
    }

    @Test
    public void singleLineTextAreaTest() {
        disabledTextArea.show();
        disabledTextArea.is().singleLine();
        readonlyTextArea.show();
        readonlyTextArea.is().notSingleLine();
    }

    @Test
    public void reversedTextAreaTest() {
        disabledTextArea.show();
        disabledTextArea.is().reversed();
        readonlyTextArea.show();
        readonlyTextArea.is().notReversed();
    }

    @Test
    public void roundedTextAreaTest() {
        disabledTextArea.show();
        disabledTextArea.is().rounded();
        readonlyTextArea.show();
        readonlyTextArea.is().notRounded();
    }

    @Test
    public void fullWidthTextAreaTest() {
        disabledTextArea.show();
        disabledTextArea.is().fullWidth();
        readonlyTextArea.show();
        readonlyTextArea.is().notFullWidth();
    }

    @Test
    public void detailsHiddenTextAreaTest() {
        readonlyTextArea.show();
        readonlyTextArea.is().detailsHidden();
        disabledTextArea.show();
        disabledTextArea.is().notDetailsHidden();
    }

    @Test
    public void shapedTextAreaTest() {
        threeRowsTextArea.show();
        threeRowsTextArea.is().shaped();
        twoRowsTextArea.show();
        twoRowsTextArea.is().notShaped();
    }

    @Test
    public void soloTextAreaTest() {
        prefixTextArea.show();
        prefixTextArea.is().solo();
        loadingTextArea.show();
        loadingTextArea.is().notSolo();
    }

    @Test
    public void soloInvertedTextAreaTest() {
        prefixTextArea.show();
        prefixTextArea.is().soloInverted();
        loadingTextArea.show();
        loadingTextArea.is().notSoloInverted();
    }

    @Test
    public void loadingTextAreaTest() {
        loadingTextArea.show();
        loadingTextArea.is().loading();
        loadingTextArea.has().loaderHeightPx(10);
        prefixTextArea.show();
        prefixTextArea.is().loaded();
    }

    @Test
    public void disabledTextAreaTest() {
        disabledTextArea.show();
        disabledTextArea.is().disabled();
        readonlyTextArea.show();
        readonlyTextArea.is().notDisabled();
    }

    @Test
    public void readonlyTextAreaTest() {
        readonlyTextArea.show();
        readonlyTextArea.is().readonly();
        disabledTextArea.show();
        disabledTextArea.is().notReadonly();
    }
}
