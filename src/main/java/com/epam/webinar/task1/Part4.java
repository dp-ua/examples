package com.epam.webinar.task1;


public class Part4 {

    public static void main(String[] args) {
        Part4 work = new Part4();

        System.out.println(work.getSummDigits(args));
    }

    public int getSummDigits(String[] input) {
        int summ = 0;
        for (String s : input) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c))
                    summ += Character.getNumericValue(c);
            }
        }
        return summ;
    }
}
