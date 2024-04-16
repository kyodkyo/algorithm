import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(Integer.parseInt(input[i]));

        int[] countArr = new int[100001];
        int result = 0, lPoint = 0, rPoint = -1;
        for(int i=0; i<n; i++){
            int num = list.get(i);

            while(k <= countArr[num] && lPoint < rPoint){
                countArr[list.get(lPoint)]--;
                lPoint++;
            }
            countArr[num]++;
            rPoint++;
            result = Math.max(rPoint-lPoint+1, result);
        }
        System.out.println(result);
    }
}