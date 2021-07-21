package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.snackbarPage;
import static org.hamcrest.Matchers.*;
import static io.github.com.pages.feedback.SnackbarPage.*;

/**
 * To see an example of Snackbar web element please visit
 * https://material-ui.com/components/snackbars/
 */

public class SnackbarTests extends TestsInit {

    private static Timer timer = new Timer(2000L);

    @BeforeMethod
    public void before() {
        snackbarPage.open();
    }

    @Test
    public void simpleSnackbarTest() {

        simpleSnackbarPopUp.is().notVisible();
        simpleSnackbarButton.click();
        timer.wait(() -> simpleSnackbarPopUp.isDisplayed());
        simpleSnackbarPopUp.is().text("Note archived");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        timer.wait(() -> simpleSnackbarPopUp.waitFor().hidden());
        simpleSnackbarPopUp.is().notVisible();
        simpleSnackbarButton.click();
        timer.wait(() -> simpleSnackbarPopUp.isDisplayed());
        closePopUpSnackbarButton.click();
        simpleSnackbarPopUp.is().notVisible();
    }

    @Test
    public void customizedSnackbarTest() {

        customizedSnackbarPopUpTitles.get(1).is().text("This is an error message!");
        customizedSnackbarPopUpStyles.get(1).has().classValue(containsString("MuiAlert-filledError"));
        customizedSnackbarPopUpTitles.get(2).is().text("This is a warning message!");
        customizedSnackbarPopUpStyles.get(2).has().classValue(containsString("MuiAlert-filledWarning"));
        customizedSnackbarPopUpTitles.get(3).is().text("This is an information message!");
        customizedSnackbarPopUpStyles.get(3).has().classValue(containsString("MuiAlert-filledInfo"));
        customizedSnackbarPopUpTitles.get(4).is().text("This is a success message!");
        customizedSnackbarPopUpStyles.get(4).has().classValue(containsString("MuiAlert-filledSuccess"));

        successSnackbarPopUp.is().notVisible();
        successSnackbarButton.click();
        successSnackbarPopUp.is().displayed();
        successSnackbarPopUp.is().text("This is a success message!");
        closePopUpSuccessButton.click();
        successSnackbarPopUp.is().notVisible();
    }

    @Test
    public void positionedSnackbarTest() {

        positionedSnackbarButtons.get(1).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("TopCenter"));
        positionedSnackbarButtons.get(1).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        positionedSnackbarButtons.get(2).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("TopRight"));
        positionedSnackbarButtons.get(2).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        positionedSnackbarButtons.get(3).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("BottomRight"));
        positionedSnackbarButtons.get(3).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        positionedSnackbarButtons.get(4).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("BottomCenter"));
        positionedSnackbarButtons.get(4).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        positionedSnackbarButtons.get(5).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("BottomLeft"));
        positionedSnackbarButtons.get(5).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        positionedSnackbarButtons.get(6).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(containsString("TopLeft"));
        positionedSnackbarButtons.get(6).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());
    }

    @Test
    public void messageLengthTest() {

        messageLengthContent.get(1).is().text("I love snacks.");
        messageLengthContentButtons.get(1).click();
        messageLengthContentButtons.get(1).is().text("LOREM IPSUM DOLOREM");

        messageLengthContent.get(2).is().text("I love candy. I love cookies. I love cupcakes. I love cheesecake. I love chocolate.");

        messageLengthContent.get(3).is().text("I love candy. I love cookies. I love cupcakes.");
        messageLengthContentButtons.get(2).click();

        messageLengthContent.get(4).is().text("I love candy. I love cookies. I love cupcakes. I love cheesecake. I love chocolate.");
        messageLengthContentButtons.get(3).click();
    }

    @Test
    public void consecutiveSnackbarsTest() {

        otherButtons.get(1).is().text("SHOW MESSAGE A");
        otherButtons.get(1).click();

        timer.wait(() -> snackbarPopUpText.isVisible());
        timer.wait(() -> undoSnackbarButton.isVisible());
        snackbarPopUpText.is().text("Message A");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(1).click();
        timer.wait(() -> closePopUpSnackbarButton.waitFor().displayed());
        closePopUpSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(2).is().text("SHOW MESSAGE B");
        otherButtons.get(2).click();

        timer.wait(() -> snackbarPopUpText.isVisible());
        timer.wait(() -> undoSnackbarButton.isVisible());

        snackbarPopUpText.is().text("Message B");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(2).click();
        timer.wait(() -> closePopUpSnackbarButton.waitFor().displayed());
        closePopUpSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();
    }

    @Test
    public void changeTransitionSnackbarTest() {

        otherButtons.get(3).click();
        timer.wait(() -> snackbarPopUpText.isVisible());
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(4).click();
        timer.wait(() -> snackbarPopUpText.isVisible());
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(5).click();
        timer.wait(() -> snackbarPopUpText.isVisible());
        snackbarPopUpText.is().text("I love snacks");
    }

    @Test
    public void controlSlideDirectionSnackbarTest() {

        otherButtons.get(6).click();
        snackbarPopUpText.is().text("I love snacks");
        otherButtons.get(6).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        otherButtons.get(7).click();
        snackbarPopUpText.is().text("I love snacks");
        otherButtons.get(7).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        otherButtons.get(8).click();
        snackbarPopUpText.is().text("I love snacks");
        otherButtons.get(8).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());

        otherButtons.get(9).click();
        snackbarPopUpText.is().text("I love snacks");
        otherButtons.get(9).click();
        timer.wait(() -> snackbarPopUpText.waitFor().hidden());
    }

    @Test
    public void complementaryProjectsSnackbarTest() {
//TODO fix
// Found 2 elements instead of one for Element 'SnackbarPage.notisnackPopUpText (xpath='//div[@id='notistack-snackbar']')' during 0 seconds

        otherButtons.get(10).click();
        timer.wait(() -> notisnackPopUpText.isVisible());
        notisnackPopUpText.is().text("I love snacks.");
        timer.wait(() -> notisnackPopUpText.is().disappear());
        timer.wait(() -> notisnackPopUpText.waitFor().hidden());
        notisnackPopUpText.is().notVisible();

        otherButtons.get(11).click();
        timer.wait(() -> notisnackPopUpText.isVisible());
        notisnackPopUpText.is().text("This is a success message!");
        timer.wait(() -> notisnackPopUpText.is().disappear());
        notisnackPopUpText.is().notVisible();
    }
}