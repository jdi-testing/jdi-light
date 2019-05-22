package pseudo.site;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import pseudo.site.pages.Header;
import pseudo.site.section.ExtendedSection;
import pseudo.site.section.CustomSection;

public class PseudoSite {
    public static Header pseudoHeader;
    @UI(".customSectionUI")
    public static CustomSection customSectionUI;
    public static CustomSection customSection;
    @UI(".extendedSectionUI")
    public static ExtendedSection extendedSectionUI;
    public static ExtendedSection extendedSection;
}
