package com.epam.webinar.task1;

import java.util.Map;
import java.util.TreeMap;

//Задание 6
//        Название класса: com.epam.webinar.task1.Part6
//
//        1) Создать метод
//public static int nextPrime(int x)
//        ---------------------------
//        который возвращает ближайшее к x простое число, которое больше x.
//        Примеры: nextPrime(14) == 17; nextPrime(31) == 37; nextPrime(3) == 5
//
//        2) Класс Part6 должен выводить в консоль разложение натурального числа n на простые множители
//        (см. "Факторизация целых чисел", например, в Wikipedia).
//        Число n передавать как параметр командной строки.
//        Выводить в формате, который дан в примере ниже (множители должны следовать в порядке возрастания).
//        Вывод не должен заканчиваться пробельным символом.
//
//        Пример.
//        Параметр командной строки:
//        ---------------------------
//        360
//        ---------------------------
//        Вывод в консоль:
//        ---------------------------
//        360 = 2^3 * 3^2 * 5^1
//        ---------------------------
public class Part6 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong input");
            return;
        }
        int n=0;
        try {
            n = Integer.parseInt(args[0]);
        }catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return;
        }
        if (n < 1) {
            System.out.println("Wrong input");
            return;
        }
        Part6 work = new Part6();
        System.out.println(work.map2FactString(work.getPrimeMultiply(n)));

    }

    private String map2FactString(Map<Integer, Integer> map) {
        String result = "";
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getKey() + "^" + entry.getValue() + " * ";
        }

        return result.substring(0, result.length() - 3);
    }

    public Map<Integer, Integer> getPrimeMultiply(int number) {
        int op = number;
        Map<Integer, Integer> map = new TreeMap<>();

        while (op > 1) {
            for (int i = 2; i <= op; i = nextPrime(i)) {
                if (op % i == 0) {
                    op /= i;
                    if (map.containsKey(i)) map.put(i, map.get(i) + 1);
                    else map.put(i, 1);
                    break;
                }
            }
        }
        return map;
    }

    public int nextPrime(int x) {
        Part5 prime = new Part5();

        for (int i = x + 1; i < Integer.MAX_VALUE; i++) {
            if (prime.isPrime(i)) return i;
        }
        throw new ArithmeticException("Cant find prime number");
    }
}
