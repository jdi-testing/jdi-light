package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import io.github.com.dataproviders.TextAreasDataProviders;
import io.github.com.entities.textareas.SignUpData;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLACK_TRANSPARENT_087;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_ACCENT_2;
import static io.github.com.StaticSite.textareasPage;
import static io.github.com.custom.forms.textareas.SignUpForm.submit;
import static io.github.com.pages.TextareasPage.appendInnerTextArea;
import static io.github.com.pages.TextareasPage.appendOuterTextArea;
import static io.github.com.pages.TextareasPage.autoGrowTextArea;
import static io.github.com.pages.TextareasPage.autocompleteTextArea;
import static io.github.com.pages.TextareasPage.clearableTextArea;
import static io.github.com.pages.TextareasPage.counterTextArea;
import static io.github.com.pages.TextareasPage.fourRowsTextArea;
import static io.github.com.pages.TextareasPage.noResizeTextArea;
import static io.github.com.pages.TextareasPage.oneRowTextArea;
import static io.github.com.pages.TextareasPage.prependInnerTextArea;
import static io.github.com.pages.TextareasPage.prependOuterTextArea;
import static io.github.com.pages.TextareasPage.signUpForm;
import static io.github.com.pages.TextareasPage.threeRowsTextArea;
import static io.github.com.pages.TextareasPage.twoRowsTextArea;
import static org.hamcrest.Matchers.containsString;
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
        autoGrowTextArea.label().has().text(equalTo("Label"));
        autoGrowTextArea.has().height(is(120));
        autoGrowTextArea.setLines(" 1 row", "2 row", "3 row", "4 row");
        autoGrowTextArea.has().height(is(120));
        autoGrowTextArea.addNewLine("5 row");
        autoGrowTextArea.has().height(is(140));
    }

    @Test(dataProvider = "textAreasWithColor", dataProviderClass = TextAreasDataProviders.class)
    public void colorTextAreaTest(TextArea textArea, String backGround) {
        textArea.label().has().text("Label");
        textArea.has().text(emptyString());
        textArea.focus();
        textArea.has().backgroundColor(backGround);
        textArea.setText("Black text");
        textArea.textArea().has().css("color", BLACK_TRANSPARENT_087.toString());
        textArea.clear();
    }

    @Test
    public void browseAutoCompleteTextAreaTest() {
        autocompleteTextArea.label().has().text("Email");
        assertTrue(autocompleteTextArea.message().isNotExist());
        assertTrue(autocompleteTextArea.counter().isNotExist());
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
    public void prependOuterIconTextAreaTest() {
        prependOuterTextArea.label().has().text("prepend-icon");
        prependOuterTextArea.prependOuter().is().displayed();
        prependOuterTextArea.prependOuter().has().classValue(containsString("mdi-comment"));
    }

    @Test
    public void appendInnerIconTextAreaTest() {
        appendInnerTextArea.label().has().text("append-icon");
        appendInnerTextArea.appendInner().is().displayed();
        appendInnerTextArea.appendInner().has().classValue(containsString("mdi-comment"));
    }

    @Test
    public void prependInnerIconTextAreaTest() {
        prependInnerTextArea.label().has().text("prepend-inner-icon");
        prependInnerTextArea.prependInner().is().displayed();
        prependInnerTextArea.prependInner().has().classValue(containsString("mdi-comment"));
    }

    @Test
    public void appendOuterIconTextAreaTest() throws Exception {
        appendOuterTextArea.label().has().text("append-outer-icon");
        appendOuterTextArea.appendOuter().is().displayed();
        appendOuterTextArea.appendOuter().has().type("mdi-comment");
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

    @Test
    public void oneRowTextAreaTest() {
        oneRowTextArea.label().has().text("One row");
        oneRowTextArea.has().rowsCount(1);
        oneRowTextArea.is().outlined();
    }

    @Test
    public void twoRowsTextAreaTest() {
        twoRowsTextArea.label().has().text("Two rows");
        twoRowsTextArea.has().rowsCount(2);
        twoRowsTextArea.is().filled();
    }

    @Test
    public void threeRowsTextAreaTest() {
        threeRowsTextArea.label().has().text("Three rows");
        threeRowsTextArea.has().rowsCount(3);
        threeRowsTextArea.is().outlined();
    }

    @Test
    public void fourRowsTextAreaTest() {
        fourRowsTextArea.label().has().text("Four rows");
        fourRowsTextArea.has().rowsCount(4);
        fourRowsTextArea.is().filled();
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
