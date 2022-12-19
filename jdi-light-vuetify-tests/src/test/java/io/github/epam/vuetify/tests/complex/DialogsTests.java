package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dialogsPage;
import static io.github.com.pages.DialogsPage.currentDialog;
import static io.github.com.pages.DialogsPage.fullscreenDialogButton;
import static io.github.com.pages.DialogsPage.nestingDialogFirst;
import static io.github.com.pages.DialogsPage.nestingDialogFirstButton;
import static io.github.com.pages.DialogsPage.nestingDialogSecond;
import static io.github.com.pages.DialogsPage.nestingDialogThird;
import static io.github.com.pages.DialogsPage.persistentDialogButton;
import static io.github.com.pages.DialogsPage.scrollableDialog;
import static io.github.com.pages.DialogsPage.scrollableDialogButton;
import static io.github.com.pages.DialogsPage.withoutActivatorDialogButton;

public class DialogsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dialogsPage.open();
        waitCondition(() -> dialogsPage.isOpened());
        dialogsPage.checkOpened();
    }

    @Test(description = "Test checks if dialog is fullscreen or not")
    public static void fullscreenDialogTest() {
        refresh();
        fullscreenDialogButton.click();
        currentDialog.is().opened().and().fullscreen();
        currentDialog.close();
        currentDialog.is().closed();
        refresh();
        persistentDialogButton.click();
        currentDialog.is().notFullscreen();
        currentDialog.close("Agree");
        currentDialog.is().closed();
    }

    @Test(description = "Test checks if dialog is persistent or not", expectedExceptions = RuntimeException.class)
    public static void persistentDialogTest() {
        refresh();
        persistentDialogButton.click();
        currentDialog.is().persistent();
        currentDialog.close();
        currentDialog.is().opened();
        currentDialog.close("Agree");
        currentDialog.is().closed();
        refresh();
        scrollableDialogButton.click();
        scrollableDialog.is().notPersistent();
        scrollableDialog.saveButton().click();
        scrollableDialog.is().closed();
    }

    @Test(description = "Test checks if dialog is scrollable or not")
    public static void scrollableDialogTest() {
        refresh();
        scrollableDialogButton.click();
        scrollableDialog.is().opened().and().scrollable();
        UIElement radioButtonAtTheBeginning = scrollableDialog.radiogroup().get(1);
        UIElement radioButtonAtTheEnd = scrollableDialog.radiogroup().get(13);
        scrollableDialog.has().visibleContent(radioButtonAtTheBeginning).and().notVisibleContent(radioButtonAtTheEnd);
        scrollableDialog.scrollableContent().scroll(300);
        scrollableDialog.has().notVisibleContent(radioButtonAtTheBeginning).and().visibleContent(radioButtonAtTheEnd);
        scrollableDialog.scrollableContent().scroll(0);
        scrollableDialog.has().visibleContent(radioButtonAtTheBeginning).and().notVisibleContent(radioButtonAtTheEnd);
        scrollableDialog.radiogroup().select("Bahrain");
        scrollableDialog.saveButton().click();
        scrollableDialog.is().closed();
        scrollableDialogButton.click();
        scrollableDialog.is().opened();
        scrollableDialog.radiogroup().is().selected("Bahrain");
        scrollableDialog.closeButton().click();
        scrollableDialog.is().closed();
        refresh();
        persistentDialogButton.click();
        currentDialog.is().notScrollable();
        currentDialog.close("Agree");
        currentDialog.is().closed();
    }

    @Test(description = "Test shows how to work with nesting dialogs")
    public static void nestingDialogTest() {
        refresh();
        nestingDialogFirstButton.click();
        nestingDialogFirst.is().opened();
        nestingDialogFirst.openDialogButton().click();
        nestingDialogSecond.is().opened();
        nestingDialogSecond.openDialogButton().click();
        nestingDialogThird.is().opened();
        nestingDialogThird.close();
        nestingDialogThird.is().closed();
        nestingDialogSecond.close();
        nestingDialogSecond.is().closed();
        nestingDialogFirst.close();
        nestingDialogFirst.is().closed();
    }

    @Test(description = "Test checks dialog's theme")
    public static void themeDialogTest() {
        refresh();
        withoutActivatorDialogButton.click();
        currentDialog.is().opened();
        currentDialog.has().lightTheme();
        currentDialog.close();
        currentDialog.is().closed();
    }

    @Test(description = "Test checks dialog's max-width")
    public static void maxWidthDialogTest() {
        refresh();
        persistentDialogButton.click();
        currentDialog.is().opened();
        currentDialog.has().maxWidthPx(290);
        currentDialog.close("Agree");
        currentDialog.is().closed();
    }

    @Test(description = "Test checks dialog's margin")
    public static void marginDialogTest() {
        refresh();
        persistentDialogButton.click();
        currentDialog.is().opened();
        currentDialog.has().marginPx(24);
        currentDialog.close("Agree");
        currentDialog.is().closed();
    }
}
