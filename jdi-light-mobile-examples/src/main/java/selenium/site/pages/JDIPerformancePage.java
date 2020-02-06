package selenium.site.pages;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.complex.Selector;
import com.epam.jdi.mobile.elements.complex.table.Table;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    public static Table usersTable;

    public static Selector userNames;

    public static UIElement textareaPerformance;
}
