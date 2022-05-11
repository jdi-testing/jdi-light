package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class ButtonDataProvider {

    @DataProvider
    public Object[][] containedButtonTestData() {
        return new Object[][] {
                {1, "DEFAULT", "Last click: Default"},
                {2, "PRIMARY", "Last click: Primary"},
                {3, "SECONDARY", "Last click: Secondary"},
                {4, "DISABLED", "Last click:"},
                {5, "LINK", "Last click: Link"}
        };
    }

    @DataProvider
    public Object[][] textButtonTestData() {
            return new Object[][] {
                {1, "DEFAULT", "Last click: Default"},
                {2, "PRIMARY", "Last click: Primary"},
                {3, "SECONDARY", "Last click: Secondary"},
                {4, "DISABLED", "Last click:"},
                {5, "LINK", "Last click: Link"}
            };
    }

    @DataProvider
    public Object[][] iconLabelButtonTestData() {
        return new Object[][] {
                {1, "DELETE", "Last click: Delete"},
                {2, "SEND\nSEND", "Last click: Sendsend"},
                {3, "UPLOAD", "Last click: Upload"},
                {4, "TALK", "Last click:"},
                {5, "SAVE", "Last click: Save"},
                {6, "SAVE ALL", "Last click: Save all"}
        };
    }

    @DataProvider
    public Object[][] iconButtonTestData() {
        return new Object[][] {
                {1, "Last click: Delete enabled"},
                {2, "Last click:"},
                {3, "Last click: Alarm"},
                {4, "Last click: Shopping cart"}
        };
    }

    @DataProvider
    public Object[][] customizeButtonTestData() {
        return new Object[][] {
                {1, "CUSTOM CSS", "Last click: Custom CSS"},
                {2, "THEME PROVIDER", "Last click: Theme Provider"},
                {3, "Bootstrap", "Last click: Bootstrap"},
        };
    }

    @DataProvider
    public Object[][] complexButtonTestData() {
        return new Object[][] {
                {1, "Breakfast", "Last click:Breakfast"},
                {2, "Burgers", "Last click:Burgers"},
                {3, "Camera", "Last click:Camera"}
        };
    }
}
