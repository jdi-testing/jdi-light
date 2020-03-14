package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.lang.reflect.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.UIUtils.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.ReflectionUtils.*;

/**
 * To see an example of Carousel web element please visit https://getbootstrap.com/docs/4.3/components/carousel/#example
 */

public class Carousel<T extends ICoreElement, D> extends UIBaseElement<TextAssert>
		implements HasValue, IsText, ISetup {
	protected String nextLocator = ".carousel-control-next";
	protected String prevLocator = ".carousel-control-prev";
	protected String indicatorsLocator = "li[data-slide-to]";

	@UI(".carousel-item") @GetAny public DataList<T, D> slides;
	@UI(".carousel-item") @VisualCheck UIElement activeSlide;

	public T activeSlide() {
		return toT(activeSlide);
	}
	protected T toT(UIElement el) {
		return initT(el, this, slides.initClass);
	}
	public D activeSlideData() {
		return asEntity(activeSlide(), slides.dataType);
	}

	@JDIAction("Open next slide '{name}'")
	public void next() {
		linked(nextLocator, "next").click();
	}
	@JDIAction("Open previous slide '{name}'")
	public void previous() {
		linked(prevLocator, "previous").click();
	}
	private WebList indicators() {
		return linkedList(indicatorsLocator, "indicators");
	}
	@JDIAction("Open slide '{0}'")
	public void openSlide(String name) {
		int index = slides.elements(1).getIndex(name);
		if (index < 0)
			throw exception("Can't find slide with name '%s'", name);
		openSlide(index + 1);
	}
	@JDIAction("Open slide '{0}'")
	public void openSlide(int index) {
		indicators().select(index);
	}
	@Override @JDIAction(level = DEBUG)
	public void show() {
		activeSlide.show();
	}

	@JDIAction("Get '{name}' text")
	public String getText() {
		return getText(activeSlide());
	}
	private String getText(T slide) {
		if (isClass(slides.initClass, IsText.class))
			return ((IsText)slide).getText();
		if (isClass(slides.initClass, HasValue.class))
			return ((HasValue)slide).getValue();
		return slide.core().getText();
	}

	public String getValue() {
		return getText();
	}

	public void setup(Field field) {
		try {
			Type[] types = getGenericTypes(field);
			if (types.length == 0)
				throw exception("Can't setup Carousel generic parameters for field '%s'. Actual 0 but expected 1 or 2",
						field.getName());
			if (types.length > 2)
				throw exception("Can't setup Carousel generic parameters for field '%s'. Actual more than %s but expected 1 or 2",
						field.getName(), types.length);
			slides.initClass = types[0].toString().equals("?") ? null : (Class<T>)types[0];
			slides.dataType = types.length == 1 || types[1].toString().equals("?") ? null : (Class<D>)types[1];
		} catch (Exception ignore) { }
	}
	@Override
	public TextAssert is() { return new TextAssert().set(this); }
}
