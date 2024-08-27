import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class position implements Comparable<position>{
        int x, y, count, gravity;
        public position(int x, int y, int count, int gravity) {
            this.x = x;
            this.y = y;
            this.count = count;	
            this.gravity = gravity;
        }

        @Override
        public int compareTo( position o) {
            return this.count-o.count;
        }
    }
    static int N,M, startX, startY;
    static int[] dx = {-1, 1};	
    static char[][] space;	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        space = new char[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                space[i][j] = str.charAt(j);

                if(space[i][j] == 'C'){
                    startX = j;
                    startY = i;
                }
            }
        }

        startY = moveOfGravity(startX,startY,0);
        if(startY==-1)	
            bw.write("0");
        else if(startY==Integer.MIN_VALUE)	
            bw.write("-1");
        else 		
            bw.write(bfs() + "");
        bw.flush();		
        bw.close();
        br.close();
    }
    
    static int bfs(){
        PriorityQueue<position> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[startY][startX][0] = true;
        pq.add(new position(startX,startY,0, 0));
        while(!pq.isEmpty()){
            position cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            int gravity = cur.gravity;

            for(int i=0;i<2;i++){
                int tempX = x + dx[i];
                if(tempX>=0 && tempX<M){
                    if(space[y][tempX]!='#'){	
                        int tempY = moveOfGravity(tempX,y,gravity);
                        if(tempY==-1)		
                            return count;
                        if(tempY!=Integer.MIN_VALUE && !visited[tempY][tempX][gravity]){
                            visited[tempY][tempX][gravity] = true;
                            pq.add(new position(tempX, tempY, count, gravity));
                        }
                    }
                }
            }
            int tempGravity = (gravity+1) % 2;	
            int tempY = moveOfGravity(x,y,tempGravity);	
            if(tempY==-1)	
                return count+1;
            if(tempY != Integer.MIN_VALUE && !visited[tempY][x][tempGravity]){
                visited[tempY][x][tempGravity] = true;
                pq.add(new position(x,tempY,count+1, tempGravity));
            }

        }
        return -1;		
    }
    
    static int moveOfGravity(int x, int y, int gravity){
        if(gravity == 0){
            for(int i=y;i<N;i++){
                if(space[i][x]=='#')	
                    return i-1;
                else if(space[i][x] == 'D')	
                    return -1;
            }
        }else{		
            for(int i=y;i>=0;i--){
                if(space[i][x] == '#')	
                    return i+1;
                else if(space[i][x] == 'D')	
                    return -1;
            }
        }
        return Integer.MIN_VALUE;	
    }
}