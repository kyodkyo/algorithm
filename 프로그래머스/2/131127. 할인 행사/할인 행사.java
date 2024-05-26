import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++)
            wantMap.put(want[i], number[i]);

        for(int i=0; i<discount.length-9; i++){
            HashMap<String, Integer> disMap = new HashMap<>();
            for(int j=i; j<i+10; j++)
                disMap.put(discount[j], disMap.getOrDefault(discount[j], 0) + 1);

            if (isPossible(wantMap, disMap))
                result++;
        }
        
        return result;
    }
    
    public static boolean isPossible(HashMap<String, Integer> wantMap, HashMap<String, Integer> disMap){
        for(String s : wantMap.keySet()){
            if (disMap.get(s) != wantMap.get(s))
                return false;
        }
        return true;
    }
}