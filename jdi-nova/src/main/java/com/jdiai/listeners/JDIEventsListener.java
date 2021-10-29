package com.jdiai.listeners;

import com.jdiai.interfaces.HasCore;

public interface JDIEventsListener {
    void beforeAction(String actionName, String step, HasCore element);
    void afterAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed);
    void afterSuccessAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed);
    void afterFailAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed,
         Throwable failException, String failAssertMessage);
}
