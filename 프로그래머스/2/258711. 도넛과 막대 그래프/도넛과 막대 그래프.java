class Solution {
    public int[] solution(int[][] edges) {
        int maxNode = 1;
        for(int i=0; i<edges.length; i++)
            maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
        
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        for(int i=0; i<edges.length; i++){
            inDegree[edges[i][1]]++;
            outDegree[edges[i][0]]++;
        }
        
        int[] answer = new int[4];
        for(int n=1; n<=maxNode; n++){
            if (inDegree[n]==0 && outDegree[n]>=2)
                answer[0] = n;
            else if (inDegree[n]!=0 && outDegree[n]==0)
                answer[2]++;
            else if (inDegree[n]>=2 && outDegree[n]>=2)
                answer[3]++;
        }
        answer[1] = outDegree[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}