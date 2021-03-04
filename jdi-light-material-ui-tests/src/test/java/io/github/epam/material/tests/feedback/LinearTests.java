package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class LinearTests extends TestsInit {
    private final String defaultColor = "rgba(63, 81, 181, 1)";
    private final String bufferBar2Color = "rgba(182, 188, 226, 1)";
    private final String customColorTop = "rgba(26, 144, 255, 1)";
    private final String customColorBack = "rgba(238, 238, 238, 1)";

    @Test
    public void verifyIndeterminateLinearTest() {
        linearIndeterminatePage.open();
        linearFrame.linearDefault.is().indeterminate();
        linearFrame.linearDefault.is().indeterminate();
    }

    @Test
    public void verifyDeterminateLinearTest() throws Exception {
        linearDeterminatePage.open();
        linearFrame.linearDefault.is().determinate();
        linearFrame.linearDefault.is().inProgress();
        linearFrame.linearDefault.has().max(100);
        linearFrame.linearDefault.has().min(0);
        linearFrame.linearDefault.has().color(defaultColor);
    }

    @Test
    public void verifyBufferProgressBarTest() throws Exception {
        linearBufferPage.open();
        linearFrame.linearDefault.is().buffer();
        linearFrame.linearDefault.inProgress();
        linearFrame.linearDefault.has().max(100);
        linearFrame.linearDefault.has().min(0);
        linearFrame.linearDefault.has().color(defaultColor, bufferBar2Color);
    }

    @Test
    public void verifyLinearLabelTest() {
        linearWithLabelPage.open();
        linearFrame.linearDefault.is().determinate();
        linearFrame.linearTypography.has().styleClass("body2");
        linearFrame.linearTypography.has().text("10%");
    }

    @Test
    public void verifyCustomizedProgressTest() throws Exception {
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
