package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
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
        return values().get(size()-1);
    }
    default T first() {
        return values().get(0);
    }
    default List<T> where(JFunc1<T, Boolean> func) {
        return LinqUtils.where(values(),func);
    }
    default List<T> filter(JFunc1<T, Boolean> func) {
        return where(func);
    }
    default <R> List<R> select(JFunc1<T, R> func) {
        return LinqUtils.select(values(), func);
    }
    default <R> List<R> map(JFunc1< T, R> func) {
        return select(func);
    }
    default T first(JFunc1<T, Boolean> func) {
        return LinqUtils.first(values(), func);
    }
    default T last(JFunc1<T, Boolean> func) {
        return LinqUtils.last(values(), func);
    }
    default void ifDo(JFunc1<T, Boolean> condition, JAction1<T> action) {
        LinqUtils.ifDo(values(), condition, action);
    }
    default <R> List<R> ifSelect(JFunc1<T, Boolean> condition, JFunc1<T, R> transform) {
        return LinqUtils.ifSelect(values(), condition, transform);
    }
    default void foreach(JAction1<T> action) {
        LinqUtils.foreach(values(), action);
    }
    default boolean any(JFunc1<T, Boolean> func) {
        return LinqUtils.any(values(), func);
    }
    default boolean all(JFunc1<T, Boolean> func) {
        return LinqUtils.all(values(), func);
    }
    default List<T> listCopy(int from) {
        return listCopy(from, values().size() - 1);
    }
    default List<T> listCopy(int from, int to) {
        return LinqUtils.listCopy(values(), from, to);
    }
    default <R> List<R> selectMany(JFunc1<T, List<R>> func) {
        return LinqUtils.selectMany(values(), func);
    }

    @Override
    default int size() {
        return values().size();
    }
    @JDIAction(level = DEBUG)
    default boolean isEmpty() {
        return values().isEmpty();
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
