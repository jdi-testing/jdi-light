package io.github.epam.html.tests.debug;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.pairs.Pair;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.init.InitActions.isJDIField;
import static com.epam.jdi.light.elements.init.InitActions.isPageObject;
import static com.epam.jdi.light.elements.init.PageFactory.STOP_INIT_CLASSES;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.pairs.Pair.$;
import static io.github.com.StaticSite.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.lang.String.format;
import static java.util.Arrays.asList;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
//@Listeners(TestNGListener.class)
public class DebugTests implements TestsInit {
    @BeforeClass
    public void before() {
        shouldBeLoggedIn();
    }

    private List<Pair<Field, Object>> getFieldsRec(Object obj) {
        List<Field> poFields = recursion(obj.getClass(),
            t -> !STOP_INIT_CLASSES.contains(t),
            t -> asList(t.getDeclaredFields()));
        List<Pair<Field, Object>> result = ifSelect(poFields, f -> isJDIField(f), f -> $(f, obj));
        for (Field section : filter(poFields, f -> isPageObject(f.getType()))) {
            try {
                result.addAll(getFieldsRec(section.get(obj)));
            } catch (Exception ignore) { }
        }
        return result;
    }
    @Test
    public void aiScreensTest() {
        List<WebPage> pages = asList(homePage, metalAndColorsPage, contactFormPage, html5Page, usersPage, tablePage);
        for (WebPage page : pages) {
            page.open();
            List<Pair<Field, Object>> fields = getFieldsRec(page);
            List<IBaseElement> uiElements = new ArrayList<>();
            for (Pair<Field, Object> field : fields) {
                try {
                    Object el = field.key.get(field.value);
                    if (isInterface(el.getClass(), IBaseElement.class) && !isClass(el.getClass(), Section.class)) {
                        uiElements.add((IBaseElement) el);
                    }
                } catch (Exception ignore) { }
            }
            String name = page.getName().toLowerCase().replace(" ", "");
            try {
                Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(page.driver());
                ImageIO.write(screenshot.getImage(), "PNG", new File("D:\\Github\\Java\\JDIGit\\JDILight\\jdi-light-html-tests\\target\\.logs\\screens\\" + name + ".png"));
            } catch (Exception ex) {
                System.out.println("Failed to do screenshot");
            }
            // WebPage.windowScreenshot("D:\\Github\\Java\\JDIGit\\JDILight\\jdi-light-html-tests\\target\\.logs\\screens\\" + name + ".png");
            File csvOutputFile = new File("D:\\Github\\Java\\JDIGit\\JDILight\\jdi-light-html-tests\\target\\.logs\\screens\\" + name + ".csv");
            List<Rectangle> rects = new ArrayList<>();
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                for (IBaseElement element : uiElements) {
                    try {
                        if (isClass(element.getClass(), HasUIList.class)) {
                            HasUIList list = (HasUIList) element;
                            if (list.list().isHidden()) continue;
                            Rectangle rect = new Rectangle(list.list().getLocation(), list.list().getSize());
                            if (hasNo(rects, rect)) {
                                rects.add(rect);
                                String elementName = getName(((ICoreElement) list).core().typeName.toLowerCase());
                                pw.println(format("%s,%s,%s,%s,%s", elementName, rect.x, rect.y, rect.width, rect.height));
                            }
                        } else if (isClass(element.getClass(), ICoreElement.class)) {
                            ICoreElement el = (ICoreElement) element;
                            if (el.isHidden()) continue;
                            Rectangle rect = el.core().getRect();
                            if (hasNo(rects, rect)) {
                                rects.add(rect);
                                String elementName = getName(el.base().typeName.toLowerCase());
                                pw.println(format("%s,%s,%s,%s,%s", elementName, rect.x, rect.y, rect.width, rect.height));
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("FAILED: " + element.getName());
                    }
                }
            } catch (Exception ignore) { }
        }
    }
    private static boolean hasNo(List<Rectangle> rects, Rectangle rect){
        return !any(rects, r -> rect.x == r.x && rect.y == r.y && rect.width == r.width && rect.height == r.height);
    }
    private static String getName(String name) {
        if (name.equals("dropdownexpand") || name.equals("isdropdown") || name.equals("customdropdown")) {
            return "dropdown";
        } else if (name.equals("grid") || name.equals("datatable") ) {
            return "table";
        }
        return name;
    }
}
