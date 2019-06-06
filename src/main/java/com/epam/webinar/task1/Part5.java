package com.epam.webinar.task1;


import java.util.Arrays;

public class Part5 {
    // 3) В методе Part5.main(String[]):
//    a) получить n как параметр командной строки;
//    b) получить с помощью вызова метода getPrimeNumbers массив из n элементов;
//    c) распечатать элементы массива через пробел в консоль.
// Вывод не должен заканчиваться пробельным символом.
    public static void main(String[] args) {
        Part5 work = new Part5();

        if (args.length != 1) System.out.println("Wrong arguments. Check input");
        try {
            int number = Integer.parseInt(args[0]);
            int[] numbers = work.getPrimeNumbers(number);
            System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));

        } catch (NumberFormatException e) {
            System.out.println("Error. Not a INT number in argument. Check input ");
        }

    }

    public boolean isPrime(int n) {
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


    public int[] getPrimeNumbers(int n) {
        //    который возвращает массив из n элементов, заполненный восходящим рядом простых чисел (2, 3, 5, 7, ...).
        if (n < 1) throw new IllegalArgumentException("Number cant be less than 1");
        int numbers[] = new int[n];
        int number = 2;
        int count = 1;
        while (count <= n) {
            if (isPrime(number)) {
                numbers[count - 1] = number;
                count++;
            }
            number++;
        }
        return numbers;
    }
}
