package selenium.site.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.table.FastTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import org.openqa.selenium.WebElement;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    public static FastTable usersTable;

    public static Selector userNames;

    public static UIElement textareaPerformance;
}
