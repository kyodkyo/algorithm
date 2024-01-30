import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;

        int answer = 0;
        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
    
    public static int find(int land){
        if (parent[land] == land)
            return land;
        return find(parent[land]);
    }
    
    public static void union(int land1, int land2){
        land1 = find(land1);
        land2 = find(land2);
        
        if (land1 != land2)
            parent[land2] = land1;
    }
}