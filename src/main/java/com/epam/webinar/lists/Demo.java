package com.epam.webinar.lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


        List<Integer> oneWayList = new OneWayList<>();
        oneWayList.add(0);
        oneWayList.add(1);
        oneWayList.add(2);
        oneWayList.add(3);
        oneWayList.add(4);
        System.out.println("must be [0,1,2,3,4] : " + Arrays.toString(oneWayList.toArray()));
        System.out.println("must be 3: " + oneWayList.get(3));
        oneWayList.add(0,00);
        System.out.println("must be [00,0,1,2,3,4] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.add(3,22);
        System.out.println("must be [00,0,1,22,2,3,4] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.add(7,7);
        System.out.println("must be [00,0,1,22,2,3,4,7] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.remove(0);
        System.out.println("must be [0,1,22,2,3,4,7] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.remove(2);
        System.out.println("must be [0,1,2,3,4,7] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.set(5,5);
        System.out.println("must be [0,1,2,3,4,5] : " + Arrays.toString(oneWayList.toArray()));
        oneWayList.set(0,00);
        System.out.println("must be [00,1,2,3,4,5] : " + Arrays.toString(oneWayList.toArray()));

        System.out.println("must be 4 : " + oneWayList.indexOf(4));
        oneWayList.add(4);
        System.out.println("must be 6 : " + oneWayList.lastIndexOf(4));
    }
}
