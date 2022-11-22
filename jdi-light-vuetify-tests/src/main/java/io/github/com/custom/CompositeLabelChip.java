package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.custom.asserts.CompositeLabelChipAssert;

import java.util.List;

public class CompositeLabelChip extends Chip {
	private static final String ALL_TEXTS_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/*[text()]";
	private static final String BOLD_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/strong";
	private static final String REGULAR_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/span";

	@Override
	public CompositeLabelChipAssert is() {
		return (CompositeLabelChipAssert) new CompositeLabelChipAssert().set(this);
	}

	@JDIAction("Get bold text from '{name}' composite label")
	public String getBoldTextFromCompositeLabel() {
		return find(BOLD_TEXT_FROM_COMPOSITE_LABEL).getText();
	}

	@JDIAction("Get bold text from '{name}' composite label")
	public String getRegularTextFromCompositeLabel() {
		return find(REGULAR_TEXT_FROM_COMPOSITE_LABEL).getText();
	}

	@JDIAction("Get all the text from '{name}' composite label")
	public String getFullTextFromCompositeLabel() {
		StringBuilder result = new StringBuilder();
		List<UIElement> labelParts = finds(ALL_TEXTS_FROM_COMPOSITE_LABEL);
		for (int i = 1; i <= labelParts.size(); i++) {
			result.append(labelParts.get(i).getText());
			result.append(" ");
		}
		return result.toString().trim();
	}
}
