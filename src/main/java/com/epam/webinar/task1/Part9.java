package com.epam.webinar.task1;

//Задание 9
//        -------------------------------------------------------
//        Название класса: com.epam.webinar.task1.Part9
//        -------------------------------------------------------
//
//        Создать класс, который выводит в консоль в возрастающем порядке все простые числа, не превышающие n.
//        Число n получать как параметр командной строки.
//        Числа должны быть выведены через пробел, вывод не должен заканчиваться пробельным символом.

import java.util.*;

public class Part9 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong input");
            return;
        }
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return;
        }
        if (n < 2) {
            System.out.println("Wrong input");
            return;
        }
        Part9 work = new Part9();
        int[] numbers = work.getPrimeNumbersLessTheNumber(n);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));

    }

    public int[] getPrimeNumbersLessTheNumber(int number) throws IllegalArgumentException {
        if (number < 2) throw new IllegalArgumentException("Number cant be less than 2");
        List<Integer> result = new ArrayList<>();

        boolean[] numbers = new boolean[number];
        Arrays.fill(numbers, true);
        Part5 part5 = new Part5();
        for (int i = 1; i < number; i++) {
            if (numbers[i]) {
                if (part5.isPrime(i + 1)) {
                    result.add(i + 1);
                    for (int j = i; j < number; j++) {
                        int k = (i + 1) * (j + 1) - 1;
                        if (k < number) numbers[k] = false;
                        else break;
                    }
                }
            }
        }
        return result.parallelStream().mapToInt(Integer::intValue).toArray();



    }

}
