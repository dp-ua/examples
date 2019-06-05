package com.epam.webinar.task1;


public class Part2 {

    public static void main(String[] args) {
        Part2 work = new Part2();
//        System.out.printf("Input string: %s\n", work.arrayToString(args));
        System.out.printf("%s\n", work.arrayToString(work.reverseMassive(args)));
    }

    public String arrayToString(String[] input) {
        String result = "";
        for (String s : input) {
            result += s + " ";
        }
        return result.trim();
    }

    public String[] reverseMassive(String[] input) {
        String[] result = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            result[input.length - i - 1] = input[i];
        }
        return result;
    }
}
