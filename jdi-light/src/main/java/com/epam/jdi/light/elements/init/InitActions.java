package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.*;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.complex.*;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.*;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.VisualCheckAction.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.*;
import static com.epam.jdi.light.elements.init.rules.InitRule.*;
import static com.epam.jdi.light.elements.init.rules.SetupRule.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.*;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class InitActions {
    static void webPageSetup(SiteInfo info) {
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
        $(IsDropdown.class, Dropdown.class),
        $(IsCombobox.class, Combobox.class),
        $(IsChecklist.class, Checklist.class)
    );
    public static MapArray<String, InitRule> INIT_RULES = map(
        $("WebList", iRule(f -> isList(f, WebElement.class), info -> new WebList().indexFromZero())),
        $("DataList", iRule(f -> isList(f, InitActions::isPageObject),
            info -> new DataList<>())),
        $("JList", iRule(f -> f.getType() == List.class && isInterface(getGenericType(f), ICoreElement.class),
            info -> new JList<>())),
        $("Interface", iRule(f -> INTERFACES.keys().contains(f.getType()),
            info -> create(INTERFACES.get(info.field.getType()))))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
        $("Element", sRule(info -> isInterface(info.instance.getClass(), IBaseElement.class),
            InitActions::elementSetup)),
        $("ISetup", sRule(InitActions::isSetupValue, info -> ((ISetup)info.instance).setup(info.field))),
        $("Page", sRule(info -> isClass(info.instance.getClass(), WebPage.class), InitActions::webPageSetup)),
        $("PageObject", sRule(info -> isClassOr(info.type(), WebPage.class, PageObject.class) ||
                isPageObject(info.instance.getClass()),
            PageFactory::initElements)),
        $("VisualCheck", sRule(
            info -> VISUAL_ACTION_STRATEGY == IS_DISPLAYED && isInterface(info.instance.getClass(), ICoreElement.class),
            i-> ((ICoreElement)i.instance).core().params.update("visualCheck",""))),
        $("List", sRule(info -> info.type() == List.class && isInterface(info.type(), HasUIList.class),
            i -> ((HasUIList)i.instance).list().indexFromZero()))
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
        jdi.driverName = isBlank(info.driverName) ? DRIVER.name : info.driverName;
        return jdi;
    }
    public static MapArray<String, AnnotationRule> JDI_ANNOTATIONS = map(
        $("Root", aRule(Root.class, (e,a)-> e.base().locator.isRoot = true)),
        $("Frame", aRule(Frame.class, (e,a)-> e.base().setFrames(getFrames(a)))),
        $("FindBySelenium", aRule(org.openqa.selenium.support.FindBy.class,
            (e,a)-> e.base().setLocator(findByToBy(a)))),
        $("Css", aRule(Css.class, (e,a)-> e.base().setLocator(findByToBy(a)))),
        $("XPath", aRule(XPath.class, (e,a)-> e.base().setLocator(findByToBy(a)))),
        $("ByText", aRule(ByText.class, (e,a)-> e.base().setLocator(findByToBy(a)))),
        $("WithText", aRule(WithText.class, (e,a)-> e.base().setLocator(findByToBy(a)))),
        $("ClickArea", aRule(ClickArea.class, (e,a)-> e.base().clickAreaType = a.value())),
        $("GetTextAs", aRule(GetTextAs.class, (e,a)-> e.base().textType = a.value())),
        $("SetTextAs", aRule(SetTextAs.class, (e,a)-> e.base().setTextType = a.value())),
        $("NoCache", aRule(NoCache.class, (e,a)-> e.offCache())),

        $("WaitTimeout", aRule(WaitTimeout.class, (e,a)-> e.waitSec(a.value()))),
        $("NoWait", aRule(NoWait.class, (e,a)-> e.waitSec(0))),
        $("Name", aRule(Name.class, (e,a)-> e.setName(a.value()))),
        $("GetAny", aRule(GetAny.class, (e, a)-> e.base().noValidation())),
        $("GetVisible", aRule(GetVisible.class, (e, a)-> e.base().searchVisible())),
        $("GetVisibleEnabled", aRule(GetVisibleEnabled.class, (e, a)-> e.base().visibleEnabled())),
        $("GetShowInView", aRule(GetShowInView.class, (e, a)-> e.base().inView())),
        $("PageName", aRule(PageName.class, (e, a)-> e.base().setPage(a.value()))),
        $("StartIndex", aRule(StartIndex.class, (e, a)-> {
            if (isInterface(e.getClass(), HasUIList.class))
                ((HasUIList)e).list().startIndex(a.value());
        })),
        $("CloseAfterSelect", aRule(CloseAfterSelect.class, (e, a)-> {
            if (isClass(e.getClass(), DropdownExpand.class))
                ((DropdownExpand)e).autoClose = true;
        })),
        $("SId", aRule(SId.class, (e,a) -> {
            e.base().setLocator("#" + toKebabCase(e.getName()));
            e.base().locator.isRoot = true;
        })),
        $("Smart Text", aRule(SText.class, (e, a) -> e.base().setLocator(asTextLocator(splitCamelCase(e.getName()))))),
        $("Smart Name", aRule(SName.class, (e, a) -> e.base().setLocator(format("[name='%s']", toKebabCase(e.getName()))))),
        $("Smart", aRule(Smart.class, (e, a) -> e.base().setLocator(format("[%s='%s']", a.value(), toKebabCase(e.getName()))))),
        $("Smart Class", aRule(SClass.class, (e, a) -> e.base().setLocator(format(".%s", toKebabCase(e.getName()))))),
        $("List UI", aRule(UI.class, (e,a,f)-> {
            UI[] uis = f.getAnnotationsByType(UI.class);
            if (uis.length > 0 && any(uis, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
                e.base().setLocator(findByToBy(first(uis, j -> j.group().equals(TEST_GROUP))));
            })),
        $("FindBy UI", aRule(FindBy.class, (e,a,f)-> {
            FindBy[] jfindbys = f.getAnnotationsByType(FindBy.class);
            if (jfindbys.length > 0) {
                FindBy findBy = first(jfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP));
                if (findBy != null) {
                    e.base().setLocator(findByToBy(findBy));
                }
            }
            })),
        $("Visual Check", aRule(VisualCheck.class, (e, a) ->  {
            if (a.value())
                e.base().params.update("visualCheck", "");
            else
                if (e.base().params.keys().contains("visualCheck"))
                    e.base().params.removeByKey("visualCheck");
        }))
    );

    public static IBaseElement elementSetup(SiteInfo info) {
        IBaseElement jdi = (IBaseElement) info.instance;
        defaultSetup(info, jdi.base());
        Object parent = jdi.base().parent;
        if (parent != null && isClass(parent.getClass(), IBaseElement.class)) {
            JDIBase parentBase = ((IBaseElement)parent).base();
            jdi.base().searchRules = parentBase.searchRules.copy();
        }
        if (info.field != null) {
            for (Pair<String, AnnotationRule> aRule : JDI_ANNOTATIONS) {
                try {
                    Class<? extends Annotation> annotation = aRule.value.annotation;
                    if (hasAnnotation(info.field, annotation))
                        aRule.value.action.execute(jdi, info.field.getAnnotation(annotation), info.field);
                } catch (Exception ex) {
                    throw exception(ex, "Setup element '%s' with Annotation '%s' failed", info.name(), aRule.key);
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
            isListOf(field, PageObject.class);
    }
    public static boolean isPageObject(Class<?> type) {
        return isClass(type, Section.class) || isClass(type, WebPage.class) ||
            any(type.getDeclaredFields(), InitActions::isJDIField);
    }
}
