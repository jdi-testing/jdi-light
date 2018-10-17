package com.epam.jdi.light.common;

import com.epam.jdi.light.logger.JDILogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnixProcessUtils {

    private static JDILogger logger = JDILogger.instance(UnixProcessUtils.class.getName());

    public static void main(String[] args) {

        System.out.println(Paths.get(".")
            .toAbsolutePath());
        killProcessesTree("chromedriver");
        return;


    }

    /**
     *
     * @param rootNamePart
     */
    public static void killProcessesTree(String rootNamePart) {

        List<String> chrome = null;

        try {
            chrome = getPIDsByNamePart(rootNamePart);

            for (String s : chrome) {

                int pid = Integer.parseInt(s);
                killChildProcesses(pid);
            }
            killProcessesByNamePart(rootNamePart);

            logger.info("Process: " + rootNamePart);


        } catch (InterruptedException | IOException e) {

            JDILogger.instance(UnixProcessUtils.class.getName())
                .error(e.getMessage());
        }

        return;
    }

    /**
     *
     * @param name
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static List<String> getPIDsByNamePart(String name) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(
            "/usr/bin/pgrep",
            "-afi",
            name)
            .start();
        process.waitFor();

        List<String> list = new ArrayList<>();

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = null;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        logger.info("Parent Pids: " + list);
        return list;

    }

    /**
     *
     * @param pid
     */
    public static void killChildProcesses(int pid) {
        String ppid = String.valueOf("-P " + pid);
        killProcessWithArgs(Collections.singletonList(ppid));
    }

    /**
     *
     * @param name
     */
    public static void killProcessesByNamePart(String name) {
        killProcessWithArgs(Arrays.asList("-aif", name));
    }

    /**
     *
     * @param args
     */
    private static void killProcessWithArgs(List<String> args) {

        List<String> list = new ArrayList<>();
        list.add("/usr/bin/pkill");
        list.addAll(args);

        try {
            Process child = new ProcessBuilder(list.toArray(new String[list.size()]))
                .start();

            child.waitFor();
        } catch (InterruptedException | IOException e) {

            JDILogger.instance(UnixProcessUtils.class.getName())
                .error(e.getMessage());
        }
    }

}