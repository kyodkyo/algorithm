package org.example.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Stack
 * LIFO(Last In First Out)의 구조, 데이터를 넣고 빼는 곳의 위치가 하나
 * 쌍을 이루고 있는 것들이 올바르게 배치되어 있는지 확인할 때 유용하게 사용
 *
 *
 * import java.util.Stack;
 * Stack<T> stack = new Stack<>();
 * (T는 반드시 Reference Type)
 *
 *
 * push(x)
 * size()
 * isEmpty()
 * peek()    // 값만 반환
 * pop()    // 값 반환 & 값 제거
 */
public class StackA {
    //괄호 문자열 확인하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                s.push('(');
            else if (str.charAt(i) == ')')
                if (!s.isEmpty() && s.peek() == '(')
                    s.pop();
                else {
                    System.out.println("No");
                    System.exit(0);
                }
        }

        if (s.isEmpty())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
