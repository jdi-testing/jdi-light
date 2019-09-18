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

public class TextAreaTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        textArea.clear();
    }
    String text = "TextArea";

    @Test
    public void getTextTest() {
        textArea.setText(text);
        assertEquals(textArea.getText(), text);
    }

    @Test
    public void getValueTest() {
        textArea.setText(text);
        assertEquals(textArea.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        textArea.setText(text);
        textArea.sendKeys("Test");
        assertEquals(textArea.getValue(), text+"Test");
    }
    @Test
    public void inputTest() {
        textArea.setText(text);
        textArea.input("New text");
        assertEquals(textArea.getText(), "New text");
    }

    @Test
    public void getLinesTest() {
        textArea.setLines("test 1", "test 2", "test 3");
        assertEquals(textArea.getLines(), asList("test 1", "test 2", "test 3"));
    }

    @Test
    public void clearTest() {
        textArea.setText(text);
        textArea.clear();
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(textArea.placeholder(), "Input huge text");
    }

    @Test
    public void disabledTest() {
        disabledTextArea.setText(text);
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void addNewLineTest(){
        textArea.setLines("line1", "line2");
        textArea.addNewLine("line3");
        assertEquals(textArea.getText(), "line1\nline2\nline3");
    }

    @Test
    public void setLinesTest(){
        textArea.setLines("line1", "line2");
        assertEquals(textArea.getText(), "line1\nline2");
    }
    @Test
    public void addLinesTest(){
        textArea.addNewLine("line1");
        textArea.addNewLine("line2");
        assertEquals(textArea.getText(), "line1\nline2");
    }
    @Test
    public void focusTest() {
        textArea.focus();
    }

    @Test
    public void isValidationTest() {
        textArea.is().enabled();
        textArea.setText(text);
        textArea.is().text(is(text));
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
        textArea.setText(text);
        textArea.assertThat().text(is(text));
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
