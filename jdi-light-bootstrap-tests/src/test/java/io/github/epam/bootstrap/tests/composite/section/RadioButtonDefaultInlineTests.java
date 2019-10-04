package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonDefaultInline;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonDefaultInlineTests extends TestsInit {

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
        radioButtonDefaultInline.radioButton
                .is()
                .size(3);
        radioButtonDefaultInline.radio1
                .is()
                .deselected();
        radioButtonDefaultInline.radio2
                .is()
                .deselected();
        radioButtonDefaultInline.radio3
                .is()
                .deselected();
        radioButtonDefaultInline.radio3
                .is()
                .disabled();
        radioButtonDefaultInline.radio1Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label1));
        radioButtonDefaultInline.radio2Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label2));
        radioButtonDefaultInline.radio3Label
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label3));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonDefaultInline.radioButton.get(2)
                .is()
                .deselected();
        radioButtonDefaultInline.radioButton.get(3)
                .is()
                .deselected();
        radioButtonDefaultInline.radioButton.get(3)
                .is()
                .disabled();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonDefaultInline.radioButton.select(2);
        radioButtonDefaultInline.radioButton.get(2)
                .is()
                .selected();
        radioButtonDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonDefaultInline.radioButton.select(1);
        radioButtonDefaultInline.radioButton.get(1)
                .is()
                .selected();
        radioButtonDefaultInline.radioButton.get(2)
                .is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonDefaultInline.radio2Label.click();
        radioButtonDefaultInline.radioButton.get(2)
                .is()
                .selected();
        radioButtonDefaultInline.radioButton
                .is()
                .text(is(value2));
        radioButtonDefaultInline.radioButton.get(1)
                .is()
                .deselected();
        radioButtonDefaultInline.radio1Label.click();
        radioButtonDefaultInline.radioButton.get(1)
                .is()
                .selected();
        radioButtonDefaultInline.radioButton
                .is()
                .text(is(value1));
        radioButtonDefaultInline.radioButton.get(2)
                .is()
                .deselected();
    }

    @Test
    public void radioButtonTests() {
        radioButtonDefaultInline.radio2.select();
        radioButtonDefaultInline.radio2
                .is()
                .selected();
        radioButtonDefaultInline.radio1
                .is()
                .deselected();
        radioButtonDefaultInline.radio1.select();
        radioButtonDefaultInline.radio1
                .is()
                .selected();
        radioButtonDefaultInline.radio2
                .is()
                .deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonDefaultInline.radio1
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
        radioButtonDefaultInline.radio2
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
        radioButtonDefaultInline.radio3
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
