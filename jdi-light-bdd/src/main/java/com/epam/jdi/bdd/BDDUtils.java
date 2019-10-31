package com.epam.jdi.bdd;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.CommonAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.tools.map.MapArray;
import cucumber.api.DataTable;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public final class BDDUtils {
    private BDDUtils() { }

    public static MapArray<String, String> getMapFromTable(DataTable table) {
		return new MapArray<>(table.getGherkinRows(),
				r -> r.getCells().get(0), r -> r.getCells().get(1));
	}

    public static UIElement core(String name) {
		return getUI(name).core();
	}
	public static IsAssert isAssert(String name) {
		return getUI(name).core().is();
	}
	public static SelectedAssert selectedAssert(String name) {
		return ((HasAssert<SelectedAssert>)getAssert(name)).is();
	}
	public static CommonAssert uiAssert(String name) {
		return ((HasAssert<CommonAssert>)getAssert(name)).is();
	}
	public static UISelectAssert selectAssert(String name) {
		return ((HasAssert<UISelectAssert>)getAssert(name)).is();
	}
	private static HasAssert getAssert(String name) {
		return getUI(name, HasAssert.class);
	}
	public static IsInput input(String name) {
		return getUI(name, IsInput.class);
	}
	public static Label label(String name) {
		return getUI(name, HasLabel.class).label();
	}
    public static ITextAssert textAssert(String name) {
		return (ITextAssert)getUI(name, HasAssert.class).is();
	}
}
