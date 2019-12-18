package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledTextArea;
import static io.github.com.pages.HtmlElementsPage.textArea;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class TextAreaExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        textArea.clear();
    }

    String text = "TextArea";

    @Test
    public void addNewLineTest() {
        textArea.setLines("line1", "line2");
        textArea.addNewLine("line3");
        textArea.assertThat().text(is("line1\nline2\nline3"));
        textArea.clear();
        textArea.assertThat().text(is(""));
    }

    @Test
    public void isValidationTest() {
        textArea.is().enabled();
        textArea.setText(text);
        textArea.is().text(containsString("Area"));
        disabledTextArea.is().disabled();
    }

    @Test
    public void rowsTest() {
        textArea.is().rowsCount(is(3));
        textArea.is().colsCount(is(33));
        textArea.is().minlength(is(10));
        textArea.is().maxlength(is(200));
    }
}
