import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i<n; i++)
            hashSet.add(br.readLine());

        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            String name = br.readLine();
            if (hashSet.contains(name))
                result.add(name);
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size() + "\n");
        for(String s : result)
            sb.append(s + "\n");
        System.out.println(sb);
    }
}