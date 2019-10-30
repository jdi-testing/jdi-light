package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.SeleniumWebList;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.AnnotationRule;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.init.rules.SetupRule;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.ClickArea;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.GetAny;
import com.epam.jdi.light.elements.pageobjects.annotations.GetShowInView;
import com.epam.jdi.light.elements.pageobjects.annotations.GetTextAs;
import com.epam.jdi.light.elements.pageobjects.annotations.GetVisible;
import com.epam.jdi.light.elements.pageobjects.annotations.GetVisibleEnabled;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.light.elements.pageobjects.annotations.NoCache;
import com.epam.jdi.light.elements.pageobjects.annotations.NoWait;
import com.epam.jdi.light.elements.pageobjects.annotations.Root;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.updatePage;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;
import static com.epam.jdi.light.elements.init.rules.InitRule.iRule;
import static com.epam.jdi.light.elements.init.rules.SetupRule.sRule;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.findByToBy;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getAnnotation;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getFrame;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.LinqUtils.valueOrDefault;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isClassOr;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class InitActions {
    public static void init() {}
    private static void webPageSetup(SiteInfo info) {
        WebPage page = (WebPage) info.instance;
        defaultSetup(info, page);
        page.updatePageData(
            valueOrDefault(getAnnotation(info.field, Url.class),
                page.getClass().getAnnotation(Url.class)),
            valueOrDefault(getAnnotation(info.field, Title.class),
                page.getClass().getAnnotation(Title.class))
        );
        updatePage(page);
    }

    public static MapArray<Class<?>, Class<?>> INTERFACES = map(
        $(WebElement.class, UIElement.class),
        $(IsDropdown.class, Dropdown.class)
    );
    public static MapArray<String, InitRule> INIT_RULES = map(
        $("WebList", iRule(f -> isList(f, WebElement.class), info -> new SeleniumWebList())),
        $("DataList", iRule(f -> isList(f, InitActions::isPageObject),
            info -> new DataList())),
        $("JList", iRule(f -> f.getType() == List.class && isInterface(getGenericType(f), ICoreElement.class),
            info -> new JList())),
        $("Interface", iRule(f -> INTERFACES.keys().contains(f.getType()),
            info -> create(INTERFACES.get(info.field.getType()))))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
        $("Element", sRule(info -> isInterface(info.instance.getClass(), IBaseElement.class),
            InitActions::elementSetup)),
        $("ISetup", sRule(InitActions::isSetupValue, info -> ((ISetup)info.instance).setup(info.field))),
        $("Page", sRule(info -> isClass(info.instance.getClass(), WebPage.class), InitActions::webPageSetup)),
        $("PageObject", sRule(info -> !isClassOr(info.type(), WebPage.class, Section.class) &&
                isPageObject(info.instance.getClass()),
            PageFactory::initElements))
    );

    private static boolean isSetupValue(SiteInfo info) {
        try {
            if (isInterface(info.instance.getClass(), ISetup.class))
                return true;
            Object value = info.field.get(info.parent);
            if (value == null) return false;
            return isInterface(value.getClass(), ISetup.class);
        } catch (Exception ex) {return false; }
    }

    public static DriverBase defaultSetup(SiteInfo info, DriverBase jdi) {
        if (jdi.parent == null)
            jdi.setParent(info.parent);
        if (!jdi.name.matches("[A-Z].*]"))
            jdi.setName(info);
        jdi.driverName = isBlank(info.driverName) ? DRIVER_NAME : info.driverName;
        return jdi;
    }
    public static MapArray<String, AnnotationRule> JDI_ANNOTATIONS = map(
        $("Root", aRule(Root.class, (e,a)-> e.locator.isRoot = true)),
        $("Frame", aRule(Frame.class, (e,a)-> e.setFrame(getFrame(a)))),
        $("FindBySelenium", aRule(org.openqa.selenium.support.FindBy.class,
            (e,a)-> e.setLocator(findByToBy(a)))),
        $("Css", aRule(Css.class, (e,a)-> e.setLocator(findByToBy(a)))),
        $("XPath", aRule(XPath.class, (e,a)-> e.setLocator(findByToBy(a)))),
        $("ByText", aRule(ByText.class, (e,a)-> e.setLocator(findByToBy(a)))),
        $("WithText", aRule(WithText.class, (e,a)-> e.setLocator(findByToBy(a)))),
        $("ClickArea", aRule(ClickArea.class, (e,a)-> e.setClickArea(a.value()))),
        $("GetTextAs", aRule(GetTextAs.class, (e,a)-> e.setTextType(a.value()))),
        $("NoCache", aRule(NoCache.class, (e,a)-> e.offCache())),

        $("Timeout", aRule(WaitTimeout.class, (e,a)-> e.waitSec(a.value()))),
        $("NoWait", aRule(NoWait.class, (e,a)-> e.waitSec(0))),
        $("Name", aRule(Name.class, (e,a)-> e.setName(a.value()))),
        $("GetAny", aRule(GetAny.class, (e, a)-> e.noValidation())),
        $("GetVisible", aRule(GetVisible.class, (e, a)-> e.searchVisible())),
        $("GetVisibleEnabled", aRule(GetVisibleEnabled.class, (e, a)-> e.visibleEnabled())),
        $("GetShowInView", aRule(GetShowInView.class, (e, a)-> e.inView())),

        $("ListUI", aRule(UI.class, (e,a,f)-> {
            UI[] uis = f.getAnnotationsByType(UI.class);
            if (uis.length > 0 && any(uis, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
                e.setLocator(findByToBy(first(uis, j -> j.group().equals(TEST_GROUP))));
            })),
        $("FindByUI", aRule(FindBy.class, (e,a,f)-> {
            FindBy[] jfindbys = f.getAnnotationsByType(FindBy.class);
            if (jfindbys.length > 0 && any(jfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
                e.setLocator(findByToBy(first(jfindbys, j -> j.group().equals(TEST_GROUP))));
            }))
    );

    public static IBaseElement elementSetup(SiteInfo info) {
        IBaseElement jdi = (IBaseElement) info.instance;
        defaultSetup(info, jdi.base());
        if (info.field != null) {
            for (Pair<String, AnnotationRule> aRule : JDI_ANNOTATIONS) {
                try {
                    Class<? extends Annotation> annotation = aRule.value.annotation;
                    if (hasAnnotation(info.field, annotation))
                        aRule.value.action.execute(jdi.base(), info.field.getAnnotation(annotation), info.field);
                } catch (Exception ex) {
                    throw exception("Setup element '%s' with Annotation '%s' failed", info.name(), aRule.key);
                }
            }
        }
        info.instance = jdi;
        return jdi;
    }
    public static boolean isJDIField(Field field) {
        return isInterface(field, WebElement.class) ||
            isInterface(field, ICoreElement.class) ||
            isListOf(field, WebElement.class) ||
            isListOf(field, ICoreElement.class) ||
            isListOf(field, Section.class);
    }
    public static boolean isPageObject(Class<?> type) {
        return isClass(type, Section.class) || isClass(type, WebPage.class) ||
            LinqUtils.any(type.getDeclaredFields(), InitActions::isJDIField);
    }
    public static boolean isList(Field f, JFunc1<Class<?>, Boolean> func) {
        try {
            return f.getType() == List.class && func.execute(getGenericType(f));
        } catch (Exception ex) { return false; }
    }
    public static boolean isList(Class<?> clazz, JFunc1<Class<?>, Boolean> func) {
        try {
            return clazz == List.class && func.execute(getGenericType(clazz));
        } catch (Exception ex) { return false; }
    }
    public static boolean isList(Field f, Class<?> type) {
        return isList(f, g -> g == type);
    }
    public static boolean isListOf(Field field, Class<?> type) {
        return isList(field, g -> isClass(g, type) || isInterface(g, type));
    }
    public static Type[] getGenericTypes(Field field) {
        try {
            return ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        } catch (Exception ex) {
            throw exception( "'%s' is List but has no Generic types", field.getName());
        }
    }
    public static Class<?> getGenericType(Field field) {
        try {
            return (Class<?>)((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
        } catch (Exception ex) {
            throw exception( "'%s' is List but has no Generic types", field.getName());
        }
    }
    public static Class<?> getGenericType(Class<?> clazz) {
        try {
            return (Class<?>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception ex) {
            throw exception("'%s' is List but has no Generic type", clazz.getName());
        }
    }
}
