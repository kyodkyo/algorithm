import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static String s, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        System.out.println(dfs(t));
    }

    public static int dfs(String str) {
        if (str.length() == s.length()){
            if (str.equals(s))
                return 1;
            return 0;
        }

        int possible = 0;
        if (str.charAt(str.length()-1) == 'A')
            possible += dfs(str.substring(0, str.length()-1));

        if (str.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(str.substring(1));
            possible += dfs(sb.reverse().toString());
        }

        if (possible > 0)
            return 1;
        else
            return 0;
    }
}