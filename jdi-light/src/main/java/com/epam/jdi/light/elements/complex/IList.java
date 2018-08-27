package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.IHasValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public interface IList<T> extends List<T>, IHasValue {
    /**
     *  Get all application elements
    @JDIAction(level = DEBUG)
    MapArray<String, T> getMap();*/
    @JDIAction(level = DEBUG)
    List<T> elements();
    default T last() {
        return elements().get(size()-1);
    }
    default T first() {
        return elements().get(0);
    }
    default List<T> where(JFunc1<T, Boolean> condition) {
        return LinqUtils.where(elements(),condition);
    }
    default List<T> filter(JFunc1<T, Boolean> condition) {
        return where(condition);
    }
    default <R> List<R> select(JFunc1<T, R> transform) {
        return LinqUtils.select(elements(), transform);
    }
    default <R> List<R> map(JFunc1<T, R> transform) {
        return select(transform);
    }
    default T first(JFunc1<T, Boolean> condition) {
        return LinqUtils.first(elements(), condition);
    }
    default T last(JFunc1<T, Boolean> condition) {
        return LinqUtils.last(elements(), condition);
    }
    default void ifDo(JFunc1<T, Boolean> condition, JAction1<T> action) {
        LinqUtils.ifDo(elements(), condition, action);
    }
    default <R> List<R> ifSelect(JFunc1<T, Boolean> condition, JFunc1<T, R> transform) {
        return LinqUtils.ifSelect(elements(), condition, transform);
    }
    default void foreach(JAction1<T> action) {
        LinqUtils.foreach(elements(), action);
    }
    default boolean any(JFunc1<T, Boolean> condition) {
        return LinqUtils.any(elements(), condition);
    }
    default boolean all(JFunc1<T, Boolean> condition) {
        return LinqUtils.all(elements(), condition);
    }
    default List<T> slice(int from) {
        return slice(from, elements().size() - 1);
    }
    default List<T> slice(int from, int to) {
        return LinqUtils.listCopy(elements(), from, to);
    }
    default <R> List<R> selectMany(JFunc1<T, List<R>> func) {
        return LinqUtils.selectMany(elements(), func);
    }

    @Override
    default int size() {
        return elements().size();
    }
    @JDIAction(level = DEBUG)
    default boolean isEmpty() {
        return elements().isEmpty();
    }
    @JDIAction(level = DEBUG)
    default boolean any() { return !isEmpty(); }

    // List methods
    @Override
    default boolean contains(Object o) {
        return elements().contains(o);
    }
    @Override
    default Iterator<T> iterator() {
        return elements().iterator();
    }
    @Override
    default Object[] toArray() {
        return elements().toArray();
    }
    @Override
    default <T1> T1[] toArray(T1[] a) {
        return elements().toArray(a);
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
        return elements().containsAll(c);
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
    default void clear() { throw new NotImplementedException(); }
    @Override
    @JDIAction(level = DEBUG)
    default T get(int index) {
        return elements().get(index);
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
        return elements().remove(index);
    }
    @Override
    default int indexOf(Object o) {
        return elements().indexOf(o);
    }
    @Override
    default int lastIndexOf(Object o) {
        return elements().lastIndexOf(o);
    }
    @Override
    default ListIterator<T> listIterator() {
        return elements().listIterator();
    }
    @Override
    default ListIterator<T> listIterator(int index) {
        return elements().listIterator(index);
    }
    @Override
    default List<T> subList(int fromIndex, int toIndex) {
        return slice(fromIndex, toIndex);
    }
}
