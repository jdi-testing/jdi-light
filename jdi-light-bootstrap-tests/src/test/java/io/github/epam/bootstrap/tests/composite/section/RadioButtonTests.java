package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonGroup;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 24.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonTests extends TestsInit {

    private String label1 = "Default radio";
    private String label2 = "Second default radio";
    private String label3 = "Disabled radio";
    private String value1 = "option1";
    private String value2 = "option2";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonGroup.radioButton.is()
                .size(3);
        radioButtonGroup.radio1.is()
                .selected();
        radioButtonGroup.radio2.is()
                .deselected();
        radioButtonGroup.radio3.is()
                .deselected();
        radioButtonGroup.radio3.is()
                .disabled();
        radioButtonGroup.radio1Label.is()
                .text(is(label1));
        radioButtonGroup.radio2Label.is()
                .text(is(label2));
        radioButtonGroup.radio3Label.is()
                .text(is(label3));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonGroup.radioButton.get(1).is()
                .selected();
        radioButtonGroup.radioButton.get(2).is()
                .deselected();
        radioButtonGroup.radioButton.get(3).is()
                .deselected();
        radioButtonGroup.radioButton.get(3).is()
                .disabled();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonGroup.radioButton.select(2);
        radioButtonGroup.radioButton.get(2).is()
                .selected();
        radioButtonGroup.radioButton.get(1).is()
                .deselected();
        radioButtonGroup.radioButton.select(1);
        radioButtonGroup.radioButton.get(1).is()
                .selected();
        radioButtonGroup.radioButton.get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonGroup.radio2Label.click();
        radioButtonGroup.radioButton.get(2).is()
                .selected();
        radioButtonGroup.radioButton.is()
                .text(is(value2));
        radioButtonGroup.radioButton.get(1).is()
                .deselected();
        radioButtonGroup.radio1Label.click();
        radioButtonGroup.radioButton.get(1).is()
                .selected();
        radioButtonGroup.radioButton.is()
                .text(is(value1));
        radioButtonGroup.radioButton.get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonTests() {
        radioButtonGroup.radio2.select();
        radioButtonGroup.radio2.is()
                .selected();
        radioButtonGroup.radio1.is()
                .deselected();
        radioButtonGroup.radio1.select();
        radioButtonGroup.radio1.is()
                .selected();
        radioButtonGroup.radio2.is()
                .deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonGroup.radio1.is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "exampleRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonGroup.radio2.is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "exampleRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }

    @Test
    public void radioThreeIsValidationTests() {
        radioButtonGroup.radio3.is()
                .displayed()
                .disabled()
                .core()
                .attr("type", "radio")
                .attr("name", "exampleRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }
}
