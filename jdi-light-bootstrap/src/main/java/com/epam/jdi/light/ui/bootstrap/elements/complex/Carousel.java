package com.epam.jdi.light.ui.bootstrap.elements.complex;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.*;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.settings.WebSettings;

import static com.epam.jdi.light.settings.WebSettings.*;

public class Carousel extends UIListBase<UISelectAssert> {
	public String getText() { return currentSlide().text(TEXT); }
	
    public String currentSlideLocator = "//div[contains(@class,'carousel-item active')]";
	
	public UIElement currentSlide() {
        return linked(currentSlideLocator, "current");
    }
	
	public String nextLocator = ".carousel-control-next";
	
	public UIElement nextControl() {
        return linked(nextLocator, "next");
    }
	
	public void nextSlide() {
		nextControl().click();
	}
	
	public String prevLocator = ".carousel-control-prev";
    
	public UIElement prevControl() {
        return linked(prevLocator, "prev");
    }
	
	public void prevSlide() {
		prevControl().click();
	}
	
	public String indicatorsLocator = "li";
		
    @Override
    public WebList list() {
        return linkedList(indicatorsLocator, "slidesList").setUIElementName(TEXT);
    }
	
    @Override
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        list().select(index - 1);
    }
    
    public String selected() {
        return list().selected();
    }
    
    public int getInterval() {
    	return Integer.valueOf(currentSlide().getAttribute("data-interval"));
    }
}
