package org.example.Sorting;

/**
 * 객체 정렬
 *
 * <방법 1>
 *     : 객체 클래스 생성 시 Comparable<T>를 implements
 *
 *  @Override compareTo()
 *
 *  class A implements Comparable<A>{
 *     int index;
 *     String name;
 *
 *     @Override
 *     public int compareTo(A a){
 *         return this.index - a.index; //오름차순
 *         return a.index - this.index; //내림차순
 *         return this.name.compareTo(a.name)
 *     }
 *  }
 *  => Arrays.sort()로 사용
 *
 *
 *  <방법 2>
 *      : lambda 사용
 *
 *     Arrays.sort(배열명, (a, b) -> a.index - b.index);
 *
 *
 *  <방법 3>
 *      : custom comparator 사용
 *
 *    Arrays.sort(배열명, new Comparator<A>() {
 *          @Override
 *          public int compare(A a, A b) {
 *              return a.index - b.index;
 *          }
 *     });
 *
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class ETC {

    static class Info{
        String name;
        int height;
        Double weight;

        public Info(String name, int height, Double weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Info[] infos = new Info[5];
        for(int i=0; i<5; i++){
            infos[i] = new Info(sc.next(), sc.nextInt(), sc.nextDouble());
        }

        Arrays.sort(infos, new Comparator<Info>(){
            @Override
            public int compare(Info a, Info b){
                return a.name.compareTo(b.name);
            }
        });
        System.out.println("name");
        for(Info i : infos){
            System.out.printf("%s %d %.1f\n", i.name, i.height, i.weight);
        }

        Arrays.sort(infos, new Comparator<Info>(){
            @Override
            public int compare(Info a, Info b){
                return b.height - a.height;
            }
        });
        System.out.println("\nheight");
        for(Info i : infos){
            System.out.printf("%s %d %.1f\n", i.name, i.height, i.weight);
        }
    }
}
