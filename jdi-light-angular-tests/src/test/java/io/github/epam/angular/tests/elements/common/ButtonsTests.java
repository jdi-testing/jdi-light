package io.github.epam.angular.tests.elements.common;

import java.util.Random;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.BASIC;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.EXTENDED_FAB;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.FAB;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.FLAT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.ICON;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.MINI_FAB;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.RAISED;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTypes.STROKED;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.accentColorButtons;
import static io.github.com.pages.ButtonsPage.basicButtons;
import static io.github.com.pages.ButtonsPage.defaultColorButton;
import static io.github.com.pages.ButtonsPage.extendedFabButtons;
import static io.github.com.pages.ButtonsPage.fabButtons;
import static io.github.com.pages.ButtonsPage.flatButtons;
import static io.github.com.pages.ButtonsPage.iconButtons;
import static io.github.com.pages.ButtonsPage.miniFabButtons;
import static io.github.com.pages.ButtonsPage.primaryColorButtons;
import static io.github.com.pages.ButtonsPage.raisedButtons;
import static io.github.com.pages.ButtonsPage.strokedButtons;
import static io.github.com.pages.ButtonsPage.warnColorButtons;

public class ButtonsTests extends TestsInit {
    Random rand = new Random();

    @BeforeClass
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test(description = "Test checks basic buttons attributes")
    public void basicButtonsTest() {
        Button basicButton = basicButtons.stream().filter(b -> b.text().equalsIgnoreCase("Disabled"))
                .findAny().orElse(null);

        basicButton.is().displayed();
        basicButton.show();
        basicButton.is().visible();

        basicButton.has().visualType(BASIC);

        basicButton.has().text("Disabled").is().disabled();
    }

    @Test(description = "Test checks default color button attributes")
    public void defaultColorButtonTest() {
        defaultColorButton.show();
        defaultColorButton.shouldBe().visible();

        defaultColorButton.has().defaultColor()
                          .and().text("Basic")
                          .and().visualType(BASIC);

        defaultColorButton.click();
        defaultColorButton.is().focused();
    }

    @Test(description = "Test checks extended fab buttons attributes")
    public void extendedFabButtonsTest() {
        Button extendedFabButton = extendedFabButtons.get(rand.nextInt(extendedFabButtons.size()) + 1);
        extendedFabButton.show();
        extendedFabButton.shouldBe().visible();

        extendedFabButton.has().visualType(EXTENDED_FAB);
    }

    @Test(description = "Test checks fab buttons attributes")
    public void fabButtonsTest() {
        Button fabButton = fabButtons.get(rand.nextInt(fabButtons.size()) + 1);
        fabButton.shouldBe().displayed();
        fabButton.show();
        fabButton.shouldBe().visible();

        fabButton.has().visualType(FAB);
    }

    @Test(description = "Test checks flat buttons attributes")
    public void flatButtonsTest() {
        Button flatButton = flatButtons.get(rand.nextInt(flatButtons.size()) + 1);
        flatButton.shouldBe().displayed();
        flatButton.show();
        flatButton.shouldBe().visible();

        flatButton.has().visualType(FLAT);
    }

    @Test(description = "Test checks icon buttons attributes")
    public void iconButtonsTest() {
        Button iconButton = iconButtons.get(rand.nextInt(iconButtons.size()) + 1);
        iconButton.shouldBe().displayed();
        iconButton.show();
        iconButton.shouldBe().visible()
                .and().visualType(ICON)
                .and().hasIcon();
    }

    @Test(description = "Test checks mini fab buttons attributes")
    public void miniFabButtonsTest() {
        Button miniFabButton = miniFabButtons.get(rand.nextInt(miniFabButtons.size()) + 1);
        miniFabButton.shouldBe().displayed();
        miniFabButton.show();
        miniFabButton.shouldBe().visible();

        miniFabButton.has().visualType(MINI_FAB);
    }

    @Test(description = "Test checks raised buttons attributes")
    public void raisedButtonsTest() {
        Button raisedButton = raisedButtons.get(rand.nextInt(raisedButtons.size()) + 1);
        raisedButton.shouldBe().displayed();
        raisedButton.show();
        raisedButton.shouldBe().visible();

        raisedButton.has().visualType(RAISED);
    }

    @Test(description = "Test checks stroked buttons attributes")
    public void strokedButtonsTest() {
        Button strokedButton = strokedButtons.get(rand.nextInt(strokedButtons.size()) + 1);
        strokedButton.shouldBe().displayed();
        strokedButton.show();
        strokedButton.shouldBe().visible();

        strokedButton.has().visualType(STROKED);
    }

    @Test(description = "Check buttons colors")
    public void colorButtonsTest() {
        primaryColorButtons.get(rand.nextInt(primaryColorButtons.size()) + 1)
                .has().color(AngularColors.PRIMARY);
        accentColorButtons.get(rand.nextInt(accentColorButtons.size()) + 1)
                .has().color(AngularColors.ACCENT);
        warnColorButtons.get(rand.nextInt(warnColorButtons.size()) + 1)
                .has().color(AngularColors.WARN);
    }
}
