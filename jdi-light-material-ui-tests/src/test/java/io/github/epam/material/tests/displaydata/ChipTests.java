package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Chip;
import io.github.epam.TestsInit;
import io.github.epam.test.data.ChipDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.displaydata.ChipsPage.angularChip;
import static io.github.com.pages.displaydata.ChipsPage.arrayChips;
import static io.github.com.pages.displaydata.ChipsPage.basicChips;
import static io.github.com.pages.displaydata.ChipsPage.jQueryChip;
import static io.github.com.pages.displaydata.ChipsPage.lastClickArrayInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastClickBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastClickOutlinedInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastDeleteBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastDeleteOutlinedInfo;
import static io.github.com.pages.displaydata.ChipsPage.linkChips;
import static io.github.com.pages.displaydata.ChipsPage.outlinedChips;
import static io.github.com.pages.displaydata.ChipsPage.polymerChip;
import static io.github.com.pages.displaydata.ChipsPage.vueJSChip;

public class ChipTests extends TestsInit {

    static final String basicClickText = "You clicked on:";

    @BeforeMethod
    public void beforeTest() {
        chipsPage.open();
    }

    @Test(dataProvider = "basicChipsTestsDataProvider", dataProviderClass = ChipDataProvider.class)
    public void basicChipsTests(int index, String text) {
        chipsCommonTestLogic(basicChips.get(index), text, false);
    }

    @Test(dataProvider = "outlinedChipsTestsDataProvider", dataProviderClass = ChipDataProvider.class)
    public void outlinedChipsTests(int index, String text) {
        chipsCommonTestLogic(outlinedChips.get(index), text, true);
    }

    @Test(dataProvider = "linkChipsTestsDataProvider", dataProviderClass = ChipDataProvider.class)
    public void linkChipsTests(int index, String text, boolean isOutlined, String href) {
        linkChips.get(index).is().displayed();
        linkChips.get(index).label().has().text(text);
        linkChips.get(index).is().link();
        linkChips.get(index).has().href(href);
        linkChips.get(index).is().clickable();
        if (isOutlined) {
            linkChips.get(index).is().outlined();
        }
        linkChips.get(index).click();
        linkChips.get(index).is().notVisible();
    }

    @Test(dataProvider = "arrayChipsTestsDataProvider", dataProviderClass = ChipDataProvider.class)
    public void arrayChipsTests(int index, String text) {
        arrayChipsTestLogic(arrayChips.get(index), text);
    }

    @Test
    public void chipDeleteTest() {
        angularChip.delete();
        angularChip.is().notVisible();
        jQueryChip.delete();
        jQueryChip.is().notVisible();
        polymerChip.delete();
        polymerChip.is().notVisible();
        vueJSChip.delete();
        vueJSChip.is().notVisible();
        jdiAssert(arrayChips.size(), Matchers.is(1));
    }

    public void chipsCommonTestLogic(Chip chip, String text, boolean isOutlined) {
        String clickInfoText = String.format(basicClickText + " %s", text).trim();
        String deleteInfoText = String.format("You delete : %s", text);
        chip.is().displayed();
        chip.label().has().text(text);
        if (isOutlined) {
            chip.is().outlined();
        }
        if (chip.isDisabled()) {
            chip.is().disabled();
        } else {
            chip.is().enabled();
        }
        if (chip.isClickable() && !chip.isDisabled()) {
            chip.is().clickable();
            chip.click();
            if(isOutlined) {
                lastClickOutlinedInfo.has().text(clickInfoText);
            } else {
                lastClickBasicInfo.has().text(clickInfoText);
            }
        }
        if (!chip.isClickable()) {
            chip.is().notClickable();
        }
        if (chip.avatar().isDisplayed() && chip.isClickable()) {
            String clickOnAvatarInfoText = String.format(basicClickText + " %s", chip.avatar().core().getText()).trim();
            chip.avatar().is().displayed();
            chip.avatar().click();
            if(isOutlined) {
                lastClickOutlinedInfo.has().text(clickOnAvatarInfoText);
            } else {
                lastClickBasicInfo.has().text(clickOnAvatarInfoText);
            }
        }
        if (chip.icon().isDisplayed() && chip.isClickable()) {
            chip.icon().is().displayed();
            chip.icon().click();
            if(isOutlined) {
                lastClickOutlinedInfo.has().text(basicClickText);
            } else {
                lastClickBasicInfo.has().text(basicClickText);
            }
        }
        if (chip.isDeletable()) {
            chip.is().deletable();
            chip.delete();
            if(isOutlined) {
                    lastDeleteOutlinedInfo.has().text(deleteInfoText);
            } else {
                lastDeleteBasicInfo.has().text(deleteInfoText);
            }
        }
        if (chip.hasPrimaryColor()) {
            chip.has().primaryColor();
        }
        if (chip.hasSecondaryColor()) {
            chip.has().secondaryColor();
        }
    }

    public void arrayChipsTestLogic(Chip chip, String text) {
        String clickInfoText = String.format(basicClickText + " %s", text).trim();
        chip.is().displayed();
        chip.label().has().text(text);
        chip.is().enabled();
        chip.is().clickable();
        chip.click();
        lastClickArrayInfo.has().text(clickInfoText);
        if (chip.icon().isDisplayed()) {
            chip.icon().is().displayed();
            chip.icon().click();
            lastClickArrayInfo.has().text(basicClickText);
            }
        if (chip.isDeletable()) {
            chip.is().deletable();
        }
    }
}