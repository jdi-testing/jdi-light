package io.github.epam.material.tests.utils;

import com.epam.jdi.tools.pairs.Pair;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.github.com.StaticSite.utilsClickAwayListenerDefaultPage;
import static io.github.com.StaticSite.clickAwayListenerFrame;
import static io.github.com.StaticSite.utilsClickAwayListenerPortalExamplePage;

public class ClickAwayListenerTests extends TestsInit {

    private ArrayList<Pair<Integer, Integer>> points;

    @Test
    public void defaultClickAwayListenerTest() {
        utilsClickAwayListenerDefaultPage.open();
        textFieldTest();
    }

    @Test
    public void portalExampleClickAwayListenerTest() {
        utilsClickAwayListenerPortalExamplePage.open();
        textFieldTest();
    }

    private void textFieldTest() {
        clickAwayListenerFrame.openMenuButton.click();
        clickAwayListenerFrame.textArea.is().displayed();
        //initializing all border points of a text field
        initPoints();
        //hiding text field by clicking on 'open menu dropdown' button
        clickAwayListenerFrame.openMenuButton.click();
        clickAwayListenerFrame.textArea.is().hidden();
        //checking all border points of a text field
        for (Pair<Integer, Integer> point : points) {
            clickAwayListenerFrame.openMenuButton.click();
            clickAwayListenerFrame.textArea.is().displayed();
            clickAwayListenerFrame.clickAroundTextPopup(point.key, point.value);
            clickAwayListenerFrame.textArea.is().hidden();
        }
        //failed check for fixing bug
//        clickAwayListenerFrame.openMenuButton.click();
//        clickAwayListenerFrame.clickAroundButton(clickAwayListenerFrame.openMenuButton.getSize().width + 1,0);
//        clickAwayListenerFrame.text.is().hidden();
    }
    //for checking borders of a text field
    private void initPoints() {
        if (points == null) {
            points = new ArrayList<>();
            addPoint(-1, 0);
            addPoint(-1, -1);
            addPoint(0, -1);
            addPoint(clickAwayListenerFrame.textArea.getSize().width, -1);
            addPoint(clickAwayListenerFrame.textArea.getSize().width + 1, -1);
            addPoint(clickAwayListenerFrame.textArea.getSize().width + 1, 0);
            addPoint(clickAwayListenerFrame.textArea.getSize().width + 1, clickAwayListenerFrame.textArea.getSize().height);
            addPoint(clickAwayListenerFrame.textArea.getSize().width + 1, clickAwayListenerFrame.textArea.getSize().height + 1);
            addPoint(clickAwayListenerFrame.textArea.getSize().width, clickAwayListenerFrame.textArea.getSize().height + 1);
            addPoint(0, clickAwayListenerFrame.textArea.getSize().height + 1);
            addPoint(-1, clickAwayListenerFrame.textArea.getSize().height + 1);
            addPoint(-1, clickAwayListenerFrame.textArea.getSize().height);
        }
    }

    private void addPoint(int x, int y) {
        points.add(new Pair<>(x, y));
    }
}
