package io.github.epam.bootstrap.tests.composite.section.inputgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customSelectWithButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class InputGroupCustomSelectWithButton extends TestsInit {

    private String buttonClickAlert = "Button clicked, thank you!";
    private String buttonText = "Button";
    private String selectChoose = "Choose...";
    private String selectOne = "One";
    private String selectTwo = "Two";
    private String selectThree = "Three";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void buttonTests() {
        customSelectWithButton.button.is().displayed();
        customSelectWithButton.button.is().enabled();
        customSelectWithButton.button.is().text(buttonText);
        customSelectWithButton.button.hover();
        customSelectWithButton.button.click();
        validateAlert(is(buttonClickAlert));
    }

    @Test
    public void selectorByIndexTests() {
        customSelectWithButton.selector.is().selected(selectChoose);
        customSelectWithButton.selector.select(2);
        customSelectWithButton.selector.is().selected(selectOne);
        customSelectWithButton.selector.select(3);
        customSelectWithButton.selector.is().selected(selectTwo);
        customSelectWithButton.selector.select(4);
        customSelectWithButton.selector.is().selected(selectThree);
        customSelectWithButton.selector.select(1);
        customSelectWithButton.selector.is().selected(selectChoose);
    }

    @Test(priority = 1)
    public void selectorByValueTests() {
        customSelectWithButton.selector.is().selected(selectChoose);
        customSelectWithButton.selector.select(selectOne);
        customSelectWithButton.selector.is().selected(selectOne);
        customSelectWithButton.selector.select(selectTwo);
        customSelectWithButton.selector.is().selected(selectTwo);
        customSelectWithButton.selector.select(selectThree);
        customSelectWithButton.selector.is().selected(selectThree);
    }

    @Test
    public void selectorIsValidationTests() {
        customSelectWithButton.selector.is().displayed()
                .enabled()
                .core()
                .hasClass("custom-select")
                .css("font-size", is("16px"));
        customSelectWithButton.selector.is().size(4);
    }

}
