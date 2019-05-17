package pseudo.site.dataproviders.WebPage;

import com.epam.jdi.light.elements.composite.WebPage;
import org.testng.annotations.DataProvider;
import pseudo.site.pages.PageWithBoth;
import pseudo.site.pages.PageWithTitle;
import pseudo.site.pages.PageWithURL;
import pseudo.site.pages.PageWithoutBoth;

public class WebPageDataProvider {

    private WebPage pageWithBoth;
    private WebPage pageWithoutBoth;
    private WebPage pageWithURL;
    private WebPage pageWithTitle;

    @DataProvider
    public Object[][] annotationsWebPageDataProvider() {
        return new Object[][]{
                {pageWithBoth = new PageWithBoth(), "www.pagewithboth.com","Page with both"},
                {pageWithoutBoth = new PageWithoutBoth(), "",""},
                {pageWithTitle = new PageWithTitle(), "","Page with title"},
                {pageWithURL = new PageWithURL(), "www.pagewithurl.com",""}
        };
    }
}