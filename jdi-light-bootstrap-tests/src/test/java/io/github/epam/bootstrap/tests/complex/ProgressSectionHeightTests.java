package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ProgressBarWrapper;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class ProgressSectionHeightTests extends TestsInit {

    List<ProgressBarWrapper> list;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        list = progressHeightSection.getProgressBarWrappersList();
    }

    @Test
    public void HeightOfWrapperShouldBeValid() {
        for (ProgressBarWrapper wrapper : list) {
            int actualHeight = wrapper.core().getSize().getHeight();
            int expectedHeight = wrapper.getWrapperHeightValueInPx();
            assertEquals(actualHeight, expectedHeight);
        }
    }

    @Test
    public void HeightOfBarShouldBeValid() {
        for (ProgressBarWrapper wrapper : list) {
            int expectedBarHeight = wrapper.getWrapperHeightValueInPx();

            List<Progress> progressBarList = wrapper.getProgressBarList();
            for (Progress progressBar : progressBarList) {
                int actualBarHeight = progressBar.core().getSize().getHeight();
                assertEquals(actualBarHeight, expectedBarHeight);
            }
        }
    }


}
