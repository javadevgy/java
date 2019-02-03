package com.java.basics.arrays;

import java.util.Arrays;

public class SettingArrayElements {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Arrays.parallelSetAll(numbers, x -> 2 * x);
        System.out.println(Arrays.toString(numbers));
        long[][] a1 = new long[3][4];
        Arrays.parallelSetAll(a1, x -> {
            long[] result = new long[x + 2];
            Arrays.parallelSetAll(result, y -> y + 1);
            return result;
        });
        System.out.printf("\n%s\n", Arrays.deepToString(a1));
    }

}
