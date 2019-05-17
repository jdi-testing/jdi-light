package pseudo.site.dataproviders.WebPage;

import com.epam.jdi.light.elements.composite.WebPage;
import org.testng.annotations.DataProvider;
import pseudo.site.pages.PageWithBoth;
import pseudo.site.pages.PageWithTitle;
import pseudo.site.pages.PageWithURL;
import pseudo.site.pages.PageWithoutBoth;

public class WebPageDataProvider {

    private WebPage pageWithBoth = new PageWithBoth();
    private WebPage pageWithoutBoth = new PageWithoutBoth();
    private WebPage pageWithURL = new PageWithURL();
    private WebPage pageWithTitle = new PageWithTitle();

    @DataProvider
    public Object[][] annotationsWebPageDataProvider() {
        return new Object[][]{
                {pageWithBoth, "www.pagewithboth.com","Page with both"},
                {pageWithoutBoth, "",""},
                {pageWithTitle, "","Page with both"},
                {pageWithURL, "www.pagewithboth.com",""}
        };
    }
}