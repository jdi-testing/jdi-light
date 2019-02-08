package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface IList2<T> extends HasValue {
    /**
     *  Get all application elements
     *  */
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
    default void refresh() { clear(); }
    void clear();
    default List<T> slice(int from, int to) {
        return LinqUtils.listCopy(elements(), from, to);
    }
    default <R> List<R> selectMany(JFunc1<T, List<R>> func) {
        return LinqUtils.selectMany(elements(), func);
    }
    default int size() {
        return elements().size();
    }
    default boolean isEmpty() {
        return elements().isEmpty();
    }
    default boolean any() { return !isEmpty(); }

    // List methods
    default boolean contains(Object o) {
        return elements().contains(o);
    }

    default Iterator<T> iterator() {
        return elements().iterator();
    }
    default Object[] toArray() {
        return elements().toArray();
    }
    default <T1> T1[] toArray(T1[] a) {
        return elements().toArray(a);
    }
    default boolean add(T t) {
        throw new NotImplementedException();
    }
    default boolean remove(Object o) {
        throw new NotImplementedException();
    }
    default boolean containsAll(Collection<?> c) {
        return elements().containsAll(c);
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
    default T get(int index) {
        return elements().get(index);
    }
    default T set(int index, T element) {
        throw new NotImplementedException();
    }
    default void add(int index, T element) {
        throw new NotImplementedException();
    }
    default T remove(int index) {
        return elements().remove(index);
    }
    default int indexOf(Object o) {
        return elements().indexOf(o);
    }
    default int lastIndexOf(Object o) {
        return elements().lastIndexOf(o);
    }
    default ListIterator<T> listIterator() {
        return elements().listIterator();
    }
    default ListIterator<T> listIterator(int index) {
        return elements().listIterator(index);
    }
    default List<T> subList(int fromIndex, int toIndex) {
        return slice(fromIndex, toIndex);
    }
}
