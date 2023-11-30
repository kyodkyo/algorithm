package org.example.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * ListIterator<T> it = new ListIterator<>();
 *
 * hasPrevious() / hasNext()
 * previous() / next() -> iterator 위치 이동 및 노드 반환
 * add()
 * remove()
 */

public class Iterator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        LinkedList<Character> list = new LinkedList<>();
        String input = sc.next();
        for(int i=0; i<n; i++){
            list.add(input.charAt(i));
        }

        ListIterator<Character> it = list.listIterator(list.size());
        for(int i=0; i<m; i++){
            String s = sc.next();
            if (s.equals("L")){
                if (it.hasPrevious())
                    it.previous();
            }
            else if (s.equals("R")){
                if (it.hasNext())
                    it.next();
            }
            else if (s.equals("D")){
                if (it.hasNext()){
                    it.next();
                    it.remove();
                }
            }
            else if (s.equals("P")){
                it.add(sc.next().charAt(0));
            }
        }

        it = list.listIterator();
        while(it.hasNext())
            System.out.print(it.next());
    }
}
