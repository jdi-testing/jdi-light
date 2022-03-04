package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class DialogDataProvider {

    @DataProvider(name = "simpleDialogDataProvider")
    public Object[][] simpleDialogData() {
        return new Object[][]{
                {"Set backup account", 0, "username@gmail.com"},
                {"Set backup account", 1, "user02@gmail.com"},
                {"Set backup account", 2, "Add account"}
        };
    }

}
