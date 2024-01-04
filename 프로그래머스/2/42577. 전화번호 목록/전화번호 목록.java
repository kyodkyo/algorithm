import java.util.Arrays;

class Solution {
    public boolean solution(String[] book) {
        Arrays.sort(book);
        
        for(int i=0; i<book.length-1; i++){
            if (book[i+1].startsWith(book[i]))
                return false;
        }
        return true;
    }
}