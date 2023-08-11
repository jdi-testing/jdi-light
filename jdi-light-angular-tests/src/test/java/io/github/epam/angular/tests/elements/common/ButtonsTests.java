package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import io.github.epam.data.ButtonsTestsDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.BASIC;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.EXTENDED_FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.FLAT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.ICON;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.MINI_FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.RAISED;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.STROKED;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;

import static io.github.com.pages.ButtonsPage.basicButtons;
import static io.github.com.pages.ButtonsPage.basicbuttonLabel;
import static io.github.com.pages.ButtonsPage.defaultColorButton;
import static io.github.com.pages.ButtonsPage.extendedFabButtons;
import static io.github.com.pages.ButtonsPage.extendedFabLabel;
import static io.github.com.pages.ButtonsPage.fabButtonLabel;
import static io.github.com.pages.ButtonsPage.fabButtons;
import static io.github.com.pages.ButtonsPage.flatButtonLabel;
import static io.github.com.pages.ButtonsPage.flatButtons;
import static io.github.com.pages.ButtonsPage.iconButtonLabel;
import static io.github.com.pages.ButtonsPage.iconButtons;
import static io.github.com.pages.ButtonsPage.miniFabButtonLabel;
import static io.github.com.pages.ButtonsPage.miniFabButtons;
import static io.github.com.pages.ButtonsPage.raisedButtonLabel;
import static io.github.com.pages.ButtonsPage.raisedButtons;
import static io.github.com.pages.ButtonsPage.strokedButtonLabel;
import static io.github.com.pages.ButtonsPage.strokedButtons;

public class ButtonsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test(dataProvider = "textButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks basic buttons attributes")
    public void basicButtonsTest(int index, String text, String color) {
        basicButtons.get(index).shouldBe().displayed();
        basicButtons.get(index).show();
        basicButtons.get(index).shouldBe().visible();

        basicButtons.get(index).has().text(text)
                    .and().visualTypeOfButton(BASIC)
                    .and().color(color);

        if (!text.equals("Disabled")) {
            basicButtons.get(index).click();
            basicButtons.get(index).is().focused()
                        .and().has().buttonLabelText(basicbuttonLabel, text);
        } else {
            basicButtons.get(index).is().disabled();
        }
    }

    @Test(description = "Test checks default color button attributes")
    public void defaultColorButtonTest() {
        defaultColorButton.shouldBe().displayed();
        defaultColorButton.show();
        defaultColorButton.shouldBe().visible();

        defaultColorButton.has().defaultColor()
                          .and().text("Basic")
                          .and().visualTypeOfButton(BASIC);

        defaultColorButton.click();
        defaultColorButton.is().focused();
    }

    @Test(dataProvider = "textFabButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks extended fab buttons attributes")
    public void extendedFabButtonsTest(int index, String text, String color, String labelText) {
        extendedFabButtons.get(index).shouldBe().displayed();
        extendedFabButtons.get(index).show();
        extendedFabButtons.get(index).shouldBe().visible();

        extendedFabButtons.get(index).has().text(text)
                          .and().visualTypeOfButton(EXTENDED_FAB)
                          .and().color(color);

        if (!text.equals("Disabled")) {
            extendedFabButtons.get(index).click();
            extendedFabButtons.get(index).is().focused()
                              .and().has().buttonLabelText(extendedFabLabel, labelText);
        } else {
            extendedFabButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textFabButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks fab buttons attributes")
    public void fabButtonsTest(int index, String text, String color, String labelText) {
        fabButtons.get(index).shouldBe().displayed();
        fabButtons.get(index).show();
        fabButtons.get(index).shouldBe().visible();

        fabButtons.get(index).has().text(text)
                  .and().visualTypeOfButton(FAB)
                  .and().color(color);

        if (!text.equals("Disabled")) {
            fabButtons.get(index).click();
            fabButtons.get(index).is().focused()
                      .and().has().buttonLabelText(fabButtonLabel, labelText);
        } else {
            fabButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks flat buttons attributes")
    public void flatButtonsTest(int index, String text, String color) {
        flatButtons.get(index).shouldBe().displayed();
        flatButtons.get(index).show();
        flatButtons.get(index).shouldBe().visible();

        flatButtons.get(index).has().text(text)
                   .and().visualTypeOfButton(FLAT)
                   .and().color(color);

        if (!text.equals("Disabled")) {
            flatButtons.get(index).click();
            flatButtons.get(index).is().focused()
                       .and().has().buttonLabelText(flatButtonLabel, text);
        } else {
            flatButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textIconButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks icon buttons attributes")
    public void iconButtonsTest(int index, String text, String color, String labelText) {
        iconButtons.get(index).shouldBe().displayed();
        iconButtons.get(index).show();
        iconButtons.get(index).shouldBe().visible();

        iconButtons.get(index).has().text(text)
                   .and().visualTypeOfButton(ICON)
                   .and().color(color);

        if (!(index == 5)) {
            iconButtons.get(index).click();
            iconButtons.get(index).is().focused()
                       .and().has().buttonLabelText(iconButtonLabel, labelText);
        } else {
            iconButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textFabButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks mini fab buttons attributes")
    public void miniFabButtonsTest(int index, String text, String color, String labelText) {
        miniFabButtons.get(index).shouldBe().displayed();
        miniFabButtons.get(index).show();
        miniFabButtons.get(index).shouldBe().visible();

        miniFabButtons.get(index).has().text(text)
                      .and().visualTypeOfButton(MINI_FAB)
                      .and().color(color);

        if (!text.equals("Disabled")) {
            miniFabButtons.get(index).click();
            miniFabButtons.get(index).is().focused()
                          .and().has().buttonLabelText(miniFabButtonLabel, labelText);
        } else {
            miniFabButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks raised buttons attributes")
    public void raisedButtonsTest(int index, String text, String color) {
        raisedButtons.get(index).shouldBe().displayed();
        raisedButtons.get(index).show();
        raisedButtons.get(index).shouldBe().visible();

        raisedButtons.get(index).has().text(text)
                     .and().visualTypeOfButton(RAISED)
                     .and().color(color);

        if (!text.equals("Disabled")) {
            raisedButtons.get(index).click();
            raisedButtons.get(index).is().focused()
                         .and().has().buttonLabelText(raisedButtonLabel, text);
        } else {
            raisedButtons.get(index).is().disabled();
        }
    }

    @Test(dataProvider = "textButtonsTestsData", dataProviderClass = ButtonsTestsDataProvider.class,
          description = "Test checks stroked buttons attributes")
    public void strokedButtonsTest(int index, String text, String color) {
        strokedButtons.get(index).shouldBe().displayed();
        strokedButtons.get(index).show();
        strokedButtons.get(index).shouldBe().visible();

        strokedButtons.get(index).has().text(text)
                      .and().visualTypeOfButton(STROKED)
                      .and().color(color);

        if (!text.equals("Disabled")) {
            strokedButtons.get(index).click();
            strokedButtons.get(index).is().focused()
                          .and().has().buttonLabelText(strokedButtonLabel, text);
        } else {
            strokedButtons.get(index).is().disabled();
        }
    }
}
