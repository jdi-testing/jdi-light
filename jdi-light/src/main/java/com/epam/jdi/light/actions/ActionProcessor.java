package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.Exceptions;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.settings.WebSettings.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {  }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() {  }
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel()
                ? stableAction(jInfo)
                : defaultAction(jInfo);
            return AFTER_JDI_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            logger.debug("ActionProcessor exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            jInfo.clear();
        }
    }
}
