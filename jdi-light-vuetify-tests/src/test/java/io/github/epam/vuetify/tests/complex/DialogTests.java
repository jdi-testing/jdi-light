package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dialogsPage;
import static io.github.com.pages.DialogsPage.currentDialog;
import static io.github.com.pages.DialogsPage.fullscreenDialogButton;
import static io.github.com.pages.DialogsPage.loaderDialogButton;
import static io.github.com.pages.DialogsPage.nestingDialogFirst;
import static io.github.com.pages.DialogsPage.nestingDialogFirstButton;
import static io.github.com.pages.DialogsPage.nestingDialogSecond;
import static io.github.com.pages.DialogsPage.nestingDialogThird;
import static io.github.com.pages.DialogsPage.persistentDialogButton;
import static io.github.com.pages.DialogsPage.scrollableDialog;
import static io.github.com.pages.DialogsPage.scrollableDialogButton;
import static io.github.com.pages.DialogsPage.withoutActivatorDialogButton;

public class DialogTests extends TestsInit {

    @BeforeMethod
    public static void setup() {
        dialogsPage.open();
        waitCondition(() -> dialogsPage.isOpened());
        dialogsPage.checkOpened();
    }

    @Test
    public static void fullscreenDialogTest() {
        fullscreenDialogButton.click();
        currentDialog.is().opened().and().fullscreen();
        currentDialog.close();
        currentDialog.is().closed();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public static void persistentDialogTest() {
        persistentDialogButton.click();
        currentDialog.is().opened();
        currentDialog.close();
        currentDialog.is().opened();
        currentDialog.close("Agree");
        currentDialog.is().closed();
    }

    @Test
    public static void scrollableDialogTest() {
        scrollableDialogButton.click();
        scrollableDialog.is().opened().and().scrollable();
        scrollableDialog.radiogroup().get(1).is().visible();
        scrollableDialog.radiogroup().get(15).is().notVisible();
        scrollableDialog.scrollToPosition(200);
        scrollableDialog.radiogroup().get(1).is().notVisible();
        scrollableDialog.radiogroup().get(15).is().visible();
        scrollableDialog.scrollToPosition(0);
        scrollableDialog.radiogroup().get(1).is().visible();
        scrollableDialog.radiogroup().get(15).is().notVisible();
        scrollableDialog.close();
        scrollableDialog.is().closed();
    }

    @Test
    public static void loaderDialogTest() {
        loaderDialogButton.click();
        currentDialog.is().opened().and().persistent();
        currentDialog.close();
        currentDialog.is().opened();
        waitCondition(() -> currentDialog.isClosed());
        currentDialog.is().closed();
    }

    @Test
    public static void nestingDialogTest() {
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

    @Test
    public static void withoutActivatorDialogTest() {
        withoutActivatorDialogButton.click();
        currentDialog.is().opened();
        currentDialog.close();
        currentDialog.is().closed();
    }
}
