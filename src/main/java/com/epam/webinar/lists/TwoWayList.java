package com.epam.webinar.lists;


import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoWayList<T> extends AbstractList<T> {
    private Node head;
    private Node tail;
    private int count;


    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * <p>This implementation calls {@code removeRange(0, size())}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless {@code remove(int
     * index)} or {@code removeRange(int fromIndex, int toIndex)} is
     * overridden.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
     */
    public void clear() {
        count = 0;
        head = null;
        tail = null;
    }

    //done
    public T set(int index, T obj) {
        if (index < 0 || index > count - 1) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);

        Node oldNode = getInternal(index);
        T result = oldNode.getObj();
        oldNode.setObj(obj);

        return result;
    }

    //done
    public T remove(int index) {
        if (index < 0 || index > count - 1) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        Node removeNode = getInternal(index);
        if (index == 0) {
            head = head.getNext();
            head.setBefore(null);
        } else if (index == count - 1) {
            tail = tail.getBefore();
            tail.setNext(null);
        } else {
            removeNode.getBefore().setNext(removeNode.getNext());
            removeNode.getNext().setBefore(removeNode.getBefore());
        }
        count--;
        return removeNode.getObj();
    }

    //done
    public void add(int index, T obj) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        Node newNode = new Node(obj);
        if (index == 0) {
            head.setBefore(newNode);
            newNode.setNext(head);
            head = newNode;

        } else if (index == count) {
            tail.setNext(newNode);
            newNode.setBefore(tail);
            tail = newNode;
        } else {
            Node oldNode = getInternal(index);
            newNode.setNext(oldNode);
            newNode.setBefore(oldNode.getBefore());

            oldNode.getBefore().setNext(newNode);
            oldNode.setBefore(newNode);
        }
        count++;
    }

    public T get(int index) {
        if (index < 0 || index > count - 1) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        Node node = getInternal(index);
        return node.getObj();
    }

    private Node getNodeByIndexFromHead(int index) {
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    private Node getNodeByIndexFromTail(int index) {
        Node node = tail;

        for (int i = count - 1; i > index; i--) {
            node = node.getBefore();
        }
        return node;
    }


    private Node getInternal(int index) {
        Node node;
        if (index <= count / 2) node = getNodeByIndexFromHead(index);
        else node = getNodeByIndexFromTail(index);
        return node;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node current;

        public MyIterator() {
            current = TwoWayList.this.head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return !(current == null);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T result = current.getObj();
            current = current.getNext();
            return result;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns a string representation of this collection.  The string
     * representation consists of a list of the collection's elements in the
     * order they are returned by its iterator, enclosed in square brackets
     * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
     * <tt>", "</tt> (comma and space).  Elements are converted to strings as
     * by {@link String#valueOf(Object)}.
     *
     * @return a string representation of this collection
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    //done
    public int size() {
        return count;
    }

    //done
    public TwoWayList() {
        count = 0;
        head = null;
        tail = null;
    }

    //done
    public boolean add(T obj) {
        Node addNode = new Node(obj);
        if (head == null) {
            head = addNode;
            tail = head;
            count = 1;
        } else {
            addNode.setBefore(tail);
            tail.setNext(addNode);
            tail = addNode;
            count++;
        }

        return true;
    }

    //done
    public T[] toArray() {
        if (count == 0) return null;
        T[] array = (T[]) new Object[count];
        int c = 1;
        Node node = head;
        array[0] = head.getObj();
        while (node.hasNext()) {
            node = node.getNext();
            array[c] = node.getObj();
            c++;
        }
        return array;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        T obj;
        Node next;
        Node before;

        public Node getBefore() {
            return before;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        @Override
        public String toString() {
            return "obj: " + obj.toString() + ", before: " + hasBefore() + ", next: " + hasNext();
        }

        public Node(T obj) {
            this.obj = obj;
            next = null;
            before = null;
        }

        public boolean hasBefore() {
            return !(before == null);
        }

        public boolean hasNext() {
            return !(next == null);
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
