package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.github.com.pages.inputs.RadioButtonPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.radioButtonPage;


public class RadioButtonTests extends TestsInit {
    static private final ArrayList<String> labels = new ArrayList<>(Arrays.asList("First", "Second", "Third", "Disabled"));
    static private final ArrayList<String> classes = new ArrayList<>(Arrays.asList("Top", "Start", "Bottom"));
    static private final ArrayList<String> messages = new ArrayList<>(Arrays.asList("You got it!", "Sorry, wrong answer!"));
    static private final Timer timer = new Timer(2000L);

    @BeforeTest()
    public void beforeTest() {
        openSection("Radio");
        radioButtonPage.isOpened();
    }

    @Test
    public void simpleRadioTest() {
        for (int i = 1; i <= 4; i++) {
            Button button = simpleRadioButtons.get(i);
            Button buttonClass = simpleRadioButtonsClass.get(i);
            button.click();
            if (i != 4)
                timer.wait(() -> buttonClass.has().classValue(Matchers.containsString("Mui-checked")));
            else
                timer.wait(() -> buttonClass.has().classValue(Matchers.containsString("Mui-disabled")));
            button.has().text(labels.get(i - 1));
            lastRadioText.has().text(Matchers.containsString(button.text()));
        }
    }

    @Test
    public void labelPlacementTest() {
        for (int i = 1; i <= 4; i++) {
            Button button = labelPlacementButtons.get(i);
            Button buttonClass = labelPlacementButtonsClass.get(i);
            if (i != 4)
                button.has().classValue(Matchers.containsString(classes.get(i - 1)));
            button.click();
            timer.wait(() -> buttonClass.has().classValue(Matchers.containsString("Mui-checked")));
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
