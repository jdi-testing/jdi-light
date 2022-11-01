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

    @Test
    public static void simpleSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible();
        simpleSnackbar.is().text("Hello, I'm a snackbar");
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void heightSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible();
        simpleSnackbar.has().height(48);
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void widthSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible();
        simpleSnackbar.has().width(344);
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void themeSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible()
                .and().darkTheme();
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void colorSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible()
                .and().backgroundColor(GREY_DARK_CHARCOAL.value())
                .and().color(WHITE_TRANSPARENT_087.value());
        simpleSnackbar.closeButton().click();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void multilineSnackbarTest() {
        multilineSnackbarOpen.click();
        multilineSnackbar.is().visible().and().multiLine();
        multilineSnackbar.closeButton().click();
        multilineSnackbar.is().closed();
    }

    @Test
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

    @Test
    public static void shapedSnackbarTest() {
        diffStylesSnackbars.get(1).is().visible()
                .and().shaped()
                .and().leftAlignment()
                .and().top();
    }

    @Test
    public static void roundedSnackbarTest() {
        diffStylesSnackbars.get(2).is().visible()
                .and().rounded()
                .and().rightAlignment()
                .and().top();
    }

    @Test
    public static void elevationSnackbarTest() {
        diffStylesSnackbars.get(3).is().visible()
                .and().elevated()
                .and().leftAlignment()
                .and().centered();
    }

    @Test
    public static void tileSnackbarTest() {
        diffStylesSnackbars.get(4).is().visible()
                .and().tile()
                .and().rightAlignment()
                .and().centered();
    }

    @Test
    public static void textSnackbarTest() {
        diffStylesSnackbars.get(5).is().visible()
                .and().styledText()
                .and().leftAlignment()
                .and().bottom();
    }

    @Test
    public static void outlinedSnackbarTest() {
        diffStylesSnackbars.get(6).is().visible()
                .and().outlined()
                .and().rightAlignment()
                .and().bottom();
    }

    @Test
    public static void verticalSnackbarTest() {
        verticalSnackbarOpen.click();
        verticalSnackbar.is().visible();
        verticalSnackbar.is().vertical().and().text("Lorem ipsum dolor sit amet");
        verticalSnackbar.closeButton().click();
        verticalSnackbar.is().closed();
    }
}
