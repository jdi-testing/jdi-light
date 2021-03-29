package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import javafx.util.Pair;
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
        clickAwayListenerFrame.text.is().displayed();
        //initializing all border points of a text field
        initPoints();
        //hiding text field by clicking on 'open menu dropdown' button
        clickAwayListenerFrame.openMenuButton.click();
        clickAwayListenerFrame.text.is().hidden();
        //checking all border points of a text field
        for (Pair<Integer, Integer> point : points) {
            clickAwayListenerFrame.openMenuButton.click();
            clickAwayListenerFrame.text.is().displayed();
            clickAwayListenerFrame.text.click(point.getKey(), point.getValue());
            clickAwayListenerFrame.text.is().hidden();
        }
        //failed check for fixing bug
//        clickAwayListenerFrame.openMenuButton.click();
//        clickAwayListenerFrame.openMenuButton.click(clickAwayListenerFrame.openMenuButton.getSize().width + 1,0);
//        clickAwayListenerFrame.text.is().hidden();
    }
    //for checking borders of a text field
    private void initPoints() {
        if (points == null) {
            points = new ArrayList<>();
            addPoint(-1, 0);
            addPoint(-1, -1);
            addPoint(0, -1);
            addPoint(clickAwayListenerFrame.text.getSize().width, -1);
            addPoint(clickAwayListenerFrame.text.getSize().width + 1, -1);
            addPoint(clickAwayListenerFrame.text.getSize().width + 1, 0);
            addPoint(clickAwayListenerFrame.text.getSize().width + 1, clickAwayListenerFrame.text.getSize().height);
            addPoint(clickAwayListenerFrame.text.getSize().width + 1, clickAwayListenerFrame.text.getSize().height + 1);
            addPoint(clickAwayListenerFrame.text.getSize().width, clickAwayListenerFrame.text.getSize().height + 1);
            addPoint(0, clickAwayListenerFrame.text.getSize().height + 1);
            addPoint(-1, clickAwayListenerFrame.text.getSize().height + 1);
            addPoint(-1, clickAwayListenerFrame.text.getSize().height);
        }
    }

    private void addPoint(int x, int y) {
        points.add(new Pair<>(x, y));
    }
}
