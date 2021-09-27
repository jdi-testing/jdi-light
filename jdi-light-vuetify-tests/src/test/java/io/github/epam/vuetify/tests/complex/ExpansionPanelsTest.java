package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.ExpansionPanels;
import io.github.com.StaticSite;import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static io.github.com.pages.ExpansionPanelsPage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExpansionPanelsTest extends TestsInit {

    String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    @BeforeSuite
    public void before() {
        StaticSite.expansionPanelsPage.open();
        StaticSite.expansionPanelsPage.checkOpened();
    }

    @Test
    public void accordionExpansionPanelTest() {
        accordionExpansionPanels.has().size(5);
        accordionExpansionPanels.panels().forEach(expansionPanel -> {
            expansionPanel.getIcon().click();
            expansionPanel.getHeader().has().text("Item");
            expansionPanel.getWrapper().has().text(TEXT);
            expansionPanel
                    .is().open();
        });
    }
//
//    @Test
//    public void disabledExpansionPanelTest() {
//        disabledExpansionPanels.has().size(3);
//        disabledExpansionPanels.get(1).is().open();
//        disabledExpansionPanels.get(2).is().open();
//        disabledExpansionPanels.get(3).is().closed();
//
//        disableCheckbox.check();
//        disabledExpansionPanels.forEach(expansionPanel -> expansionPanel.is().disabled());
//
//        disableCheckbox.check();
//        disabledExpansionPanels.forEach(expansionPanel -> expansionPanel.is().enabled());
//    }
//
//    @Test
//    public void focusableExpansionPanelTest() {
//        focusableExpansionPanels.has().size(5);
//        focusableExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.getHeader().has().text("Item");
//            expansionPanel.getWrapper().has().text(TEXT);
//            expansionPanel.is().open();
//        });
//    }
//
//    @Test
//    public void insetExpansionPanelTest() {
//        insetExpansionPanels.has().size(5);
//        insetExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.getHeader().has().text("Item");
//            expansionPanel.getWrapper().has().text(TEXT);
//            expansionPanel.is().open();
//        });
//    }
//
//    @Test
//    public void modelExpansionPanelTest(){
//        modelExpansionPanels.has().size(5);
//        modelExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.getHeader().has().text(containsString("Header"));
//            expansionPanel.getWrapper().has().text(TEXT);
//            expansionPanel.is().open();
//        });
//        openPanelText.is().text("[ 0, 1, 2, 3, 4 ]");
//        noneButton.click();
//        openPanelText.is().text("[]");
//        modelExpansionPanels.forEach(expansionPanel -> expansionPanel.is().closed());
//        allButton.click();
//        modelExpansionPanels.forEach(expansionPanel -> expansionPanel.is().open());
//    }
//
//    @Test
//    public void popOutExpansionPanelTest(){
//        popOutExpansionPanels.has().size(5);
//        popOutExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.getHeader().has().text("Item");
//            expansionPanel.getWrapper().has().text(TEXT);
//            expansionPanel.is().open();
//        });
//        popOutExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.close();
//            expansionPanel.is().closed();
//        });
//        popOutExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.open();
//            expansionPanel.is().open();
//        });
//    }
//
//    @Test
//    public void readOnlyExpansionPanelTest() {
//        readOnlyExpansionPanels.has().size(3);
//        readOnlyExpansionPanels.get(1).is().open();
//        readOnlyExpansionPanels.get(2).is().open();
//        readOnlyExpansionPanels.get(3).is().closed();
//
//        readOnlyCheckbox.check();
//        readOnlyExpansionPanels.forEach(ExpansionPanel::open);
//        readOnlyExpansionPanels.get(1).is().open();
//        readOnlyExpansionPanels.get(2).is().open();
//        readOnlyExpansionPanels.get(3).is().closed();
//
//        readOnlyCheckbox.check();
//        readOnlyExpansionPanels.forEach(expansionPanel -> {
//            expansionPanel.open();
//            expansionPanel.is().open();
//        });
//    }
//
//    @Test
//    public void advancedExpansionPanelTest() {
//        advancedExpansionPanels.has().size(3);
//
//        String tripName = "My trip name";
//        ExpansionPanel expansionPanel = advancedExpansionPanels.get(1);
//        expansionPanel
//                .getWrapper()
//                .find(By.tagName("input"))
//                .sendKeys(tripName);
//        expansionPanel.close();
//        expansionPanel
//                .getHeader()
//                .find(By.cssSelector(".text--secondary span"))
//                .wait(uiElement -> uiElement.getText().equals(tripName));
//
//        String countryName = "Ecuador";
//        expansionPanel = advancedExpansionPanels.get(2);
//        expansionPanel
//                .getWrapper()
//                .find(By.tagName("input"))
//                .sendKeys(countryName);
//        expansionPanel.close();
//        expansionPanel
//                .getHeader()
//                .find(By.cssSelector(".text--secondary span"))
//                .wait(uiElement -> uiElement.getText().equals(countryName));
//
//        List<String> listWhenClosedExpected = Arrays.asList("Start date: Not set", "End date: Not set");
//        expansionPanel = advancedExpansionPanels.get(3);
//        expansionPanel.close();
//        WebList listWhenClosedActual = expansionPanel
//                .getHeader()
//                .finds(By.cssSelector(".text--secondary div.col-6"));
//
//        listWhenClosedActual.has().size(listWhenClosedExpected.size());
//        List<String> listWhenClosedActualStrings = new ArrayList<>(listWhenClosedActual.map(UIElement::getText));
//        assertThat(listWhenClosedActualStrings, equalTo(listWhenClosedExpected));
//    }
//
//    @Test
//    public void customIconExpansionPanelTest() {
//        customIconExpansionPanelsSameIcons.has().size(5);
//        customIconExpansionPanelsSameIcons.forEach(expansionPanel -> {
//            expansionPanel.getHeader().has().text("Item");
//            expansionPanel.getWrapper().has().text(TEXT);
//            expansionPanel.is().open();
//        });
//        customIconExpansionPanelsSameIcons.all(expansionPanel -> expansionPanel.getIcon().isDisplayed());
//        customIconExpansionPanelsDifferentIcons.has().size(3);
//        customIconExpansionPanelsDifferentIcons.all(expansionPanel -> expansionPanel.getIcon().isDisplayed());
//    }

}
