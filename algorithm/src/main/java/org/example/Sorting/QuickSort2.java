package org.example.Sorting;

import java.util.Scanner;

public class QuickSort2 {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(0, n - 1);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int left, int right) {
        if (left < right) {
            int pos = partition(left, right);
            quickSort(left, pos - 1);
            quickSort(pos + 1, right);
        }
    }

    public static int partition(int left, int right) {
        int pivot = arr[right];

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        i += 1;
        swap(i, right);
        return i;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
