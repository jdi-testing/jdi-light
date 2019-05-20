package pseudo.site.dataproviders.WebPage;

import com.epam.jdi.light.elements.composite.WebPage;
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
                {new PageWithoutBoth(), "",""},
                {new PageWithTitle(), "","Page with title"},
                {new PageWithURL(), "www.pagewithurl.com",""}
        };
    }
}