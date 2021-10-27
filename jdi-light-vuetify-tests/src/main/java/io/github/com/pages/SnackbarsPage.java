package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;
import java.util.List;

public class SnackbarsPage extends VuetifyPage {

    @UI("//div[@class='container'][1]//button")
    public static Button simpleSnackbarOpen;

    @UI("//div[@class='container'][1]/div/div")
    public static Snackbar simpleSnackbar;

    @UI("//div[@class='container'][2]//button")
    public static Button multilineSnackbarOpen;

    @UI("//div[@class='container'][2]/div/div")
    public static Snackbar multilineSnackbar;

    @UI("//div[@class='container'][3]//button")
    public static Button timeoutSnackbarOpen;

    @UI("//div[@class='container'][3]/div/div")
    public static Snackbar timeoutSnackbar;

    @UI(".v-card--flat .v-snack--absolute")
    public static List<Snackbar> diffStylesSnackbars;

    @UI("//div[@class='container'][5]//button")
    public static Button verticalSnackbarOpen;

    @UI("//div[@class='container'][5]/div/div")
    public static Snackbar verticalSnackbar;
}
