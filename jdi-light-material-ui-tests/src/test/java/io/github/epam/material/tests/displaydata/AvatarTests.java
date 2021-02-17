package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class AvatarTests extends TestsInit {
    @Test
    public void noImageTest(){
        dataDisplayNoImageAvatarPage.open();

        dataDisplayAvatarFrame.noImage.is().displayed();
    }

    @Test
    public void circleTest(){
        dataDisplayCircleAvatarPage.open();

        dataDisplayAvatarFrame.circle.is().displayed();
    }

    @Test
    public void squareTest(){
        dataDisplaySquareAvatarPage.open();

        dataDisplayAvatarFrame.square.is().displayed();
    }

    @Test
    public void roundedTest(){
        dataDisplayRoundedAvatarPage.open();

        dataDisplayAvatarFrame.rounded.is().displayed();
    }

    @Test
    public void fallbackAltTest(){
        dataDisplayFallbackAltAvatarPage.open();

        dataDisplayAvatarFrame.fallbackAlt.is().displayed();
    }

    @Test
    public void letterTest(){
        dataDisplayLetterAvatarPage.open();

        dataDisplayAvatarFrame.letter.is().displayed();
    }

    @Test
    public void iconTest(){
        dataDisplayIconAvatarPage.open();

        dataDisplayAvatarFrame.icon.is().displayed();
    }
}
