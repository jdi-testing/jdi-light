package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.radioButtonGroup;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 23.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseInitTest() {
        radioButtonGroup.radio1.is().deselected();
        radioButtonGroup.radio2.is().deselected();
        radioButtonGroup.radio3.is().deselected();
    }

    @Test
    public void radioButtonTests() {
        radioButtonGroup.radio1.select();
        radioButtonGroup.radio1.is().selected();
        radioButtonGroup.radio2.is().deselected();
        radioButtonGroup.radio3.is().deselected();
        radioButtonGroup.radio2.select();
        radioButtonGroup.radio2.is().selected();
        radioButtonGroup.radio1.is().deselected();
        radioButtonGroup.radio3.is().deselected();
        radioButtonGroup.radio3.select();
        radioButtonGroup.radio3.is().selected();
        radioButtonGroup.radio1.is().deselected();
        radioButtonGroup.radio2.is().deselected();
    }

    @Test
    public void radioOneIsValidationTests() {
        radioButtonGroup.radio1.is()
                .displayed()
                .enabled().core()
                .attr("type", "radio")
                .attr("name", "radio-button")
                .tag(is("input"));
    }

    @Test
    public void radioTwoIsValidationTests() {
        radioButtonGroup.radio2.is()
                .displayed()
                .enabled().core()
                .attr("type", "radio")
                .attr("name", "radio-button")
                .tag(is("input"));
    }

    @Test
    public void radioThreeIsValidationTests() {
        radioButtonGroup.radio3.is()
                .displayed()
                .enabled().core()
                .attr("type", "radio")
                .attr("name", "radio-button")
                .tag(is("input"));
    }
}
