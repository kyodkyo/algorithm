import java.util.HashMap;
import java.util.Set;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> s1Map = makeMap(str1);
        HashMap<String, Integer> s2Map = makeMap(str2);
        
        double inter = countInter(s1Map, s2Map);
        double union = countUnion(s1Map, s2Map);
        if (union == 0)
            return 65536;
        else
            return (int)((inter / union) * 65536);
    }
    
    public static HashMap<String, Integer> makeMap(String s){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<s.length()-1; i++){
            if (checkChar(s.charAt(i), s.charAt(i+1))) {
                String key = s.substring(i, i + 2);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }
    
    public static boolean checkChar(char c1, char c2){
        return c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z';
    }
    
    public static double countInter(HashMap<String, Integer> s1Map, HashMap<String, Integer> s2Map){
        double count = 0;

        for(String key : s1Map.keySet()){
            if (s2Map.containsKey(key))
                count += Math.min(s1Map.get(key), s2Map.get(key));
        }
        return count;
    }
    
    public static double countUnion(HashMap<String, Integer> s1Map, HashMap<String, Integer> s2Map){
        HashMap<String, Integer> unionMap = new HashMap<>(s2Map);

        for(String key : s1Map.keySet()){
            unionMap.put(key, Math.max(s1Map.getOrDefault(key, 0), s2Map.getOrDefault(key, 0)));

        }
        return unionMap.values().stream().mapToInt(i -> i).sum();
    }
}