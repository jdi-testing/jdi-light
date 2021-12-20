package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.snackbarPage;
import static io.github.com.pages.feedback.SnackbarPage.changeTransitionSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.complementaryProjectsSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.consecutiveSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.controlSlideDirectionSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.customizedSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.directionButtons;
import static io.github.com.pages.feedback.SnackbarPage.messageLength;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.showMessageButtons;
import static io.github.com.pages.feedback.SnackbarPage.showSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbarButton;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbarButton;
import static io.github.com.pages.feedback.SnackbarPage.transitionButtons;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SnackbarTests extends TestsInit {

    private static final String[] POSITION = {"Top Center", "Top Right", "Bottom Right", "Bottom Center",
            "Bottom Left", "Top Left"};
    private static final String[] MESSAGE = {"SHOW MESSAGE A", "SHOW MESSAGE B", "Message A", "Message B"};
    private static final String LOVE_SNACKS = "I love snacks";
    private static final String LOREM = "lorem ipsum dolorem";
    private static final String LOVE_CANDY = "I love candy. I love cookies. I love cupcakes.";
    private static final String LOVE_CHEESECAKE = "I love cheesecake. I love chocolate.";
    private static final String UNDO = "UNDO";

    @BeforeMethod
    public void before() {
        snackbarPage.open();
        snackbarPage.isOpened();

    }

    @Test
    public void simpleSnackbarTest() {

        simpleSnackbar.is().notVisible();
        simpleSnackbarButton.click();
        simpleSnackbar.waitFor().displayed();
        simpleSnackbar.has().text("Note archived");
        simpleSnackbar.snackbarButton(UNDO).click();
        simpleSnackbar.waitFor().hidden();
        simpleSnackbar.is().notVisible();
        simpleSnackbarButton.click();
        simpleSnackbar.waitFor().displayed();
        simpleSnackbar.close();
        simpleSnackbar.is().notVisible();
    }

    @Test
    public void customizedSnackbarTest() {

        successSnackbar.is().notVisible();
        successSnackbarButton.click();
        successSnackbar.is().displayed();
        successSnackbar.has().text("This is a success message!");
        successSnackbar.close();
        successSnackbar.is().notVisible();

        customizedSnackbar.get(1).has().text("This is an error message!").and().messageType("error");
        customizedSnackbar.get(2).has().text("This is a warning message!").and().messageType("warning");
        customizedSnackbar.get(3).has().text("This is an information message!").and().messageType("info");
        customizedSnackbar.get(4).has().text("This is a success message!").and().messageType("success");
    }

    @Test
    public void positionedSnackbarTest() {

        for (int i = 1; i <= 6; i++) {
            positionedSnackbarButtons.get(i).click();
            positionedSnackbar.has().text(LOVE_SNACKS).and().position(POSITION[i - 1]);
            positionedSnackbarButtons.get(i).click();
            positionedSnackbar.waitFor().hidden();
        }
    }

    @Test
    public void messageLengthTest() {

        messageLength.get(1).has().text(LOVE_SNACKS + ".");
        messageLength.get(1).snackbarButton(LOREM).click();

        messageLength.get(2).has().text(LOVE_CANDY + " " + LOVE_CHEESECAKE);

        messageLength.get(3).has().text(LOVE_CANDY);
        messageLength.get(3).snackbarButton(LOREM).click();

        messageLength.get(4).has().text(LOVE_CANDY + " " + LOVE_CHEESECAKE);
        messageLength.get(4).snackbarButton(LOREM).click();
    }

    @Test
    public void consecutiveSnackbarsTest() {

        for (int i = 1; i <= 2; i++) {
            showMessageButtons.get(i).is().displayed().and().text(MESSAGE[i - 1]);
            showMessageButtons.get(i).click();
            consecutiveSnackbar.waitFor().displayed();
            consecutiveSnackbar.has().text(MESSAGE[i + 1]);
            consecutiveSnackbar.close();
            consecutiveSnackbar.waitFor().notVisible();

            showMessageButtons.get(i).click();
            consecutiveSnackbar.waitFor().displayed();
            consecutiveSnackbar.snackbarButton(UNDO).click();
            consecutiveSnackbar.waitFor().notVisible();
        }
    }

    @Test
    public void changeTransitionSnackbarTest() {
        for (int i = 1; i <= 3; i++) {
            transitionButtons.get(i).click();
            changeTransitionSnackbar.waitFor().displayed();
            changeTransitionSnackbar.has().text(LOVE_SNACKS);
        }
    }

    @Test
    public void controlSlideDirectionSnackbarTest() {
        for (int i = 1; i <= 4; i++) {
            directionButtons.get(i).click();
            controlSlideDirectionSnackbar.has().text(LOVE_SNACKS);
            directionButtons.get(i).click();
            controlSlideDirectionSnackbar.waitFor().hidden();
        }
    }

    @Test
    public void complementaryProjectsSnackbarTest() {

        showSnackbarButtons.get(1).click();
        complementaryProjectsSnackbar.waitFor().displayed();
        complementaryProjectsSnackbar.has().text(LOVE_SNACKS + ".");
        complementaryProjectsSnackbar.waitFor().disappear();
        complementaryProjectsSnackbar.is().notVisible();

        showSnackbarButtons.get(2).click();
        complementaryProjectsSnackbar.waitFor().displayed();
        complementaryProjectsSnackbar.has().text("This is a success message!");
        complementaryProjectsSnackbar.waitFor().disappear();
        complementaryProjectsSnackbar.is().notVisible();
    }
}
