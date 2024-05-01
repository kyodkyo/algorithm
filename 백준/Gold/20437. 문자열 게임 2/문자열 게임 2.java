import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-->0){
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            
            if (k == 1){
                sb.append("1 1\n");
                continue;
            }
            
            int[] alpha = new int[26];
            for(int i=0; i<s.length(); i++)
                alpha[s.charAt(i)-'a'] += 1;

            int min = Integer.MAX_VALUE, max = 0;
            for(int i=0; i<s.length(); i++){
                if (alpha[s.charAt(i)-'a'] >= k){
                    int count = 1;
                    for(int j=i+1; j<s.length(); j++){
                        if (s.charAt(i) == s.charAt(j))
                            count++;

                        if (count == k){
                            min = Math.min(min, j - i + 1);
                            max = Math.max(max, j - i + 1);
                            break;
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == 0)
                sb.append("-1\n");
            else
                sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }
}