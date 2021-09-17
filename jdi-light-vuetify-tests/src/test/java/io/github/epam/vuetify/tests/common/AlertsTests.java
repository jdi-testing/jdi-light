package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.alertsPage;
import static io.github.com.pages.AlertsPage.blueGreyAlert;
import static io.github.com.pages.AlertsPage.denseErrorAlert;
import static io.github.com.pages.AlertsPage.denseInfoAlert;
import static io.github.com.pages.AlertsPage.denseSuccessAlert;
import static io.github.com.pages.AlertsPage.denseWarningAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlert;
import static io.github.com.pages.AlertsPage.dismissibleAlertResetButton;
import static io.github.com.pages.AlertsPage.errorAlert;
import static io.github.com.pages.AlertsPage.fireTextAlert;
import static io.github.com.pages.AlertsPage.firstIconAlert;
import static io.github.com.pages.AlertsPage.indigoAlert;
import static io.github.com.pages.AlertsPage.infoAlert;
import static io.github.com.pages.AlertsPage.infoTextAlert;
import static io.github.com.pages.AlertsPage.pinkAlert;
import static io.github.com.pages.AlertsPage.prominentErrorAlert;
import static io.github.com.pages.AlertsPage.prominentLockAlert;
import static io.github.com.pages.AlertsPage.prominentSchoolAlert;
import static io.github.com.pages.AlertsPage.purpleOutlinedAlert;
import static io.github.com.pages.AlertsPage.redAlert;
import static io.github.com.pages.AlertsPage.secondIconAlert;
import static io.github.com.pages.AlertsPage.successAlert;
import static io.github.com.pages.AlertsPage.successOutlinedAlert;
import static io.github.com.pages.AlertsPage.thirdIconAlert;
import static io.github.com.pages.AlertsPage.timeTextAlert;
import static io.github.com.pages.AlertsPage.transitionAlert;
import static io.github.com.pages.AlertsPage.transitionAlertToggleButton;
import static io.github.com.pages.AlertsPage.warningAlert;
import static io.github.com.pages.AlertsPage.warningOutlinedAlert;
import static io.github.com.pages.AlertsPage.warningTextAlert;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class AlertsTests extends TestsInit {
    @BeforeClass
    public void before() {
        alertsPage.open();
        alertsPage.checkOpened();
    }

    @Test
    public void basicAlertsHaveProperTextAndIcon() {
        successAlert.has().text("I'm a success alert.");
        successAlert.getIcon().has().cssClass("mdi-check-circle");

        infoAlert.has().text("I'm an info alert.");
        infoAlert.getIcon().has().cssClass("mdi-information");

        warningAlert.has().text("I'm a warning alert.");
        warningAlert.getIcon().has().cssClass("mdi-exclamation");

        errorAlert.has().text("I'm an error alert.");
        errorAlert.getIcon().has().cssClass("mdi-alert");
    }

    @Test
    public void alertsWithPropsHaveProperCssProps() {
        redAlert.has().text("I'm an alert with a top border and red color");
        redAlert.has().css("background-color", Colors.RED_LIGHTEN_2.value());
        redAlert.has().cssClass("v-alert--border-top");

        blueGreyAlert.has().text("I'm an alert with a right border and blue-grey color");
        blueGreyAlert.has().css("background-color", Colors.BLUE_GREY.value());
        blueGreyAlert.has().cssClass("v-alert--border-right");

        pinkAlert.has().text("I'm an alert with a bottom border and pink color");
        pinkAlert.has().css("background-color", Colors.PINK_DARKEN_1.value());
        pinkAlert.has().cssClass("v-alert--border-bottom");

        indigoAlert.has().text("I'm an alert with a border left type info");
        indigoAlert.has().css("background-color", Colors.INDIGO.value());
        indigoAlert.has().cssClass("v-alert--border-left");
    }

    @Test
    public void denseAlertsTest() {
        denseInfoAlert.has().text("I'm a dense alert with a type of info");
        denseInfoAlert.getIcon().has().cssClass("mdi-information");

        denseSuccessAlert.has().text("I'm a dense alert with the text prop and a type of success");
        denseSuccessAlert.getIcon().has().cssClass("mdi-check-circle");

        denseWarningAlert.has().text("I'm a dense alert with the border prop and a type of warning");
        denseWarningAlert.getIcon().has().cssClass("mdi-exclamation");

        denseErrorAlert.has().text("I'm a dense alert with the outlined prop and a type of error");
        denseErrorAlert.getIcon().has().cssClass("mdi-alert");
    }

    @Test
    public void dismissibleAlertCouldBeClosed() {
        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString("Aenean imperdiet. Quisque id odio."));
        dismissibleAlert.getButton().click();

        dismissibleAlert.is().hidden();
        dismissibleAlertResetButton.is().displayed();
        dismissibleAlertResetButton.click();

        dismissibleAlert.is().displayed();
        dismissibleAlert.has().text(containsString("Aenean imperdiet. Quisque id odio."));
    }

    @Test
    public void alertsWithIconHaveProperIcons() {
        firstIconAlert.has().text(containsString("Suspendisse enim turpis, dictum sed"));
        firstIconAlert.getIcon().has().cssClass("mdi-firework");

        secondIconAlert.has().text(containsString("Phasellus blandit leo ut odio. Morbi mattis ullamcorper"));
        secondIconAlert.getIcon().has().cssClass("mdi-material-design");

        thirdIconAlert.has().text(containsString("raesent congue erat at massa. Nullam vel sem."));
        thirdIconAlert.getIcon().has().cssClass("mdi-vuetify");
    }

    @Test
    public void outlinedAlertsHaveProperStyles() {
        purpleOutlinedAlert.has().text(containsString("Maecenas ullamcorper, dui et placerat feugiat"));
        purpleOutlinedAlert.has().css("color", Colors.PURPLE.value());
        checkBorderColor(purpleOutlinedAlert, Colors.PURPLE.value());
        purpleOutlinedAlert.has().css("background-color", Colors.TRANSPARENT.value());

        successOutlinedAlert.has().text(containsString("Aenean commodo ligula"));
        successOutlinedAlert.has().css("color", Colors.GREEN.value());
        checkBorderColor(successOutlinedAlert, Colors.GREEN.value());
        checkBackgroundColorOpacity(successOutlinedAlert);

        warningOutlinedAlert.has().text(containsString("Duis arcu tortor"));
        warningOutlinedAlert.has().css("color", Colors.ORANGE_DARKEN_1.value());
        checkBorderColor(warningOutlinedAlert, Colors.ORANGE_DARKEN_1.value());
    }

    @Test
    public void prominentAlertsHaveIconEffect() {
        prominentErrorAlert.has().text(containsString("Nunc nonummy metus."));
        prominentErrorAlert.getButton().click();
        prominentErrorAlert.getIcon().has().cssClass("mdi-alert");
        checkProminentIconEffect(prominentErrorAlert);

        prominentSchoolAlert.has().text(containsString("egestas nec, vestibulum et"));
        prominentSchoolAlert.getIcon().has().cssClass("mdi-school");
        checkProminentIconEffect(prominentSchoolAlert);

        prominentLockAlert.has().text(containsString("Donec quam felis, ultricies nec"));
        prominentLockAlert.getIcon().has().cssClass("mdi-shield-lock-outline");
        checkProminentIconEffect(prominentLockAlert);
    }

    @Test
    public void textAlertsTextAndBackgroundColorsMatch() {
        infoTextAlert.has().text(containsString("Sed mollis, eros et"));
        infoTextAlert.has().css("color", Colors.BLUE.value());
        checkBackgroundColorOpacity(infoTextAlert);

        fireTextAlert.has().text(containsString("Nullam tincidunt adipiscing enim."));
        fireTextAlert.has().css("color", Colors.DEEP_ORANGE.value());
        checkBackgroundColorOpacity(fireTextAlert);

        timeTextAlert.has().text(containsString("Nulla porta dolor."));
        timeTextAlert.has().css("color", Colors.TEAL.value());
        checkBackgroundColorOpacity(timeTextAlert);

        warningTextAlert.has().text(containsString("Praesent blandit laoreet nibh."));
        warningTextAlert.has().css("color", Colors.RED_ACCENT_2.value());
        checkBackgroundColorOpacity(warningTextAlert);
    }

    @Test
    public void transitionAlertTest() {
        transitionAlert.is().displayed();

        transitionAlertToggleButton.click();
        transitionAlert.is().hidden();

        transitionAlertToggleButton.click();
        transitionAlert.isDisplayed();
    }

    private void checkBorderColor(HasAssert<? extends UIAssert<?, ?>> element, String color) {
        element.has().css("border-bottom-color", color);
        element.has().css("border-left-color", color);
        element.has().css("border-right-color", color);
        element.has().css("border-top-color", color);
    }

    private void checkProminentIconEffect(Alert element) {
        String script = "return window.getComputedStyle(arguments[0].querySelector('i'), ':after')" +
                ".getPropertyValue('%s');";
        String expectedOpacity = "0.16";
        String expectedHeight = "48px";

        String opacity = ((JavascriptExecutor)element.core().driver()).executeScript(
                String.format(script, "opacity"),
                element.core().seleniumElement()).toString();
        String height = ((JavascriptExecutor)element.core().driver()).executeScript(
                String.format(script, "height"),
                element.core().seleniumElement()).toString();

        jdiAssert(opacity, equalTo(expectedOpacity));
        jdiAssert(height, equalTo(expectedHeight));
    }

    private void checkBackgroundColorOpacity(Alert element) {
        String script = "return window.getComputedStyle(arguments[0], ':before')" +
                ".getPropertyValue('%s');";
        String expectedOpacity = "0.12";

        String opacity = ((JavascriptExecutor)element.core().driver()).executeScript(
                String.format(script, "opacity"),
                element.core().seleniumElement()).toString();

        jdiAssert(opacity, equalTo(expectedOpacity));
    }
}
