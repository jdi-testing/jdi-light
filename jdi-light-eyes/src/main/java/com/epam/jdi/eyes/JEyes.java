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
        super(EYES_CONFIG.runner);
        setConfiguration(EYES_CONFIG.config);
        setApiKey(EYES_CONFIG.apiKey);
        setAppName(EYES_CONFIG.appName);
    }

    boolean getResult() {
        try {
            TestResults testResults = close(false);
            return testResults.getStatus() == Passed;
        } catch (Exception ex){
            abortIfNotClosed();
        }
        return false;
    }

}
