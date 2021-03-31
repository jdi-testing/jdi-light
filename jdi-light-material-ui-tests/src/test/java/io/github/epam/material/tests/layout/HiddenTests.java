package io.github.epam.material.tests.layout;

import com.epam.jdi.light.material.elements.layouts.Hidden;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.defaultHiddenPage;
import static io.github.com.StaticSite.hiddenFrame;

public class HiddenTests extends TestsInit {

    @Test
    public void defaultHiddenTest() {
        defaultHiddenPage.open();

        String width = hiddenFrame.currentWidth.getWidth();
        checkWidth(width);

        hiddenFrame.currentWidth.setHalfScreenWidthSize();
        width = hiddenFrame.currentWidth.getWidth();
        checkWidth(width);
    }

    private void checkWidth(String width) {
        String[] widthArr = {"xs", "sm", "md", "lg", "xl"};
        Hidden[] hiddenArr = {hiddenFrame.xsDown, hiddenFrame.smDown, hiddenFrame.mdDown, hiddenFrame.lgDown, hiddenFrame.xlDown};
        int j = 0;
        for (int i = j; !width.equals(widthArr[i]); i++) {
            hiddenArr[i].is().visible();
            j++;
        }
        for (int i = j; i < 5; i++) {
            hiddenArr[i].is().notVisible();
        }
    }
}
