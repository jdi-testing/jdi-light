package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.BUFFER;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.DETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.INDETERMINATE;
import static com.epam.jdi.light.angular.elements.enums.ProgressBarModes.QUERY;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressBarPage;
import static io.github.com.pages.ProgressBarPage.matProgressBarBuffer;
import static io.github.com.pages.ProgressBarPage.matProgressBarConfigurable;
import static io.github.com.pages.ProgressBarPage.matProgressBarDeterminate;
import static io.github.com.pages.ProgressBarPage.matProgressBarIndeterminate;
import static io.github.com.pages.ProgressBarPage.matProgressBarQuery;
import static io.github.com.pages.ProgressBarPage.showBufferProgressBarButton;
import static io.github.com.pages.ProgressBarPage.showIndeterminateProgressBarButton;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProgressBarUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        progressBarPage.open();
        waitCondition(() -> progressBarPage.isOpened());
        progressBarPage.checkOpened();
    }

    @Test
    public void isDisplayedTest() {
        assertTrue(matProgressBarDeterminate.isDisplayed());
        assertTrue(matProgressBarQuery.isDisplayed());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isDisplayed());
        showBufferProgressBarButton.click();
        assertTrue(matProgressBarBuffer.isDisplayed());
        assertTrue(matProgressBarConfigurable.isDisplayed());
    }

    @Test
    public void isVisibleTest() {
        matProgressBarDeterminate.show();
        assertTrue(matProgressBarDeterminate.isVisible());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isVisible());
        showBufferProgressBarButton.click();
        assertTrue(matProgressBarBuffer.isVisible());
        matProgressBarQuery.show();
        assertTrue(matProgressBarQuery.isVisible());
        matProgressBarConfigurable.show();
        assertTrue(matProgressBarConfigurable.isVisible());
    }

    @Test
    public void verifyDisappearTest() {
        refresh();
        assertFalse(matProgressBarIndeterminate.isDisplayed());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isDisplayed());
        matProgressBarIndeterminate.is().disappear(5);
        assertTrue(matProgressBarIndeterminate.isHidden());
        showBufferProgressBarButton.click();
        assertTrue(matProgressBarBuffer.isDisplayed());
        matProgressBarBuffer.is().disappear(5);
        assertTrue(matProgressBarBuffer.isHidden());
    }

    @Test
    public void verifyModesTest() {
        assertEquals(matProgressBarDeterminate.mode(), DETERMINATE.getMode());
        assertEquals(matProgressBarQuery.mode(), QUERY.getMode());
        showIndeterminateProgressBarButton.click();
        assertEquals(matProgressBarIndeterminate.mode(), INDETERMINATE.getMode());
        showBufferProgressBarButton.click();
        assertEquals(matProgressBarBuffer.mode(), BUFFER.getMode());
        assertEquals(matProgressBarConfigurable.mode(), DETERMINATE.getMode());
    }

    @Test
    public void verifyValuesTest() throws Exception {
        assertEquals(matProgressBarDeterminate.value(), 40);
        showBufferProgressBarButton.click();
        assertEquals(matProgressBarBuffer.bufferValue(), 0);
        assertEquals(matProgressBarBuffer.value(), 0);
        assertEquals(matProgressBarConfigurable.value(), 50);
    }

    @Test
    public void verifyMinValuesTest() {
        assertEquals(matProgressBarDeterminate.min(), 0);
        showBufferProgressBarButton.click();
        assertEquals(matProgressBarBuffer.min(), 0);
        assertEquals(matProgressBarBuffer.min(), 0);
        showIndeterminateProgressBarButton.click();
        assertEquals(matProgressBarIndeterminate.min(), 0);
        assertEquals(matProgressBarQuery.min(), 0);
        assertEquals(matProgressBarConfigurable.min(), 0);
    }

    @Test
    public void verifyMaxValuesTest() {
        assertEquals(matProgressBarDeterminate.max(), 100);
        showBufferProgressBarButton.click();
        assertEquals(matProgressBarBuffer.max(), 100);
        assertEquals(matProgressBarBuffer.max(), 100);
        showIndeterminateProgressBarButton.click();
        assertEquals(matProgressBarIndeterminate.max(), 100);
        assertEquals(matProgressBarQuery.max(), 100);
        assertEquals(matProgressBarConfigurable.max(), 100);
    }
}
