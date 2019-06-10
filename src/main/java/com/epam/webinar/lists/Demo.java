package com.epam.webinar.lists;


import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        List<Integer> listOne = new OneWayList<>();
        List<Integer> listTwo = new MyLinkedList<>();
        Map<String, Long> time = new LinkedHashMap<>();

        time.put("Start", Calendar.getInstance().getTimeInMillis());

        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        System.out.println();
        time.put("made list", Calendar.getInstance().getTimeInMillis());
        listOne.addAll(list);
        time.put("add all to listOne", Calendar.getInstance().getTimeInMillis());
        listTwo.addAll(list);
        time.put("add all to listTwo", Calendar.getInstance().getTimeInMillis());

        int index = (list.size()/4) *3 ;

        int n2 = listTwo.get(index);
        time.put("get n2", Calendar.getInstance().getTimeInMillis());

//        int n1=0;
        int n1 = listOne.get(index);
        time.put("get n1", Calendar.getInstance().getTimeInMillis());

        Integer n = list.get(index);
        time.put("get from main list", Calendar.getInstance().getTimeInMillis());

        System.out.println("n=" + n+ " n1=" + n1 + " n2=" + n2);

        long t=0;
        for (Map.Entry<String, Long> pair : time.entrySet()) {
            if (t==0) t = pair.getValue();
            long spent = pair.getValue()-t;
            t=pair.getValue();
            System.out.println(pair.getKey() + " "  + pair.getValue() + (spent==0?"":" time: " + spent + "ms"));
        }

//        List<Integer> myList = new MyLinkedList<>();
//        myList.add(0);
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//        System.out.println("add 5 elements [0,1,2,3,4] : " + Arrays.toString(myList.toArray()));
//        System.out.println("get by index(3) must be 3: " + myList.get(3));
//        myList.add(0, 00);
//        System.out.println("add 0 to index(0) must be [0,0,1,2,3,4] : " + Arrays.toString(myList.toArray()));
//        myList.add(3, 22);
//        System.out.println("add 22 to index(3) must be [0,0,1,22,2,3,4] : " + Arrays.toString(myList.toArray()));
//        myList.add(7, 7);
//        System.out.println("add 7 to index(7) must be [0,0,1,22,2,3,4,7] : " + Arrays.toString(myList.toArray()));
//        myList.remove(0);
//        System.out.println("remove on index(0) must be [0,1,22,2,3,4,7] : " + Arrays.toString(myList.toArray()));
//        myList.remove(2);
//        System.out.println("remove on index(2) must be [0,1,2,3,4,7] : " + Arrays.toString(myList.toArray()));
//        myList.set(5, 5);
//        System.out.println("set 5 to index(5) must be [0,1,2,3,4,5] : " + Arrays.toString(myList.toArray()));
//        myList.set(0, -1);
//        System.out.println("set -1 to index(0) must be [-1,1,2,3,4,5] : " + Arrays.toString(myList.toArray()));
//
//        System.out.println("get indexOf 4 must be 4 : " + myList.indexOf(4));
//        myList.add(4);
//        System.out.println("add 4 must be [-1,1,2,3,4,5,4] : " + Arrays.toString(myList.toArray()));
//        myList.add(3);
//        System.out.println("get lastIndexOf 4 must be 6 : " + myList.lastIndexOf(4));
//        System.out.println("array: " + Arrays.toString(myList.toArray()));
//        System.out.println("get index 1: " + myList.get(1));
//        System.out.println("get index 5: " + myList.get(5));

    }
}
