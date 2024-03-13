import java.util.*;
import java.io.*;

/*
 * 모든 매개변수를 완전탐색 하지말 이분탐색으로 줄이자.
 */
public class Main {
    public static int N, K;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        K = read(); // 랜선의 수
        N = read(); // 랜선으 ㅣ길이
        long ans = 0;

        arr = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] =  read();
        }

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    public static long binarySearch(){
        long s = 1;
        long e = Integer.MAX_VALUE;
        long ans = 0;

        while(s<=e) {
            long mid = (s + e) / 2;
            long now = 0;
            for(int i = 0; i < K; i++){
                now += arr[i]/mid;
            }
            if(now >= N){
                s = mid + 1;
                ans = mid;
            }
            else{
                e = mid -1;
            }
        }
        return ans;
    }




    public static int read() throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    return isNegative ? -n : n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }

}