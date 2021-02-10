package io.github.epam.material.tests.datadisplay;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dataDisplayTypographyPage;
import static io.github.com.StaticSite.typographyFrame;
import static org.hamcrest.Matchers.containsString;

public class TypographyTests extends TestsInit {

    @Test
    public void typographyViewTest() {
        dataDisplayTypographyPage.open();

        typographyFrame.h1Typography.has().text(containsString("Head 1"));
        typographyFrame.h1Typography.has().styleClass("h1");

        typographyFrame.subtitle2Typography.has().styleClass("subtitle2");
        typographyFrame.subtitle2Typography.has().text(containsString("Subtitle 2"));

        typographyFrame.buttonTypography.has().styleClass("button");
        typographyFrame.buttonTypography.has().text(containsString("BUTTON TEXT"));
    }
}
