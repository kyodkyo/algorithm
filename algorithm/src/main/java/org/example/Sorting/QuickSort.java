package org.example.Sorting;

import java.util.Scanner;

public class QuickSort {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int left, int right) {
        if (left <= right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    public static int partition(int left, int right) {
        int low = left;
        int high = right;

        int pivot = arr[right];
        while (low < high){
            while (arr[low] < pivot && low < high){
                low++;
            }
            while (arr[high] >= pivot && low < high){
                high--;
            }
            swap(low, high);
        }
        swap(high, right);
        return high;
    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
