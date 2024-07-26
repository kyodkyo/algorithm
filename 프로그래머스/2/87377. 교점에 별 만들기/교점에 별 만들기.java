import java.util.Arrays;
import java.util.HashSet;

class Solution {
    static class Point{
        long x, y;

        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static long minX, minY, maxX, maxY;
    
    public String[] solution(int[][] line) {
        minX = Long.MAX_VALUE;
        minY = Long.MAX_VALUE;
        maxX = Long.MIN_VALUE;
        maxY = Long.MIN_VALUE;

        HashSet<Point> list = new HashSet<>();
        for(int i=0; i<line.length-1; i++){
            for(int j=i+1; j<line.length; j++) {
                long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long bunmo = A * D - B * C;
                if (bunmo == 0)
                    continue;

                long bunjaX = B * F - E * D;
                long bunjaY = E * C - A * F;
                if (bunjaX % bunmo != 0 || bunjaY % bunmo != 0)
                    continue;

                list.add(new Point(bunjaX/bunmo, bunjaY/bunmo));
                minX = Math.min(bunjaX / bunmo, minX);
                minY = Math.min(bunjaY / bunmo, minY);
                maxX = Math.max(bunjaX / bunmo, maxX);
                maxY = Math.max(bunjaY / bunmo, maxY);
            }
        }

        long height = maxY-minY+1;
        long width = maxX-minX+1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<width; i++)
            sb.append(".");

        String[] answer = new String[(int)height];
        Arrays.fill(answer, sb.toString());
        
        long nx, ny;
        for(Point p : list){
            nx = p.x - minX;
            ny = maxY - p.y;
            answer[(int)ny] = answer[(int)ny].substring(0, (int)nx) + "*" + answer[(int)ny].substring((int)nx+1);
        }
        return answer;
    }
}