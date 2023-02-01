package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bottomSheetsPage;
import static io.github.com.pages.BottomSheetsPage.*;
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
        insetBottomSheet.is().displayed();
        insetBottomSheet.sheetText().has().text(containsString("the inset prop"));
        insetBottomSheet.has().insetSheetWidthProportion(0.7);
        insetBottomSheet.close();
        insetBottomSheet.is().hidden();
    }

    @Test(description = "Test checks that bottom sheet is persistent : persistent (y/n)")
    public void persistentBottomSheetTest() {
        persistentBottomSheet.is().hidden();
        persistentBottomSheetButton.show();
        persistentBottomSheetButton.click();
        persistentBottomSheet.is().displayed();
        persistentBottomSheet.is().persistent();
        persistentBottomSheet.sheetText().has().text(containsString("using the persistent prop"));
        persistentBottomSheet.clickOutsideOfSheet();
        persistentBottomSheet.is().displayed();
        persistentBottomSheet.close();
        persistentBottomSheet.is().hidden();
        bottomSheetPlayer.is().hidden();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().displayed();
        bottomSheetPlayer.is().notPersistent();
        bottomSheetPlayer.clickOutsideOfSheet();
        waitCondition(() -> bottomSheetPlayer.isHidden());
        bottomSheetPlayer.is().hidden();
    }

    @Test(description = "Test checks custom element Player Bottom Sheet")
    public void playerBottomSheetTest() {
        bottomSheetPlayer.is().hidden();
        playerBottomSheetButton.show();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().displayed();
        bottomSheetPlayer.progressBar().is().displayed();
        bottomSheetPlayer.songName().has().text("The Walker");
        bottomSheetPlayer.songAuthor().has().text("Fitz & The Trantrums");
        bottomSheetPlayer.arrowLeftButton().click();
        bottomSheetPlayer.pauseButton().click();
        bottomSheetPlayer.arrowRightButton().click();
        bottomSheetPlayer.clickOutsideOfSheet();
        waitCondition(() -> bottomSheetPlayer.isHidden());
        bottomSheetPlayer.is().hidden();
    }

    @Test(description = "Test checks custom element List Bottom Sheet")
    public void listBottomSheetTest() {
        listBottomSheet.is().hidden();
        listBottomSheetButton.show();
        listBottomSheetButton.click();
        listBottomSheet.is().displayed();
        listBottomSheet.assertThat().optionTitlesPresented("Keep");
        listBottomSheet.clickOption("Keep");
        listBottomSheet.is().hidden();
        listBottomSheetButton.click();
        listBottomSheet.is().displayed();
        listBottomSheet.assertThat().optionTitlesPresented("Google+");
        listBottomSheet.clickOption("Google+");
        listBottomSheet.is().hidden();
    }

    @Test(description = "Test checks bottom sheet's theme : theme (light/dark)")
    public void themeBottomSheetTest() {
        insetBottomSheetButton.show();
        insetBottomSheetButton.click();
        insetBottomSheet.is().displayed();
        insetBottomSheet.has().lightTheme();
        insetBottomSheet.clickOutsideOfSheet();
        insetBottomSheet.is().hidden();
    }

    @Test(description = "Test checks if bottom sheet is fullscreen or not : fullscreen (y/n)")
    public void fullscreenBottomSheetTest() {
        vModelBottomSheetButton.show();
        vModelBottomSheetButton.click();
        vModelBottomSheet.is().displayed();
        vModelBottomSheet.is().fullscreen();
        vModelBottomSheet.close();
        vModelBottomSheet.is().hidden();
        insetBottomSheetButton.click();
        insetBottomSheet.is().displayed();
        insetBottomSheet.is().notFullscreen();
        insetBottomSheet.clickOutsideOfSheet();
        insetBottomSheet.is().hidden();
    }

    @Test(description = "Test checks if bottom sheet is scrollable or not : scrollable (y/n)")
    public void scrollableBottomSheetTest() {
        scrollableBottomSheetButton.show();
        scrollableBottomSheetButton.click();
        scrollableBottomSheet.is().displayed();
        scrollableBottomSheet.is().scrollable();
        scrollableBottomSheet.clickOutsideOfSheet();
        scrollableBottomSheet.is().hidden();
        listBottomSheetButton.click();
        listBottomSheet.is().displayed();
        listBottomSheet.is().notScrollable();
        listBottomSheet.clickOutsideOfSheet();
        listBottomSheet.is().hidden();
    }

    @Test(description = "Test checks if bottom sheet is inset or not : inset (y/n)")
    public void insetBottomSheetTest() {
        insetBottomSheetButton.show();
        insetBottomSheetButton.click();
        insetBottomSheet.is().displayed();
        insetBottomSheet.is().inset();
        insetBottomSheet.clickOutsideOfSheet();
        insetBottomSheet.is().hidden();
        listBottomSheetButton.click();
        listBottomSheet.is().displayed();
        listBottomSheet.is().notInset();
        listBottomSheet.clickOutsideOfSheet();
        listBottomSheet.is().hidden();
    }

    @Test(description = "Test checks if bottom sheet's width and max-width : width (px), max-width (px)")
    public void widthBottomSheetTest() {
        playerBottomSheetButton.show();
        playerBottomSheetButton.click();
        bottomSheetPlayer.is().displayed();
        bottomSheetPlayer.has().maxWidthPx(800);
        bottomSheetPlayer.clickOutsideOfSheet();
        bottomSheetPlayer.is().hidden();
        listBottomSheetButton.click();
        listBottomSheet.is().displayed();
        listBottomSheet.has().widthPx(500);
        listBottomSheet.clickOutsideOfSheet();
        listBottomSheet.is().hidden();
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
        scrollableBottomSheet.clickOutsideOfSheet();
        overlay.is().notVisible();


    }
}
