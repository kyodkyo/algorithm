class Solution {
    public static int[] board;
    public static int answer;

    public static int solution(int n) {
        board = new int[n];
        backTracking(0, n);
        return answer;
    }

    public static void backTracking(int depth, int n){
        if (depth == n){
            answer++;
            return;
        }

        for(int i=0; i<n; i++){
            board[depth] = i;
            if (validCheck(depth))
                backTracking(depth+1, n);
        }
    }

    public static boolean validCheck(int target){
        for(int i=0; i<target; i++){
            if (board[i] == board[target])
                return false;
            if (Math.abs(target-i) == Math.abs(board[target]-board[i]))
                return false;
        }
        return true;
    }
}