package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class PopperDataProvider {

    @DataProvider
    public Object[][] positionedPopperDataProvider() {
        return new Object[][] {
            {1, "TOP", Position.TOP},
            {2, "LEFT", Position.LEFT},
            {3, "RIGHT", Position.RIGHT},
            {4, "BOTTOM", Position.BOTTOM}
        };
    }
}
