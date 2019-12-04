package io.github.epam.bootstrap.tests.composite.section.listgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupCustomContent;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CustomContentTests extends TestsInit {

    private String link1 = "https://jdi-testing.github.io/jdi-light/index.html";
    private String link2 = "https://github.com/jdi-testing";
    private String link3 = "https://github.com/jdi-docs";
    private String header1 = "List group item heading one";
    private String header2 = "List group item heading two";
    private String header3 = "List group item heading three";
    private String dateText = "3 days ago";
    private String mainText1 = "Some simple text for first section of custom list group.";
    private String mainText2 = "Some simple text for second section of custom list group.";
    private String mainText3 = "Some simple text for third section of custom list group.";
    private String footer1 = "JDI website";
    private String footer2 = "JDI - testing tool";
    private String footer3 = "JDI Docs";
    private String pageTitle1 = "Home Page";
    private String pageTitle2 = "JDI Testing tools · GitHub";
    private String pageTitle3 = "JDI · GitHub";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, link1, header1, dateText, mainText1, footer1},
                {2, link2, header2, dateText, mainText2, footer2},
                {3, link3, header3, dateText, mainText3, footer3}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, pageTitle1}, {2, pageTitle2}, {3, pageTitle3}
        };
    }

    @Test
    public void isValidationTests() {
        listGroupCustomContent.listGroup.is()
                .size(3);
        listGroupCustomContent.container.is()
                .size(3);
        listGroupCustomContent.header.is()
                .size(3);
        listGroupCustomContent.dateText.is()
                .size(3);
        listGroupCustomContent.mainText.is()
                .size(3);
        listGroupCustomContent.footer.is()
                .size(3);
    }

    @Test(dataProvider = "listData")
    public void mainContentTests(int index, String link, String header, String dateText, String mainText, String footer) {
        listGroupCustomContent.listGroup.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .hasClass("list-group-item list-group-item-action")
                .attr("href", is(link));
        listGroupCustomContent.container.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .hasClass("d-flex w-100 justify-content-between");
        listGroupCustomContent.header.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .hasClass("mb-1")
                .text(is(containsStringIgnoringCase(header)));
        listGroupCustomContent.dateText.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(dateText));
        listGroupCustomContent.mainText.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .hasClass("mb-1")
                .text(is(mainText));
        listGroupCustomContent.footer.get(index)
                .is()
                .core()
                .displayed()
                .enabled()
                .text(is(footer));
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String pageTitle) {
        listGroupCustomContent.listGroup.get(index).highlight();
        listGroupCustomContent.listGroup.get(index).click();
        newWindowTitleCheck(pageTitle);
        listGroupCustomContent.listGroup.get(index).unhighlight();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
