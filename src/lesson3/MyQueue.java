package lesson3;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //0 1 2 3 4
    //        B
    //    E
    //1 5     8

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }

        return list[begin];
    }

    public void insert(T item) {
        ensureCapacity(size+1);

        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
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
        if (minCapacity < 0) throw new IllegalStateException("Illegal capacity");
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
