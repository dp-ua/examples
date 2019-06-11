package com.epam.webinar.lists;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoWayListTest {

    List<Integer> list = new TwoWayList<>();
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
    }

    @org.junit.jupiter.api.Test
    void remove() {
        list.remove(5);
        normalList.remove(5);
        assertArrayEquals(normalList.toArray(), list.toArray());
    }

    @org.junit.jupiter.api.Test
    void add() {
        list.add(10);
        normalList.add(10);
        assertArrayEquals(normalList.toArray(), list.toArray());

    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(normalList.get(1),list.get(1));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(normalList.size(),list.size());
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
        assertEquals(false,list.isEmpty());
        list.clear();
        assertEquals(true,list.isEmpty());
    }
}