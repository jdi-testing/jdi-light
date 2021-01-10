package org.jdiai;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public class Json extends MapArray<String, String> {
    public Json(List<String> keys, JsonObject json) {
        this(keys, s -> json.get(s).getAsString());
    }
    public Json() {
        pairs = new ArrayList<>();
    }

    public Json(String key, String value) {
        this();
        add(key, value);
    }

    public Json(Pair<String, String>... pairs) {
        this(asList(pairs));
    }
    public Json(List<Pair<String, String>> pairs) {
        this();
        try {
            for (Pair<String, String> pair : pairs)
                add(pair.key, pair.value);
        } catch (Exception ex) {
            throw new RuntimeException(format("Can't create MapArray. Exception: %s", ex.getMessage()));
        }
    }

    public Json(Collection<String> collection, JFunc1<String, String> value) {
        this(collection, k -> k, value::execute);
    }
    public <T> Json(Collection<T> collection, JFunc1<T, String> keyFunc, JFunc1<T, String> valueFunc) {
        this(collection, keyFunc, valueFunc, false);
    }
    public <T> Json(Collection<T> collection, JFunc1<T, String> keyFunc, JFunc1<T, String> valueFunc, boolean ignoreNotUnique) {
        this();
        try {
            for (T t : collection) {
                if (ignoreNotUnique)
                    addNew(keyFunc.invoke(t), valueFunc.invoke(t));
                else
                    add(keyFunc.invoke(t), valueFunc.invoke(t));
            }
        } catch (Exception ex) {
            throw new RuntimeException(format("Can't create MapArray. Exception: %s", ex.getMessage()));
        }
    }

    public Json(String[] array, JFunc1<String, String> value) {
        this(asList(array), value);
    }
    public <T> Json(T[] array, JFunc1<T, String> key, JFunc1<T, String> value) {
        this(array, key, value, false);
    }
    public <T> Json(T[] array, JFunc1<T, String> key, JFunc1<T, String> value, boolean ignoreNotUnique) {
        this(asList(array), key, value, ignoreNotUnique);
    }

    public Json(int count, JFunc1<Integer, String> keyFunc, JFunc1<Integer, String> value) {
        this();
        try {
            for (int i = 0; i < count; i++)
                add(keyFunc.invoke(i), value.invoke(i));
        } catch (Exception ex) {
            throw new RuntimeException(format("Can't create MapArray. Exception: %s", ex.getMessage()));
        }
    }
    public Json(int count, JFunc1<Integer, Pair<String, String>> pairFunc) {
        this();
        try {
            for (int i = 0; i < count; i++) {
                Pair<String, String> pair = pairFunc.invoke(i);
                add(pair.key, pair.value);
            }
        } catch (Exception ex) {
            throw new RuntimeException(format("Can't create MapArray. Exception: %s", ex.getMessage()));
        }
    }
    public void addUnique(String key, String value) {
        if (keys().contains(key))
            throw new RuntimeException("Duplicated keys " + key + ". Can't create MapArray");
        add(key, value);
    }

    public Json(MapArray<String, String> mapArray) {
        this();
        addAll(new ArrayList<>(mapArray));
    }
    public Json(Map<String, String> map) {
        this();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet())
                add(entry.getKey(), entry.getValue());
        }
    }

    public Json(Object[][] objects) {
        this();
        if (objects != null) {
            add(objects);
        }
    }
    private static List<String> jsonToList(JsonElement json) {
        List<String> result = new ArrayList<>();
        for (JsonElement js : json.getAsJsonArray()) {
            result.add(js.getAsString());
        }
        return result;
    }
    public Json(JsonElement keys, JsonElement values) {
        this(jsonToList(keys), jsonToList(values));
    }
    public Json(Collection<String> keys, Collection<String> values) {
        this();
        if (keys != null && values != null) {
            if (keys.size() != values.size())
                throw new RuntimeException(format("keys and values has different count (keys:[%s]; values:[%s])",
                        print(keys, Object::toString), print(values, Objects::toString)));
            Iterator<String> ik = keys.iterator();
            Iterator<String> vk = values.iterator();
            for (int i = 0; i < keys.size(); i++) {
                add(ik.next(), vk.next());
            }
        }
    }
    public Json(String[] keys, String[] values) {
        this(asList(keys), asList(values));
    }
}
