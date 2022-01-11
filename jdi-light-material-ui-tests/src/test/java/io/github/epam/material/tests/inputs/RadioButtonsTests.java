package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.utils.enums.LabelPosition;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.pages.inputs.RadioButtonsPage.checkAnswer;
import static io.github.com.pages.inputs.RadioButtonsPage.labelPlacementRadioButtons;
import static io.github.com.pages.inputs.RadioButtonsPage.lastRadioText;
import static io.github.com.pages.inputs.RadioButtonsPage.quizRadioButtons;
import static io.github.com.pages.inputs.RadioButtonsPage.quizText;
import static io.github.com.pages.inputs.RadioButtonsPage.simpleRadioButtons;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;

public class RadioButtonsTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        radioButtonsPage.open();
        radioButtonsPage.checkOpened();
    }

    @Test
    public void simpleRadioTest() {
        simpleRadioButtons.has().values("First", "Second", "Third", "Disabled");
        simpleRadioButtons.has().enabled("First", "Second", "Third");
        simpleRadioButtons.has().disabled("Disabled");
        asList("First", "Second", "Third").forEach(label -> {
            simpleRadioButtons.select(label);
            simpleRadioButtons.has().selected(label);
            lastRadioText.has().text(containsString(label));
        });
    }

    @Test
    public void labelPlacementTest() {
        labelPlacementRadioButtons.has().size(4);
        labelPlacementRadioButtons.has().selected(1);
        labelPlacementRadioButtons.has().selected("Top");
        labelPlacementRadioButtons.has().labelPosition(1, LabelPosition.TOP);
        labelPlacementRadioButtons.has().labelPosition("Start", LabelPosition.START);
        labelPlacementRadioButtons.has().labelPosition(2, LabelPosition.BOTTOM);
        labelPlacementRadioButtons.has().labelPosition("End", LabelPosition.END);
    }

    @Test
    public void quizTest() {
        quizRadioButtons.select("The worst.");
        quizRadioButtons.has().selected("The worst.");
        checkAnswer.click();
        quizText.has().text(containsString("Sorry, wrong answer!"));

        quizRadioButtons.select("The best!");
        quizRadioButtons.has().selected("The best!");
        checkAnswer.click();
        quizText.has().text(containsString("You got it!"));
    }
}