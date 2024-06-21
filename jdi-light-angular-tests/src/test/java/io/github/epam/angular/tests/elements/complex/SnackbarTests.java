package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.Position.CENTER_BOTTOM;
import static com.epam.jdi.light.angular.elements.enums.Position.CENTER_TOP;
import static com.epam.jdi.light.angular.elements.enums.Position.LEFT_BOTTOM;
import static com.epam.jdi.light.angular.elements.enums.Position.LEFT_TOP;
import static com.epam.jdi.light.angular.elements.enums.Position.RIGHT_BOTTOM;
import static com.epam.jdi.light.angular.elements.enums.Position.RIGHT_TOP;
import static com.epam.jdi.light.elements.base.Conditions.hidden;
import static com.epam.jdi.light.elements.base.Conditions.visible;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.snackBarPage;
import static io.github.com.pages.SnackBarPage.basicSnackbarActionInput;
import static io.github.com.pages.SnackBarPage.basicSnackbarMessageInput;
import static io.github.com.pages.SnackBarPage.customSnackbar;
import static io.github.com.pages.SnackBarPage.durationInput;
import static io.github.com.pages.SnackBarPage.horizontalPositionDropdown;
import static io.github.com.pages.SnackBarPage.showBasicSnackbarButton;
import static io.github.com.pages.SnackBarPage.showCustomSnackbarButton;
import static io.github.com.pages.SnackBarPage.showPositionSnackbarButton;
import static io.github.com.pages.SnackBarPage.snackbar;
import static io.github.com.pages.SnackBarPage.verticalPositionDropdown;

public class SnackbarTests extends TestsInit {

    private static final String MESSAGE = "Test Message";
    private static final String ACTION = "Test Action";

    @BeforeClass
    public void before() {
        snackBarPage.open();
        waitCondition(() -> snackBarPage.isOpened());
        snackBarPage.checkOpened();
    }

    @Test
    public void basicSnackbarTest() {
        basicSnackbarMessageInput.setValue(MESSAGE);
        basicSnackbarActionInput.setValue(ACTION);
        showBasicSnackbarButton.click();

        snackbar.is()
                .displayed();
        snackbar.has()
                .message(MESSAGE);
        snackbar.action()
                .has()
                .text(ACTION);
    }

    @Test
    public void snackbarDismissAfterClickActionTest() {
        basicSnackbarMessageInput.setValue(MESSAGE);
        basicSnackbarActionInput.setValue(ACTION);
        showBasicSnackbarButton.click();

        snackbar.action()
                .click();
        snackbar.is()
                .disappear();
    }

    @Test
    public void snackbarWithNoActionTest() {
        basicSnackbarMessageInput.setValue(MESSAGE);
        basicSnackbarActionInput.setValue("");
        showBasicSnackbarButton.click();

        snackbar.has()
                .shown();
        snackbar.action()
                .has()
                .notAppear();
    }

    @Test
    public void snackbarDurationTest() {
        final int DURATION = 3;

        durationInput.setValue(String.valueOf(DURATION));
        showCustomSnackbarButton.click();

        customSnackbar.shouldBe(visible);
        customSnackbar.is()
                .notHidden(DURATION);
        customSnackbar.shouldBe(hidden);
    }

    @Test(dataProvider = "positionProvider")
    public void snackbarPositionTest(String horizontal,Position horizontalPosition, String vertical, Position verticalPosition) {
        horizontalPositionDropdown.select(horizontal);
        verticalPositionDropdown.select(vertical);
        showPositionSnackbarButton.click();
        snackbar.has()
                .shown()
                .and().has().position(verticalPosition)
                .and().has().position(horizontalPosition);
    }

    @DataProvider(name = "positionProvider")
    public Object[][] providePositions() {
        return new Object[][]{
                {"Start", "Top", LEFT_TOP},
                {"Center", "Top", CENTER_TOP},
                {"End", "Top", RIGHT_TOP},
                {"Left", "Top", LEFT_TOP},
                {"Right", "Top", RIGHT_TOP},

                {"Start", "Bottom", LEFT_BOTTOM},
                {"Center", "Bottom", CENTER_BOTTOM},
                {"End", "Bottom", RIGHT_BOTTOM},
                {"Left", "Bottom", LEFT_BOTTOM},
                {"Right", "Bottom", RIGHT_BOTTOM}};
    }
}