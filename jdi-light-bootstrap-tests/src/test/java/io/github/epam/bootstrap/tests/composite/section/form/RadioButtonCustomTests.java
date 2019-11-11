package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.complex.WebList;
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
    private WebList radioButtonsWebList;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        radioButtonsWebList = radioButtonCustom.radioButtons.list();
    }

    @Test
    public void baseInitTest() {
        radioButtonCustom.radioButtons.is().size(2);
        radioButtonsWebList.is().size(2);
        radioButtonsWebList.get(1).label().is().text(is(label1));
        radioButtonsWebList.get(2).label().is().text(is(label2));
    }

    @Test
    public void baseInitByIndexTest() {
        radioButtonsWebList.get(1).click();
        radioButtonsWebList.get(1).is().selected();
        radioButtonsWebList.get(2).is().deselected();
        radioButtonsWebList.get(2).click();
        radioButtonsWebList.get(2).is().selected();
        radioButtonsWebList.get(1).is().deselected();
    }

    @Test
    public void radioButtonByIndexTests() {
        radioButtonsWebList.get(1).select();
        radioButtonsWebList.get(1).core().waitFor().selected();
        radioButtonsWebList.get(1).is().selected();
        radioButtonsWebList.get(2).is().deselected();
        radioButtonsWebList.get(2).select();
        radioButtonsWebList.get(2).core().waitFor().selected();
        radioButtonsWebList.get(2).is().selected();
    }

    @Test
    public void radioButtonByIndexInSelectTests() {
        radioButtonsWebList.select(1);
        radioButtonsWebList.get(1).core().waitFor().selected();
        radioButtonsWebList.get(1).is().selected();
        radioButtonsWebList.get(2).is().deselected();
        radioButtonsWebList.select(2);
        radioButtonsWebList.get(2).core().waitFor().selected();
        radioButtonsWebList.get(2).is().selected();
        radioButtonCustom.radioButtons.is().selected(2);
        radioButtonsWebList.select("Toggle this custom radio");
        radioButtonsWebList.selected("Toggle this custom radio");
    }

    @Test
    public void radioButtonByIndexInSelectAltTests() {
        radioButtonCustom.radioButtons.select(1);
        radioButtonCustom.radioButtons.is().selected("Toggle this custom radio");
        radioButtonCustom.radioButtons.select(2);
        radioButtonCustom.radioButtons.is().selected("Or toggle this other custom radio");
        radioButtonCustom.radioButtons.select("Toggle this custom radio");
        radioButtonCustom.radioButtons.is().selected("Toggle this custom radio");
        radioButtonCustom.radioButtons.is().selected(1);
        radioButtonCustom.radioButtons.select("Or toggle this other custom radio");
        radioButtonCustom.radioButtons.is().selected(2);
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonsWebList.get(1).label().click();
        radioButtonsWebList.get(1).is().selected();
        radioButtonsWebList.get(2).is().deselected();
        radioButtonsWebList.get(2).label().click();
        radioButtonsWebList.get(2).is().selected();
        radioButtonsWebList.get(1).is().deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonsWebList.get(1).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonsWebList.get(2).is()
                .enabled()
                .core()
                .attr("type", "radio")
                .attr("name", "customRadio")
                .hasClass("custom-control-input")
                .tag(is("input"));
    }
}
