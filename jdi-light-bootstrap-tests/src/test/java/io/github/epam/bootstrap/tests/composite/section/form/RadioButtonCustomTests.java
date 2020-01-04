package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonCustom;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 07.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonCustomTests extends TestsInit {

    private String label1 = "Toggle this custom radio";
    private String label2 = "Or toggle this other custom radio";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.open();
    }

    @Test
    public void baseInitTest() {
        radioButtonCustom.radioButtons.is().size(2);
        radioButtonCustom.radioButtons.list().is().size(2);
        radioButtonCustom.radioButtons.list().get(1).label().is().text(is(label1));
        radioButtonCustom.radioButtons.list().get(2).label().is().text(is(label2));
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonCustom.radioButtons.list().get(1).select();
        radioButtonCustom.radioButtons.list().get(1).core().waitFor().selected();
        radioButtonCustom.radioButtons.list().get(1).is().selected();
        radioButtonCustom.radioButtons.list().get(2).is().deselected();
        radioButtonCustom.radioButtons.list().get(2).select();
        radioButtonCustom.radioButtons.list().get(2).core().waitFor().selected();
        radioButtonCustom.radioButtons.list().get(2).is().selected();
        radioButtonCustom.radioButtons.list().select(label1);
        radioButtonCustom.radioButtons.list().is().selected(label1);
        radioButtonCustom.radioButtons.list().get(2).is().deselected();
        radioButtonCustom.radioButtons.list().get(1).click();
        radioButtonCustom.radioButtons.list().get(1).is().selected();
        radioButtonCustom.radioButtons.list().get(2).is().deselected();
    }

    @Test
    public void radioButtonByIndexInSelectTests() {
        radioButtonCustom.radioButtons.select(1);
        radioButtonCustom.radioButtons.is().selected(label1);
        radioButtonCustom.radioButtons.select(2);
        radioButtonCustom.radioButtons.is().selected(label2);
        radioButtonCustom.radioButtons.select(label1);
        radioButtonCustom.radioButtons.is().selected(label1);
        //radioButtonCustom.radioButtons.is().selected(1);
        radioButtonCustom.radioButtons.select(label2);
        //radioButtonCustom.radioButtons.is().selected(2);
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonCustom.radioButtons.list().get(1).label().click();
        radioButtonCustom.radioButtons.list().get(1).is().selected();
        radioButtonCustom.radioButtons.list().get(2).is().deselected();
        radioButtonCustom.radioButtons.list().get(2).label().click();
        radioButtonCustom.radioButtons.list().get(2).is().selected();
        radioButtonCustom.radioButtons.list().get(1).is().deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonCustom.radioButtons.list().get(1).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonCustom.radioButtons.list().get(2).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }
}
