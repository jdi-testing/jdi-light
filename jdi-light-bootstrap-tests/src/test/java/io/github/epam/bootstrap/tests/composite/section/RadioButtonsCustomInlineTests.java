package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class RadioButtonsCustomInlineTests extends TestsInit {

    private String label1 = "Toggle this custom radio";
    private String label2 = "Or toggle this other custom radio";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonCustom.radioButton.is()
                .size(2);
        radioButtonCustom.radio1.is()
                .deselected();
        radioButtonCustom.radio2.is()
                .deselected();
        radioButtonCustom.radio1Label.is()
                .text(is(label1));
        radioButtonCustom.radio2Label.is()
                .text(is(label2));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonCustom.radioButton.get(1).is()
                .deselected();
        radioButtonCustom.radioButton.get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonCustom.radioButton.select(2);
        radioButtonCustom.radio2.is()
                .selected();
        radioButtonCustom.radio1.is()
                .deselected();
        radioButtonCustom.radioButton.select(1);
        radioButtonCustom.radio1.is()
                .selected();
        radioButtonCustom.radio2.is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonCustom.radio2Label.click();
        radioButtonCustom.radio2.is()
                .selected();
        radioButtonCustom.radio1.is()
                .deselected();
        radioButtonCustom.radio1Label.click();
        radioButtonCustom.radio1.is()
                .selected();
        radioButtonCustom.radio2.is()
                .deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonCustom.radio1.is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonCustom.radio2.is()
                .hidden()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }
}
