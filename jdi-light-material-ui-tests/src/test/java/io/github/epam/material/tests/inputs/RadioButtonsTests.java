package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.pages.inputs.RadioButtonsPage.checkAnswer;
import static io.github.com.pages.inputs.RadioButtonsPage.labelPlacementRadioButtons;
import static io.github.com.pages.inputs.RadioButtonsPage.lastRadioText;
import static io.github.com.pages.inputs.RadioButtonsPage.quizAnswer;
import static io.github.com.pages.inputs.RadioButtonsPage.quizRadioButtons;
import static io.github.com.pages.inputs.RadioButtonsPage.popQuiz;
import static io.github.com.pages.inputs.RadioButtonsPage.simpleRadioButtons;

import static io.github.epam.enums.Colors.GREY_600_TRANSPARENT;
import static io.github.epam.enums.Colors.INDIGO_500;
import static io.github.epam.enums.Colors.RED_500;
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
        labelPlacementRadioButtons.has().position(1, Position.TOP);
        labelPlacementRadioButtons.has().position("Start", Position.START);
        labelPlacementRadioButtons.has().position(2, Position.BOTTOM);
        labelPlacementRadioButtons.has().position("End", Position.END);
        asList("Top", "Start", "Bottom", "End").forEach(label -> {
            labelPlacementRadioButtons.select(label);
            labelPlacementRadioButtons.has().selected(label);
        });
    }

    @Test
    public void quizTest() {
        quizRadioButtons.has().values("The best!", "The worst.").and().enabled();

        popQuiz.has().text(containsString("Pop quiz: Material-UI is..."));
        popQuiz.has().css("color", GREY_600_TRANSPARENT.rgba());

        quizAnswer.has().text(containsString("Choose wisely"));
        quizAnswer.has().css("color", GREY_600_TRANSPARENT.rgba());

        quizRadioButtons.select("The worst.");
        quizRadioButtons.has().selected(2);

        checkAnswer.click();

        quizAnswer.is().displayed();
        quizAnswer.has().text(containsString("Sorry, wrong answer!"));
        quizAnswer.has().css("color", RED_500.rgba());
        popQuiz.has().css("color", RED_500.rgba());


        quizRadioButtons.select("The best!");
        quizRadioButtons.has().selected("The best!");
        popQuiz.has().css("color", INDIGO_500.rgba());

        checkAnswer.click();

        quizAnswer.is().displayed();
        quizAnswer.has().text(containsString("You got it!"));
        quizAnswer.has().css("color", GREY_600_TRANSPARENT.rgba());
    }
}
