import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int total = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        
        int[] board = new int[101];
        for(int i=0; i<total; i++){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            board[start] = end;
        }
        bfs(board);
    }

    public static void bfs(int[] board){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int[] count = new int[101];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()){
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(count[100]);
                return;
            }

            for(int i=1; i<=6; i++){
                int pos = cur + i;

                if (pos > 100 || visited[pos])
                    continue;
                visited[pos] = true;

                if (board[pos] != 0){
                    if (!visited[board[pos]]) {
                        q.add(board[pos]);
                        visited[board[pos]] = true;
                        count[board[pos]] = count[cur] + 1;
                    }
                }
                else{
                    q.add(pos);
                    count[pos] = count[cur] + 1;
                }

            }
        }
    }
}
