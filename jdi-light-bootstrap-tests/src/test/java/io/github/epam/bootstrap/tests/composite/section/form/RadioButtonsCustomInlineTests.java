package io.github.epam.bootstrap.tests.composite.section.form;

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

    private String text1 = "Toggle this\ncustom radio";
    private String text2 = "Or toggle this\ncustom radio";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.open();
    }

    @Test
    public void baseInitTest() {
        radioButtonsCustomInline.radioButtons.is().size(2);
        radioButtonsCustomInline.radioButtons.list().get(1).is()
                .deselected();
        radioButtonsCustomInline.radioButtons.list().get(2).is()
                .deselected();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonsCustomInline.radioButtons.select(1);
        radioButtonsCustomInline.radioButtons.is().selected(1);
        radioButtonsCustomInline.radioButtons.list().get(2).select();
        radioButtonsCustomInline.radioButtons.list().is().selected(2);
        radioButtonsCustomInline.radioButtons.list().get(2).is().selected();
        radioButtonsCustomInline.radioButtons.list().get(1).click();
        radioButtonsCustomInline.radioButtons.list().get(1).is().selected();
        radioButtonsCustomInline.radioButtons.list().get(2).is().deselected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonsCustomInline.radioButtons.list().get(1).label().click();
        radioButtonsCustomInline.radioButtons.is().selected(1);
        radioButtonsCustomInline.radioButtons.list().get(2).label().click();
        radioButtonsCustomInline.radioButtons.is().selected(2);
        radioButtonsCustomInline.radioButtons.list().get(1).label().click();
        radioButtonsCustomInline.radioButtons.is().selected(text1);
        radioButtonsCustomInline.radioButtons.list().is().selected(text1);
        radioButtonsCustomInline.radioButtons.select(text2);
        radioButtonsCustomInline.radioButtons.list().is().selected(text2);
        radioButtonsCustomInline.radioButtons.list().get(1).label().is().text(text1);
        radioButtonsCustomInline.radioButtons.list().get(2).label().is().text(text2);
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonsCustomInline.radioButtons.list().get(1).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadioInline1")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonsCustomInline.radioButtons.list().get(2).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadioInline1")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }
}
