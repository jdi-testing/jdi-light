package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.tools.Timer;
import static io.github.com.StaticSite.dialogsPage;
import static io.github.com.pages.DialogsPage.formDialog;
import static io.github.com.pages.DialogsPage.fromTheBottom;
import static io.github.com.pages.DialogsPage.fromTheTop;
import static io.github.com.pages.DialogsPage.fullscreenDialog;
import static io.github.com.pages.DialogsPage.loaderDialog;
import static io.github.com.pages.DialogsPage.nestingDialog;
import static io.github.com.pages.DialogsPage.overflowedDialog;
import static io.github.com.pages.DialogsPage.persistentDialog;
import static io.github.com.pages.DialogsPage.scrollableDialog;
import static io.github.com.pages.DialogsPage.withoutActivatorDialog;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DialogTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dialogsPage.open();
    }

    @Test
    public static void fullscreenDialogTest() {
        fullscreenDialog.open();
        fullscreenDialog.is().opened();
        fullscreenDialog.has().title(containsString("Settings"));
        fullscreenDialog.has().elementText(1, "Content filtering");
        fullscreenDialog.checkElement(1);
        fullscreenDialog.checkElement(3);
        fullscreenDialog.uncheckElement(2);
        fullscreenDialog.uncheckElement(3);
        fullscreenDialog.cancel();
        fullscreenDialog.is().closed();
    }

    @Test
    public static void transitionsDialogTest() {
        fromTheBottom.open();
        fromTheBottom.is().opened();
        fromTheBottom.has().title("Opening from the bottom").and().cardText("Hello world!");
        fromTheBottom.cancel();
        fromTheBottom.is().closed();

        fromTheTop.open();
        fromTheTop.is().opened();
        fromTheTop.has().title("Opening from the top").and().cardText("Hello world!");
        fromTheTop.cancel();
        fromTheTop.is().closed();
    }

    @Test
    public static void persistentDialogTest() {
        persistentDialog.open();
        persistentDialog.is().opened();
        persistentDialog.has().title("Use Google's location service?")
                .and().cardText(containsString("Let Google help apps determine location."));
        persistentDialog.cancel();
        persistentDialog.is().closed();
        persistentDialog.open();
        persistentDialog.save();
        persistentDialog.is().closed();
    }

    @Test
    public static void scrollableDialogTest() {
        scrollableDialog.open();
        scrollableDialog.is().opened();
        scrollableDialog.has().title("Select Country");
        verifyRadiobutton(6, null);
        verifyRadiobutton(10, 6);
        verifyRadiobutton(17, 7);
        scrollableDialog.cancel();
        scrollableDialog.open();
        jdiAssert(scrollableDialog.isSelected(17), Matchers.is(true));
        scrollableDialog.save();
        scrollableDialog.is().closed();
    }

    @Test
    public static void formDialogTest() {
        formDialog.open();
        formDialog.is().opened();
        formDialog.has().title("User Profile");
        formDialog.fillTheForm("John", "Hadley", "Chase", "john@hadley.com",
                "12345", 4, "Soccer", "Skiing", "Writing");
        formDialog.save();
        formDialog.is().closed();
    }

    @Test
    public static void loaderDialogTest() {
        Timer timer = new Timer(7000L);
        loaderDialog.open();
        loaderDialog.is().opened();
        loaderDialog.is().loading();

        timer.wait(() -> loaderDialog.is().active());
    }

    @Test
    public static void nestingDialogTest() {
        nestingDialog.open(1);
        nestingDialog.is().opened();
        nestingDialog.openTooltip();
        nestingDialog.assertThat().tooltipIsOpened();
        nestingDialog.openMenu();
        nestingDialog.openNestedDialog();
        nestingDialog.assertThat().nestedDialogOpened();
        nestingDialog.closeNestedDialog();
        nestingDialog.assertThat().nestedDialogClosed();
        nestingDialog.cancel();
        nestingDialog.is().closed();

        nestingDialog.open(2);
        nestingDialog.is().opened();
        nestingDialog.has().title("Dialog 2");
        nestingDialog.openNestedDialog();
        nestingDialog.assertThat().nestedDialogOpened();
        nestingDialog.closeNestedDialog();
        nestingDialog.assertThat().nestedDialogClosed();
        nestingDialog.cancel();
        nestingDialog.is().closed();

        nestingDialog.open(3);
        nestingDialog.is().opened();
        nestingDialog.has().title("Dialog 3");
        nestingDialog.openMenu();
        nestingDialog.selectMenuElement(3);
        nestingDialog.cancel();
        nestingDialog.is().closed();

        nestingDialog.open(4);
        nestingDialog.selectMenuElement(2);
    }

    @Test
    public static void overflowedDialogTest() {
        overflowedDialog.open();
        overflowedDialog.is().opened();
        overflowedDialog.has().title("Use Google's location service?")
                .and().cardText(containsString("Lorem ipsum dolor sit amet, semper quis, sapien id natoque elit."));
        overflowedDialog.cancel();
        overflowedDialog.is().closed();
    }

    @Test
    public static void withoutActivatorDialogTest() {
        withoutActivatorDialog.open();
        withoutActivatorDialog.is().opened();
        withoutActivatorDialog.has().title("Use Google's location service?")
                .and().cardText(containsString("Let Google help apps determine location."));
        withoutActivatorDialog.cancel();
        withoutActivatorDialog.is().closed();
    }

    //selects required element and verifies, that current element selected and previous element not selected
    public static void verifyRadiobutton(Integer selectedElNum, Integer notSelectedElNum) {
        scrollableDialog.selectRadiobutton(selectedElNum);
        scrollableDialog.assertThat().elementSelected(selectedElNum).and().elementNotSelected(notSelectedElNum);
    }
}
