import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, m;
    static int[] values;
    static String[] names;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        values = new int[n];
        names = new String[n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            names[i] = line[0];
            values[i] = Integer.parseInt(line[1]);
        }

        for(int i=0; i<m; i++)
            searchLevel(Integer.parseInt(br.readLine()));
        System.out.println(sb);
    }

    public static void searchLevel(int cur){
        int left = 0;
        int right = n-1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (values[mid] < cur)
                left = mid + 1;
            else
                right = mid - 1;
        }
        sb.append(names[left] + "\n");
    }
}