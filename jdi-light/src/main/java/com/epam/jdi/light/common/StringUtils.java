package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
// TODO: Remove file after jdi-lightsaber 2.1.7 release

import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.tools.ReflectionUtils.getAllFields;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.map.MapArray.map;
import static java.lang.Character.*;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.regex.Matcher.quoteReplacement;
import static javax.xml.bind.DatatypeConverter.*;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;

final class StringUtils {
    public static final String LINE_BREAK = System.getProperty("line.separator");

    public static boolean namesEqual(String name1, String name2) {
        return name1.replace(" ", "").equalsIgnoreCase(name2.replace(" ", ""));
    }

    public static String msgFormat(String template, List<Object> args) {
        String result = template;
        int i = 0;
        for (Object arg : args) {
            if (template.contains("{" + i + "}"))
                result = result.replaceAll("\\{" + i + "}", arg.toString());
            i++;
        }
        return result;
    }
    public static String msgFormat(String template, Object... args) {
        String result = template;
        int i = 0;
        for (Object arg : args) {
            if (template.contains("{" + i + "}"))
                result = result.replaceAll("\\{" + i + "}", arg.toString().replace("$", "\\$"));
            i++;
        }
        return result;
    }
    public static String msgFormat(String template, Object obj) {
        return msgFormat(template, getAllFields(obj));
    }
    public static String msgFormat(String template, MapArray<String, Object> args) {
        final Matcher matcher = Pattern.compile("\\{([^}]*)}").matcher(template);
        final StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            final String pattern = matcher.group(1);
            Object replacement = args.get(pattern);
            if (replacement == null) replacement = matcher.group();
            matcher.appendReplacement(sb, quoteReplacement(getValue(replacement)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    private static String getValue(Object obj) {
        return isClass(obj.getClass(), JFunc.class) ? ((JFunc<String>) obj).execute() : obj.toString();
    }
    public static String msgFormat(String template, Pair<String, Object>... pairs) {
        return msgFormat(template, map(pairs));
    }
    public static boolean contains(String string, String[] strings) {
        return contains(string, asList(strings));
    }
    public static boolean contains(String string, List<String> strings) {
        for (String s : strings)
            if (!string.contains(s)) return false;
        return true;
    }
    //someVariable Name-Field -> some variable name field
    public static String splitLowerCase(String value) {
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            if (isUpperCase(value.charAt(i)))
                result += " ";
            result += toLowerCase(value.charAt(i));
        }
        return result;
    }
    public static String splitFirstCapital(String name) {
        String result = toUpperCase(name.charAt(0))+"";
        for(int i = 1; i < name.length() - 1; ++i) {
            if (!isUpperCase(name.charAt(i)) || !isLowerCase(name.charAt(i + 1))
                    && !isLowerCase(name.charAt(i - 1))) {
                result += name.charAt(i);
            } else {
                if (name.charAt(i) != ' ') {
                    result += " ";
                }
                result += toLowerCase(name.charAt(i));
            }
        }
        return result + name.charAt(name.length() - 1);
    }

    //someVariable IDName-Field -> Some Variable ID Name Field
    public static String splitCamelCase(String value) {
        String result = (value.charAt(0) + "").toUpperCase();
        for (int i = 1; i < value.length() - 1; i++)
            result += (isUpperCase(value.charAt(i)) && (
                    isLowerCase(value.charAt(i+1)) || isLowerCase(value.charAt(i-1)))
                    ? " " : "") + value.charAt(i);
        return result + value.charAt(value.length() - 1);
    }
    private static String cleanupString(String text) {
        if (isEmpty(text)) return "";
        return text.replaceAll("[^a-zA-Z0-9 ]", "")
                .trim()
                .replaceAll(" +", " ");
    }
    public static String toCamelCase(String value) {
        String result = cleanupString(value);
        result.replaceAll(" ", "");
        if (isEmpty(result)) return "";
        return toLowerCase(result.charAt(0)) + result.substring(1);
    }
    public static String toPascalCase(String value) {
        String result = cleanupString(value);
        result.replaceAll(" ", "");
        if (isEmpty(result)) return "";
        return toUpperCase(result.charAt(0)) + result.substring(1);
    }
    public static String toSnakeCase(String value) {
        String clean = cleanupString(value);
        if (isEmpty(clean)) return "";
        return processString(clean, "_").toLowerCase();
    }
    public static String toKebabCase(String value) {
        String clean = cleanupString(value);
        if (isEmpty(clean)) return "";
        return processString(clean, "-").toLowerCase();
    }
    public static String toUpperSnakeCase(String value) {
        String clean = cleanupString(value).toUpperCase();
        if (isEmpty(clean)) return "";
        return processString(clean, "_").toUpperCase();
    }
    private static String processString(String str, String splitter) {
        if (isBlank(str) || str.length() < 3)
            return str;
        String result = "" + str.charAt(0);
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) == ' ') {
                if (isLetter(str.charAt(i+1))) {
                    result += splitter;
                }
            } else  {
                if (isUpperCase(str.charAt(i)) && isLetter(str.charAt(i-1)) && isLetter(str.charAt(i+1)) && (isLowerCase(str.charAt(i-1)) || isLowerCase(str.charAt(i+1))))
                    result += splitter;
                result += str.charAt(i);
            }
        }
        return result + str.charAt(str.length()-1);
    }
    public static String splitHyphen(String value) {
        String text = cleanupString(value);
        if (isEmpty(text)) return "";
        return text.toLowerCase().replace(" ", "-");
    }

    public static String correctPath(String path) {
        return path.replace("\\", File.separator);
    }
    public static String format(String s, Object... args) {
        return args.length > 0 ? String.format(s, args) : s;
    }

    public static List<String> inputStreamToList(InputStream stream) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception ex) { throw new RuntimeException("Can't read Input Stream: " + ex.getMessage()); }
        return list;
    }


    public static String arrayToString(Object array) {
        String result = "";
        boolean first = true;
        for(Object a : (Object[])array) {
            if (first) first = false;
            else result += ",";
            result += a.toString();
        }
        return result;
    }

    public static void setPrimitiveField(Field field, Object obj, String value) {
        field.setAccessible(true);
        try {
            if (String.class.isAssignableFrom(field.getType())) {
                field.set(obj, value);
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (boolean.class.isAssignableFrom(field.getType())) {
                field.set(obj, Boolean.parseBoolean(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (char.class.isAssignableFrom(field.getType())) {
                field.set(obj, value.charAt(0));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (byte.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseByte(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (short.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseShort(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (int.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseInt(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (long.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseLong(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (float.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseFloat(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (double.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseDouble(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Boolean.class.isAssignableFrom(field.getType())) {
                field.set(obj, Boolean.parseBoolean(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Character.class.isAssignableFrom(field.getType())) {
                field.set(obj, value.charAt(0));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Byte.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseByte(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Short.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseShort(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Integer.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseInt(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Long.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseLong(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Float.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseFloat(value));
                return;
            }
        } catch (Exception ignore) { }
        try {
            if (Double.class.isAssignableFrom(field.getType())) {
                field.set(obj, parseDouble(value));
                return;
            }
        } catch (Exception ignore) { }
    }

    private StringUtils() {}
}