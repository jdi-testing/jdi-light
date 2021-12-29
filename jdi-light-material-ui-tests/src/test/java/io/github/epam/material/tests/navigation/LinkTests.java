package io.github.epam.material.tests.navigation;

import static io.github.com.StaticSite.linkPage;
import static io.github.com.pages.navigation.LinkPage.body2Link;
import static io.github.com.pages.navigation.LinkPage.inheritColorLink;
import static io.github.com.pages.navigation.LinkPage.link;
import static io.github.com.pages.navigation.LinkPage.underlinedLink;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.material.elements.utils.enums.TypographyStyles;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        linkPage.open();
        linkPage.isOpened();
    }

    @Test
    public void defaultLinkTest() {
        link.is().displayed().and().enabled()
                .and().has().text("Link");

        link.has().cssClass("MuiLink-underlineHover");
        link.hover();
        link.is().underlined();

        inheritColorLink.hover();
        link.is().notUnderlined();

        link.click();
    }

    @Test
    public void colorInheritLinkTest() {
        inheritColorLink.is().displayed().and().enabled()
                .and().has().text(containsString("inherit"));

        inheritColorLink.has().cssClass("MuiTypography-colorInherit");
        inheritColorLink.has().color("rgba(0, 0, 0, 0.87)");

        inheritColorLink.click();
    }

    @Test
    public void body2LinkTest() {
        body2Link.is().displayed().and().enabled()
                .and().has().text(containsString("body2"));

        body2Link.has().cssClass("MuiTypography-body2")
                .and().style(TypographyStyles.BODY_2);

        body2Link.has().cssClass("MuiTypography-colorPrimary");
        body2Link.has().color(Colors.PRIMARY.rgba());

        body2Link.click();
    }

    @Test
    public void underlineAlwaysLinkTest() {
        underlinedLink.is().displayed().and().enabled()
                .and().has().text("Underlined link4");

        underlinedLink.has().cssClass("MuiLink-underlineAlways");
        body2Link.hover();
        underlinedLink.is().underlined();

        underlinedLink.click();
    }
}
