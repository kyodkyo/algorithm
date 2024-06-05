import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++){
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            
            int min = Integer.MAX_VALUE;
            if (!(startX == ballX && startY >= ballY))
                min = Math.min(min, calcDistance(startX, startY, ballX, -ballY));
            if (!(startX == ballX && startY <= ballY))
                min = Math.min(min, calcDistance(startX, startY, ballX, 2*n - ballY));
            if (!(startY == ballY && startX >= ballX))
                min = Math.min(min, calcDistance(startX, startY, -ballX, ballY));
            if (!(startY == ballY && startX <= ballX))
                min = Math.min(min, calcDistance(startX, startY, 2*m - ballX, ballY));
            
            answer[i] = min;
        }
        return answer;
    }
    
    public static int calcDistance(int sx, int sy, int bx, int by){
        return (int)(Math.pow(sx-bx, 2) + Math.pow(sy-by, 2));
    }
}