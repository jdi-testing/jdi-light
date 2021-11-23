package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.utils.enums.LabelPosition;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioPage;
import static io.github.com.pages.inputs.RadioPage.checkAnswer;
import static io.github.com.pages.inputs.RadioPage.labelPlacementRadio;
import static io.github.com.pages.inputs.RadioPage.lastRadioText;
import static io.github.com.pages.inputs.RadioPage.quizRadio;
import static io.github.com.pages.inputs.RadioPage.quizText;
import static io.github.com.pages.inputs.RadioPage.simpleRadio;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Radio Button web element please visit
 * https://material-ui.com/components/radio-buttons/
 */

public class RadioTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        radioPage.open();
        radioPage.checkOpened();
    }

    @Test
    public void simpleRadioTest() {
        System.out.println(simpleRadio.values());
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
        labelPlacementRadio.has().selected(1);
        labelPlacementRadio.has().selected("Top");
        labelPlacementRadio.has().labelPosition(1, LabelPosition.TOP);
        labelPlacementRadio.has().labelPosition("Start", LabelPosition.START);
        labelPlacementRadio.has().labelPosition(2, LabelPosition.BOTTOM);
        labelPlacementRadio.has().labelPosition("End", LabelPosition.END);
    }

    @Test
    public void quizTest() {
        quizRadio.select("The worst.");
        quizRadio.has().selected("The worst.");
        checkAnswer.click();
        quizText.has().text(containsString("Sorry, wrong answer!"));

        quizRadio.select("The best!");
        quizRadio.has().selected("The best!");
        checkAnswer.click();
        quizText.has().text(containsString("You got it!"));
    }
}
