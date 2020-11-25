package io.github.epam.mobile.tests;

import io.github.epam.pages.HtmlMobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.github.epam.sections.HtmlMobileElements.htmlMenu;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MobileWebTextAreaTests extends StaticTestsInit {

    @Test
    public void textAreaIsDisplayed() {
        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.textArea.is().displayed();
    }

    @Test
    public void enterTextToArea() {
        List<String> inputText = new ArrayList<>();
        inputText.add("New text for text area.");
        inputText.add("JDI-Light mobile is very good and convenient.");
        inputText.add("It is very convenient to write auto tests");

        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.textArea.focus();
        HtmlMobilePage.textArea.clear();
        HtmlMobilePage.textArea.input(String.valueOf(inputText));
        HtmlMobilePage.textArea.has().text(String.valueOf(inputText));
        HtmlMobilePage.textArea.clear();
    }

    @Test
    public void addNewLinesTest() {
        List<String> inputText = new ArrayList<>();
        inputText.add("New text for text area.");
        inputText.add("JDI-Light mobile is very good and convenient.");
        inputText.add("It is very convenient to write auto tests");

        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.textArea.focus();
        HtmlMobilePage.textArea.clear();
        HtmlMobilePage.textArea.sendKeys(String.valueOf(inputText));
        HtmlMobilePage.textArea.addNewLine("New line for text area");
        Assert.assertEquals(HtmlMobilePage.textArea.getLines().size(), 2);
    }

    @Test
    public void addNewLinesAndClearOld() {
        List<String> inputText = new ArrayList<>();
        inputText.add("New text for text area.");
        inputText.add("JDI-Light mobile is very good and convenient.");
        inputText.add("It is very convenient to write auto tests");

        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.textArea.focus();
        HtmlMobilePage.textArea.input("New line instead old");
        HtmlMobilePage.textArea.placeholder().equals("New line instead old");
    }
}
