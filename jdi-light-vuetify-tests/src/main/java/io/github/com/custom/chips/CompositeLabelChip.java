package io.github.com.custom.chips;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.custom.asserts.CompositeLabelChipAssert;

import java.util.List;
import java.util.stream.Collectors;

public class CompositeLabelChip extends Chip {
	private static final String ALL_TEXTS_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/*[text()]";
	private static final String BOLD_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/strong";
	private static final String REGULAR_TEXT_FROM_COMPOSITE_LABEL = "//span[@class='v-chip__content']/span";

	@Override
	public CompositeLabelChipAssert is() {
		return (CompositeLabelChipAssert) new CompositeLabelChipAssert().set(this);
	}

	@JDIAction("Get bold text from '{name}' composite label")
	public String boldTextFromCompositeLabel() {
		return find(BOLD_TEXT_FROM_COMPOSITE_LABEL).getText();
	}

	@JDIAction("Get bold text from '{name}' composite label")
	public String regularTextFromCompositeLabel() {
		return find(REGULAR_TEXT_FROM_COMPOSITE_LABEL).getText();
	}

	@JDIAction("Get all the text from '{name}' composite label")
	public List<String> compositeLabel() {
		return finds(ALL_TEXTS_FROM_COMPOSITE_LABEL).stream()
				.map(e -> e.getText())
				.collect(Collectors.toList());
	}

	@JDIAction("Get all the text from '{name}' composite label")
	public String getFullTextFromCompositeLabel() {
		String[] compositeLabel = compositeLabel().toArray(new String[0]);
		return String.join(" ", compositeLabel);
	}
}
