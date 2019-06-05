package com.epam.webinar.task1;


import org.apache.catalina.LifecycleState;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part5 {

    public static void main(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            int[] numbers = getPrimeNumbers(number);
            System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));

        }   catch (Exception e) {
            System.out.println("Error. Cant calculate. " + e.getMessage());
        }

    }

    public static boolean isPrime(int n) {
        //    который возвращает true, если число n простое; false в противном случае.
        int sqrt = (int) Math.sqrt(n);
        int i = 2;
        while (i <= sqrt) {
            int rem = n % i;
            if (rem == 0) return false;
            i++;
        }
        return true;

    }


    public static int[] getPrimeNumbers(int n) {
        //    который возвращает массив из n элементов, заполненный восходящим рядом простых чисел (2, 3, 5, 7, ...).
        List<Integer> result = new ArrayList<>();

        boolean[] numbers = new boolean[n];
        Arrays.fill(numbers, true);

        for (int i = 1; i < n; i++) {
            if (numbers[i]) {
                if (isPrime(i+1)) {
                    result.add(i+1);
                    for (int j = i; j <n ; j++) {
                        int k = (i+1) * (j+1)-1;
                        if (k<n) numbers[k]=false;
                        else break;
                    }
                }
            }
        }
        return  result.parallelStream().mapToInt(Integer::intValue).toArray();
    }
//---------------------------

//
//            3) В методе Part5.main(String[]):
//    a) получить n как параметр командной строки;
//    b) получить с помощью вызова метода getPrimeNumbers массив из n элементов;
//    c) распечатать элементы массива через пробел в консоль.
//    Вывод не должен заканчиваться пробельным символом.

}
