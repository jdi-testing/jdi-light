package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bottomSheetsPage;
import static io.github.com.pages.BottomSheetsPage.bottomSheetPlayer;
import static io.github.com.pages.BottomSheetsPage.insetBottomSheet;
import static io.github.com.pages.BottomSheetsPage.insetBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.listBottomSheet;
import static io.github.com.pages.BottomSheetsPage.listBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.persistentBottomSheet;
import static io.github.com.pages.BottomSheetsPage.persistentBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.playerBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.scrollableBottomSheet;
import static io.github.com.pages.BottomSheetsPage.scrollableBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.vModelBottomSheet;
import static io.github.com.pages.BottomSheetsPage.vModelBottomSheetButton;
import static io.github.com.pages.BottomSheetsPage.overlay;
import static org.hamcrest.Matchers.containsString;


public class BottomSheetsTests extends TestsInit {
    @BeforeClass
    public void before() {
        bottomSheetsPage.open();
        waitCondition(() -> bottomSheetsPage.isOpened());
        bottomSheetsPage.checkOpened();
    }

    @Test(description = "Test checks custom element Text Bottom Sheet : text, sheet width proportion")
    public void checkInsetSheetCssProps() {
        insetBottomSheet.is().hidden();
        insetBottomSheetButton.show();
        insetBottomSheetButton.click();
        insetBottomSheet.is().opened();
        insetBottomSheet.sheetText().has().text(containsString("the inset prop"));
        insetBottomSheet.has().insetSheetWidthProportion(0.7);
        insetBottomSheet.close();
        insetBottomSheet.is().closed();
    }

    @Test(description = "Test checks that bottom sheet is persistent : persistent (y/n)")
    public void persistentBottomSheetTest() {
        persistentBottomSheetButton.show();
        persistentBottomSheetButton.click();
        persistentBottomSheet.is().opened();
        persistentBottomSheet.is().persistent();
        persistentBottomSheet.sheetText().has().text(containsString("using the persistent prop"));
        persistentBottomSheet.clickOutsideOfDialog();
        persistentBottomSheet.is().opened();
        persistentBottomSheet.close();
        persistentBottomSheet.is().closed();
        bottomSheetPlayer.is().hidden();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().opened();
        bottomSheetPlayer.is().notPersistent();
        bottomSheetPlayer.clickOutsideOfDialog();
        waitCondition(() -> bottomSheetPlayer.isHidden());
        bottomSheetPlayer.is().closed();
    }

    @Test(description = "Test checks custom element Player Bottom Sheet")
    public void playerBottomSheetTest() {
        playerBottomSheetButton.show();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().opened();
        bottomSheetPlayer.progressBar().is().displayed();
        bottomSheetPlayer.songName().has().text("The Walker");
        bottomSheetPlayer.songAuthor().has().text("Fitz & The Trantrums");
        bottomSheetPlayer.arrowLeftButton().click();
        bottomSheetPlayer.pauseButton().click();
        bottomSheetPlayer.arrowRightButton().click();
        bottomSheetPlayer.clickOutsideOfDialog();
        waitCondition(() -> bottomSheetPlayer.isClosed());
        bottomSheetPlayer.is().closed();
    }

    @Test(description = "Test checks custom element List Bottom Sheet")
    public void listBottomSheetTest() {
        listBottomSheetButton.show();
        listBottomSheetButton.click();
        listBottomSheet.is().opened();
        listBottomSheet.bottomSheetList().item("Keep").is().displayed();
        listBottomSheet.bottomSheetList().item("Keep").click();
        listBottomSheet.is().closed();
        listBottomSheetButton.click();
        listBottomSheet.is().opened();
        listBottomSheet.bottomSheetList().item("Google+").is().displayed();
        listBottomSheet.bottomSheetList().item("Google+").click();
        listBottomSheet.is().closed();
    }

    @Test(description = "Test checks bottom sheet's theme : theme (light/dark)")
    public void themeBottomSheetTest() {
        insetBottomSheetButton.show();
        insetBottomSheetButton.click();
        insetBottomSheet.is().opened();
        insetBottomSheet.has().lightTheme();
        insetBottomSheet.clickOutsideOfDialog();
        insetBottomSheet.is().closed();
    }

    @Test(description = "Test checks if bottom sheet is fullscreen or not : fullscreen (y/n)")
    public void fullscreenBottomSheetTest() {
        vModelBottomSheetButton.show();
        vModelBottomSheetButton.click();
        vModelBottomSheet.is().opened();
        vModelBottomSheet.is().fullscreen();
        vModelBottomSheet.close();
        vModelBottomSheet.is().closed();
        insetBottomSheetButton.click();
        insetBottomSheet.is().opened();
        insetBottomSheet.is().notFullscreen();
        insetBottomSheet.clickOutsideOfDialog();
        insetBottomSheet.is().closed();
    }

    @Test(description = "Test checks if bottom sheet is scrollable or not : scrollable (y/n)")
    public void scrollableBottomSheetTest() {
        scrollableBottomSheetButton.show();
        scrollableBottomSheetButton.click();
        scrollableBottomSheet.is().opened();
        scrollableBottomSheet.is().scrollable();
        scrollableBottomSheet.clickOutsideOfDialog();
        scrollableBottomSheet.is().closed();
        listBottomSheetButton.click();
        listBottomSheet.is().opened();
        listBottomSheet.is().notScrollable();
        listBottomSheet.clickOutsideOfDialog();
        listBottomSheet.is().closed();
    }

    @Test(description = "Test checks if bottom sheet is inset or not : inset (y/n)")
    public void insetBottomSheetTest() {
        insetBottomSheetButton.show();
        insetBottomSheetButton.click();
        insetBottomSheet.is().opened();
        insetBottomSheet.is().inset();
        insetBottomSheet.clickOutsideOfDialog();
        insetBottomSheet.is().closed();
        listBottomSheetButton.click();
        listBottomSheet.is().opened();
        listBottomSheet.is().notInset();
        listBottomSheet.clickOutsideOfDialog();
        listBottomSheet.is().closed();
    }

    @Test(description = "Test checks if bottom sheet's width and max-width : width (px), max-width (px)")
    public void widthBottomSheetTest() {
        playerBottomSheetButton.show();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().opened();
        bottomSheetPlayer.has().maxWidthPx(800);
        bottomSheetPlayer.clickOutsideOfDialog();
        bottomSheetPlayer.is().closed();
        listBottomSheetButton.click();
        listBottomSheet.is().opened();
        listBottomSheet.has().widthPx(500);
        listBottomSheet.clickOutsideOfDialog();
        listBottomSheet.is().closed();
    }

    @Test(description = "Test checks an overlay shows up or doesn't depending on a bottomsheet : shown (y/n)")
    public void checkOverlayTest() {
        persistentBottomSheetButton.show();
        persistentBottomSheetButton.click();
        overlay.is().shown();
        persistentBottomSheet.close();
        overlay.is().notVisible();
        scrollableBottomSheetButton.show();
        scrollableBottomSheetButton.click();
        overlay.is().notVisible();
        scrollableBottomSheet.clickOutsideOfDialog();
        overlay.is().notVisible();

    }
}
