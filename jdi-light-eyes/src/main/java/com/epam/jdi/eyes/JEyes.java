package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import static com.applitools.eyes.TestResultsStatus.Passed;
import static com.epam.jdi.eyes.JDIEyes.EYES_CONFIG;
import static com.google.common.base.Strings.isNullOrEmpty;

class JEyes extends Eyes {
    JEyes() {
        super(new ClassicRunner());
        if (isNullOrEmpty(System.getenv("APPLITOOLS_API_KEY"))) {
            throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'. More info how to obtain API_KEY https://applitools.com/docs/topics/overview/obtain-api-key.html");
        }
        setApiKey(EYES_CONFIG.apiKey);
        setAppName(EYES_CONFIG.appName);
        setConfiguration(EYES_CONFIG.config);
        open(EYES_CONFIG.webDriver);
    }

    boolean getResult() {
        try {
            TestResults testResults = close(false);
            //String fullTestResult = testResults.toString();
            //String testResult = fullTestResult.substring(fullTestResult.indexOf("test name"), fullTestResult.indexOf(']'));
            return testResults.getStatus() == Passed;
            //logger.info(format("Applitools eyes check result: %s: %s (full info in your Applitools account).", status, testResult));
        } catch (Exception ex){
            abortIfNotClosed();
        }
        return false;
    }

}
