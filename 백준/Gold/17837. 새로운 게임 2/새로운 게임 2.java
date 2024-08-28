import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{

    public static void main(String[]args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[]tmp = reader.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int[][]board = new int[N+1][N+1];
        List<Integer>[][]list = new List[N+1][N+1];

        for(int i = 1; i<=N; i++) {
            String[]mapString = reader.readLine().split(" ");

            for(int j = 1; j<=N; j++) {
                list[i][j]= new ArrayList<>();
                board[i][j]= Integer.parseInt(mapString[j-1]);
            }
        }

        int[][]horse = new int[K+1][3];
        for(int i = 1; i<=K; i++) {
            String[]t = reader.readLine().split(" ");
            int r = Integer.parseInt(t[0]);
            int c = Integer.parseInt(t[1]);

            horse[i][0]= r;
            horse[i][1]= c;
            horse[i][2]= Integer.parseInt(t[2]);

            list[r][c].add(i);
        }

        int[] dr = {0, 0, 0, -1, 1};
        int[] dc = {0, 1, -1, 0, 0};

        int count = 0;
        while(count < 1000) {
            count++;

            for(int i = 1; i<=K; i++) {
                int r = horse[i][0];
                int c = horse[i][1];
                int dir = horse[i][2];

                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(nr <= N && nr >= 1 && nc >= 1 && nc <= N) {
                    if(board[nr][nc]== 0) {
                        int index = list[r][c].indexOf(i);

                        list[nr][nc].addAll(list[r][c].subList(index, list[r][c].size()));
                        list[r][c] = list[r][c].subList(0, index);

                        horse[i][0]= nr;
                        horse[i][1]= nc;

                        for(Integer h : list[nr][nc]) {
                            horse[h][0]= nr;
                            horse[h][1]= nc;
                        }
                    }
                    else if(board[nr][nc]== 1) {
                        int index = list[r][c].indexOf(i);
                        List<Integer> subList = list[r][c].subList(index, list[r][c].size());
                        Collections.reverse(subList);

                        list[nr][nc].addAll(subList);
                        list[r][c] = list[r][c].subList(0, index);

                        for(Integer h : list[nr][nc]) {
                            horse[h][0]= nr;
                            horse[h][1]= nc;
                        }
                    } 
                    else if(board[nr][nc] == 2) {
                        int new_dir = dir % 2 == 0 ? dir - 1 : dir + 1;
                        horse[i][2] = new_dir;

                        if(r + dr[new_dir]< 1 || r + dr[new_dir]>= N+1 || c + dc[new_dir]< 1 || c + dc[new_dir]>= N+1) 
                            continue;

                        if(board[r + dr[new_dir]][c + dc[new_dir]]!= 2) 
                            i--;
                    }

                    if(list[nr][nc].size()> 3) {
                        System.out.println(count);
                        return;
                    }
                }
                else {
                    int new_dir = dir % 2 == 0 ? dir - 1 : dir + 1;
                    horse[i][2]= new_dir;

                    if(board[r + dr[new_dir]][c + dc[new_dir]]!= 2)
                        i--;
                }
            }
        }
        System.out.println(-1);
    }
}
