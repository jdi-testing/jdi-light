package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public interface IList<T> extends List<T> {
    /**
     *  Get all application elements
     */
    @JDIAction(level = DEBUG)
    List<WebElement> getAll(Object... args);

    /**
     *  Get all application elements
     */
    @JDIAction(level = DEBUG)
    MapArray<String, T> getMap();
    @JDIAction(level = DEBUG)
    List<T> values();
    default T last() {
        return getMap().last().value;
    }
    default T first() {
        return getMap().first().value;
    }
    default List<T> where(JFunc2<String, T, Boolean> func) {
        return getMap().filter(func).values();
    }
    default List<T> filter(JFunc2<String, T, Boolean> func) {
        return where(func);
    }
    default <R> List<R> select(JFunc2<String, T, R> func) {
        return getMap().select(func);
    }
    default <R> List<R> map(JFunc2<String, T, R> func) {
        return select(func);
    }
    default T first(JFunc2<String, T, Boolean> func) {
        return getMap().first(func);
    }
    default T last(JFunc2<String, T, Boolean> func) {
        return getMap().last(func);
    }
    @Override
    default int size() {
        return getMap().size();
    }
    @JDIAction(level = DEBUG)
    default boolean isEmpty() {
        return getMap().isEmpty();
    }
    @JDIAction(level = DEBUG)
    default boolean any() { return !isEmpty(); }

    // List methods
    default boolean contains(Object o) {
        return values().contains(o);
    }
    default Iterator<T> iterator() {
        return values().iterator();
    }
    default Object[] toArray() {
        return values().toArray();
    }
    default <T1> T1[] toArray(T1[] a) {
        return values().toArray(a);
    }
    default boolean add(T t) {
        throw new NotImplementedException();
    }
    default boolean remove(Object o) {
        throw new NotImplementedException();
    }
    default boolean containsAll(Collection<?> c) {
        return values().containsAll(c);
    }
    default boolean addAll(Collection<? extends T> c) {
        throw new NotImplementedException();
    }
    default boolean addAll(int index, Collection<? extends T> c) {
        throw new NotImplementedException();
    }
    default boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }
    default boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }
    default void clear() { throw new NotImplementedException(); }
    default T get(int index) {
        return values().get(index);
    }
    default T set(int index, T element) {
        throw new NotImplementedException();
    }
    default void add(int index, T element) {
        throw new NotImplementedException();
    }
    default T remove(int index) {
        throw new NotImplementedException();
    }
    default int indexOf(Object o) {
        return values().indexOf(o);
    }
    default int lastIndexOf(Object o) {
        return values().lastIndexOf(o);
    }
    default ListIterator<T> listIterator() {
        return values().listIterator();
    }
    default ListIterator<T> listIterator(int index) {
        return values().listIterator(index);
    }
    default List<T> subList(int fromIndex, int toIndex) {
        return values().subList(fromIndex, toIndex);
    }
}
