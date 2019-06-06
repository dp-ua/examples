package com.epam.webinar.task1;

//Задание 9
//        -------------------------------------------------------
//        Название класса: com.epam.webinar.task1.Part9
//        -------------------------------------------------------
//
//        Создать класс, который выводит в консоль в возрастающем порядке все простые числа, не превышающие n.
//        Число n получать как параметр командной строки.
//        Числа должны быть выведены через пробел, вывод не должен заканчиваться пробельным символом.

import java.util.Arrays;

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
        if (n < 1) {
            System.out.println("Wrong input");
            return;
        }
        Part5 part5 = new Part5();
        int[] numbers = part5.getPrimeNumbers(n);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));

    }
}
