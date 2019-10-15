package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonsDefaultInline;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonsDefaultInlineTests extends TestsInit {

    private String label1 = "1";
    private String label2 = "2";
    private String label3 = "3 (disabled)";
    private String value1 = "option1";
    private String value2 = "option2";
    private String value3 = "option3";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonsDefaultInline.radioButton
                .is()
                .size(3);
        radioButtonsDefaultInline.radio1
                .is()
                .deselected();
        radioButtonsDefaultInline.radio2
                .is()
                .deselected();
        radioButtonsDefaultInline.radio3
                .is()
                .deselected();
        radioButtonsDefaultInline.radio3
                .is()
                .disabled();
        radioButtonsDefaultInline.radio1Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label1));
        radioButtonsDefaultInline.radio2Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label2));
        radioButtonsDefaultInline.radio3Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label3));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonsDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonsDefaultInline.radioButton.get(2)
                .is()
                .deselected();
        radioButtonsDefaultInline.radioButton.get(3)
                .is()
                .deselected();
        radioButtonsDefaultInline.radioButton.get(3)
                .is()
                .disabled();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonsDefaultInline.radioButton.select(2);
        radioButtonsDefaultInline.radioButton.get(2)
                .is()
                .selected();
        radioButtonsDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonsDefaultInline.radioButton.select(1);
        radioButtonsDefaultInline.radioButton.get(1)
                .is()
                .selected();
        radioButtonsDefaultInline.radioButton.get(2)
                .is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonsDefaultInline.radio2Label.click();
        radioButtonsDefaultInline.radioButton.get(2)
                .is()
                .selected();
        radioButtonsDefaultInline.radioButton
                .is()
                .text(is(value2));
        radioButtonsDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonsDefaultInline.radio1Label.click();
        radioButtonsDefaultInline.radioButton.get(1)
                .is()
                .selected();
        radioButtonsDefaultInline.radioButton
                .is()
                .text(is(value1));
        radioButtonsDefaultInline.radioButton.get(2)
                .is()
                .deselected();
    }

    @Test
    public void radioButtonTests() {
        radioButtonsDefaultInline.radio2.select();
        radioButtonsDefaultInline.radio2
                .is()
                .selected();
        radioButtonsDefaultInline.radio1
                .is()
                .deselected();
        radioButtonsDefaultInline.radio1.select();
        radioButtonsDefaultInline.radio1
                .is()
                .selected();
        radioButtonsDefaultInline.radio2
                .is()
                .deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonsDefaultInline.radio1
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "inlineRadioOptions")
                .attr("value", value1)
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonsDefaultInline.radio2
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "inlineRadioOptions")
                .attr("value", value2)
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioThreeIsValidationTests() {
        radioButtonsDefaultInline.radio3
                .is()
                .displayed()
                .disabled()
                .core()
                .attr("type", "radio")
                .attr("name", "inlineRadioOptions")
                .attr("value", value3)
                .hasClass("form-check-input")
                .tag(is("input"));
    }
}
