package org.example.Sorting;

import java.util.Scanner;
import java.util.ArrayList;

public class RadixSort {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        radixSort();

        for (int num : arr)
            System.out.print(num + " ");
    }

    public static void radixSort() {
        int p = 1;

        for (int current = 0; current < 6; current++) {
            ArrayList<Integer>[] radix_arr = new ArrayList[10];
            for (int i = 0; i < 10; i++)
                radix_arr[i] = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                int digit = (arr[i] / p) % 10;
                radix_arr[digit].add(arr[i]);
            }

            int index = 0;
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < radix_arr[i].size(); j++)
                    arr[index++] = radix_arr[i].get(j);

            p *= 10;
        }
    }
}