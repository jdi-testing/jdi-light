package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import static io.github.com.StaticSite.snackbarsPage;
import static io.github.com.pages.SnackbarsPage.diffStylesSnackbars;
import static io.github.com.pages.SnackbarsPage.multilineSnackbar;
import static io.github.com.pages.SnackbarsPage.multilineSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.simpleSnackbar;
import static io.github.com.pages.SnackbarsPage.simpleSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.timeoutSnackbar;
import static io.github.com.pages.SnackbarsPage.timeoutSnackbarOpen;
import static io.github.com.pages.SnackbarsPage.verticalSnackbar;
import static io.github.com.pages.SnackbarsPage.verticalSnackbarOpen;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SnackbarsTests extends TestsInit {

    @BeforeSuite
    public static void setup() {
        snackbarsPage.open();
    }

    @Test
    public static void simpleSnackbarTest() {
        simpleSnackbarOpen.click();
        simpleSnackbar.is().visible();
        simpleSnackbar.is().text("Hello, I'm a snackbar");
        simpleSnackbar.close();
        simpleSnackbar.is().closed();
    }

    @Test
    public static void multilineSnackbarTest() {
        multilineSnackbarOpen.click();
        multilineSnackbar.is().visible().and().text("I'm a multi-line snackbar.");
        multilineSnackbar.close();
        multilineSnackbar.is().closed();
    }

    @Test
    public static void timeoutSnackbarTest() {
        Timer timer = new Timer(3000L);
        timeoutSnackbarOpen.click();
        timeoutSnackbar.is().visible().and().text("My timeout is set to 2000.");
        timer.wait(() -> timeoutSnackbar.is().closed());
    }

    @Test
    public static void diffStylesSnackbarsTest() {
        diffStylesSnackbars.get(1).is().visible().and().left().and().text("Lorem ipsum dolor sit amet consectetur.");
        diffStylesSnackbars.get(2).is().visible().and().right();
        diffStylesSnackbars.get(3).is().visible().and().centered();
        diffStylesSnackbars.get(4).is().visible().and().left();
        diffStylesSnackbars.get(5).is().visible().and().right();
    }

    @Test
    public static void verticalSnackbarTest() {
        verticalSnackbarOpen.click();
        verticalSnackbar.is().visible();
        verticalSnackbar.is().vertical().and().text("Lorem ipsum dolor sit amet");
        verticalSnackbar.close();
        verticalSnackbar.is().closed();
    }
}
