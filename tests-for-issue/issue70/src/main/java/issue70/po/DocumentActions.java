package issue70.po;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.By;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;

public class DocumentActions extends HtmlElement {
    private Button documentActionsBtn = $(new By.ByCssSelector(".document-actions-btn"), this);
    private WebList actions = new WebList(new By.ByCssSelector(".%s-btn"));

    @Override
    public void select(String name) {
        documentActionsBtn.click();
        actions.select(name);
    }
}