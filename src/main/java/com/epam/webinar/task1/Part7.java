package com.epam.webinar.task1;
//Задание 7
//        Создать класс, который находит среди первых n простых чисел количество тех из них, которые имеют максимальную сумму цифр.
//        Найденное значение вывести в консоль, через пробел напечатать саму сумму.
//        Чило n получать как параметр командной строки.
//
//        Пример.
//        Параметр командной строки:
//        ---------------------------
//        15
//        ---------------------------
//        Вывод в консоль:
//        ---------------------------
//        11 2
//        ---------------------------
//        Пояснение: первые 15 простых чисел представляют из себя ряд
//        ---------------------------
//        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
//        ---------------------------
//        среди них максимальную сумму цифр (11) имеют два числа 29 и 47


public class Part7 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong input.");
            return;
        }
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Arguments is not a number. Check input");
            return;
        }
        if (n < 2) {
            System.out.println("Wrong input. Number must be more than 1");
            return;
        }
        int count = 1;
        int max = 0;
        int prime = 2;

        Part6 part6 = new Part6();
        Part7 work = new Part7();
        for (int i = 0; i < n; i++) {
            int summ = work.summDigitsInNumber(prime);
            if (summ > max) {
                count = 1;
                max = summ;
            } else if (summ == max) count++;
            prime = part6.nextPrime(prime);
        }
        System.out.println(max + " " + count);

    }

    public int summDigitsInNumber(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        int summ = 0;
        for (char c : chars) {
            summ += Character.getNumericValue(c);
        }
        return summ;
    }


}
