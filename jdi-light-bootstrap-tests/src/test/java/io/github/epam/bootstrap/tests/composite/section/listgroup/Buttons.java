package io.github.epam.bootstrap.tests.composite.section.listgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupButtons;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class Buttons extends TestsInit {

    private String text1 = "Cras justo odio";
    private String text2 = "Dapibus ac facilisis in";
    private String text3 = "Morbi leo risus";
    private String text4 = "Porta ac consectetur ac";
    private String text5 = "Vestibulum at eros";
    private String listClass = "list-group-item list-group-item-action";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, text1}, {2, text2}, {3, text3}, {4, text4}, {5, text5}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, text1}, {2, text2}, {3, text3}, {4, text4}
        };
    }

    @Test
    public void isValidationTests() {
        listGroupButtons.listGroup.is()
                .size(5);
        listGroupButtons.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("list-group");
        listGroupButtons.listGroup.get(1).is()
                .hasClass(listClass + " active");
        listGroupButtons.listGroup.get(5).is()
                .disabled();
    }

    @Test(dataProvider = "listData")
    public void buttonGroupTextTests(int index, String text) {
        listGroupButtons.listGroup.get(index).is()
                .text(text)
                .css("font-size", is("14px"));
    }

    @Test(dataProvider = "clickValidate")
    public void buttonClickableTests(int index, String text) {
        listGroupButtons.listGroup.get(index).highlight();
        listGroupButtons.listGroup.get(index).click();
        validateAlert(is(text));
        listGroupButtons.listGroup.get(index).unhighlight();
    }

    @Test(dataProvider = "clickValidate")
    public void buttonTextClickableTests(int index, String text) {
        listGroupButtons.listGroup.select(text);
        validateAlert(is(text));
    }
}
