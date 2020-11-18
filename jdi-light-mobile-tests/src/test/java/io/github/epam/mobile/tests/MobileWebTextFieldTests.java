package io.github.epam.mobile.tests;

import io.github.epam.pages.HtmlMobilePage;
import org.testng.annotations.Test;

import static io.github.epam.sections.HtmlMobileElements.htmlMenu;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MobileWebTextFieldTests  extends StaticTestsInit {

    private static String CONDITION1 = "111";
    private static String CONDITION2 = "!}{?)";
    private static String CONDITION3 = "17";
    private static String CONDITION4 = "MyName";
    private static String CONDITION5 = "Мое имя";

    @Test
    public void textFieldTests() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();

        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION1);
        HtmlMobilePage.nameArea.has().text(CONDITION1);
        HtmlMobilePage.nameArea.clear();

        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION2);
        HtmlMobilePage.nameArea.has().text(CONDITION2);
        HtmlMobilePage.nameArea.clear();

        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION3);
        HtmlMobilePage.nameArea.has().text(CONDITION3);
        HtmlMobilePage.nameArea.clear();

        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION4);
        HtmlMobilePage.nameArea.has().text(CONDITION4);
        HtmlMobilePage.nameArea.clear();

        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION5);
        HtmlMobilePage.nameArea.has().text(CONDITION5);
        HtmlMobilePage.nameArea.clear();
    }

    @Test
    public void setTextTests() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        HtmlMobilePage.nameArea.setValue(CONDITION1);
        HtmlMobilePage.nameArea.placeholder().equals(CONDITION1);
    }



    @Test
    public void isNameAreaDisplayed() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMenu.click();
        HtmlMobilePage.nameArea.is().displayed();
    }
}
