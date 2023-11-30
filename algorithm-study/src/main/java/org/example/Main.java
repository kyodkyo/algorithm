package org.example;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;



public class Main {

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
        // 여기에 코드를 작성해주세요.
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
            System.out.printf("%s %d %.1f", i.name, i.height, i.weight);
        }

        Arrays.sort(infos, new Comparator<Info>(){
            @Override
            public int compare(Info a, Info b){
                return a.height - b.height;
            }
        });
        System.out.println("height");
        for(Info i : infos){
            System.out.printf("%s %d %.1f", i.name, i.height, i.weight);
        }
    }
}