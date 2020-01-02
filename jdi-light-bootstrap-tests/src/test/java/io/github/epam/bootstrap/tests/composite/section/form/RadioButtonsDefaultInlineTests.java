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
        bsPage.open();
    }

    @Test
    public void baseInitTest() {

        radioButtonsDefaultInline.radioButtons.is().size(3);
        radioButtonsDefaultInline.radioButtons.list().get(1).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().get(2).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().get(3).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().get(3).is().disabled();

        radioButtonsDefaultInline.radioButtons.list().get(1).label()
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label1));
        radioButtonsDefaultInline.radioButtons.list().get(2).label()
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label2));
        radioButtonsDefaultInline.radioButtons.list().get(3).label()
                .is()
                .core()
                .hasClass("form-check-label")
                .text(is(label3));
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonsDefaultInline.radioButtons.select(2);
        radioButtonsDefaultInline.radioButtons.is().selected(2);
        radioButtonsDefaultInline.radioButtons.is().selected("2");
        radioButtonsDefaultInline.radioButtons.list().get(2).is().selected();
        radioButtonsDefaultInline.radioButtons.list().get(1).is().deselected();
        radioButtonsDefaultInline.radioButtons.select(1);
        radioButtonsDefaultInline.radioButtons.is().selected(1);
        radioButtonsDefaultInline.radioButtons.is().selected("1");
        radioButtonsDefaultInline.radioButtons.list().get(2).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().select("2");
        radioButtonsDefaultInline.radioButtons.list().get(2).is().selected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonsDefaultInline.radioButtons.list().get(2).label().click();
        radioButtonsDefaultInline.radioButtons.list().get(2).is().selected();
        radioButtonsDefaultInline.radioButtons.list().get(1).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().get(3).label().click();
        radioButtonsDefaultInline.radioButtons.list().get(3).is().deselected();
        radioButtonsDefaultInline.radioButtons.list().get(3).is().disabled();
        radioButtonsDefaultInline.radioButtons.list().get(1).label().click();
        radioButtonsDefaultInline.radioButtons.list().get(1).is().selected();
        radioButtonsDefaultInline.radioButtons.list().get(2).is().deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonsDefaultInline.radioButtons.list().get(1)
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
        radioButtonsDefaultInline.radioButtons.list().get(2)
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
        radioButtonsDefaultInline.radioButtons.list().get(3)
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
