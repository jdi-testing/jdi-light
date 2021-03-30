package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ChipTests extends TestsInit {
    @Test
    public void defaultChipTest(){
        displayDataDefaultChipPage.open();

        basicCheck();
        disabledCheck();// first variant of class value
        clickableCheck(3);
        clickableLinkCheck(7);
    }

    @Test
    public void outlinedChipTest(){
        displayDataOutlinedChipPage.open();

        basicCheck();
        disabledCheck(); // second variant of class value
        clickableCheck(3);
        clickableLinkCheck(7);
    }

    @Test
    public void chipArrayTest(){
        displayDataArrayChipPage.open();

        chipFrame.chips.is().displayed(1);
        chipFrame.chips.is().text(1, hasToString("Angular"));
        chipFrame.chips.is().displayed(2);
        chipFrame.chips.is().text(2, hasToString("jQuery"));
        chipFrame.chips.getChipIcon(1).click();
        chipFrame.chips.is().text(1, hasToString("jQuery")); // "jQuery" became first element as "Angular" element was deleted
    }

    @Test
    public void smallDefaultChipTest(){
        displayDataSmallDefaultChipPage.open();

        basicCheck();
        clickableCheck(2);
        clickableLinkCheck(6);
    }

    @Test
    public void smallOutlinedChipTest(){
        displayDataSmallOutlinedChipPage.open();

        basicCheck();
        clickableCheck(2);
        clickableLinkCheck(6);
    }

    public void basicCheck(){
        chipFrame.chips.is().displayed(1);
        chipFrame.chips.is().text(1, hasToString("Basic"));
    }

    public void disabledCheck(){
        chipFrame.chips.is().displayed(2);
        chipFrame.chips.is().disabled(2);
        chipFrame.chips.is().text(2, hasToString("Disabled"));
    }

    public void clickableCheck(int index){
        chipFrame.chips.is().displayed(index);
        chipFrame.chips.is().clickable(index);
        chipFrame.chips.is().text(index, hasToString("Clickable"));
    }

    public void clickableLinkCheck(int index){
        chipFrame.chips.is().displayed(index);
        chipFrame.chips.is().text(index, equalToIgnoringCase("Clickable Link"));
        chipFrame.chips.click(index);
        chipFrame.chips.is().urlContains("viewMode=story#chip");
    }
}
