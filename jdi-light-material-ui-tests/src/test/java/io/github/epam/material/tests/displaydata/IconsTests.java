package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.displaydata.IconsPage.*;

/**
 * To see an example of Icons web element please visit https://material-ui.com/components/icons/
 */

public class IconsTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Icons");
    }

    private void lastClickHoverTextsIs(Text lastClick, Text lastHover, List<String> txt) {
        lastClick.is().text(String.format("Last click:%s", txt.get(0)));
        lastHover.is().text(String.format("Last hover:%s", txt.get(1)));
    }

    @Test
    public void simpleIconsTest() {
        filled.forEach(el -> el.is().displayed());
        outlined.forEach(el -> el.is().displayed());
        rounded.forEach(el -> el.is().displayed());
        twoTone.forEach(el -> el.is().displayed());
        sharp.forEach(el -> el.is().displayed());
        edgeCase.forEach(el -> el.is().displayed());
        lastClickHoverTextsIs(simpleLastClick, simpleLastHover, Arrays.asList("", ""));

        Map<UIElement, List<List<String>>> allSimpleIcons = new LinkedHashMap<>();
        allSimpleIcons.put(filled.get(1), Arrays.asList(Arrays.asList("", " DeleteIcon"), Arrays.asList(" DeleteIcon", " DeleteIcon")));
        allSimpleIcons.put(filled.get(2), Arrays.asList(Arrays.asList(" DeleteIcon", " DeleteForeverIcon"), Arrays.asList(" DeleteForeverIcon", " DeleteForeverIcon")));
        allSimpleIcons.put(outlined.get(1), Arrays.asList(Arrays.asList(" DeleteForeverIcon", " DeleteOutlinedIcon"), Arrays.asList(" DeleteOutlinedIcon", " DeleteOutlinedIcon")));
        allSimpleIcons.put(outlined.get(2), Arrays.asList(Arrays.asList(" DeleteOutlinedIcon", " DeleteForeverOutlinedIcon"), Arrays.asList(" DeleteForeverOutlinedIcon", " DeleteForeverOutlinedIcon")));
        allSimpleIcons.put(rounded.get(1), Arrays.asList(Arrays.asList(" DeleteForeverOutlinedIcon", " DeleteRoundedIcon"), Arrays.asList(" DeleteRoundedIcon", " DeleteRoundedIcon")));
        allSimpleIcons.put(rounded.get(2), Arrays.asList(Arrays.asList(" DeleteRoundedIcon", " DeleteForeverRoundedIcon"), Arrays.asList(" DeleteForeverRoundedIcon", " DeleteForeverRoundedIcon")));
        allSimpleIcons.put(twoTone.get(1), Arrays.asList(Arrays.asList(" DeleteForeverRoundedIcon", " DeleteTwoToneIcon"), Arrays.asList(" DeleteTwoToneIcon", " DeleteTwoToneIcon")));
        allSimpleIcons.put(twoTone.get(2), Arrays.asList(Arrays.asList(" DeleteTwoToneIcon", " DeleteForeverTwoToneIcon"), Arrays.asList(" DeleteForeverTwoToneIcon", " DeleteForeverTwoToneIcon")));
        allSimpleIcons.put(sharp.get(1), Arrays.asList(Arrays.asList(" DeleteForeverTwoToneIcon", " DeleteSharpIcon"), Arrays.asList(" DeleteSharpIcon", " DeleteSharpIcon")));
        allSimpleIcons.put(sharp.get(2), Arrays.asList(Arrays.asList(" DeleteSharpIcon", " DeleteForeverSharpIcon"), Arrays.asList(" DeleteForeverSharpIcon", " DeleteForeverSharpIcon")));
        allSimpleIcons.put(edgeCase.get(1), Arrays.asList(Arrays.asList(" DeleteForeverSharpIcon", " ThreeDRotationIcon"), Arrays.asList(" ThreeDRotationIcon", " ThreeDRotationIcon")));
        allSimpleIcons.put(edgeCase.get(2), Arrays.asList(Arrays.asList(" ThreeDRotationIcon", " FourKIcon"), Arrays.asList(" FourKIcon", " FourKIcon")));
        allSimpleIcons.put(edgeCase.get(3), Arrays.asList(Arrays.asList(" FourKIcon", " ThreeSixtyIcon"), Arrays.asList(" ThreeSixtyIcon", " ThreeSixtyIcon")));

        allSimpleIcons.forEach(
                (k, v) -> {
                    k.hover();
                    lastClickHoverTextsIs(simpleLastClick, simpleLastHover, v.get(0));
                    k.click();
                    lastClickHoverTextsIs(simpleLastClick, simpleLastHover, v.get(1));
                }
        );
    }

    @Test
    public void colorIconsTest() {
        color.forEach(el -> el.is().displayed());
        lastClickHoverTextsIs(colorLastClick, colorLastHover, Arrays.asList("", ""));

        Map<UIElement, List<List<String>>> allColorIcons = new LinkedHashMap<>();
        allColorIcons.put(color.get(1), Arrays.asList(Arrays.asList("", " default"), Arrays.asList(" default", " default")));
        allColorIcons.put(color.get(2), Arrays.asList(Arrays.asList(" default", " primary"), Arrays.asList(" primary", " primary")));
        allColorIcons.put(color.get(3), Arrays.asList(Arrays.asList(" primary", " secondary"), Arrays.asList(" secondary", " secondary")));
        allColorIcons.put(color.get(4), Arrays.asList(Arrays.asList(" secondary", " action"), Arrays.asList(" action", " action")));
        allColorIcons.put(color.get(5), Arrays.asList(Arrays.asList(" action", " disabled"), Arrays.asList(" disabled", " disabled")));
        allColorIcons.put(color.get(6), Arrays.asList(Arrays.asList(" disabled", " green[500]"), Arrays.asList(" green[500]", " green[500]")));

        allColorIcons.forEach(
                (k, v) -> {
                    k.hover();
                    lastClickHoverTextsIs(colorLastClick, colorLastHover, v.get(0));
                    k.click();
                    lastClickHoverTextsIs(colorLastClick, colorLastHover, v.get(1));
                }
        );
    }

    @Test
    public void sizeIconsTest() {
        size.forEach(el -> el.is().displayed());
        lastClickHoverTextsIs(sizeLastClick, sizeLastHover, Arrays.asList("", ""));

        Map<UIElement, List<List<String>>> allSizeIcons = new LinkedHashMap<>();
        allSizeIcons.put(size.get(1), Arrays.asList(Arrays.asList("", " small size"), Arrays.asList(" small size", " small size")));
        allSizeIcons.put(size.get(2), Arrays.asList(Arrays.asList(" small size", " default size"), Arrays.asList(" default size", " default size")));
        allSizeIcons.put(size.get(3), Arrays.asList(Arrays.asList(" default size", " large size"), Arrays.asList(" large size", " large size")));
        allSizeIcons.put(size.get(4), Arrays.asList(Arrays.asList(" large size", " 40 size"), Arrays.asList(" 40 size", " 40 size")));

        allSizeIcons.forEach(
                (k, v) -> {
                    k.hover();
                    lastClickHoverTextsIs(sizeLastClick, sizeLastHover, v.get(0));
                    k.click();
                    lastClickHoverTextsIs(sizeLastClick, sizeLastHover, v.get(1));
                }
        );
    }
}
