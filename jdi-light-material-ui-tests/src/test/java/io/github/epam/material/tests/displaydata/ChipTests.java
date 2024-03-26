package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Chip;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.displaydata.ChipsPage.arrayChips;
import static io.github.com.pages.displaydata.ChipsPage.basicChips;
import static io.github.com.pages.displaydata.ChipsPage.lastClickBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.linkChips;

public class ChipTests extends TestsInit {

    static final String BASIC_CLICK_TEXT = "You clicked on:";

    @BeforeClass
    public void beforeTest() {
        chipsPage.open();
        chipsPage.isOpened();
    }

    @Test
    public void basicFunctionalityChipTest() {
        String text = "Clickable deletable";
        Chip chip = basicChips.get(5);

        chip.show();
        chip.is().displayed().and().enabled().and().clickable();
        chip.label().has().text(text);
        chip.click();
        lastClickBasicInfo.has().text(BASIC_CLICK_TEXT + " " + text);
    }

    @Test
    public void iconTest() {
        Chip chip = basicChips.get(5);
        chip.show();
        chip.icon.is().displayed();
        chip.icon.click();
        lastClickBasicInfo.has().text(BASIC_CLICK_TEXT);
    }

    @Test
    public void avatarTest() {
        Chip chip = basicChips.get(3);
        chip.show();
        chip.avatar.is().displayed();
        chip.is().clickable();
        chip.avatar.click();
        lastClickBasicInfo.has().text(BASIC_CLICK_TEXT + " " + chip.avatar.text());
    }

    @Test
    public void linkTest() {
        Chip chip = linkChips.get(2);
        String text = "Clickable link";
        String href = "https://jdi-testing.github.io/jdi-light/material/chips#chip";

        chip.show();
        chip.is().displayed().and().link().and().clickable();
        chip.label().has().text(text);
        chip.has().ref(href);
        chip.click();
        chip.is().notVisible();
    }

    @Test
    public void deleteChipTest() {
        Chip chip = arrayChips.get(5);

        chip.show();
        chip.is().displayed().and().deletable();
        chip.delete();
        chip.is().notVisible();
    }

    @Test
    public void disabledChipTest() {
        Chip chip = basicChips.get(2);

        chip.show();
        chip.is().disabled();
    }
}
