package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonsCustomInline;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 07.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonsCustomInlineTests extends TestsInit {

    private String label1 = "Toggle this\ncustom radio";
    private String label2 = "Or toggle this\ncustom radio";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonsCustomInline.radioButton.is()
                .size(2);
        radioButtonsCustomInline.radio1.is()
                .deselected();
        radioButtonsCustomInline.radio2.is()
                .deselected();
        radioButtonsCustomInline.radio1Label.is()
                .text(is(label1));
        radioButtonsCustomInline.radio2Label.is()
                .text(is(label2));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonsCustomInline.radioButton.get(1).is()
                .deselected();
        radioButtonsCustomInline.radioButton.get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonsCustomInline.radioButton.select(2);
        radioButtonsCustomInline.radio2.is()
                .selected();
        radioButtonsCustomInline.radio1.is()
                .deselected();
        radioButtonsCustomInline.radioButton.select(1);
        radioButtonsCustomInline.radio1.is()
                .selected();
        radioButtonsCustomInline.radio2.is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonsCustomInline.radio2Label.click();
        radioButtonsCustomInline.radio2.is()
                .selected();
        radioButtonsCustomInline.radio1.is()
                .deselected();
        radioButtonsCustomInline.radio1Label.click();
        radioButtonsCustomInline.radio1.is()
                .selected();
        radioButtonsCustomInline.radio2.is()
                .deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonsCustomInline.radio1.is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadioInline1")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonsCustomInline.radio2.is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadioInline1")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }
}
