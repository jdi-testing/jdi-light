package com.epam.jdi.light.ui.applitools.actions;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import org.aspectj.lang.JoinPoint;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionProcessor.*;
import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.light.ui.applitools.eyes.JEyes.openEyesCheckWindowAndClose;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

public class JEyesActions {

    public static Safe<UIElement> uiElementLastProcessed = new Safe<>(() -> null);

    private static Safe<Boolean> openNewPage = new Safe<>(false);

    public static void integrateEyesInJDI() {

        if (EYES_CHECK_NEW_PAGE || EYES_CHECK_WITH_PROCESSED_ELEMENT) {

            if (EYES_CHECK_NEW_PAGE) {
                BEFORE_JDI_ACTION = jp -> {
                    BEFORE_STEP_ACTION.execute(jp);
                    processNewPage(jp);
                };
            }

            STABLE_ACTION = jp -> {
                try {
                    String exception = "";
                    JDIAction ja = getJpMethod(jp).getMethod().getAnnotation(JDIAction.class);
                    JDIBase obj = getJdi(jp);
                    JFunc1<JDIBase, Object> overrideAction = getOverride(jp, obj);
                    int timeout = getTimeout(ja, obj);
                    long start = currentTimeMillis();
                    do {
                        try {
                            Object result = overrideAction != null
                                    ? overrideAction.execute(obj) : jp.proceed();
                            if (EYES_CHECK_NEW_PAGE && openNewPage.get()) {
                                openEyesCheckWindowAndClose(format("Page (%s) had just opened", getCurrentPage()));
                                openNewPage.set(false);
                            }
                            if (EYES_CHECK_WITH_PROCESSED_ELEMENT && jp.getThis() != null && isClass(jp.getThis().getClass(), UIElement.class)) {
                                uiElementLastProcessed.set((UIElement) jp.getThis());
                            }
                            if (!condition(jp)) continue;
                            return result;
                        } catch (Throwable ex) {
                            try {
                                exception = safeException(ex);
                                Thread.sleep(200);
                            } catch (Exception ignore) {
                            }
                        }
                    } while (currentTimeMillis() - start < timeout * 1000);
                    throw exception(getFailedMessage(jp, exception));
                } finally {
                }
            };
        }

        if (EYES_CHECK_AFTER_JDI_ASSERTION) {

            JDI_ASSERT_FOR_SINGLE_ENTRY = (actual, matcher) -> {
                jdi_assert_for_single_entry(actual, matcher);
                openEyesCheckWindowAndClose(format("After jdi assertion (%s, %s)", actual.toString(), matcher.toString()));
            };

            JDI_ASSERT_FOR_LIST_ENTRY = (actual, matcher) -> {
                jdi_assert_for_list_entry(actual, matcher);
                openEyesCheckWindowAndClose(format("After jdi assertion (%s, %s)", actual.toString(), matcher.toString()));
            };
        }
    }

    public static void processNewPage(JoinPoint jp) {
        getWindows();
        Object element = jp.getThis();
        if (element != null) { // TODO support static pages
            WebPage requestedPage = getPage(element);
            String currentPageName = getCurrentPage();
            if (currentPageName != null && requestedPage != null) {
                if (!currentPageName.equals(requestedPage.getName())) {
                    setCurrentPage(requestedPage);
                    BEFORE_NEW_PAGE.execute(requestedPage);
                    openNewPage.set(true);
                } else BEFORE_THIS_PAGE.execute(requestedPage);
            }
        }
    }

}
