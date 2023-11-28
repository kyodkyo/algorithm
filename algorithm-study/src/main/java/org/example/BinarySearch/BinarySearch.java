package org.example.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(search(target));
    }

    public static int search(int target) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
