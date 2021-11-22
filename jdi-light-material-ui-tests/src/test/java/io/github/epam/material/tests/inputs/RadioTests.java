package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.radioPage;
import static io.github.com.pages.inputs.RadioPage.labelPlacementRadio;
import static io.github.com.pages.inputs.RadioPage.lastRadioText;
import static io.github.com.pages.inputs.RadioPage.simpleRadio;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Radio Button web element please visit
 * https://material-ui.com/components/radio-buttons/
 */

public class RadioTests extends TestsInit {
    static private final List<String> simpleLabels = asList("First", "Second", "Third", "Disabled");
    static private final List<String> classes = asList("Top", "Start", "Bottom");
    static private final List<String> messages = asList("You got it!", "Sorry, wrong answer!");

    @BeforeMethod()
    public void beforeTest() {
        radioPage.open();
        radioPage.isOpened();
    }

    @Test
    public void simpleRadioTest() {
        simpleRadio.has().values("First", "Second", "Third", "Disabled");
        simpleRadio.has().enabled("First", "Second", "Third");
        simpleRadio.has().disabled("Disabled");
        asList("First", "Second", "Third").forEach(label -> {
            simpleRadio.select(label);
            simpleRadio.has().selected(label);
            lastRadioText.has().text(containsString(label));
        });
    }

    @Test
    public void labelPlacementTest() {

    }

    @Test
    public void showErrorTest() {

    }
}
