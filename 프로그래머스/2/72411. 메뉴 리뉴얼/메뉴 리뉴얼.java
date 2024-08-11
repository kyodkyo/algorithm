import java.util.*;

class Solution {
    static int max;
    static HashMap<String, Integer> hashMap;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int count : course){
            max = 0;
            hashMap = new HashMap<>();
            
            for(String order : orders){
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                dfs(order, "", -1, count, 0);
            }
            
            for(String key : hashMap.keySet()){
                int value = hashMap.get(key);
                if (value >= 2 && value == max)
                    list.add(key);
            }
        }
        
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
    
    public static void dfs(String order, String key, int index, int end, int depth){
        if (depth == end){
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            max = Math.max(max, hashMap.get(key));
        }
        
        for(int i=index+1; i<order.length(); i++)
            dfs(order, key + order.charAt(i), i, end, depth+1);
    }
}