package com.epam.webinar.task1;

//Задание 8
//        -------------------------------------------------------
//        Название класса: com.epam.webinar.task1.Part8
//        -------------------------------------------------------
//
//        1) Создать метод
//        ---------------------------
//public static int[][] pascal(int n)
//        ---------------------------
//        который возвращает двумерный массив "треугольной структуры", содержащий треугольник Паскаля.
//        Параметр n задает число строк треугольника (n > 0).
//        Пример содержимого массива при n=5:
//        -------------
//        1
//        11
//        121
//        1331
//        14641
//        -------------
//
//        2) В методе Part8.main(String[]):
//        a) получить n как параметр командной строки;
//        b) получить с помощью вызова метода pascal(n) массив с треугольником Паскаля;
//        c) распечатать содержимое аналогично следующему виду:
//        -------------
//        1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1
//        -------------
//        Пример вывода дан для n=5, отступ между соседними числами должен быть 1 пробел.
//        Каждая строка не должна оканчиваться пробельным символом.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part8 {

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
        Part8 work = new Part8();
        int[][] triangle = work.pascal(n);
        System.out.println(work.getStringForPrintTriangle(triangle));
    }

    private String getStringForPrintTriangle(int[][] triangle) {
        StringBuilder result = new StringBuilder();
        int maxLen = getStringFromIntArray(triangle[triangle.length - 1]).length();
        for (int[] line : triangle) {
            String s = getStringFromIntArray(line);
            int spaceCount = (maxLen - s.length()) / 2;
            for (int i = 0; i < spaceCount; i++) result.append(" ");
            result.append(s).append("\n");
        }
        return result.toString();
    }

    private String getStringFromIntArray(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    public int[][] pascal(int n) {
        List<int[]> list = new ArrayList<>();
        if (n <= 0) throw new IllegalArgumentException("Wrong argument. Need n>0");

        for (int i = 1; i <= n; i++) {
            int[] line = new int[i];
            if (i == 1) {
                line[0] = 1;
                list.add(line);
                continue;
            }
            if (i == 2) {
                line[0] = 1;
                line[1] = 1;
                list.add(line);
                continue;
            }

            int[] prev = list.get(list.size() - 1);
            line[0] = 1;
            line[line.length - 1] = 1;
            for (int j = 0; j < prev.length - 1; j++) {
                line[j + 1] = prev[j] + prev[j + 1];
            }
            list.add(line);

        }
        int[][] result = new int[n][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
