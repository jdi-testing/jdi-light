package io.github.com.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import java.util.List;


public class Breadcrumb extends Section {//implements HasValue, HasClick, IsText {
    @Css(".breadcrumb-item a")
    public WebList itemsList;
    @Css(".breadcrumb-item.active")
    public Button currentItem;
}
