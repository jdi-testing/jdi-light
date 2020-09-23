package com.epam.jdi.light.logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FixedQueue<T> {
    private Queue<T> queue;
    private int limit;

    public FixedQueue(int limit) {
        if (limit < 1)
            throw new RuntimeException("FixedQueue init failed. Limit should be more than 0, but " + limit);
        this.limit = limit;
        queue = new LinkedList<>();
    }
    public void push(T element) {
        if (queue.size() >= limit) {
            queue.remove();
        }
        queue.add(element);
    }
    public List<T> values() {
        return queue.stream().collect(Collectors.toList());
    }
    public void clear() {
        queue.clear();
    }
    public int size() {
        return queue.size();
    }
    public T peek() {
        T element = queue.peek();
        queue.remove();
        return element;
    }
    public T observe() {
        return queue.peek();
    }
}
