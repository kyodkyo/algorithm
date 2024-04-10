import java.io.*;
import java.util.*;

public class Main{
    static class Puyo{
        int x, y;
        char color;

        public Puyo(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    static char[][] board = new char[12][6];
    static boolean check, visited[][];
    static Queue<Puyo> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<12; i++){
            String s = br.readLine();
            for(int j=0; j<6; j++)
                board[i][j] = s.charAt(j);
        }

        int count = 0;
        while(true){
            check = false;
            popPuyo();
            downPuyo();

            if (!check)
                break;
            count++;
        }
        System.out.println(count);
    }

    public static void popPuyo(){
        q = new LinkedList<>();
        visited = new boolean[12][6];

        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if (board[i][j] != '.' && !visited[i][j]){
                    q.add(new Puyo(i, j, board[i][j]));
                    visited[i][j] = true;

                    ArrayList<int[]> samePuyo = bfs(i, j);
                    if (samePuyo.size() >= 4){
                        for(int[] tmp : samePuyo)
                            board[tmp[0]][tmp[1]] = '.';
                        check = true;
                    }
                }
            }
        }
    }

    public static ArrayList<int[]> bfs(int x, int y){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        ArrayList<int[]> samePuyo = new ArrayList<>();
        samePuyo.add(new int[]{x, y});

        while(!q.isEmpty()){
            Puyo p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx<0 || 12<=nx || ny<0 || 6<=ny)
                    continue;
                if (!visited[nx][ny] && board[nx][ny]==p.color){
                    q.add(new Puyo(nx, ny, board[nx][ny]));
                    visited[nx][ny] = true;
                    samePuyo.add(new int[]{nx, ny});
                }
            }
        }
        return samePuyo;
    }

    public static void downPuyo(){
        for(int y=0; y<6; y++){
            Queue<Puyo> q = new LinkedList<>();
            for(int x=11; x>=0; x--){
                if (board[x][y] != '.'){
                    q.add(new Puyo(x, y, board[x][y]));
                    board[x][y] = '.';
                }
            }

            int pos = 11;
            while(!q.isEmpty()){
                Puyo p = q.poll();
                board[pos][y] = p.color;
                pos--;
            }
        }
    }
}