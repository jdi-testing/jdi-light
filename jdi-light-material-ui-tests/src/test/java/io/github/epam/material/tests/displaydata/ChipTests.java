package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Chip;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.displaydata.ChipsPage.arrayChips;
import static io.github.com.pages.displaydata.ChipsPage.basicChips;
import static io.github.com.pages.displaydata.ChipsPage.lastClickArrayInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastClickBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.linkChips;

public class ChipTests extends TestsInit {

    static final String BASIC_CLICK_TEXT = "You clicked on:";

    @BeforeMethod
    public void beforeTest() {
        chipsPage.open();
        chipsPage.isOpened();
    }

    @Test()
    public void basicFunctionalityChipTest() {
        String text = "Clickable deletable";
        Chip chip = basicChips.get(5);
        String clickInfoText = String.format(BASIC_CLICK_TEXT + " %s", text).trim();

        chip.is().displayed();
        chip.label().has().text(text);
        chip.is().enabled();
        chip.is().clickable();
        chip.click();
        lastClickBasicInfo.has().text(clickInfoText);
    }

    @Test()
    public void iconTest() {
        Chip chip = basicChips.get(5);
        chip.icon().is().displayed();
        chip.icon().click();
        lastClickBasicInfo.has().text(BASIC_CLICK_TEXT);
    }

    @Test()
    public void avatarTest() {
        Chip chip = basicChips.get(3);
        chip.avatar().is().displayed();
        chip.is().clickable();
        chip.avatar().click();
        String clickOnAvatarInfoText = String.format(BASIC_CLICK_TEXT + " %s", chip.avatar().text()).trim();
        lastClickBasicInfo.has().text(clickOnAvatarInfoText);
    }

    @Test()
    public void linkTest() {
        Chip chip = linkChips.get(2);
        String text = "Clickable link";
        String href = "https://jdi-testing.github.io/jdi-light/material/chips#chip";

        chip.is().displayed();
        chip.label().has().text(text);
        chip.is().link();
        chip.has().href(href);
        chip.is().outlined();
        chip.is().clickable();
        chip.click();
        chip.is().notVisible();
    }

    @Test()
    public void deleteChipTest() {
        Chip chip = arrayChips.get(3);
        String text = "Polymer";
        String clickInfoText = String.format(BASIC_CLICK_TEXT + " %s", text).trim();
        chip.is().displayed();
        chip.label().has().text(text);
        chip.is().enabled();
        chip.is().clickable();
        chip.click();
        lastClickArrayInfo.has().text(clickInfoText);
        chip.is().deletable();
        chip.delete();
        chip.is().notVisible();
    }
}
