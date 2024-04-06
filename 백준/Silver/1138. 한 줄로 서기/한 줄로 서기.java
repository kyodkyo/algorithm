import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] leftCnt = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            leftCnt[i] = Integer.parseInt(s[i]);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n-1; i>=0; i--)
            list.add(leftCnt[i], i+1);

        for(int k : list)
            System.out.print(k + " ");
    }
}