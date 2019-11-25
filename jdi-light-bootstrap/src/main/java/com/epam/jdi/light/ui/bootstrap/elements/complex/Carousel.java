package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.TEXT;

/**
 * To see an example of Carousel web element please visit https://getbootstrap.com/docs/4.3/components/carousel/#example
 */

public class Carousel extends UIBaseElement<TextAssert> implements IsText, IsButton {
	public String currentSlideLocator = "//div[contains(@class,'carousel-item active')]";
	public String nextLocator = ".carousel-control-next";
	public String prevLocator = ".carousel-control-prev";
	public String indicatorsLocator = "li";

	public String getText() {
		return text(TEXT);
	}

	@JDIAction("Get current slide in '{name}'")
	public UIElement currentSlide() {
		return linked(currentSlideLocator, "current");
	}

	public UIElement nextControl() {
		return linked(nextLocator, "next");
	}

	@JDIAction("Click 'next control' in '{name}'")
	public void next() {
		nextControl().click();
	}

	public UIElement prevControl() {
		return linked(prevLocator, "prev");
	}

	@JDIAction("Click 'prev control' in '{name}'")
	public void prev() {
		prevControl().click();
	}

	public WebList indicators() {
		return linkedList(indicatorsLocator, "indicators");
	}

	public void select(int index) {
		if (index < 1)
			throw exception("Can't select element with index '%s'. Index should be 1 or more", index);
		indicators().select(index);
	}
	
	public UIElement get(int index) {
		if (index < 1)
			throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
		return indicators().get(index);
	}

	@JDIAction("Current slide interval in '{name}'")
	public int interval() {
		return Integer.valueOf(currentSlide().getAttribute("data-interval"));
	}

	@Override
	public TextAssert is() {
		return new TextAssert().set(this);
	}
}
