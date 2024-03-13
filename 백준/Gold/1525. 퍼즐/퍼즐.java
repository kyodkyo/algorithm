import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static String puzzle = "123456780";
    static Queue<String> q = new LinkedList<>();
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++)
            sb.append(br.readLine().replace(" ", ""));

        if (sb.toString().equals(puzzle))
            System.out.println("0");
        else
            System.out.println(bfs(sb.toString()));
    }

    public static int bfs(String s){
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};

        q.add(s);
        hashMap.put(s, 0);

        while (!q.isEmpty()){
            String cur = q.poll();
            int zero = cur.indexOf("0");
            int x = zero/3;
            int y = zero%3;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0<=nx && nx<3 && 0<=ny && ny<3){
                    int n = nx*3 + ny;

                    StringBuilder sb = new StringBuilder(cur);
                    char c = sb.charAt(n);
                    sb.setCharAt(n, '0');
                    sb.setCharAt(zero, c);

                    if (sb.toString().equals(puzzle))
                        return hashMap.get(cur) + 1;

                    if (!hashMap.containsKey(sb.toString())){
                        q.add(sb.toString());
                        hashMap.put(sb.toString(), hashMap.get(cur) + 1);
                    }
                }
            }
        }

        return -1;
    }
}