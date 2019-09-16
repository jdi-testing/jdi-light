package com.epam.jdi.light.ui.bootstrap.elements.complex;

import static com.epam.jdi.light.common.TextTypes.TEXT;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.settings.WebSettings;

import static com.epam.jdi.light.settings.WebSettings.ANY_ELEMENT;

public class Carousel extends UIListBase<UISelectAssert> {
	public String getText() { return text(TEXT); }
	
	public String nextLocator = ".carousel-control-next";
	
	public UIElement nextControl() {
        return linked(nextLocator, "next");
    }
	
	public void nextSlide() {
		nextControl().click();
	}
	
	public String prevLocator = ".carousel-control-prev";
    
	public UIElement prevControl() {
        return linked(prevLocator, "next");
    }
	
	public void prevSlide() {
		prevControl().click();
	}
	
	public String innerLocator = "div";
	public String listLocator = "//div[contains(@class,'carousel-item')]";
		
    @Override
    public WebList list() {
    	WebSettings.SEARCH_RULES = ANY_ELEMENT;
        return linkedList(listLocator, "slidesList").setUIElementName(TEXT);
    }
	
}
