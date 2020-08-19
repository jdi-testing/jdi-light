package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.cardSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardTests extends TestsInit {
    private static String header = "mat-card-header";
    private static String avatar = "mat-card-avatar";
    private static String headerText = "mat-card-header-text";
    private static String title = "mat-card-title";
    private static String subtitle = "mat-card-subtitle";
    private static String image = "mat-card-image";
    private static String content = "mat-card-content";
    private static String actions = "mat-card-actions";
    private static String button = "mat-button";
    private static String buttonsText = "mat-button-wrapper";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedBasicCardTest() {
        cardSection.simpleCard.is().displayed();
        cardSection.simpleCard.is().text("Simple card");
    }

    @Test
    public void displayedCardTest() {
        cardSection.card.is().displayed();
        cardSection.card.find(By.className(header)).is().displayed();
        cardSection.card.find(By.className(avatar)).is().displayed();
        cardSection.card.find(By.className(headerText)).is().displayed();
        cardSection.card.find(By.className(title)).is().displayed();
        cardSection.card.find(By.className(title)).is().text("Shiba Inu");
        cardSection.card.find(By.className(subtitle)).is().displayed();
        cardSection.card.find(By.className(subtitle)).is().text("Dog Breed");
        cardSection.card.find(By.className(image)).is().displayed();
        cardSection.card.find(By.className(image)).is().attr("src", "https://material.angular.io/assets/img/examples/shiba2.jpg");
        cardSection.card.find(By.className(image)).is().attr("alt", "Photo of a Shiba Inu");
        cardSection.card.find(By.className(content)).is().displayed();
        cardSection.card.find(By.className(actions)).is().displayed();
    }

    @Test
    public void cardButtonsTest() {
        cardSection.card.find(By.className(button)).list().is().size(2);
        cardSection.card.find(By.className(buttonsText)).list().is().size(2);
        WebElement buttonLike = cardSection.card.find(By.className(button)).getWebElements().get(0);
        WebElement buttonShare = cardSection.card.find(By.className(button)).getWebElements().get(1);
        assertTrue(buttonLike.isDisplayed());
        assertTrue(buttonShare.isDisplayed());
        assertEquals("LIKE", buttonLike.findElement(By.className(buttonsText)).getText());
        assertEquals("SHARE", buttonShare.findElement(By.className(buttonsText)).getText());
    }
}
