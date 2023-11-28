package org.example.Recursive;

import java.util.Scanner;

public class RecursiveLCM {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(recursive(n-1));
    }

    public static int recursive(int n){
        if (n==0)
            return arr[0];
        return getLCM(arr[n], recursive(n-1));
    }

    public static int getLCM(int a, int b){
        int gcd = 1;
        for(int i=1; i<= Math.min(a, b); i++){
            if (a%i==0 && b%i==0)
                gcd = i;
        }
        return a*b / gcd;
    }
}