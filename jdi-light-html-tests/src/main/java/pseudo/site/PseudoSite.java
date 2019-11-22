package pseudo.site;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import pseudo.site.pages.Header;
import pseudo.site.pages.PageNotExtendWebPageWithBoth;
import pseudo.site.pages.PageNotExtendWebPageWithoutBoth;
import pseudo.site.pages.PageWithBoth;
import pseudo.site.pages.PageWithTitle;
import pseudo.site.pages.PageWithURL;
import pseudo.site.pages.PageWithoutBoth;
import pseudo.site.section.CustomSection;
import pseudo.site.section.ExtendedSection;
import pseudo.site.webpage.CustomWebPage;
import pseudo.site.webpage.ExtendedWebPage;

@SuppressWarnings("PMD.ClassNamingConventions")
public class PseudoSite {
    public static Header pseudoHeader;
    @UI(".customSectionUI")
    public static CustomSection customSectionUI;
    public static CustomSection customSection;
    @UI(".extendedSectionUI")
    public static ExtendedSection extendedSectionUI;
    public static ExtendedSection extendedSection;

    @UI(".customWebPageUI")
    public static CustomWebPage customWebPageUI;
    public static CustomWebPage customWebPage;
    @UI(".extendedWebPageUI")
    public static ExtendedWebPage extendedWebPageUI;
    public static ExtendedWebPage extendedWebPage;

    @Url("pagewithurl.com")
    public static PageWithURL pageWithURL;

    @Url("/pagewithurl.com")
    public static PageWithURL slashPageWithURL;

    @Title("Page with Title")
    public static PageWithTitle pageWithTitle;

    @Url("pagewithboth.com") @Title("Page with both")
    public static PageWithBoth pageWithBoth;

    public static PageWithoutBoth pageWithoutBoth;

    @Url("notextendwebpagewithboth.com") @Title("Page not extend web page with both")
    public static PageNotExtendWebPageWithBoth pageNotExtendWebPageWithBoth;

    public static PageNotExtendWebPageWithoutBoth pageNotExtendWebPageWithoutBoth;
}
