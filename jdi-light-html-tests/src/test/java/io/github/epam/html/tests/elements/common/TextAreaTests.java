package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledTextArea;
import static io.github.com.pages.HtmlElementsPage.textArea;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class TextAreaTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        textArea.clear();
    }
    String defaultText = "TextArea";

    @Test
    public void getTextTest() {
        textArea.setText(defaultText);
        assertEquals(textArea.getText(), defaultText);
    }

    @Test
    public void getValueTest() {
        textArea.setText(defaultText);
        assertEquals(textArea.getValue(), defaultText);
    }

    @Test
    public void sendKeysTest() {
        textArea.setText(defaultText);
        textArea.sendKeys("Test");
        assertEquals(textArea.getValue(), defaultText +"Test");
    }

    @Test
    public void setNullAsTextTest() {
        String value = textArea.getText();
        textArea.setText(null);
        textArea.has().text(value);
    }

    @Test
    public void setNullValueTest() {
        String value = textArea.getText();
        textArea.setValue(null);
        textArea.has().text(value);
    }

    @Test
    public void sendNullValueTest() {
        String value = textArea.getText();
        textArea.sendKeys(null);
        textArea.has().text(value);
    }

    @Test
    public void setFirstValueNullTest() {
        textArea.sendKeys(null, "Test");
        textArea.has().text("");
    }

    @Test
    public void inputTest() {
        textArea.setText(defaultText);
        textArea.input("New text");
        assertEquals(textArea.getText(), "New text");
    }

    @Test
    public void inputNullValueTest() {
        String value = textArea.getText();
        textArea.input(null);
        textArea.has().text(value);
    }

    @Test
    public void getLinesTest() {
        textArea.setLines("test 1", "test 2", "test 3");
        assertEquals(textArea.getLines(), asList("test 1", "test 2", "test 3"));
    }

    @Test
    public void clearTest() {
        textArea.setText(defaultText);
        textArea.clear();
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(textArea.placeholder(), "Input huge text");
    }

    @Test
    public void disabledTest() {
        disabledTextArea.setText(defaultText);
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void addNewLineTest() {
        textArea.setLines("line1", "line2");
        textArea.addNewLine("line3");
        assertEquals(textArea.getText(), "line1\nline2\nline3");
    }

    @Test
    public void setLinesTest() {
        textArea.setLines("line1", "line2");
        assertEquals(textArea.getText(), "line1\nline2");
    }

    @Test
    public void setSecondValueNullTest() {
        textArea.setLines("Line", null);
        textArea.has().text("Line\n");
    }

    @Test
    public void addLinesTest() {
        textArea.addNewLine("line1");
        textArea.addNewLine("line2");
        assertEquals(textArea.getText(), "line1\nline2");
    }

    @Test
    public void addNullAsNewLineTest() {
        String value = textArea.getText();
        textArea.addNewLine(null);
        textArea.has().text(value);
    }

    @Test
    public void addEmptyLineTest() {
        textArea.addNewLine("line1");
        textArea.addNewLine("");
        textArea.addNewLine("line2");
        assertEquals(textArea.getText(), "line1\n\nline2");
    }
    @Test
    public void focusTest() {
        textArea.focus();
    }

    @Test
    public void isValidationTest() {
        textArea.is().enabled();
        textArea.setText(defaultText);
        textArea.is().text(is(defaultText));
        textArea.is().text(containsString("Area"));
        disabledTextArea.is().disabled();
    }

    @Test
    public void labelTest() {
        assertEquals(textArea.labelText(), "Text example:");
        textArea.label().is().text(containsString("example"));
    }

    @Test
    public void assertValidationTest() {
        textArea.setText(defaultText);
        textArea.assertThat().text(is(defaultText));
    }

    @Test
    public void rowsTest() {
        assertEquals(textArea.rows(), 3);
        assertEquals(textArea.cols(), 33);
        assertEquals(textArea.minlength(), 10);
        assertEquals(textArea.maxlength(), 200);

        textArea.is().rowsCount(is(3));
        textArea.is().colsCount(is(33));
        textArea.is().minlength(is(10));
        textArea.is().maxlength(is(200));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(textArea);
    }


}
