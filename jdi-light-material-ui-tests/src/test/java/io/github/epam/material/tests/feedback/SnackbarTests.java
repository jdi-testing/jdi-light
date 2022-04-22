package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.snackbarPage;
import static io.github.com.pages.feedback.SnackbarPage.changeTransitionSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.complementaryProjectsSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.complementaryProjectsSnackbarList;
import static io.github.com.pages.feedback.SnackbarPage.consecutiveSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.consecutiveSnackbarList;
import static io.github.com.pages.feedback.SnackbarPage.controlSlideDirectionSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.directionButtons;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.showMessageButtons;
import static io.github.com.pages.feedback.SnackbarPage.showSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbarButton;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbarButton;
import static io.github.com.pages.feedback.SnackbarPage.transitionButtons;
import static com.epam.jdi.light.material.elements.utils.enums.MessageType.SUCCESS;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import io.github.epam.test.data.SnackbarsDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SnackbarTests extends TestsInit {

    private static final String LOVE_SNACKS = "I love snacks";
    private static final String SUCCESS_MESSAGE = "This is a success message!";
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
    public void successSnackbarTest() {
        successSnackbar.is().notVisible();
        successSnackbarButton.click();
        successSnackbar.is().displayed();
        successSnackbar.has().text(SUCCESS_MESSAGE).and().messageType(SUCCESS);
        successSnackbar.close();
        successSnackbar.is().notVisible();
    }

    @Test(dataProviderClass = SnackbarsDataProvider.class, dataProvider = "positionedSnackbarDataProvider")
    public void positionedSnackbarTest(int number, Position position) {
        positionedSnackbarButtons.get(number).core()
                .jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
        positionedSnackbarButtons.get(number).click();
        positionedSnackbar.has().text(LOVE_SNACKS).and().position(position);
        positionedSnackbarButtons.get(number).click();
        positionedSnackbar.waitFor().hidden();
    }

    @Test(dataProviderClass = SnackbarsDataProvider.class, dataProvider = "consecutiveSnackbarsDataProvider")
    public void consecutiveSnackbarsTest(int number, String message, String buttonMessage) {
        showMessageButtons.get(number).is().displayed().and().has().text(buttonMessage);
        showMessageButtons.get(number).click();
        consecutiveSnackbar.waitFor().displayed();
        consecutiveSnackbar.has().text(message);
        consecutiveSnackbar.close();
        consecutiveSnackbar.waitFor().notVisible();

        showMessageButtons.get(number).click();
        consecutiveSnackbar.waitFor().displayed();
        consecutiveSnackbar.snackbarButton(UNDO).click();
        consecutiveSnackbar.waitFor().notVisible();

        showMessageButtons.get(1).click();
        consecutiveSnackbar.waitFor().displayed();

        showMessageButtons.get(2).click();
        consecutiveSnackbar.waitFor().displayed();
        consecutiveSnackbarList.get(2).is().hidden();
        consecutiveSnackbarList.get(1).is().displayed();
    }

    @Test
    public void changeTransitionSnackbarTest() {
        transitionButtons.forEach(button -> {
            button.click();
            changeTransitionSnackbar.waitFor().displayed();
            changeTransitionSnackbar.has().text(LOVE_SNACKS);
        });
    }

    @Test
    public void controlSlideDirectionSnackbarTest() {
        directionButtons.forEach(button -> {
            button.click();
            controlSlideDirectionSnackbar.has().text(LOVE_SNACKS);
            button.click();
            controlSlideDirectionSnackbar.waitFor().hidden();
        });
    }

    @Test
    public void complementaryProjectsSnackbarTest() {
        showSnackbarButtons.get(1).click();
        complementaryProjectsSnackbar.waitFor().displayed();
        complementaryProjectsSnackbar.has().text(LOVE_SNACKS + ".");

        showSnackbarButtons.get(2).click();
        complementaryProjectsSnackbarList.get(1).has().text(LOVE_SNACKS + ".");
        complementaryProjectsSnackbarList.get(2).has().text(SUCCESS_MESSAGE);
        complementaryProjectsSnackbar.waitFor().disappear();
        complementaryProjectsSnackbar.is().notVisible();
    }
}
