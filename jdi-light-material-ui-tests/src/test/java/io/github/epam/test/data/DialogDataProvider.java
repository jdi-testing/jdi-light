package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class DialogDataProvider {

    private final String alertDialogText =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ultricesurna tortor, " +
                    "ac pharetra tortor venenatis id. Praesent consecteturtempor fringilla." +
                    " Cras laoreet sodales pellentesque. Ut nibh leo,auctor id massa vitae," +
                    " consequat congue turpis.";

    @DataProvider(name = "simpleDialogDataProvider")
    public Object[][] simpleDialogData() {
        return new Object[][]{
                {"Set backup account", 1, "username@gmail.com"},
                {"Set backup account", 2, "user02@gmail.com"},
                {"Set backup account", 3, "Add account"}
        };
    }

    @DataProvider(name = "alertDialogDataProvider")
    public Object[][] alertDialogData() {
        return new Object[][]{
                {"Alert dialog question?", alertDialogText, "Selected: close", "Selected: ok"}
        };
    }

    @DataProvider(name = "formDialogDataProvider")
    public Object[][] formDialogData() {
        return new Object[][]{
                {"Form Dialog", alertDialogText, "email@example.com", "Entered email: email@example.com", "Entered email:"}
        };
    }

    @DataProvider(name = "confirmationDialogDataProvider")
    public Object[][] confirmationDialogData() {
        return new Object[][]{
                {"Phone Ringtone", "Callisto", "None", "Triton"},
        };
    }

    @DataProvider(name = "scrollableDialogDataProvider")
    public Object[][] scrollableDialogData() {
        String dialogScrollableTextContent = "Cras mattis consectetur purus sit amet fermentum. " +
                "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, " +
                "porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, " +
                "vel scelerisque nisl consectetur et.";
        return new Object[][]{
                {"Subscribe", dialogScrollableTextContent, "Last clicked button: Subscribe", "Last clicked button: Cancel"}
        };
    }
}
