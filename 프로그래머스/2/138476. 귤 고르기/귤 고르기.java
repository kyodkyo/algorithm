import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<tangerine.length; i++)
            hashMap.put(tangerine[i], hashMap.getOrDefault(tangerine[i], 0) + 1);

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));

        int kind = 0;
        for(int key : list){
            kind++;
            k -= hashMap.get(key);

            if (k <= 0)
                break;
        }
       return kind;
    }
}