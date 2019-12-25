package com.epam.jdi.light.common;

import java.io.IOException;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.inputStreamToList;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class LinuxProcessUtils {
    /**
     * @param rootNamePart
     */
    public static void killProcessesTree(String rootNamePart) {
        List<String> chrome;
        try {
            logger.info("rootNamePart: " + rootNamePart);
            chrome = getPIDsByNamePart(rootNamePart);
            logger.info("Driver PID: " + chrome);
            for (String pid : chrome) {
                killProcessByPid(pid);
            }
            chrome = getPIDsByNamePart(rootNamePart);
            logger.info("Driver PID after it got killed: " + chrome);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Can't kill drivers");
        }
    }

    private static void killProcessByPid(String pid) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(
                "kill", "-9", pid)
                .start();
        process.waitFor();
    }

    /**
     * @param value
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private static List<String> getPIDsByNamePart(String value) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(
                "pgrep", value)
                .start();
        process.waitFor();
        return inputStreamToList(process.getInputStream());
    }
}
