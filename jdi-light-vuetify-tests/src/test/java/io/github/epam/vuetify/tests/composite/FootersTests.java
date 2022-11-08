package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Year;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.footersPage;
import static io.github.com.pages.FootersPage.companyFooter;
import static io.github.com.pages.FootersPage.indigoFooter;
import static io.github.com.pages.FootersPage.padlessFooter;
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

    @Test
    public void padlessFooterTest() {
        padlessFooter.is().displayed();
        padlessFooter.has().text(containsString(expectedVuetifyText));

        padlessFooter.has().cssClass("v-footer--padless");
    }

    @Test
    public void companyFooterTest() {
        companyFooter.is().displayed();
        companyFooter.footerText().has().text(containsString(expectedVuetifyText));

        companyFooter.navigationButtons().stream()
                .peek(button -> button.is().displayed())
                .forEach(HasClick::click);
    }

    @Test
    public void indigoFooterTest() {
        indigoFooter.is().displayed();
        // footer itself does not have indigo color but inner container has
        indigoFooter.firstChild().has().css("background-color", Colors.INDIGO_LIGHTEN_1.value());

        indigoFooter.footerText().has().text(containsString(expectedVuetifyText));
        indigoFooter.divider().is().darkTheme();
        indigoFooter.descriptionText().has().text(containsString("Phasellus feugiat arcu sapien"));

        indigoFooter.socialButtons().forEach(HasClick::click);
    }

    @Test @Ignore
    public void tealFooterTest() {
        tealFooter.is().displayed();
        tealFooter.subheading().has().text(containsString("Get connected with us on social networks!"));
        tealFooter.footerText().has().text(containsString(expectedVuetifyText));

        tealFooter.socialButtons().forEach(HasClick::click);
    }

}
