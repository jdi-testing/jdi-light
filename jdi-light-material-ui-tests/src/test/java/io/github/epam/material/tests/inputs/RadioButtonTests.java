package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.pages.inputs.RadioButtonPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.radioButtonPage;


public class RadioButtonTests extends TestsInit {
    static ArrayList<String> labels = new ArrayList() {{add("First"); add("Second"); add("Third"); add("Disabled");}};
    static ArrayList<String> classes = new ArrayList() {{add("Top"); add("Start"); add("Bottom");}};
    static ArrayList<String> messages = new ArrayList() {{add("You got it!"); add("Sorry, wrong answer!");}};

    @BeforeTest()
    public void beforeTest() {
        openSection("Radio");
        radioButtonPage.isOpened();
    }

    @Test
    public void simpleRadioTest() {
        for (int i = 1; i <= 4; i++) {
            selectRadio(i, 1);
        }
    }

    @Test
    public void labelPlacementTest() {
        for (int i = 1; i <= 4; i++) {
            selectRadio(i, 2);
        }
    }

    @Test
    public void showErrorTest() {
        for (int i = 1; i <= 2; i++) {
            selectRadio(i, 3);
        }
    }

    public void selectRadio(int x, int section) {
        switch(section) {
            case 1 :
                simpleRadioButtons.get(x).select();
                if (x != 4)
                    new Timer(5000L).wait(() -> simpleRadioButtonsClass.get(x).has().classValue(Matchers.containsString("Mui-checked")));
                simpleRadioButtons.get(x).has().text(labels.get(x - 1));
                lastRadioText.has().text(Matchers.containsString(simpleRadioButtons.get(x).text()));
                break;
            case 2 :
                if (x != 4)
                    labelPlacementButtons.get(x).has().classValue(Matchers.containsString(classes.get(x - 1)));
                labelPlacementButtons.get(x).select();
                new Timer(5000L).wait(() -> labelPlacementButtonsClass.get(x).has().classValue(Matchers.containsString("Mui-checked")));
                break;
            case 3:
                showErrorButtons.get(x).select();
                checkAnswer.click();
                new Timer(5000L).wait(() -> errorText.is().text(messages.get(x - 1)));
                break;
            default:
                break;
        }
    }
}
