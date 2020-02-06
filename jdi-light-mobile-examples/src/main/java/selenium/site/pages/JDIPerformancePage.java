package selenium.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    public static Table usersTable;

    public static Selector userNames;

    public static UIElement textareaPerformance;
}
