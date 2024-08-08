class Solution {
    public int solution(String[] board) {
        int oCount=0, xCount=0;
        char[][] game = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                game[i][j] = board[i].charAt(j);
                if (game[i][j] == 'O')
                    oCount++;
                if (game[i][j] == 'X')
                    xCount++;
            }
        }

        if (xCount > oCount || Math.abs(oCount - xCount) >= 2)
            return 0;

        if (checkWin(game, 'O') && oCount == xCount)
            return 0;

        if (checkWin(game, 'X') && oCount == xCount+1)
            return 0;

        return 1;
    }
    
    public static boolean checkWin(char[][] game, char c){
        if (game[0][0]==c && game[1][1]==c && game[2][2]==c)
            return true;
        
        if (game[0][2]==c && game[1][1]==c && game[2][0]==c)
            return true;
        
        for(int i=0; i<3; i++){
                if (game[i][0]==c && game[i][1]==c && game[i][2]==c)
                    return true;
                if (game[0][i]==c && game[1][i]==c && game[2][i]==c)
                    return true;
        }
        return false;
    }
}