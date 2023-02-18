package io.github.epam.vuetify.tests.common;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.snackbarsPage;
import static io.github.com.enums.Colors.GREY_DARK_CHARCOAL;
import static io.github.com.enums.Colors.WHITE_TRANSPARENT_087;
import static io.github.com.pages.SnackbarsPage.diffStylesSnackbars;
import static io.github.com.pages.SnackbarsPage.multilineSnackbar;
import static io.github.com.pages.SnackbarsPage.multilineSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.simpleSnackbar;
import static io.github.com.pages.SnackbarsPage.simpleSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.timeoutSnackbar;
import static io.github.com.pages.SnackbarsPage.timeoutSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.verticalSnackbar;
import static io.github.com.pages.SnackbarsPage.verticalSnackbarOpen;

public class SnackbarsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        snackbarsPage.open();
        waitCondition(() -> snackbarsPage.isOpened());
        snackbarsPage.checkOpened();
    }

    @Test(description = "Test checks a simple Snackbar")
    public static void simpleSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible()
                .and().has().text("Hello, I'm a snackbar");
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test(description = "Test checks that simple Snackbar has specific height")
    public static void dimensionsSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible().and().has().height(48).and().width(344);
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test(description = "Test checks that simple Snackbar is visible and has dark theme")
    public static void themeSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible()
                .and().darkTheme();
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test(description = "Test checks that Snackbar has a specific color")
    public static void colorSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible()
                .and().backgroundColor(GREY_DARK_CHARCOAL.value())
                .and().color(WHITE_TRANSPARENT_087.value());
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test(description = "Test checks that Snackbar is of a multiline type")
    public static void multilineSnackbarTest() {
        multilineSnackbarOpen.click();
        multilineSnackbar.is().visible().and().multiLine();
        multilineSnackbar.closeButton().click();
        multilineSnackbar.is().closed();
    }

    @Test(description = "Test checks that Snackbar disappears after particular timeout has expired")
    public static void timeoutSnackbarTest() {
        Timer timer = new Timer(3000L);
        timeoutSnackbarOpen.click();
        timeoutSnackbar.is().visible().and().text("My timeout is set to 2000.");
        timer.wait(() -> timeoutSnackbar.is().closed());

        timeoutSnackbarOpen.click();
        timeoutSnackbar.is().visible();
        timeoutSnackbar.closeButton().click();
        timeoutSnackbar.is().closed();
    }

    @Test(description = "Test checks that Snackbar is shaped and has left and top alignments")
    public static void shapedSnackbarTest() {
        diffStylesSnackbars.get(1).is().visible()
                .and().shaped()
                .and().leftAlignment()
                .and().top();
    }

    @Test(description = "Test checks that Snackbar is rounded as a pill and has right alignment and it's position is centered")
    public static void roundedSnackbarTest() {
        diffStylesSnackbars.get(2).is().visible()
                .and().rounded()
                .and().has().rounded("pill")
                .and().rightAlignment()
                .and().top();
    }

    @Test(description = "Test checks that Snackbar is elevated and has left alignment")
    public static void elevationSnackbarTest() {
        diffStylesSnackbars.get(3).is().visible()
                .and().elevated()
                .and().leftAlignment()
                .and().centered();
    }

    @Test(description = "Test checks that Snackbar has a styled text, left alignment is positioned at bottom")
    public static void textSnackbarTest() {
        diffStylesSnackbars.get(5).is().visible()
                .and().styledText()
                .and().leftAlignment()
                .and().bottom();
    }

    @Test(description = "Test checks that Snackbar is outlined")
    public static void outlinedSnackbarTest() {
        diffStylesSnackbars.get(6).is().visible()
                .and().outlined()
                .and().rightAlignment()
                .and().bottom();
    }

    @Test(description = "Test checks that Snackbar is of vertical type, visible and has specific text")
    public static void verticalSnackbarTest() {
        verticalSnackbarOpen.click();
        verticalSnackbar.is().visible()
                .and().vertical()
                .and().text("Lorem ipsum dolor sit amet");
        verticalSnackbar.closeButton().click();
        verticalSnackbar.is().closed();
    }
}
