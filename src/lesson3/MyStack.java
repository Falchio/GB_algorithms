package lesson3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void push(T item) {
        ensureCapacity(size+1);
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) throw new IllegalStateException("Illegal min capacity");
        if (minCapacity <= size) return;

        int newCapacity = (int) (minCapacity * 1.5 + 1);
        copyElements(newCapacity);
    }

    private void copyElements(int newCapacity) {
        T[] temp = (T[]) new Object[newCapacity];
        int startPosition = 0;
        System.arraycopy(list,startPosition, temp,startPosition,size);
        list = temp;
    }
}
