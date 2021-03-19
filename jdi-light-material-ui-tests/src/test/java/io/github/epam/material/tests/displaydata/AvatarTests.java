package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class AvatarTests extends TestsInit {
    @Test
    public void noImageTest(){
        dataDisplayNoImageAvatarPage.open();

        dataDisplayAvatarFrame.noImage.is().displayed();
        dataDisplayAvatarFrame.noImage.is().hasClass("MuiAvatar-circle");
        dataDisplayAvatarFrame.noImage.is().hasClass("MuiAvatar-colorDefault");
    }

    @Test
    public void circleTest(){
        dataDisplayCircleAvatarPage.open();

        dataDisplayAvatarFrame.circle.is().displayed();
        dataDisplayAvatarFrame.circle.is().hasClass("MuiAvatar-circle");
        dataDisplayAvatarFrame.circle.is().displayedImg();
        dataDisplayAvatarFrame.circle.is().hasImg("MuiAvatar-img");
    }

    @Test
    public void squareTest(){
        dataDisplaySquareAvatarPage.open();

        dataDisplayAvatarFrame.square.is().displayed();
        dataDisplayAvatarFrame.square.is().hasClass("MuiAvatar-square");
        dataDisplayAvatarFrame.square.is().displayedImg();
        dataDisplayAvatarFrame.square.is().hasImg("MuiAvatar-img");
    }

    @Test
    public void roundedTest(){
        dataDisplayRoundedAvatarPage.open();

        dataDisplayAvatarFrame.rounded.is().displayed();
        dataDisplayAvatarFrame.rounded.hasClass("MuiAvatar-rounded");
        dataDisplayAvatarFrame.rounded.is().displayedImg();
        dataDisplayAvatarFrame.rounded.is().hasImg("MuiAvatar-img");
    }

    @Test
    public void fallbackAltTest(){
        dataDisplayFallbackAltAvatarPage.open();

        dataDisplayAvatarFrame.fallbackAlt.is().displayed();
        dataDisplayAvatarFrame.fallbackAlt.is().hasClass("MuiAvatar-circle");
        dataDisplayAvatarFrame.fallbackAlt.is().hasClass("MuiAvatar-colorDefault");
        dataDisplayAvatarFrame.fallbackAlt.is().text("L");
    }

    @Test
    public void letterTest(){
        dataDisplayLetterAvatarPage.open();

        dataDisplayAvatarFrame.letter.is().displayed();
        dataDisplayAvatarFrame.letter.is().hasClass("MuiAvatar-circle");
        dataDisplayAvatarFrame.fallbackAlt.is().hasClass("MuiAvatar-colorDefault");
        dataDisplayAvatarFrame.fallbackAlt.is().text("A");
    }

    @Test
    public void iconTest(){
        dataDisplayIconAvatarPage.open();

        dataDisplayAvatarFrame.icon.is().displayed();
        dataDisplayAvatarFrame.icon.is().hasClass("MuiAvatar-circle");
        dataDisplayAvatarFrame.icon.is().hasClass("MuiAvatar-colorDefault");
        dataDisplayAvatarFrame.icon.is().displayedSvg();
        dataDisplayAvatarFrame.icon.is().hasSvg("MuiSvgIcon-root");
    }
}
