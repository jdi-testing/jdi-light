package pseudo.site.dataproviders.WebPage;

import org.testng.annotations.DataProvider;
import static pseudo.site.PseudoSite.*;

public class WebPageDataProvider {

    @DataProvider
    public Object[][] annotationsWebPageDataProvider() {
        return new Object[][]{
            {pageWithBoth, "https://epam.github.io/JDI/pagewithboth.com","Page with both"},
            {pageWithTitle, "https://epam.github.io/JDI/","Page with Title"},
            {pageWithURL, "https://epam.github.io/JDI/pagewithurl.com",""},
            {slashPageWithURL, "https://epam.github.io/JDI/pagewithurl.com",""},
            {pageWithoutBoth, "https://epam.github.io/JDI/",""}
        };
    }
}