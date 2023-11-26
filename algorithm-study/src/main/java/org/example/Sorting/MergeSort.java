package org.example.Sorting;

import java.util.Scanner;

public class MergeSort {

    static int[] arr;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int[] sorted = new int[right - left + 1];
        int i = left;
        int j = mid + 1;

        int idx = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[idx] = arr[i];
                idx++;
                i++;
            } else {
                sorted[idx] = arr[j];
                idx++;
                j++;
            }
        }

        while (i <= mid) {
            sorted[idx] = arr[i];
            idx++;
            i++;
        }

        while (j <= right) {
            sorted[idx] = arr[j];
            idx++;
            j++;
        }

        for (int k = 0; k < idx; k++) {
            arr[left++] = sorted[k];
        }
    }
}
