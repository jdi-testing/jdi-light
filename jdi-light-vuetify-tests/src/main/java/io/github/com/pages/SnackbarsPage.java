package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;
import io.github.com.custom.ClosingSnackbar;

import java.util.List;

public class SnackbarsPage extends VuetifyPage {

    @UI("//div[./h2/text()='Simple Snackbar']//button")
    public static Button simpleSnackbarOpen;

    @UI("//div[./h2/text()='Simple Snackbar']//div[contains(@class, 'v-snack')]")
    public static ClosingSnackbar simpleSnackbar;

    @UI("//div[./h2/text()='Multi line Snackbar']//button")
    public static Button multilineSnackbarOpen;

    @UI("//div[./h2/text()='Multi line Snackbar']//div[contains(@class, 'v-snack')]")
    public static ClosingSnackbar multilineSnackbar;

    @UI("//div[./h2/text()='Timeout Snackbar']//button")
    public static Button timeoutSnackbarOpen;

    @UI("//div[./h2/text()='Timeout Snackbar']//div[contains(@class, 'v-snack')]")
    public static ClosingSnackbar timeoutSnackbar;

    @UI(".v-card--flat .v-snack--absolute")
    public static List<Snackbar> diffStylesSnackbars;

    @UI("//div[./h2/text()='Vertical Snackbar']//button")
    public static Button verticalSnackbarOpen;

    @UI("//div[./h2/text()='Vertical Snackbar']//div[contains(@class, 'v-snack')]")
    public static ClosingSnackbar verticalSnackbar;
}
