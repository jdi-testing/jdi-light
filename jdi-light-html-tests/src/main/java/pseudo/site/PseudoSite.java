package pseudo.site;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import pseudo.site.pages.Header;
import pseudo.site.section.*;

public class PseudoSite {
    public static Header pseudoHeader;
    @UI(".someSectionUI")
    public static SomeSection someSectionUI;
    public static SomeSection someSection;
    @UI(".extendedSectionUI")
    public static ExtendedSection extendedSectionUI;
    public static ExtendedSection extendedSection;
}
