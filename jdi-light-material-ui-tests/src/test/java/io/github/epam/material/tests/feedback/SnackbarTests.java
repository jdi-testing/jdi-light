package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.snackbarPage;
import static io.github.com.pages.feedback.SnackbarPage.complementaryProjectsSnackbarList;
import static io.github.com.pages.feedback.SnackbarPage.consecutiveSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.positionedSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.showMessageButtons;
import static io.github.com.pages.feedback.SnackbarPage.showSnackbarButtons;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.simpleSnackbarButton;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbar;
import static io.github.com.pages.feedback.SnackbarPage.successSnackbarButton;
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
    private static final String MESSAGE_A = "Message A";
    private static final String MESSAGE_B = "Message B";


    @BeforeMethod
    public void before() {
        snackbarPage.open();
        snackbarPage.isOpened();
    }

    @Test
    public void simpleSnackbarTest() {
        simpleSnackbar.is().notVisible();

        simpleSnackbarButton.click();
        simpleSnackbar.is().displayed().and().has().text("Note archived");

        simpleSnackbar.snackbarButton(UNDO).click();
        simpleSnackbar.is().hidden().and().is().notVisible();

        simpleSnackbarButton.click();
        simpleSnackbar.is().displayed();
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
    }

    @Test(dataProviderClass = SnackbarsDataProvider.class, dataProvider = "positionedSnackbarDataProvider")
    public void positionedSnackbarTest(int number, Position position) {
        positionedSnackbarButtons.get(number).core()
                .jsExecute("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");

        positionedSnackbarButtons.get(number).click();
        positionedSnackbar.has().text(LOVE_SNACKS).and().position(position);

        positionedSnackbarButtons.get(number).click();
        positionedSnackbar.is().hidden();
    }

    @Test
    public void consecutiveSnackbarsTest() {
        showMessageButtons.get(1).click();
        consecutiveSnackbar.is().displayed().and().has().text(MESSAGE_A);

        showMessageButtons.get(2).click();
        consecutiveSnackbar.is().displayed().and().has().text(MESSAGE_B);
        consecutiveSnackbar.is().hidden();
    }

    @Test
    public void complementaryProjectsSnackbarTest() {
        showSnackbarButtons.get(1).click();
        complementaryProjectsSnackbarList.get(1).is().displayed()
                .and().has().text(LOVE_SNACKS + ".");

        showSnackbarButtons.get(2).click();
        complementaryProjectsSnackbarList.get(1).has().text(LOVE_SNACKS + ".");
        complementaryProjectsSnackbarList.get(2).has().text(SUCCESS_MESSAGE);
        complementaryProjectsSnackbarList.get(1).is().notVisible();
        complementaryProjectsSnackbarList.get(2).is().notVisible();
    }
}
