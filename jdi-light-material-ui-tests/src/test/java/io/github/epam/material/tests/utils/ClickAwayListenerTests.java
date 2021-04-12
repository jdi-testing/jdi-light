package io.github.epam.material.tests.utils;

import com.epam.jdi.tools.pairs.Pair;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.clickAwayListenerPage;

public class ClickAwayListenerTests extends TestsInit {

    private ArrayList<Pair<Integer, Integer>> points;

    @BeforeTest
    public void beforeTest() {
        openSection("Click Away Listener");
        clickAwayListenerPage.shouldBeOpened();
    }

    @Test
    public void exampleClickAwayListenerTest() {
        textFieldTest(1);
    }

    @Test
    public void portalExampleClickAwayListenerTest() {
        textFieldTest(2);
    }

    private void textFieldTest(int buttonId) {
        clickAwayListenerPage.clickButton(buttonId);
        clickAwayListenerPage.text.is().displayed();
        //initializing all border points of a text field
        initPoints();
        //hiding text field by clicking on 'open menu dropdown' button
        clickAwayListenerPage.clickButton(buttonId);
        clickAwayListenerPage.text.is().hidden();
        //checking all border points of a text field
        for (Pair<Integer, Integer> point : points) {
            clickAwayListenerPage.clickButton(buttonId);
            clickAwayListenerPage.text.is().displayed();
            clickAwayListenerPage.clickAroundTextPopup(point.key, point.value);
            clickAwayListenerPage.text.is().hidden();
        }
        //check for a fixed bug
        clickAwayListenerPage.clickButton(buttonId);
        clickAwayListenerPage.clickAroundButton(clickAwayListenerPage.exampleButton.getSize().width + 1,0, buttonId);
        clickAwayListenerPage.text.is().hidden();
    }
    //for checking borders of a text field
    private void initPoints() {
        if (points == null) {
            points = new ArrayList<>();
            addPoint(clickAwayListenerPage.text.getSize().width + 1, -1);
        }
    }

    private void addPoint(int x, int y) {
        points.add(new Pair<>(x, y));
    }
}
