import java.util.*;

class Solution {
    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p){
            if (this.x == p.x)
                return Integer.compare(this.y, p.y);
            return Integer.compare(this.x, p.x);
        }
    }

    static List<List<Point>> list_t = new ArrayList<>();
    static List<List<Point>> list_g = new ArrayList<>();
    static int len;


    public int solution(int[][] game_board, int[][] table) {
        len = game_board.length;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j] == 1)
                    game_board[i][j] = 0;
                else
                    game_board[i][j] = 1;
            }
        }

        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(table[i][j]==1 && !visited_t[i][j])
                    bfs(i, j, table, visited_t, list_t);

                if(game_board[i][j]==1 && !visited_g[i][j])
                    bfs(i, j, game_board, visited_g, list_g);
            }
        }

        return compareBlock(list_t, list_g);
    }

    public int compareBlock(List<List<Point>> table, List<List<Point>> board){
        int answer = 0;
        int table_size = table.size();
        int board_size = board.size();

        boolean[] visited = new boolean[board_size];

        for(int i=0; i<table_size; i++){
            for(int j=0; j<board_size; j++){
                if(checkMap(j, visited, table.get(i), board.get(j))){
                    visited[j] = true;
                    answer += board.get(j).size();
                    break;
                }

            }
        }

        return answer;
    }
    
    public boolean checkMap(int j, boolean[] visited, List<Point> table, List<Point> board){
        if (visited[j])
            return false;
        if (table.size() != board.size())
            return false;
        if (!isRotate(table, board))
            return false; 
        return true;
        
    }

    public boolean isRotate(List<Point> table, List<Point> board){
        Collections.sort(board);

        for(int i=0; i<4; i++){
            Collections.sort(table);

            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;

            for(int j=0; j<table.size(); j++){
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }

            boolean check = true;
            for(int j=0; j<board.size(); j++){
                if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                    check = false;
                    break;
                }
            }

            if(check){
                return true;
            }
            else{
                for(int j=0; j<table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }

        return false;
    }

    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> lists){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));

        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0<=nx && nx<len && 0<= ny && ny<len 
                        && !visited[nx][ny] && board[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    list.add(new Point(nx-x, ny-y));
                }
            }
        }

        lists.add(list);
    }
}