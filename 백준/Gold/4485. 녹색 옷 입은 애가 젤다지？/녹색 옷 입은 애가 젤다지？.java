import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
    static int n;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n==0)
                break;

            board = new int[n][n];
            for(int i=0; i<n; i++){
                String[] line = br.readLine().split(" ");
                for(int j=0; j<n; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }

            sb.append("Problem " + count + ": " + checkRupee() + "\n");
            count++;
        }
        System.out.println(sb);
    }

    public static int checkRupee(){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        q.add(new int[]{0, 0, board[0][0]});

        int[][] rupees = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(rupees[i], Integer.MAX_VALUE);
        rupees[0][0] = board[0][0];

        while(!q.isEmpty()){
            int[] prev = q.poll();
            int x = prev[0];
            int y = prev[1];
            int r = prev[2];

            if (x==n-1 && y==n-1)
                return r;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0<=nx && nx<n && 0<=ny && ny<n){
                    if (r + board[nx][ny] < rupees[nx][ny]){
                        rupees[nx][ny] = r + board[nx][ny];
                        q.add(new int[]{nx, ny, r + board[nx][ny]});
                    }
                }
            }
        }
        return -1;
    }
}