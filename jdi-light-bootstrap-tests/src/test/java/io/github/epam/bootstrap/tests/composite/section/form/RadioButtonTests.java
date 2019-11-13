package io.github.epam.bootstrap.tests.composite.section.form;

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

    private String labelText1 = "Default radio";
    private String labelText2 = "Second default radio";
    private String labelText3 = "Disabled radio";
    private String value1 = "option1";
    private String value2 = "option2";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonGroup.radioButtons.is().size(3);
        radioButtonGroup.radioButtons.list().get(1).is().selected();
        radioButtonGroup.radioButtons.list().get(2).is().deselected();
        radioButtonGroup.radioButtons.list().get(3).is().deselected();
        radioButtonGroup.radioButtons.list().get(3).is().disabled();
        radioButtonGroup.radioButtons.list().get(1).label().is().text(is(labelText1));
        radioButtonGroup.radioButtons.list().get(2).label().is().text(is(labelText2));
        radioButtonGroup.radioButtons.list().get(3).label().is().text(is(labelText3));
    }


    @Test
    public void radioButtonByIndexTests() {
        radioButtonGroup.radioButtons.list().get(2).click();
        radioButtonGroup.radioButtons.list().get(2).is().selected();
        radioButtonGroup.radioButtons.list().is().selected(2);
        radioButtonGroup.radioButtons.is().selected(2);
        radioButtonGroup.radioButtons.list().get(1).is().deselected();
        radioButtonGroup.radioButtons.list().get(1).select();
        radioButtonGroup.radioButtons.list().get(1).is().selected();
        radioButtonGroup.radioButtons.list().is().selected(1);
        radioButtonGroup.radioButtons.list().get(2).is().deselected();
        radioButtonGroup.radioButtons.list().select(2);
        radioButtonGroup.radioButtons.list().get(2).is().selected();
    }

    @Test
    public void radioButtonByLabelTests() {
        radioButtonGroup.radioButtons.list().select(labelText1);;
        radioButtonGroup.radioButtons.list().is().selected(labelText1);
        radioButtonGroup.radioButtons.is().selected(labelText1);
        radioButtonGroup.radioButtons.list().get(1).is().text(is(value1));
        radioButtonGroup.radioButtons.list().get(2).is().deselected();
        radioButtonGroup.radioButtons.list().get(2).label().click();
        radioButtonGroup.radioButtons.is().selected(labelText2);
        radioButtonGroup.radioButtons.list().get(2).is().text(is(value2));
        radioButtonGroup.radioButtons.list().get(1).is().deselected();
        radioButtonGroup.radioButtons.select(labelText1);
        radioButtonGroup.radioButtons.is().selected(labelText1);
        radioButtonGroup.radioButtons.list().get(2).is().deselected();
    }

    @Test
    public void radioButtonLabelsTests() {
        radioButtonGroup.radioButtons.list().get(1).label().is().text(labelText1);
        radioButtonGroup.radioButtons.list().get(2).label().is().text(labelText2);
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonGroup.radioButtons.list().get(1).is()
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
        radioButtonGroup.radioButtons.list().get(2).is()
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
        radioButtonGroup.radioButtons.list().get(3).is()
                .displayed()
                .disabled()
                .core()
                .attr("type", "radio")
                .attr("name", "exampleRadios")
                .hasClass("form-check-input")
                .tag(is("input"));
    }
}
