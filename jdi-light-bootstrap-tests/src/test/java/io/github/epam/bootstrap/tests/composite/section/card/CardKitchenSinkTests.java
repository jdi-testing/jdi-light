package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardKitchenSink;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class CardKitchenSinkTests extends TestsInit {
    private String imgSrc = "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg";
    private String imgAlt = "Spider Man";
    private String titleText = "CARD TITLE";
    private String cardText = "Some quick example text to build on the card title and make up the bulk of the card's content.";
    private String item1Text = "Cras justo odio";
    private String item2Text = "Dapibus ac facilisis in";
    private String item3Text = "Vestibulum at eros";
    private String link1Text = "JDI Light Github";
    private String link2Text = "JDI Website";
    private String link1Url = "https://github.com/jdi-testing/jdi-light";
    private String link2Url = "https://jdi-testing.github.io/jdi-light/index.html";
    private UIElement link1;
    private UIElement link2;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void itemsTest() {
        assertEquals(cardKitchenSink.list.size(), 3);
        cardKitchenSink.list.get(1).is().text(is(item1Text));
        cardKitchenSink.list.get(2).is().text(is(item2Text));
        cardKitchenSink.list.get(3).is().text(is(item3Text));
        cardKitchenSink.list.get(1).is().text(containsString(item1Text));
        cardKitchenSink.list.get(2).is().text(containsString(item2Text));
        cardKitchenSink.list.get(3).is().text(containsString(item3Text));
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
        link1 = cardKitchenSink.links.get(1);
        link1.is().displayed();
        link1.is().text(link1Text);
        link1.is().attr("target", "_blank")
                .and().tag(is("a"));

        link2 = cardKitchenSink.links.get(2);
        link2.is().displayed();
        link2.is().text(link2Text);
        link2.is().attr("target", "_blank")
                .and().tag(is("a"));

        WebDriver driver = WebDriverFactory.getDriver();

        link1.click();
        switchToWindow(2);
        assertEquals(getUrl(), link1Url);
        driver.close();
        switchToWindow(1);

        link2.click();
        switchToWindow(2);
        assertEquals(getUrl(), link2Url);
        driver.close();
        switchToWindow(1);
    }
}
