package javalab6;

import java.util.*;

/**
 * Custom implementation of a generic collection that uses a singly linked list and implements the Set interface.
 *
 * @param <T> The type of elements stored in the collection.
 */
public class CustomSet<T> implements Set<T> {
    // Node class representing a single element in the singly linked list.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Head of the singly linked list.
    private int size;     // Size of the set.

    // Default constructor (empty collection).
    public CustomSet() {
        head = null;
        size = 0;
    }

    // Constructor accepting a single object.
    public CustomSet(T element) {
        this();
        add(element);
    }

    // Constructor accepting a standard collection.
    public CustomSet(Collection<? extends T> collection) {
        this();
        for (T element : collection) {
            add(element);
        }
    }

    @Override
    public boolean add(T element) {
        if (contains(element)) return false; // Avoid duplicates.
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;

        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !Objects.equals(current.next.data, o)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Object[] result = a;
        Node<T> current = head;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                remove(current.data);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    // For testing
    public static void main(String[] args) {
        CustomSet<Ball> customSet = new CustomSet<>();
        Ball ball1 = new Ball("Soccer Ball", 25.0, 8, "Leather");
        Ball ball2 = new Ball("Basketball", 30.0, 10, "Rubber");

        customSet.add(ball1);
        customSet.add(ball2);
        customSet.add(ball1); // Duplicate

        System.out.println("Custom Set Size: " + customSet.size());
        for (Ball ball : customSet) {
            ball.display();
        }
    }
}
