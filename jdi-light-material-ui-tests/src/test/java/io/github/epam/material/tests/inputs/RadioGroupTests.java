package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.jdiai.tools.Timer;
import io.github.com.pages.inputs.RadioGroupPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.radioGroupPage;
import static io.github.com.pages.inputs.RadioGroupPage.simpleRadioGroup;

/**
 * To see an example of Radio Button web element please visit
 * https://material-ui.com/components/radio-buttons/
 */

public class RadioGroupTests extends TestsInit {
    static private final List<String> labels = Arrays.asList("First", "Second", "Third", "Disabled");
    static private final List<String> classes = Arrays.asList("Top", "Start", "Bottom");
    static private final List<String> messages = Arrays.asList("You got it!", "Sorry, wrong answer!");
    static private final Timer timer = new Timer(2000L);

    @BeforeMethod()
    public void beforeTest() {
        radioGroupPage.open();
        radioGroupPage.isOpened();
    }

    @Test
    public void simpleRadioTest() throws InterruptedException {
        simpleRadioGroup.select("First");
        simpleRadioGroup.highlight();
        Thread.sleep(5000);
    }

    @Test
    public void labelPlacementTest() {

    }

    @Test
    public void showErrorTest() {

    }
}
