package io.github.epam.material.tests.displaydata;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.scrollToTop;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.displaydata.ChipsPage.basicChip;
import static io.github.com.pages.displaydata.ChipsPage.basicClickableChip;
import static io.github.com.pages.displaydata.ChipsPage.basicDisabledChip;
import static io.github.com.pages.displaydata.ChipsPage.chipArrayAngular;
import static io.github.com.pages.displaydata.ChipsPage.chipArrayJquery;
import static io.github.com.pages.displaydata.ChipsPage.chipArrayPolymer;
import static io.github.com.pages.displaydata.ChipsPage.chipArrayReact;
import static io.github.com.pages.displaydata.ChipsPage.chipArrayVuejs;
import static io.github.com.pages.displaydata.ChipsPage.clickableDeletableBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.clickableLinkBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.customDeleteIconBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.deletableBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.deletablePrimaryBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.deletableSecondaryBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.lastClickArrayInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastClickBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastClickOutlinedInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastDeleteBasicInfo;
import static io.github.com.pages.displaydata.ChipsPage.lastDeleteOutlinedInfo;
import static io.github.com.pages.displaydata.ChipsPage.outlinedChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedClickableChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedClickableDeletableChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedClickableLinkChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedCustomDeleteIconChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedDeletableChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedDisabledChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedPrimaryClickableChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedPrimaryClickableWithFaceChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedPrimaryDeletableChip;
import static io.github.com.pages.displaydata.ChipsPage.outlinedSecondaryDeletableChip;
import static io.github.com.pages.displaydata.ChipsPage.primaryClickableBasicChip;
import static io.github.com.pages.displaydata.ChipsPage.primaryClickableWithFaceBasicChip;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Chips web element please visit
 * https://material-ui.com/ru/components/chips/
 */

public class ChipTests extends TestsInit {

    Timer timer = new Timer(2000L);

    @BeforeMethod
    public void beforeTest() {
        chipsPage.open();
    }

    @Test
    public void basiChipsTest() {
        basicChip.is().displayed();
        basicChip.has().text("Basic");

        basicDisabledChip.is().displayed();
        basicDisabledChip.is().disabled();
        basicDisabledChip.has().text("Disabled");

        basicClickableChip.is().displayed();
        basicClickableChip.has().text("Clickable");
        basicClickableChip.click();
        lastClickBasicInfo.has().text(containsString("Clickable"));
        basicClickableChip.getChipIcon().click();
        lastClickBasicInfo.has().text(containsString("M"));

        deletableBasicChip.is().displayed();
        deletableBasicChip.has().text("Deletable");
        deletableBasicChip.is().deletable();
        deletableBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Deletable"));

        clickableDeletableBasicChip.is().displayed();
        clickableDeletableBasicChip.has().text("Clickable deletable");
        clickableDeletableBasicChip.is().clickable();
        clickableDeletableBasicChip.is().deletable();
        clickableDeletableBasicChip.click();
        lastClickBasicInfo.has().text(containsString("Clickable deletable"));
        clickableDeletableBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Clickable deletable"));

        customDeleteIconBasicChip.is().displayed();
        customDeleteIconBasicChip.has().text("Custom delete icon");
        customDeleteIconBasicChip.is().clickable();
        customDeleteIconBasicChip.is().deletable();
        customDeleteIconBasicChip.click();
        lastClickBasicInfo.has().text(containsString("Custom delete icon"));
        customDeleteIconBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Custom delete icon"));

        clickableLinkBasicChip.is().displayed();
        clickableLinkBasicChip.has().text("Clickable Link");
        clickableLinkBasicChip.is().clickable();
        clickableLinkBasicChip.click();
        timer.wait(() -> clickableLinkBasicChip.is().notDisplayed());

        scrollToTop();
        primaryClickableBasicChip.is().displayed();
        primaryClickableBasicChip.has().text("Primary clickable");
        primaryClickableBasicChip.is().clickable();
        primaryClickableBasicChip.is().deletable();
        primaryClickableBasicChip.click();
        primaryClickableBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Primary clickable"));

        primaryClickableWithFaceBasicChip.is().displayed();
        primaryClickableWithFaceBasicChip.has().text("Primary clickable with face");
        primaryClickableWithFaceBasicChip.is().clickable();
        primaryClickableWithFaceBasicChip.is().deletable();
        primaryClickableWithFaceBasicChip.click();
        lastClickBasicInfo.has().text(containsString("Primary clickable with face"));
        primaryClickableWithFaceBasicChip.getChipIcon().click();
        lastClickBasicInfo.has().text("You clicked on:");
        primaryClickableWithFaceBasicChip.delete();

        deletablePrimaryBasicChip.is().displayed();
        deletablePrimaryBasicChip.has().text("Deletable primary");
        deletablePrimaryBasicChip.is().clickable();
        deletablePrimaryBasicChip.click();
        deletablePrimaryBasicChip.is().deletable();
        deletablePrimaryBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Deletable primary"));

        deletableSecondaryBasicChip.is().displayed();
        deletableSecondaryBasicChip.has().text("Deletable secondary");
        deletableSecondaryBasicChip.is().clickable();
        deletableSecondaryBasicChip.click();
        deletableSecondaryBasicChip.is().deletable();
        deletableSecondaryBasicChip.delete();
        lastDeleteBasicInfo.has().text(containsString("Deletable secondary"));
    }

    @Test
    public void outlinedChipsTest() {
        outlinedChip.is().displayed();
        outlinedChip.has().text("Basic");
        outlinedChip.is().clickable();
        outlinedChip.click();
        lastClickOutlinedInfo.has().text(containsString("Basic"));

        outlinedDisabledChip.is().displayed();
        outlinedDisabledChip.is().disabled();
        outlinedDisabledChip.has().text("Disabled");

        outlinedClickableChip.is().displayed();
        outlinedClickableChip.has().text("Clickable");
        outlinedClickableChip.is().clickable();
        outlinedClickableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Clickable"));
        outlinedClickableChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text(containsString("M"));

        outlinedDeletableChip.is().displayed();
        outlinedDeletableChip.has().text("Deletable");
        outlinedDeletableChip.is().clickable();
        outlinedDeletableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Deletable"));
        outlinedDeletableChip.is().deletable();
        outlinedDeletableChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Deletable"));
        outlinedDeletableChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text(containsString(""));

        outlinedClickableDeletableChip.is().displayed();
        outlinedClickableDeletableChip.has().text("Clickable deletable");
        outlinedClickableDeletableChip.is().clickable();
        outlinedClickableDeletableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Clickable deletable"));
        outlinedClickableDeletableChip.is().deletable();
        outlinedClickableDeletableChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Clickable deletable"));
        outlinedClickableDeletableChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text(containsString(""));

        outlinedCustomDeleteIconChip.is().displayed();
        outlinedCustomDeleteIconChip.has().text("Custom delete icon");
        outlinedCustomDeleteIconChip.is().clickable();
        outlinedCustomDeleteIconChip.click();
        lastClickOutlinedInfo.has().text(containsString("Custom delete icon"));
        outlinedCustomDeleteIconChip.is().deletable();
        outlinedCustomDeleteIconChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Custom delete icon"));

        outlinedClickableLinkChip.is().displayed();
        outlinedClickableLinkChip.has().text("Clickable link");
        outlinedClickableLinkChip.is().clickable();
        outlinedClickableLinkChip.click();
        timer.wait(() -> outlinedClickableLinkChip.is().notDisplayed());

        scrollToTop();
        outlinedPrimaryClickableChip.is().displayed();
        outlinedPrimaryClickableChip.has().text("Primary clickable");
        outlinedPrimaryClickableChip.is().clickable();
        outlinedPrimaryClickableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Primary clickable"));
        outlinedPrimaryClickableChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text(containsString("M"));
        outlinedPrimaryClickableChip.is().deletable();
        outlinedPrimaryClickableChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Primary clickable"));

        outlinedPrimaryClickableWithFaceChip.is().displayed();
        outlinedPrimaryClickableWithFaceChip.has().text("Primary clickable with face");
        outlinedPrimaryClickableWithFaceChip.is().clickable();
        outlinedPrimaryClickableWithFaceChip.click();
        lastClickOutlinedInfo.has().text(containsString("Primary clickable with face"));
        outlinedPrimaryClickableWithFaceChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text("You clicked on:");
        outlinedPrimaryClickableWithFaceChip.is().deletable();
        outlinedPrimaryClickableWithFaceChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Primary clickable with face"));

        outlinedPrimaryDeletableChip.is().displayed();
        outlinedPrimaryDeletableChip.has().text("Deletable primary");
        outlinedPrimaryDeletableChip.is().clickable();
        outlinedPrimaryDeletableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Deletable primary"));
        outlinedPrimaryDeletableChip.is().deletable();
        outlinedPrimaryDeletableChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Deletable primary"));

        outlinedSecondaryDeletableChip.is().displayed();
        outlinedSecondaryDeletableChip.has().text("Deletable secondary");
        outlinedSecondaryDeletableChip.is().clickable();
        outlinedSecondaryDeletableChip.click();
        lastClickOutlinedInfo.has().text(containsString("Deletable secondary"));
        outlinedSecondaryDeletableChip.is().deletable();
        outlinedSecondaryDeletableChip.delete();
        lastDeleteOutlinedInfo.has().text(containsString("Deletable secondary"));
        outlinedSecondaryDeletableChip.getChipIcon().click();
        lastClickOutlinedInfo.has().text("You clicked on:");
    }

    @Test
    public void chipArrayTest() {
        chipArrayAngular.show();
        chipArrayAngular.is().displayed();
        chipArrayAngular.has().text("Angular");
        chipArrayAngular.is().clickable();
        chipArrayAngular.click();
        lastClickArrayInfo.has().text(containsString("Angular"));
        chipArrayAngular.is().deletable();

        chipArrayJquery.is().displayed();
        chipArrayJquery.has().text("jQuery");
        chipArrayJquery.is().clickable();
        chipArrayJquery.click();
        lastClickArrayInfo.has().text(containsString("jQuery"));
        chipArrayJquery.is().deletable();

        chipArrayPolymer.is().displayed();
        chipArrayPolymer.has().text("Polymer");
        chipArrayPolymer.is().clickable();
        chipArrayPolymer.click();
        lastClickArrayInfo.has().text(containsString("Polymer"));
        chipArrayPolymer.is().deletable();

        chipArrayReact.is().displayed();
        chipArrayReact.has().text("React");
        chipArrayReact.is().clickable();
        chipArrayReact.click();
        lastClickArrayInfo.has().text(containsString("React"));
        chipArrayReact.is().notDeletable();

        chipArrayVuejs.is().displayed();
        chipArrayVuejs.has().text("Vue.js");
        chipArrayVuejs.is().clickable();
        chipArrayVuejs.click();
        lastClickArrayInfo.has().text(containsString("Vue.js"));

        chipArrayVuejs.delete();
        chipArrayPolymer.delete();
        chipArrayJquery.delete();
        chipArrayAngular.delete();
        chipArrayAngular.has().text("React");
    }
}
