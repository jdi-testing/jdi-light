package io.github.epam.mobile.tests;

import io.github.epam.pages.HtmlMobilePage;
import org.testng.annotations.Test;

import static io.github.epam.sections.HtmlMobileElements.htmlMobileElements;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MobileWebTextFieldTests  extends StaticTestsInit {

    private static String CONDITION1 = "111";
    private static String CONDITION2 = "!}{?)";
    private static String CONDITION3 = "17.0";
    private static String CONDITION4 = "MyName";

    @Test
    public void textFieldTests() {
        shouldBeLoggedIn();

        leftMenu.tap();
        htmlMenu.tap();

        HtmlMobilePage.multiDropdown.focus();
        HtmlMobilePage.multiDropdown.sendKeys(CONDITION1);
        HtmlMobilePage.multiDropdown.has().text(CONDITION1);
        HtmlMobilePage.multiDropdown.clear();

        HtmlMobilePage.multiDropdown.focus();
        HtmlMobilePage.multiDropdown.sendKeys(CONDITION2);
        HtmlMobilePage.multiDropdown.has().text(CONDITION2);
        HtmlMobilePage.multiDropdown.clear();

        HtmlMobilePage.multiDropdown.focus();
        HtmlMobilePage.multiDropdown.sendKeys(CONDITION3);
        HtmlMobilePage.multiDropdown.has().text(CONDITION3);
        HtmlMobilePage.multiDropdown.clear();


        HtmlMobilePage.nameArea.focus();
        HtmlMobilePage.nameArea.sendKeys(CONDITION4);
        HtmlMobilePage.nameArea.has().text(CONDITION4);
        HtmlMobilePage.nameArea.clear();

        HtmlMobilePage.multiDropdown.focus();
        HtmlMobilePage.multiDropdown.sendKeys(CONDITION4);
        HtmlMobilePage.multiDropdown.has().text(CONDITION4);
        HtmlMobilePage.multiDropdown.clear();
    }

    @Test
    public void setTextTests() {
        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.nameArea.setValue(CONDITION1);
        HtmlMobilePage.nameArea.placeholder().equals(CONDITION1);
    }



    @Test
    public void isNameAreaDisplayed() {
        shouldBeLoggedIn();
        leftMenu.tap();
        htmlMenu.tap();
        HtmlMobilePage.nameArea.is().displayed();
    }
}
