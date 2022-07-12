package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
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

    @Test
    public static void persistentDialogTest() {
        persistentDialogButton.click();
        currentDialog.is().opened();
        currentDialog.close();
        currentDialog.is().opened();
        Button button = new Button().setCore(Button.class,
            new Card().setCore(Card.class, currentDialog.content())
                .actions().find("//button[./span[contains(text(), 'Agree')]]"));
        button.click();
        currentDialog.is().closed();
    }

    @Test
    public static void scrollableDialogTest() {
        scrollableDialogButton.click();
        currentDialog.is().opened().and().scrollable();
        currentDialog.close();
        currentDialog.is().closed();
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
        Button button = new Button().setCore(Button.class,
            nestingDialogFirst.content().find("//button[./span[contains(text(), 'Open Dialog 2')]]"));
        button.click();
        nestingDialogSecond.is().opened();
        button = new Button().setCore(Button.class,
            nestingDialogSecond.content().find("//button[./span[contains(text(), 'Open Dialog 3')]]"));
        button.click();
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
