package com.epam.webinar.task1;


public class Part3 {

    public static void main(String[] args) {
        Part3 work = new Part3();
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.printf("%d %d", work.getMaxDivider(a, b), work.getMinMultiply(a, b));
        }catch (Exception e) {
            System.out.println("Wrong arguments. Check input");
        }
    }

    public int getMinMultiply(int a, int b){
        int maxDiv = getMaxDivider(a,b);
        return (a*b)/maxDiv;
    }

    public int getMaxDivider(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (max % min != 0) {
            int c = max % min;
            max = min;
            min = c;
        }
        return min;
    }
}
