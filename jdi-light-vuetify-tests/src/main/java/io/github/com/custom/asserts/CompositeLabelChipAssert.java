package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.CompositeLabelChip;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CompositeLabelChipAssert extends UIAssert<CompositeLabelChipAssert, CompositeLabelChip>
		implements ITextAssert {
	@Override
	@JDIAction("Assert that '{name}' composite label contains text '{0}'")
	public CompositeLabelChipAssert text(Matcher condition) {
		String actualText = element().getFullTextFromCompositeLabel();
		jdiAssert(actualText, condition, String.format("Actual label text '%s' doesn't contain " +
				"expected text '%s'", actualText, condition));
		return this;
	}

	@JDIAction("Assert that bold text from '{name}' composite label contains text '{0}'")
	public CompositeLabelChipAssert containsBoldText(String text) {
		String actualText = element().getBoldTextFromCompositeLabel();
		jdiAssert(actualText, Matchers.containsString(text), String.format("Actual bold label text '%s' doesn't " +
				"contain expected text '%s'", actualText, text));
		return this;
	}

	@JDIAction("Assert that regular text from '{name}' composite label contains text '{0}'")
	public CompositeLabelChipAssert containsRegularText(String text) {
		String actualText = element().getRegularTextFromCompositeLabel();
		jdiAssert(actualText, Matchers.containsString(text), String.format("Actual regular label text '%s' doesn't " +
				"contain expected text '%s'", actualText, text));
		return this;
	}
}
