package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBarAssert, ToolBar> {
	@JDIAction("Assert that '{name}' has background image")
	public ToolBarAssert backgroundImage() {
		jdiAssert(element().hasBackgroundImage(), Matchers.is(true), "Element has not background image");
		return this;
	}

	@JDIAction("Assert that '{name}' has not background image")
	public ToolBarAssert notBackgroundImage() {
		jdiAssert(element().hasBackgroundImage(), Matchers.is(false), "Element has background image");
		return this;
	}
}
