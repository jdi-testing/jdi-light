package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.actions.ActionObject;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.bottomSheetsPage;
import static io.github.com.pages.BottomSheetsPage.bottomSheetPlayer;
import static io.github.com.pages.BottomSheetsPage.insetBottomSheet;
import static io.github.com.pages.BottomSheetsPage.insetBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.persistentBottomSheet;
import static io.github.com.pages.BottomSheetsPage.persistentBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.playerBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.vModelBottomSheet;
import static io.github.com.pages.BottomSheetsPage.vModelBottomSheetButton;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class BottomSheetsTests extends TestsInit {
    @BeforeClass
    public void before() {
        bottomSheetsPage.open();
        bottomSheetsPage.checkOpened();
    }

    @Test
    public void checkInsetSheetCssProps() {
        insetBottomSheet.is().hidden();

        insetBottomSheetButton.click();
        insetBottomSheet.is().displayed();
        insetBottomSheet.sheetText().has().text(containsString("the inset prop"));
        assertInsetSheetWidth();

        insetBottomSheet.close();
        insetBottomSheet.is().hidden();
    }

    @Test
    public void vModelSheetTest() {
        vModelBottomSheet.is().hidden();

        vModelBottomSheetButton.click();
        vModelBottomSheet.is().displayed();
        vModelBottomSheet.sheetText().has().text(containsString("controlled by v-model instead"));

        vModelBottomSheet.close();
        vModelBottomSheet.is().hidden();

        // can be closed by clicking outside (no persistent prop)
        vModelBottomSheetButton.click();
        vModelBottomSheet.is().displayed();
        clickOutsideOfSheet(vModelBottomSheet);
        vModelBottomSheet.is().hidden();
    }

    @Test
    public void persistentBottomSheetTest() {
        persistentBottomSheet.is().hidden();

        persistentBottomSheetButton.click();
        persistentBottomSheet.is().displayed();
        persistentBottomSheet.sheetText().has().text(containsString("using the persistent prop"));

        // cannot be closed by clicking outside
        clickOutsideOfSheet(persistentBottomSheet);
        persistentBottomSheet.is().displayed();
        clickOutsideOfSheet(persistentBottomSheet);
        persistentBottomSheet.is().displayed();

        persistentBottomSheet.close();
        persistentBottomSheet.is().hidden();
    }

    @Test
    public void playerBottomSheetTest() {
        bottomSheetPlayer.is().hidden();

        playerBottomSheetButton.click();
        bottomSheetPlayer.is().displayed();
        bottomSheetPlayer.progressBar().is().displayed();
        bottomSheetPlayer.songName().has().text("The Walker");
        bottomSheetPlayer.songAuthor().has().text("Fitz & The Trantrums");
        bottomSheetPlayer.arrowLeftButton().click();
        bottomSheetPlayer.pauseButton().click();
        bottomSheetPlayer.arrowRightButton().click();

        bottomSheetPlayer.is().displayed();
        clickOutsideOfSheet(bottomSheetPlayer);
        bottomSheetPlayer.is().hidden();
    }

    @JDIAction("Assert that inset bottom sheet width is 70% of its parent")
    private void assertInsetSheetWidth() {
        double insetWidth = insetBottomSheet.find(".v-dialog").getSize().width;
        int parentWidth = insetBottomSheet.getSize().width;

        jdiAssert(Math.abs(insetWidth / parentWidth - 0.7), lessThan(1e-3));
    }

    @JDIAction("Clicking 10px higher the sheet '{0}'")
    private void clickOutsideOfSheet(BottomSheet sheet) {
        int x = sheet.find(".v-dialog").getSize().width / 2;
        int y = sheet.find(".v-dialog").getLocation().y - 10;

        sheet.core().click(x, y);
    }
}
