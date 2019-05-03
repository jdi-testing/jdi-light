package issue70.po;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;

public class DashboardItem extends Section {
    @UI(".document-actions")
    public DocumentActions menu;
}
