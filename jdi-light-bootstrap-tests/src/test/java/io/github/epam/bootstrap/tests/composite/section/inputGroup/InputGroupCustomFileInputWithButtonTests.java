package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.elements.common.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class InputGroupCustomFileInputWithButtonTests extends TestsInit {
    public final static String BUTTON_TEXT = "Button";
    public final static String INPUT_TEXT_DEFAULT = "Choose file";
    public final static String INPUT_TEXT = "general.xml";
    public final static String FILE_NAME = "/src/test/resources/general.xml";
    public final static String buttonClickAlert = "Button clicked, thank you!";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void labelTextTests() {
        customFileInputWithButtonPrepend.button.is().text(BUTTON_TEXT);
        customFileInputWithButtonPrepend.button.is().value(BUTTON_TEXT);

        customFileInputWithButtonAppend.button.is().text(BUTTON_TEXT);
        customFileInputWithButtonAppend.button.is().value(BUTTON_TEXT);
    }

    @Test
    public void inputTextTests() {
        customFileInputWithButtonPrepend.inputText.is().text(INPUT_TEXT_DEFAULT);
        customFileInputWithButtonPrepend.inputText.is().value(INPUT_TEXT_DEFAULT);

        customFileInputWithButtonAppend.inputText.is().text(INPUT_TEXT_DEFAULT);
        customFileInputWithButtonAppend.inputText.is().value(INPUT_TEXT_DEFAULT);
    }

    @Test
    public void uploadTest() {
        customFileInputWithButtonPrepend.click();
        customFileInputWithButtonPrepend.inputField.uploadFile(mergePath(PROJECT_PATH,FILE_NAME));
        customFileInputWithButtonAppend.click();
        customFileInputWithButtonAppend.inputField.uploadFile(mergePath(PROJECT_PATH,FILE_NAME));

        customFileInputWithButtonPrepend.inputText.is().text(INPUT_TEXT);
        customFileInputWithButtonPrepend.inputText.is().value(INPUT_TEXT);
        customFileInputWithButtonAppend.inputText.is().text(INPUT_TEXT);
        customFileInputWithButtonAppend.inputText.is().value(INPUT_TEXT);
    }


    @Test
    public void buttonTests() {
        customFileInputWithButtonPrepend.button.hover();
        customFileInputWithButtonAppend.button.hover();

        customFileInputWithButtonPrepend.button.is().displayed();
        customFileInputWithButtonPrepend.button.is().enabled();
        customFileInputWithButtonAppend.button.is().displayed();
        customFileInputWithButtonAppend.button.is().enabled();

        customFileInputWithButtonPrepend.button.click();
        validateAlert(is(buttonClickAlert));
        acceptAlert();

        customFileInputWithButtonAppend.button.click();
        validateAlert(is(buttonClickAlert));
    }

    @Test
    public void isValidationOptionsSectionTests() {
        customFileInputWithButtonPrepend.is().enabled();
        customFileInputWithButtonPrepend.is().displayed()
                .core()
                .hasClass("input-group mb-3")
                .css("font-size", is("14px"))
                .tag("div");
        customFileInputWithButtonPrepend.find(By.cssSelector("div:nth-child(1)")).is().enabled();
        customFileInputWithButtonPrepend.find(By.cssSelector("div:nth-child(1)")).is().displayed()
                .core()
                .hasClass("input-group-prepend")
                .tag("div");
        customFileInputWithButtonPrepend.find(By.cssSelector("div:nth-child(2)")).is().enabled();
        customFileInputWithButtonPrepend.find(By.cssSelector("div:nth-child(2)")).is().displayed()
                .core()
                .hasClass("custom-file")
                .tag("div");
        customFileInputWithButtonPrepend.button.is().enabled();
        customFileInputWithButtonPrepend.button.is().displayed()
                .core()
                .hasClass("input-group-text")
                .tag("span")
                .css("background-color", is("rgba(233, 236, 239, 1)")) // #e9ecef Color Hex
                .css("color", is("rgba(73, 80, 87, 1)")) // #495057 Color Hex
                .css("text-align", is("center"))
                .css("font-size", is("16px"))
                .css("align-items", is("center"))
                .attr("id", "inputGroupFileAddon01");
        customFileInputWithButtonPrepend.inputText.is().enabled();
        customFileInputWithButtonPrepend.inputText.is().displayed()
                .core()
                .hasClass("custom-file-label")
                .tag("label")
                .css("background-color", is("rgba(255, 255, 255, 1)")) // #fff Color Hex
                .css("color", is("rgba(73, 80, 87, 1)")) // #495057 Color Hex
                .css("position", is("absolute"))
                .attr("for", "inputGroupFile01");
        customFileInputWithButtonPrepend.inputField.is().enabled();
        customFileInputWithButtonPrepend.inputField.is().hidden()
                .core()
                .hasClass("custom-file-input")
                .tag("input")
                .css("position", is("relative"))
                .attr("aria-describedby", "inputGroupFileAddon01")
                .attr("type", "file")
                .attr("id", "inputGroupFile01");

        customFileInputWithButtonAppend.is().enabled();
        customFileInputWithButtonAppend.is().displayed()
                .core()
                .hasClass("input-group mb-3")
                .css("font-size", is("14px"))
                .tag("div");
        customFileInputWithButtonAppend.find(By.cssSelector("div:nth-child(1)")).is().enabled();
        customFileInputWithButtonAppend.find(By.cssSelector("div:nth-child(1)")).is().displayed()
                .core()
                .hasClass("custom-file")
                .tag("div");
        customFileInputWithButtonAppend.find(By.cssSelector("div:nth-child(2)")).is().enabled();
        customFileInputWithButtonAppend.find(By.cssSelector("div:nth-child(2)")).is().displayed()
                .core()
                .hasClass("input-group-append")
                .tag("div");
        customFileInputWithButtonAppend.button.is().enabled();
        customFileInputWithButtonAppend.button.is().displayed()
                .core()
                .hasClass("input-group-text")
                .tag("span")
                .css("background-color", is("rgba(233, 236, 239, 1)")) // #e9ecef Color Hex
                .css("color", is("rgba(73, 80, 87, 1)")) // #495057 Color Hex
                .css("text-align", is("center"))
                .css("font-size", is("16px"))
                .css("align-items", is("center"))
                .attr("id", "inputGroupFileAddon02");
        customFileInputWithButtonAppend.inputText.is().enabled();
        customFileInputWithButtonAppend.inputText.is().displayed()
                .core()
                .hasClass("custom-file-label")
                .tag("label")
                .css("background-color", is("rgba(255, 255, 255, 1)")) // #fff Color Hex
                .css("color", is("rgba(73, 80, 87, 1)")) // #495057 Color Hex
                .css("position", is("absolute"))
                .attr("aria-describedby", "inputGroupFileAddon02")
                .attr("for", "inputGroupFile02");
        customFileInputWithButtonAppend.inputField.is().enabled();
        customFileInputWithButtonAppend.inputField.is().hidden()
                .core()
                .hasClass("custom-file-input")
                .tag("input")
                .css("position", is("relative"))
                .attr("type", "file")
                .attr("id", "inputGroupFile02");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(customFileInputWithButtonPrepend);
        baseValidation(customFileInputWithButtonAppend);
    }
}
