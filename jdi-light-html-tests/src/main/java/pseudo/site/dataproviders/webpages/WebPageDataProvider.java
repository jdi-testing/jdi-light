package pseudo.site.dataproviders.webpages;

import org.testng.annotations.DataProvider;

import static pseudo.site.PseudoSiteUtils.pageWithBoth;
import static pseudo.site.PseudoSiteUtils.pageWithTitle;
import static pseudo.site.PseudoSiteUtils.pageWithURL;
import static pseudo.site.PseudoSiteUtils.pageWithoutBoth;
import static pseudo.site.PseudoSiteUtils.slashPageWithURL;

public class WebPageDataProvider {

    @DataProvider
    public Object[][] annotationsWebPageDataProvider() {
        return new Object[][]{
            { pageWithBoth, "https://jdi-testing.github.io/jdi-light/pagewithboth.com","Page with both"},
            { pageWithTitle, "https://jdi-testing.github.io/jdi-light/","Page with Title"},
            { pageWithURL, "https://jdi-testing.github.io/jdi-light/pagewithurl.com",""},
            { slashPageWithURL, "https://jdi-testing.github.io/jdi-light/pagewithurl.com",""},
            { pageWithoutBoth, "https://jdi-testing.github.io/jdi-light/",""}
        };
    }
}