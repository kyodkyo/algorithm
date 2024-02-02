package org.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,3,0,1,1};
        int[] result = solution(arr);

        for(int i=0; i<result.length; i++)
            System.out.print(result[i] + " ");
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if (i==0 || stack.peek() != arr[i])
                stack.push(arr[i]);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}