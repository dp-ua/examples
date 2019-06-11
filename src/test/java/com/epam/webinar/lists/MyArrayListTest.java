package com.epam.webinar.lists;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListTest {

    List<Integer> list = new MyArrayList<>();
    List<Integer> normalList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        normalList.addAll(list);
    }

    @org.junit.jupiter.api.Test
    void set() {
        list.set(0, 100);
        normalList.set(0, 100);
        assertArrayEquals(normalList.toArray(), list.toArray());
        list.set(2, 200);
        normalList.set(2, 200);
        assertArrayEquals(normalList.toArray(), list.toArray());
        list.set(normalList.size()-1, 1000);
        normalList.set(normalList.size()-1, 1000);
        assertArrayEquals(normalList.toArray(), list.toArray());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        list.remove(0);
        normalList.remove(0);
        assertArrayEquals(normalList.toArray(), list.toArray());

        list.remove(normalList.size() - 1);
        normalList.remove(normalList.size() - 1);
        assertArrayEquals(normalList.toArray(), list.toArray());

        list.remove(5);
        normalList.remove(5);
        assertArrayEquals(normalList.toArray(), list.toArray());

        Integer obj = new Integer(5);
        list.remove(obj);
        normalList.remove(obj);
        assertArrayEquals(normalList.toArray(), list.toArray());

    }

    @org.junit.jupiter.api.Test
    void add() {
        list.add(10);
        normalList.add(10);
        assertArrayEquals(normalList.toArray(), list.toArray());
        list.add(0,-1);
        normalList.add(0,-1);
        assertArrayEquals(normalList.toArray(), list.toArray());
        list.add(3,3);
        normalList.add(3,3);
        assertArrayEquals(normalList.toArray(), list.toArray());

    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(normalList.get(1), list.get(1));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(normalList.size(), list.size());
    }

    @org.junit.jupiter.api.Test
    void add1() {
        List<Integer> add = new ArrayList<>();
        add.add(12);
        add.add(13);
        add.add(14);
        list.addAll(add);
        normalList.addAll(add);
        assertArrayEquals(normalList.toArray(), list.toArray());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(false, list.isEmpty());
        list.clear();
        assertEquals(true, list.isEmpty());
    }
}