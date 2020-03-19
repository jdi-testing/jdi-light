package io.github.epam.tests;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.searchPage;
import static io.github.com.pages.Header.iconSearch;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.pages.HomePage.linkText;
import static io.github.com.pages.HomePage.mainTitleName;
import static io.github.com.pages.HomePage.partialLinkText;
import static io.github.com.pages.HomePage.titleTag;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedOut;


public class RootTests extends StaticTestsInit {

    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        System.out.println(mainTitleName.getText());
        System.out.println(titleTag);
        iconSearch.click();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
//        linkText.click();
        partialLinkText.click();
    }
    @Test
    public void initDeepTest() {
        Assert.assertNotNull(homePage.testField);
        Assert.assertNotNull(searchPage.testField);
    }
}
