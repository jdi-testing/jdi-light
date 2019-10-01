package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardKitchenSink;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardKitchenSinkTests extends TestsInit {
    private String imgSrc = "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg";
    private String imgAlt = "Spider Man";
    private String titleText = "CARD TITLE";
    private String cardText = "Some quick example text to build on the card title and make up the bulk of the card's content.";
    private String item0Text = "Cras justo odio";
    private String item1Text = "Dapibus ac facilisis in";
    private String item2Text = "Vestibulum at eros";
    private String link0Text = "JDI Light Github";
    private String link1Text = "JDI Website";
    private String link0Url = "https://github.com/jdi-testing/jdi-light";
    private String link1Url = "https://jdi-testing.github.io/jdi-light/index.html";
    private WebElement link0;
    private WebElement link1;
    private ArrayList<String> tabs;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void itemsTest() {
        assertEquals(cardKitchenSink.list.size(), 3);
        cardKitchenSink.list.get(1).is().text(is(item0Text));
        cardKitchenSink.list.get(2).is().text(is(item1Text));
        cardKitchenSink.list.get(3).is().text(is(item2Text));
        cardKitchenSink.list.get(1).is().text(containsString(item0Text));
        cardKitchenSink.list.get(2).is().text(containsString(item1Text));
        cardKitchenSink.list.get(3).is().text(containsString(item2Text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardKitchenSink.image);
        baseValidation(cardKitchenSink.title);
        baseValidation(cardKitchenSink.text);
        baseValidation(cardKitchenSink.list.get(1));
        baseValidation(cardKitchenSink.list.get(2));
        baseValidation(cardKitchenSink.list.get(3));
        baseValidation(cardKitchenSink.body.get(1));
        baseValidation(cardKitchenSink.body.get(2));
    }

    @Test
    public void isValidationTest() {
        cardKitchenSink.image.is().src(is(imgSrc));
        cardKitchenSink.image.is().alt(is(imgAlt));
        cardKitchenSink.image.unhighlight();
        cardKitchenSink.image.assertThat().width(is(86));
        cardKitchenSink.image.assertThat().height(is(137));
        cardKitchenSink.title.is().text(is(titleText));
        cardKitchenSink.title.is().text(containsString(titleText));
        cardKitchenSink.text.is().text(is(cardText));
        cardKitchenSink.text.is().text(containsString(cardText));
    }

    @Test
    public void linksTest(){
        link0 = cardKitchenSink.body.get(2).findElements(By.cssSelector(".card-link")).get(0);
        assertTrue(link0.isDisplayed());
        assertEquals(link0.getText(), link0Text);
        assertEquals(link0.getAttribute("target"), "_blank");
        assertEquals(link0.getTagName(), "a");

        link1 = cardKitchenSink.body.get(2).findElements(By.cssSelector(".card-link")).get(1);
        assertTrue(link1.isDisplayed());
        assertEquals(link1.getText(), link1Text);
        assertEquals(link1.getAttribute("target"), "_blank");
        assertEquals(link1.getTagName(), "a");

        WebDriver driver = WebDriverFactory.getDriver();

        link0.click();
        refreshTabs();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl(), link0Url);
        driver.close();
        driver.switchTo().window(tabs.get(0));

        link1.click();
        refreshTabs();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl(), link1Url);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    private void refreshTabs() {
        tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
    }
}
