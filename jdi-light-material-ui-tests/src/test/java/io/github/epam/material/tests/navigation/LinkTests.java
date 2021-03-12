package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.hasToString;

public class LinkTests extends TestsInit {
    @Test
    public void defaultLinkTest() {
        defaultLinkPage.open();

        linkFrame.link.is().underlineHover();
        linkFrame.link.is().colorPrimary();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }

    @Test
    public void secondaryLinkTest() {
        secondaryLinkPage.open();

        linkFrame.link.is().underlineHover();
        linkFrame.link.is().colorSecondary();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }

    @Test
    public void textPrimaryLinkTest() {
        textPrimaryLinkPage.open();

        linkFrame.link.is().underlineHover();
        linkFrame.link.is().colorTextPrimary();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }

    @Test
    public void textSecondaryLinkTest() {
        textSecondaryLinkPage.open();

        linkFrame.link.is().underlineHover();
        linkFrame.link.is().colorTextSecondary();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }

    @Test
    public void errorLinkTest() {
        errorLinkPage.open();

        linkFrame.link.is().underlineHover();
        linkFrame.link.is().colorError();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }

    @Test
    public void underlineAlwaysLinkTest() {
        underlineAlwaysLinkPage.open();

        linkFrame.link.is().underlineAlways();
        linkFrame.link.click();
        linkFrame.link.is().text(hasToString("Link"));
    }
}
