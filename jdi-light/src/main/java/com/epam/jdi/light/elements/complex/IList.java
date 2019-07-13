package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.settings.TimeoutSettings;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;

public interface IList<T> extends List<T>, HasValue, IHasSize {
    /**
     *  Get all application elements
     *  */
    List<T> elements(int minAmount);
    T get(String value);

    default T get(Enum name) { return get(getEnumValue(name)); }
    default T last() {
        return elements(1).get(size()-1);
    }
    default T first() {
        return elements(1).get(0);
    }
    default List<T> where(JFunc1<T, Boolean> condition) {
        return LinqUtils.where(elements(0),condition);
    }
    default List<T> filter(JFunc1<T, Boolean> condition) {
        return where(condition);
    }
    default <R> List<R> select(JFunc1<T, R> transform) {
        return LinqUtils.select(elements(0), transform);
    }
    default <R> List<R> map(JFunc1<T, R> transform) {
        return select(transform);
    }
    default T first(JFunc1<T, Boolean> condition) {
        return LinqUtils.first(elements(1), condition);
    }
    default T last(JFunc1<T, Boolean> condition) {
        return LinqUtils.last(elements(1), condition);
    }
    default void ifDo(JFunc1<T, Boolean> condition, JAction1<T> action) {
        LinqUtils.ifDo(elements(1), condition, action);
    }
    default <R> List<R> ifSelect(JFunc1<T, Boolean> condition, JFunc1<T, R> transform) {
        return LinqUtils.ifSelect(elements(0), condition, transform);
    }
    default void foreach(JAction1<T> action) {
        LinqUtils.foreach(elements(0), action);
    }
    default boolean hasAny(JFunc1<T, Boolean> condition) {
        return LinqUtils.any(elements(0), condition);
    }
    default boolean all(JFunc1<T, Boolean> condition) {
        return LinqUtils.all(elements(0), condition);
    }
    default List<T> slice(int from) {
        return slice(from, elements(from).size() - 1);
    }
    default void refresh() { clear(); }
    default List<T> slice(int from, int to) {
        return LinqUtils.listCopy(elements(to), from, to);
    }
    default <R> List<R> selectMany(JFunc1<T, List<R>> func) {
        return LinqUtils.selectMany(elements(0), func);
    }
    @Override
    default int size() {
        return TIMEOUT.immediately(() -> elements(0).size());
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
        return elements(0).iterator();
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
        return elements(index).get(index);
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
        return elements(index).remove(index);
    }
    @Override
    default int indexOf(Object o) {
        return elements(0).indexOf(o);
    }
    @Override
    default int lastIndexOf(Object o) {
        return elements(0).lastIndexOf(o);
    }
    @Override
    default ListIterator<T> listIterator() {
        return elements(0).listIterator();
    }
    @Override
    default ListIterator<T> listIterator(int index) {
        return elements(0).listIterator(index);
    }
    @Override
    default List<T> subList(int fromIndex, int toIndex) {
        return slice(fromIndex, toIndex);
    }
}
