import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(",");
            for(String s : line)
                hashSet.remove(s);
            sb.append(hashSet.size() + "\n");
        }
        System.out.println(sb);
    }
}