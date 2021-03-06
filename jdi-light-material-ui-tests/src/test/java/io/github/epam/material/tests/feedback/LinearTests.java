package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.linearFrame;
import static io.github.com.StaticSite.linearIndeterminatePage;
import static io.github.com.StaticSite.linearDeterminatePage;
import static io.github.com.StaticSite.linearBufferPage;
import static io.github.com.StaticSite.linearWithLabelPage;
import static io.github.com.StaticSite.customisedProgressPage;

public class LinearTests extends TestsInit {
    private final String defaultColor = "rgba(63, 81, 181, 1)";
    private final String bufferBar2Color = "rgba(182, 188, 226, 1)";
    private final String customColorTop = "rgba(26, 144, 255, 1)";
    private final String customColorBack = "rgba(238, 238, 238, 1)";

    @Test
    public void indeterminateLinearTest() {
        linearIndeterminatePage.open();
        linearFrame.linearDefault.is().indeterminate();
    }

    @Test
    public void determinateLinearTest() {
        linearDeterminatePage.open();
        linearFrame.linearDefault.is().determinate();
        linearFrame.linearDefault.has().max(100);
        linearFrame.linearDefault.has().min(0);
        linearFrame.linearDefault.has().color(defaultColor);
    }

    @Test
    public void bufferProgressBarTest() {
        linearBufferPage.open();
        linearFrame.linearDefault.is().buffer();
        linearFrame.linearDefault.has().max(100);
        linearFrame.linearDefault.has().min(0);
        linearFrame.linearDefault.has().color(defaultColor, bufferBar2Color);
    }

    @Test
    public void linearLabelTest() {
        linearWithLabelPage.open();
        linearFrame.linearDefault.is().determinate();
        linearFrame.linearTypography.has().styleClass("body2");
    }

    @Test
    public void customizedProgressTest() {
        customisedProgressPage.open();
        linearFrame.circularTop.has().color(customColorTop);
        linearFrame.circularBackground.has().color(customColorBack);
        linearFrame.circularTop.is().indeterminate();
        linearFrame.circularBackground.is().determinate();

        linearFrame.linearDefault.has().color(customColorTop);
        linearFrame.linearDefault.isDeterminate();
        linearFrame.linearDefault.has().max(100);
        linearFrame.linearDefault.has().min(0);
        linearFrame.linearDefault.has().value(50);
        linearFrame.linearDefault.has().color(customColorTop);
    }
}
