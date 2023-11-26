package org.example.Sorting;

import java.util.Scanner;

public class InsertionSort {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort();

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort() {
        int key;
        int j;

        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
