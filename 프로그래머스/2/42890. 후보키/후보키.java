import java.util.*;

class Solution {
    public static List<String> list = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int n = relation[0].length;
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++)
            arr[i] = i;
        
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n];
            comb(arr, n, i, 0, visited);
        }
        
        List<String> unique = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if (isUnique(list.get(i), relation))
                unique.add(list.get(i));
        }
        
        List<String> minimum = new ArrayList<>(unique);
        for(int i=0; i<unique.size(); i++){
            String start = unique.get(i);
            
            for(int j=0; j<unique.size(); j++){
                String target = unique.get(j);
                
                if(start.equals(target))
                    continue;
                
                int count = 0;
                for(char c : start.toCharArray()){
                    if (target.contains(String.valueOf(c)))
                        count++;
                }
                
                if(count == start.length())
                    minimum.remove(target);
            }
        }
        return minimum.size();
    }
    
    public static void comb(int[] arr, int n, int combCount, int depth, boolean[] visited){
        if (depth == combCount){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<visited.length; j++){
                if (visited[j])
                    sb.append(arr[j]);
            }
            
            if (sb.length()>0 && !list.contains(sb.toString()))
                list.add(sb.toString());
            return;
        }
        
        visited[depth] = true;
        comb(arr, n, combCount, depth+1, visited);
        visited[depth] = false;
        comb(arr, n, combCount, depth+1, visited);
    }
    
    public static boolean isUnique(String columns, String[][] relation){
        Set<String> set = new HashSet<>();
        for(String[] record : relation){
            String s = "";
            for(char c : columns.toCharArray())
                s += record[Integer.parseInt(String.valueOf(c))];
            set.add(s);
        }
        
        if (set.size() == relation.length)
            return true;
        return false;
    }
}