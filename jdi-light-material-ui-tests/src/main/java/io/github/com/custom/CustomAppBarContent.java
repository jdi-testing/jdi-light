package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class CustomAppBarContent extends UIElement {
    public CustomAppBarContent(UIElement root) {
        setCore(CustomAppBarContent.class, root.base());
    }

    public Typography title() {
        return new Typography().setCore(Typography.class, core().find(".MuiTypography-root"));
    }

    public TextField searchField() {
        return new TextField().setCore(TextField.class, core().find("//input[@aria-label='search']"));
    }
}
