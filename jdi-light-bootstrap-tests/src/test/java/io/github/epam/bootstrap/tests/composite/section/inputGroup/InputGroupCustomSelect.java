package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customSelect;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class InputGroupCustomSelect extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String optionText = "Options";
    String selectChoose = "Choose...";
    String selectOne = "One";
    String selectTwo = "Two";
    String selectThree = "Three";

    @Test
    public void isValidationOptionsSectionTests() {
        customSelect.optionText.is().text(optionText);
        customSelect.optionText.is()
                .core()
                .hasClass("input-group-prepend")
                .css("font-size", is("14px"))
                .tag("div");
    }

    @Test
    public void selectorByIndexTests() {
        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(2);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(3);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(4);
        customSelect.selector.is().selected(selectThree);
        customSelect.selector.select(1);
        customSelect.selector.is().selected(selectChoose);
    }

    @Test(priority = 1)
    public void selectorByValueTests() {
        customSelect.selector.is().selected(selectChoose);
        customSelect.selector.select(selectOne);
        customSelect.selector.is().selected(selectOne);
        customSelect.selector.select(selectTwo);
        customSelect.selector.is().selected(selectTwo);
        customSelect.selector.select(selectThree);
        customSelect.selector.is().selected(selectThree);
    }

    @Test
    public void selectorIsValidationTests() {
        customSelect.selector.is().displayed()
                .enabled()
                .core()
                .hasClass("custom-select")
                .css("font-size", is("16px"));;
        customSelect.selector.is().size(4);
    }
}
