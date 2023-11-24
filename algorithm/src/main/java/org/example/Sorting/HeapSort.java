package org.example.Sorting;

import java.util.Scanner;

public class HeapSort {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        heapSort(n);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void heapSort(int n) {
        // max-heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // sorting
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    public static void heapify(int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
