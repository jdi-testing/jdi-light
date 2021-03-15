package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.linearProgressFrame;
import static io.github.com.StaticSite.linearIndeterminatePage;
import static io.github.com.StaticSite.linearDeterminatePage;
import static io.github.com.StaticSite.linearBufferPage;
import static io.github.com.StaticSite.linearWithLabelPage;
import static io.github.com.StaticSite.customisedProgressPage;

public class LinearProgressTests extends TestsInit {
    private final String defaultColor = "rgba(63, 81, 181, 1)";
    private final String bufferBar2Color = "rgba(182, 188, 226, 1)";
    private final String customColorTop = "rgba(26, 144, 255, 1)";
    private final String customColorBack = "rgba(238, 238, 238, 1)";

    @Test
    public void indeterminateLinearTest() {
        linearIndeterminatePage.open();
        linearProgressFrame.linearDefault.is().indeterminate();
    }

    @Test
    public void determinateLinearTest() {
        linearDeterminatePage.open();
        linearProgressFrame.linearDefault.is().determinate();
        linearProgressFrame.linearDefault.has().max(100);
        linearProgressFrame.linearDefault.has().min(0);
        linearProgressFrame.linearDefault.has().color(defaultColor);
    }

    @Test
    public void bufferProgressBarTest() {
        linearBufferPage.open();
        linearProgressFrame.linearDefault.is().buffer();
        linearProgressFrame.linearDefault.has().max(100);
        linearProgressFrame.linearDefault.has().min(0);
        linearProgressFrame.linearDefault.has().color(defaultColor, bufferBar2Color);
    }

    @Test
    public void linearLabelTest() {
        linearWithLabelPage.open();
        linearProgressFrame.linearDefault.is().determinate();
        linearProgressFrame.linearTypography.has().styleClass("body2");
    }

    @Test
    public void customizedProgressTest() {
        customisedProgressPage.open();
        linearProgressFrame.circularTop.has().color(customColorTop);
        linearProgressFrame.circularBackground.has().color(customColorBack);
        linearProgressFrame.circularTop.is().indeterminate();
        linearProgressFrame.circularBackground.is().determinate();

        linearProgressFrame.linearDefault.has().color(customColorTop);
        linearProgressFrame.linearDefault.isDeterminate();
        linearProgressFrame.linearDefault.has().max(100);
        linearProgressFrame.linearDefault.has().min(0);
        linearProgressFrame.linearDefault.has().value(50);
        linearProgressFrame.linearDefault.has().color(customColorTop);
    }
}
