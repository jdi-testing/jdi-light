package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static io.github.com.StaticSite.overlaysPage;
import static io.github.com.pages.OverlaysPage.*;

public class OverlayTests extends TestsInit {

    @BeforeClass
    public void before() {
        overlaysPage.open();
        overlaysPage.checkOpened();
    }

    @Test
    public void absoluteOverlayTest(){
        absoluteOverlay.is().absolute();
        absoluteOverlay.is().notActive();
        absoluteOverlay.is().opacity(0);

        absoluteOverlayButton.click();
        absoluteOverlay.is().absolute();
        absoluteOverlay.is().active();
        absoluteOverlay.is().opacity(0.46);

        absoluteOverlay.content().find("button").click();
        absoluteOverlay.is().notActive();
        absoluteOverlay.is().opacity(0);
    }

    @Test
    public void opacityOverlayTest(){
        opacityOverlay.is().opacity(0);
        opacityOverlayButton.click();
        opacityOverlay.is().opacity(1);
        opacityOverlay.content().find("button").click();
        opacityOverlay.is().opacity(0);
    }

    @Test
    public void notAbsoluteOverlayTest(){
        Assert.assertTrue(absoluteOverlayButton.isClickable());
        Assert.assertTrue(opacityOverlayButton.core().isClickable());
        zIndexOverlay.is().notAbsolute();
        zIndexOverlayButton.click();
        zIndexOverlay.is().active();
        Assert.assertFalse(absoluteOverlayButton.isClickable());
    }

    @Test
    public void zIndexOverlayTest(){
        zIndexOverlay.is().zIndex(0);
        zIndexOverlay.is().opacity(0);

        absoluteOverlay.is().zIndex(5);
        absoluteOverlayButton.click();
        absoluteOverlay.is().active();

        zIndexOverlayButton.click();
        zIndexOverlay.is().active();

        absoluteOverlay.content().find("button").click();
        absoluteOverlay.is().notActive();

        zIndexOverlay.content().find("button").click();
        absoluteOverlay.is().active();
    }
}
