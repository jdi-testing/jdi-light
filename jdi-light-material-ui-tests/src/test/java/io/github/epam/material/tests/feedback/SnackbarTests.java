package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.feedback.SnackbarPage.*;

/**
 * To see an example of Snackbar web element please visit https://material-ui.com/components/snackbars/
 */

public class SnackbarTests extends TestsInit {

    private static Timer timer = new Timer(2000L);
    private static Map<String, String> map  = new HashMap<String, String>() {{
        put("topCenter", "TopCenter");
        put("topRight", "TopRight");
        put("bottomRight", "BottomRight");
        put("bottomCenter", "BottomCenter");
        put("bottomLeft", "BottomLeft");
        put("topLeft", "TopLeft");
    }};
    private static String cssConstanValue = "MuiSnackbar-root MuiSnackbar-anchorOrigin";

    @BeforeMethod
    public void before() {
        openSection("Snackbar");
    }

    @Test
    public void simpleSnackbarTest() {

        simpleSnackbarPopUp.is().notVisible();
        simpleSnackbarButton.click();
        simpleSnackbarPopUp.is().text("Note archived");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        simpleSnackbarPopUp.is().notVisible();
        simpleSnackbarButton.click();
        closePopUpSnackbarButton.click();
        simpleSnackbarPopUp.is().notVisible();
    }

    @Test
    public void customizedSnackbarTest() {

        customizedSnackbarPopUpTitles.get(1).is().text("This is an error message!");
        customizedSnackbarPopUpStyles.get(1).has().classValue(String.format("MuiPaper-root MuiAlert-root MuiAlert-filled%s MuiPaper-elevation6", "Error"));
        customizedSnackbarPopUpTitles.get(2).is().text("This is a warning message!");
        customizedSnackbarPopUpStyles.get(2).has().classValue(String.format("MuiPaper-root MuiAlert-root MuiAlert-filled%s MuiPaper-elevation6", "Warning"));
        customizedSnackbarPopUpTitles.get(3).is().text("This is an information message!");
        customizedSnackbarPopUpStyles.get(3).has().classValue(String.format("MuiPaper-root MuiAlert-root MuiAlert-filled%s MuiPaper-elevation6", "Info"));
        customizedSnackbarPopUpTitles.get(4).is().text("This is a success message!");
        customizedSnackbarPopUpStyles.get(4).has().classValue(String.format("MuiPaper-root MuiAlert-root MuiAlert-filled%s MuiPaper-elevation6", "Success"));

        successSnackbarPopUp.is().notVisible();
        successSnackbarButton.click();
        successSnackbarPopUp.is().text("This is a success message!");
        closePopUpSuccessButton.click();
        successSnackbarPopUp.is().notVisible();
    }

    @Test
    public void positionedSnackbarTest() {

        positionedSnackbarButtons.get(1).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("topCenter")));

        positionedSnackbarButtons.get(2).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("topRight")));

        positionedSnackbarButtons.get(3).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("bottomRight")));

        positionedSnackbarButtons.get(4).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("bottomCenter")));

        positionedSnackbarButtons.get(5).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("bottomLeft")));

        positionedSnackbarButtons.get(6).click();
        snackbarPopUpText.is().text("I love snacks");
        positionedSnackbarPopUp.has().classValue(String.format("%s%s", cssConstanValue, map.get("topLeft")));
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

        snackbarPopUpText.is().text("Message A");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(1).click();
        closePopUpSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(2).is().text("SHOW MESSAGE B");
        otherButtons.get(2).click();

        snackbarPopUpText.is().text("Message B");
        undoSnackbarButton.is().text("UNDO");
        undoSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();

        otherButtons.get(2).click();
        closePopUpSnackbarButton.click();
        timer.wait(() -> snackbarPopUpText.is().disappear());
        snackbarPopUpText.is().notVisible();
    }

    @Test
    public void changeTransitionSnackbarTest() {

        otherButtons.get(3).click();
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(4).click();
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(5).click();
        snackbarPopUpText.is().text("I love snacks");
    }

    @Test
    public void controlSlideDirectionSnackbarTest() {

        otherButtons.get(6).click();
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(7).click();
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(8).click();
        snackbarPopUpText.is().text("I love snacks");

        otherButtons.get(9).click();
        snackbarPopUpText.is().text("I love snacks");
    }

    @Test
    public void complementaryProjectsSnackbarTest() {

        otherButtons.get(10).click();
        notisnackPopUpText.is().text("I love snacks.");
        timer.wait(() -> notisnackPopUpText.is().disappear());
        notisnackPopUpText.is().notVisible();

        otherButtons.get(11).click();
        notisnackPopUpText.is().text("This is a success message!");
        timer.wait(() -> notisnackPopUpText.is().disappear());
        notisnackPopUpText.is().notVisible();
    }
}