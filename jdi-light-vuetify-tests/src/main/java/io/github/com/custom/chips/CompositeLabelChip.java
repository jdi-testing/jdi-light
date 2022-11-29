package io.github.com.custom.chips;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.complex.Text;
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
	public Text boldTextFromCompositeLabel() {
		return new Text().setCore(Text.class, find(BOLD_TEXT_FROM_COMPOSITE_LABEL));
	}

	@JDIAction("Get bold text from '{name}' composite label")
	public Text regularTextFromCompositeLabel() {
		return new Text().setCore(Text.class, find(REGULAR_TEXT_FROM_COMPOSITE_LABEL));
	}

	@JDIAction("Get all the text from '{name}' composite label")
	public List<Text> compositeLabel() {
		return finds(ALL_TEXTS_FROM_COMPOSITE_LABEL).stream()
				.map(e -> new Text().setCore(Text.class, e))
				.collect(Collectors.toList());
	}

	@JDIAction("Get all the text from '{name}' composite label")
	public String getFullTextFromCompositeLabel() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= compositeLabel().size() - 1; i++) {
			result.append(compositeLabel().get(i).getText());
			result.append(" ");
		}
		return result.toString().trim();
	}
}
