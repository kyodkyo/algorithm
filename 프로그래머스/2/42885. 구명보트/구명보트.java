import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int j = 0;
        int count = 0;
        for(int i=people.length-1; i>=j; i--){
            if (people[i] + people[j] <= limit){
                j++;
            }
            count++;
        }
        return count;
    }
}