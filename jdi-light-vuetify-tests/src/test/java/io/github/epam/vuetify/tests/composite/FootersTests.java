package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Year;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.footersPage;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.FootersPage.absoluteFooter;
import static io.github.com.pages.FootersPage.companyFooter;
import static io.github.com.pages.FootersPage.fixedFooter;
import static io.github.com.pages.FootersPage.indigoFooter;
import static io.github.com.pages.FootersPage.padlessFooter;
import static io.github.com.pages.FootersPage.shapedFooter;
import static io.github.com.pages.FootersPage.tealFooter;
import static org.hamcrest.Matchers.containsString;

public class FootersTests extends TestsInit {

    private String expectedVuetifyText = Year.now().getValue() + " — Vuetify";

    @BeforeClass
    public void before() {
        footersPage.open();
        waitCondition(() -> footersPage.isOpened());
        footersPage.checkOpened();
    }

    @Test(description = "Test checks that footer contains text")
    public void containsTextFooterTest() {
        padlessFooter.show();
        padlessFooter.is().displayed();
        padlessFooter.has().text(containsString(expectedVuetifyText));
    }

    @Test(description = "Test checks if footer is padless or not")
    public void padlessFooterTest() {
        padlessFooter.show();
        padlessFooter.is().padless();
        shapedFooter.show();
        shapedFooter.is().notPadless();
    }

    @Test(description = "Test checks custom element company footer")
    public void companyFooterTest() {
        companyFooter.show();
        companyFooter.footerText().has().text(containsString(expectedVuetifyText));
        companyFooter.navigationButtons().stream()
                .peek(button -> button.is().displayed())
                .forEach(HasClick::click);
    }

    @Test(description = "Test checks custom element indigo footer")
    public void indigoFooterTest() {
        indigoFooter.show();
        // footer itself does not have indigo color but inner container has
        indigoFooter.firstChild().has().css("background-color", Colors.INDIGO_LIGHTEN_1.value());
        indigoFooter.footerText().has().text(containsString(expectedVuetifyText));
        indigoFooter.divider().has().darkTheme();
        indigoFooter.descriptionText().has().text(containsString("Phasellus feugiat arcu sapien"));
        indigoFooter.socialButtons().forEach(HasClick::click);
    }

    @Test(description = "Test checks custom element teal footer")
    public void tealFooterTest() {
        tealFooter.show();
        tealFooter.subheading().has().text(containsString("Get connected with us on social networks!"));
        tealFooter.footerText().has().text(containsString(expectedVuetifyText));
        tealFooter.socialButtons().forEach(HasClick::click);
    }

    @Test(description = "Test checks footer's color")
    public void colorFooterTest() {
        fixedFooter.show();
        fixedFooter.has().backgroundColor(BLUE.value()).and().color(WHITE.value());
        fixedFooter.has().darkTheme();
        shapedFooter.has().lightTheme();
    }

    @Test(description = "Test checks if footer is absolute")
    public void absoluteFooterTest() {
        absoluteFooter.show();
        absoluteFooter.is().absolute();
        shapedFooter.show();
        shapedFooter.has().notAbsolute();
    }

    @Test(description = "Test checks if footer has fixed or not")
    public void fixedFooterTest() {
        fixedFooter.show();
        fixedFooter.is().fixed();
        shapedFooter.show();
        shapedFooter.is().notFixed();
    }

    @Test(description = "Test checks footer's measurements")
    public void measurementsFooterTest() {
        absoluteFooter.show();
        absoluteFooter.has().maxHeight(60);
        absoluteFooter.has().minHeight(40);
        absoluteFooter.has().maxWidth(1200);
        absoluteFooter.has().minWidth(800);
    }

    @Test(description = "Test checks if footer has outlined or not")
    public void outlinedFooterTest() {
        shapedFooter.show();
        shapedFooter.is().outlined();
        fixedFooter.show();
        fixedFooter.is().notOutlined();
    }

    @Test(description = "Test checks if footer is rounded or not")
    public void roundedFooterTest() {
        absoluteFooter.show();
        absoluteFooter.is().rounded();
        shapedFooter.show();
        shapedFooter.is().notRounded();
    }

    @Test(description = "Test checks if footer is shaped or not")
    public void shapedFooterTest() {
        shapedFooter.show();
        shapedFooter.is().shaped();
        fixedFooter.show();
        fixedFooter.is().notShaped();
    }

    @Test(description = "Test checks if footer is tile or not")
    public void tileFooterTest() {
        absoluteFooter.show();
        absoluteFooter.is().tile();
        shapedFooter.show();
        shapedFooter.is().notTile();
    }
}
