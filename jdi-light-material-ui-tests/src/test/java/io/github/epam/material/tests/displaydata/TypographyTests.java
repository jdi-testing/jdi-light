package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dataDisplayTypographyPage;
import static io.github.com.StaticSite.typographyFrame;

public class TypographyTests extends TestsInit {

    @Test
    public void typographyViewTest() {
        dataDisplayTypographyPage.open();

        typographyFrame.h1Typography.has().text("Head 1");
        typographyFrame.h1Typography.has().styleClass("h1");

        typographyFrame.subtitle2Typography.has().styleClass("subtitle2");
        typographyFrame.subtitle2Typography.has().text("Subtitle 2");

        typographyFrame.buttonTypography.has().styleClass("button");
        typographyFrame.buttonTypography.has().text("BUTTON TEXT");
    }
}
