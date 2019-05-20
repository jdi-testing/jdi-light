package pseudo.site.dataproviders.WebPage;

import org.testng.annotations.DataProvider;
import pseudo.site.pages.PageWithBoth;
import pseudo.site.pages.PageWithTitle;
import pseudo.site.pages.PageWithURL;
import pseudo.site.pages.PageWithoutBoth;

public class WebPageDataProvider {

    @DataProvider
    public Object[][] annotationsWebPageDataProvider() {
        return new Object[][]{
            {new PageWithBoth(), "www.pagewithboth.com","Page with both"},
            {new PageWithTitle(), "","Page with title"},
            {new PageWithURL(), "www.pagewithurl.com",""},
            {new PageWithoutBoth(), "",""}
        };
    }

    @DataProvider
    public Object[][] actionsWebPageDataProvider() {
        return new Object[][]{

        };
    }
}