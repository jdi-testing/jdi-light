package com.jdi.testng;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {
    long timeStart = 0;
    String testName = "";
    @Override
    public void beforeInvocation(IInvokedMethod m, ITestResult tr) {
        if (m.isTestMethod()) {
            Method testMethod = m.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(Test.class)) {
                timeStart = currentTimeMillis();
                testName = tr.getTestClass().getRealClass().getSimpleName()+"."+testMethod.getName();
                System.out.println("== Test '"+testName+"' START ==");
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult r) {
        if (method.isTestMethod()) {
            String result = getTestResult(r);
            String date = new SimpleDateFormat("mm:ss.SS").format(new Date(currentTimeMillis() - timeStart));
            System.out.println("=== Test '"+testName+"' "+result+" ["+date+"] ===");
            if (result.equals("FAILED")) {
                System.out.println("ERROR: " + r.getThrowable().getMessage());
            }
            System.out.println();
        }
    }

    private String getTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "FAILED";
        }
    }


}