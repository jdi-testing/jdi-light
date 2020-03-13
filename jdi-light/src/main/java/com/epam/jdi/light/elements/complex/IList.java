package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.*;
import com.epam.jdi.tools.map.MultiMap;
import com.epam.jdi.tools.pairs.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.tools.EnumUtils.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IList<T> extends IBaseElement, List<T>, HasValue, IHasSize {
    /**
     *  Get all application elements
     *  */
    MultiMap<String, T> elements(int minAmount);
    T get(String value);

    default T get(Enum name) { return get(getEnumValue(name)); }
    default T last() {
        MultiMap<String, T> elements = elements(1);
        Pair<String, T> last = elements.last();
        return last == null ? null : last.value;
    }
    default T first() {
        MultiMap<String, T> elements = elements(1);
        Pair<String, T> first = elements.first();
        return first == null ? null : first.value;
    }
    default List<T> where(JFunc1<T, Boolean> condition) {
        return elements(0).values(condition);
    }
    default List<T> filter(JFunc1<T, Boolean> condition) {
        return where(condition);
    }
    default <R> List<R> select(JFunc1<T, R> transform) {
        return elements(0).select((k,v) -> transform.execute(v));
    }
    default <R> List<R> map(JFunc1<T, R> transform) {
        return select(transform);
    }
    default T first(JFunc1<T, Boolean> condition) {
        MultiMap<String, T> elements = elements(1);
        Pair<String, T> first = elements.first((k,v) -> condition.execute(v));
        return first == null ? null : first.value;
    }
    default T last(JFunc1<T, Boolean> condition) {
        MultiMap<String, T> elements = elements(1);
        Pair<String, T> last = elements.last((k,v) -> condition.execute(v));
        return last == null ? null : last.value;
    }
    default void ifDo(JFunc1<T, Boolean> condition, JAction1<T> action) {
        elements(1).ifDo(p -> condition.execute(p.value), action::execute);
    }
    default <R> List<R> ifSelect(JFunc1<T, Boolean> condition, JFunc1<T, R> transform) {
        return elements(0).ifSelect((k,v) -> condition.execute(v), transform);
    }
    default void foreach(JAction1<T> action) {
        elements(0).foreach((k,v) -> action.execute(v));
    }
    default boolean hasAny(JFunc1<T, Boolean> condition) {
        return elements(0).any(condition);
    }
    default boolean hasAnyKey(JFunc1<String, Boolean> condition) {
        return LinqUtils.any(elements(0).keys(), condition);
    }
    default boolean all(JFunc1<T, Boolean> condition) {
        return elements(0).all(condition);
    }
    default List<T> slice(int from, int to) {
        return elements(to).slice(from, to).values();
    }
    default List<T> slice(int from) {
        return elements(from).slice(from).values();
    }
    default List<T> sliceTo(int to) {
        return elements(to).sliceTo(to).values();
    }
    default void refresh() { clear(); }
    default <R> List<R> selectMany(JFunc1<T, List<R>> func) {
        return elements(0).selectMany((k,v) -> func.execute(v));
    }
    @Override
    default int size() {
        try {
            return base().noWait(() -> base().getList(0).size());
        } catch (Exception ex) {
            throw exception(ex, "Get size failed");
        }
    }
    @Override
    default boolean isEmpty() { return size() == 0; }
    // List methods
    @Override
    default boolean contains(Object o) {
        return elements(0).contains(o);
    }
    @Override
    default Iterator<T> iterator() {
        return elements(0).values().iterator();
    }
    @Override
    default Object[] toArray() {
        return elements(0).toArray();
    }
    @Override
    default <T1> T1[] toArray(T1[] a) {
        return elements(0).toArray(a);
    }
    @Override
    default boolean add(T t) {
        throw new NotImplementedException();
    }
    @Override
    default boolean remove(Object o) {
        throw new NotImplementedException();
    }
    @Override
    default boolean containsAll(Collection<?> c) {
        return elements(c.size()).containsAll(c);
    }
    @Override
    default boolean addAll(Collection<? extends T> c) {
        throw new NotImplementedException();
    }
    @Override
    default boolean addAll(int index, Collection<? extends T> c) {
        throw new NotImplementedException();
    }
    @Override
    default boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }
    @Override
    default boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }
    @Override
    default T get(int index) {
        Pair<String, T> result = elements(index).get(index);
        return result != null ? result.value : null;
    }
    @Override
    default T set(int index, T element) {
        throw new NotImplementedException();
    }
    @Override
    default void add(int index, T element) {
        throw new NotImplementedException();
    }
    @Override
    default T remove(int index) {
        MultiMap<String, T> elements = elements(index);
        Pair<String, T> removed = elements.removeByIndex(index);
        return removed == null ? null : removed.value;
    }
    @Override
    default int indexOf(Object o) {
        return elements(0).values().indexOf(o);
    }
    @Override
    default int lastIndexOf(Object o) {
        return elements(0).values().lastIndexOf(o);
    }
    @Override
    default ListIterator<T> listIterator() {
        return elements(0).values().listIterator();
    }
    @Override
    default ListIterator<T> listIterator(int index) {
        return elements(0).values().listIterator(index);
    }
    @Override
    default List<T> subList(int fromIndex, int toIndex) {
        return slice(fromIndex, toIndex);
    }
}
