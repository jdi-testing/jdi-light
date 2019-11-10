package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.JS;
import static com.epam.jdi.light.settings.WebSettings.ANY_ELEMENT;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxAndRadioButtonCustomDisabled;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 08.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class CheckboxAndRadioButtonCustomDisabledTests extends TestsInit {

    private String label1 = "Toggle this custom radio";
    WebList radioBtnList;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        radioBtnList = checkboxAndRadioButtonCustomDisabled.radioButtons.list(ANY_ELEMENT, JS);
        //checkboxAndRadioButtonCustomDisabled.checkbox.hover();
    }

    @Test
    public void checkboxIsValidationTests() {
        checkboxAndRadioButtonCustomDisabled.checkbox
                .is()
                .displayed()
                .disabled()
                .core()
                .hasClass("custom-control")
                .hasClass("custom-checkbox")
                .tag(is("div"));
        checkboxAndRadioButtonCustomDisabled.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control-label")
                .text(is("Check this custom checkbox"))
                .tag(is("label"));
    }

    @Test
    public void radioButtonIsValidationTests() {
        radioBtnList.get(1).is()
                .hidden()
                .disabled()
                .core()
                .attr("type", "radio")
                .attr("name", "radioDisabled")
                .hasClass("custom-control-input")
                .tag(Matchers.is("input"));
    }

    @Test
    public void baseInitTest() {

        radioBtnList.is().size(1);
        radioBtnList.get(1).is().deselected();
        radioBtnList.get(1).label().is().text(is(label1));
    }

    @Test
    public void radioButtonTests() {
        radioBtnList.get(1).label().click();
        radioBtnList.get(1).is().deselected();
        radioBtnList.get(1).is().disabled();
        radioBtnList.get(1).is().deselected();
    }

    @Test
    public void checkboxTests() {
        checkboxAndRadioButtonCustomDisabled.checkbox.check();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
        checkboxAndRadioButtonCustomDisabled.checkbox.click();
        checkboxAndRadioButtonCustomDisabled.checkbox.is().deselected();
    }
}
