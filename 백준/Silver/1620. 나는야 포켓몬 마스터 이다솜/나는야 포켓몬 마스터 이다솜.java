import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<Integer, String> stringMap = new HashMap<>();
        HashMap<String, Integer> numMap = new HashMap<>();
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            stringMap.put(i, s);
            numMap.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String key = br.readLine();
            if ('A' <= key.charAt(0) && key.charAt(0) <= 'Z')
                sb.append(numMap.get(key) + "\n");
            else
                sb.append(stringMap.get(Integer.parseInt(key)) + "\n");
        }
        System.out.println(sb);
    }
}