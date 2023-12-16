package org.example;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution("BAB"));

    }
    public static int solution(String name) {
        int answer = 0;

        int min = 0;
        for(int i=0; i<name.length(); i++){
            char temp = name.charAt(i);
            answer += Math.min(temp - 'A', 'Z' - temp + 1);

            int j = i+1;
            while(j < name.length() && name.charAt(j) == 'A'){
                j++;
            }

            int t = Math.min(2*i + (name.length()-j), 2*(name.length()-j) + i);
            min = Math.min(name.length()-1, t);
        }

        answer += min;
        return answer;
    }
}