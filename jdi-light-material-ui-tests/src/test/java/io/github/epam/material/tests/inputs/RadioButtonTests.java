package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static io.github.com.pages.inputs.RadioButtonPage.*;
import static io.github.com.StaticSite.radioButtonPage;

/**
 * To see an example of Radio Button web element please visit https://material-ui.com/components/radio-buttons/
 */
public class RadioButtonTests extends TestsInit {
    static private final List<String> labels = Arrays.asList("First", "Second", "Third", "Disabled");
    static private final List<String> classes = Arrays.asList("Top", "Start", "Bottom");
    static private final List<String> messages = Arrays.asList("You got it!", "Sorry, wrong answer!");
    static private final Timer timer = new Timer(2000L);

    @BeforeMethod()
    public void beforeTest() {
        radioButtonPage.open();
        radioButtonPage.isOpened();
    }

    @Test
    public void simpleRadioTest() {
        for (int i = 1; i <= 4; i++) {
            Button currentRadioButton = simpleRadioButtons.get(i);
            Button currentRadioButtonLabel = simpleRadioButtonsLabel.get(i);
            if (i != 4) {
                currentRadioButton.click();
                timer.wait(() -> currentRadioButton.has().classValue(containsString("Mui-checked")));
                lastRadioText.has().text(containsString(currentRadioButton.text()));
            }
            else
                timer.wait(() -> currentRadioButton.has().classValue(containsString("Mui-disabled")));
            currentRadioButtonLabel.has().text(labels.get(i - 1));
        }
    }

    @Test
    public void labelPlacementTest() {
        for (int i = 1; i <= 4; i++) {
            Button currentRadioButton = labelPlacementButtons.get(i);
            Button currentButtonClass = labelPlacementButtonsClass.get(i);
            if (i != 4)
                currentRadioButton.has().classValue(containsString(classes.get(i - 1)));
            currentRadioButton.click();
            timer.wait(() -> currentButtonClass.has().classValue(containsString("Mui-checked")));
        }
    }

    @Test
    public void showErrorTest() {
        for (int i = 1; i <= 2; i++) {
            showErrorButtons.get(i).click();
            checkAnswer.click();
            int finalI = i;
            timer.wait(() -> errorText.is().text(messages.get(finalI - 1)));
        }
    }
}
