package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Chip;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.displaydata.ChipsPage.*;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

/**
 * To see an example of Chips web element please visit
 * https://material-ui.com/ru/components/chips/
 */

public class ChipTests extends TestsInit {
    
    @BeforeMethod
    public void beforeTest() {
        chipsPage.open();
    }
    
    @Test
    public void defaultChipTest(){
        basicCheck(defaultChips);
        disabledCheck(defaultChips);// first variant of class value
        clickableCheck(defaultChips,3);
        clickableLinkCheck(defaultChips,7);
    }

    @Test
    public void outlinedChipTest(){
        basicCheck(outlinedChips);
        disabledCheck(outlinedChips); // second variant of class value
        clickableCheck(outlinedChips, 3);
        clickableLinkCheck(outlinedChips, 7);
    }

    @Test
    public void chipArrayTest(){
        chipArrays.is().displayed(1);
        chipArrays.is().text(1, hasToString("Angular"));
        chipArrays.is().displayed(2);
        chipArrays.is().text(2, hasToString("jQuery"));
        chipArrays.getChipIcon(1).click();
        chipArrays.is().text(1, hasToString("jQuery")); // "jQuery" became first element as "Angular" element was deleted
    }

    public void basicCheck(Chip chips){
        chips.is().displayed(1);
        chips.is().text(1, hasToString("Basic"));
    }

    public void disabledCheck(Chip chips){
        chips.is().displayed(2);
        chips.is().disabled(2);
        chips.is().text(2, hasToString("Disabled"));
    }

    public void clickableCheck(Chip chips, int index){
        chips.is().displayed(index);
        chips.is().clickable(index);
        chips.is().text(index, hasToString("Clickable"));
    }

    public void clickableLinkCheck(Chip chips, int index){
        chips.is().displayed(index);
        chips.is().text(index, equalToIgnoringCase("Clickable Link"));
        chips.click(index);
        chips.is().urlContains("#chip");
    }
}
