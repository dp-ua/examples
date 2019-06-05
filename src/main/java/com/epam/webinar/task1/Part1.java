package com.epam.webinar.task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    private final String MISSING = "Command line arguments missing. Check input";
    private final String WRONG = "Not a number in command line arguments. Check input";


    public static void main(String[] args) {
        Part1 work = new Part1();

        List<Double> workList;
//        System.out.printf("Input line: %s\n", Arrays.toString(args));
        try {
            workList = work.parse(args,false);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
//        System.out.printf("Numbers in input: %s\n", workList.toString());
        System.out.printf("%.2f\n", work.summList(workList));
    }



    public List<Double> parse(String[] input,boolean ignoreWrongArguments) throws IllegalArgumentException {
        List<Double> result = new ArrayList<>();
        if (input.length < 2) throw new IllegalArgumentException(MISSING);

        for (String s : input) {
            try {
                double d = Double.parseDouble(s);
                result.add(d);
            } catch (NumberFormatException e) {
                if (!ignoreWrongArguments) throw new IllegalArgumentException(WRONG);
            }

        }
        return result;
    }

    public double summList(List<Double> list) {
        double summ = 0;
        for (double d : list) {
            summ += d;
        }
        return summ;
    }
}
