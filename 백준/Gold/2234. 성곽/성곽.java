import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m, wallMap[][], roomMap[][];
    static int roomNum = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] wall = {1, 2, 4, 8};
    static HashMap<Integer, ArrayList<Integer>> adjRooms = new HashMap<>();
    static ArrayList<Integer> roomSize = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        wallMap = new int[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                wallMap[i][j] = Integer.parseInt(input[j]);
        }

        roomMap = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (roomMap[i][j]==0){
                    roomMap[i][j] = ++roomNum;
                    bfs(i, j);
                }
            }
        }

        int breakWall = 0;
        for(int i=1; i<=roomNum; i++){
            for(int adj : adjRooms.get(i))
                breakWall = Math.max(breakWall, roomSize.get(i-1) + roomSize.get(adj-1));
        }

        System.out.println(roomNum);
        System.out.println(roomSize.stream().mapToInt(i->i).max().getAsInt());
        System.out.println(breakWall);
    }

    public static void bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        ArrayList<Integer> roomList = new ArrayList<>();

        int size = 1;
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || n<=nx || ny<0 || m<=ny)
                    continue;

                if (roomMap[nx][ny] != 0 && roomMap[nx][ny] != roomNum){
                    roomList.add(roomMap[nx][ny]);
                    continue;
                }

                if ((wallMap[x][y] & wall[i])==0 && roomMap[nx][ny]==0){
                    q.add(new int[]{nx, ny});
                    roomMap[nx][ny] = roomNum;
                    size++;
                }
            }
        }
        adjRooms.put(roomNum, roomList);
        roomSize.add(size);
    }
}
